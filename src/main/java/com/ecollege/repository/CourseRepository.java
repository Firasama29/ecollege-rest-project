package com.ecollege.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecollege.model.Courses;

@Repository
public interface CourseRepository extends JpaRepository<Courses, Long>{

}
