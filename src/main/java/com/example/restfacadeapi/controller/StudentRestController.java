package com.example.restfacadeapi.controller;

import com.example.restfacadeapi.facade.abstracts.StudentFacade;
import com.example.restfacadeapi.model.dto.StudentDTO;
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
@RequestMapping("/api/students")
public class StudentRestController {

    private final StudentFacade studentFacade;

    public StudentRestController(StudentFacade studentFacade) {
        this.studentFacade = studentFacade;
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        return new ResponseEntity<>(studentFacade.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<StudentDTO>> getStudentById(@PathVariable Long id) {
        return new ResponseEntity<>(studentFacade.getStudentById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentDTO> saveStudent(@RequestBody StudentDTO studentDTO) {
        return new ResponseEntity<>(studentFacade.saveStudent(studentDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        studentFacade.deleteStudent(id);
        return new ResponseEntity<>("Student with id = " + id + " was deleted", HttpStatus.OK);
    }

}
