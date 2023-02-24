package com.ming.ch02.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author 贺春明
 * @date 2023/2/13
 */

@Service
@Slf4j
public class UserService {

    public void say() {
        for (int i = 0; i < 10000; i++) {
            log.info("Hello UserService...");
        }
    }
}
