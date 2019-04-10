package org.jon.lv.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Package org.jon.lv.kafka.MsgConsumer
 * @Description: 消息消费者
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/5/18 16:15
 * version V1.0.0
 */
@Component
public class MsgConsumer {

	//配置监听的topic，多个时用逗号隔开
   // @KafkaListener(topics = {"jon-replicated-topic","jon-replicated-topic2"})
    @KafkaListener(topics = {"mml"})
    public void processMessage(String content) {
        System.out.println("consumer监听mml收到消息" + content);
    }
    
    
}
