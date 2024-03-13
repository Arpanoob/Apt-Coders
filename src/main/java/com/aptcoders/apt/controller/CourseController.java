package com.aptcoders.apt.controller;

import com.aptcoders.apt.constants.UserRoles;
import com.aptcoders.apt.model.updateCourse;
import com.aptcoders.apt.entity.Course;

import com.aptcoders.apt.model.GetCourseResponse;
import com.aptcoders.apt.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/add")
    public String addUser(@RequestBody Course course)
    {
        courseService.addCources(course);
        return "Success";
    }

@GetMapping("/get")
public ResponseEntity<List<GetCourseResponse>> getCourse (@RequestHeader String authority) {
    // Logic to differentiate output based on user roles
    System.out.println(authority);
    if ((authority != null)) {
        if(Objects.equals(UserRoles.STUDENT.toString(),authority)){
            return ResponseEntity.ok(courseService.getAllCoursesForStudent());
        }
        else if(Objects.equals(UserRoles.TEACHER.toString(),authority)){
            return ResponseEntity.ok(courseService.getAllCoursesForTeacher());
        }
        else if (
                (Objects.equals(UserRoles.COURSE_CREATOR.toString(),authority))) {
            return ResponseEntity.ok(courseService.getAllCoursesForCourseCreator());
        }}
    else
    {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ArrayList<>());
    }
    return ResponseEntity.ok().build();
}
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Long id,@RequestBody Course course)
    {
        courseService.updateCources(id, course);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        courseService.deleteCources(id);

        return ResponseEntity.noContent().build();
    }
    @PatchMapping("/update-name/{id}")
    public ResponseEntity<Void> updateName(@RequestBody updateCourse updateCourse, @PathVariable Long id){
        courseService.updateCources(id, updateCourse);
        return ResponseEntity.noContent().build();
    }
}
