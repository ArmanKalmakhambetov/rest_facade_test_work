package com.example.restfacadeapi.facade.impl;

import com.example.restfacadeapi.converter.StudentMapper;
import com.example.restfacadeapi.facade.abstracts.StudentFacade;
import com.example.restfacadeapi.model.dto.StudentDTO;
import com.example.restfacadeapi.model.entity.Student;
import com.example.restfacadeapi.service.abstracts.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentFacadeImpl implements StudentFacade {

    private final StudentService studentService;

    public StudentFacadeImpl(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents().stream()
                .map(StudentMapper.INSTANCE::studentToStudentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<StudentDTO> getStudentById(Long id) {
        return studentService
                .getStudentById(id)
                .map(StudentMapper.INSTANCE::studentToStudentDTO);
    }

    @Override
    public StudentDTO saveStudent(StudentDTO studentDTO) {
        Student student = StudentMapper.INSTANCE.studentDTOToStudent(studentDTO);
        return StudentMapper.INSTANCE.studentToStudentDTO(studentService.saveStudent(student));
    }

    @Override
    public void deleteStudent(Long id) {
        studentService.deleteStudent(id);
    }

}
