package com.ming.ch06.controller;

import com.ming.ch06.vo.ResultVo;
import org.springframework.http.HttpStatus;

/**
 * @author 贺春明
 * @date 2023/2/17
 */

public class BaseController {

    public <T>ResultVo<T> success(T data){
        ResultVo<T> vo = new ResultVo<>();
        vo.setCode(HttpStatus.OK.value());
        vo.setData(data);
        return vo;
    }

    public ResultVo success(Integer code,String message){
        ResultVo vo = new ResultVo<>();
        vo.setCode(code);
        vo.setMessage(message);
        return vo;
    }
}
