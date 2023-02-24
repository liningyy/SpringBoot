package com.ming.ch06.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 贺春明
 * @date 2023/2/16
 */

@Controller
@RequestMapping("/aa")
public class MyErrorController {

    /**
     * 如果请求头里面带有Accpet：text/html的信息就调用此方法处理请求
     * @return
     */
    @RequestMapping(produces = MediaType.TEXT_HTML_VALUE)
    public String errorHtml(){
        System.err.println("1");
        return "forward:error/404.html";
    }

    @RequestMapping
    @ResponseBody
    public Object error(){
        Map<String,Object> map = new HashMap<>();
        map.put("code",404);
        map.put("error","not found");
        return map;
    }
}
