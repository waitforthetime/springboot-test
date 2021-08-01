package com.sensorsdata.wy.webtest.exception;

/**
 * 参数异常
 *
 * @author wangyuan
 * @version 1.0.0
 * @since 2021/07/04 15:13
 */
public class ParamException extends WebException {
  public ParamException(int code, String errMsg) {
    super(code, errMsg);
  }
}
