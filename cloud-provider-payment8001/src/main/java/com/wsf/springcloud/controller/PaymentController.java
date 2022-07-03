package com.wsf.springcloud.controller;

import com.wsf.springcloud.pojo.Payment;
import com.wsf.springcloud.pojo.ResponseResult;
import com.wsf.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;


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

    @Resource
    private DiscoveryClient discoveryClient;

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

    @GetMapping("discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        services.forEach(service ->{
            log.info("*******service:"+service);
        });

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(instance ->{
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        });
        return this.discoveryClient;
    }

    @GetMapping(value = "feign/timeout")
    public String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
