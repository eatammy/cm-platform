/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：菜谱											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-04-28  郭旭辉        新建	
{ 	                                                                     
{  ---------------------------------------------------------------------------
{  注：本模块代码由codgen代码生成工具辅助生成 http://www.oschina.net/p/codgen	
{*****************************************************************************	
*/

package cn.eatammy.cm.domain.cook;

import cn.eatammy.common.domain.CMCreateBaseDomain;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 《菜谱》 实体
 * @author 郭旭辉
 *
 */
public class CookBook extends CMCreateBaseDomain<Long> {
	private static final long serialVersionUID = 1L;
	
	private String name; //食谱名称
	private String description; //菜谱简介
	private Long materialId; //原材料表主键
	private Long processId; //过程表主键
	private Long categoryId; //菜谱所属类别主键
	private String tips; //贴士
	private Integer praise; //点赞数，默认为0
	private Integer comment; //评论数，默认为0
	private String code; //食谱code
	private String uid; //uid,用户code
    
	/**
	 *默认空构造函数
	 */
	public CookBook() {
		super();
	}
	 
	/**
	 * @return name 食谱名称
	 */
	public String getName(){
		return this.name;
	}
	/**
	 * @param name 食谱名称
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 * @return description 菜谱简介
	 */
	public String getDescription(){
		return this.description;
	}
	/**
	 * @param description 菜谱简介
	 */
	public void setDescription(String description){
		this.description = description;
	}
	/**
	 * @return materialId 原材料表主键
	 */
	public Long getMaterialId(){
		return this.materialId;
	}
	/**
	 * @param materialId 原材料表主键
	 */
	public void setMaterialId(Long materialId){
		this.materialId = materialId;
	}
	/**
	 * @return processId 过程表主键
	 */
	public Long getProcessId(){
		return this.processId;
	}
	/**
	 * @param processId 过程表主键
	 */
	public void setProcessId(Long processId){
		this.processId = processId;
	}
	/**
	 * @return categoryId 菜谱所属类别主键
	 */
	public Long getCategoryId(){
		return this.categoryId;
	}
	/**
	 * @param categoryId 菜谱所属类别主键
	 */
	public void setCategoryId(Long categoryId){
		this.categoryId = categoryId;
	}
	/**
	 * @return tips 贴士
	 */
	public String getTips(){
		return this.tips;
	}
	/**
	 * @param tips 贴士
	 */
	public void setTips(String tips){
		this.tips = tips;
	}
	/**
	 * @return praise 点赞数，默认为0
	 */
	public Integer getPraise(){
		return this.praise;
	}
	/**
	 * @param praise 点赞数，默认为0
	 */
	public void setPraise(Integer praise){
		this.praise = praise;
	}
	/**
	 * @return comment 评论数，默认为0
	 */
	public Integer getComment(){
		return this.comment;
	}
	/**
	 * @param comment 评论数，默认为0
	 */
	public void setComment(Integer comment){
		this.comment = comment;
	}
	/**
	 * @return code 食谱code
	 */
	public String getCode(){
		return this.code;
	}
	/**
	 * @param code 食谱code
	 */
	public void setCode(String code){
		this.code = code;
	}
	/**
	 * @return uid uid,用户code
	 */
	public String getUid(){
		return this.uid;
	}
	/**
	 * @param uid uid,用户code
	 */
	public void setUid(String uid){
		this.uid = uid;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("name",getName())
			.append("description",getDescription())
			.append("materialId",getMaterialId())
			.append("processId",getProcessId())
			.append("categoryId",getCategoryId())
			.append("tips",getTips())
			.append("praise",getPraise())
			.append("comment",getComment())
			.append("code",getCode())
			.append("uid",getUid())
			.append("createDate",getCreateDate())
			.append("creator",getCreator())
			.append("lastModDate",getLastModDate())
			.append("lastModifier",getLastModifier())
			.append("status",getStatus())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getName())
			.append(getDescription())
			.append(getMaterialId())
			.append(getProcessId())
			.append(getCategoryId())
			.append(getTips())
			.append(getPraise())
			.append(getComment())
			.append(getCode())
			.append(getUid())
			.append(getCreateDate())
			.append(getCreator())
			.append(getLastModDate())
			.append(getLastModifier())
			.append(getStatus())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof CookBook == false) return false;
		if(this == obj) return true;
		CookBook other = (CookBook)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}
