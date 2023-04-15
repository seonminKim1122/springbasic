package com.sparta.springbasic.repository;

import com.sparta.springbasic.dto.CourseRequestDto;
import com.sparta.springbasic.dto.CourseResponseDto;
import com.sparta.springbasic.entity.Course;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CourseRepository {

    private static final Map<Long, Course> table = new HashMap<>();
    private static long ID;

    public String createCourse(Course course) {
        // ID 중복을 막기 위해서 현재 table 의 최대 ID + 1
        course.setId(++ID);

        // 테이블에 생성한 Course 인스턴스를 저장
        table.put(ID, course);

        return "강의 저장에 성공했습니다.";
    }


    public List<CourseResponseDto> getCourseList() {
        // 테이블에 저장되어 있는 모든 강의 목록을 조회
        return table.values().stream().map(CourseResponseDto::new).collect(Collectors.toList());
    }


    public Course getCourse(Long id) {
        // 조회하기 위해 받아온 course 의 id를 사용해서 해당 course 인스턴스가 테이블에 존재하는지 확인하고 가져옵니다.
        return table.get(id);
    }


    public void deleteCourse(Long id) {
        // 삭제하기 위해 받아온 course 의 id를 사용하여 해당 course 인스턴가 존재하는지 확인하고 가져옵니다.
        table.remove(id);
    }

}
