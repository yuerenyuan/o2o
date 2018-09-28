package com.o2o.dao;

import com.o2o.BaseTest;
import com.o2o.entity.Area;
import com.o2o.entity.PersonInfo;
import com.o2o.entity.Shop;
import com.o2o.entity.ShopCategory;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by tanke on 2018/9/20.
 */
public class ShopDaoTest extends BaseTest{
    @Resource
    private ShopDao shopDao;
    @Test
    @Ignore
    public void insertShop(){
        Shop shop=new Shop();
        PersonInfo personInfo=new PersonInfo();
        ShopCategory shopCategory=new ShopCategory();
        Area area=new Area();
        personInfo.setUserId(1);
        shopCategory.setShopCategoryId(1);
        area.setAreaId(1);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setOwner(personInfo);
        shop.setShopName("测试店铺");
        shop.setShopDesc("test");
        shop.setShopAddr("test");
        shop.setPhone("test");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(1);
        shop.setAdvice("审核中");
        int num=shopDao.insertShop(shop);
        Assert.assertEquals(1,num);
    }
    @Test
    @Ignore
    public void  usdateShop(){
        Shop shop=new Shop();
        shop.setShopId(1);
        shop.setShopName("跟新店铺66");
        shop.setLastEditTime(new Date());
        shop.setPriority(6);
        int num=shopDao.updateShop(shop);
        Assert.assertEquals(1,num);
    }
    @Test
    public void queryShopById(){
       Shop shop =shopDao.queryShopById(14);
        System.out.println(shop.getShopName()+shop.getShopId());

    }
}
