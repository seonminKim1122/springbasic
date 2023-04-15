package com.sparta.springbasic.repository;

import com.sparta.springbasic.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
