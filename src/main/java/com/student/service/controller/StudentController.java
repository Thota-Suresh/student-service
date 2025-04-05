package com.student.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.service.dto.StudentResponse;
import com.student.service.entity.Student;
import com.student.service.exception.StudentException;
import com.student.service.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService service;

	@PostMapping("/student")
	public Student createStudent(@RequestBody Student student) {
		System.out.println(" studen request .." + student);
		Student st = service.createStudent(student);
		System.out.println("out put .." + st);
		return st;
	}

	@GetMapping("/student")
	public List<Student> getAllStudent() {
		return service.getAllStudent();
	}

	@GetMapping("/student/{id}")
	public Student getStudentData(@PathVariable("id") Long studentid) {
		return service.getStudentByID(studentid);
	}

	@GetMapping("/student/marks/{id}")
	public StudentResponse getStudentMarksDetails(@PathVariable("id") long studentId) {
		return service.getstudentMarksDetails(studentId);
	}

	@GetMapping("/student/class/{classname}")
	public List<StudentResponse> getClassStudentdata(@PathVariable("classname") String classname) {
		return service.getClassStudent(classname);

	}

	@PatchMapping("/student")
	public Student updateStudent(@RequestBody Student student) throws StudentException {
		return service.updateStudent(student);
	}

	@DeleteMapping("/student/{id}")
	public String deleteStudent(@PathVariable("id") long id) throws Exception {
		return service.deleteStudent(id);
	}
}