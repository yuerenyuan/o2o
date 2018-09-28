package com.o2o.service;

import com.o2o.dto.ShopExecution;
import com.o2o.entity.Shop;
import com.o2o.exceptions.ShopOperationException;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.InputStream;

/**
 * Created by tanke on 2018/9/21.
 */
public interface ShopService {
    /**
     * 增加店铺
     * @param shop
     * @param shopImgInputStream
     * @param fileName
     * @return
     */
    ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperationException;

    /**
     * 跟新店铺
     * @param shop
     * @param shopImgInputStream
     * @param fileName
     * @return
     */
    ShopExecution updateShop(Shop shop, InputStream shopImgInputStream, String fileName)throws ShopOperationException;

    /**
     * 查询店铺
     * @param shopId
     * @return
     */
    Shop queryShopById(Integer shopId);
}
