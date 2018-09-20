package com.o2o.entity;

import java.util.Date;
/**
 * 店铺类
 * @author Administrator
 *
 */
public class Shop {

	private Integer shopId;//店铺id
	private String shopName;//店铺名称
	private String shopDesc;//店铺描述
	private String shopAddr;//店铺地址
	private String phone;//店铺联系方式
	private String shopImg;//店铺缩略图地址
	private Double longitude;
	private Double latitude;
	private Integer priority;//店铺权重
	private Date createTime;//创建时间
	private Date lastEditTime;//修改时间
	private Integer enableStatus;//店铺状态 -1.不可用 0.审核中 1.可用
	private String advice;//超级管理员给店家的提醒
	
	private Area area;//区域实体类
	private PersonInfo owner;//用户信息实体类
	private ShopCategory shopCategory;//店铺类别实体类
	private ShopCategory parentCategory;


	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopDesc() {
		return shopDesc;
	}
	public void setShopDesc(String shopDesc) {
		this.shopDesc = shopDesc;
	}
	public String getShopAddr() {
		return shopAddr;
	}
	public void setShopAddr(String shopAddr) {
		this.shopAddr = shopAddr;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getShopImg() {
		return shopImg;
	}
	public void setShopImg(String shopImg) {
		this.shopImg = shopImg;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getLastEditTime() {
		return lastEditTime;
	}
	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}
	public Integer getEnableStatus() {
		return enableStatus;
	}
	public void setEnableStatus(Integer enableStatus) {
		this.enableStatus = enableStatus;
	}
	public String getAdvice() {
		return advice;
	}
	public void setAdvice(String advice) {
		this.advice = advice;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public PersonInfo getOwner() {
		return owner;
	}
	public void setOwner(PersonInfo owner) {
		this.owner = owner;
	}
	public ShopCategory getShopCategory() {
		return shopCategory;
	}
	public void setShopCategory(ShopCategory shopCategory) {
		this.shopCategory = shopCategory;
	}
	public ShopCategory getParentCategory() {
		return parentCategory;
	}
	public void setParentCategory(ShopCategory parentCategory) {
		this.parentCategory = parentCategory;
	}


}
