package com.summit.client.controller;

import com.summit.client.mqtt.MqttGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liusj on 2019/11/4
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private MqttGateway mqttGateway;

    @GetMapping("/sendMqtt.do")
    public String sendMqtt(String  sendData){
        mqttGateway.sendToMqtt(sendData,"deviceMsg/yinhanjiwei");
        return "OK";
    }
}
