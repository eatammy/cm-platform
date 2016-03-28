package cn.eatammy.common.sms.models;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by 郭旭辉 on 2016/3/28.
 */
@XmlRootElement(name = "voiceCode")
public class VoiceCode {
    private String appId;
    private String verifyCode;
    private String to;
    public String getAppId() {
        return appId;
    }
    public void setAppId(String appId) {
        this.appId = appId;
    }
    public String getVerifyCode() {
        return verifyCode;
    }
    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }
    public String getTo() {
        return to;
    }
    public void setTo(String to) {
        this.to = to;
    }
}
