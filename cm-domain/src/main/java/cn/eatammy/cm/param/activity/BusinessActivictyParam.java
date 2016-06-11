/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：商城活动											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-06-11  郭旭辉        新建	
{ 	                                                                     
{  ---------------------------------------------------------------------------
{  注：本模块代码由codgen代码生成工具辅助生成 http://www.oschina.net/p/codgen	
{*****************************************************************************	
*/

package cn.eatammy.cm.param.activity;

import cn.eatammy.common.param.CreateBaseParam;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 《商城活动》 查询参数实体
 * @author 郭旭辉
 *
 */
public class BusinessActivictyParam extends CreateBaseParam<Long> {
	private static final long serialVersionUID = 1L;
	
	/**
	*字段常量——商店id
	*/
	public static final String F_ShopId="shopId";
	/**
	*字段常量——所属活动id
	*/
	public static final String F_ActivityId="activityId";
	/**
	*字段常量——活动名称
	*/
	public static final String F_Name="name";
	/**
	*字段常量——活动价格
	*/
	public static final String F_Price="price";
	/**
	*字段常量——活动图片
	*/
	public static final String F_Picture="picture";
	/**
	*字段常量——活动评分
	*/
	public static final String F_Score="score";
	/**
	*字段常量——活动介绍
	*/
	public static final String F_Description="description";
	/**
	*字段常量——活动库存
	*/
	public static final String F_Stock="stock";
	/**
	*字段常量——活动销售量
	*/
	public static final String F_Sale="sale";
	/**
	*字段常量——使用开始时间
	*/
	public static final String F_StartTime="startTime";
	/**
	*字段常量——使用结束时间
	*/
	public static final String F_EndTime="endTime";
	/**
	*字段常量——使用规则
	*/
	public static final String F_Rules="rules";
	/**
	*字段常量——使用人数上限
	*/
	public static final String F_PNum="pNum";
	/**
	*字段常量——活动代码，UUID
	*/
	public static final String F_Code="code";
	/**
	*字段常量——是否参加活动，0：是，1：否
	*/
	public static final String F_IsAttend="isAttend";
	
	private Long shopId; //商店id
	private Long activityId; //所属活动id
	private String name; //活动名称
	private Double price; //活动价格
	private String picture; //活动图片
	private Integer score; //活动评分
	private String description; //活动介绍
	private Integer stock; //活动库存
	private Integer sale; //活动销售量
	private String startTime; //使用开始时间
	private String endTime; //使用结束时间
	private String rules; //使用规则
	private Integer pNum; //使用人数上限
	private String code; //活动代码，UUID
	private Integer isAttend; //是否参加活动，0：是，1：否
    
	/**
	 *默认空构造函数
	 */
	public BusinessActivictyParam() {
		super();
	}
	 
	/**
	 * @return shopId 商店id
	 */
	public Long getShopId(){
		return this.shopId;
	}
	/**
	 * @param shopId 商店id
	 */
	public void setShopId(Long shopId){
		this.shopId = shopId;
	}
	/**
	 * @return activityId 所属活动id
	 */
	public Long getActivityId(){
		return this.activityId;
	}
	/**
	 * @param activityId 所属活动id
	 */
	public void setActivityId(Long activityId){
		this.activityId = activityId;
	}
	/**
	 * @return name 活动名称
	 */
	public String getName(){
		return this.name;
	}
	/**
	 * @param name 活动名称
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 * @return price 活动价格
	 */
	public Double getPrice(){
		return this.price;
	}
	/**
	 * @param price 活动价格
	 */
	public void setPrice(Double price){
		this.price = price;
	}
	/**
	 * @return picture 活动图片
	 */
	public String getPicture(){
		return this.picture;
	}
	/**
	 * @param picture 活动图片
	 */
	public void setPicture(String picture){
		this.picture = picture;
	}
	/**
	 * @return score 活动评分
	 */
	public Integer getScore(){
		return this.score;
	}
	/**
	 * @param score 活动评分
	 */
	public void setScore(Integer score){
		this.score = score;
	}
	/**
	 * @return description 活动介绍
	 */
	public String getDescription(){
		return this.description;
	}
	/**
	 * @param description 活动介绍
	 */
	public void setDescription(String description){
		this.description = description;
	}
	/**
	 * @return stock 活动库存
	 */
	public Integer getStock(){
		return this.stock;
	}
	/**
	 * @param stock 活动库存
	 */
	public void setStock(Integer stock){
		this.stock = stock;
	}
	/**
	 * @return sale 活动销售量
	 */
	public Integer getSale(){
		return this.sale;
	}
	/**
	 * @param sale 活动销售量
	 */
	public void setSale(Integer sale){
		this.sale = sale;
	}
	/**
	 * @return startTime 使用开始时间
	 */
	public String getStartTime(){
		return this.startTime;
	}
	/**
	 * @param startTime 使用开始时间
	 */
	public void setStartTime(String startTime){
		this.startTime = startTime;
	}
	/**
	 * @return endTime 使用结束时间
	 */
	public String getEndTime(){
		return this.endTime;
	}
	/**
	 * @param endTime 使用结束时间
	 */
	public void setEndTime(String endTime){
		this.endTime = endTime;
	}
	/**
	 * @return rules 使用规则
	 */
	public String getRules(){
		return this.rules;
	}
	/**
	 * @param rules 使用规则
	 */
	public void setRules(String rules){
		this.rules = rules;
	}
	/**
	 * @return pNum 使用人数上限
	 */
	public Integer getPNum(){
		return this.pNum;
	}
	/**
	 * @param pNum 使用人数上限
	 */
	public void setPNum(Integer pNum){
		this.pNum = pNum;
	}
	/**
	 * @return code 活动代码，UUID
	 */
	public String getCode(){
		return this.code;
	}
	/**
	 * @param code 活动代码，UUID
	 */
	public void setCode(String code){
		this.code = code;
	}
	/**
	 * @return isAttend 是否参加活动，0：是，1：否
	 */
	public Integer getIsAttend(){
		return this.isAttend;
	}
	/**
	 * @param isAttend 是否参加活动，0：是，1：否
	 */
	public void setIsAttend(Integer isAttend){
		this.isAttend = isAttend;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("shopId",getShopId())
			.append("activityId",getActivityId())
			.append("name",getName())
			.append("price",getPrice())
			.append("picture",getPicture())
			.append("score",getScore())
			.append("description",getDescription())
			.append("stock",getStock())
			.append("sale",getSale())
			.append("startTime",getStartTime())
			.append("endTime",getEndTime())
			.append("rules",getRules())
			.append("pNum",getPNum())
			.append("code",getCode())
			.append("isAttend",getIsAttend())
			.append("creator",getCreator())
			.append("createDate",getCreateDate())
			.append("lastModifier",getLastModifier())
			.append("lastModDate",getLastModDate())
			.append("status",getStatus())
			.toString();
	}
	
}
