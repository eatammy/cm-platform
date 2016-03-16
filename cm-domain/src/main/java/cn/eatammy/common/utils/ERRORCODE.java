package cn.eatammy.common.utils;

/**
 * Created by 郭旭辉 on 2016/3/16.
 */
public enum ERRORCODE {
    /**
     * 参数异常
     */
    QUERYJSON_ISNULL("0100001", "查询参数为空"),
    PARAM_ISERROR("0100002", "参数错误"),
    PARAM_ISNULL("0100003", "参数不能为空"),
    PARAM_ISTOLONG("0100004", "参数长度超过限制"),
    ;

    /**
     * 操作码
     */
    private final String code;
    /**
     * 信息内容
     */
    private final String message;

    /**
     * 单例话操作码
     * @param code
     * @param message
     */
    private ERRORCODE(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 获取操作码
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     * 获取信息内容
     * @return
     */
    public String getMessage() {
        return message;
    }
}
