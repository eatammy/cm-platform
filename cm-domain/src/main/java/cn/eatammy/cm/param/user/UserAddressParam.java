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
{  2016-03-14  郭旭辉        新建	
{ 	                                                                     
{  ---------------------------------------------------------------------------
{  注：本模块代码由codgen代码生成工具辅助生成 http://www.oschina.net/p/codgen	
{*****************************************************************************	
*/

package cn.eatammy.cm.param.user;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import cn.eatammy.common.param.CreateBaseParam;

import java.util.*;

/**
 * 《用户地址》 查询参数实体
 * @author 郭旭辉
 *
 */
public class UserAddressParam extends CreateBaseParam<Long> {
	private static final long serialVersionUID = 1L;
	
	/**
	*字段常量——省名称
	*/
	public static final String F_Province="province";
	/**
	*字段常量——城市名称
	*/
	public static final String F_City="city";
	/**
	*字段常量——区县名称
	*/
	public static final String F_Town="town";
	/**
	*字段常量——详细地区地址
	*/
	public static final String F_Detail="detail";
	/**
	*字段常量——用户主键id
	*/
	public static final String F_Uid="uid";
	/**
	*字段常量——地址状态，0：有效，1：无效
	*/
	public static final String F_State="state";
	
	private String province; //省名称
	private String city; //城市名称
	private String town; //区县名称
	private String detail; //详细地区地址
	private Long uid; //用户主键id
	private Boolean state; //地址状态，0：有效，1：无效
    
	/**
	 *默认空构造函数
	 */
	public UserAddressParam() {
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
	/**
	 * @return state 地址状态，0：有效，1：无效
	 */
	public Boolean getState(){
		return this.state;
	}
	/**
	 * @param state 地址状态，0：有效，1：无效
	 */
	public void setState(Boolean state){
		this.state = state;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("province",getProvince())
			.append("city",getCity())
			.append("town",getTown())
			.append("detail",getDetail())
			.append("uid",getUid())
			.append("state",getState())
			.append("creator",getCreator())
			.append("createDate",getCreateDate())
			.append("lastModifier",getLastModifier())
			.append("lastModDate",getLastModDate())
			.toString();
	}
	
}
