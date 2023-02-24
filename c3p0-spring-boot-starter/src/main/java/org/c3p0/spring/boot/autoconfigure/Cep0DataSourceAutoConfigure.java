package org.c3p0.spring.boot.autoconfigure;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.c3p0.spring.boot.properties.C3p0DataSourceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @author 贺春明
 * @date 2023/2/20
 * C3P0自动配置类
 */

@Configuration
/**
 * 当ComboPooledDataSource存在classpath下时，才初始化当前配置类
 */
@ConditionalOnClass(ComboPooledDataSource.class)
/**
 * 将带有@ConfigurationProperties注解的类纳入Spring容器中管理，
 * 这样就可以再其他类中进行注入
 */
@EnableConfigurationProperties(C3p0DataSourceProperties.class)
public class Cep0DataSourceAutoConfigure {

    /**
     * 注入数据源属性
     */
    @Autowired
    private C3p0DataSourceProperties properties;

    @Bean
    /**
     * 如果IOC容器中没有DataSource的Bean才装配数据源
     * 这里可以用Spring提供的深拷贝 跟便捷
     */
    @ConditionalOnMissingBean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(properties.getDriverClassName());
        dataSource.setJdbcUrl(properties.getJdbcUrl());
        dataSource.setUser(properties.getUser());
        dataSource.setPassword(properties.getPassword());
        dataSource.setInitialPoolSize(properties.getInitialPoolSize());
        dataSource.setMaxPoolSize(properties.getMaxPoolSize());
        dataSource.setMinPoolSize(properties.getMinPoolSize());
        dataSource.setMaxIdleTime(properties.getMaxIdleTime());
        dataSource.setCheckoutTimeout(properties.getCheckoutTimeOut());
        return dataSource;
    }
}
