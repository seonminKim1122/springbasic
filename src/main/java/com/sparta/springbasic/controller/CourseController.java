package com.sparta.springbasic.controller;

import com.sparta.springbasic.dto.CourseRequestDto;
import com.sparta.springbasic.dto.CourseResponseDto;
import com.sparta.springbasic.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 지금 이 클래스로 만든 객체가 RestController 의 역할을 할 거다.
@RequestMapping("/course") // 요청이 들어올 때 localhost:8080/course/~~ 가 되게 만들어 줌.
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }
    @PostMapping("/create") // POST 요청에 대한 처리를 할 거다.
    public String createCourse(@RequestBody CourseRequestDto requestDto) {
        return courseService.createCourse(requestDto);
    }

    @GetMapping("/list")
    public List<CourseResponseDto> getCourseList() {
        return courseService.getCourseList();
    }

    @GetMapping("/{id}") // http://localhost:8080/course/{id}
    public CourseResponseDto getCourse(@PathVariable Long id) {
        return courseService.getCourse(id);
    }

    @PutMapping("/update/{id}")
    public CourseResponseDto updateCourse(@PathVariable Long id, @RequestBody CourseRequestDto requestDto) {
        return courseService.updateCourse(id, requestDto);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id) {
        return courseService.deleteCourse(id);
    }
}
