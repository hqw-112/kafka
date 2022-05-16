package com.kafka.testkfk.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void sendMessage(String topic, String content) {
        // KafkaTemplate 提供了一系列 send 方法用来发送消息
        kafkaTemplate.send(topic, content);
    }
}
