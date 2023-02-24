package com.ming.ch10.service;

import com.ming.ch10.config.RabbitConfig;
import com.ming.ch10.order.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

/**
 * @author 贺春明
 * @date 2023/2/21
 */

@Service
@RequiredArgsConstructor
public class ProducerService {

    private final RabbitTemplate template;

    public void sendMessage(Order order) {
        CorrelationData data = new CorrelationData();
        data.setId(order.getOrderId());
        template.convertAndSend(RabbitConfig.EXCHANGE_NAME, "order.message", order, data);
    }
}
