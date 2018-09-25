package com.o2o.dao;

import com.o2o.BaseTest;
import com.o2o.entity.ShopCategory;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tanke on 2018/9/22.
 */
public class ShopCategoryDaoTest extends BaseTest {
    @Resource
    private ShopCategoryDao shopCategoryDao;
    @Test
    public void  queryShopCategoryTest(){
        ShopCategory shopCategory=new ShopCategory();
        ShopCategory shopCategory1=new ShopCategory();
        shopCategory.setShopCategoryId(1);
        shopCategory1.setParent(shopCategory);
        List<ShopCategory> shopCategoryList=shopCategoryDao.queryShopCategory(shopCategory1);
        Assert.assertEquals(1,shopCategoryList.size());
        System.out.println(shopCategoryList.get(0).getShopCategoryName());
    }
}
