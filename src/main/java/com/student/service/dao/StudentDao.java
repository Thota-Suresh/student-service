package com.student.service.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.service.entity.Student;
@Repository
public interface StudentDao extends JpaRepository<Student, Long> {

	List<Student> findByClassName(String classname);

}