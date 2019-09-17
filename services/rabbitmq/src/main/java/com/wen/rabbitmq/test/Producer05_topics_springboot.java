package com.wen.rabbitmq.test;


import com.alibaba.fastjson.JSON;
import com.wen.rabbitmq.config.RabbitmqConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Administrator
 * @version 1.0
 * @create 2018-06-17 19:23
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class Producer05_topics_springboot {
    @Autowired
    RabbitTemplate rabbitTemplate;

    //使用rabbitTemplate发送消息
    @Test
    public void testSendEmail(){

        String message = "send email message to user";
        /**
         * 参数：
         * 1、交换机名称
         * 2、routingKey
         * 3、消息内容
         */
        //rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_TOPICS_INFORM,"inform.email",message);

        for (int i = 0; i <10 ; i++) {
            rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_TOPICS_INFORM,"inform.sms",message+i);

        }

    }


    @Test
    public void tests(){

        //UUID uuid = UUID.randomUUID();
        for (int i = 0; i <100 ; i++) {
            UUID uuid = UUID.randomUUID();
            rabbitTemplate.convertAndSend("test",null,uuid.toString());

        }

    }
    //使用rabbitTemplate发送消息
    @Test
    public void testSendPostPage(){

        Map message = new HashMap<>();
        message.put("pageId","5a795ac7dd573c04508f3a56");
        //将消息对象转成json串
        String messageString = JSON.toJSONString(message);
        //路由key，就是站点ID
        String routingKey = "5a751fab6abb5044e0d19ea1";
        /**
         * 参数：
         * 1、交换机名称
         * 2、routingKey
         * 3、消息内容
         */
        rabbitTemplate.convertAndSend("ex_routing_cms_postpage",routingKey,messageString);

    }

}
