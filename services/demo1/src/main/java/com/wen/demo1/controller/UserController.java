package com.wen.demo1.controller;


import com.wen.demo1.model.UserTest;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping(value = "/getUser/{id}")

    public UserTest getUser(@PathVariable Long id){
        UserTest user=new UserTest();
        user.setId(id);
        user.setName("李四");
        user.setAge(18);
        return user;
    }
    @PostMapping(value = "/getName")
    public String getName(){
        return "张三";
    }
}




