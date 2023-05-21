package com.emsi.schoolmangmvc.repositories;

import com.emsi.schoolmangmvc.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
    Page<Student> findByNameContains (String kw, Pageable pageable);
}
