package com.wen.demo.controller;

import com.wen.consumer.feign.UserFeignClient;
import com.wen.demo.model.UserTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
    @RequestMapping("/user")
    public class UserController  {

       // @Autowired
        //private UserFeignClient userFeignClient;

        @GetMapping(value = "/getUser/{id}")
        public UserTest getUser(@PathVariable Long id){
            UserTest user=new UserTest();
            user.setId(id);
            user.setName("张三");
            user.setAge(18);
            return user;
        }
        @RequestMapping(value = "/getName")
        public String getName(){
            return "张三";
        }

      //  @RequestMapping(value = "/getUser", method = RequestMethod.POST)
        //public UserTest getUser(@RequestParam String id){
            //return restTemplate.getForObject("http://service-demo/user/getUser/"+id,UserTest.class);
           // return userFeignClient.getUser(id);
          //  return null;
     //   }

    @RequestMapping(value = "/getName")
    public String getUser(@RequestParam String id){
          return "123";
    }

    }




