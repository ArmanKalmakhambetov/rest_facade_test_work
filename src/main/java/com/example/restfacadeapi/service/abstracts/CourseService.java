package com.example.restfacadeapi.service.abstracts;

import com.example.restfacadeapi.model.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    List<Course> getAllCourses();

    Optional<Course> getCourseById(Long id);

    Course saveCourse(Course course);

    void deleteCourse(Long id);

    Optional<Course> findByNameOfCourse(String name);
}
