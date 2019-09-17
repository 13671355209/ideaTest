package com.wen.baseface.rabbitmq;


import com.wen.baseface.model.TestUser;
import com.wen.baseface.service.TestUserService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

/**
 * 消息消费者1
 * @author zhuzhe
 * @date 2018/5/25 17:32
 * @email 1529949535@qq.com
 */
@Component
public class FirstConsumer {

    @Autowired
    private TestUserService testUserService;

    @RabbitListener(queues = {"first-queue","second-queue"}, containerFactory = "rabbitListenerContainerFactory")
    public void handleMessage(String message) throws Exception {
        // 处理消息
        System.out.println("FirstConsumer {} handleMessage :"+message);
        String uuid = UUID.randomUUID().toString();
        TestUser vo = new TestUser();
        vo.setSex(uuid);
        vo.setAge(uuid);
        vo.setRemark(uuid);
        testUserService.insertOrUpdate(vo);
        List<TestUser> retModel = testUserService.findUser(null);

        for (TestUser testUser : retModel) {
           System.out.println(testUser.toString());
        }
    }
}

