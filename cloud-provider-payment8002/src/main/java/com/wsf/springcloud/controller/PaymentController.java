package com.wsf.springcloud.controller;

import com.wsf.springcloud.pojo.Payment;
import com.wsf.springcloud.pojo.ResponseResult;
import com.wsf.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


/**
 * @author wsfstart
 * @create 2022-06-28 18:28
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("create")
    public ResponseResult create(@RequestBody Payment payment){
        boolean save = paymentService.save(payment);
        log.info("****插入结果:"+save);
        if(save){
            return new ResponseResult(200,"数据插入成功,serverPort:"+serverPort,save);
        }
        return  new ResponseResult(444,"数据插入失败",save);
    }

    @GetMapping("get/{id}")
    public ResponseResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getById(id);
        if(payment!=null){
            return new ResponseResult(200,"查询成功,serverPort:"+serverPort,payment);
        }
        return  new ResponseResult(444,"没有对应记录");
    }

    @GetMapping("test")
    public String test(){
        return "hello1";
    }
}