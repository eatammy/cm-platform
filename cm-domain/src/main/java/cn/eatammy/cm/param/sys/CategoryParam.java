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

package cn.eatammy.cm.param.sys;

import cn.eatammy.common.param.CreateBaseParam;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 《分类》 查询参数实体
 * @author 郭旭辉
 *
 */
public class CategoryParam extends CreateBaseParam<Long> {
	private static final long serialVersionUID = 1L;
	
	/**
	*字段常量——
	*/
	public static final String F_Name="name";
	/**
	*字段常量——排序字段
	*/
	public static final String F_Priority="priority";
	/**
	*字段常量——分类类别，1：食谱分类，2：商店分类,4：商品分类，8：活动分类
	*/
	public static final String F_Type="type";
	
	private String name; //
	private Integer priority; //排序字段
	private Integer type; //分类类别，1：食谱分类，2：商店分类,4：商品分类，8：活动分类
    
	/**
	 *默认空构造函数
	 */
	public CategoryParam() {
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
	
}
