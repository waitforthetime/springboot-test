package com.sensorsdata.wy.webtest.constant;

/**
 * 业务异常枚举
 *
 * @author wangyuan
 * @version 1.0.0
 * @since 2021/06/27 22:13
 */
public enum BusinessErrorEnum {
  SUCCEED(0, "操作成功"),
  FAILED(-1, "系统错误"),

  PARAM_ERROR(1010101, "参数异常"),
  ;
  /**
   * 业务code
   */
  private int code;
  /**
   * code 描述
   */
  private String errMsg;

  private BusinessErrorEnum(int code, String errMsg) {
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
