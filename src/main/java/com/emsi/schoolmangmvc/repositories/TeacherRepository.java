package com.emsi.schoolmangmvc.repositories;

import com.emsi.schoolmangmvc.entity.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
    Page<Teacher> findByNameContains (String kw, Pageable pageable);
}
