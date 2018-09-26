package com.o2o.web.superadmin.shopadmin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.o2o.dto.ShopExecution;
import com.o2o.entity.Area;
import com.o2o.entity.PersonInfo;
import com.o2o.entity.Shop;
import com.o2o.entity.ShopCategory;
import com.o2o.enums.ShopStateEnum;
import com.o2o.exceptions.ShopOperationException;
import com.o2o.service.AreaService;
import com.o2o.service.ShopCategoryService;
import com.o2o.service.ShopService;
import com.o2o.until.HttpServletRequestUntil;
import com.o2o.until.VerifyCodeUntil;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tanke on 2018/9/21.
 */
@Controller
@RequestMapping("/shopadmin")
public class ShopManagementController {
    @Resource
    private ShopService shopService;
    @Resource
    private AreaService areaService;
    @Resource
    private ShopCategoryService shopCategoryService;
    @GetMapping("/getshopinitinfo")
    @ResponseBody
    public Map<String,Object> getShopInitInfo(){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        List<Area> areaList=new ArrayList<Area>();
        List<ShopCategory> shopCategoryList=new ArrayList<ShopCategory>();
        try{
            areaList=areaService.getAreaList();
            shopCategoryList=shopCategoryService.getShopCategory(new ShopCategory());
            modelMap.put("success",true);
            modelMap.put("areaList",areaList);
            modelMap.put("shopCategoryList",shopCategoryList);
        }catch (Exception e){
            modelMap.put("success",false);
            modelMap.put("errMsg",e.getMessage());
        }
            return modelMap;
    }
    @RequestMapping("/registerShop")
    @ResponseBody
    public Map<String,Object> registerShop(HttpServletRequest request){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        if(!VerifyCodeUntil.isYang(request)){
            modelMap.put("success",false);
            modelMap.put("errMsg","输入了错误的验证码");
            return modelMap;
        }
        //接收并转换相应的参数，包括店铺信息和图片信息
        ObjectMapper mapper = new ObjectMapper();
        String value= HttpServletRequestUntil.getString(request,"shopStr");
        Shop shop = null;
        try {
            shop=mapper.readValue(value, Shop.class);
            System.out.println("店铺是否为空+++++++++++++++++++++++++++++++++++++");
            System.out.println(shop==null);
        } catch (IOException e) {
            modelMap.put("success",false);
           // modelMap.put("errMsg",e.getMessage());
           modelMap.put("errMsg","错误1");
            return modelMap;
        }
        CommonsMultipartFile shopImg=null;
        CommonsMultipartResolver commonsMultipartResolver=new CommonsMultipartResolver(
                request.getSession().getServletContext() );
        if(commonsMultipartResolver.isMultipart(request)){
            MultipartHttpServletRequest multipartHttpServletRequest=(MultipartHttpServletRequest)request;
            shopImg=(CommonsMultipartFile)multipartHttpServletRequest.getFile("shopImg");
        }else{
            modelMap.put("success",false);
            modelMap.put("errMsg","上传图片不能为空");
            return modelMap;
        }
        //注册店铺
        if(shop!=null&&shopImg!=null){
            PersonInfo personInfo=new PersonInfo();
            personInfo.setUserID(1);
            shop.setOwner(personInfo);
            ShopExecution shopExecution;
            try {
                shopExecution = shopService.addShop(shop,shopImg.getInputStream(),shopImg.getOriginalFilename());
                if(shopExecution.getState()== ShopStateEnum.CHECK.getState()){
                    modelMap.put("success",true);
                }else{
                    modelMap.put("success",false);
                    modelMap.put("errMsg",shopExecution.getStateInfo());
                }
            } catch (ShopOperationException e) {
                modelMap.put("success",false);
              modelMap.put("errMsg",e.getMessage());
            }catch (IOException e) {
                modelMap.put("success",false);
                modelMap.put("errMsg",e.getMessage());
            }
            return modelMap;
        }else{
            modelMap.put("success",false);
            modelMap.put("errMsg","请输入店铺信息");
            return modelMap;
        }
    }
}
