package com.o2o.web.superadmin.shopadmin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.o2o.dto.ShopExecution;
import com.o2o.entity.PersonInfo;
import com.o2o.entity.Shop;
import com.o2o.enums.ShopStateEnum;
import com.o2o.exceptions.ShopOperationException;
import com.o2o.service.ShopService;
import com.o2o.until.HttpServletRequestUntil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tanke on 2018/9/21.
 */
@RequestMapping("/shopAdmin")
public class ShopManagementController {
    @Resource
    private ShopService shopService;
    @PostMapping("/registerShop")
    public Map<String,Object> registerShop(HttpServletRequest request){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        //接收并转换相应的参数，包括店铺信息和图片信息
        ObjectMapper mapper = new ObjectMapper();
        String value= HttpServletRequestUntil.getString(request,"shopstr");
        Shop shop = null;
        try {
            shop=mapper.readValue(value, Shop.class);
        } catch (IOException e) {
            modelMap.put("SUCCESS",false);
            modelMap.put("errMsg",e.getMessage());
            return modelMap;
        }
        CommonsMultipartFile shopImg=null;
        CommonsMultipartResolver commonsMultipartResolver=new CommonsMultipartResolver(
                request.getSession().getServletContext() );
        if(commonsMultipartResolver.isMultipart(request)){
            MultipartHttpServletRequest multipartHttpServletRequest=(MultipartHttpServletRequest)request;
            shopImg=(CommonsMultipartFile)multipartHttpServletRequest.getFile("shopImg");
        }else{
            modelMap.put("SUCCESS",false);
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
                    modelMap.put("SUCCESS",true);
                }else{
                    modelMap.put("SUCCESS",false);
                    modelMap.put("errMsg",shopExecution.getStateInfo());
                }
            } catch (ShopOperationException e) {
                modelMap.put("SUCCESS",false);
                modelMap.put("errMsg",e.getMessage());
                return modelMap;
            }catch (IOException e) {
                modelMap.put("SUCCESS",false);
                modelMap.put("errMsg",e.getMessage());
                return modelMap;
            }
            return modelMap;
        }else{
            modelMap.put("SUCCESS",false);
            modelMap.put("errMsg","请输入店铺信息");
            return modelMap;
        }
    }


}
