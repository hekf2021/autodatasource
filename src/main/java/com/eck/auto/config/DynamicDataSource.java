package com.eck.auto.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class DynamicDataSource extends AbstractRoutingDataSource {
    /**
     * 每次请求动态请求哪一个数据源
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceHolder.getDataSource();
    }

    public DynamicDataSource(){
         Map<Object, Object> dataSources=new ConcurrentHashMap<>();
        for(int i=1;i<=4;i++){
            DataSource dataSource = druidDataSource(i);
            dataSources.put(String.valueOf(i),dataSource);
            if(i==1){
                super.setDefaultTargetDataSource(dataSource);
            }
        }
        super.setTargetDataSources(dataSources);
    }
    /**
     * 此处数据库信配置,可以来源于redis等,然后再初始化所有数据源
     * 重点说明:一个DruidDataSource数据源,它里面本身就是线程池了,
     * 所以我们不需要考虑线程池的问题
     * @param no
     * @return
     */
    public DataSource druidDataSource(int no) {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl("jdbc:mysql://localhost:3306/ds0"+no);
        datasource.setUsername("root");
        datasource.setPassword("123456");
        datasource.setDriverClassName("com.mysql.jdbc.Driver");
        datasource.setInitialSize(5);
        datasource.setMinIdle(5);
        datasource.setMaxActive(20);
        //datasource.setDbType("com.alibaba.druid.pool.DruidDataSource");
        datasource.setMaxWait(60000);
        datasource.setTimeBetweenEvictionRunsMillis(60000);
        datasource.setMinEvictableIdleTimeMillis(300000);
        datasource.setValidationQuery("SELECT 1 FROM DUAL");
        datasource.setTestWhileIdle(true);
        datasource.setTestOnBorrow(false);
        datasource.setTestOnReturn(false);
        try {
            datasource.setFilters("stat,wall,log4j");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return datasource;
    }
}
