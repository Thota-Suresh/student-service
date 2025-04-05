package com.student.service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.student.service.dto.StudentResponse;
import com.student.service.entity.Student;
import com.student.service.exception.StudentException;

@Service
public interface StudentService {

	public Student createStudent(Student student);
	public List<Student> getAllStudent();
	public Student getStudentByID(Long studentId);
	public Student getByStudentRankOrders();
	public StudentResponse getstudentMarksDetails(long studentId);
	public List<StudentResponse> getClassStudent(String classname);
	public Student updateStudent(Student student) throws StudentException;
	public String deleteStudent(long id) throws Exception;
}