/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：用户地址表											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-03-23  郭旭辉        新建	
{ 	                                                                     
{  ---------------------------------------------------------------------------
{  注：本模块代码由codgen代码生成工具辅助生成 http://www.oschina.net/p/codgen	
{*****************************************************************************	
*/

package cn.eatammy.cm.domain.user;

import cn.eatammy.common.domain.CMCreateBaseDomain;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 《用户地址》 实体
 * @author 郭旭辉
 *
 */
public class UserAddress extends CMCreateBaseDomain<Long> {
	private static final long serialVersionUID = 1L;
	
	private String province; //省名称
	private String city; //城市名称
	private String town; //区县名称
	private String detail; //详细地区地址
	private Long uid; //用户主键id
    
	/**
	 *默认空构造函数
	 */
	public UserAddress() {
		super();
	}
	 
	/**
	 * @return province 省名称
	 */
	public String getProvince(){
		return this.province;
	}
	/**
	 * @param province 省名称
	 */
	public void setProvince(String province){
		this.province = province;
	}
	/**
	 * @return city 城市名称
	 */
	public String getCity(){
		return this.city;
	}
	/**
	 * @param city 城市名称
	 */
	public void setCity(String city){
		this.city = city;
	}
	/**
	 * @return town 区县名称
	 */
	public String getTown(){
		return this.town;
	}
	/**
	 * @param town 区县名称
	 */
	public void setTown(String town){
		this.town = town;
	}
	/**
	 * @return detail 详细地区地址
	 */
	public String getDetail(){
		return this.detail;
	}
	/**
	 * @param detail 详细地区地址
	 */
	public void setDetail(String detail){
		this.detail = detail;
	}
	/**
	 * @return uid 用户主键id
	 */
	public Long getUid(){
		return this.uid;
	}
	/**
	 * @param uid 用户主键id
	 */
	public void setUid(Long uid){
		this.uid = uid;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("province",getProvince())
			.append("city",getCity())
			.append("town",getTown())
			.append("detail",getDetail())
			.append("uid",getUid())
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
			.append(getProvince())
			.append(getCity())
			.append(getTown())
			.append(getDetail())
			.append(getUid())
			.append(getStatus())
			.append(getCreator())
			.append(getCreateDate())
			.append(getLastModifier())
			.append(getLastModDate())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof UserAddress == false) return false;
		if(this == obj) return true;
		UserAddress other = (UserAddress)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}
