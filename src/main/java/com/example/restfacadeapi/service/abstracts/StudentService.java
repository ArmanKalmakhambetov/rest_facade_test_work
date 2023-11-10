package com.example.restfacadeapi.service.abstracts;

import com.example.restfacadeapi.model.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> getAllStudents();

    Optional<Student> getStudentById(Long id);

    Student saveStudent(Student student);

    void deleteStudent(Long id);

    void deleteStudentsByCourseId(Long id);
}
