package com.ming.ch05.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 贺春明
 * @date 2023/2/15
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer uid;
    private String account;
    private String password;
    private String userName;
}
