/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：食谱收藏表											
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

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import cn.eatammy.common.domain.CMCreateBaseDomain;

import java.util.*;

/**
 * 《食谱收藏》 实体
 * @author 郭旭辉
 *
 */
public class CCollection extends CMCreateBaseDomain<Long> {
	private static final long serialVersionUID = 1L;
	
	private Long uid; //所属者主键
	private Long cookbookId; //食谱主键
    
	/**
	 *默认空构造函数
	 */
	public CCollection() {
		super();
	}
	 
	/**
	 * @return uid 所属者主键
	 */
	public Long getUid(){
		return this.uid;
	}
	/**
	 * @param uid 所属者主键
	 */
	public void setUid(Long uid){
		this.uid = uid;
	}
	/**
	 * @return cookbookId 食谱主键
	 */
	public Long getCookbookId(){
		return this.cookbookId;
	}
	/**
	 * @param cookbookId 食谱主键
	 */
	public void setCookbookId(Long cookbookId){
		this.cookbookId = cookbookId;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("uid",getUid())
			.append("cookbookId",getCookbookId())
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
			.append(getUid())
			.append(getCookbookId())
			.append(getCreateDate())
			.append(getCreator())
			.append(getLastModDate())
			.append(getLastModifier())
			.append(getStatus())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof CCollection == false) return false;
		if(this == obj) return true;
		CCollection other = (CCollection)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}
