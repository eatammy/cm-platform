/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：分类表											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-05-17  郭旭辉        新建	
{ 	                                                                     
{  ---------------------------------------------------------------------------
{  注：本模块代码由codgen代码生成工具辅助生成 http://www.oschina.net/p/codgen	
{*****************************************************************************	
*/

package cn.eatammy.cm.domain.sys;

import cn.eatammy.common.domain.CMCreateBaseDomain;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 《分类》 实体
 * @author 郭旭辉
 *
 */
public class Category extends CMCreateBaseDomain<Long> {
	private static final long serialVersionUID = 1L;
	
	private String name; //
	private Integer priority; //排序字段
	private Integer type; //分类类别，1：食谱分类，2：商店分类,4：商品分类，8：活动分类
    
	/**
	 *默认空构造函数
	 */
	public Category() {
		super();
	}
	 
	/**
	 * @return name 
	 */
	public String getName(){
		return this.name;
	}
	/**
	 * @param name 
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 * @return priority 排序字段
	 */
	public Integer getPriority(){
		return this.priority;
	}
	/**
	 * @param priority 排序字段
	 */
	public void setPriority(Integer priority){
		this.priority = priority;
	}
	/**
	 * @return type 分类类别，1：食谱分类，2：商店分类,4：商品分类，8：活动分类
	 */
	public Integer getType(){
		return this.type;
	}
	/**
	 * @param type 分类类别，1：食谱分类，2：商店分类,4：商品分类，8：活动分类
	 */
	public void setType(Integer type){
		this.type = type;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("name",getName())
			.append("priority",getPriority())
			.append("type",getType())
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
			.append(getPriority())
			.append(getType())
			.append(getStatus())
			.append(getCreator())
			.append(getCreateDate())
			.append(getLastModifier())
			.append(getLastModDate())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Category == false) return false;
		if(this == obj) return true;
		Category other = (Category)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}
