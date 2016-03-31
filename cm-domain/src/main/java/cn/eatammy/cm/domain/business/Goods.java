/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：商品信息表											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-03-31  郭旭辉        新建	
{ 	                                                                     
{  ---------------------------------------------------------------------------
{  注：本模块代码由codgen代码生成工具辅助生成 http://www.oschina.net/p/codgen	
{*****************************************************************************	
*/

package cn.eatammy.cm.domain.business;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import cn.eatammy.common.domain.CMCreateBaseDomain;

import java.util.*;

/**
 * 《商品信息》 实体
 * @author 郭旭辉
 *
 */
public class Goods extends CMCreateBaseDomain<Long> {
	private static final long serialVersionUID = 1L;
	
	private String goodsName; //商品名称
	private Double price; //商品单价
	private Long shopId; //所属商店
	private Integer stock; //库存量
	private Integer sale; //销售量
	private String description; //描述
    
	/**
	 *默认空构造函数
	 */
	public Goods() {
		super();
	}
	 
	/**
	 * @return goodsName 商品名称
	 */
	public String getGoodsName(){
		return this.goodsName;
	}
	/**
	 * @param goodsName 商品名称
	 */
	public void setGoodsName(String goodsName){
		this.goodsName = goodsName;
	}
	/**
	 * @return price 商品单价
	 */
	public Double getPrice(){
		return this.price;
	}
	/**
	 * @param price 商品单价
	 */
	public void setPrice(Double price){
		this.price = price;
	}
	/**
	 * @return shopId 所属商店
	 */
	public Long getShopId(){
		return this.shopId;
	}
	/**
	 * @param shopId 所属商店
	 */
	public void setShopId(Long shopId){
		this.shopId = shopId;
	}
	/**
	 * @return stock 库存量
	 */
	public Integer getStock(){
		return this.stock;
	}
	/**
	 * @param stock 库存量
	 */
	public void setStock(Integer stock){
		this.stock = stock;
	}
	/**
	 * @return sale 销售量
	 */
	public Integer getSale(){
		return this.sale;
	}
	/**
	 * @param sale 销售量
	 */
	public void setSale(Integer sale){
		this.sale = sale;
	}
	/**
	 * @return description 描述
	 */
	public String getDescription(){
		return this.description;
	}
	/**
	 * @param description 描述
	 */
	public void setDescription(String description){
		this.description = description;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("goodsName",getGoodsName())
			.append("price",getPrice())
			.append("shopId",getShopId())
			.append("stock",getStock())
			.append("sale",getSale())
			.append("description",getDescription())
			.append("creator",getCreator())
			.append("createDate",getCreateDate())
			.append("lastModifier",getLastModifier())
			.append("lastModDate",getLastModDate())
			.append("status",getStatus())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getGoodsName())
			.append(getPrice())
			.append(getShopId())
			.append(getStock())
			.append(getSale())
			.append(getDescription())
			.append(getCreator())
			.append(getCreateDate())
			.append(getLastModifier())
			.append(getLastModDate())
			.append(getStatus())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Goods == false) return false;
		if(this == obj) return true;
		Goods other = (Goods)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}
