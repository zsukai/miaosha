package com.miaoshaproject.service.model;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangsk
 * @Date: 2019/1/7 14:36
 * To change this template use File | Settings | File Templates.
 * @Description: 用户下单交易模型
 */
public class OrderModel {

    /**
     * 订单编号
     */
    private String id;

    /**
     * 购买者id
     */
    private Integer userId;

    /**
     * 购买时商品单价
     */
    private BigDecimal itemPrice;

    /**
     * 购买的商品id
     */
    private Integer itemId;

    /**
     * 购买数量
     */
    private Integer amount;

    /**
     * 购买金额
     */
    private BigDecimal orderPrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }
}