/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：购物车											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-03-23  郭旭辉        新建	
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
 * 《购物车》 查询参数实体
 * @author 郭旭辉
 *
 */
public class ShoppingCartParam extends CreateBaseParam<Long> {
	private static final long serialVersionUID = 1L;
	
	/**
	*字段常量——用户id
	*/
	public static final String F_Uid="uid";
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
	public static final String F_Count="count";
	
	private Long uid; //用户id
	private Long shopId; //商店id
	private Long goodsId; //商品id
	private Integer count; //数量
    
	/**
	 *默认空构造函数
	 */
	public ShoppingCartParam() {
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
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("uid",getUid())
			.append("shopId",getShopId())
			.append("goodsId",getGoodsId())
			.append("count",getCount())
			.append("creator",getCreator())
			.append("createDate",getCreateDate())
			.append("lastModifier",getLastModifier())
			.append("lastModDate",getLastModDate())
			.append("status",getStatus())
			.toString();
	}
	
}
