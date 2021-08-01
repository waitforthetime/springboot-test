package com.sensorsdata.wy.webtest.exception.builder;

import com.sensorsdata.wy.webtest.constant.BusinessErrorEnum;
import com.sensorsdata.wy.webtest.exception.ParamException;
import com.sensorsdata.wy.webtest.exception.WebException;

/**
 * Web异常构造器
 *
 * @author wangyuan
 * @version 1.0.0
 * @since 2021/07/04 14:49
 */
public class WebExceptionBuilder {

  public static WebException buildWebException(BusinessErrorEnum errorEnum) {
    return new WebException(errorEnum.getCode(), errorEnum.getErrMsg());
  }

  public static WebException buildWebException(BusinessErrorEnum errorEnum, String message) {
    return new WebException(errorEnum.getCode(), errorEnum.getErrMsg(), message);
  }

  public static WebException buildWebException(BusinessErrorEnum errorEnum, Throwable e) {
    return new WebException(errorEnum.getCode(), errorEnum.getErrMsg(), e);
  }

  public static WebException buildWebException(BusinessErrorEnum errorEnum, String message, Throwable e) {
    return new WebException(errorEnum.getCode(), errorEnum.getErrMsg(), message, e);
  }

  public static ParamException buildParamException(String message) {
    return new ParamException(BusinessErrorEnum.PARAM_ERROR.getCode(), message);
  }
}
