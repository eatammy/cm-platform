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

package cn.eatammy.cm.param.auth;

import cn.eatammy.common.param.CreateBaseParam;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 《模块》 查询参数实体
 * @author 郭旭辉
 *
 */
public class AuthModuleParam extends CreateBaseParam<Long> {
	private static final long serialVersionUID = 1L;

	/**
	 *字段常量——模块代码（java 生成uuid格式不要横线）
	 */
	public static final String F_Code="code";
	/**
	 *字段常量——模块名称
	 */
	public static final String F_Name="name";
	/**
	 *字段常量——根节点code
	 */
	public static final String F_PCode="pCode";
	/**
	 *字段常量——父id（根0）
	 */
	public static final String F_PId="pId";
	/**
	 *字段常量——模块地址
	 */
	public static final String F_Url="url";
	/**
	 *字段常量——模块图标
	 */
	public static final String F_Icon="icon";
	/**
	 *字段常量——是否菜单，0：否，1：是
	 */
	public static final String F_IsMenu="isMenu";
	/**
	 *字段常量——模块层级
	 */
	public static final String F_Level="level";
	/**
	 *字段常量——模块全代码，以“.”号分隔，示例 code.code
	 */
	public static final String F_FullCode="fullCode";
	/**
	 *字段常量——模块全名称，连接符每个系统自己定义
	 */
	public static final String F_FullName="fullName";
	/**
	 *字段常量——排序字段
	 */
	public static final String F_Priority="priority";

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
	public AuthModuleParam() {
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

}