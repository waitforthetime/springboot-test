package com.sensorsdata.wy.webtest.model;

/**
 * 基础响应实体
 *
 * @author wangyuan
 * @version 1.0.0
 * @since 2021/06/27 21:54
 */
public class BasicResponse<T> {
  /**
   * 业务code，0成功，其他失败；
   */
  private int code;
  /**
   * 处理结果描述
   */
  private String message;
  /**
   * 请求id，用于请求链路跟踪
   */
  private String requestId;
  /**
   * 业务响应数据
   */
  private T data;

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }
}
