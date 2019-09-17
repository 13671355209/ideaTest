package com.wen.consumer.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "service-demo")
public interface UserFeignClient {
    @RequestMapping(value = "/user/getName")
    public String getUser( @RequestParam String id);
}
