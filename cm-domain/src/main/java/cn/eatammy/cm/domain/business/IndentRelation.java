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

package cn.eatammy.cm.domain.business;

import cn.eatammy.common.domain.BaseDomain;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 《订单关系》 实体
 * @author 郭旭辉
 *
 */
public class IndentRelation extends BaseDomain<Long> {
	private static final long serialVersionUID = 1L;

	private Long indentId; //订单id
	private String shopId; //商店id
	private String goodsId; //商品id
	private Integer num; //数量
	private Double price; //销售价格

	/**
	 *默认空构造函数
	 */
	public IndentRelation() {
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

	public int hashCode() {
		return new HashCodeBuilder()
				.append(getId())
				.append(getIndentId())
				.append(getShopId())
				.append(getGoodsId())
				.append(getNum())
				.append(getPrice())
				.toHashCode();
	}

	public boolean equals(Object obj) {
		if(obj instanceof IndentRelation == false) return false;
		if(this == obj) return true;
		IndentRelation other = (IndentRelation)obj;
		return new EqualsBuilder()
				.append(getId(),other.getId())
				.isEquals();
	}
}