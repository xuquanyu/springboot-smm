package com.example.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@Slf4j
public class DataConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "sqlSessionFactory")
    @ConditionalOnMissingBean(SqlSessionFactoryBean.class)
    public SqlSessionFactoryBean createSqlSessionFactory(DataSource dataSource,
                                                         ApplicationContext applicationContext) throws Exception {
        log.info("into createSqlSessionFactory method");
        try {
            SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
            sessionFactory.setDataSource(dataSource);
            sessionFactory.setTypeAliasesPackage("com.example.demo.entity");
            sessionFactory.setMapperLocations(applicationContext.getResources("classpath*:/mapper/*.xml"));
            sessionFactory.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
            return sessionFactory;

        } catch (IOException e) {
            log.error(
                    "Error happens when getting sqlSessionFactory config files.{}", e);
        }
        return null;
    }

    /**
     * 创建SqlSessionTemplate对象
     *
     * @param sqlSessionFactory 创建SqlSessionTemplate所需的SessionFactory对象
     * @return 创建成功的SqlSessionTemplate对象
     */
    @Bean
    @ConditionalOnMissingBean(SqlSessionTemplate.class)
    public SqlSessionTemplate createSqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    /**
     * 创建事务用的Transaction Manager对象
     *
     * @return 创建成功的Transaction Manager对象
     */
    @Bean
    @ConditionalOnMissingBean(PlatformTransactionManager.class)
    public PlatformTransactionManager createTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
