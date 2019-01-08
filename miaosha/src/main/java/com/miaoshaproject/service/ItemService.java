package com.miaoshaproject.service;

import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.service.model.ItemModel;

import java.util.List;

/**
* @Description:    java类作用描述
* @Author:         zhangsk
* @Date:     2019/1/5 16:58
* @UpdateDate:     2019/1/5 16:58
* @Version:        1.0
*/
public interface ItemService {

    /**
     * 创建商品
     * @param itemModel
     * @return
     */
    ItemModel createItem(ItemModel itemModel) throws BusinessException;

    /**
     * 商品列表浏览
     * @return
     */
    List<ItemModel> itemList();

    /**
     * 商品详细信息
     * @param id
     * @return
     */
    ItemModel getItemById(Integer id);

    /**
     *更新商品库存
     * @param itemId
     * @param amount
     * @return
     */
    boolean decreaseStock(Integer itemId, Integer amount);

    /**
     * 更新商品销量
     * @param itemId
     * @param amount
     */
    void increaseSales(Integer itemId, Integer amount);
}
