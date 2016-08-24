/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2016-2016 郭旭辉-詹晓锋. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：模块表											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-08-13  郭旭辉        新建
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
 * 《模块》 实体
 * @author 郭旭辉
 *
 */
public class AuthModule extends CMCreateBaseDomain<Long> {
	private static final long serialVersionUID = 1L;

	private String code; //模块代码（java 生成uuid格式不要横线）
	private String name; //模块名称
	private String pCode; //根节点code
	private Long pId; //父id（根0）
	private String url; //模块地址
	private String icon; //模块图标
	private Boolean isMenu; //是否菜单，0：否，1：是
	private Integer level; //模块层级
	private String fullCode; //模块全代码，以“.”号分隔，示例 code.code
	private String fullName; //模块全名称，连接符每个系统自己定义
	private Integer priority; //排序字段

	/**
	 *默认空构造函数
	 */
	public AuthModule() {
		super();
	}

	/**
	 * @return code 模块代码（java 生成uuid格式不要横线）
	 */
	public String getCode(){
		return this.code;
	}
	/**
	 * @param code 模块代码（java 生成uuid格式不要横线）
	 */
	public void setCode(String code){
		this.code = code;
	}
	/**
	 * @return name 模块名称
	 */
	public String getName(){
		return this.name;
	}
	/**
	 * @param name 模块名称
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 * @return pCode 根节点code
	 */
	public String getPCode(){
		return this.pCode;
	}
	/**
	 * @param pCode 根节点code
	 */
	public void setPCode(String pCode){
		this.pCode = pCode;
	}
	/**
	 * @return pId 父id（根0）
	 */
	public Long getPId(){
		return this.pId;
	}
	/**
	 * @param pId 父id（根0）
	 */
	public void setPId(Long pId){
		this.pId = pId;
	}
	/**
	 * @return url 模块地址
	 */
	public String getUrl(){
		return this.url;
	}
	/**
	 * @param url 模块地址
	 */
	public void setUrl(String url){
		this.url = url;
	}
	/**
	 * @return icon 模块图标
	 */
	public String getIcon(){
		return this.icon;
	}
	/**
	 * @param icon 模块图标
	 */
	public void setIcon(String icon){
		this.icon = icon;
	}
	/**
	 * @return isMenu 是否菜单，0：否，1：是
	 */
	public Boolean getIsMenu(){
		return this.isMenu;
	}
	/**
	 * @param isMenu 是否菜单，0：否，1：是
	 */
	public void setIsMenu(Boolean isMenu){
		this.isMenu = isMenu;
	}
	/**
	 * @return level 模块层级
	 */
	public Integer getLevel(){
		return this.level;
	}
	/**
	 * @param level 模块层级
	 */
	public void setLevel(Integer level){
		this.level = level;
	}
	/**
	 * @return fullCode 模块全代码，以“.”号分隔，示例 code.code
	 */
	public String getFullCode(){
		return this.fullCode;
	}
	/**
	 * @param fullCode 模块全代码，以“.”号分隔，示例 code.code
	 */
	public void setFullCode(String fullCode){
		this.fullCode = fullCode;
	}
	/**
	 * @return fullName 模块全名称，连接符每个系统自己定义
	 */
	public String getFullName(){
		return this.fullName;
	}
	/**
	 * @param fullName 模块全名称，连接符每个系统自己定义
	 */
	public void setFullName(String fullName){
		this.fullName = fullName;
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
				.append("code",getCode())
				.append("name",getName())
				.append("pCode",getPCode())
				.append("pId",getPId())
				.append("url",getUrl())
				.append("icon",getIcon())
				.append("isMenu",getIsMenu())
				.append("level",getLevel())
				.append("fullCode",getFullCode())
				.append("fullName",getFullName())
				.append("priority",getPriority())
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
				.append(getCode())
				.append(getName())
				.append(getPCode())
				.append(getPId())
				.append(getUrl())
				.append(getIcon())
				.append(getIsMenu())
				.append(getLevel())
				.append(getFullCode())
				.append(getFullName())
				.append(getPriority())
				.append(getCreator())
				.append(getCreateDate())
				.append(getLastModifier())
				.append(getLastModDate())
				.append(getStatus())
				.toHashCode();
	}

	public boolean equals(Object obj) {
		if(obj instanceof AuthModule == false) return false;
		if(this == obj) return true;
		AuthModule other = (AuthModule)obj;
		return new EqualsBuilder()
				.append(getId(),other.getId())
				.isEquals();
	}
}