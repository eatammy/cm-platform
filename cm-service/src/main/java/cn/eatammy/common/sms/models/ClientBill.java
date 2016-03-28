package cn.eatammy.common.sms.models;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by 郭旭辉 on 2016/3/28.
 */
@XmlRootElement(name = "clientBill")
public class ClientBill {
    private String appId;
    private String clientNumber;
    private String date;
    private String downUrl;
    private String token;
    public String getAppId() {
        return appId;
    }
    public void setAppId(String appId) {
        this.appId = appId;
    }
    public String getClientNumber() {
        return clientNumber;
    }
    public void setClientNumber(String clientNumber) {
        this.clientNumber = clientNumber;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getDownUrl() {
        return downUrl;
    }
    public void setDownUrl(String downUrl) {
        this.downUrl = downUrl;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
}
