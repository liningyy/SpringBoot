package com.ming.ch10.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 贺春明
 * @date 2023/2/21
 */

@Configuration
public class RabbitConfig {

    public static final String EXCHANGE_NAME = "order.exchange";
    public static final String QUEUE_NAME = "order.queue";
    public static final String ROUTER_KEY = "order.*";

    @Bean
    public Exchange exchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME, false);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(exchange()).with(ROUTER_KEY).noargs();
    }

    /**
     * 自定义消息转换器，默认是使用 SimpleConverter，
     * 只能处理文本信息，如果想要处理对象，可以使用json的序列化器
     * @return
     */
    @Bean
    public MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }
}
