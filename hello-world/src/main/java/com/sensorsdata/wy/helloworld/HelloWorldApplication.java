package com.sensorsdata.wy.helloworld;

import com.sensorsdata.wy.helloworld.config.CustomProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangyuan
 * @version 1.0.0
 * @since 2021/06/21 22:02
 */
@SpringBootApplication
@RestController
public class HelloWorldApplication {

  @Autowired
  private CustomProperties customProperties;

  public static void main(String[] args) {
    new SpringApplication(HelloWorldApplication.class).run(args);
  }

  @RequestMapping(path = "/")
  public String helloWorld() {
    return "hello world. open is " + customProperties.isOpen() + ", key is " + customProperties.getKey();
  }
}
