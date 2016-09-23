/*
{*****************************************************************************
{  主平台 v1.0													
{  版权信息 (c) 2016-2016 郭旭辉-詹晓锋. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：用户行为流量监控表											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-09-02  郭旭辉        新建
{
{  ---------------------------------------------------------------------------
{*****************************************************************************
*/

package cn.eatammy.cm.domain.bi;

import cn.eatammy.common.domain.BaseDomain;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 《用户行为流量监控》 实体
 * @author 郭旭辉
 *
 */
public class UserFlow extends BaseDomain<Long> {
	private static final long serialVersionUID = 1L;

	private String uid; //事件触发用户uid
	private Integer eventType; //事件，1：登陆，2：注册
	private String eventValue; //值，1：login，2：register
	private Long createTime; //创建时间
	private Integer deviceType; //访问设备类型，0：pc，1：手机，2：平板
	private String deviceName; //访问设备名称

	/**
	 *默认空构造函数
	 */
	public UserFlow() {
		super();
	}

	/**
	 * @return uid 事件触发用户uid
	 */
	public String getUid(){
		return this.uid;
	}
	/**
	 * @param uid 事件触发用户uid
	 */
	public void setUid(String uid){
		this.uid = uid;
	}
	/**
	 * @return eventType 事件，1：登陆，2：注册
	 */
	public Integer getEventType(){
		return this.eventType;
	}
	/**
	 * @param eventType 事件，1：登陆，2：注册
	 */
	public void setEventType(Integer eventType){
		this.eventType = eventType;
	}
	/**
	 * @return eventValue 值，1：login，2：register
	 */
	public String getEventValue(){
		return this.eventValue;
	}
	/**
	 * @param eventValue 值，1：login，2：register
	 */
	public void setEventValue(String eventValue){
		this.eventValue = eventValue;
	}
	/**
	 * @return createTime 创建时间
	 */
	public Long getCreateTime(){
		return this.createTime;
	}
	/**
	 * @param createTime 创建时间
	 */
	public void setCreateTime(Long createTime){
		this.createTime = createTime;
	}
	/**
	 * @return deviceType 访问设备类型，0：pc，1：手机，2：平板
	 */
	public Integer getDeviceType(){
		return this.deviceType;
	}
	/**
	 * @param deviceType 访问设备类型，0：pc，1：手机，2：平板
	 */
	public void setDeviceType(Integer deviceType){
		this.deviceType = deviceType;
	}
	/**
	 * @return deviceName 访问设备名称
	 */
	public String getDeviceName(){
		return this.deviceName;
	}
	/**
	 * @param deviceName 访问设备名称
	 */
	public void setDeviceName(String deviceName){
		this.deviceName = deviceName;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
				.append("id",getId())
				.append("uid",getUid())
				.append("eventType",getEventType())
				.append("eventValue",getEventValue())
				.append("createTime",getCreateTime())
				.append("deviceType",getDeviceType())
				.append("deviceName",getDeviceName())
				.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder()
				.append(getId())
				.append(getUid())
				.append(getEventType())
				.append(getEventValue())
				.append(getCreateTime())
				.append(getDeviceType())
				.append(getDeviceName())
				.toHashCode();
	}

	public boolean equals(Object obj) {
		if(obj instanceof UserFlow == false) return false;
		if(this == obj) return true;
		UserFlow other = (UserFlow)obj;
		return new EqualsBuilder()
				.append(getId(),other.getId())
				.isEquals();
	}
}