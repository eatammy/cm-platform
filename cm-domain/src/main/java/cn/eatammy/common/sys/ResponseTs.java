package cn.eatammy.common.sys;

import cn.eatammy.common.exception.BizException;
import cn.eatammy.common.utils.RtnCodeEnum;

/**
 * Response 工具类
 * Created by 郭旭辉 on 2016/3/18.
 */
public class ResponseTs {

    /**
     * 返回位置异常
     * @param <T>
     * @return
     */
    public static <T> ResponseT newUnknow(){
        ResponseT<T> responseT = new ResponseT<>(RtnCodeEnum.UNKNOW);
        return responseT;
    }

    /**
     * 成功返回
     * @param <T>
     * @return
     */
    public static <T> ResponseT newOK(){
        ResponseT<T> responseT = new ResponseT<>(RtnCodeEnum.SUCCESS);
        return responseT;
    }

    /**
     *
     * @param ex
     * @param isDebug   是否为调试模式，true，调试模式，返回纤细的错误堆栈信息
     * @param <T>
     * @return
     */
    public static <T> ResponseT<T> newResponseException(BizException ex, boolean isDebug){
        ResponseT<T> responseT = new ResponseT<>(ex, isDebug);
        return responseT;
    }

    /**
     * 正常业务对象的返回
     * @param bizData
     * @param <T>
     * @return
     */
    public static <T> ResponseT newResponse(T bizData){
        ResponseT<T> responseT = new ResponseT<>(RtnCodeEnum.SUCCESS);
        return responseT;
    }

    /**
     * 返回网络异常
     * @param <T>
     * @return
     */
    public static  <T> ResponseT newNetError(){
        ResponseT<T> responseT = new ResponseT<>(RtnCodeEnum.NET_ERROR);
        return responseT;
    }

    /**
     * 返回请求参数异常
     * @param <T>
     * @return
     */
    public static <T> ResponseT newParamError(){
        ResponseT<T> responseT = new ResponseT<>(RtnCodeEnum.UNKNOW);
        return responseT;
    }

    /**
     * 返回吊事次数超限异常
     * @param <T>
     * @return
     */
    public static <T> ResponseT newOverLimit(){
        ResponseT<T> responseT = new ResponseT<>(RtnCodeEnum.APP_OVER_INVOCATION_LIMIT);
        return responseT;
    }
}
