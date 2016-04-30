package cn.eatammy.common.qiniu;

/**
 * Created by 郭旭辉 on 2016/4/26.
 * bucketl类型
 */
public enum BucketEnum {
    BUSINESS(1, "business"),
    COOKBOOK(2, "cookbook"),
    DISCOVER(3, "discover"),
    HEADICON(4, "headicon");
    private int type;
    private String bucketName;

    BucketEnum(int type, String bucketName) {
        this.type = type;
        this.bucketName = bucketName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }
}
