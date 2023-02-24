package com.ming.ch05;

import com.github.pagehelper.PageInfo;
import com.ming.ch05.dao.UserDao;
import com.ming.ch05.entity.User;
import com.ming.ch05.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class Ch05ApplicationTests {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    @Test
    void testListUser() {
        userDao.listUser(1,2).forEach(System.out::println);
    }

    @Test
    void testUserService() {
        PageInfo<User> pageInfo = userService.listUser(1, 2);
        pageInfo.getList().forEach( u -> {
            log.info(u.toString());
        });
    }

}
