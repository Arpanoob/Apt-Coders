package com.aptcoders.apt.services;

import com.aptcoders.apt.dto.CourceDTO;
import com.aptcoders.apt.entity.Cource;

import java.util.List;

public interface CourceService {
    void addCources(Cource cource);

    List<Cource> getCources();
    Cource getCources(Long id);
    void updateCources(Long id, Cource cource);

    void deleteCources(Long id);

    void updateCources(Long id, CourceDTO courceDTO);
}
