/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：回复表											
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

package cn.eatammy.cm.param.share;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import cn.eatammy.common.param.CreateBaseParam;

import java.util.*;

/**
 * 《回复》 查询参数实体
 * @author 郭旭辉
 *
 */
public class ShareReplyParam extends CreateBaseParam<Long> {
	private static final long serialVersionUID = 1L;
	
	/**
	*字段常量——回复内容
	*/
	public static final String F_Content="content";
	/**
	*字段常量——评论主键
	*/
	public static final String F_CommentId="commentId";
	/**
	*字段常量——回复人主键
	*/
	public static final String F_AnswerId="answerId";
	/**
	*字段常量——回复人名称
	*/
	public static final String F_AnswerName="answerName";
	/**
	*字段常量——回复时间
	*/
	public static final String F_ReplayDate="replayDate";
	/**
	*字段常量——被回复者主键
	*/
	public static final String F_ReplyToId="replyToId";
	/**
	*字段常量——被回复者名称
	*/
	public static final String F_ReplyName="replyName";
	
	private String content; //回复内容
	private Long commentId; //评论主键
	private Long answerId; //回复人主键
	private String answerName; //回复人名称
	private Long replayDate; //回复时间
	private Long replyToId; //被回复者主键
	private String replyName; //被回复者名称
    
	/**
	 *默认空构造函数
	 */
	public ShareReplyParam() {
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
	 * @return answerId 回复人主键
	 */
	public Long getAnswerId(){
		return this.answerId;
	}
	/**
	 * @param answerId 回复人主键
	 */
	public void setAnswerId(Long answerId){
		this.answerId = answerId;
	}
	/**
	 * @return answerName 回复人名称
	 */
	public String getAnswerName(){
		return this.answerName;
	}
	/**
	 * @param answerName 回复人名称
	 */
	public void setAnswerName(String answerName){
		this.answerName = answerName;
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
			.append("answerId",getAnswerId())
			.append("answerName",getAnswerName())
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
	
}
