package org.simplilearn.app.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Course {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	private String CourseName;
	private int fee;
	@ManyToOne
	@JoinColumn(name = "sid")
	private Student student;
	public Course(Student student) {
		super();
		this.student = student;
	}
	public Course() {
		//TODO Auto-generated constructor stub
	}
	public Course(int cid, String courseName, int fee) {
		super();
		this.cid = cid;
		CourseName = courseName;
		this.fee = fee;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	
}
