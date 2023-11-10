package com.example.restfacadeapi.facade.abstracts;

import com.example.restfacadeapi.model.dto.StudentDTO;

import java.util.List;
import java.util.Optional;

public interface StudentFacade {

    List<StudentDTO> getAllStudents();

    Optional<StudentDTO> getStudentById(Long id);


    StudentDTO saveStudent(StudentDTO studentDTO);


    void deleteStudent(Long id);
}
