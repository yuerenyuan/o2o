package com.o2o.web.superadmin;

import com.o2o.entity.Area;
import com.o2o.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tanke on 2018/9/20.
 */
@RestController
@RequestMapping("/surperadmin")
public class AreaController {
    Logger logger=LoggerFactory.getLogger(AreaController.class);
    @Resource
    private AreaService areaService;
    @GetMapping("arealist")
    public Map<String,Object> areaList(){
       logger.info("===start===");
        Long startTime=System.currentTimeMillis();
        Map<String,Object> map=new HashMap<String,Object>();
        List<Area> list=new ArrayList<Area>();
        try{
            list=areaService.getAreaList();
            map.put("rows",list);
            map.put("total",list.size());
        }catch(Exception e){
            e.printStackTrace();
            map.put("success",false);
            map.put("error",e.toString());
        }
        logger.error("testError");
        Long endTime=System.currentTimeMillis();
        logger.debug("costTime:[{}ms]",endTime-startTime);
        logger.info("===end===");
        return map;
    }
}
