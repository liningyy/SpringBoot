package org.c3p0.spring.boot.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author 贺春明
 * @date 2023/2/20
 * C3P0属性配置，将yml中的配置的内容绑定到字段中
 */

@ConfigurationProperties(prefix = "spring.datasource.c3p0")
public class C3p0DataSourceProperties {
    private String driverClassName;
    private String jdbcUrl;
    private String user;
    private String password;
    private Integer maxPoolSize;
    private Integer minPoolSize;
    private Integer initialPoolSize;
    private Integer maxIdleTime;
    private Integer checkoutTimeOut;

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getMaxPoolSize() {
        return maxPoolSize;
    }

    public void setMaxPoolSize(Integer maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public Integer getMinPoolSize() {
        return minPoolSize;
    }

    public void setMinPoolSize(Integer minPoolSize) {
        this.minPoolSize = minPoolSize;
    }

    public Integer getInitialPoolSize() {
        return initialPoolSize;
    }

    public void setInitialPoolSize(Integer initialPoolSize) {
        this.initialPoolSize = initialPoolSize;
    }

    public Integer getMaxIdleTime() {
        return maxIdleTime;
    }

    public void setMaxIdleTime(Integer maxIdleTime) {
        this.maxIdleTime = maxIdleTime;
    }

    public Integer getCheckoutTimeOut() {
        return checkoutTimeOut;
    }

    public void setCheckoutTimeOut(Integer checkoutTimeOut) {
        this.checkoutTimeOut = checkoutTimeOut;
    }
}
