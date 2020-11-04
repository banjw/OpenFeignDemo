package com.learn.demo.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * //TODO 描述
 *
 * @author banjiawei
 * @date 2020/11/04
 */
@Configuration
public class OpenFeignConfig {
    @Bean
    Logger.Level getFeignLogLevel(){
        return Logger.Level.FULL;
    }
}
