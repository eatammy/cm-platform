/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：好友列表（cm_user_buddyList）											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-04-03  郭旭辉        新建	
{ 	                                                                     
{  ---------------------------------------------------------------------------
{  注：本模块代码由codgen代码生成工具辅助生成 http://www.oschina.net/p/codgen	
{*****************************************************************************	
*/

package cn.eatammy.cm.param.user;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import cn.eatammy.common.param.CreateBaseParam;

import java.util.*;

/**
 * 《好友列表（cm_user_buddyList）》 查询参数实体
 * @author 郭旭辉
 *
 */
public class BuddyListParam extends CreateBaseParam<Long> {
	private static final long serialVersionUID = 1L;
	
	/**
	*字段常量——用户uid
	*/
	public static final String F_Uid="uid";
	/**
	*字段常量——朋友id
	*/
	public static final String F_BuddyUid="buddyUid";
	/**
	*字段常量——朋友名称
	*/
	public static final String F_BuddyName="buddyName";
	/**
	*字段常量——朋友头像
	*/
	public static final String F_BuddyHeadIcon="buddyHeadIcon";
	
	private Long uid; //用户uid
	private Long buddyUid; //朋友id
	private String buddyName; //朋友名称
	private String buddyHeadIcon; //朋友头像
    
	/**
	 *默认空构造函数
	 */
	public BuddyListParam() {
		super();
	}
	 
	/**
	 * @return uid 用户uid
	 */
	public Long getUid(){
		return this.uid;
	}
	/**
	 * @param uid 用户uid
	 */
	public void setUid(Long uid){
		this.uid = uid;
	}
	/**
	 * @return buddyUid 朋友id
	 */
	public Long getBuddyUid(){
		return this.buddyUid;
	}
	/**
	 * @param buddyUid 朋友id
	 */
	public void setBuddyUid(Long buddyUid){
		this.buddyUid = buddyUid;
	}
	/**
	 * @return buddyName 朋友名称
	 */
	public String getBuddyName(){
		return this.buddyName;
	}
	/**
	 * @param buddyName 朋友名称
	 */
	public void setBuddyName(String buddyName){
		this.buddyName = buddyName;
	}
	/**
	 * @return buddyHeadIcon 朋友头像
	 */
	public String getBuddyHeadIcon(){
		return this.buddyHeadIcon;
	}
	/**
	 * @param buddyHeadIcon 朋友头像
	 */
	public void setBuddyHeadIcon(String buddyHeadIcon){
		this.buddyHeadIcon = buddyHeadIcon;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("uid",getUid())
			.append("buddyUid",getBuddyUid())
			.append("buddyName",getBuddyName())
			.append("buddyHeadIcon",getBuddyHeadIcon())
			.append("creator",getCreator())
			.append("createDate",getCreateDate())
			.append("lastModifier",getLastModifier())
			.append("lastModDate",getLastModDate())
			.append("status",getStatus())
			.toString();
	}
	
}
