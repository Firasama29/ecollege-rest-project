package com.ecollege.model;
import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "students")
public class Students implements Serializable {

	private static final long serialVersionUID = 3431144695882848701L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long studentId;
	
	@NotNull
	@Size(min= 4, message = "student name should have at least 4 characters")
	@Column(name = "student_name")
	private String studentName;
	
	@NotNull
	@Column(name = "nationality")
	private String nationality;
	
	@NotNull
	@Column(name = "intake")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date intake;
	
	@NotNull
	@Column(name = "currentYear")
	private int currentYear;
	
	@Column(name = "age")
	private int age;
	
	//multiple students can have the same course, but only one course per student
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(name = "students_course", joinColumns = @JoinColumn(name = "student_id"), 
	inverseJoinColumns = @JoinColumn(name = "course_id"))
	private Courses courses;					//object of Courses
	
	public Students() {
		super();
	}
	
	
	public Students(Students students) {
		this.studentId = students.getStudentId();
		this.studentName = students.getStudentName();
		this.nationality = students.getNationality();
		this.intake = students.getIntake();
		this.currentYear = students.getCurrentYear();
		this.age = students.getAge();
		this.courses = students.getCourses();
	}
	
	public long getStudentId() {
		return studentId;
	}

	public void setStudenttId(long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setSubjectName(String studentName) {
		this.studentName = studentName;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Date getIntake() {
		return intake;
	}

	public void setIntake(Date intake) {
		this.intake = intake;
	}
	
	public int getCurrentYear() {
		return currentYear;
	}

	public void setCurrentYear(int currentYear) {
		this.currentYear = currentYear;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	public Courses getCourses() {
		return courses;
	}

	public void setCourses(Courses courses) {
		this.courses= courses;
	}


	@Override
	public String toString() {
		return "Students [studentId=" + studentId + ", studentName=" + studentName + ", nationality=" + nationality
				+ ", intake=" + intake + ", currentYear=" + currentYear + ", age=" + age + "]";
	}

}
