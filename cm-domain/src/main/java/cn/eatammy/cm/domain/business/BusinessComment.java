/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：商城评论表											
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

package cn.eatammy.cm.domain.business;

import cn.eatammy.common.domain.CMCreateBaseDomain;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 《商城评论》 实体
 * @author 郭旭辉
 *
 */
public class BusinessComment extends CMCreateBaseDomain<Long> {
	private static final long serialVersionUID = 1L;
	
	private String content; //评论内容
	private Long userId; //评论者id
	private Long activityId; //活动主键
	private Long goodsId; //商品主键
    
	/**
	 *默认空构造函数
	 */
	public BusinessComment() {
		super();
	}
	 
	/**
	 * @return content 评论内容
	 */
	public String getContent(){
		return this.content;
	}
	/**
	 * @param content 评论内容
	 */
	public void setContent(String content){
		this.content = content;
	}
	/**
	 * @return userId 评论者id
	 */
	public Long getUserId(){
		return this.userId;
	}
	/**
	 * @param userId 评论者id
	 */
	public void setUserId(Long userId){
		this.userId = userId;
	}
	/**
	 * @return activityId 活动主键
	 */
	public Long getActivityId(){
		return this.activityId;
	}
	/**
	 * @param activityId 活动主键
	 */
	public void setActivityId(Long activityId){
		this.activityId = activityId;
	}
	/**
	 * @return goodsId 商品主键
	 */
	public Long getGoodsId(){
		return this.goodsId;
	}
	/**
	 * @param goodsId 商品主键
	 */
	public void setGoodsId(Long goodsId){
		this.goodsId = goodsId;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("content",getContent())
			.append("userId",getUserId())
			.append("activityId",getActivityId())
			.append("goodsId",getGoodsId())
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
			.append(getContent())
			.append(getUserId())
			.append(getActivityId())
			.append(getGoodsId())
			.append(getCreator())
			.append(getCreateDate())
			.append(getLastModifier())
			.append(getLastModDate())
			.append(getStatus())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessComment == false) return false;
		if(this == obj) return true;
		BusinessComment other = (BusinessComment)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}
