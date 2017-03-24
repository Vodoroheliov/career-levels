use internship;
#use internship_test;

INSERT INTO `users` (`id`,`last_name`,`first_name`,`login`,`password`,`email`, `career_level`) VALUES (1,'Doe','John','john123', 'doe1111', 'john@mail.ru','internship');
INSERT INTO `users` (`id`,`last_name`,`first_name`,`login`,`password`,`email`, `career_level`) VALUES (2,'Public','Mary','public123','mary111', 'mary@mail.ru','internship');
INSERT INTO `users` (`id`,`last_name`,`first_name`,`login`,`password`,`email`, `career_level`) VALUES (3,'Queue','Susan','queue1111','susan123', 'susan@mail.ru','internship');

INSERT INTO `career_levels` (`id`,`level_name`) VALUES (1,'Internship');
INSERT INTO `career_levels` (`id`,`level_name`) VALUES (2,'Baby on board');

INSERT INTO `users_benefits` (`user_id`,`benefit_id`) VALUES (1, 1);
INSERT INTO `users_benefits` (`user_id`,`benefit_id`) VALUES (1, 2);
INSERT INTO `users_benefits` (`user_id`,`benefit_id`) VALUES (1, 3);
INSERT INTO `users_benefits` (`user_id`,`benefit_id`) VALUES (1, 4);

INSERT INTO `users_benefits` (`user_id`,`benefit_id`) VALUES (2, 1);
INSERT INTO `users_benefits` (`user_id`,`benefit_id`) VALUES (2, 2);
INSERT INTO `users_benefits` (`user_id`,`benefit_id`) VALUES (2, 3);
INSERT INTO `users_benefits` (`user_id`,`benefit_id`) VALUES (2, 4);

INSERT INTO `users_benefits` (`user_id`,`benefit_id`) VALUES (3, 1);
INSERT INTO `users_benefits` (`user_id`,`benefit_id`) VALUES (3, 2);
INSERT INTO `users_benefits` (`user_id`,`benefit_id`) VALUES (3, 3);
INSERT INTO `users_benefits` (`user_id`,`benefit_id`) VALUES (3, 4);

INSERT INTO `benefits` (`id`,`benefit_name`) VALUES (1,'Lunch 100%');
INSERT INTO `benefits` (`id`,`benefit_name`) VALUES (2,'Fixed Schedule (9:00-18:00)');
INSERT INTO `benefits` (`id`,`benefit_name`) VALUES (3,'Teambuildings access');
INSERT INTO `benefits` (`id`,`benefit_name`) VALUES (4,'Table + chair');

INSERT INTO `users_todos` (`user_id`,`todo_id`) VALUES (1, 1);
INSERT INTO `users_todos` (`user_id`,`todo_id`) VALUES (2, 1);
INSERT INTO `users_todos` (`user_id`,`todo_id`) VALUES (3, 1);

INSERT INTO `todos` (`id`,`task`) VALUES (1,'Prove you are proactive');

INSERT INTO `users_groups` (`user_id`,`group_id`) VALUES (1, 1);
INSERT INTO `users_groups` (`user_id`,`group_id`) VALUES (2, 1);
INSERT INTO `users_groups` (`user_id`,`group_id`) VALUES (3, 1);

INSERT INTO `groups` (`id`,`group_name`) VALUES (1,'user');
INSERT INTO `groups` (`id`,`group_name`) VALUES (2,'admin');

