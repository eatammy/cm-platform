package cn.eatammy.common.sys.database;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by 郭旭辉 on 2016/4/6.
 * 动态数据源
 */

public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceHandler.getDataSource();
    }
}
