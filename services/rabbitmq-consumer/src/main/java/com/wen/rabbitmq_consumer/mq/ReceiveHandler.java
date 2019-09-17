package com.wen.rabbitmq_consumer.mq;

import com.rabbitmq.client.Channel;

import com.wen.rabbitmq_consumer.config.RabbitmqConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @version 1.0
 * @create 2018-06-17 21:21
 **/
@Component
public class ReceiveHandler {

    @RabbitListener(queues = {RabbitmqConfig.QUEUE_INFORM_EMAIL})
    public void send_email(String msg,Message message,Channel channel){
        System.out.println("receive message is:"+msg);
    }
    @RabbitListener(queues = {RabbitmqConfig.QUEUE_INFORM_SMS})
    public  void send_sms(String msg){
        System.out.println("receive sms is:"+msg);
    }
    @RabbitListener(queues = {"test123"})
    public void send_test(String msg,Message message,Channel channel){
        System.out.println("receive test123 is:"+msg);
    }


}
