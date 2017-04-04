package com.inthergroup.internship.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Embeddable
public class UserTodoId implements Serializable { 
    private User user;
    private TodoType todoType;
 
    @ManyToOne(cascade = CascadeType.ALL)
    public User getUser() {
        return user;
    }
 
    public void setUser(User user) {
        this.user = user;
    }
 
    @ManyToOne(cascade = CascadeType.ALL)
    public TodoType getTodoType() {
        return todoType;
    }
 
    public void setTodoType(TodoType todo) {
        this.todoType = todo;
    }
    
    public int hashCode() {
        return (int) (user.getId() + todoType.getId());
    }

    public boolean equals(Object object) {
        if (object instanceof UserTodoId) {
            UserTodoId otherId = (UserTodoId) object;
            return (otherId.user.getId() == this.user.getId())
                    && (otherId.todoType.getId() == this.todoType.getId());
        }
        return false;
    }
}
