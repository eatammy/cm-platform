/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：订单											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-06-13  郭旭辉        新建	
{ 	                                                                     
{  ---------------------------------------------------------------------------
{  注：本模块代码由codgen代码生成工具辅助生成 http://www.oschina.net/p/codgen	
{*****************************************************************************	
*/

package cn.eatammy.cm.domain.business;

import cn.eatammy.common.domain.CMCreateBaseDomain;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 《订单》 实体
 * @author 郭旭辉
 *
 */
public class Indent extends CMCreateBaseDomain<Long> {
	private static final long serialVersionUID = 1L;
	
	private Long uid; //用户id
	private Long serialNumber; //订单流水号
	private String address; //订单地址
	private Float total; //总额
	private Integer isTraded; //是否完成交易，0：未完成，1：完成
    
	/**
	 *默认空构造函数
	 */
	public Indent() {
		super();
	}
	 
	/**
	 * @return uid 用户id
	 */
	public Long getUid(){
		return this.uid;
	}
	/**
	 * @param uid 用户id
	 */
	public void setUid(Long uid){
		this.uid = uid;
	}
	/**
	 * @return serialNumber 订单流水号
	 */
	public Long getSerialNumber(){
		return this.serialNumber;
	}
	/**
	 * @param serialNumber 订单流水号
	 */
	public void setSerialNumber(Long serialNumber){
		this.serialNumber = serialNumber;
	}
	/**
	 * @return address 订单地址
	 */
	public String getAddress(){
		return this.address;
	}
	/**
	 * @param address 订单地址
	 */
	public void setAddress(String address){
		this.address = address;
	}
	/**
	 * @return total 总额
	 */
	public Float getTotal(){
		return this.total;
	}
	/**
	 * @param total 总额
	 */
	public void setTotal(Float total){
		this.total = total;
	}
	/**
	 * @return isTraded 是否完成交易，0：未完成，1：完成
	 */
	public Integer getIsTraded(){
		return this.isTraded;
	}
	/**
	 * @param isTraded 是否完成交易，0：未完成，1：完成
	 */
	public void setIsTraded(Integer isTraded){
		this.isTraded = isTraded;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("uid",getUid())
			.append("serialNumber",getSerialNumber())
			.append("address",getAddress())
			.append("total",getTotal())
			.append("isTraded",getIsTraded())
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
			.append(getUid())
			.append(getSerialNumber())
			.append(getAddress())
			.append(getTotal())
			.append(getIsTraded())
			.append(getCreator())
			.append(getCreateDate())
			.append(getLastModifier())
			.append(getLastModDate())
			.append(getStatus())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Indent == false) return false;
		if(this == obj) return true;
		Indent other = (Indent)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}
