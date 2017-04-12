select tt.name, ct.quantity from todo_types tt, career_levels_todos ct, users u
	where  tt.id = ct.todo_type_id and ct.career_level_id = u.career_level_id
	and u.id = 1
    and ct.todo_type_id not in (select todo_type_id from todos where user_id = 1)