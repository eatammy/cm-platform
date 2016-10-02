package cn.eatammy.common.utils.excel; /**
 * @author linjingjie
 * @create 2016-05-05  20:20
 */
/**
 * The <code>ExcelLog</code>
 *
 * @author sargeras.wang
 * @version 1.0, Created at 2013年9月17日
 */
public class ExcelLog {
    private Integer rowNum;
    private String log;

    /**
     * @return the rowNum
     */
    public Integer getRowNum() {
        return rowNum;
    }

    /**
     * @param rowNum
     *            the rowNum to set
     */
    public void setRowNum(Integer rowNum) {
        this.rowNum = rowNum;
    }

    /**
     * @return the log
     */
    public String getLog() {
        return log;
    }
    /**
     * @param log
     * @param rowNum
     */
    public ExcelLog(Integer rowNum, String log) {
        super();
        this.rowNum = rowNum;
        this.log = log;
    }

    /**
     * @param log
     *            the log to set
     */
    public void setLog(String log) {
        this.log = log;
    }

}