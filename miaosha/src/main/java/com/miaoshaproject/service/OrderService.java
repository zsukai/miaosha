package com.miaoshaproject.service;

import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.service.model.OrderModel;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangsk
 * @Date: 2019/1/7 14:52
 * To change this template use File | Settings | File Templates.
 * @Description:
 */
public interface OrderService {

    OrderModel createOrder(Integer userId, Integer itemId, Integer amount) throws BusinessException;
}