package com.aptcoders.apt.controller;

import com.aptcoders.apt.dto.CourceDTO;
import com.aptcoders.apt.entity.Cource;

import com.aptcoders.apt.services.CourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/")
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
    @GetMapping("/get")
    public Cource getUser(@RequestParam Long id)
    {
        return  courceService.getCources(id);
    }
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
