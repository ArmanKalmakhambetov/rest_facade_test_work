package com.example.restfacadeapi.converter;

import com.example.restfacadeapi.model.dto.StudentDTO;
import com.example.restfacadeapi.model.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mapping(target = "coursesDTO", source = "courses")
    StudentDTO studentToStudentDTO(Student student);

    @Mapping(target = "courses", ignore = true)
    Student studentDTOToStudent(StudentDTO studentDTO);

}

