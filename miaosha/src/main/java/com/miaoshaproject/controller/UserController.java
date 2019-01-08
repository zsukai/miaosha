package com.miaoshaproject.controller;

import com.alibaba.fastjson.JSON;
import com.miaoshaproject.controller.viewobject.UserVO;
import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.error.EmBusinessError;
import com.miaoshaproject.response.CommonReturnType;
import com.miaoshaproject.service.UserService;
import com.miaoshaproject.service.model.UserModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/user")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*") // 处理ajax跨域请求
public class UserController extends BaseController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private HttpServletRequest httpServletRequest;
    
    // 用户登录接口
    @RequestMapping(value = "/login", method = { RequestMethod.POST }, consumes = { CONTENT_TYPE_FORMED })
    public CommonReturnType login(@RequestParam(name = "telphone") String telphone,
                                     @RequestParam(name = "password") String password)
            throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        
        if (StringUtils.isEmpty(telphone) || StringUtils.isEmpty(password)) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        UserModel userModel = userService.validateLogin(telphone, encodeByMd5(password));
        this.httpServletRequest.getSession().setAttribute("IS_LOGIN", true);
        this.httpServletRequest.getSession().setAttribute("LOGIN_USER", userModel);
        UserVO userVO = convertFromModel(userModel);
        return CommonReturnType.create(userVO);
    }
    
    // 用户注册接口
    @RequestMapping(value = "/register", method = { RequestMethod.POST }, consumes = { CONTENT_TYPE_FORMED })
    public CommonReturnType register(@RequestParam(name = "telphone") String telphone,
                                     @RequestParam(name = "otpCode") String otpCode,
                                     @RequestParam(name = "name") String name,
                                     @RequestParam(name = "gender") Integer gender,
                                     @RequestParam(name = "age") Integer age,
                                     @RequestParam(name = "password") String password)
            throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        
        String inSessionOtpCOde = (String) this.httpServletRequest.getSession().getAttribute(telphone);
        if (!StringUtils.equals(otpCode, inSessionOtpCOde)) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "短信验证码不符");
            
        }
        UserModel userModel = new UserModel();
        userModel.setName(name);
        userModel.setGender(Byte.decode(String.valueOf(gender.intValue())));
        userModel.setAge(age);
        userModel.setTelphone(telphone);
        userModel.setRegisterMode("byphone");
        userModel.setEncrptPassword(encodeByMd5(password));
        userService.register(userModel);
        return CommonReturnType.create(null);
    }
    
    // 用户获取otp短信接口
    @RequestMapping(value = "/getotp", method = { RequestMethod.POST }, consumes = { CONTENT_TYPE_FORMED })
    public CommonReturnType getOtp(@RequestParam(name = "telphone") String telphone) {
        
        // 需要按照一定的规则生成OTP验证码
        Random random = new Random();
        int randomInt = random.nextInt(999999);
        randomInt += 100000;
        String otpCode = String.valueOf(randomInt);
        
        // 将OTP验证码同对应用户的手机号关联, 使用httpSession的方式将手机号和otpCode绑定
        httpServletRequest.getSession().setAttribute(telphone, otpCode);
        
        // 将OTP验证码通过短信通道发送给用户，省了
        System.out.println("telphone = " + telphone + " & otpCode = " + otpCode);
        return CommonReturnType.create(null);
    }
    
    @RequestMapping("/get")
    public CommonReturnType getUserById(HttpServletRequest request) throws BusinessException {
        
        String id = request.getParameter("id");
        UserModel userModel = userService.getUserById(Integer.parseInt(id));
        
        if (userModel == null) {
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
        }
        
        UserVO userVO = convertFromModel(userModel);
        return CommonReturnType.create(userVO);
    }
    
    public static String encodeByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        
        // 确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        
        String newStr = Base64.getEncoder().encodeToString(md5.digest(str.getBytes("UTF-8")));
        
        return newStr;
    }
    
    private UserVO convertFromModel(UserModel userModel) {
        
        if (userModel == null) {
            
            return null;
        }
        
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userModel, userVO);
        
        return userVO;
    }
    
}
