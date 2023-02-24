package com.ming.ch05.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ming.ch05.dao.UserDao;
import com.ming.ch05.entity.User;
import com.ming.ch05.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 贺春明
 * @date 2023/2/15
 */

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = RuntimeException.class)
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Override
    public PageInfo<User> listUser(Integer pageNum, Integer pageSize) {
        PageInfo<User> pageInfo = new PageInfo<>(userDao.listUser(pageNum,pageSize));
        return pageInfo;
    }
}
