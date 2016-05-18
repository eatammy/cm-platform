/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：活动表											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-05-18  郭旭辉        新建	
{ 	                                                                     
{  ---------------------------------------------------------------------------
{  注：本模块代码由codgen代码生成工具辅助生成 http://www.oschina.net/p/codgen	
{*****************************************************************************	
*/

package cn.eatammy.cm.domain.activity;

import cn.eatammy.common.domain.CMCreateBaseDomain;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 《活动》 实体
 * @author 郭旭辉
 *
 */
public class Activity extends CMCreateBaseDomain<Integer> {
	private static final long serialVersionUID = 1L;
	
	private String name; //活动名称
	private Long categoryId; //活动类型
	private Long startTime; //活动起始时间
	private Long endTime; //活动结束时间
    
	/**
	 *默认空构造函数
	 */
	public Activity() {
		super();
	}
	 
	/**
	 * @return name 活动名称
	 */
	public String getName(){
		return this.name;
	}
	/**
	 * @param name 活动名称
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 * @return categoryId 活动类型
	 */
	public Long getCategoryId(){
		return this.categoryId;
	}
	/**
	 * @param categoryId 活动类型
	 */
	public void setCategoryId(Long categoryId){
		this.categoryId = categoryId;
	}
	/**
	 * @return startTime 活动起始时间
	 */
	public Long getStartTime(){
		return this.startTime;
	}
	/**
	 * @param startTime 活动起始时间
	 */
	public void setStartTime(Long startTime){
		this.startTime = startTime;
	}
	/**
	 * @return endTime 活动结束时间
	 */
	public Long getEndTime(){
		return this.endTime;
	}
	/**
	 * @param endTime 活动结束时间
	 */
	public void setEndTime(Long endTime){
		this.endTime = endTime;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("name",getName())
			.append("categoryId",getCategoryId())
			.append("startTime",getStartTime())
			.append("endTime",getEndTime())
			.append("status",getStatus())
			.append("creator",getCreator())
			.append("createDate",getCreateDate())
			.append("lastModifier",getLastModifier())
			.append("lastModDate",getLastModDate())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getName())
			.append(getCategoryId())
			.append(getStartTime())
			.append(getEndTime())
			.append(getStatus())
			.append(getCreator())
			.append(getCreateDate())
			.append(getLastModifier())
			.append(getLastModDate())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Activity == false) return false;
		if(this == obj) return true;
		Activity other = (Activity)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}
