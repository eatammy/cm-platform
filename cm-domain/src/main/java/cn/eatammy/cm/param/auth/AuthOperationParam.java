/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2016-2016 郭旭辉-詹晓锋. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：权限操作表											
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

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import cn.eatammy.common.param.CreateBaseParam;

import java.util.*;

/**
 * 《权限操作》 查询参数实体
 * @author 郭旭辉
 *
 */
public class AuthOperationParam extends CreateBaseParam<Long> {
	private static final long serialVersionUID = 1L;
	
	/**
	*字段常量——操作代码（java 生成uuid格式不要横线）
	*/
	public static final String F_Code="code";
	/**
	*字段常量——操作名称
	*/
	public static final String F_Name="name";
	/**
	*字段常量——所属模块
	*/
	public static final String F_ModuleCode="moduleCode";
	/**
	*字段常量——权限代码，在访问时根据权限代码判断是否有权限，同一个菜单下权限代码不能重复
	*/
	public static final String F_AuthCode="authCode";
	
	private String code; //操作代码（java 生成uuid格式不要横线）
	private String name; //操作名称
	private String moduleCode; //所属模块
	private String authCode; //权限代码，在访问时根据权限代码判断是否有权限，同一个菜单下权限代码不能重复
    
	/**
	 *默认空构造函数
	 */
	public AuthOperationParam() {
		super();
	}
	 
	/**
	 * @return code 操作代码（java 生成uuid格式不要横线）
	 */
	public String getCode(){
		return this.code;
	}
	/**
	 * @param code 操作代码（java 生成uuid格式不要横线）
	 */
	public void setCode(String code){
		this.code = code;
	}
	/**
	 * @return name 操作名称
	 */
	public String getName(){
		return this.name;
	}
	/**
	 * @param name 操作名称
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 * @return moduleCode 所属模块
	 */
	public String getModuleCode(){
		return this.moduleCode;
	}
	/**
	 * @param moduleCode 所属模块
	 */
	public void setModuleCode(String moduleCode){
		this.moduleCode = moduleCode;
	}
	/**
	 * @return authCode 权限代码，在访问时根据权限代码判断是否有权限，同一个菜单下权限代码不能重复
	 */
	public String getAuthCode(){
		return this.authCode;
	}
	/**
	 * @param authCode 权限代码，在访问时根据权限代码判断是否有权限，同一个菜单下权限代码不能重复
	 */
	public void setAuthCode(String authCode){
		this.authCode = authCode;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("code",getCode())
			.append("name",getName())
			.append("moduleCode",getModuleCode())
			.append("authCode",getAuthCode())
			.append("creator",getCreator())
			.append("createDate",getCreateDate())
			.append("lastModifier",getLastModifier())
			.append("lastModDate",getLastModDate())
			.append("status",getStatus())
			.toString();
	}
	
}
