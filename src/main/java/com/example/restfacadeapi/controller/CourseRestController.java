package com.example.restfacadeapi.controller;

import com.example.restfacadeapi.facade.abstracts.CourseFacade;
import com.example.restfacadeapi.model.dto.CourseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
public class CourseRestController {

    private final CourseFacade courseFacade;

    public CourseRestController(CourseFacade courseFacade) {
        this.courseFacade = courseFacade;
    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAllCourses() {
        return new ResponseEntity<>(courseFacade.getAllCourses(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CourseDTO>> getCourseById(@PathVariable Long id) {
        return new ResponseEntity<>(courseFacade.getCourseById(id), HttpStatus.OK);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<CourseDTO>> getCoursesByStudentId(@PathVariable Long studentId) {
        return new ResponseEntity<>(courseFacade.getCoursesByStudentId(studentId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CourseDTO> saveCourse(@RequestBody CourseDTO courseDTO) {
        return new ResponseEntity<>(courseFacade.saveCourse(courseDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
        courseFacade.deleteCourse(id);
        return new ResponseEntity<>("Course with id = " + id + " was deleted", HttpStatus.OK);
    }

}
