package com.student.service.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.student.service.dao.StudentDao;
import com.student.service.dto.Marks;
import com.student.service.dto.StudentResponse;
import com.student.service.entity.Student;
import com.student.service.exception.StudentException;

@Component
public class StudentServiceimple implements StudentService {

	@Autowired
	StudentDao dao;
	@Autowired
	RestTemplate restTemplate;

	@Override
	public Student createStudent(Student student) {
		return dao.save(student);
	}

	@Override
	public List<Student> getAllStudent() {
		return dao.findAll();
	}

	@Override
	public Student getStudentByID(Long studentId) {
		Student student = dao.findById(studentId).get();
		return student;
	}

	@Override
	public Student getByStudentRankOrders() {
		return null;
	}

	@Override
	public StudentResponse getstudentMarksDetails(long studentId) {
		String url = "http://localhost:8080/marks/" + studentId;
		Student student = dao.findById(studentId).get();
		ResponseEntity<List<Marks>> response1 = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Marks>>() {
				});
		StudentResponse response = new StudentResponse();
		List<Marks> marksList = response1.getBody();
		Map<String, Integer> data = new HashMap<String, Integer>();
		long totalMarks = 0;
		for (Marks m : marksList) {
			totalMarks += m.getMarks();
			data.putIfAbsent(m.getSubject(), m.getMarks());
		}
		boolean result = marksList.stream().allMatch(x -> x.getMarks() > 35);
		response.setAge(student.getAge());
		response.setResult((result == true) ? "pass" : "fail");
		response.setClass_name(student.getClassName());
		response.setStudentName(student.getName());
		response.setStudentId(student.getStudentId());
		response.setGender(student.getGender());
		response.setTotalMarks(totalMarks);
		response.setMarksData(data);
		student.setTotal_marks(totalMarks);
		dao.save(student);
		return response;
	}

	@Override
	public List<StudentResponse> getClassStudent(String classname) {

		List<Student> students = dao.findByClassName(classname);
		System.out.println("student data "+students);
		List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();
		for (Student s : students) {
			StudentResponse studentResponse = getstudentMarksDetails(s.getStudentId());
			studentResponseList.add(studentResponse);
		}
		return studentResponseList;
	}

	@Override
	public Student updateStudent(Student student) throws StudentException {
		if ( student.getStudentId() == null) {
			throw new StudentException("please enter student id ");
		}
		Student st = dao.findById(student.getStudentId()).get();
		if (student.getStudentId() != 0 || student != null) {
			if (student.getAge() != null) {
				st.setAge(student.getAge());
			}
			if (student.getClassName() != null) {
				st.setClassName(student.getClassName());
			}
			if (student.getGender() != null) {
				st.setGender(student.getGender());
			}
			if (student.getName() != null) {
				st.setName(student.getName());
			}
		}
		return dao.save(st);
	}

	@Override
	public String deleteStudent(long id) throws Exception {
		Optional<Student> st = dao.findById(id);
		if (st.isEmpty()) {
			throw new StudentException("please enter student id ");
		} else {
			dao.deleteById(id);
			return "record is Deleted ";
		}

	}
}