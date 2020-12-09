package com.cainiao.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @ClassName : KafkaProducer
 * @Description :
 * @Author : Cai
 * @Date: 2020/11/26
 */
@Component
public class KafkaProducer {
    @Resource
    private KafkaTemplate<String, Object> kafkaTemplate;

    // 启动发送消息方法
    public void addMessage(String trainingInfo) {
        System.out.println(trainingInfo);
        kafkaTemplate.send("http-messages", trainingInfo);
    }
}
