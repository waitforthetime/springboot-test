package com.sensorsdata.wy.webtest.repo;

import com.sensorsdata.wy.webtest.model.Student;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wangyuan
 * @version 1.0.0
 * @since 2021/08/01 17:55
 */
@Repository
public interface StudentRepo extends CrudRepository<Student, Integer> {

  @Modifying
  @Query("TRUNCATE TABLE student")
  void truncate();

}
