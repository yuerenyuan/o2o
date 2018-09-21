package com.o2o.service;

import com.o2o.dto.ShopExecution;
import com.o2o.entity.Shop;

import java.io.File;

/**
 * Created by tanke on 2018/9/21.
 */
public interface ShopService {
    ShopExecution addShop(Shop shop, File shopImg);
}
