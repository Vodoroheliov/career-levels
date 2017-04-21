package com.inthergroup.internship.models;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * An entity CareerLevelBenefit represents the user benefit for a specific level.
 * The Entity annotation indicates that this class is a JPA entity.
 * The Table annotation specifies the name for the table in the db.
 *
 * @author interns
 */
@Entity
@Table(name = "career_levels_benefits")
@AssociationOverrides({
    @AssociationOverride(name = "primaryKey.careerLevel",
            joinColumns = @JoinColumn(name = "career_level_id", nullable = false)),
    @AssociationOverride(name = "primaryKey.benefitType",
            joinColumns = @JoinColumn(name = "benefit_type_id", nullable = false))
})
public class CareerLevelBenefit {
    
    // ----------------
    // PRIVATE FIELDS
    // ----------------
    
    /**
     *  composite-id key
     */
    private CareerLevelBenefitPK primaryKey = new CareerLevelBenefitPK();
    
    // additional fields
    
    private int quantity;
    
    // ---------------
    // PUBLIC METHODS
    // ---------------

    @EmbeddedId
    public CareerLevelBenefitPK getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(CareerLevelBenefitPK primaryKey) {
        this.primaryKey = primaryKey;
    }
    
    /**
     * Get required career level for this benefit.
     */
    @Transient
    public CareerLevel getCareerLevel() {
        return getPrimaryKey().getCareerLevel();
    }
    
    /**
     * Set required career level for this benefit.
     */
    public void setCareerLevel(CareerLevel careerLevel) {
        getPrimaryKey().setCareerLevel(careerLevel);
    }
    
    @Transient
    public BenefitType getBenefitType() {
        return getPrimaryKey().getBenefitType();
    }
    
    public void setBenefitType(BenefitType benefitType) {
        getPrimaryKey().setBenefitType(benefitType);
    }

    @Column(nullable = false, columnDefinition = "int default 1")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public int hashCode() {
        return primaryKey.hashCode();
    }

    public boolean equals(Object object) {
        if (object instanceof CareerLevelBenefit) {
            return primaryKey.equals(((CareerLevelBenefit) object).getPrimaryKey());
        }
        return false;
    }
}
