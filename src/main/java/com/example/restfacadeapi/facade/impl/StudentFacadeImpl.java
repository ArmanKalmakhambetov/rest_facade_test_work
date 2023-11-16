package com.example.restfacadeapi.facade.impl;

import com.example.restfacadeapi.converter.CourseMapper;
import com.example.restfacadeapi.converter.StudentMapper;
import com.example.restfacadeapi.facade.abstracts.StudentFacade;
import com.example.restfacadeapi.model.dto.CourseDTO;
import com.example.restfacadeapi.model.dto.StudentDTO;
import com.example.restfacadeapi.model.entity.Course;
import com.example.restfacadeapi.model.entity.Student;
import com.example.restfacadeapi.service.abstracts.CourseService;
import com.example.restfacadeapi.service.abstracts.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentFacadeImpl implements StudentFacade {

    private final StudentService studentService;

    private final CourseService courseService;

    public StudentFacadeImpl(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
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

        List<CourseDTO> coursesDTO = studentDTO.getCoursesDTO();

        // Если курсы указаны
        if (coursesDTO != null && !coursesDTO.isEmpty()) {
            List<Course> courses = new ArrayList<>();
            // проходимся по всем курсам прешедшим при добавлении нового студента
            for (CourseDTO courseDTO : coursesDTO) {
                // Проверка есть ли курсы в базе данных
                Optional<Course> existingCourse = courseService.findByNameOfCourse(courseDTO.getNameOfCourse());

                // Если курс существует, использовать его, в противном случае сохранить новый курс
                Course course = existingCourse
                        .orElseGet(() -> courseService.saveCourse(CourseMapper.INSTANCE.courseDTOToCourse(courseDTO)));

                // Связать студента с курсом
                courses.add(course);
            }

            student.setCourses(courses);
        }

        return StudentMapper.INSTANCE.studentToStudentDTO(studentService.saveStudent(student));
    }

    @Override
    public void deleteStudent(Long id) {
        studentService.deleteStudent(id);
    }

}
