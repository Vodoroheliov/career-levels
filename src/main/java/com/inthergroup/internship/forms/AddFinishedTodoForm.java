package com.inthergroup.internship.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class AddFinishedTodoForm {
    @NotEmpty
    @Size(min=4, max=30)
    private String todoId = "";
    
    private String description = "";
    
    @NotNull
    private Long todoTypeId;

    public String getTodoId() {
        return todoId;
    }

    public void setTodoId(String todoId) {
        this.todoId = todoId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getTodoTypeId() {
        return todoTypeId;
    }

    public void setTodoTypeId(Long todoTypeId) {
        this.todoTypeId = todoTypeId;
    }
}
