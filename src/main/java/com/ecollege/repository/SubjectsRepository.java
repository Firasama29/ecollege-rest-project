package com.ecollege.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecollege.model.Subjects;


@Repository
public interface SubjectsRepository extends JpaRepository<Subjects, Long> {
	
//	//order all profiles by nationality
//	List<Subjects> getSubjectsByOrderByFaculty();
//	
//	//find all by faculty
//	Collection<Subjects> findAllSubjectsByFaculty(String faculty);
//	
//	//find one subject by name
//	Optional<Subjects> findSubjectsByName(String subjectName);
}
