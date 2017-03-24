package com.inthergroup.internship.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.inthergroup.internship.models.UserBenefit;
import com.inthergroup.internship.repositories.UserBenefitRepository;

@Deprecated
@Service
@Primary
public class UserBenefitServiceJpaImpl implements UserBenefitService {
    @Autowired
    private UserBenefitRepository userBenefitRepo;

    @Override
    public List<UserBenefit> findAll() {
        return this.userBenefitRepo.findAll();
    }

    @Override
    public UserBenefit findById(Long id) {
        return this.userBenefitRepo.findOne(id);
    }

    @Override
    public UserBenefit create(UserBenefit userBenefit) {
        return this.userBenefitRepo.save(userBenefit);
    }

    @Override
    public UserBenefit edit(UserBenefit userBenefit) {
        return this.userBenefitRepo.save(userBenefit);
    }

    @Override
    public void deleteById(Long id) {
        this.userBenefitRepo.delete(id);
    }
}
