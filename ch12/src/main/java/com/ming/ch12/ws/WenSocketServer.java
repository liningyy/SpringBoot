package com.ming.ch12.ws;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ming.ch12.entity.User;
import com.ming.ch12.vo.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 贺春明
 * @date 2023/2/22
 */

@Component
@ServerEndpoint(value = "/ws/connect", configurator = WebSocketHandshake.class)
@Slf4j
public class WenSocketServer {

    /**
     * 在线用户列表
     */
    private static Map<String, Session> map = new ConcurrentHashMap<>();

    /**
     * 第一次建立握手 调用
     *
     * @param session
     */
    @OnOpen
    public void onOpen(Session session) {
        User user = (User) session.getUserProperties().get("user");
        map.put(user.getId(), session);
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        User sendUser = (User) session.getUserProperties().get("user");
        // 封装消息对象
        Message msg = new Message();
        msg.setSendUser(sendUser.getName());
        msg.setMessage(message);
        msg.setDate(new Date());

        // 将 msg 序列化为 json
        String jsonMessage = new ObjectMapper().writeValueAsString(msg);

        if (msg.getUid() != null && msg.getUid() != "") {
            // 私发
            // 需要私发用户的 websocket session对象
            Session session1 = map.get(msg.getUid());
            session1.getBasicRemote().sendText(jsonMessage);
        } else {
            // 群发
            map.forEach((userId, sess) -> {
                try {
                    sess.getBasicRemote().sendText(jsonMessage);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    @OnClose
    public void onClose(Session session) {
        User user = (User) session.getUserProperties().get("user");
        log.info("用户" + user.getName() + "已离线");
        map.remove(user.getId());
    }
}
