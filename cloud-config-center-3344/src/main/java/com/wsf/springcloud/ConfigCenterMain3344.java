package com.wsf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wsfstart
 * @create 2022-07-05 22:31
 */
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class ConfigCenterMain3344 {
  public static void main(String[] args) {
      SpringApplication.run(ConfigCenterMain3344.class,args);
  }
}
