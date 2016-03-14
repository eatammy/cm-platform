/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：退单											
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

package cn.eatammy.cm.param.business;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import cn.eatammy.common.param.CreateBaseParam;

import java.util.*;

/**
 * 《退单》 查询参数实体
 * @author 郭旭辉
 *
 */
public class BackIndentParam extends CreateBaseParam<Long> {
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
	*字段常量——订单id
	*/
	public static final String F_IndentId="indentId";
	/**
	*字段常量——商家退款确认，0：不确认，1：确认退款
	*/
	public static final String F_IsRefund="isRefund";
	
	private Long uid; //用户id
	private Long shopId; //商店id
	private Long indentId; //订单id
	private Boolean isRefund; //商家退款确认，0：不确认，1：确认退款
    
	/**
	 *默认空构造函数
	 */
	public BackIndentParam() {
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
	 * @return isRefund 商家退款确认，0：不确认，1：确认退款
	 */
	public Boolean getIsRefund(){
		return this.isRefund;
	}
	/**
	 * @param isRefund 商家退款确认，0：不确认，1：确认退款
	 */
	public void setIsRefund(Boolean isRefund){
		this.isRefund = isRefund;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("uid",getUid())
			.append("shopId",getShopId())
			.append("indentId",getIndentId())
			.append("isRefund",getIsRefund())
			.append("creator",getCreator())
			.append("createDate",getCreateDate())
			.append("lastModifier",getLastModifier())
			.append("lastModDate",getLastModDate())
			.append("status",getStatus())
			.toString();
	}
	
}
