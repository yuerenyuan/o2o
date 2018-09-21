package com.o2o.dto;

import com.o2o.entity.Shop;
import com.o2o.enums.ShopStateEnum;

import java.util.List;

/**
 * Created by tanke on 2018/9/20.
 */
public class ShopExecution {
    //状态码
    private int state;
    //状态标识
    private String stateInfo;
    //操作的SHOP
    private Shop shop;
    //
    private List<Shop> shopList;
    //店铺数量
    private int count;

    public ShopExecution(){

    }
    //店铺操作失败的构造器
    public ShopExecution(ShopStateEnum shopStateEnum){
           this.state=shopStateEnum.getState();
           this.stateInfo=shopStateEnum.getStateInfo();
    }
    //店铺操作成功的构造器
    public ShopExecution(ShopStateEnum shopStateEnum,Shop shop){
        this.state=shopStateEnum.getState();
        this.stateInfo=shopStateEnum.getStateInfo();
        this.shop=shop;
    }
    //店铺操作成功的构造器
    public ShopExecution(ShopStateEnum shopStateEnum,List<Shop> shopList){
        this.state=shopStateEnum.getState();
        this.stateInfo=shopStateEnum.getStateInfo();
        this.shopList=shopList;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<Shop> getShopList() {
        return shopList;
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
