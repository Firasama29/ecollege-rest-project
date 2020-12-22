package com.ecollege.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subjects")
public class Subjects implements Serializable{

	private static final long serialVersionUID = 6586862029509019898L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long subjectId;
	
	@Column(name = "subject_name")
	private String subjectName;
	
//	@Column(name = "faculty")
//	private String faculty;
//	
//	@Column(name = "assignments")
//	private int assignments;
//	
//	@Column(name = "tests")
//	private int tests;
//	
	public Subjects() {
		super();
	}

	public Subjects(long subject, String subjectName) {
	super();
	this.subjectName = subjectName;
}

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

//	public String getFaculty() {
//		return faculty;
//	}
//
//	public void setFaculty(String faculty) {
//		this.faculty = faculty;
//	}
//
//	public int getAssignments() {
//		return assignments;
//	}
//
//	public void setAssignments(int assignments) {
//		this.assignments = assignments;
//	}
//
//	public int getTests() {
//		return tests;
//	}
//
//	public void setTests(int tests) {
//		this.tests = tests;
//	}

	@Override
	public String toString() {
		return subjectName;
	}
}
