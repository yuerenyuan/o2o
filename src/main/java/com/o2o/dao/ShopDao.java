package com.o2o.dao;

import com.o2o.entity.Shop;

/**
 * Created by tanke on 2018/9/20.
 */
public interface ShopDao {
    int insertShop(Shop shop);

    int updateShop(Shop shop);
}
