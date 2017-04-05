package com.inthergroup.internship.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Embeddable
public class CareerLevelBenefitPK implements Serializable {
    private CareerLevel careerLevel;
    private BenefitType benefitType;

    @ManyToOne(cascade = CascadeType.ALL)
    public CareerLevel getCareerLevel() {
        return careerLevel;
    }

    public void setCareerLevel(CareerLevel careerLevel) {
        this.careerLevel = careerLevel;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public BenefitType getBenefitType() {
        return benefitType;
    }

    public void setBenefitType(BenefitType benefitType) {
        this.benefitType = benefitType;
    }
    
    public int hashCode() {
        return (int) (careerLevel.getId() + benefitType.getId());
    }

    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null)
            return false;
        if (object instanceof CareerLevelBenefitPK) {
            CareerLevelBenefitPK otherId = (CareerLevelBenefitPK) object;
            return (otherId.careerLevel.getId() == this.careerLevel.getId()
                    && (otherId.benefitType.getId() == this.benefitType.getId()));
        }
        return false;
    }
}
