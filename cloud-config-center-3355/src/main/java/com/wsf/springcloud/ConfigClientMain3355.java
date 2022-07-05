package com.wsf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wsfstart
 * @create 2022-07-05 22:55
 */
@EnableEurekaClient
@SpringBootApplication
public class ConfigClientMain3355 {
  public static void main(String[] args) {
    //
      SpringApplication.run(ConfigClientMain3355.class,args);
  }
}
