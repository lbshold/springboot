package com.summit.client.mqtt;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

import java.util.UUID;

/**
 * Created by liusj on 2019/11/4
 */
@Configuration
@IntegrationComponentScan
public class MqttReceiveConfig {
    private static final Logger log = LoggerFactory.getLogger(MqttReceiveConfig.class);
    @Value("${spring.mqtt.username}")
    private String username;

    @Value("${spring.mqtt.qos}")
    private String qos;

    @Value("${spring.mqtt.keepaliveinterval}")
    private String keepaliveinterval;

    @Value("${spring.mqtt.password}")
    private String password;

    @Value("${spring.mqtt.url}")
    private String hostUrl;

    @Value("${spring.mqtt.client.id}")
    private String clientId;

    @Value("${spring.mqtt.topic.icreader}")
    private String icreaderTopic;
    @Value("${spring.mqtt.topic.wictr}")
    private String wictrTopic;
    @Value("${spring.mqtt.topic.wictr_heartbeat}")
    private String wictrHeartBeatTopic;

    @Bean
    public MqttConnectOptions getMqttConnectOptions() {
        MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
        mqttConnectOptions.setUserName(username);
        mqttConnectOptions.setPassword(password.toCharArray());
        mqttConnectOptions.setServerURIs(new String[]{hostUrl});
        mqttConnectOptions.setCleanSession(false);
        mqttConnectOptions.setKeepAliveInterval(Integer.parseInt(keepaliveinterval));
        mqttConnectOptions.setAutomaticReconnect(true);
        return mqttConnectOptions;
    }

    @Bean
    public MqttPahoClientFactory mqttClientFactory() {
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        factory.setConnectionOptions(getMqttConnectOptions());
        return factory;
    }

    //接收通道
    @Bean
    public MessageChannel mqttInputChannel() {
        return new DirectChannel();
    }

    //配置client,监听的topic
    @Bean
    public MessageProducer inbound() {
        MqttPahoMessageDrivenChannelAdapter adapter =
                new MqttPahoMessageDrivenChannelAdapter(clientId + "_" + UUID.randomUUID().toString().substring(0, 5),
                        mqttClientFactory(), icreaderTopic, wictrTopic, wictrHeartBeatTopic);
        adapter.setCompletionTimeout(3000);
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setQos(Integer.parseInt(qos));
        adapter.setOutputChannel(mqttInputChannel());
        return adapter;
    }

    //通过通道获取数据
    @Bean
    @ServiceActivator(inputChannel = "mqttInputChannel")
    public MessageHandler handler() {
        return new MessageHandler() {
            @Override
            public void handleMessage(Message<?> message) throws MessagingException {
                String topic = message.getHeaders().get("mqtt_receivedTopic").toString();
                log.info("订阅到的消息:" + topic + ":" + message.getPayload().toString());
            }
        };
    }
}
