package com.miaoshaproject.controller;

import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.error.EmBusinessError;
import com.miaoshaproject.response.CommonReturnType;
import com.miaoshaproject.service.OrderService;
import com.miaoshaproject.service.model.OrderModel;
import com.miaoshaproject.service.model.UserModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangsk
 * @Date: 2019/1/7 17:25
 * To change this template use File | Settings | File Templates.
 * @Description:
 */
@RestController
@RequestMapping("/order")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*") // 处理ajax跨域请求
public class OrderController extends BaseController{
    @Autowired
    private OrderService orderService;

    @Autowired
    private HttpServletRequest httpServletRequest;

    /**
     * 下单
     * @return
     */
    @RequestMapping(value = "/create", method = { RequestMethod.POST }, consumes = { CONTENT_TYPE_FORMED })
    public CommonReturnType createOrder(@RequestParam("itemId")Integer itemId, @RequestParam("amount")Integer amount) throws BusinessException {

        //获取用户登录信息
        Boolean isLogin = (Boolean)httpServletRequest.getSession().getAttribute("IS_LOGIN");

        if (isLogin == null || !isLogin.booleanValue()){
            throw  new BusinessException(EmBusinessError.USER_NOT_LOGIN);
        }
        UserModel userModel = (UserModel)httpServletRequest.getSession().getAttribute("LOGIN_USER");

        OrderModel orderModel = orderService.createOrder(userModel.getId(), itemId, amount);

        return CommonReturnType.create(null);

    }
}