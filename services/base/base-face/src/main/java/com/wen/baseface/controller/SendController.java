package com.wen.baseface.controller;

import com.wen.baseface.rabbitmq.FirstSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author zhuzhe
 * @date 2018/5/25 16:00
 * @email 1529949535@qq.com
 */
@RestController
public class SendController {
    //@Autowired
    //private FirstSender firstSender;

    @PostMapping("/send")
    public String send( @PathVariable("message")String message){
        String uuid = UUID.randomUUID().toString();
        //firstSender.send(uuid,message);
        return uuid;
    }

}
