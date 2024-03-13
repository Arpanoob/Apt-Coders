package com.aptcoders.apt.services.impl;

import com.aptcoders.apt.constants.UserRoles;
import com.aptcoders.apt.model.updateCourse;
import com.aptcoders.apt.entity.Course;
import com.aptcoders.apt.model.GetCourseResponse;
import com.aptcoders.apt.repository.CourseRepository;

import com.aptcoders.apt.services.CourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Override
    public void addCources(Course course)
    {
        courseRepository.save(course);
    }

    @Override
    public List<Course> getCources() {
        List<Course> courses = new ArrayList<>();
        courseRepository.findAll().forEach(courses::add);
    return courses;}

    @Override
    public Course getCources(Long id) {
        return courseRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid"));
    }

    @Override
    public void updateCources(Long id, Course course) {
        Course c =  courseRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid"));
        course.setId(id);
        System.out.println(course);
        courseRepository.save(course);

    }

    @Override
    public void deleteCources(Long id) {
        Course c =  courseRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid"));
        courseRepository.delete(c);
    }

    @Override
    public void updateCources(Long id, updateCourse updateCourse) {
        Course c =  courseRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid"));
        BeanUtils.copyProperties(updateCourse,c,getNullPropertyNames(updateCourse));
        courseRepository.save((c));
    }
    private String[] getNullPropertyNames(Object sourceForObjectCopy) {
        final var src = new BeanWrapperImpl(sourceForObjectCopy);
        var pds = src.getPropertyDescriptors();

        var emptyNames = new HashSet<String>();
        for (var pd : pds) {
            var srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        var result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
    public List<GetCourseResponse> getAllCoursesForStudent() {
        var getCourses = new ArrayList<GetCourseResponse>();
        var courses = courseRepository.findAll();
        courses.forEach(course -> {
            var courseResponse = new GetCourseResponse();
            BeanUtils.copyProperties(course,courseResponse,getNullPropertyNames(course));
            courseResponse.setRole(UserRoles.STUDENT);
            getCourses.add(courseResponse);
        });
        return getCourses;
    }

    public List<GetCourseResponse> getAllCoursesForCourseCreator() {
        var getCourses = new ArrayList<GetCourseResponse>();
        var courses = courseRepository.findAll();
        courses.forEach(course -> {
            var courseResponse = new GetCourseResponse();
            BeanUtils.copyProperties(course,courseResponse,getNullPropertyNames(course));
            courseResponse.setRole(UserRoles.COURSE_CREATOR);
            getCourses.add(courseResponse);
        });
        return getCourses;
    }

    public List<GetCourseResponse> getAllCoursesForTeacher() {
        var getCourses = new ArrayList<GetCourseResponse>();
        var courses = courseRepository.findAll();
        courses.forEach(course -> {
            var courseResponse = new GetCourseResponse();
            BeanUtils.copyProperties(course,courseResponse,getNullPropertyNames(course));
            courseResponse.setRole(UserRoles.TEACHER);
            getCourses.add(courseResponse);
        });
        return getCourses;
    }
}
