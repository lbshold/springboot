package top.lconcise.springbootwebsocketsocketjsdemo.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Created by liusj on 2020/3/30
 */
@Configuration
@EnableWebSocket
public class WebSocketServerConfig implements WebSocketConfigurer {

    @Autowired
    private MyStringWebSocketHandler myStringWebSocketHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(myStringWebSocketHandler, "/connect").withSockJS();

    }
}
