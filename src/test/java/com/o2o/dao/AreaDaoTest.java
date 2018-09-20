package com.o2o.dao;

import com.o2o.BaseTest;
import com.o2o.entity.Area;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tanke on 2018/9/19.
 */
public class AreaDaoTest extends BaseTest {
    @Resource
    private AreaDao areaDao;
    @Test
    public void testQueryArea(){
        List<Area> areaList=areaDao.queryArea();
        assertEquals(2,areaList.size());
    }


}
