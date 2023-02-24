package com.ming.ch01;

import com.ming.ch01.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @SpringBootApplication 里面默认带有@CompontentScan注解，
 * 启动时就会自动扫描包，默认情况下扫描是从启动类所在的包开始扫描，
 * 包括所有子包
 *
 * 这个启动类既是程序的入口同时也是一个标准的配置类
 */
// 可以通过 scanBasePackages 属性重新指定扫描的包
@SpringBootApplication(scanBasePackages = "com.ming.ch01.service")
public class Ch01Application {

    @Bean
    public UserService userService(){
        return new UserService();
    }

    /**
     * springboot 应用程序的启动方法，运行这个 main 方法
     * 就会启动整个 springboot 项目
     * @param args
     */
    public static void main(String[] args) {
        // SpringApplication 的 run 方法实际上是初始化一个 spring 的 ioc 容器，
        // 这个 run 方法是有返回值，返回的就是初始化的 ioc 容器
        ApplicationContext context = SpringApplication.run(Ch01Application.class, args);
        context.getBean(UserService.class).say();
    }

}
