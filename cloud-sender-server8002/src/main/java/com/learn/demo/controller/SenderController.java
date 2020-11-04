package com.learn.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * //TODO 描述
 *
 * @author banjiawei
 * @date 2020/11/04
 */
@RestController
@Slf4j
public class SenderController {
    @PostMapping("/sender/paySuccess")
    public String paySuccess(String orderNo){
        log.info("sender订单回调，orderNo：{}", orderNo);
        return "sender订单回调";
    }
}
