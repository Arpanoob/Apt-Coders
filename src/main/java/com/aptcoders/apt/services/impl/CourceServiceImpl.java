package com.aptcoders.apt.services.impl;

import com.aptcoders.apt.dto.CourceDTO;
import com.aptcoders.apt.entity.Cource;
import com.aptcoders.apt.repository.CourceRepository;

import com.aptcoders.apt.services.CourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
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
        c.setName(courceDTO.getName());
        courceRepository.save((c));
    }
}
