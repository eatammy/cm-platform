/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2016-2016 郭旭辉-詹晓锋. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：用户行为流量监控											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-07-23  郭旭辉        新建	
{ 	                                                                     
{  ---------------------------------------------------------------------------
{*****************************************************************************	
*/

package cn.eatammy.cm.domain.user;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import cn.eatammy.common.domain.BaseDomain;

import java.util.*;

/**
 * 《用户行为流量监控》 实体
 * @author 郭旭辉
 *
 */
public class UserFlow extends BaseDomain<Long> {
	private static final long serialVersionUID = 1L;
	
	private String uid; //事件触发用户uid
	private Integer event; //事件，1：登陆，2：访问商店，4：浏览商品
	private String sColumn; //自定义字段
	private String sContent; //自定义内容
	private Long createTime; //创建时间
    
	/**
	 *默认空构造函数
	 */
	public UserFlow() {
		super();
	}
	 
	/**
	 * @return uid 事件触发用户uid
	 */
	public String getUid(){
		return this.uid;
	}
	/**
	 * @param uid 事件触发用户uid
	 */
	public void setUid(String uid){
		this.uid = uid;
	}
	/**
	 * @return event 事件，1：登陆，2：访问商店，4：浏览商品
	 */
	public Integer getEvent(){
		return this.event;
	}
	/**
	 * @param event 事件，1：登陆，2：访问商店，4：浏览商品
	 */
	public void setEvent(Integer event){
		this.event = event;
	}
	/**
	 * @return sColumn 自定义字段
	 */
	public String getSColumn(){
		return this.sColumn;
	}
	/**
	 * @param sColumn 自定义字段
	 */
	public void setSColumn(String sColumn){
		this.sColumn = sColumn;
	}
	/**
	 * @return sContent 自定义内容
	 */
	public String getSContent(){
		return this.sContent;
	}
	/**
	 * @param sContent 自定义内容
	 */
	public void setSContent(String sContent){
		this.sContent = sContent;
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
			.append("event",getEvent())
			.append("sColumn",getSColumn())
			.append("sContent",getSContent())
			.append("createTime",getCreateTime())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getUid())
			.append(getEvent())
			.append(getSColumn())
			.append(getSContent())
			.append(getCreateTime())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof UserFlow == false) return false;
		if(this == obj) return true;
		UserFlow other = (UserFlow)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}
