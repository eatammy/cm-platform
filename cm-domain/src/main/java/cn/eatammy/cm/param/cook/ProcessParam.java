/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：食谱制作步骤表											
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

package cn.eatammy.cm.param.cook;

import cn.eatammy.common.param.CreateBaseParam;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 《食谱制作步骤》 查询参数实体
 * @author 郭旭辉
 *
 */
public class ProcessParam extends CreateBaseParam<Long> {
	private static final long serialVersionUID = 1L;
	
	/**
	*字段常量——步骤图片url，以''，"隔开
	*/
	public static final String F_ProcessUrl="processUrl";
	/**
	*字段常量——步骤集合，"，"隔开
	*/
	public static final String F_Process="process";
	
	private String processUrl; //步骤图片url，以''，"隔开
	private String process; //步骤集合，"，"隔开
    
	/**
	 *默认空构造函数
	 */
	public ProcessParam() {
		super();
	}
	 
	/**
	 * @return processUrl 步骤图片url，以''，"隔开
	 */
	public String getProcessUrl(){
		return this.processUrl;
	}
	/**
	 * @param processUrl 步骤图片url，以''，"隔开
	 */
	public void setProcessUrl(String processUrl){
		this.processUrl = processUrl;
	}
	/**
	 * @return process 步骤集合，"，"隔开
	 */
	public String getProcess(){
		return this.process;
	}
	/**
	 * @param process 步骤集合，"，"隔开
	 */
	public void setProcess(String process){
		this.process = process;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("processUrl",getProcessUrl())
			.append("process",getProcess())
			.append("createDate",getCreateDate())
			.append("creator",getCreator())
			.append("lastModDate",getLastModDate())
			.append("lastModifier",getLastModifier())
			.append("status",getStatus())
			.toString();
	}
	
}
