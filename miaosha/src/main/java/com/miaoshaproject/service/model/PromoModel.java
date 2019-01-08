package com.miaoshaproject.service.model;

import org.joda.time.DateTime;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangsk
 * @Date: 2019/1/8 14:16
 * To change this template use File | Settings | File Templates.
 * @Description: 秒杀
 */
public class PromoModel {

    private Integer id;

    private String promoName;

    private DateTime startDate;

    private DateTime endDate;

    /**
     * 秒杀活动状态 1： 未开始 2：进行中， 3：已结束
     */
    private Integer status;

    /**
     * 秒杀活动适应的商品
     */
    private Integer itemId;

    /**
     * 秒杀活动的商品价格
     */
    private BigDecimal promoItemPoice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPromoName() {
        return promoName;
    }

    public void setPromoName(String promoName) {
        this.promoName = promoName;
    }

    public DateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(DateTime startDate) {
        this.startDate = startDate;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public BigDecimal getPromoItemPoice() {
        return promoItemPoice;
    }

    public void setPromoItemPoice(BigDecimal promoItemPoice) {
        this.promoItemPoice = promoItemPoice;
    }

    public DateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(DateTime endDate) {
        this.endDate = endDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}