package com.inthergroup.internship.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Embeddable
public class UserTodoId implements Serializable { 
    private User user;
    private Todo todo;
 
    @ManyToOne(cascade = CascadeType.ALL)
    public User getUser() {
        return user;
    }
 
    public void setUser(User user) {
        this.user = user;
    }
 
    @ManyToOne(cascade = CascadeType.ALL)
    public Todo getTodo() {
        return todo;
    }
 
    public void setTodo(Todo todo) {
        this.todo = todo;
    }
    
    public int hashCode() {
        return (int) (user.getId() + todo.getId());
    }

    public boolean equals(Object object) {
        if (object instanceof UserTodoId) {
            UserTodoId otherId = (UserTodoId) object;
            return (otherId.user.getId() == this.user.getId())
                    && (otherId.todo.getId() == this.todo.getId());
        }
        return false;
    }
}
