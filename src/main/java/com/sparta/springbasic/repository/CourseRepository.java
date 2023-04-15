package com.sparta.springbasic.repository;

import com.sparta.springbasic.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findByTitle(String title); // Query Method
}
