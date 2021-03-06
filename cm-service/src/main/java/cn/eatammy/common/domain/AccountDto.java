package cn.eatammy.common.domain;

/**
 * Created by 郭旭辉 on 2016/3/22.
 * 用户信息dto
 */
public class AccountDto {
    private String uid;   //uid
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
    private String idCard; //身份证
    private String idCardPic; //身份证图片链接
    private Integer userTypes;    //用户身份值
    private String salt;        //加密盐
    private String token;   //数字签名
    private Integer userType; //当前身份

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getHeadIcon() {
        return headIcon;
    }

    public void setHeadIcon(String headIcon) {
        this.headIcon = headIcon;
    }

    public Integer getFuns() {
        return funs;
    }

    public void setFuns(Integer funs) {
        this.funs = funs;
    }

    public Integer getAttentions() {
        return attentions;
    }

    public void setAttentions(Integer attentions) {
        this.attentions = attentions;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getIdCardPic() {
        return idCardPic;
    }

    public void setIdCardPic(String idCardPic) {
        this.idCardPic = idCardPic;
    }

    public Integer getUserTypes() {
        return userTypes;
    }

    public void setUserTypes(Integer userTypes) {
        this.userTypes = userTypes;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }
}
