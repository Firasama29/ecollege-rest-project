package com.ecollege.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Courses implements Serializable{

	private static final long serialVersionUID = 8584453756985603371L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "course_name")
	private String courseName;
	
//	@OneToMany(mappedBy = "students")		//means 'private Courses courses' owns the relationship(i.e. contains foreign key for the query to find all phones for an employee.)
//	private Set<Students> students = new HashSet<>();

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "course_subjects", joinColumns = @JoinColumn(name = "course_id"), 
	inverseJoinColumns = @JoinColumn(name = "subject_id"))
	private Set<Subjects> subjects = new HashSet<>();
	
	public Courses() {
		super();
	}

	public Courses(long id, String courseName, Set<Subjects> subjects) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.subjects = subjects;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

//	public Set<Students> getStudents() {
//		return students;
//	}
//	
//	public void setStudents(Set<Students> students){
//		this.students = students;
//	}
	public Set<Subjects> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subjects> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "courseName=" + courseName;
	}
}
