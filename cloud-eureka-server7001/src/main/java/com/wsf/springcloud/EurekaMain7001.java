package com.wsf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author wsfstart
 * @create 2022-06-28 23:09
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7001 {
  public static void main(String[] args) {
      SpringApplication.run(EurekaMain7001.class,args);
    //
  }
}
