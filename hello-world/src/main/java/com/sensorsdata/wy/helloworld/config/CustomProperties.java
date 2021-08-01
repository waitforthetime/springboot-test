package com.sensorsdata.wy.helloworld.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *
 * @author wangyuan
 * @version 1.0.0
 * @since 2021/06/27 20:17
 */
@Component
@ConfigurationProperties(prefix = "custom")
public class CustomProperties {
  private boolean open;
  private String key;

  public boolean isOpen() {
    return open;
  }

  public void setOpen(boolean open) {
    this.open = open;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }
}
