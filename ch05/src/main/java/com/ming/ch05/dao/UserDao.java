package com.ming.ch05.dao;

import com.ming.ch05.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 贺春明
 * @date 2023/2/15
 */

public interface UserDao {
    List<User> listUser(@Param("pageNum") Integer pageNum,
                        @Param("pageSize") Integer pageSize);
}
