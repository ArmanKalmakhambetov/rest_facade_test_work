package com.example.restfacadeapi.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    @JsonIgnoreProperties("studentsDTO")
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

    @Override
    public String toString() {
        return "StudentDTO{" +
               "id=" + id +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", email='" + email + '\'' +
               ", coursesDTO=" + coursesDTO +
               '}';
    }
}
