package com.student.service.entity;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Student {

	@Id
	@Column(name ="student_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentId;
	private String name ;
	private String age;
	private String gender;
	private Long total_marks;
	@CreatedDate
	private Date enrollment_date;
	@Column(name ="class_name")
	private String className;
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Date getEnrollment_date() {
		return enrollment_date;
	}
	public void setEnrollment_date(Date enrollment_date) {
		this.enrollment_date = enrollment_date;
	}
	 
	public Student() {
		super();
	}
	public Long getTotal_marks() {
		return total_marks;
	}
	public void setTotal_marks(long totalMarks) {
		this.total_marks = totalMarks;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public void setTotal_marks(Long total_marks) {
		this.total_marks = total_marks;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", age=" + age + ", gender=" + gender
				+ ", total_marks=" + total_marks + ", enrollment_date=" + enrollment_date + ", className=" + className
				+ "]";
	}
	public Student(Long studentId, String name, String age, String gender, Long total_marks, Date enrollment_date,
			String className) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.total_marks = total_marks;
		this.enrollment_date = enrollment_date;
		this.className = className;
	}
	 
	
}