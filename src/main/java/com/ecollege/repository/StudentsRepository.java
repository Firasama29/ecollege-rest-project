package com.ecollege.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecollege.model.Courses;
import com.ecollege.model.Students;

@Repository
public interface StudentsRepository extends JpaRepository<Students, Long>{

//	void save(StudentsDTO student);

	Students findStudentByStudentName(String studentName);
	
//	Collection<Students> findAllByStudentName(String studentName);
//	
//	Collection<Students> findAllByCourse(String course);
	
	
}
