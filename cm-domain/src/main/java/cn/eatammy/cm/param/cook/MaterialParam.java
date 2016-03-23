/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：食谱原材料表											
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
 * 《食谱原材料》 查询参数实体
 * @author 郭旭辉
 *
 */
public class MaterialParam extends CreateBaseParam<Long> {
	private static final long serialVersionUID = 1L;
	
	/**
	*字段常量——原材料名称，名称以'，'隔开
	*/
	public static final String F_MaterialNames="materialNames";
	/**
	*字段常量——用量，以‘，’隔开
	*/
	public static final String F_Dosage="dosage";
	
	private String materialNames; //原材料名称，名称以'，'隔开
	private String dosage; //用量，以‘，’隔开
    
	/**
	 *默认空构造函数
	 */
	public MaterialParam() {
		super();
	}
	 
	/**
	 * @return materialNames 原材料名称，名称以'，'隔开
	 */
	public String getMaterialNames(){
		return this.materialNames;
	}
	/**
	 * @param materialNames 原材料名称，名称以'，'隔开
	 */
	public void setMaterialNames(String materialNames){
		this.materialNames = materialNames;
	}
	/**
	 * @return dosage 用量，以‘，’隔开
	 */
	public String getDosage(){
		return this.dosage;
	}
	/**
	 * @param dosage 用量，以‘，’隔开
	 */
	public void setDosage(String dosage){
		this.dosage = dosage;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("materialNames",getMaterialNames())
			.append("dosage",getDosage())
			.append("createDate",getCreateDate())
			.append("creator",getCreator())
			.append("lastModDate",getLastModDate())
			.append("lastModifier",getLastModifier())
			.append("status",getStatus())
			.toString();
	}
	
}
