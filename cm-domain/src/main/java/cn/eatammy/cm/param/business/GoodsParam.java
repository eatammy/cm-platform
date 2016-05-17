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
{  2016-05-17  郭旭辉        新建	
{ 	                                                                     
{  ---------------------------------------------------------------------------
{  注：本模块代码由codgen代码生成工具辅助生成 http://www.oschina.net/p/codgen	
{*****************************************************************************	
*/

package cn.eatammy.cm.param.business;

import cn.eatammy.common.param.CreateBaseParam;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

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
	*字段常量——商品code，UUID
	*/
	public static final String F_Code="code";
	/**
	*字段常量——所属商店,商店code
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
	/**
	*字段常量——商品图片
	*/
	public static final String F_Picture="picture";
	/**
	*字段常量——商品分类id
	*/
	public static final String F_CategoryId="categoryId";
	
	private String goodsName; //商品名称
	private Double price; //商品单价
	private String code; //商品code，UUID
	private String shopId; //所属商店,商店code
	private Integer stock; //库存量
	private Integer sale; //销售量
	private String description; //描述
	private String picture; //商品图片
	private Long categoryId; //商品分类id
    
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
	 * @return code 商品code，UUID
	 */
	public String getCode(){
		return this.code;
	}
	/**
	 * @param code 商品code，UUID
	 */
	public void setCode(String code){
		this.code = code;
	}
	/**
	 * @return shopId 所属商店,商店code
	 */
	public String getShopId(){
		return this.shopId;
	}
	/**
	 * @param shopId 所属商店,商店code
	 */
	public void setShopId(String shopId){
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
	/**
	 * @return picture 商品图片
	 */
	public String getPicture(){
		return this.picture;
	}
	/**
	 * @param picture 商品图片
	 */
	public void setPicture(String picture){
		this.picture = picture;
	}
	/**
	 * @return categoryId 商品分类id
	 */
	public Long getCategoryId(){
		return this.categoryId;
	}
	/**
	 * @param categoryId 商品分类id
	 */
	public void setCategoryId(Long categoryId){
		this.categoryId = categoryId;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("goodsName",getGoodsName())
			.append("price",getPrice())
			.append("code",getCode())
			.append("shopId",getShopId())
			.append("stock",getStock())
			.append("sale",getSale())
			.append("description",getDescription())
			.append("picture",getPicture())
			.append("categoryId",getCategoryId())
			.append("creator",getCreator())
			.append("createDate",getCreateDate())
			.append("lastModifier",getLastModifier())
			.append("lastModDate",getLastModDate())
			.append("status",getStatus())
			.toString();
	}
	
}
