/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：时光轴											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-04-28  郭旭辉        新建	
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
 * 《时光轴》 查询参数实体
 * @author 郭旭辉
 *
 */
public class FusionParam extends CreateBaseParam<Long> {
	private static final long serialVersionUID = 1L;
	
	/**
	*字段常量——所属者id,用户code
	*/
	public static final String F_Uid="uid";
	/**
	*字段常量——发表日期
	*/
	public static final String F_RecordDate="recordDate";
	/**
	*字段常量——发表内容
	*/
	public static final String F_Content="content";
	/**
	*字段常量——图片url
	*/
	public static final String F_Picture="picture";
	/**
	*字段常量——地点
	*/
	public static final String F_Address="address";
	/**
	*字段常量——点赞数
	*/
	public static final String F_PraiseNum="praiseNum";
	/**
	*字段常量——评论数
	*/
	public static final String F_CommentNum="commentNum";
	
	private String uid; //所属者id,用户code
	private Long recordDate; //发表日期
	private String content; //发表内容
	private String picture; //图片url
	private String address; //地点
	private Integer praiseNum; //点赞数
	private Integer commentNum; //评论数
    
	/**
	 *默认空构造函数
	 */
	public FusionParam() {
		super();
	}
	 
	/**
	 * @return uid 所属者id,用户code
	 */
	public String getUid(){
		return this.uid;
	}
	/**
	 * @param uid 所属者id,用户code
	 */
	public void setUid(String uid){
		this.uid = uid;
	}
	/**
	 * @return recordDate 发表日期
	 */
	public Long getRecordDate(){
		return this.recordDate;
	}
	/**
	 * @param recordDate 发表日期
	 */
	public void setRecordDate(Long recordDate){
		this.recordDate = recordDate;
	}
	/**
	 * @return content 发表内容
	 */
	public String getContent(){
		return this.content;
	}
	/**
	 * @param content 发表内容
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
	 * @return address 地点
	 */
	public String getAddress(){
		return this.address;
	}
	/**
	 * @param address 地点
	 */
	public void setAddress(String address){
		this.address = address;
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
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("uid",getUid())
			.append("recordDate",getRecordDate())
			.append("content",getContent())
			.append("picture",getPicture())
			.append("address",getAddress())
			.append("praiseNum",getPraiseNum())
			.append("commentNum",getCommentNum())
			.append("createDate",getCreateDate())
			.append("creator",getCreator())
			.append("lastModDate",getLastModDate())
			.append("lastModifier",getLastModifier())
			.append("status",getStatus())
			.toString();
	}
	
}
