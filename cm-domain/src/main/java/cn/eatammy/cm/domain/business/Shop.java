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

package cn.eatammy.cm.domain.business;

import cn.eatammy.common.domain.CMCreateBaseDomain;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 《商家》 实体
 * @author 郭旭辉
 *
 */
public class Shop extends CMCreateBaseDomain<Long> {
	private static final long serialVersionUID = 1L;
	
	private String shopName; //商店名称
	private String address; //商店详细地址
	private String province; //所属省
	private String city; //所属城市
	private String town; //所属区县
	private Integer cover; //商店封面
	private String owner; //商店名称
	private Long uid; //商家信息
	private String ownerPaperPic; //商店所有人证件照
	private String ownerPaper; //商店所有人证件号
	private String licensePic; //商店营业执照照片
	private String license; //商店营业执照号码
	private Integer shopCategoryId; //商店类型
	private String linetTelephone; //商店固定电话
	private String phone; //商店联系电话
	private Double income4Sum; //商家总收入，默认为0
	private Double withdrawable; //商家可提现收入，默认为0
    
	/**
	 *默认空构造函数
	 */
	public Shop() {
		super();
	}
	 
	/**
	 * @return shopName 商店名称
	 */
	public String getShopName(){
		return this.shopName;
	}
	/**
	 * @param shopName 商店名称
	 */
	public void setShopName(String shopName){
		this.shopName = shopName;
	}
	/**
	 * @return address 商店详细地址
	 */
	public String getAddress(){
		return this.address;
	}
	/**
	 * @param address 商店详细地址
	 */
	public void setAddress(String address){
		this.address = address;
	}
	/**
	 * @return province 所属省
	 */
	public String getProvince(){
		return this.province;
	}
	/**
	 * @param province 所属省
	 */
	public void setProvince(String province){
		this.province = province;
	}
	/**
	 * @return city 所属城市
	 */
	public String getCity(){
		return this.city;
	}
	/**
	 * @param city 所属城市
	 */
	public void setCity(String city){
		this.city = city;
	}
	/**
	 * @return town 所属区县
	 */
	public String getTown(){
		return this.town;
	}
	/**
	 * @param town 所属区县
	 */
	public void setTown(String town){
		this.town = town;
	}
	/**
	 * @return cover 商店封面
	 */
	public Integer getCover(){
		return this.cover;
	}
	/**
	 * @param cover 商店封面
	 */
	public void setCover(Integer cover){
		this.cover = cover;
	}
	/**
	 * @return owner 商店名称
	 */
	public String getOwner(){
		return this.owner;
	}
	/**
	 * @param owner 商店名称
	 */
	public void setOwner(String owner){
		this.owner = owner;
	}
	/**
	 * @return uid 商家信息
	 */
	public Long getUid(){
		return this.uid;
	}
	/**
	 * @param uid 商家信息
	 */
	public void setUid(Long uid){
		this.uid = uid;
	}
	/**
	 * @return ownerPaperPic 商店所有人证件照
	 */
	public String getOwnerPaperPic(){
		return this.ownerPaperPic;
	}
	/**
	 * @param ownerPaperPic 商店所有人证件照
	 */
	public void setOwnerPaperPic(String ownerPaperPic){
		this.ownerPaperPic = ownerPaperPic;
	}
	/**
	 * @return ownerPaper 商店所有人证件号
	 */
	public String getOwnerPaper(){
		return this.ownerPaper;
	}
	/**
	 * @param ownerPaper 商店所有人证件号
	 */
	public void setOwnerPaper(String ownerPaper){
		this.ownerPaper = ownerPaper;
	}
	/**
	 * @return licensePic 商店营业执照照片
	 */
	public String getLicensePic(){
		return this.licensePic;
	}
	/**
	 * @param licensePic 商店营业执照照片
	 */
	public void setLicensePic(String licensePic){
		this.licensePic = licensePic;
	}
	/**
	 * @return license 商店营业执照号码
	 */
	public String getLicense(){
		return this.license;
	}
	/**
	 * @param license 商店营业执照号码
	 */
	public void setLicense(String license){
		this.license = license;
	}
	/**
	 * @return shopCategoryId 商店类型
	 */
	public Integer getShopCategoryId(){
		return this.shopCategoryId;
	}
	/**
	 * @param shopCategoryId 商店类型
	 */
	public void setShopCategoryId(Integer shopCategoryId){
		this.shopCategoryId = shopCategoryId;
	}
	/**
	 * @return linetTelephone 商店固定电话
	 */
	public String getLinetTelephone(){
		return this.linetTelephone;
	}
	/**
	 * @param linetTelephone 商店固定电话
	 */
	public void setLinetTelephone(String linetTelephone){
		this.linetTelephone = linetTelephone;
	}
	/**
	 * @return phone 商店联系电话
	 */
	public String getPhone(){
		return this.phone;
	}
	/**
	 * @param phone 商店联系电话
	 */
	public void setPhone(String phone){
		this.phone = phone;
	}
	/**
	 * @return income4Sum 商家总收入，默认为0
	 */
	public Double getIncome4Sum(){
		return this.income4Sum;
	}
	/**
	 * @param income4Sum 商家总收入，默认为0
	 */
	public void setIncome4Sum(Double income4Sum){
		this.income4Sum = income4Sum;
	}
	/**
	 * @return withdrawable 商家可提现收入，默认为0
	 */
	public Double getWithdrawable(){
		return this.withdrawable;
	}
	/**
	 * @param withdrawable 商家可提现收入，默认为0
	 */
	public void setWithdrawable(Double withdrawable){
		this.withdrawable = withdrawable;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("shopName",getShopName())
			.append("address",getAddress())
			.append("province",getProvince())
			.append("city",getCity())
			.append("town",getTown())
			.append("cover",getCover())
			.append("owner",getOwner())
			.append("uid",getUid())
			.append("ownerPaperPic",getOwnerPaperPic())
			.append("ownerPaper",getOwnerPaper())
			.append("licensePic",getLicensePic())
			.append("license",getLicense())
			.append("shopCategoryId",getShopCategoryId())
			.append("linetTelephone",getLinetTelephone())
			.append("phone",getPhone())
			.append("income4Sum",getIncome4Sum())
			.append("withdrawable",getWithdrawable())
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
			.append(getShopName())
			.append(getAddress())
			.append(getProvince())
			.append(getCity())
			.append(getTown())
			.append(getCover())
			.append(getOwner())
			.append(getUid())
			.append(getOwnerPaperPic())
			.append(getOwnerPaper())
			.append(getLicensePic())
			.append(getLicense())
			.append(getShopCategoryId())
			.append(getLinetTelephone())
			.append(getPhone())
			.append(getIncome4Sum())
			.append(getWithdrawable())
			.append(getCreator())
			.append(getCreateDate())
			.append(getLastModifier())
			.append(getLastModDate())
			.append(getStatus())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Shop == false) return false;
		if(this == obj) return true;
		Shop other = (Shop)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}
