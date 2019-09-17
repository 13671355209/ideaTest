package com.wen.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;


@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "com.wen.consumer")
@EnableFeignClients(basePackages = { "com.wen.consumer"})
//@ComponentScan(basePackages = { "com.wen.consumer"})
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

//    @Bean
//    @LoadBalanced//开启负载均衡
//    public RestTemplate restTemplate(){
//        return new RestTemplate();
//    }
}
