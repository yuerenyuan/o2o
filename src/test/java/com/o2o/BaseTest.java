package com.o2o;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by tanke on 2018/9/19.
 * 配置Spring和junit整合，junit启动时加载SpringIOC容器
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit配置文件的位置
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class BaseTest extends Assert{

}
