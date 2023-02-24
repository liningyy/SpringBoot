package com.ming.ch12.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author 贺春明
 * @date 2023/2/22
 */

@Configuration
public class WebSocketConfig {

    /**
     * 装配 ServerEndpointExporter，
     * 这个Bean会自动注册使用 @ServerEndpoint注解声明的websocket类，
     * 并且会将 ServerEndpoint纳入 ioc 容器管理
     *
     * 这个Bean的作用就是扫描带有 @ServerEndpoint 注解，暴露成websocket端点，以便客户连接使用
     * @return
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }
}
