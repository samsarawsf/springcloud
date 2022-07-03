package com.wsf.springcloud.controller;

import com.wsf.springcloud.pojo.Payment;
import com.wsf.springcloud.pojo.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author wsfstart
 * @create 2022-06-28 19:12
 */
@RestController
@Slf4j
public class OrderController {

//    public static final String PAYMENT_URL = "http://localhost:8001";

    public static final String PAYMENT_URL =  "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public ResponseResult create(Payment payment){
        log.info("***********参数:"+payment);
        //后面的请求需要加RequestBody注解
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,ResponseResult.class);
    }


    @GetMapping("/consumer/payment/get/{id}")
    public ResponseResult getPayment(@PathVariable("id") Long id){
        return  restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,ResponseResult.class);
    }

    @GetMapping("/consumer/payment/getForEntity/{id}")
    public ResponseResult getForEntity(@PathVariable("id") Long id){
        ResponseEntity<ResponseResult> entity=restTemplate.getForEntity(PAYMENT_URL+"/payment/get/"+id,ResponseResult.class);
        if (entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }
        return new ResponseResult(444,"操作失败");
    }
}
