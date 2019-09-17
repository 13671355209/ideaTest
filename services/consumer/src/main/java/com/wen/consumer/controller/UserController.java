package com.wen.consumer.controller;




import com.wen.consumer.feign.UserFeignClient;
import com.wen.consumer.model.UserTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/user")
public class UserController {

   // @Autowired
    //private RestTemplate restTemplate;
    @Autowired
    private UserFeignClient userFeignClient;

    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    public String getUser(@RequestParam String id){
        //return restTemplate.getForObject("http://service-demo/user/getUser/"+id,UserTest.class);

        return userFeignClient.getUser("123");
    }

}




