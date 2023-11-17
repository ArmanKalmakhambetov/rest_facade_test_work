package com.example.restfacadeapi.facade.impl;

import com.example.restfacadeapi.converter.CourseMapper;
import com.example.restfacadeapi.facade.abstracts.CourseFacade;
import com.example.restfacadeapi.model.dto.CourseDTO;
import com.example.restfacadeapi.model.entity.Course;
import com.example.restfacadeapi.service.abstracts.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseFacadeImpl implements CourseFacade {

    private final CourseService courseService;

    public CourseFacadeImpl(CourseService courseService) {
        this.courseService = courseService;
    }


    @Override
    public List<CourseDTO> getAllCourses() {
        return courseService.getAllCourses().stream()
                .map(CourseMapper.INSTANCE::courseToCourseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CourseDTO> getCourseById(Long id) {
        return courseService.getCourseById(id).map(CourseMapper.INSTANCE::courseToCourseDTO);
    }

    @Override
    public CourseDTO saveCourse(CourseDTO courseDTO) {
        Course course = CourseMapper.INSTANCE.courseDTOToCourse(courseDTO);
        return CourseMapper.INSTANCE.courseToCourseDTO(courseService.saveCourse(course));
    }

    @Override
    public void deleteCourse(Long id) {
        courseService.deleteCourse(id);
    }

    @Override
    public List<CourseDTO> getCoursesByStudentId(Long studentId) {
        return courseService.getCoursesByStudentId(studentId).stream()
                .map(CourseMapper.INSTANCE::courseToCourseDTO)
                .collect(Collectors.toList());
    }

}
