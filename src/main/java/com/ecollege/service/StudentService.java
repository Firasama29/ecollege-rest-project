package com.ecollege.service;

import java.util.Collections;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecollege.exception.StudentNotFoundException;
import com.ecollege.model.Students;
import com.ecollege.repository.CourseRepository;
import com.ecollege.repository.StudentsRepository;
import com.ecollege.repository.SubjectsRepository;

@Service
public class StudentService {

	@Autowired
	private StudentsRepository studentRepo;
	
	@Autowired
	private CourseRepository courseRepo;
	
	@Autowired
//	private SubjectsRepository subjectRepo;
	
	
	//add students
	public Students addStudent(Students students) {
		
		Students student = studentRepo.save(students);
		student.setStudenttId(student.getStudentId());
		student.setSubjectName(student.getStudentName());
		student.setAge(student.getAge());
		student.setIntake(student.getIntake());
		student.setCurrentYear(student.getCurrentYear());
		student.setNationality(student.getNationality());
		student.setCourses(student.getCourses());
		return student;
		
	}
	
	//view students, sorted by name using lambda expression---------------------------------------
	public List<Students> findStudentsSortedByName(){
		List<Students> students = studentRepo.findAll();
		
		//using lambda to sort students by name
		Collections.sort(students, (student1, student2) -> student1.getStudentName()
				.compareTo(student2.getStudentName()));
		return students;
	}
	
	//find students whose names start with F
	public List<Students> sortStudentsByLetter(){
		List<Students> students = studentRepo.findAll();
		for(Students s : students) {
			if(!s.getStudentName().startsWith("F")) {
				return null;
			}
		}
		return students;
	}
	
	//find by id
	// orElseThrow is a method that Returns value if present, otherwise invokes an exception
	public Students findById(long studentId) throws StudentNotFoundException {
		return studentRepo.findById(studentId).orElseThrow(() -> new StudentNotFoundException(studentId));
	}
	
	//TO-DO get all students by name
	
	
	//update students
	public Students updateStudents(long studentId, Students students)
			throws StudentNotFoundException {
		//first find student by id
		Students student = studentRepo.findById(studentId)
				.orElseThrow(() -> new StudentNotFoundException(studentId));
		//set the new values
		student.setSubjectName(students.getStudentName());
		student.setAge(students.getAge());
		student.setNationality(students.getNationality());
		student.setCurrentYear(students.getCurrentYear());
		student.setIntake(students.getIntake());
		student.setCourses(students.getCourses());
		Students studentUpdate = studentRepo.save(student);
		
		return studentUpdate;
	}
	
	//delete
	public void deleteStudent(long studentId) throws StudentNotFoundException {
		studentRepo.findById(studentId).orElseThrow(() -> new StudentNotFoundException(studentId));
		studentRepo.deleteById(studentId);
	}
	
	
	//add courses
	//view all courses
	//view courses by name, sorted
	
	
	
	//add subjects
	//view all subjects by course
	//
	
}
