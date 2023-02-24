package com.ming.ch06.config;

import com.ming.ch06.filter.AuthFilter;
import com.ming.ch06.filter.TestFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 贺春明
 * @date 2023/2/16
 */

@Configuration
// 扫描 servlet 组件相关的类
// 过滤只有几个可以用这个注解
// @ServletComponentScan("com.ming.ch06")
public class MvcConfig implements WebMvcConfigurer {

    /**
     * 动态注册 Servlet 组件
     * FilterRegistrationBean 用于动态注册Filter
     * ServletRegistrationBean 用于动态注册Servlet
     * ServletListenerRegistrationBean 用于动态注册Listener
     * @return
     */
    @Bean
    public FilterRegistrationBean authFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        // 装配过滤器
        filterRegistrationBean.setFilter(new AuthFilter());
        // 设置过滤器的name
        filterRegistrationBean.setName("authFilter");
        // 映射请求 url
        filterRegistrationBean.addUrlPatterns("/*");
        // 设置过滤器执行的优先级别，数值越小，级别越高
        filterRegistrationBean.setOrder(2);
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean testFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new TestFilter());
        filterRegistrationBean.setName("testFilter");
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(2);
        return filterRegistrationBean;
    }
}
