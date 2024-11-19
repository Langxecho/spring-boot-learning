package top.langxecho.springboot.websocket.server;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micrometer.common.util.StringUtils;
import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author mqxu
 * @date 2024/11/5
 * @description WebSocketServer
 */
@Component
@ServerEndpoint("/server/{uid}")
@Slf4j
public class WebSocketServer {

    // 记录当前在线连接数
    private static int onlineCount = 0;

    /**
     * 用来存放每个客户端对应的MyWebSocket对象
     */
    private static final ConcurrentHashMap<String, WebSocketServer> WEB_SOCKET_MAP = new ConcurrentHashMap<>();

    // 与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    // 接收用户编号的uid
    private String uid = "";

    /**
     * 连接建立成功调用的方法
     *
     * @param session session
     * @param uid     用户id
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("uid") String uid) {
        this.session = session;
        this.uid = uid;
        if (WEB_SOCKET_MAP.containsKey(uid)) {
            WEB_SOCKET_MAP.remove(uid);
            //加入set中
            WEB_SOCKET_MAP.put(uid, this);
        } else {
            //加入set中
            WEB_SOCKET_MAP.put(uid, this);
            //在线数加1
            addOnlineCount();
        }
        log.info("用户{}连接成功, 当前在线人数为:{}", uid, getOnlineCount());
        try {
            sendMsg("连接成功");
        } catch (IOException e) {
            log.error("用户{}连接异常!", uid, e);
        }
    }

    // 连接关闭调用的方法
    @OnClose
    public void onClose() {
        if (WEB_SOCKET_MAP.containsKey(uid)) {
            WEB_SOCKET_MAP.remove(uid);
            //在线数减1
            subOnlineCount();
        }
        log.info("用户{}退出, 当前在线人数为:{}", uid, getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     * @param session 可选的参数
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("用户{}发来消息:{}", uid, message);
        //可以群发消息
        if (StringUtils.isNotBlank(message)) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                Map<String, String> map = objectMapper.readValue(message, new TypeReference<>() {
                });
                // 追加发送人(防止串改)
                map.put("fromUid", this.uid);
                String toUid = map.get("toUid");
                // 传送给对应toUserId用户的websocket
                if (StringUtils.isNotBlank(toUid) && WEB_SOCKET_MAP.containsKey(toUid)) {
                    WEB_SOCKET_MAP.get(toUid).sendMsg(objectMapper.writeValueAsString(map));
                } else {
                    // 如果不在线则返回不在线信息给自己
                    log.error("请求的userId:{}不在该服务器上", toUid);
                }
            } catch (Exception e) {
                log.error("用户{}发送消息出现错误!", uid, e);
                e.printStackTrace();
            }
        }
    }

    /**
     * 发送消息
     *
     * @param msg 消息
     */
    private void sendMsg(String msg) throws IOException {
        this.session.getBasicRemote().sendText(msg);
    }

    /**
     * 发送自定义消息
     *
     * @param message 消息
     * @param uid     用户id
     */
    public static void sendInfo(String message, @PathParam("uid") String uid) throws IOException {
        log.info("发送消息到{}用户，报文:{}", uid, message);
        if (StringUtils.isNotEmpty(uid) && WEB_SOCKET_MAP.containsKey(uid)) {
            WEB_SOCKET_MAP.get(uid).sendMsg(message);
        } else {
            log.error("用户{}不在线!", uid);
        }
    }

    private static synchronized int getOnlineCount() {
        return onlineCount;
    }

    private static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    private static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }
}
