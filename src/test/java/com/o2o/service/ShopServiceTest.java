package com.o2o.service;

import com.o2o.BaseTest;
import com.o2o.dto.ShopExecution;
import com.o2o.entity.Area;
import com.o2o.entity.PersonInfo;
import com.o2o.entity.Shop;
import com.o2o.entity.ShopCategory;
import com.o2o.enums.ShopStateEnum;
import com.o2o.exceptions.ShopOperationException;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

/**
 * Created by tanke on 2018/9/21.
 */
public class ShopServiceTest extends BaseTest{
    @Resource
    private ShopService shopService;
    @Test
    @Ignore
    public void testQueryShopById(){
        Shop shop=new Shop();
        shop.setShopId(14);
        Shop shop1=shopService.queryShopById(shop.getShopId());
        System.out.println(shop1.getShopName());
    }
    @Test
    public void testUpdateShop()throws ShopOperationException,FileNotFoundException{
        Shop shop=new Shop();
        shop.setShopId(2);
        shop.setShopName("修改后店铺名987");
        File file=new File("D:\\JAVA_top\\Github\\image\\学校图书馆.jpg");
        InputStream is=new FileInputStream(file);
        ShopExecution shopExecution=shopService.updateShop(shop,is,"学校图书馆.jpg");
        System.out.println("图片新地址："+shopExecution.getShop().getShopImg());
        System.out.println("店铺新新名称："+shopExecution.getShop().getShopName());
    }
   @Test
    @Ignore
    public void testAddShop()throws FileNotFoundException,ShopOperationException{
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
        shop.setShopName("测试店铺666");
        shop.setShopDesc("test");
        shop.setShopAddr("test");
        shop.setPhone("test");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        shop.setAdvice("审核中");
        File shopImg=new File("/JAVA_top/Github/image/fendou.jpg");
        InputStream is=new FileInputStream(shopImg);
        ShopExecution se=shopService.addShop(shop,is,shopImg.getName());
        Assert.assertEquals(ShopStateEnum.CHECK.getState(),se.getState());
    }
}
