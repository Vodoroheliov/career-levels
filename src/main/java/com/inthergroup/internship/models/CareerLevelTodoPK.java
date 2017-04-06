package com.inthergroup.internship.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Embeddable
public class CareerLevelTodoPK implements Serializable {
    private CareerLevel careerLevel;
    private TodoType todoType;

    @ManyToOne(cascade = CascadeType.ALL)
    public CareerLevel getCareerLevel() {
        return careerLevel;
    }

    public void setCareerLevel(CareerLevel careerLevel) {
        this.careerLevel = careerLevel;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public TodoType getTodoType() {
        return todoType;
    }

    public void setTodoType(TodoType todoType) {
        this.todoType = todoType;
    }
    
    public int hashCode() {
        return (int) (careerLevel.getId() + todoType.getId());
    }

    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null)
            return false;
        if (object instanceof CareerLevelTodoPK) {
            CareerLevelTodoPK otherId = (CareerLevelTodoPK) object;
            return (otherId.careerLevel.getId() == this.careerLevel.getId()
                    && (otherId.todoType.getId() == this.todoType.getId()));
        }
        return false;
    }
}
