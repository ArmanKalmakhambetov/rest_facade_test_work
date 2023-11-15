package com.example.restfacadeapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private List<CourseDTO> coursesDTO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<CourseDTO> getCoursesDTO() {
        return coursesDTO;
    }

    public void setCoursesDTO(List<CourseDTO> coursesDTO) {
        this.coursesDTO = coursesDTO;
    }
}
