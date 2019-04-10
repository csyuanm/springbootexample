package org.jon.lv.kafka;


import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Component;

/**
 * @Package org.jon.lv.kafka.MsgProducer
 * @Description: 消息生产者
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/5/18 16:13
 * version V1.0.0
 */
@Component
public class MsgProducer {
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void send(String content) {
    	for(int i = 0;i < 100;i++) {
    		kafkaTemplate.send("mml", content);
    		kafkaTemplate.send("mml", 0, content+"--3");
    		kafkaTemplate.send("mml", "kkk", content+"--3");
    		kafkaTemplate.send("mml", 0, "key", content+"--4");
    	}
        System.out.println("producer向topic发送消息" + content);
        kafkaTemplate.metrics();
        kafkaTemplate.execute(new KafkaOperations.ProducerCallback<String, String, Object>() {
            @Override
            public Object doInKafka(Producer<String, String> producer) {
                //这里可以编写kafka原生的api操作
            	System.out.println("producer 原生炒作是啥？");
                return null;
            }
        });

        //消息发送的监听器，用于回调返回信息
        kafkaTemplate.setProducerListener(new ProducerListener<String, String>() {
        
            @Override
            public void onSuccess(String topic, Integer partition, String key, String value, RecordMetadata recordMetadata) {
            	System.out.println("consumer 已经消费消息");
            }

            @Override
            public void onError(String topic, Integer partition, String key, String value, Exception exception) {
            	System.out.println("consum 消费出错");
            }

            @Override
            public boolean isInterestedInSuccess() {
            	System.out.println("???");
                return false;
            }
        });
    }
}
