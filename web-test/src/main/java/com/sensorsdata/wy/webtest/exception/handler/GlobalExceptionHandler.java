package com.sensorsdata.wy.webtest.exception.handler;

import com.sensorsdata.wy.webtest.constant.BusinessErrorEnum;
import com.sensorsdata.wy.webtest.exception.WebException;
import com.sensorsdata.wy.webtest.exception.builder.WebExceptionBuilder;
import com.sensorsdata.wy.webtest.model.BasicResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 异常统一处理
 *
 * @author wangyuan
 * @version 1.0.0
 * @since 2021/07/04 14:54
 */
@ControllerAdvice
public class GlobalExceptionHandler {

  private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  @ExceptionHandler(WebException.class)
  @ResponseBody
  public BasicResponse<Void> webExceptionHandler(HttpServletRequest request, WebException e) {
    logger.error("web exception global handler. [url:{},method:{}, exception:]", request.getRequestURI(),
        request.getMethod(), e);

    BasicResponse<Void> response = new BasicResponse<>();
    response.setCode(e.getCode());
    response.setMessage(e.getMessage());
    return response;
  }

  @ExceptionHandler({Exception.class})
  @ResponseBody
  public BasicResponse<Void> exceptionHandler(HttpServletRequest request, Exception e) {
    WebException webException = WebExceptionBuilder.buildWebException(BusinessErrorEnum.FAILED, e);
    return webExceptionHandler(request, webException);
  }
}
