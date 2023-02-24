package com.ming.ch06.config;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

/**
 * @author 贺春明
 * @date 2023/2/17
 * 访问文档路径：http://localhost:8080/项目上下文名称/swagger-ui.html
 *
 * info：相关头信息
 * license：开源证书
 * externalDocs：参考文档
 */

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "项目接口文档",
                version = "v1.0",
                description = "基于SpringBoot开发的API接口文档",
                license = @License(name = "MIT",url = "https://www.baidu.com/")
        ),
        externalDocs = @ExternalDocumentation(description = "参考文档",url = "https://github.com")
)
public class OpenApiConfig {
}
