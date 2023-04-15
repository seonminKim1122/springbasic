package com.sparta.springbasic.service;

import com.sparta.springbasic.dto.CourseRequestDto;
import com.sparta.springbasic.dto.CourseResponseDto;
import com.sparta.springbasic.entity.Course;
import com.sparta.springbasic.repository.CourseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CourseService {
    private final CourseRepository courseRepository = new CourseRepository();

    public String createCourse(CourseRequestDto requestDto) {
        // 브라우저에서 받아온 데이터를 저장하기 위해서 Course 객체로 변환
        Course course = new Course(requestDto);
        return courseRepository.createCourse(course);
    }


    public List<CourseResponseDto> getCourseList() {
        // 테이블에 저장되어 있는 모든 강의 목록을 조회
        return courseRepository.getCourseList();
    }


    public CourseResponseDto getCourse(Long id) {
        // 조회하기 위해 받아온 course 의 id를 사용해서 해당 course 인스턴스가 테이블에 존재하는지 확인하고 가져옵니다.
        Course course = courseRepository.getCourse(id);

        if (course != null) {
            return new CourseResponseDto(course);
        } else {
            return new CourseResponseDto();
        }
    }


    public CourseResponseDto updateCourse(Long id, CourseRequestDto requestDto) {
        // 수정하기 위해 받아온 course 의 id를 사용하여 해당 course 인스턴스가 존재하는지 확인하고 가져옵니다.
        Course course = courseRepository.getCourse(id);

        if (course != null) {
            course.update(requestDto); // 참조하고 있는 형태이기에 인스턴스 필드를 변경하면 알아서 Map 자료 구조 내의 인스턴스에 반영됌.

            return new CourseResponseDto(course);
        }
        return new CourseResponseDto();
    }


    public String deleteCourse(Long id) {
        // 삭제하기 위해 받아온 course 의 id를 사용하여 해당 course 인스턴가 존재하는지 확인하고 가져옵니다.
        Course course = courseRepository.getCourse(id);

        if (course != null) {
            courseRepository.deleteCourse(id);
            return "강의 삭제에 성공했습니다.";
        }

        return "삭제할 강의가 없습니다.";
    }
}
