/*
{*****************************************************************************
{  主平台 v1.0													
{  版权信息 (c) 2016-2016 郭旭辉-詹晓锋. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：商务流量表（cm_bi_business_flow）											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-09-01  郭旭辉        新建	
{ 	                                                                     
{  ---------------------------------------------------------------------------
{*****************************************************************************	
*/

package cn.eatammy.cm.param.bi;

import cn.eatammy.common.param.BaseParam;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 《商务流量表（cm_bi_business_flow）》 查询参数实体
 * @author 郭旭辉
 *
 */
public class BusinessFlowParam extends BaseParam<Long> {
	private static final long serialVersionUID = 1L;

	/**
	 *字段常量——操作者类型，0：系统用户，1：游客
	 */
	public static final String F_OperatorType="operatorType";
	/**
	 *字段常量——目标对象类型,0:商店,1:商品
	 */
	public static final String F_TargetType="targetType";
	/**
	 *字段常量——targetCode
	 */
	public static final String F_TargetCode="targetCode";
	/**
	 *字段常量——创建时间
	 */
	public static final String F_CreateTime="createTime";
	/**
	 *字段常量——停留时间
	 */
	public static final String F_DuringTime="duringTime";
	/**
	 *字段常量——事件类型，0：点击，1：购买，2：加入购物车
	 */
	public static final String F_EventType="eventType";
	/**
	 *字段常量——事件值，0：click，1：buy，2：shopcart
	 */
	public static final String F_EventValue="eventValue";

	private Integer operatorType; //操作者类型，0：系统用户，1：游客
	private Integer targetType; //目标对象类型,0:商店,1:商品
	private String targetCode; //targetCode
	private Long createTime; //创建时间
	private Integer duringTime; //停留时间
	private Integer eventType; //事件类型，0：点击，1：购买，2：加入购物车
	private String eventValue; //事件值，0：click，1：buy，2：shopcart

	/**
	 *默认空构造函数
	 */
	public BusinessFlowParam() {
		super();
	}

	/**
	 * @return operatorType 操作者类型，0：系统用户，1：游客
	 */
	public Integer getOperatorType(){
		return this.operatorType;
	}
	/**
	 * @param operatorType 操作者类型，0：系统用户，1：游客
	 */
	public void setOperatorType(Integer operatorType){
		this.operatorType = operatorType;
	}
	/**
	 * @return targetType 目标对象类型,0:商店,1:商品
	 */
	public Integer getTargetType(){
		return this.targetType;
	}
	/**
	 * @param targetType 目标对象类型,0:商店,1:商品
	 */
	public void setTargetType(Integer targetType){
		this.targetType = targetType;
	}
	/**
	 * @return targetCode targetCode
	 */
	public String getTargetCode(){
		return this.targetCode;
	}
	/**
	 * @param targetCode targetCode
	 */
	public void setTargetCode(String targetCode){
		this.targetCode = targetCode;
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
	 * @return duringTime 停留时间
	 */
	public Integer getDuringTime(){
		return this.duringTime;
	}
	/**
	 * @param duringTime 停留时间
	 */
	public void setDuringTime(Integer duringTime){
		this.duringTime = duringTime;
	}
	/**
	 * @return eventType 事件类型，0：点击，1：购买，2：加入购物车
	 */
	public Integer getEventType(){
		return this.eventType;
	}
	/**
	 * @param eventType 事件类型，0：点击，1：购买，2：加入购物车
	 */
	public void setEventType(Integer eventType){
		this.eventType = eventType;
	}
	/**
	 * @return eventValue 事件值，0：click，1：buy，2：shopcart
	 */
	public String getEventValue(){
		return this.eventValue;
	}
	/**
	 * @param eventValue 事件值，0：click，1：buy，2：shopcart
	 */
	public void setEventValue(String eventValue){
		this.eventValue = eventValue;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
				.append("id",getId())
				.append("operatorType",getOperatorType())
				.append("targetType",getTargetType())
				.append("targetCode",getTargetCode())
				.append("createTime",getCreateTime())
				.append("duringTime",getDuringTime())
				.append("eventType",getEventType())
				.append("eventValue",getEventValue())
				.toString();
	}

}