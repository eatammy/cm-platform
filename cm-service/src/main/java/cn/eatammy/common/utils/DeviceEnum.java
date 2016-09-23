package cn.eatammy.common.utils;

/**
 * Created by 郭旭辉 on 2016/9/23.
 * 设备枚举类
 */
public enum DeviceEnum {
    PC(0, "电脑"),
    MOBILE(1, "手机"),
    TABLET(2, "平板");

    private Integer action;
    private String name;

    private DeviceEnum(Integer action) {
        this.action = action;
    }

    private DeviceEnum(Integer action, String name) {
        this.action = action;
        this.name = name;
    }

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
