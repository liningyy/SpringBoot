package com.ming.ch09;

import com.ming.ch09.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
@Slf4j
class Ch09ApplicationTests {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;


    @Test
    void test() {
        User user = new User(1001,"张三");
        redisTemplate.opsForValue().set("user:1001",user);
        User u = (User) redisTemplate.opsForValue().get("user:1001");
        log.info(u.toString());
        redisTemplate.delete("user:1001");
    }

}
