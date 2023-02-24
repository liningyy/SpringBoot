package com.ming.ch03.dto;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author 贺春明
 * @date 2023/2/14
 * <p>
 * springboot 默认读取的配置文件为application.properties或application.yml文件，
 * 解析后的内容通常都会绑定到具体的某个 Java对象中，用于后续的解析和配置，
 * 因此可以时使用@value注解实现属性绑定（绑定固定的属性）
 * 也可以使用@ConfigurationProperties 注解实现松散绑定，松散绑定只需要指定属性名的前缀即可，
 * 绑定的Bean属性名不需要精确匹配，
 * 在yml中可以依据约定使用驼峰模式（如：userName）、“-” 线（如：user-name）。
 * 全大写加下划线（USER_NAME）。这样就不需要 @value注解对每一个属性都绑定。
 */

@Component
@Data
@ConfigurationProperties("student")
public class Student {
//    // @Value("${student.user-id}")
//    private Integer userId;
//    // @Value("${student.user-name}")
//    private String userName;
//    // @Value("${student.age}")
//    private Integer age;
//    private String[] tels;
//    private List<String> list;
//    private Map<String, Integer> score;
//    private List<Teacher> teachers;
//    private Map<String, Teacher> teacherMap;

    private Integer userId;
    private String userName;
    private Integer age;
    private String[] tels;
    private List<Teacher> teachers;
    private List<String> lists;
    private Map<String,Teacher> maps;
    private Map<String,Integer> map;
}
