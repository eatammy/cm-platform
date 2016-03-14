/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：订单											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-03-14  郭旭辉        新建	
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
 * 《订单》 实体
 * @author 郭旭辉
 *
 */
public class Indent extends CMCreateBaseDomain<Long> {
	private static final long serialVersionUID = 1L;
	
	private Long uid; //用户id
	private Long shopId; //商店id
	private String address; //订单地址
	private Long goodsId; //商品id
	private String goodsName; //商店名称
	private Integer count; //数量
	private Integer total; //总额
	private Double piece; //单价
	private Boolean isTraded; //是否完成交易，0：未完成，1：完成
    
	/**
	 *默认空构造函数
	 */
	public Indent() {
		super();
	}
	 
	/**
	 * @return uid 用户id
	 */
	public Long getUid(){
		return this.uid;
	}
	/**
	 * @param uid 用户id
	 */
	public void setUid(Long uid){
		this.uid = uid;
	}
	/**
	 * @return shopId 商店id
	 */
	public Long getShopId(){
		return this.shopId;
	}
	/**
	 * @param shopId 商店id
	 */
	public void setShopId(Long shopId){
		this.shopId = shopId;
	}
	/**
	 * @return address 订单地址
	 */
	public String getAddress(){
		return this.address;
	}
	/**
	 * @param address 订单地址
	 */
	public void setAddress(String address){
		this.address = address;
	}
	/**
	 * @return goodsId 商品id
	 */
	public Long getGoodsId(){
		return this.goodsId;
	}
	/**
	 * @param goodsId 商品id
	 */
	public void setGoodsId(Long goodsId){
		this.goodsId = goodsId;
	}
	/**
	 * @return goodsName 商店名称
	 */
	public String getGoodsName(){
		return this.goodsName;
	}
	/**
	 * @param goodsName 商店名称
	 */
	public void setGoodsName(String goodsName){
		this.goodsName = goodsName;
	}
	/**
	 * @return count 数量
	 */
	public Integer getCount(){
		return this.count;
	}
	/**
	 * @param count 数量
	 */
	public void setCount(Integer count){
		this.count = count;
	}
	/**
	 * @return total 总额
	 */
	public Integer getTotal(){
		return this.total;
	}
	/**
	 * @param total 总额
	 */
	public void setTotal(Integer total){
		this.total = total;
	}
	/**
	 * @return piece 单价
	 */
	public Double getPiece(){
		return this.piece;
	}
	/**
	 * @param piece 单价
	 */
	public void setPiece(Double piece){
		this.piece = piece;
	}
	/**
	 * @return isTraded 是否完成交易，0：未完成，1：完成
	 */
	public Boolean getIsTraded(){
		return this.isTraded;
	}
	/**
	 * @param isTraded 是否完成交易，0：未完成，1：完成
	 */
	public void setIsTraded(Boolean isTraded){
		this.isTraded = isTraded;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("uid",getUid())
			.append("shopId",getShopId())
			.append("address",getAddress())
			.append("goodsId",getGoodsId())
			.append("goodsName",getGoodsName())
			.append("count",getCount())
			.append("total",getTotal())
			.append("piece",getPiece())
			.append("isTraded",getIsTraded())
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
			.append(getUid())
			.append(getShopId())
			.append(getAddress())
			.append(getGoodsId())
			.append(getGoodsName())
			.append(getCount())
			.append(getTotal())
			.append(getPiece())
			.append(getIsTraded())
			.append(getCreator())
			.append(getCreateDate())
			.append(getLastModifier())
			.append(getLastModDate())
			.append(getStatus())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Indent == false) return false;
		if(this == obj) return true;
		Indent other = (Indent)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}
