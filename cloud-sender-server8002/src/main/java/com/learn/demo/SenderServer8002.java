package com.learn.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * //TODO 描述
 *
 * @author banjiawei
 * @date 2020/11/04
 */
@SpringBootApplication
@EnableEurekaClient
public class SenderServer8002 {
    public static void main(String[] args) {
        SpringApplication.run(SenderServer8002.class, args);
    }
}
