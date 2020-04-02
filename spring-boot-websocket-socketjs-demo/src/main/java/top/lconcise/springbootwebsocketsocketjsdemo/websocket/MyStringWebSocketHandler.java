package top.lconcise.springbootwebsocketsocketjsdemo.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * Created by liusj on 2020/3/30
 */
@Component
public class MyStringWebSocketHandler extends TextWebSocketHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyStringWebSocketHandler.class);

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        LOGGER.info("和客户端建立连接");
//        https://www.cnblogs.com/nosqlcoco/p/5860730.html
//        https://mrbird.cc/Spring-Boot%E6%95%B4%E5%90%88WebSocket.html
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // 获取客户单发送过来的消息
        String receiveMessage = message.getPayload();
        LOGGER.info(receiveMessage);
        // 发送消息给客户端
        session.sendMessage(new TextMessage(fakeAi(receiveMessage)));
        // 关闭连接
        session.close();
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        session.close(CloseStatus.SERVER_ERROR);
        LOGGER.info("连接异常", exception);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
        LOGGER.info("和客户端断开连接");
    }

    private static String fakeAi(String input) {
        if (input == null || "".equals(input)) {
            return "你说什么，没有听清";
        }
        return input.replace('你', '我')
                .replace("吗", "")
                .replace('?', '!')
                .replace('？', '！');
    }
}
