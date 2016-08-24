/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2016-2016 郭旭辉-詹晓锋. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：访问控制表											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-08-09  郭旭辉        新建	
{ 	                                                                     
{  ---------------------------------------------------------------------------
{*****************************************************************************	
*/

package cn.eatammy.cm.param.auth;

import cn.eatammy.common.param.CreateBaseParam;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 《访问控制》 查询参数实体
 * @author 郭旭辉
 *
 */
public class AuthAclParam extends CreateBaseParam<Long> {
	private static final long serialVersionUID = 1L;
	
	/**
	*字段常量——主体类型（0 角色）
	*/
	public static final String F_SubjectType="subjectType";
	/**
	*字段常量——主体代码
	*/
	public static final String F_SubjectCode="subjectCode";
	/**
	*字段常量——资源类型（0 模块、1 操作）
	*/
	public static final String F_ResourceType="resourceType";
	/**
	*字段常量——资源代码
	*/
	public static final String F_ResourceCode="resourceCode";
	
	private Integer subjectType; //主体类型（0 角色）
	private String subjectCode; //主体代码
	private Integer resourceType; //资源类型（0 模块、1 操作）
	private String resourceCode; //资源代码
    
	/**
	 *默认空构造函数
	 */
	public AuthAclParam() {
		super();
	}
	 
	/**
	 * @return subjectType 主体类型（0 角色）
	 */
	public Integer getSubjectType(){
		return this.subjectType;
	}
	/**
	 * @param subjectType 主体类型（0 角色）
	 */
	public void setSubjectType(Integer subjectType){
		this.subjectType = subjectType;
	}
	/**
	 * @return subjectCode 主体代码
	 */
	public String getSubjectCode(){
		return this.subjectCode;
	}
	/**
	 * @param subjectCode 主体代码
	 */
	public void setSubjectCode(String subjectCode){
		this.subjectCode = subjectCode;
	}
	/**
	 * @return resourceType 资源类型（0 模块、1 操作）
	 */
	public Integer getResourceType(){
		return this.resourceType;
	}
	/**
	 * @param resourceType 资源类型（0 模块、1 操作）
	 */
	public void setResourceType(Integer resourceType){
		this.resourceType = resourceType;
	}
	/**
	 * @return resourceCode 资源代码
	 */
	public String getResourceCode(){
		return this.resourceCode;
	}
	/**
	 * @param resourceCode 资源代码
	 */
	public void setResourceCode(String resourceCode){
		this.resourceCode = resourceCode;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("subjectType",getSubjectType())
			.append("subjectCode",getSubjectCode())
			.append("resourceType",getResourceType())
			.append("resourceCode",getResourceCode())
			.append("creator",getCreator())
			.append("createDate",getCreateDate())
			.append("lastModifier",getLastModifier())
			.append("lastModDate",getLastModDate())
			.append("status",getStatus())
			.toString();
	}
	
}
