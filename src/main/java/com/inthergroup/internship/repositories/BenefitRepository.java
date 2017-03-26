package com.inthergroup.internship.repositories;

import com.inthergroup.internship.models.Benefit;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BenefitRepository extends JpaRepository<Benefit, Long> {
    @Query("select benefitName from Benefit where id in " +
            "(select b.id from Benefit b inner join b.careerLevels c where c.id = ?1)")
    public List<String> findBenefitsFromLevel(Long id);
}
