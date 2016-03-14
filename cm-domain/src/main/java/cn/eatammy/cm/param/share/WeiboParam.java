/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：美食圈											
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
 * 《美食圈》 查询参数实体
 * @author 郭旭辉
 *
 */
public class WeiboParam extends CreateBaseParam<Long> {
	private static final long serialVersionUID = 1L;
	
	/**
	*字段常量——所属者主键
	*/
	public static final String F_Uid="uid";
	/**
	*字段常量——所属者名称
	*/
	public static final String F_Username="username";
	/**
	*字段常量——所属者头像
	*/
	public static final String F_UserIcon="userIcon";
	/**
	*字段常量——分享时间
	*/
	public static final String F_ShareTime="shareTime";
	/**
	*字段常量——分享内容
	*/
	public static final String F_Content="content";
	/**
	*字段常量——图片url
	*/
	public static final String F_Picture="picture";
	/**
	*字段常量——点赞数，默认为0
	*/
	public static final String F_PraiseNum="praiseNum";
	/**
	*字段常量——评论数，默认为0
	*/
	public static final String F_CommentNum="commentNum";
	/**
	*字段常量——是否举报，0：正常，1：举报一次；2：完全举报（敏感内容）
	*/
	public static final String F_IsReport="isReport";
	/**
	*字段常量——圈文类型
	*/
	public static final String F_WeiboType="weiboType";
	
	private Long uid; //所属者主键
	private String username; //所属者名称
	private String userIcon; //所属者头像
	private Long shareTime; //分享时间
	private String content; //分享内容
	private String picture; //图片url
	private Integer praiseNum; //点赞数，默认为0
	private Integer commentNum; //评论数，默认为0
	private Boolean isReport; //是否举报，0：正常，1：举报一次；2：完全举报（敏感内容）
	private Boolean weiboType; //圈文类型
    
	/**
	 *默认空构造函数
	 */
	public WeiboParam() {
		super();
	}
	 
	/**
	 * @return uid 所属者主键
	 */
	public Long getUid(){
		return this.uid;
	}
	/**
	 * @param uid 所属者主键
	 */
	public void setUid(Long uid){
		this.uid = uid;
	}
	/**
	 * @return username 所属者名称
	 */
	public String getUsername(){
		return this.username;
	}
	/**
	 * @param username 所属者名称
	 */
	public void setUsername(String username){
		this.username = username;
	}
	/**
	 * @return userIcon 所属者头像
	 */
	public String getUserIcon(){
		return this.userIcon;
	}
	/**
	 * @param userIcon 所属者头像
	 */
	public void setUserIcon(String userIcon){
		this.userIcon = userIcon;
	}
	/**
	 * @return shareTime 分享时间
	 */
	public Long getShareTime(){
		return this.shareTime;
	}
	/**
	 * @param shareTime 分享时间
	 */
	public void setShareTime(Long shareTime){
		this.shareTime = shareTime;
	}
	/**
	 * @return content 分享内容
	 */
	public String getContent(){
		return this.content;
	}
	/**
	 * @param content 分享内容
	 */
	public void setContent(String content){
		this.content = content;
	}
	/**
	 * @return picture 图片url
	 */
	public String getPicture(){
		return this.picture;
	}
	/**
	 * @param picture 图片url
	 */
	public void setPicture(String picture){
		this.picture = picture;
	}
	/**
	 * @return praiseNum 点赞数，默认为0
	 */
	public Integer getPraiseNum(){
		return this.praiseNum;
	}
	/**
	 * @param praiseNum 点赞数，默认为0
	 */
	public void setPraiseNum(Integer praiseNum){
		this.praiseNum = praiseNum;
	}
	/**
	 * @return commentNum 评论数，默认为0
	 */
	public Integer getCommentNum(){
		return this.commentNum;
	}
	/**
	 * @param commentNum 评论数，默认为0
	 */
	public void setCommentNum(Integer commentNum){
		this.commentNum = commentNum;
	}
	/**
	 * @return isReport 是否举报，0：正常，1：举报一次；2：完全举报（敏感内容）
	 */
	public Boolean getIsReport(){
		return this.isReport;
	}
	/**
	 * @param isReport 是否举报，0：正常，1：举报一次；2：完全举报（敏感内容）
	 */
	public void setIsReport(Boolean isReport){
		this.isReport = isReport;
	}
	/**
	 * @return weiboType 圈文类型
	 */
	public Boolean getWeiboType(){
		return this.weiboType;
	}
	/**
	 * @param weiboType 圈文类型
	 */
	public void setWeiboType(Boolean weiboType){
		this.weiboType = weiboType;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("uid",getUid())
			.append("username",getUsername())
			.append("userIcon",getUserIcon())
			.append("shareTime",getShareTime())
			.append("content",getContent())
			.append("picture",getPicture())
			.append("praiseNum",getPraiseNum())
			.append("commentNum",getCommentNum())
			.append("isReport",getIsReport())
			.append("createDate",getCreateDate())
			.append("creator",getCreator())
			.append("lastModDate",getLastModDate())
			.append("lastModifier",getLastModifier())
			.append("status",getStatus())
			.append("weiboType",getWeiboType())
			.toString();
	}
	
}
