package com.ecollege.rest.controller;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecollege.exception.StudentNotFoundException;
import com.ecollege.model.Courses;
import com.ecollege.model.Students;
import com.ecollege.repository.CourseRepository;
import com.ecollege.repository.StudentsRepository;
import com.ecollege.repository.SubjectsRepository;
import com.ecollege.service.StudentService;

@RestController
public class EcollegeRest{
//	
	
	@Autowired
	private StudentService service;
	
	@Autowired
	private StudentsRepository studentRepo;
	
	@Autowired
	private CourseRepository courseRepo;
	
	@Autowired
	private SubjectsRepository subjectRepo;
	
	Logger log = LoggerFactory.getLogger(EcollegeRest.class);

	
	//add students
	@PostMapping("/students")
	public Students addStudent(@RequestBody Students student) {
		log.info("student" + student);
		service.addStudent(student);
//		return "Hi " + student.getStudentName() + " , your registration is successful with id: " + student.getStudentId();
		return student;
	}
	
	
	//view students, sorted by name using lambda expression---------------------------------------
	@GetMapping("/students")
	public List<Students> findStudentsSortedByName(){
		return service.findStudentsSortedByName();
	}

//	//get all students, sorted
//	@GetMapping("/students")
//	public List<Students> getAll(){
//		return service.getAllsorted();
//	}

	//view students whose names start with F
	@GetMapping("/students/sorted")
	public List<Students> sortStudentsByLetter(){
		return service.sortStudentsByLetter();
	}
	
	//find a student by id
	@GetMapping("/students/{studentId}")
	public Students getById(@PathVariable("studentId") long studentId) throws StudentNotFoundException {
		
		return service.findById(studentId);
	}
	
	
	//update students
	@PutMapping("/students/{studentId}")
	public Students updateStudents(@PathVariable("studentId") long studentId, @Valid @RequestBody Students students)
			throws StudentNotFoundException {
		return service.updateStudents(studentId, students);
	}
	
	//delete students
	@DeleteMapping("/students/{studentId}")
	public String deleteById(@PathVariable("studentId") long studentId) throws StudentNotFoundException {
		service.deleteStudent(studentId);
		return "student with id '" + studentId + "' is deleted successfully";
	}
	
//	//add courses
//	@PostMapping("/addCourses")
//	public void addCourses(@RequestBody Courses courses) {
//		crepo.save(courses);
//	}
//	
//	//view courses
//	@GetMapping("/courses")
//	public List<Courses> findCourses(){
//		return crepo.findAll();
//	}
	

	//TO-DO get all students by name
	
	
//	//get all students by course
//	@GetMapping("/students2/{course}")
//	public Collection<Students> findStudentsByCourse(@PathVariable("course") String course){
//		return service.getStudentsByCourse(course);
//	}
//	
	
	
	

//	//find a student by name
//	@GetMapping("/student/{studentName}")
//	public Optional<Students> getByName(@PathVariable("studentName") String studentName){
//		return service.getByName(studentName);
//	}
		
	
	
//	@GetMapping("/findAllSub")
//	public List<Subjects> findSubjects(){
//		return Srepo.findAll();
//	}	
//	//add students
//	@PostMapping("/addStudent")
//	public Students addStudents(@RequestBody StudentDTO student) {
//		return service.sa
//	}
	
	
	
}
	