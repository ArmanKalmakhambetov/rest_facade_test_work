package com.example.restfacadeapi.converter;

import com.example.restfacadeapi.model.dto.CourseDTO;
import com.example.restfacadeapi.model.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourseMapper {

    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    @Mapping(target = "studentsDTO", source = "students")
    CourseDTO courseToCourseDTO(Course course);


    Course courseDTOToCourse(CourseDTO courseDTO);
}

