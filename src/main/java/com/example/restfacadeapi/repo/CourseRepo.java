package com.example.restfacadeapi.repo;

import com.example.restfacadeapi.model.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {

    Course findByNameOfCourse(String nameOfCourse);

    List<Course> findAllByStudents_id(Long studentId);
}
