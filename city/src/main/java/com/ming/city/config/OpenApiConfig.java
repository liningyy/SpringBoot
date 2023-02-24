package com.ming.city.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

/**
 * @author 贺春明
 * @date 2023/2/19
 */

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "项目接口文档",
                version = "v1.0",
                description = "Swagger-UI API文档",
                license = @License(name = "MIT", url = "https://baidu.com")
        )
)
public class OpenApiConfig {
}
