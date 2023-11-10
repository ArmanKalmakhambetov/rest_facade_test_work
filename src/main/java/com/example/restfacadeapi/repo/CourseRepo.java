package com.example.restfacadeapi.repo;

import com.example.restfacadeapi.model.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {
}
