/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：商城回复回复表											
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
 * 《商城回复回复》 实体
 * @author 郭旭辉
 *
 */
public class BusinessReply extends CMCreateBaseDomain<Long> {
	private static final long serialVersionUID = 1L;
	
	private String content; //回复内容
	private Long commentId; //评论主键
	private Long shopId; //回复人主键
	private String shopName; //回复人名称
	private Long replayDate; //回复时间
	private Long replyToId; //被回复者主键
	private String replyName; //被回复者名称
    
	/**
	 *默认空构造函数
	 */
	public BusinessReply() {
		super();
	}
	 
	/**
	 * @return content 回复内容
	 */
	public String getContent(){
		return this.content;
	}
	/**
	 * @param content 回复内容
	 */
	public void setContent(String content){
		this.content = content;
	}
	/**
	 * @return commentId 评论主键
	 */
	public Long getCommentId(){
		return this.commentId;
	}
	/**
	 * @param commentId 评论主键
	 */
	public void setCommentId(Long commentId){
		this.commentId = commentId;
	}
	/**
	 * @return shopId 回复人主键
	 */
	public Long getShopId(){
		return this.shopId;
	}
	/**
	 * @param shopId 回复人主键
	 */
	public void setShopId(Long shopId){
		this.shopId = shopId;
	}
	/**
	 * @return shopName 回复人名称
	 */
	public String getShopName(){
		return this.shopName;
	}
	/**
	 * @param shopName 回复人名称
	 */
	public void setShopName(String shopName){
		this.shopName = shopName;
	}
	/**
	 * @return replayDate 回复时间
	 */
	public Long getReplayDate(){
		return this.replayDate;
	}
	/**
	 * @param replayDate 回复时间
	 */
	public void setReplayDate(Long replayDate){
		this.replayDate = replayDate;
	}
	/**
	 * @return replyToId 被回复者主键
	 */
	public Long getReplyToId(){
		return this.replyToId;
	}
	/**
	 * @param replyToId 被回复者主键
	 */
	public void setReplyToId(Long replyToId){
		this.replyToId = replyToId;
	}
	/**
	 * @return replyName 被回复者名称
	 */
	public String getReplyName(){
		return this.replyName;
	}
	/**
	 * @param replyName 被回复者名称
	 */
	public void setReplyName(String replyName){
		this.replyName = replyName;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("content",getContent())
			.append("commentId",getCommentId())
			.append("shopId",getShopId())
			.append("shopName",getShopName())
			.append("replayDate",getReplayDate())
			.append("replyToId",getReplyToId())
			.append("replyName",getReplyName())
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
			.append(getCommentId())
			.append(getShopId())
			.append(getShopName())
			.append(getReplayDate())
			.append(getReplyToId())
			.append(getReplyName())
			.append(getCreator())
			.append(getCreateDate())
			.append(getLastModifier())
			.append(getLastModDate())
			.append(getStatus())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessReply == false) return false;
		if(this == obj) return true;
		BusinessReply other = (BusinessReply)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}
