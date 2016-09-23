/*
{*****************************************************************************
{  主平台 v1.0
{  版权信息 (c) 2016-2016 郭旭辉-詹晓锋. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：用户表
{  功能描述:
{
{  ---------------------------------------------------------------------------
{  维护历史:
{  日期        维护人        维护类型
{  ---------------------------------------------------------------------------
{  2016-09-14  郭旭辉        新建
{
{  ---------------------------------------------------------------------------
{*****************************************************************************
*/

package cn.eatammy.cm.domain.user;

import cn.eatammy.common.domain.CMCreateBaseDomain;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 《用户》 实体
 * @author 郭旭辉
 *
 */
public class UserDetail extends CMCreateBaseDomain<Long> {
	private static final long serialVersionUID = 1L;

	private String username; //账号
	private String password; //密码
	private String phone; //电话
	private Integer province; //省代码
	private Integer city; //市代码
	private Integer town; //区县代码
	private String address; //地址
	private String nickname; //昵称
	private Integer age; //年龄
	private Integer sex; //性别,0:man,1:fumale
	private String headIcon; //头像
	private Integer funs; //粉丝数
	private Integer attentions; //关注数
	private Integer score; //积分
	private String idCard; //身份证
	private String idCardPic; //身份证图片链接
	private String description; //个性签名
	private String code; //用户代码，默认为UUID
	private Integer userTypes; //用户类型
	private String salt; //加密盐

	/**
	 *默认空构造函数
	 */
	public UserDetail() {
		super();
	}

