package com.sensorsdata.wy.webtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangyuan
 * @version 1.0.0
 * @since 2021/06/21 23:23
 */
@SpringBootApplication
@RestController
@EnableJdbcRepositories({"com.sensorsdata.wy.webtest.repo"})
public class WebApplication {
  public static void main(String[] args) {
    new SpringApplication(WebApplication.class).run(args);
  }

  @RequestMapping(path = "/")
  public String helloWorld() {
    return "hello world";
  }
}
