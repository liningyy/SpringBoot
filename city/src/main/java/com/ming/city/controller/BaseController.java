package com.ming.city.controller;

import com.github.pagehelper.PageInfo;
import com.ming.city.vo.ResultVo;
import org.springframework.http.HttpStatus;

/**
 * @author 贺春明
 * @date 2023/2/16
 */

public class BaseController {
    protected ResultVo success(PageInfo pageInfo){
        ResultVo vo = new ResultVo();
        vo.setCode(HttpStatus.OK.value());
        vo.setData(pageInfo.getList());
        return vo;
    }
}
