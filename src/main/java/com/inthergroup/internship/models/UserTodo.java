package com.inthergroup.internship.models;

import java.sql.Timestamp;

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
            joinColumns = @JoinColumn(name = "user_id", nullable = false)),
    @AssociationOverride(name = "primaryKey.todo",
            joinColumns = @JoinColumn(name = "todo_type_id", nullable = false))
})
public class UserTodo {
    
    // ----------------
    // PRIVATE FIELDS
    // ----------------
    
    // composite-id key
    private UserTodoId primaryKey = new UserTodoId();
    
    // additional fields
    private boolean done;
    private int quantity;
    private Timestamp dateOfCompletion;
    private String description;
    
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
    public TodoType getTodoType() {
        return getPrimaryKey().getTodoType();
    }
 
    public void setTodoType(TodoType todoType) {
        getPrimaryKey().setTodoType(todoType);
    }

    @Column(name = "done", nullable = false,
            columnDefinition = "boolean default false")
    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
    
    @Column(name = "quantity", nullable = false,
            columnDefinition = "integer default 1")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Timestamp getDateOfCompletion() {
        return dateOfCompletion;
    }

    public void setDateOfCompletion(Timestamp dateOfCompletion) {
        this.dateOfCompletion = dateOfCompletion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
