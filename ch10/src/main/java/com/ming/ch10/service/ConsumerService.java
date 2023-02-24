package com.ming.ch10.service;

import com.ming.ch10.config.RabbitConfig;
import com.ming.ch10.order.Order;
import com.sun.org.apache.xpath.internal.operations.Or;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.nio.channels.Channel;
import java.time.format.DateTimeFormatter;

/**
 * @author 贺春明
 * @date 2023/2/21
 */

@Service
@RabbitListener(queues = RabbitConfig.QUEUE_NAME)
@Slf4j
public class ConsumerService {
    @RabbitHandler
    public void receive(@Payload Order order) {
        log.info("订单编号：" + order.getOrderId());
        log.info("订单时间：" + order.getCreateDate());
    }
}
