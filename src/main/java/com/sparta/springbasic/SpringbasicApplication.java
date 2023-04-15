package com.sparta.springbasic;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.springbasic.dto.CourseRequestDto;
import com.sparta.springbasic.entity.Course;
import com.sparta.springbasic.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@EnableJpaAuditing
@SpringBootApplication
public class SpringbasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbasicApplication.class, args);
    }

    @Autowired
    private CourseRepository courseRepository;

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            File json = ResourceUtils.getFile("classpath:CourseData.json");

            List<CourseRequestDto> list = new ObjectMapper().readValue(json, new TypeReference<>() {});
            List<Course> courses = list.stream().map(Course::new).collect(Collectors.toCollection(ArrayList::new));

            courseRepository.saveAll(courses);
        };
    }
}
