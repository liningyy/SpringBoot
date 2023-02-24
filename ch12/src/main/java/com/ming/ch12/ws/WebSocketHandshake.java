package com.ming.ch12.ws;

import com.ming.ch12.entity.User;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

/**
 * @author 贺春明
 * @date 2023/2/22
 * 握手拦截器，在这里获取 HttpSession的信息
 *
 *
 */

public class WebSocketHandshake extends ServerEndpointConfig.Configurator{

    /**
     * 由于客户端第一次发送的是http请求，所以在握手的时候，当前形参的request还是http的request，
     * 当我们第一次发送http请求的时候，把用户登录信息存入到了 httpsession 会话作用域中。
     * 此时获取当前http对象从会话作用域中获取到了，登录的用户信息。
     *
     * ServerEndpointConfig 类继承EndpointConfig接口，内部维护了一个 map集合。
     * 这个map集合和和 javax.websocket.Session; 包中的 Session对象互通的，所以将user对象
     * 放入到这个集合中，websocket的Session对象可以通过键去获取当前用户信息。
     *
     * 大概意思：客户端发送请求 -》 控制器，控制器将用户信息保存到了HttpSession会话作用域中。
     * controller跳转视图到html页面中，当进入这个页面 触发 js中的这句代码
     * // 创建WebSocket对象，指定端点
     * let ws = new WebSocket('ws://localhost:8080/ws/connect');
     * 指定我们船舰的websocket端点进行握手操作。当成功握手后，发送和接收通过已建立的连接进行。
     *
     * @param sec
     * @param request
     * @param response
     */
    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
        HttpSession httpSession = (HttpSession) request.getHttpSession();
        // 获取用户登录信息
        User user = (User) httpSession.getAttribute("user");
        System.out.println(user);
        // 将用户信息保存再 websocket连接的Session
        sec.getUserProperties().put("user",user);
    }
}
