package com.sensorsdata.wy.webtest.config.web.filter;

import com.sensorsdata.wy.webtest.context.RequestIdContext;

import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wangyuan
 * @version 1.0.0
 * @since 2021/07/04 17:21
 */
public class RequestIdFilter extends OncePerRequestFilter {

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {

    String requestId = request.getHeader("request_id");
    if (StringUtils.isEmpty(requestId)) {
      requestId = UUID.randomUUID().toString();
    }
    try {
      RequestIdContext.setRequestId(requestId);
      filterChain.doFilter(request, response);
    } finally {
      RequestIdContext.removeRequestId();
    }
  }
}
