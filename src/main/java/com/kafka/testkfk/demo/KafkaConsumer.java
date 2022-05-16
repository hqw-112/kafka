package com.kafka.testkfk.demo;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    // 对 test 主题进行监听
//    @KafkaListener(topics = {"test"})
    @KafkaListener(topics = {"my-replicated-topic"})
    public void handleMessage(ConsumerRecord record) {
        // 在读取消息的时候，会把消息封装成Record，用于接收消息
        String a = record.value().toString();
        if (a.startsWith("{"))
            a = JSON.parseObject(a).get("message").toString();
        System.out.println(a + "-------------------------------------");
    }

}
