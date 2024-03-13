package com.aptcoders.apt.services.impl;

import com.aptcoders.apt.constants.UserRoles;
import com.aptcoders.apt.dto.CourceDTO;
import com.aptcoders.apt.entity.Cource;
import com.aptcoders.apt.model.GetCourseResponse;
import com.aptcoders.apt.repository.CourceRepository;

import com.aptcoders.apt.services.CourceService;
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
public class CourceServiceImpl implements CourceService {

    @Autowired
    private CourceRepository courceRepository;
    @Override
    public void addCources(Cource cource)
    {
        courceRepository.save(cource);
    }

    @Override
    public List<Cource> getCources() {
        List<Cource> cources = new ArrayList<>();
        courceRepository.findAll().forEach(cources::add);
    return cources;}

    @Override
    public Cource getCources(Long id) {
        return courceRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid"));
    }

    @Override
    public void updateCources(Long id, Cource cource) {
        Cource c =  courceRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid"));
        cource.setId(id);
        System.out.println(cource);
        courceRepository.save(cource);

    }

    @Override
    public void deleteCources(Long id) {
        Cource c =  courceRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid"));
        courceRepository.delete(c);
    }

    @Override
    public void updateCources(Long id, CourceDTO courceDTO) {
        Cource c =  courceRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid"));
        BeanUtils.copyProperties(courceDTO,c,getNullPropertyNames(courceDTO));
        courceRepository.save((c));
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
        var courses = courceRepository.findAll();
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
        var courses = courceRepository.findAll();
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
        var courses = courceRepository.findAll();
        courses.forEach(course -> {
            var courseResponse = new GetCourseResponse();
            BeanUtils.copyProperties(course,courseResponse,getNullPropertyNames(course));
            courseResponse.setRole(UserRoles.TEACHER);
            getCourses.add(courseResponse);
        });
        return getCourses;
    }
}
