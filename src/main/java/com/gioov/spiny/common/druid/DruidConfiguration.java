package com.gioov.spiny.common.druid;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author godcheese
 * @date 2018/2/27 8:08
 */
@Configuration
public class DruidConfiguration {

    /**
     * DataSource 配置注入
     *
     * @return
     */
    @Primary     //在同样的DataSource中，首先使用被标注的DataSource
    @Bean(destroyMethod = "close", initMethod = "init") //声明其为Bean实例
    @ConfigurationProperties("spring.datasource.druid")
    public DataSource dataSource() {
        return DruidDataSourceBuilder.create().build();
    }

}
