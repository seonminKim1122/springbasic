package com.sparta.springbasic.dto;

import com.sparta.springbasic.entity.Course;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CourseResponseDto {
    private Long id;
    private String title;
    private String instructor;
    private double cost;

    public CourseResponseDto(Course course) {
        this.id = course.getId();
        this.title = course.getTitle();
        this.instructor = course.getInstructor();
        this.cost = course.getCost();
    }
}
