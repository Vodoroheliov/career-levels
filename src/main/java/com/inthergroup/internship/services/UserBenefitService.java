package com.inthergroup.internship.services;

import java.util.List;

import com.inthergroup.internship.models.UserBenefit;

@Deprecated
public interface UserBenefitService {
    List<UserBenefit> findAll();

    UserBenefit findById(Long id);

    UserBenefit create(UserBenefit userBenefit);

    UserBenefit edit(UserBenefit userBenefit);

    void deleteById(Long id);
}
