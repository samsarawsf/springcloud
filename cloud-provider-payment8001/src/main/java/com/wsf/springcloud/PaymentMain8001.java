package com.wsf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wsfstart
 * @create 2022-06-28 16:22
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentMain8001 {
  public static void main(String[] args) {
      SpringApplication.run(PaymentMain8001.class,args);
  }
}
