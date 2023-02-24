package com.ming.ch05.service;

import com.github.pagehelper.PageInfo;
import com.ming.ch05.entity.User;

/**
 * @author 贺春明
 * @date 2023/2/15
 */

public interface UserService {

    /**
     * 查询用户账号
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<User> listUser(Integer pageNum,Integer pageSize);
}
