/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：活动消费表											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-05-18  郭旭辉        新建	
{ 	                                                                     
{  ---------------------------------------------------------------------------
{  注：本模块代码由codgen代码生成工具辅助生成 http://www.oschina.net/p/codgen	
{*****************************************************************************	
*/

package cn.eatammy.cm.param.activity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import cn.eatammy.common.param.CreateBaseParam;

import java.util.*;

/**
 * 《活动消费》 查询参数实体
 * @author 郭旭辉
 *
 */
public class ActivityConsumeParam extends CreateBaseParam<Long> {
	private static final long serialVersionUID = 1L;
	
	/**
	*字段常量——商城活动主键
	*/
	public static final String F_BActId="bActId";
	/**
	*字段常量——消费者uid，多人以“，”分隔
	*/
	public static final String F_Consumers="consumers";
	/**
	*字段常量——参与人数
	*/
	public static final String F_Participants="participants";
	
	private Long bActId; //商城活动主键
	private String consumers; //消费者uid，多人以“，”分隔
	private Integer participants; //参与人数
    
	/**
	 *默认空构造函数
	 */
	public ActivityConsumeParam() {
		super();
	}
	 
	/**
	 * @return bActId 商城活动主键
	 */
	public Long getBActId(){
		return this.bActId;
	}
	/**
	 * @param bActId 商城活动主键
	 */
	public void setBActId(Long bActId){
		this.bActId = bActId;
	}
	/**
	 * @return consumers 消费者uid，多人以“，”分隔
	 */
	public String getConsumers(){
		return this.consumers;
	}
	/**
	 * @param consumers 消费者uid，多人以“，”分隔
	 */
	public void setConsumers(String consumers){
		this.consumers = consumers;
	}
	/**
	 * @return participants 参与人数
	 */
	public Integer getParticipants(){
		return this.participants;
	}
	/**
	 * @param participants 参与人数
	 */
	public void setParticipants(Integer participants){
		this.participants = participants;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("bActId",getBActId())
			.append("consumers",getConsumers())
			.append("participants",getParticipants())
			.append("creator",getCreator())
			.append("createDate",getCreateDate())
			.append("lastModifier",getLastModifier())
			.append("lastModDate",getLastModDate())
			.append("status",getStatus())
			.toString();
	}
	
}
