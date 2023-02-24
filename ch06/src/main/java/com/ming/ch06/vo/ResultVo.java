package com.ming.ch06.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author 贺春明
 * @date 2023/2/17
 */

@Data
@Schema(name = "ResultVo", description = "统一视图响应对象")
public class ResultVo<T> {
    @Schema(name = "code", description = "响应状态码")
    private Integer code;
    @Schema(name = "message", description = "响应消息")
    private String message;
    @Schema(name = "data", description = "响应数据")
    private T data;
}
