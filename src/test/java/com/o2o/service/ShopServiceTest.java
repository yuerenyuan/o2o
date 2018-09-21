package com.o2o.service;

import com.o2o.BaseTest;
import com.o2o.dto.ShopExecution;
import com.o2o.entity.Area;
import com.o2o.entity.PersonInfo;
import com.o2o.entity.Shop;
import com.o2o.entity.ShopCategory;
import com.o2o.enums.ShopStateEnum;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.File;
import java.util.Date;

/**
 * Created by tanke on 2018/9/21.
 */
public class ShopServiceTest extends BaseTest{
    @Resource
    private ShopService shopService;
    @Test
    public void testAddShop(){
        Shop shop=new Shop();
        PersonInfo personInfo=new PersonInfo();
        ShopCategory shopCategory=new ShopCategory();
        Area area=new Area();
        personInfo.setUserID(1);
        shopCategory.setShopCategoryId(1);
        area.setAreaID(1);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setOwner(personInfo);
        shop.setShopName("测试店铺service");
        shop.setShopDesc("test");
        shop.setShopAddr("test");
        shop.setPhone("test");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        shop.setAdvice("审核中");
        File shopImg=new File("/JAVA_top/Github/image/fendou.jpg");
        ShopExecution se=shopService.addShop(shop,shopImg);
        Assert.assertEquals(ShopStateEnum.CHECK.getState(),se.getState());
    }
}
