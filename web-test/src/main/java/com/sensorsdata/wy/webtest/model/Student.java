package com.sensorsdata.wy.webtest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

/**
 * @author wangyuan
 * @version 1.0.0
 * @since 2021/08/01 17:56
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("student")
public class Student {

  @Id
  private Integer id;
  private Integer classId;
  private String name;
  private String gender;
  private Date createTime;
  private Date updateTime;

}
