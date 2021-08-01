package com.sensorsdata.wy.webtest.repo;

import static org.junit.jupiter.api.Assertions.*;

import com.sensorsdata.wy.webtest.model.Student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author wangyuan
 * @version 1.0.0
 * @since 2021/08/01 19:51
 */
@SpringBootTest
class StudentRepoTest {

  @Resource
  private StudentRepo studentRepo;

  @BeforeEach
  void beforeEach() {
    studentRepo.truncate();
  }

  @Test
  void testDB() {
    Student student = Student.builder().name("王大").gender("男").classId(1).build();
    int id = studentRepo.save(student).getId();
    assertEquals(1, id);
    Student result = studentRepo.findById(id).orElse(null);
    assertNotNull(result);
    assertEquals(student.getName(), result.getName());
    assertNotNull(result.getCreateTime());
    assertNotNull(result.getUpdateTime());
  }

}