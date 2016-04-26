package cn.eatammy.common.sms;

/**
 * Created by 郭旭辉 on 2016/4/22.
 * 1：注册短信，2：找回密码短信，4：商店认证短信
 */
public enum  SMSTYPE {
    REGISTER_SMS(1),
    FORGET_PASSWD_SMS(2),
    SHOP_AUTH_SMS(4);


    private  int typeValue;

    private SMSTYPE( int typeValue){
        this.typeValue = typeValue;
    }
    public int getTypeValue() {
        return typeValue;
    }

    public void setTypeValue(int typeValue) {
        this.typeValue = typeValue;
    }
}
