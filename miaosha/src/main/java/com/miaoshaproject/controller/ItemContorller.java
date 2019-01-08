package com.miaoshaproject.controller;

import com.miaoshaproject.controller.viewobject.ItemVO;
import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.response.CommonReturnType;
import com.miaoshaproject.service.ItemService;
import com.miaoshaproject.service.model.ItemModel;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangsk
 * @Date: 2019/1/6 11:20
 * To change this template use File | Settings | File Templates.
 * @Description:
 */

@RestController
@RequestMapping("/item")
@CrossOrigin(origins = {"*"}, allowCredentials = "true", allowedHeaders = {"*"})
public class ItemContorller extends BaseController{

    @Autowired
    private ItemService itemService;


    /**
     * 创建商品
     * @param title 商品名
     * @param price 商品价格
     * @param stock 商品库存
     * @param description 商品描述
     * @param imgUrl 商品图片地址
     * @return
     */
    @RequestMapping(value = "/create", method = { RequestMethod.POST })
    public CommonReturnType createItem(@RequestParam(name = "title") String title
                                       ,@RequestParam(name = "price") BigDecimal price
                                       ,@RequestParam(name = "stock") Integer stock
                                       ,@RequestParam(name = "description") String description
                                       ,@RequestParam(name = "imgUrl") String imgUrl) throws BusinessException {

        ItemModel itemModel = new ItemModel();
        itemModel.setTitle(title);
        itemModel.setPrice(price);
        itemModel.setStock(stock);
        itemModel.setDescription(description);
        itemModel.setImgUrl(imgUrl);
        ItemModel item = itemService.createItem(itemModel);

        ItemVO itemVO = this.convertVOFromModel(itemModel);
        return CommonReturnType.create(itemVO);
    }

    /**
     * 获取商品详细
     * @return
     */
    @RequestMapping(value = "/list", method = { RequestMethod.GET })
    public CommonReturnType findItems(){
        List<ItemModel> itemModels = itemService.itemList();
        List<ItemVO> itemVOS = itemModels.stream().map(itemModel -> {
            ItemVO itemVO = convertVOFromModel(itemModel);
            return itemVO;
        }).collect(Collectors.toList());
        return CommonReturnType.create(itemVOS);
    }

    @RequestMapping(value = "/get", method = { RequestMethod.GET })
    public CommonReturnType getItem(@RequestParam(name="id")Integer id){
        ItemModel itemModel = itemService.getItemById(id);
        if (itemModel == null){
            return null;
        }
        ItemVO itemVO = convertVOFromModel(itemModel);
        return CommonReturnType.create(itemVO);
    }

    private ItemVO convertVOFromModel(ItemModel itemModel){
        if(itemModel == null){
            return null;
        }
        ItemVO itemVO = new ItemVO();
        BeanUtils.copyProperties(itemModel, itemVO);
        if(itemModel.getPromoModel() != null){
            itemVO.setPromoStatus(itemModel.getPromoModel().getStatus());
            itemVO.setPromoId(itemModel.getPromoModel().getId());
            itemVO.setStartDate(itemModel.getPromoModel().getStartDate().toString(DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")));
            itemVO.setPromoPrice(itemModel.getPromoModel().getPromoItemPoice());
        }else{
            itemVO.setPromoStatus(0);
        }
        return itemVO;
    }
}