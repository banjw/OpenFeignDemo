package com.learn.demo.controller;

import com.learn.demo.service.BuyerPayService;
import com.learn.demo.service.SenderPayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * //TODO 描述
 *
 * @author banjiawei
 * @date 2020/11/04
 */
@RestController
@Slf4j
public class PayController {

    @Resource
    private BuyerPayService buyerPayService;

    @Resource
    private SenderPayService senderPayService;

    @PostMapping("/pay/server/PaySuccess")
    public void PaySuccess(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        if(null == parameterMap || parameterMap.isEmpty()){
            response.getWriter().println("parameterMap为空");
            return;
        }
        Map<String, String> map = new HashMap<>();
        for (String key : parameterMap.keySet()) {
            StringBuffer valueStr = new StringBuffer();
            for (String value : parameterMap.get(key)) {
                valueStr.append(value);
            }
            map.put(key, valueStr.toString());
        }
        if(map.isEmpty()){
            response.getWriter().println("map为空");
            return;
        }
        String orderNo = map.get("orderNo");
        if(orderNo.startsWith("BO")){
            String result = buyerPayService.paySuccess(orderNo);
            log.info("result:{},orderNo:{}", result, orderNo);
            response.getWriter().println(result);
        }
        if(orderNo.startsWith("SO")){
            String result = senderPayService.paySuccess(orderNo);
            log.info("result:{},orderNo:{}", result, orderNo);
            response.getWriter().println(result);
        }
    }
}
