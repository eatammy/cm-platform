/*
{*****************************************************************************
{  主平台 v1.0
{  版权信息 (c) 2016-2016 郭旭辉-詹晓锋. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：订单关系表
{  功能描述:
{
{  ---------------------------------------------------------------------------
{  维护历史:
{  日期        维护人        维护类型
{  ---------------------------------------------------------------------------
{  2016-09-29  郭旭辉        新建
{
{  ---------------------------------------------------------------------------
{*****************************************************************************
*/

package cn.eatammy.cm.param.business;

import cn.eatammy.common.param.BaseParam;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 《订单关系》 查询参数实体
 * @author 郭旭辉
 *
 */
public class IndentRelationParam extends BaseParam<Long> {
	private static final long serialVersionUID = 1L;

	/**
	 *字段常量——订单id
	 */
	public static final String F_IndentId="indentId";
	/**
	 *字段常量——商店id
	 */
	public static final String F_ShopId="shopId";
	/**
	 *字段常量——商品id
	 */
	public static final String F_GoodsId="goodsId";
	/**
	 *字段常量——数量
	 */
	public static final String F_Num="num";
	/**
	 *字段常量——销售价格
	 */
	public static final String F_Price="price";

	private Long indentId; //订单id
	private String shopId; //商店id
	private String goodsId; //商品id
	private Integer num; //数量
	private Double price; //销售价格

	/**
	 *默认空构造函数
	 */
	public IndentRelationParam() {
		super();
	}

	/**
	 * @return indentId 订单id
	 */
	public Long getIndentId(){
		return this.indentId;
	}
	/**
	 * @param indentId 订单id
	 */
	public void setIndentId(Long indentId){
		this.indentId = indentId;
	}
	/**
	 * @return shopId 商店id
	 */
	public String getShopId(){
		return this.shopId;
	}
	/**
	 * @param shopId 商店id
	 */
	public void setShopId(String shopId){
		this.shopId = shopId;
	}
	/**
	 * @return goodsId 商品id
	 */
	public String getGoodsId(){
		return this.goodsId;
	}
	/**
	 * @param goodsId 商品id
	 */
	public void setGoodsId(String goodsId){
		this.goodsId = goodsId;
	}
	/**
	 * @return num 数量
	 */
	public Integer getNum(){
		return this.num;
	}
	/**
	 * @param num 数量
	 */
	public void setNum(Integer num){
		this.num = num;
	}
	/**
	 * @return price 销售价格
	 */
	public Double getPrice(){
		return this.price;
	}
	/**
	 * @param price 销售价格
	 */
	public void setPrice(Double price){
		this.price = price;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
				.append("id",getId())
				.append("indentId",getIndentId())
				.append("shopId",getShopId())
				.append("goodsId",getGoodsId())
				.append("num",getNum())
				.append("price",getPrice())
				.toString();
	}

}