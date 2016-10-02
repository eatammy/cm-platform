package cn.eatammy.common.utils.excel;

import java.util.ArrayList;
import java.util.List;

/**
 * 导入结果
 *
 * @author linjingjie
 * @create 2016-05-23  16:16
 */
public class ExcelResult<T> {
    private List<T> resultList = new ArrayList<T>();
    private List<ExcelLog> errorList = new ArrayList<ExcelLog>();
    private boolean isError = false;

    public List<T> getResultList() {
        return resultList;
    }

    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }

    public List<ExcelLog> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<ExcelLog> errorList) {
        this.errorList = errorList;
    }

    public boolean isError() {
        return errorList.size() > 0;
    }
}
