package cn.eatammy.common.sys.database;

/**
 * Created by 郭旭辉 on 2016/4/6.
 * 动态数据源holder
 */
public class DataSourceHandler {
    public static final ThreadLocal<String> context = new ThreadLocal<>();

    /**
     * 添加数据源
     *
     * @param dataSource
     */
    public static void setDataSource(String dataSource) {
        context.set(dataSource);
    }

    /**
     * 获取数据源
     *
     * @return
     */
    public static String getDataSource() {
        return context.get();
    }

    /**
     * 移除数据源
     */
    public static void removeDataSource() {
        context.remove();
    }
}
