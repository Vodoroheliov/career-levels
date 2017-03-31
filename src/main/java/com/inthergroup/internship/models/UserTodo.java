package com.inthergroup.internship.models;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "users_todos")
@AssociationOverrides({
    @AssociationOverride(name = "primaryKey.user",
            joinColumns = @JoinColumn(name = "user_id")),
    @AssociationOverride(name = "primaryKey.todo",
            joinColumns = @JoinColumn(name = "todo_id"))
})
public class UserTodo {
    
    // ----------------
    // PRIVATE FIELDS
    // ----------------
    
    // composite-id key
    private UserTodoId primaryKey = new UserTodoId();
    
    // additional fields
    private boolean done;
    
    // ---------------
    // PUBLIC METHODS
    // ---------------

    @EmbeddedId
    public UserTodoId getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(UserTodoId primaryKey) {
        this.primaryKey = primaryKey;
    }
    
    @Transient
    public User getUser() {
        return getPrimaryKey().getUser();
    }
 
    public void setUser(User user) {
        getPrimaryKey().setUser(user);
    }
 
    @Transient
    public Todo getTodo() {
        return getPrimaryKey().getTodo();
    }
 
    public void setTodo(Todo todo) {
        getPrimaryKey().setTodo(todo);
    }

    @Column(name = "done", nullable = false,
            columnDefinition = "boolean default false")
    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
    
    public int hashCode() {
        return primaryKey.hashCode();
    }

    public boolean equals(Object object) {
        if (object instanceof UserTodo) {
            return primaryKey.equals(((UserTodo) object).getPrimaryKey());
        }
        return false;
    }
}
