package com.wen.baseface.rabbitmq;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

/**
 * 消息发送  生产者1
 * @author zhuzhe
 * @date 2018/5/25 14:28
 * @email 1529949535@qq.com
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class FirstSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 发送消息
     * @param uuid
     * @param message  消息
     */
    @Test
    public void send() {
        String uuid = UUID.randomUUID().toString();
        //CorrelationData correlationId = new CorrelationData(uuid);
        for (int i = 0; i <2 ; i++) {
            rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE, "queue_one_key1",
                    uuid+"测试queue_one_key1");
        }
//        for (int i = 0; i <10 ; i++) {
//            rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE, "queue_one_key2",
//                    uuid+"测试queue_one_key2");
//        }
    }
}

