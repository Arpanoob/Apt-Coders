package com.aptcoders.apt.controller;

import com.aptcoders.apt.constants.UserRoles;
import com.aptcoders.apt.dto.CourceDTO;
import com.aptcoders.apt.entity.Cource;

import com.aptcoders.apt.model.GetCourseResponse;
import com.aptcoders.apt.services.CourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/cource/")
public class CourceController {

    @Autowired
    private CourceService courceService;

    @PostMapping("/add")
    public String addUser(@RequestBody Cource cource)
    {
        courceService.addCources(cource);
        return "Success";
    }
    @GetMapping("")
    public List<Cource> getUsers()
    {
        return courceService.getCources();
    }
//    public Cource getUser(@RequestParam Long id)
//    {
//
//        return  courceService.getCources(id);
//    }
//
//
@GetMapping("/get")
public ResponseEntity<List<GetCourseResponse>> getCourse (@RequestHeader String authority) {
    // Logic to differentiate output based on user roles
    if ((authority != null)) {
        if(Objects.equals(UserRoles.STUDENT,authority)){
            return ResponseEntity.ok(courceService.getAllCoursesForStudent());
        }
        else if(Objects.equals(UserRoles.TEACHER,authority)){
            return ResponseEntity.ok(courceService.getAllCoursesForTeacher());
        }
        else if (
                (Objects.equals(UserRoles.COURSE_CREATOR,authority))) {
            return ResponseEntity.ok(courceService.getAllCoursesForCourseCreator());
        }}
    else
    {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ArrayList<>());
    }
    return ResponseEntity.ok().build();
}
// Logic to differentiate output based on user role
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Long id,@RequestBody Cource user)
    {
        courceService.updateCources(id,user);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        courceService.deleteCources(id);

        return ResponseEntity.noContent().build();
    }
    @PatchMapping("/update-name/{id}")
    public ResponseEntity<Void> updateName(@RequestBody CourceDTO courceDTO, @PathVariable Long id){
        courceService.updateCources(id,courceDTO);
        return ResponseEntity.noContent().build();
    }
}
