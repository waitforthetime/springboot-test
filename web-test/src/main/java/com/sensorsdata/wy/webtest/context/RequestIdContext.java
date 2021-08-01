package com.sensorsdata.wy.webtest.context;

import java.util.UUID;

/**
 * TODO
 *
 * @author wangyuan
 * @version 1.0.0
 * @since 2021/07/04 17:39
 */
public class RequestIdContext {

  private static final ThreadLocal<String> context = ThreadLocal.withInitial(() -> UUID.randomUUID().toString());

  public static String getRequestId() {
    return context.get();
  }

  public static void setRequestId(String requestId) {
    context.set(requestId);
  }

  public static void removeRequestId() {
    context.remove();
  }
}
