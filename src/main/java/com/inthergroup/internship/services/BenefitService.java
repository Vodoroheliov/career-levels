package com.inthergroup.internship.services;

import java.util.List;

import com.inthergroup.internship.models.Benefit;

public interface BenefitService {
    List<Benefit> findAll();

    Benefit findById(Long id);

    Benefit create(Benefit benefit);

    Benefit edit(Benefit benefit);

    void deleteById(Long id);
}
