package com.sensorsdata.wy.webtest.controller;

import com.sensorsdata.wy.webtest.constant.BusinessErrorEnum;
import com.sensorsdata.wy.webtest.exception.builder.WebExceptionBuilder;
import com.sensorsdata.wy.webtest.model.BasicResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangyuan
 * @version 1.0.0
 * @since 2021/07/04 16:25
 */
@RestController
public class TestController {

  @RequestMapping(path = "/test1")
  public BasicResponse<Void> test1() {
    throw new RuntimeException("测试异常");
  }

  @RequestMapping(path = "/test2")
  public BasicResponse<Void> test2() {
    throw WebExceptionBuilder.buildParamException("测试参数异常");
  }

  @RequestMapping(path = "/test3")
  public BasicResponse<String> test3() {
    BasicResponse<String> response = new BasicResponse<>();
    response.setMessage(BusinessErrorEnum.SUCCEED.getErrMsg());
    response.setCode(BusinessErrorEnum.SUCCEED.getCode());
    response.setData("hello world.");
    return response;
  }
}