	/**
	 * @return username 账号
	 */
	public String getUsername(){
		return this.username;
	}
	/**
	 * @param username 账号
	 */
	public void setUsername(String username){
		this.username = username;
	}
	/**
	 * @return password 密码
	 */
	public String getPassword(){
		return this.password;
	}
	/**
	 * @param password 密码
	 */
	public void setPassword(String password){
		this.password = password;
	}
	/**
	 * @return phone 电话
	 */
	public String getPhone(){
		return this.phone;
	}
	/**
	 * @param phone 电话
	 */
	public void setPhone(String phone){
		this.phone = phone;
	}
	/**
	 * @return province 省代码
	 */
	public Integer getProvince(){
		return this.province;
	}
	/**
	 * @param province 省代码
	 */
	public void setProvince(Integer province){
		this.province = province;
	}
	/**
	 * @return city 市代码
	 */
	public Integer getCity(){
		return this.city;
	}
	/**
	 * @param city 市代码
	 */
	public void setCity(Integer city){
		this.city = city;
	}
	/**
	 * @return town 区县代码
	 */
	public Integer getTown(){
		return this.town;
	}
	/**
	 * @param town 区县代码
	 */
	public void setTown(Integer town){
		this.town = town;
	}
	/**
	 * @return address 地址
	 */
	public String getAddress(){
		return this.address;
	}
	/**
	 * @param address 地址
	 */
	public void setAddress(String address){
		this.address = address;
	}
	/**
	 * @return nickname 昵称
	 */
	public String getNickname(){
		return this.nickname;
	}
	/**
	 * @param nickname 昵称
	 */
	public void setNickname(String nickname){
		this.nickname = nickname;
	}
	/**
	 * @return age 年龄
	 */
	public Integer getAge(){
		return this.age;
	}
	/**
	 * @param age 年龄
	 */
	public void setAge(Integer age){
		this.age = age;
	}
	/**
	 * @return sex 性别,0:man,1:fumale
	 */
	public Integer getSex(){
		return this.sex;
	}
	/**
	 * @param sex 性别,0:man,1:fumale
	 */
	public void setSex(Integer sex){
		this.sex = sex;
	}
	/**
	 * @return headIcon 头像
	 */
	public String getHeadIcon(){
		return this.headIcon;
	}
	/**
	 * @param headIcon 头像
	 */
	public void setHeadIcon(String headIcon){
		this.headIcon = headIcon;
	}
	/**
	 * @return funs 粉丝数
	 */
	public Integer getFuns(){
		return this.funs;
	}
	/**
	 * @param funs 粉丝数
	 */
	public void setFuns(Integer funs){
		this.funs = funs;
	}
	/**
	 * @return attentions 关注数
	 */
	public Integer getAttentions(){
		return this.attentions;
	}
	/**
	 * @param attentions 关注数
	 */
	public void setAttentions(Integer attentions){
		this.attentions = attentions;
	}
	/**
	 * @return score 积分
	 */
	public Integer getScore(){
		return this.score;
	}
	/**
	 * @param score 积分
	 */
	public void setScore(Integer score){
		this.score = score;
	}
	/**
	 * @return idCard 身份证
	 */
	public String getIdCard(){
		return this.idCard;
	}
	/**
	 * @param idCard 身份证
	 */
	public void setIdCard(String idCard){
		this.idCard = idCard;
	}
	/**
	 * @return idCardPic 身份证图片链接
	 */
	public String getIdCardPic(){
		return this.idCardPic;
	}
	/**
	 * @param idCardPic 身份证图片链接
	 */
	public void setIdCardPic(String idCardPic){
		this.idCardPic = idCardPic;
	}
	/**
	 * @return description 个性签名
	 */
	public String getDescription(){
		return this.description;
	}
	/**
	 * @param description 个性签名
	 */
	public void setDescription(String description){
		this.description = description;
	}
	/**
	 * @return code 用户代码，默认为UUID
	 */
	public String getCode(){
		return this.code;
	}
	/**
	 * @param code 用户代码，默认为UUID
	 */
	public void setCode(String code){
		this.code = code;
	}
	/**
	 * @return userTypes 用户类型
	 */
	public Integer getUserTypes(){
		return this.userTypes;
	}
	/**
	 * @param userTypes 用户类型
	 */
	public void setUserTypes(Integer userTypes){
		this.userTypes = userTypes;
	}
	/**
	 * @return salt 加密盐
	 */
	public String getSalt(){
		return this.salt;
	}
	/**
	 * @param salt 加密盐
	 */
	public void setSalt(String salt){
		this.salt = salt;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
				.append("id",getId())
				.append("username",getUsername())
				.append("password",getPassword())
				.append("phone",getPhone())
				.append("province",getProvince())
				.append("city",getCity())
				.append("town",getTown())
				.append("address",getAddress())
				.append("nickname",getNickname())
				.append("age",getAge())
				.append("sex",getSex())
				.append("headIcon",getHeadIcon())
				.append("funs",getFuns())
				.append("attentions",getAttentions())
				.append("score",getScore())
				.append("idCard",getIdCard())
				.append("idCardPic",getIdCardPic())
				.append("description",getDescription())
				.append("code",getCode())
				.append("userTypes",getUserTypes())
				.append("salt",getSalt())
				.append("creator",getCreator())
				.append("createDate",getCreateDate())
				.append("lastModifier",getLastModifier())
				.append("lastModDate",getLastModDate())
				.append("status",getStatus())
				.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder()
				.append(getId())
				.append(getUsername())
				.append(getPassword())
				.append(getPhone())
				.append(getProvince())
				.append(getCity())
				.append(getTown())
				.append(getAddress())
				.append(getNickname())
				.append(getAge())
				.append(getSex())
				.append(getHeadIcon())
				.append(getFuns())
				.append(getAttentions())
				.append(getScore())
				.append(getIdCard())
				.append(getIdCardPic())
				.append(getDescription())
				.append(getCode())
				.append(getUserTypes())
				.append(getSalt())
				.append(getCreator())
				.append(getCreateDate())
				.append(getLastModifier())
				.append(getLastModDate())
				.append(getStatus())
				.toHashCode();
	}

	public boolean equals(Object obj) {
		if(obj instanceof UserDetail == false) return false;
		if(this == obj) return true;
		UserDetail other = (UserDetail)obj;
		return new EqualsBuilder()
				.append(getId(),other.getId())
				.isEquals();
	}
}