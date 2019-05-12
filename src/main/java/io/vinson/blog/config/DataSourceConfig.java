package io.vinson.blog.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by JiangWeixin on 2019/5/12.
 */

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = {
        "io.vinson.blog.dao"
})

public class DataSourceConfig {

}