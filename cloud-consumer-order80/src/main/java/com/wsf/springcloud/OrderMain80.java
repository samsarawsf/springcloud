package com.wsf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wsfstart
 * @create 2022-06-28 19:09
 */
@SpringBootApplication
@EnableEurekaClient
public class OrderMain80 {
  public static void main(String[] args) {
    //
      SpringApplication.run(OrderMain80.class,args);
  }
}
