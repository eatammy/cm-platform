/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：菜谱分类表											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-03-13  郭旭辉        新建	
{ 	                                                                     
{  ---------------------------------------------------------------------------
{  注：本模块代码由codgen代码生成工具辅助生成 http://www.oschina.net/p/codgen	
{*****************************************************************************	
*/

package cn.eatammy.cm.param.cook;

import cn.eatammy.common.param.CreateBaseParam;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 《菜谱分类》 查询参数实体
 * @author 郭旭辉
 *
 */
public class CookCategoryParam extends CreateBaseParam<Long> {
	private static final long serialVersionUID = 1L;
	
	/**
	*字段常量——菜谱分类名称
	*/
	public static final String F_CategoryName="categoryName";
	/**
	*字段常量——排序字段
	*/
	public static final String F_Priority="priority";
	
	private String categoryName; //菜谱分类名称
	private Integer priority; //排序字段
    
	/**
	 *默认空构造函数
	 */
	public CookCategoryParam() {
		super();
	}
	 
	/**
	 * @return categoryName 菜谱分类名称
	 */
	public String getCategoryName(){
		return this.categoryName;
	}
	/**
	 * @param categoryName 菜谱分类名称
	 */
	public void setCategoryName(String categoryName){
		this.categoryName = categoryName;
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
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("categoryName",getCategoryName())
			.append("priority",getPriority())
			.append("status",getStatus())
			.append("creator",getCreator())
			.append("createDate",getCreateDate())
			.append("lastModifier",getLastModifier())
			.append("lastModDate",getLastModDate())
			.toString();
	}
	
}
