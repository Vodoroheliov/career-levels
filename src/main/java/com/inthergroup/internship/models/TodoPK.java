package com.inthergroup.internship.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 * Class that represents primary key of Todo entity.
 * @author interns
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class TodoPK implements Serializable { 
    private User user;
    private CareerLevel careerLevel;
    private String todoId;
 
    @ManyToOne(cascade = CascadeType.ALL)
    public User getUser() {
        return user;
    }
 
    public void setUser(User user) {
        this.user = user;
    }
  
    @ManyToOne(cascade = CascadeType.ALL)
    public CareerLevel getCareerLevel() {
        return careerLevel;
    }

    public void setCareerLevel(CareerLevel careerLevel) {
        this.careerLevel = careerLevel;
    }

    public String getTodoId() {
        return todoId;
    }

    public void setTodoId(String todoId) {
        this.todoId = todoId;
    }

    public int hashCode() {
        return (int) (user.getId() + careerLevel.getId() + 
                ((todoId == null) ? 0 : todoId.hashCode()));
    }

    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null)
            return false;
        if (object instanceof TodoPK) {
            TodoPK otherId = (TodoPK) object;
            return (otherId.user.getId() == this.user.getId())
                    && (otherId.careerLevel.getId() == this.careerLevel.getId()
                    && (this.todoId.equals(otherId.todoId)));
        }
        return false;
    }
}
