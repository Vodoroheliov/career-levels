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
 * An entity CareerLevelTodo represents the user task for a specific level.
 * The Entity annotation indicates that this class is a JPA entity.
 * The Table annotation specifies the name for the table in the db.
 *
 * @author interns
 */
@Entity
@Table(name = "career_levels_todos")
@AssociationOverrides({
    @AssociationOverride(name = "primaryKey.careerLevel",
            joinColumns = @JoinColumn(name = "career_level_id", nullable = false)),
    @AssociationOverride(name = "primaryKey.todoType",
            joinColumns = @JoinColumn(name = "todo_type_id", nullable = false))
})
public class CareerLevelTodo {
    
    // ----------------
    // PRIVATE FIELDS
    // ----------------
    
    /**
     * composite-id key
     */
    private CareerLevelTodoPK primaryKey = new CareerLevelTodoPK();
    
    // additional fields
    
    private int quantity;
    
    // ---------------
    // PUBLIC METHODS
    // ---------------

    @EmbeddedId
    public CareerLevelTodoPK getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(CareerLevelTodoPK primaryKey) {
        this.primaryKey = primaryKey;
    }
    
    /**
     * Get required career level for this todo.
     */
    @Transient
    public CareerLevel getCareerLevel() {
        return getPrimaryKey().getCareerLevel();
    }
    
    /**
     * Set required career level for this todo.
     */
    public void setCareerLevel(CareerLevel careerLevel) {
        getPrimaryKey().setCareerLevel(careerLevel);
    }
    
    @Transient
    public TodoType getTodoType() {
        return getPrimaryKey().getTodoType();
    }
    
    public void setTodoType(TodoType todoType) {
        getPrimaryKey().setTodoType(todoType);
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
        if (object instanceof CareerLevelTodo) {
            return primaryKey.equals(((CareerLevelTodo) object).getPrimaryKey());
        }
        return false;
    }
}
