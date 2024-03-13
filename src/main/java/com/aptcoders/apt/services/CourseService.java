package com.aptcoders.apt.services;

import com.aptcoders.apt.model.updateCourse;
import com.aptcoders.apt.entity.Course;
import com.aptcoders.apt.model.GetCourseResponse;

import java.util.List;

public interface CourseService {
    void addCources(Course course);

    List<Course> getCources();
    Course getCources(Long id);
    void updateCources(Long id, Course course);

    void deleteCources(Long id);

    void updateCources(Long id, updateCourse updateCourse);
    public List<GetCourseResponse> getAllCoursesForCourseCreator();
    public List<GetCourseResponse> getAllCoursesForStudent();
    public List<GetCourseResponse> getAllCoursesForTeacher();
}
