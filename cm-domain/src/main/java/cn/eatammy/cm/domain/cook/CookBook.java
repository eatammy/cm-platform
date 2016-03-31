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
{  2016-03-31  郭旭辉        新建	
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
	
	private String cookBookName; //菜谱名称
	private String description; //菜谱简介
	private Long materialId; //materialId
	private Long processId; //过程表主键
	private Long categoryId; //菜谱所属类别主键
	private String tips; //贴士
	private Integer praise; //点赞数，默认为0
	private Integer comment; //评论数，默认为0
	private Long uid; //用户主键
    
	/**
	 *默认空构造函数
	 */
	public CookBook() {
		super();
	}
	 
	/**
	 * @return cookBookName 菜谱名称
	 */
	public String getCookBookName(){
		return this.cookBookName;
	}
	/**
	 * @param cookBookName 菜谱名称
	 */
	public void setCookBookName(String cookBookName){
		this.cookBookName = cookBookName;
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
	 * @return materialId materialId
	 */
	public Long getMaterialId(){
		return this.materialId;
	}
	/**
	 * @param materialId materialId
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
	 * @return uid 用户主键
	 */
	public Long getUid(){
		return this.uid;
	}
	/**
	 * @param uid 用户主键
	 */
	public void setUid(Long uid){
		this.uid = uid;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("cookBookName",getCookBookName())
			.append("description",getDescription())
			.append("materialId",getMaterialId())
			.append("processId",getProcessId())
			.append("categoryId",getCategoryId())
			.append("tips",getTips())
			.append("praise",getPraise())
			.append("comment",getComment())
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
			.append(getCookBookName())
			.append(getDescription())
			.append(getMaterialId())
			.append(getProcessId())
			.append(getCategoryId())
			.append(getTips())
			.append(getPraise())
			.append(getComment())
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
