/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2016-2016 郭旭辉-詹晓锋. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：用户角色表											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-08-19  郭旭辉        新建
{
{  ---------------------------------------------------------------------------
{*****************************************************************************
*/

package cn.eatammy.cm.domain.auth;

import cn.eatammy.common.domain.CMCreateBaseDomain;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 《用户角色》 实体
 * @author 郭旭辉
 *
 */
public class AuthRoleUser extends CMCreateBaseDomain<Long> {
	private static final long serialVersionUID = 1L;

	private String userCode; //用户code（用户表中的code）
	private String roleCode; //角色code（java 生成uuid格式不要横线）
	private Integer userType; //用户身份类型，1：普通用户，2：商家，4：管理员：8：超级管理员

	/**
	 *默认空构造函数
	 */
	public AuthRoleUser() {
		super();
	}

	/**
	 * @return userCode 用户code（用户表中的code）
	 */
	public String getUserCode(){
		return this.userCode;
	}
	/**
	 * @param userCode 用户code（用户表中的code）
	 */
	public void setUserCode(String userCode){
		this.userCode = userCode;
	}
	/**
	 * @return roleCode 角色code（java 生成uuid格式不要横线）
	 */
	public String getRoleCode(){
		return this.roleCode;
	}
	/**
	 * @param roleCode 角色code（java 生成uuid格式不要横线）
	 */
	public void setRoleCode(String roleCode){
		this.roleCode = roleCode;
	}
	/**
	 * @return userType 用户身份类型，1：普通用户，2：商家，4：管理员：8：超级管理员
	 */
	public Integer getUserType(){
		return this.userType;
	}
	/**
	 * @param userType 用户身份类型，1：普通用户，2：商家，4：管理员：8：超级管理员
	 */
	public void setUserType(Integer userType){
		this.userType = userType;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
				.append("id",getId())
				.append("userCode",getUserCode())
				.append("roleCode",getRoleCode())
				.append("userType",getUserType())
				.append("creator",getCreator())
				.append("createDate",getCreateDate())
				.append("lastModifier",getLastModifier())
				.append("lastModDate",getLastModDate())
				.append("status",getStatus())
				.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder()
				.append(getId())
				.append(getUserCode())
				.append(getRoleCode())
				.append(getUserType())
				.append(getCreator())
				.append(getCreateDate())
				.append(getLastModifier())
				.append(getLastModDate())
				.append(getStatus())
				.toHashCode();
	}

	public boolean equals(Object obj) {
		if(obj instanceof AuthRoleUser == false) return false;
		if(this == obj) return true;
		AuthRoleUser other = (AuthRoleUser)obj;
		return new EqualsBuilder()
				.append(getId(),other.getId())
				.isEquals();
	}
}