package com.ming.ch06.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author 贺春明
 * @date 2023/2/16
 */

@Slf4j
public class TestFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("过滤器 TestFilter");
        chain.doFilter(request, response);
    }
}
