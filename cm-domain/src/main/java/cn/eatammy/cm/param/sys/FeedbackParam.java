/*
{*****************************************************************************
{  主平台 v1.0													
{  版权信息 (c) 2016-2016 郭旭辉-詹晓锋. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：用户反馈表，记录用户反馈，建议，举报等信息											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-10-02  郭旭辉        新建	
{ 	                                                                     
{  ---------------------------------------------------------------------------
{*****************************************************************************	
*/

package cn.eatammy.cm.param.sys;

import cn.eatammy.common.param.BaseParam;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 《用户反馈表，记录用户反馈，建议，举报等信息》 查询参数实体
 * @author 郭旭辉
 *
 */
public class FeedbackParam extends BaseParam<Long> {
	private static final long serialVersionUID = 1L;
	
	/**
	*字段常量——用户uid
	*/
	public static final String F_Uid="uid";
	/**
	*字段常量——反馈内容
	*/
	public static final String F_Content="content";
	/**
	*字段常量——创建时间
	*/
	public static final String F_CreateTime="createTime";
	
	private String uid; //用户uid
	private String content; //反馈内容
	private Long createTime; //创建时间
    
	/**
	 *默认空构造函数
	 */
	public FeedbackParam() {
		super();
	}
	 
	/**
	 * @return uid 用户uid
	 */
	public String getUid(){
		return this.uid;
	}
	/**
	 * @param uid 用户uid
	 */
	public void setUid(String uid){
		this.uid = uid;
	}
	/**
	 * @return content 反馈内容
	 */
	public String getContent(){
		return this.content;
	}
	/**
	 * @param content 反馈内容
	 */
	public void setContent(String content){
		this.content = content;
	}
	/**
	 * @return createTime 创建时间
	 */
	public Long getCreateTime(){
		return this.createTime;
	}
	/**
	 * @param createTime 创建时间
	 */
	public void setCreateTime(Long createTime){
		this.createTime = createTime;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("uid",getUid())
			.append("content",getContent())
			.append("createTime",getCreateTime())
			.toString();
	}
	
}
