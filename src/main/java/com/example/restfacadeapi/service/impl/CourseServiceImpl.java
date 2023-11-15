package com.example.restfacadeapi.service.impl;

import com.example.restfacadeapi.model.entity.Course;
import com.example.restfacadeapi.repo.CourseRepo;
import com.example.restfacadeapi.service.abstracts.CourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepository;

    public CourseServiceImpl(CourseRepo courseRepository) {
        this.courseRepository = courseRepository;
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
        courseRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Course> findByNameOfCourse(String name) {
        return Optional.ofNullable(courseRepository.findByNameOfCourse(name));
    }

}
