package com.o2o.service.impl;

import com.o2o.dao.ShopDao;
import com.o2o.dto.ShopExecution;
import com.o2o.entity.Shop;
import com.o2o.enums.ShopStateEnum;
import com.o2o.exceptions.ShopOperationException;
import com.o2o.service.ShopService;
import com.o2o.until.ImageUntil;
import com.o2o.until.PathUntil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.Date;

/**
 * Created by tanke on 2018/9/21.
 */
@Service
public class ShopServiceImpl implements ShopService{
    @Resource
    private ShopDao shopDao;

    @Override
    @Transactional
    public ShopExecution addShop(Shop shop, File shopImg) {
        if(shopImg==null){
           return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }
        try{
                //给店铺信息赋予初始值
                shop.setEnableStatus(0);
                shop.setCreateTime(new Date());
                shop.setLastEditTime(new Date());
                //添加店铺信息
                int effectedNum=shopDao.insertShop(shop);
                if(effectedNum<=0){
                    throw  new ShopOperationException("店铺创建失败");
                }else{
                    if(shopImg!=null){
                        //保存图片
                        try{
                            addShopImg(shop,shopImg);
                        }catch (Exception e){
                            throw new ShopOperationException("addShopImgError:"+e.getMessage());
                        }
                        //更新店铺地址图片
                        effectedNum=shopDao.updateShop(shop);
                        if(effectedNum<=0){
                            throw new ShopOperationException("更新图片地址失败");
                        }
                    }
                }
        }catch (Exception e){
            throw new ShopOperationException("shopAddError:"+e.getMessage());
        }
        return new ShopExecution(ShopStateEnum.CHECK,shop);
    }



    private void addShopImg(Shop shop, File shopImg) {
            //获取shop图片目录的相对值路径
            String dest= PathUntil.getShopImagePath(shop.getShopId());
            String shopImgAddr= ImageUntil.generateThumbnails(shopImg,dest);
            shop.setShopImg(shopImgAddr);
    }

}
