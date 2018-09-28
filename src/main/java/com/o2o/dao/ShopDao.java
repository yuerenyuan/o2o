package com.o2o.dao;

import com.o2o.entity.Shop;

/**
 * Created by tanke on 2018/9/20.
 */
public interface ShopDao {
    /**
     * 添加商铺
     * @param shop
     * @return
     */
    int insertShop(Shop shop);

    /**
     * 更新店铺
     * @param shop
     * @return
     */
    int updateShop(Shop shop);

    /**
     * 查询店铺
     * @return
     */
    Shop queryShopById(Integer shopId);
}
