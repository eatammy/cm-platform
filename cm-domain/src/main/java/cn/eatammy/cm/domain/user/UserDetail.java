/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：用户表											
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
	private String address; //地址
	private String nickname; //昵称
	private Integer sex; //性别,0:man,1:fumale
	private String headIcon; //头像
	private Integer funs; //粉丝数
	private Integer attentions; //关注数
	private Integer score; //积分
	private Integer isStudent; //是否为学生，0:学生，1：非学生
	private String studentId; //学生证号码
	private String studentPic; //学生证图片链接
	private String idCard; //身份证
	private String idCardPic; //身份证图片链接
    
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
	 * @return isStudent 是否为学生，0:学生，1：非学生
	 */
	public Integer getIsStudent(){
		return this.isStudent;
	}
	/**
	 * @param isStudent 是否为学生，0:学生，1：非学生
	 */
	public void setIsStudent(Integer isStudent){
		this.isStudent = isStudent;
	}
	/**
	 * @return studentId 学生证号码
	 */
	public String getStudentId(){
		return this.studentId;
	}
	/**
	 * @param studentId 学生证号码
	 */
	public void setStudentId(String studentId){
		this.studentId = studentId;
	}
	/**
	 * @return studentPic 学生证图片链接
	 */
	public String getStudentPic(){
		return this.studentPic;
	}
	/**
	 * @param studentPic 学生证图片链接
	 */
	public void setStudentPic(String studentPic){
		this.studentPic = studentPic;
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
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("username",getUsername())
			.append("password",getPassword())
			.append("phone",getPhone())
			.append("address",getAddress())
			.append("nickname",getNickname())
			.append("sex",getSex())
			.append("headIcon",getHeadIcon())
			.append("funs",getFuns())
			.append("attentions",getAttentions())
			.append("score",getScore())
			.append("isStudent",getIsStudent())
			.append("studentId",getStudentId())
			.append("studentPic",getStudentPic())
			.append("idCard",getIdCard())
			.append("idCardPic",getIdCardPic())
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
			.append(getAddress())
			.append(getNickname())
			.append(getSex())
			.append(getHeadIcon())
			.append(getFuns())
			.append(getAttentions())
			.append(getScore())
			.append(getIsStudent())
			.append(getStudentId())
			.append(getStudentPic())
			.append(getIdCard())
			.append(getIdCardPic())
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
