package com.sparta.springbasic.entity;

import com.sparta.springbasic.dto.CourseRequestDto;
import lombok.Getter;

@Getter
public class Course {
    private Long id;
    private String title;
    private String instructor;
    private double cost;

    public void setId(Long id) {
        this.id = id;
    }
    public Course(CourseRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.instructor = requestDto.getInstructor();
        this.cost = requestDto.getCost();
    }

    public void update(CourseRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.instructor = requestDto.getInstructor();
        this.cost = requestDto.getCost();
    }
}
