package com.sensorsdata.wy.webtest.config.web;

import com.sensorsdata.wy.webtest.config.web.filter.RequestIdFilter;
import com.sensorsdata.wy.webtest.config.web.interceptor.CustomInterceptor;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author wangyuan
 * @version 1.0.0
 * @since 2021/07/04 17:11
 */
@Configuration
public class CustomWebMvcConfig implements WebMvcConfigurer {

  @Bean
  public HandlerInterceptor customInterceptor() {
    return new CustomInterceptor();
  }


  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    InterceptorRegistration registration = registry.addInterceptor(customInterceptor());
    registration.order(100);
    registration.addPathPatterns("/**");
    registration.excludePathPatterns("/test1", "/druid","/druid/**");
  }

  @Bean
  public RequestIdFilter requestIdFilter() {
    return new RequestIdFilter();
  }

  @Bean
  public FilterRegistrationBean<RequestIdFilter> registerRequestIdFilter() {
    FilterRegistrationBean<RequestIdFilter> filterRegistration = new FilterRegistrationBean<>();
    filterRegistration.setFilter(requestIdFilter());
    filterRegistration.setOrder(100);
    filterRegistration.addUrlPatterns("/**");
    filterRegistration.setName("RequestIdFilter");
    return filterRegistration;
  }

}
