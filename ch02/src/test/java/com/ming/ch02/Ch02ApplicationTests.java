package com.ming.ch02;

import com.ming.ch02.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Ch02ApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        userService.say();
    }

}
