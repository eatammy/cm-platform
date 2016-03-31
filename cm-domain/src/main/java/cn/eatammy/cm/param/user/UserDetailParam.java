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
{  2016-03-31  郭旭辉        新建	
{ 	                                                                     
{  ---------------------------------------------------------------------------
{  注：本模块代码由codgen代码生成工具辅助生成 http://www.oschina.net/p/codgen	
{*****************************************************************************	
*/

package cn.eatammy.cm.param.user;

import cn.eatammy.common.param.CreateBaseParam;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 《用户》 查询参数实体
 * @author 郭旭辉
 *
 */
public class UserDetailParam extends CreateBaseParam<Long> {
	private static final long serialVersionUID = 1L;
	
	/**
	*字段常量——账号
	*/
	public static final String F_Username="username";
	/**
	*字段常量——密码
	*/
	public static final String F_Password="password";
	/**
	*字段常量——电话
	*/
	public static final String F_Phone="phone";
	/**
	*字段常量——地址
	*/
	public static final String F_Address="address";
	/**
	*字段常量——昵称
	*/
	public static final String F_Nickname="nickname";
	/**
	*字段常量——性别,0:man,1:fumale
	*/
	public static final String F_Sex="sex";
	/**
	*字段常量——头像
	*/
	public static final String F_HeadIcon="headIcon";
	/**
	*字段常量——粉丝数
	*/
	public static final String F_Funs="funs";
	/**
	*字段常量——关注数
	*/
	public static final String F_Attentions="attentions";
	/**
	*字段常量——积分
	*/
	public static final String F_Score="score";
	/**
	*字段常量——是否为学生，0:学生，1：非学生
	*/
	public static final String F_IsStudent="isStudent";
	/**
	*字段常量——学生证号码
	*/
	public static final String F_StudentId="studentId";
	/**
	*字段常量——学生证图片链接
	*/
	public static final String F_StudentPic="studentPic";
	/**
	*字段常量——身份证
	*/
	public static final String F_IdCard="idCard";
	/**
	*字段常量——身份证图片链接
	*/
	public static final String F_IdCardPic="idCardPic";
	/**
	*字段常量——个性签名
	*/
	public static final String F_Description="description";
	
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
	private String description; //个性签名
    
	/**
	 *默认空构造函数
	 */
	public UserDetailParam() {
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
			.append("description",getDescription())
			.append("creator",getCreator())
			.append("createDate",getCreateDate())
			.append("lastModifier",getLastModifier())
			.append("lastModDate",getLastModDate())
			.append("status",getStatus())
			.toString();
	}
	
}
