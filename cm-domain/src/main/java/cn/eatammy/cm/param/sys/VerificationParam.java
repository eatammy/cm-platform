/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：验证模块：注册验证，修改密码验证，商店证验证以及其他认证验证（短信验证码验证）											
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

package cn.eatammy.cm.param.sys;

import cn.eatammy.common.param.CreateBaseParam;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 《验证模块：注册验证，修改密码验证，商店证验证以及其他认证验证（短信验证码验证）》 查询参数实体
 * @author 郭旭辉
 *
 */
public class VerificationParam extends CreateBaseParam<Long> {
	private static final long serialVersionUID = 1L;
	
	/**
	*字段常量——验证码，6位数字
	*/
	public static final String F_VerifiedCode="verifiedCode";
	/**
	*字段常量——用户电话号码
	*/
	public static final String F_Phone="phone";
	/**
	*字段常量——验证码类型，1：注册验证，2：找回密码验证，4：注册商店商店验证码，
	*/
	public static final String F_Type="type";
	/**
	*字段常量——失效时间，默认失效时间为30min
	*/
	public static final String F_DisabledDate="disabledDate";
	
	private String verifiedCode; //验证码，6位数字
	private String phone; //用户电话号码
	private Integer type; //验证码类型，1：注册验证，2：找回密码验证，4：注册商店商店验证码，
	private Long disabledDate; //失效时间，默认失效时间为30min
    
	/**
	 *默认空构造函数
	 */
	public VerificationParam() {
		super();
	}
	 
	/**
	 * @return verifiedCode 验证码，6位数字
	 */
	public String getVerifiedCode(){
		return this.verifiedCode;
	}
	/**
	 * @param verifiedCode 验证码，6位数字
	 */
	public void setVerifiedCode(String verifiedCode){
		this.verifiedCode = verifiedCode;
	}
	/**
	 * @return phone 用户电话号码
	 */
	public String getPhone(){
		return this.phone;
	}
	/**
	 * @param phone 用户电话号码
	 */
	public void setPhone(String phone){
		this.phone = phone;
	}
	/**
	 * @return type 验证码类型，1：注册验证，2：找回密码验证，4：注册商店商店验证码，
	 */
	public Integer getType(){
		return this.type;
	}
	/**
	 * @param type 验证码类型，1：注册验证，2：找回密码验证，4：注册商店商店验证码，
	 */
	public void setType(Integer type){
		this.type = type;
	}
	/**
	 * @return disabledDate 失效时间，默认失效时间为30min
	 */
	public Long getDisabledDate(){
		return this.disabledDate;
	}
	/**
	 * @param disabledDate 失效时间，默认失效时间为30min
	 */
	public void setDisabledDate(Long disabledDate){
		this.disabledDate = disabledDate;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("verifiedCode",getVerifiedCode())
			.append("phone",getPhone())
			.append("type",getType())
			.append("disabledDate",getDisabledDate())
			.append("status",getStatus())
			.append("creator",getCreator())
			.append("createDate",getCreateDate())
			.append("lastModifier",getLastModifier())
			.append("lastModDate",getLastModDate())
			.toString();
	}
	
}
