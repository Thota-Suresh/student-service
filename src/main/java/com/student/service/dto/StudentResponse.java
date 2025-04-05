 package com.student.service.dto;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Component
@JsonIgnoreProperties
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentResponse {

	private Long studentId;
	private String studentName;
	private String class_name;
	private Map<String, Integer> marksData;
	private String result;
	private String age;
	private String gender;
	
	private Long totalMarks;
	private Long rankNumber;
	 
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	 
	 
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public Long getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(Long totalMarks) {
		this.totalMarks = totalMarks;
	}
	public Long getRankNumber() {
		return rankNumber;
	}
	public void setRankNumber(Long rankNumber) {
		this.rankNumber = rankNumber;
	}
	public StudentResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	public Map<String, Integer> getMarksData() {
		return marksData;
	}
	public void setMarksData(Map<String, Integer> marksData) {
		this.marksData = marksData;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "StudentResponse [studentId=" + studentId + ", studentName=" + studentName + ", marksData=" + marksData
				+ ", result=" + result + ",   age=" + age + ", gender=" + gender + ", class_name="
				+ class_name + ", totalMarks=" + totalMarks + ", rankNumber=" + rankNumber + "]";
	}
	 
	 
	
	
}