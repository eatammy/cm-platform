/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：商品信息表											
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

package cn.eatammy.cm.param.business;

/**
 * 《商品信息》 查询参数实体
 * @author 郭旭辉
 *
 */
public class GoodsParamEx extends GoodsParam {
	private static final long serialVersionUID = 1L;

	private Float plow;
	private Float phigh;
	//针对GoodsParam实体在这里增加额外的属性和对应的get和set方法


	public float getPlow() {
		return plow;
	}

	public void setPlow(Float plow) {
		this.plow = plow;
	}

	public float getPhigh() {
		return phigh;
	}

	public void setPhigh(Float phigh) {
		this.phigh = phigh;
	}
}