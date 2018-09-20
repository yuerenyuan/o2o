package com.o2o.dao;

import com.o2o.entity.Area;

import java.util.List;

/**
 * Created by tanke on 2018/9/19.
 */
public interface AreaDao {
    /**
     * 获取地区数据
     * @return
     */
    public List<Area> queryArea();
}
