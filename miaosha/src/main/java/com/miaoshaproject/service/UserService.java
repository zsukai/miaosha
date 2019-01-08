package com.miaoshaproject.service;

import com.miaoshaproject.dataobject.UserDO;
import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.service.model.UserModel;
import org.apache.catalina.User;

public interface UserService {

    /**
     * 根据用户id获取用户信息
     * @param id
     * @return
     */
    UserModel getUserById(Integer id);

    /**
     * 用户注册
     * @param userModel
     */
    void register(UserModel userModel) throws BusinessException;

    UserModel validateLogin(String telphone, String encrptPassword) throws BusinessException;
}
