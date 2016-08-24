/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2016-2016 郭旭辉-詹晓锋. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：权限角色表											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-08-15  郭旭辉        新建
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
 * 《权限角色》 实体
 * @author 郭旭辉
 *
 */
public class AuthRole extends CMCreateBaseDomain<Long> {
	private static final long serialVersionUID = 1L;

	private String code; //角色代码(java生成uuid格式不要横线)
	private String name; //角色名称
	private Boolean isSuper; //是否拥有所属系统的所有权限，默认为否
	private Boolean isDefault; //是否为默认角色（一个系统只能有一个），默认为否
	private String description; //描述
	private String lastModifer; //修改人

	/**
	 *默认空构造函数
	 */
	public AuthRole() {
		super();
	}

	/**
	 * @return code 角色代码(java生成uuid格式不要横线)
	 */
	public String getCode(){
		return this.code;
	}
	/**
	 * @param code 角色代码(java生成uuid格式不要横线)
	 */
	public void setCode(String code){
		this.code = code;
	}
	/**
	 * @return name 角色名称
	 */
	public String getName(){
		return this.name;
	}
	/**
	 * @param name 角色名称
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 * @return isSuper 是否拥有所属系统的所有权限，默认为否
	 */
	public Boolean getIsSuper(){
		return this.isSuper;
	}
	/**
	 * @param isSuper 是否拥有所属系统的所有权限，默认为否
	 */
	public void setIsSuper(Boolean isSuper){
		this.isSuper = isSuper;
	}
	/**
	 * @return isDefault 是否为默认角色（一个系统只能有一个），默认为否
	 */
	public Boolean getIsDefault(){
		return this.isDefault;
	}
	/**
	 * @param isDefault 是否为默认角色（一个系统只能有一个），默认为否
	 */
	public void setIsDefault(Boolean isDefault){
		this.isDefault = isDefault;
	}
	/**
	 * @return description 描述
	 */
	public String getDescription(){
		return this.description;
	}
	/**
	 * @param description 描述
	 */
	public void setDescription(String description){
		this.description = description;
	}
	/**
	 * @return lastModifer 修改人
	 */
	public String getLastModifer(){
		return this.lastModifer;
	}
	/**
	 * @param lastModifer 修改人
	 */
	public void setLastModifer(String lastModifer){
		this.lastModifer = lastModifer;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
				.append("id",getId())
				.append("code",getCode())
				.append("name",getName())
				.append("isSuper",getIsSuper())
				.append("isDefault",getIsDefault())
				.append("description",getDescription())
				.append("creator",getCreator())
				.append("createDate",getCreateDate())
				.append("lastModifer",getLastModifer())
				.append("lastModDate",getLastModDate())
				.append("status",getStatus())
				.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder()
				.append(getId())
				.append(getCode())
				.append(getName())
				.append(getIsSuper())
				.append(getIsDefault())
				.append(getDescription())
				.append(getCreator())
				.append(getCreateDate())
				.append(getLastModifer())
				.append(getLastModDate())
				.append(getStatus())
				.toHashCode();
	}

	public boolean equals(Object obj) {
		if(obj instanceof AuthRole == false) return false;
		if(this == obj) return true;
		AuthRole other = (AuthRole)obj;
		return new EqualsBuilder()
				.append(getId(),other.getId())
				.isEquals();
	}
}