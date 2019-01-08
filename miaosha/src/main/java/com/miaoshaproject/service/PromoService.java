package com.miaoshaproject.service;

import com.miaoshaproject.service.model.PromoModel;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangsk
 * @Date: 2019/1/8 14:35
 * To change this template use File | Settings | File Templates.
 * @Description:
 */
public interface PromoService {

    /**
     * 获取即将进行和正在进行的秒杀活动
     * @param itemId
     * @return
     */
    PromoModel getPromoByItemId(Integer itemId);


}