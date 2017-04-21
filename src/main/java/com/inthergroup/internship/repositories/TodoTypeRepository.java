package com.inthergroup.internship.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inthergroup.internship.models.TodoType;

@Repository
public interface TodoTypeRepository extends JpaRepository<TodoType, Long> {
    
    /**
     * Returns a list of all instances of TodoType entity ordered by Id ascending.
     */
    public List<TodoType> findAllByOrderByIdAsc();
    
    /**
     * Returns list of arrays that consist of quantity and todo type names
     * for specific career level.
     * 1st element in array - quantity.
     * 2nd element in array - name of todo type.
     * @param id Career level id.
     */
    @Query("select ct.quantity, tt.name " +
            "from CareerLevelTodo ct, TodoType tt " +
            "where ct.primaryKey.todoType.id = tt.id " +
            "and ct.primaryKey.careerLevel.id = ?1")
    public List<Object[]> findTodosFromLevel(Long id);
}
