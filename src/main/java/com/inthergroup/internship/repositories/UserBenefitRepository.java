package com.inthergroup.internship.repositories;

import com.inthergroup.internship.models.UserBenefit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Deprecated
@Repository
public interface UserBenefitRepository extends JpaRepository<UserBenefit, Long> {
}
