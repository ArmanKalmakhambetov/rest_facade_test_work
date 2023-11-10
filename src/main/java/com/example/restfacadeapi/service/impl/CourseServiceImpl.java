package com.example.restfacadeapi.service.impl;

import com.example.restfacadeapi.model.entity.Course;
import com.example.restfacadeapi.repo.CourseRepo;
import com.example.restfacadeapi.service.abstracts.CourseService;
import com.example.restfacadeapi.service.abstracts.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepository;
    private final StudentService studentService;

    public CourseServiceImpl(CourseRepo courseRepository, StudentService studentService) {
        this.courseRepository = courseRepository;
        this.studentService = studentService;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    @Override
    @Transactional
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    @Transactional
    public void deleteCourse(Long id) {
        studentService.deleteStudentsByCourseId(id);
        courseRepository.deleteById(id);
    }


}
