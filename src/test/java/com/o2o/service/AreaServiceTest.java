package com.o2o.service;

import com.o2o.BaseTest;
import com.o2o.entity.Area;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tanke on 2018/9/20.
 */
public class AreaServiceTest extends BaseTest{
    @Resource
    private AreaService areaService;
    @Test
    public  void  testQueryArea(){
        List<Area> areaList=areaService.getAreaList();
        Assert.assertEquals("坦克",areaList.get(0).getAreaName());
    }
}