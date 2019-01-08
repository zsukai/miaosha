package com.miaoshaproject.controller.viewobject;

import org.joda.time.DateTime;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangsk
 * @Date: 2019/1/6 11:20
 * To change this template use File | Settings | File Templates.
 * @Description:
 */
public class ItemVO {

    /**
     * 商品id
     */
    private Integer id;

    /**
     * 商品title
     */
    private String title;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 库存
     */
    private Integer stock;

    /**
     *描述
     */

    private String description;

    /**
     *销量
     */
    private Integer sales;

    /**
     * 图片路径
     */
    private String imgUrl;

    /**
     *记录商品是否在秒杀活动中
     * 0：没有活动，1：活动待开始，2：活动正在进行
     */
    private Integer promoStatus;

    /**
     * 活动价格
     */
    private BigDecimal promoPrice;

    /**
     * 秒杀活动id
     */
    private Integer promoId;

    /**
     * 秒杀活动开始时间
     */
    private String startDate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getPromoStatus() {
        return promoStatus;
    }

    public void setPromoStatus(Integer promoStatus) {
        this.promoStatus = promoStatus;
    }

    public BigDecimal getPromoPrice() {
        return promoPrice;
    }

    public void setPromoPrice(BigDecimal promoPrice) {
        this.promoPrice = promoPrice;
    }

    public Integer getPromoId() {
        return promoId;
    }

    public void setPromoId(Integer promoId) {
        this.promoId = promoId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}