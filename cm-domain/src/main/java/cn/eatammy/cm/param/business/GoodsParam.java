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

package cn.eatammy.cm.param.business;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import cn.eatammy.common.param.CreateBaseParam;

import java.util.*;

/**
 * 《商品信息》 查询参数实体
 * @author 郭旭辉
 *
 */
public class GoodsParam extends CreateBaseParam<Long> {
	private static final long serialVersionUID = 1L;
	
	/**
	*字段常量——商品名称
	*/
	public static final String F_GoodsName="goodsName";
	/**
	*字段常量——商品单价
	*/
	public static final String F_Price="price";
	/**
	*字段常量——所属商店
	*/
	public static final String F_ShopId="shopId";
	/**
	*字段常量——库存量
	*/
	public static final String F_Stock="stock";
	/**
	*字段常量——销售量
	*/
	public static final String F_Sale="sale";
	/**
	*字段常量——描述
	*/
	public static final String F_Description="description";
	
	private String goodsName; //商品名称
	private Double price; //商品单价
	private Long shopId; //所属商店
	private Integer stock; //库存量
	private Integer sale; //销售量
	private String description; //描述
    
	/**
	 *默认空构造函数
	 */
	public GoodsParam() {
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
	
}
