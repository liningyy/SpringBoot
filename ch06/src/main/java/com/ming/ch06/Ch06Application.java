package com.ming.ch06;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Slf4j
public class Ch06Application {

    public static void main(String[] args) {
        // 在没有集成web环境时，创建的是：
        // AnnotationConfigApplicationContext容器对象
        // 在集成web环境下创建的是：
        // AnnotationConfigServletWebServerApplicationContext@2f40e5db
        ApplicationContext context = SpringApplication.run(Ch06Application.class, args);
//        AnnotationConfigApplicationContext
//        AnnotationConfigServletWebServerApplicationContext
        log.info(context.toString());
    }

}
