package com.example.restfacadeapi.converter;

import com.example.restfacadeapi.model.dto.StudentDTO;
import com.example.restfacadeapi.model.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);


    StudentDTO studentToStudentDTO(Student student);


    Student studentDTOToStudent(StudentDTO studentDTO);

}

