/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：商家表											
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
 * 《商家》 查询参数实体
 * @author 郭旭辉
 *
 */
public class ShopParamEx extends ShopParam {
	private static final long serialVersionUID = 1L;

	private String authImg1;	//身份证正面URL
	private String authImg2;	//身份证反面URL
	private String username;	//商店账号
	//针对ShopParam实体在这里增加额外的属性和对应的get和set方法


	public String getAuthImg1() {
		return authImg1;
	}

	public void setAuthImg1(String authImg1) {
		this.authImg1 = authImg1;
	}

	public String getAuthImg2() {
		return authImg2;
	}

	public void setAuthImg2(String authImg2) {
		this.authImg2 = authImg2;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}