package com.emsi.schoolmangmvc.repositories;

import com.emsi.schoolmangmvc.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepository extends JpaRepository<Courses,Long> {
}
