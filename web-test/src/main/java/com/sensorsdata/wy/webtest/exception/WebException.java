package com.sensorsdata.wy.webtest.exception;

/**
 * 统一异常封装
 *
 * @author wangyuan
 * @version 1.0.0
 * @since 2021/06/27 22:11
 */
public class WebException extends RuntimeException {

  private int code;
  private String errMsg;

  public WebException(int code, String errMsg) {
    this(code, errMsg, errMsg);
  }

  public WebException(int code, String errMsg, String message) {
    super(message);
    this.code = code;
    this.errMsg = errMsg;
  }

  public WebException(int code, String errMsg, Throwable e) {
    super(errMsg, e);
    this.code = code;
    this.errMsg = errMsg;
  }

  public WebException(int code, String errMsg, String message, Throwable e) {
    super(message, e);
    this.code = code;
    this.errMsg = errMsg;
  }

  public int getCode() {
    return code;
  }

  public String getErrMsg() {
    return errMsg;
  }
}
