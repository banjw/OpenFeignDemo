package com.learn.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * //TODO 描述
 *
 * @author banjiawei
 * @date 2020/11/04
 */
@Component
@FeignClient(value = "CLOUD-BUYER-SERVER")
public interface BuyerPayService {

    @PostMapping("/buyer/paySuccess")
    String paySuccess(String orderNo);
}
