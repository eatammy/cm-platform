/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：美食忆文											
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

package cn.eatammy.cm.param.share;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import cn.eatammy.common.param.CreateBaseParam;

import java.util.*;

/**
 * 《美食忆文》 查询参数实体
 * @author 郭旭辉
 *
 */
public class ArticleParam extends CreateBaseParam<Long> {
	private static final long serialVersionUID = 1L;
	
	/**
	*字段常量——所属用户
	*/
	public static final String F_Uid="uid";
	/**
	*字段常量——文章标题
	*/
	public static final String F_Title="title";
	/**
	*字段常量——文章内容
	*/
	public static final String F_Content="content";
	/**
	*字段常量——点赞数
	*/
	public static final String F_PraiseNum="praiseNum";
	/**
	*字段常量——评论数
	*/
	public static final String F_CommentNum="commentNum";
	/**
	*字段常量——是否举报，默认为0，1：举报一次，2：审核状态
	*/
	public static final String F_IsReport="isReport";
	
	private Long uid; //所属用户
	private String title; //文章标题
	private String content; //文章内容
	private Integer praiseNum; //点赞数
	private Integer commentNum; //评论数
	private Boolean isReport; //是否举报，默认为0，1：举报一次，2：审核状态
    
	/**
	 *默认空构造函数
	 */
	public ArticleParam() {
		super();
	}
	 
	/**
	 * @return uid 所属用户
	 */
	public Long getUid(){
		return this.uid;
	}
	/**
	 * @param uid 所属用户
	 */
	public void setUid(Long uid){
		this.uid = uid;
	}
	/**
	 * @return title 文章标题
	 */
	public String getTitle(){
		return this.title;
	}
	/**
	 * @param title 文章标题
	 */
	public void setTitle(String title){
		this.title = title;
	}
	/**
	 * @return content 文章内容
	 */
	public String getContent(){
		return this.content;
	}
	/**
	 * @param content 文章内容
	 */
	public void setContent(String content){
		this.content = content;
	}
	/**
	 * @return praiseNum 点赞数
	 */
	public Integer getPraiseNum(){
		return this.praiseNum;
	}
	/**
	 * @param praiseNum 点赞数
	 */
	public void setPraiseNum(Integer praiseNum){
		this.praiseNum = praiseNum;
	}
	/**
	 * @return commentNum 评论数
	 */
	public Integer getCommentNum(){
		return this.commentNum;
	}
	/**
	 * @param commentNum 评论数
	 */
	public void setCommentNum(Integer commentNum){
		this.commentNum = commentNum;
	}
	/**
	 * @return isReport 是否举报，默认为0，1：举报一次，2：审核状态
	 */
	public Boolean getIsReport(){
		return this.isReport;
	}
	/**
	 * @param isReport 是否举报，默认为0，1：举报一次，2：审核状态
	 */
	public void setIsReport(Boolean isReport){
		this.isReport = isReport;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("uid",getUid())
			.append("title",getTitle())
			.append("content",getContent())
			.append("praiseNum",getPraiseNum())
			.append("commentNum",getCommentNum())
			.append("isReport",getIsReport())
			.append("createDate",getCreateDate())
			.append("creator",getCreator())
			.append("lastModDate",getLastModDate())
			.append("lastModifier",getLastModifier())
			.append("status",getStatus())
			.toString();
	}
	
}