package com.example.restfacadeapi.repo;

import com.example.restfacadeapi.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

    void deleteStudentsByCourseId(Long id);
}
