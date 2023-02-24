package com.ming.ch06.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 贺春明
 * @date 2023/2/17
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "User",description = "用户信息")
public class User {

    @Schema(name = "id",description = "用户唯一编号",example = "1001")
    private Integer id;
    @Schema(name = "userName",description = "用户名称",example = "user1")
    private String userName;
    @Schema(name = "age",description = "年龄",example = "20")
    private Integer age;
    @Schema(name = "card",description = "身份证")
    private Card card;
}
