package com.example.restfacadeapi.facade.abstracts;

import com.example.restfacadeapi.model.dto.CourseDTO;

import java.util.List;
import java.util.Optional;

public interface CourseFacade {

    List<CourseDTO> getAllCourses();

    Optional<CourseDTO> getCourseById(Long id);

    CourseDTO saveCourse(CourseDTO courseDTO);

    void deleteCourse(Long id);

}
