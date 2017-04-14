package com.inthergroup.internship.models;

import java.util.Date;
import java.sql.Timestamp;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
<<<<<<< HEAD
 * An entity Todo represents a finished task.
=======
 * An entity Todo represents a task for a user.
>>>>>>> origin/forms
 * The Entity annotation indicates that this class is a JPA entity.
 * The Table annotation specifies the name for the table in the db.
 *
 * @author interns
 */
@Entity
@Table(name = "todos")
@AssociationOverrides({
    @AssociationOverride(name = "primaryKey.user",
            joinColumns = @JoinColumn(name = "user_id", nullable = false)),
    @AssociationOverride(name = "primaryKey.careerLevel",
            joinColumns = @JoinColumn(name = "career_level_id", nullable = false)),
    @AssociationOverride(name = "primaryKey.todoId",
            joinColumns = @JoinColumn(name = "todo_id", nullable = false))
})
public class Todo {
    
    // ----------------
    // PRIVATE FIELDS
    // ----------------
    
    // composite-id key
    private TodoPK primaryKey = new TodoPK();
    
    // additional fields
    private long todoTypeId;
    private Date dateOfCompletion;
    private String description;
    
    // ---------------
    // PUBLIC METHODS
    // ---------------

    @EmbeddedId
    public TodoPK getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(TodoPK primaryKey) {
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
    public CareerLevel getCareerLevel() {
        return getPrimaryKey().getCareerLevel();
    }
 
    public void setCareerLevel(CareerLevel careerLevel) {
        getPrimaryKey().setCareerLevel(careerLevel);
    }
    
    @Transient
    public String getTodoId() {
        return getPrimaryKey().getTodoId();
    }
 
    public void setTodoId(String todoId) {
        getPrimaryKey().setTodoId(todoId);
    }

    @Column(name = "todo_type_id", nullable = false)
    public long getTodoTypeId() {
        return todoTypeId;
    }

    public void setTodoTypeId(long todoTypeId) {
        this.todoTypeId = todoTypeId;
    }

    // TODO Test with this column constraint:
//    @Column(name = "date_of_completion", nullable = false)
    public Date getDateOfCompletion() {
        return dateOfCompletion;
    }

    public void setDateOfCompletion(Date dateOfCompletion) {
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
        if (object instanceof Todo) {
            return primaryKey.equals(((Todo) object).getPrimaryKey());
        }
        return false;
    }
}
