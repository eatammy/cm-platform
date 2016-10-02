package cn.eatammy.cm.domain.bi;

/**
 * Created by 郭旭辉 on 2016/9/3.
 * BI 分析DTO
 */
public class BiResultDto {

    private Object name;

    private int value;

    private int sex;            //性别

    private int deviceType;    //设备类型

    private double total;       //销售总额

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(int deviceType) {
        this.deviceType = deviceType;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
