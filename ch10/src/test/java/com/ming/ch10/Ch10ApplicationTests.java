package com.ming.ch10;

import com.ming.ch10.order.Order;
import com.ming.ch10.service.ProducerService;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Ch10ApplicationTests {

    @Autowired
    private ProducerService service;

    @Test
    void testSend() {
//        service.sendMessage(new Order("xx123456","2023-01-01"));
        service.sendMessage(Order.builder().orderId("xx123456").createDate("2023-01-02").build());
    }

}
