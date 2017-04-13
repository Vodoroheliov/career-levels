select count(ct.todo_type_id) as numberOfTodoTypes from career_levels_todos ct
	group by career_level_id order by numberOfTodoTypes asc;
    
select count(ct.todo_type_id) as numberOfTodoTypes from career_levels_todos ct, users u
	where u.career_level_id = ct.career_level_id
    group by u.career_level_id order by numberOfTodoTypes asc;
    
select count(ct.todo_type_id) from career_levels_todos ct, users u
where u.career_level_id = ct.career_level_id and u.id = 1;
    
select count(t.todo_id) from todos t where t.user_id = 2;

select count(u.id) from users u;
select u.id from users u order by id asc