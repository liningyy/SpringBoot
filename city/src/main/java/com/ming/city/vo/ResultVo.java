package com.ming.city.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author 贺春明
 * @date 2023/2/16
 */

@Data
@Schema(name = "ResultVo",description = "响应对象")
public class ResultVo<T> {
    @Schema(name = "code",description = "编码")
    private int code;
    @Schema(name = "message",description = "错误消息")
    private String message;
    @Schema(name = "data",description = "返回数据")
    private T data;
}
