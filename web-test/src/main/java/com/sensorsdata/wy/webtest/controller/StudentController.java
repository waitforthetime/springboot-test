package com.sensorsdata.wy.webtest.controller;

import com.sensorsdata.wy.webtest.model.Student;
import com.sensorsdata.wy.webtest.repo.StudentRepo;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;

import javax.annotation.Resource;

/**
 * @author wangyuan
 * @version 1.0.0
 * @since 2021/08/01 21:39
 */
@RestController
@RequestMapping(path = "/student")
public class StudentController {

  @Resource
  private StudentRepo studentRepo;

  @RequestMapping(path = "/add")
  public Student add(Student student) {
    student.setName(StringUtils.defaultString(student.getName(), UUID.randomUUID().toString()));
    student.setClassId(ObjectUtils.defaultIfNull(student.getClassId(), new Random().nextInt(100)));
    student.setGender("男".equals(student.getGender()) ? "男" : "女");
    studentRepo.save(student);
    return studentRepo.findById(student.getId()).orElse(null);
  }

  @RequestMapping(path = "list")
  public List<Student> list() {
    return Lists.newArrayList(studentRepo.findAll());
  }

}
