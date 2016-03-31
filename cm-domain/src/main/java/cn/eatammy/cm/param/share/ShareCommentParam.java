/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：评论表											
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
 * 《评论》 查询参数实体
 * @author 郭旭辉
 *
 */
public class ShareCommentParam extends CreateBaseParam<Long> {
	private static final long serialVersionUID = 1L;
	
	/**
	*字段常量——评论内容
	*/
	public static final String F_Content="content";
	/**
	*字段常量——评论者id
	*/
	public static final String F_UserId="userId";
	/**
	*字段常量——消息id
	*/
	public static final String F_WeiboId="weiboId";
	/**
	*字段常量——忆文主键
	*/
	public static final String F_ArticleId="articleId";
	/**
	*字段常量——时光轴主键
	*/
	public static final String F_FusionId="fusionId";
	
	private String content; //评论内容
	private Long userId; //评论者id
	private Long weiboId; //消息id
	private Long articleId; //忆文主键
	private Long fusionId; //时光轴主键
    
	/**
	 *默认空构造函数
	 */
	public ShareCommentParam() {
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
	 * @return weiboId 消息id
	 */
	public Long getWeiboId(){
		return this.weiboId;
	}
	/**
	 * @param weiboId 消息id
	 */
	public void setWeiboId(Long weiboId){
		this.weiboId = weiboId;
	}
	/**
	 * @return articleId 忆文主键
	 */
	public Long getArticleId(){
		return this.articleId;
	}
	/**
	 * @param articleId 忆文主键
	 */
	public void setArticleId(Long articleId){
		this.articleId = articleId;
	}
	/**
	 * @return fusionId 时光轴主键
	 */
	public Long getFusionId(){
		return this.fusionId;
	}
	/**
	 * @param fusionId 时光轴主键
	 */
	public void setFusionId(Long fusionId){
		this.fusionId = fusionId;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("content",getContent())
			.append("userId",getUserId())
			.append("weiboId",getWeiboId())
			.append("articleId",getArticleId())
			.append("fusionId",getFusionId())
			.append("creator",getCreator())
			.append("createDate",getCreateDate())
			.append("lastModifier",getLastModifier())
			.append("lastModDate",getLastModDate())
			.append("status",getStatus())
			.toString();
	}
	
}
