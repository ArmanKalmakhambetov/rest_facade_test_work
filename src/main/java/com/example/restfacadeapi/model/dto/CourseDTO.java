package com.example.restfacadeapi.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CourseDTO {

    private Long id;

    private String nameOfCourse;

    @JsonIgnore
    private List<StudentDTO> studentsDTO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameOfCourse() {
        return nameOfCourse;
    }

    public void setNameOfCourse(String nameOfCourse) {
        this.nameOfCourse = nameOfCourse;
    }

    public List<StudentDTO> getStudentsDTO() {
        return studentsDTO;
    }

    public void setStudentsDTO(List<StudentDTO> studentsDTO) {
        this.studentsDTO = studentsDTO;
    }
}
