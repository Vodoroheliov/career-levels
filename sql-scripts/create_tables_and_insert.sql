create database if not exists internship;

use internship


drop table if exists `career_levels_benefits`;

CREATE TABLE `career_levels_benefits` (
	`career_level_id` int (20) not null AUTO_INCREMENT,
	`benefit_type_id` int (20) not null,
	`quantity` integer not null default 1,
	PRIMARY KEY (`career_level_id`, `benefit_type_id`)
);

# Benefits for Internship level
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (1, 1, 1);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (1, 2, 1);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (1, 3, 1);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (1, 4, 1);

# Benefits for Baby on Board level
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (2, 5, 1);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (2, 6, 1);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (2, 7, 1);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (2, 8, 1);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (2, 3, 1);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (2, 9, 1);

# Benefits for First Steps level
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (3, 5, 1);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (3, 6, 1);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (3, 10, 1);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (3, 7, 1);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (3, 8, 1);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (3, 3, 1);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (3, 9, 1);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (3, 11, 1);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (3, 12, 150);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (3, 13, 200);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (3, 14, 1);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (3, 15, 1);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (3, 16, 1);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (3, 17, 1);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (3, 18, 1);

# Benefits for You are Good! level
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (4, 5, 1);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (4, 6, 1);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (4, 19, 1);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (4, 7, 1);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (4, 8, 1);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (4, 3, 1);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (4, 9, 1);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (4, 20, 1);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (4, 12, 300);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (4, 13, 300);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (4, 14, 1);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (4, 15, 1);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (4, 16, 3);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (4, 21, 1);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (4, 22, 8000);

# Benefits for You Rock! level
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (5, 5, 1);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (5, 6, 1);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (5, 23, 1);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (5, 7, 1);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (5, 8, 1);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (5, 3, 1);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (5, 9, 1);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (5, 24, 1);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (5, 12, 500);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (5, 13, 500);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (5, 14, 1);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (5, 15, 1);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (5, 16, 5);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (5, 21, 3);
INSERT INTO `career_levels_benefits` (`career_level_id`, `benefit_type_id`, `quantity`) VALUES (5, 22, 8000);


drop table if exists `benefit_types`;

CREATE TABLE `benefit_types` (
  `id` int(20) not null AUTO_INCREMENT,
  `name` varchar(64) not null,
  primary key (`id`),
  UNIQUE (`name`)
);

INSERT INTO `benefit_types` (`id`,`name`) VALUES (1,'Lunch 100%');
INSERT INTO `benefit_types` (`id`,`name`) VALUES (2,'Fixed Schedule (9:00-18:00)');
INSERT INTO `benefit_types` (`id`,`name`) VALUES (3,'Teambuildings access');
INSERT INTO `benefit_types` (`id`,`name`) VALUES (4,'Table + chair');
INSERT INTO `benefit_types` (`id`,`name`) VALUES (5,'Lunch 50%');
INSERT INTO `benefit_types` (`id`,`name`) VALUES (6,'Fixed salary');
INSERT INTO `benefit_types` (`id`,`name`) VALUES (7,'Laptop');
INSERT INTO `benefit_types` (`id`,`name`) VALUES (8,'Library access');
INSERT INTO `benefit_types` (`id`,`name`) VALUES (9,'English classes');
INSERT INTO `benefit_types` (`id`,`name`) VALUES (10,'Flexible schedule1 (9:00-18:00)+/-30 min');
INSERT INTO `benefit_types` (`id`,`name`) VALUES (11,'New equipment priority 3');
INSERT INTO `benefit_types` (`id`,`name`) VALUES (12,'(EURO) Personal budget');
INSERT INTO `benefit_types` (`id`,`name`) VALUES (13,'(MDL) Monthly for sports');
INSERT INTO `benefit_types` (`id`,`name`) VALUES (14,'Private health insurance');
INSERT INTO `benefit_types` (`id`,`name`) VALUES (15,'Self-development club (1.25h per week)');
INSERT INTO `benefit_types` (`id`,`name`) VALUES (16,'Suggest books per year');
INSERT INTO `benefit_types` (`id`,`name`) VALUES (17,'OCA Java');
INSERT INTO `benefit_types` (`id`,`name`) VALUES (18,'Visit to NL');
INSERT INTO `benefit_types` (`id`,`name`) VALUES (19,'Flexible schedule2 (9:00-18:00)+/-1h');
INSERT INTO `benefit_types` (`id`,`name`) VALUES (20,'New equipment priority 2');
INSERT INTO `benefit_types` (`id`,`name`) VALUES (21,'Days per month work from home');
INSERT INTO `benefit_types` (`id`,`name`) VALUES (22,'(EURO) credit');
INSERT INTO `benefit_types` (`id`,`name`) VALUES (23,'Flexible schedule3 (40h per week)');
INSERT INTO `benefit_types` (`id`,`name`) VALUES (24,'New equipment priority 1');


drop table if exists `todos`;

# Finished tasks for each user
CREATE TABLE `todos` (
  `user_id` int(20) not null AUTO_INCREMENT, # do we need auto_increment here?
  `career_level_id` int(20) not null,
  `todo_id` varchar(64) not null, # e.g. title of the book
  `todo_type_id` int (20) not null,
  `date_of_completion` datetime not null default now(),
  `description` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`user_id`, `career_level_id`, `todo_id`)
);

INSERT INTO `todos`(`user_id`, `career_level_id`, `todo_id`, `todo_type_id`, `date_of_completion`, `description`) VALUES(1, 1, 'I did it', 1, '2017-04-09 19:31:27', 'It was interesting!');
INSERT INTO `todos`(`user_id`, `career_level_id`, `todo_id`, `todo_type_id`, `date_of_completion`, `description`) VALUES(2, 1, 'I did it!', 1, '2017-04-09 20:27:49', 'It was very interesting.');
INSERT INTO `todos`(`user_id`, `career_level_id`, `todo_id`, `todo_type_id`, `date_of_completion`, `description`) VALUES(2, 2, 'Tracking report', 4, '2017-04-09 19:37:07', 'Interesting report.');
INSERT INTO `todos`(`user_id`, `career_level_id`, `todo_id`, `todo_type_id`, `date_of_completion`, `description`) VALUES(2, 2, 'trial period', 2, '2017-04-09 18:29:03', 'Doing stuff.');
INSERT INTO `todos`(`user_id`, `career_level_id`, `todo_id`, `todo_type_id`, `date_of_completion`, `description`) VALUES(4, 2, 'trial period', 2, '2017-04-09 18:29:03', 'Doing stuff.');
INSERT INTO `todos`(`user_id`, `career_level_id`, `todo_id`, `todo_type_id`, `date_of_completion`, `description`) VALUES(4, 2, 'Good book', 3, '2017-04-09 18:29:03', 'Learned a lot.');
INSERT INTO `todos`(`user_id`, `career_level_id`, `todo_id`, `todo_type_id`, `date_of_completion`, `description`) VALUES(9, 2, 'trial period', 2, '2017-04-09 18:29:03', 'Doing stuff.');


drop table if exists `career_levels_todos`;

CREATE TABLE `career_levels_todos` (
  `career_level_id` int(20) not null AUTO_INCREMENT,
  `todo_type_id` int (20) not null,
  `quantity` integer not null default 1,
  PRIMARY KEY (`career_level_id`, `todo_type_id`)
);

# Todos for Internship level
INSERT INTO `career_levels_todos` (`career_level_id`,`todo_type_id`, `quantity`) VALUES (1, 1, 1);

# Todos for Baby on Board level
INSERT INTO `career_levels_todos` (`career_level_id`,`todo_type_id`, `quantity`) VALUES (2, 2, 1);
INSERT INTO `career_levels_todos` (`career_level_id`,`todo_type_id`, `quantity`) VALUES (2, 3, 1);
INSERT INTO `career_levels_todos` (`career_level_id`,`todo_type_id`, `quantity`) VALUES (2, 4, 1);
INSERT INTO `career_levels_todos` (`career_level_id`,`todo_type_id`, `quantity`) VALUES (2, 5, 3);
INSERT INTO `career_levels_todos` (`career_level_id`,`todo_type_id`, `quantity`) VALUES (2, 6, 3);
INSERT INTO `career_levels_todos` (`career_level_id`,`todo_type_id`, `quantity`) VALUES (2, 7, 1);
INSERT INTO `career_levels_todos` (`career_level_id`,`todo_type_id`, `quantity`) VALUES (2, 8, 1);

# Todos for First Steps level
INSERT INTO `career_levels_todos` (`career_level_id`,`todo_type_id`, `quantity`) VALUES (3, 9, 4);
INSERT INTO `career_levels_todos` (`career_level_id`,`todo_type_id`, `quantity`) VALUES (3, 4, 1);
INSERT INTO `career_levels_todos` (`career_level_id`,`todo_type_id`, `quantity`) VALUES (3, 5, 5);
INSERT INTO `career_levels_todos` (`career_level_id`,`todo_type_id`, `quantity`) VALUES (3, 7, 3);
INSERT INTO `career_levels_todos` (`career_level_id`,`todo_type_id`, `quantity`) VALUES (3, 8, 3);
INSERT INTO `career_levels_todos` (`career_level_id`,`todo_type_id`, `quantity`) VALUES (3, 10, 1);
INSERT INTO `career_levels_todos` (`career_level_id`,`todo_type_id`, `quantity`) VALUES (3, 11, 1);
INSERT INTO `career_levels_todos` (`career_level_id`,`todo_type_id`, `quantity`) VALUES (3, 12, 1);

# Todos for You are good! level
INSERT INTO `career_levels_todos` (`career_level_id`,`todo_type_id`, `quantity`) VALUES (4, 9, 7);
INSERT INTO `career_levels_todos` (`career_level_id`,`todo_type_id`, `quantity`) VALUES (4, 4, 1);
INSERT INTO `career_levels_todos` (`career_level_id`,`todo_type_id`, `quantity`) VALUES (4, 5, 10);
INSERT INTO `career_levels_todos` (`career_level_id`,`todo_type_id`, `quantity`) VALUES (4, 7, 5);
INSERT INTO `career_levels_todos` (`career_level_id`,`todo_type_id`, `quantity`) VALUES (4, 8, 5);
INSERT INTO `career_levels_todos` (`career_level_id`,`todo_type_id`, `quantity`) VALUES (4, 13, 1);
INSERT INTO `career_levels_todos` (`career_level_id`,`todo_type_id`, `quantity`) VALUES (4, 11, 3);
INSERT INTO `career_levels_todos` (`career_level_id`,`todo_type_id`, `quantity`) VALUES (4, 14, 1);
INSERT INTO `career_levels_todos` (`career_level_id`,`todo_type_id`, `quantity`) VALUES (4, 15, 1);
INSERT INTO `career_levels_todos` (`career_level_id`,`todo_type_id`, `quantity`) VALUES (4, 16, 1);

# Todos for You rock! level
INSERT INTO `career_levels_todos` (`career_level_id`,`todo_type_id`, `quantity`) VALUES (5, 9, 10);
INSERT INTO `career_levels_todos` (`career_level_id`,`todo_type_id`, `quantity`) VALUES (5, 4, 1);
INSERT INTO `career_levels_todos` (`career_level_id`,`todo_type_id`, `quantity`) VALUES (5, 5, 15);
INSERT INTO `career_levels_todos` (`career_level_id`,`todo_type_id`, `quantity`) VALUES (5, 7, 10);
INSERT INTO `career_levels_todos` (`career_level_id`,`todo_type_id`, `quantity`) VALUES (5, 8, 10);
INSERT INTO `career_levels_todos` (`career_level_id`,`todo_type_id`, `quantity`) VALUES (5, 13, 1);
INSERT INTO `career_levels_todos` (`career_level_id`,`todo_type_id`, `quantity`) VALUES (5, 11, 3);
INSERT INTO `career_levels_todos` (`career_level_id`,`todo_type_id`, `quantity`) VALUES (5, 14, 1);
INSERT INTO `career_levels_todos` (`career_level_id`,`todo_type_id`, `quantity`) VALUES (5, 15, 1);
INSERT INTO `career_levels_todos` (`career_level_id`,`todo_type_id`, `quantity`) VALUES (5, 16, 1);


drop table if exists `todo_types`;

CREATE TABLE `todo_types` (
  `id` int(20) not null AUTO_INCREMENT,
  `name` varchar(64) not null,
  PRIMARY KEY (`id`),
  UNIQUE (`name`)
);

INSERT INTO `todo_types` (`id`,`name`) VALUES (1,'Prove you are proactive');
INSERT INTO `todo_types` (`id`,`name`) VALUES (2,'Finish trial period');
INSERT INTO `todo_types` (`id`,`name`) VALUES (3,'Read "Warehouse & Distribution Science"');
INSERT INTO `todo_types` (`id`,`name`) VALUES (4,'Daily time tracking report');
INSERT INTO `todo_types` (`id`,`name`) VALUES (5,'Ideas for the company');
INSERT INTO `todo_types` (`id`,`name`) VALUES (6,'Months in the company');
INSERT INTO `todo_types` (`id`,`name`) VALUES (7,'Articles');
INSERT INTO `todo_types` (`id`,`name`) VALUES (8,'Presentations');
INSERT INTO `todo_types` (`id`,`name`) VALUES (9,'Books per year');
INSERT INTO `todo_types` (`id`,`name`) VALUES (10,'English upper-intermediate');
INSERT INTO `todo_types` (`id`,`name`) VALUES (11,'Responsibilities');
INSERT INTO `todo_types` (`id`,`name`) VALUES (12,'Be independent');
INSERT INTO `todo_types` (`id`,`name`) VALUES (13,'English advanced');
INSERT INTO `todo_types` (`id`,`name`) VALUES (14,'PM for 3 projects (incl. 5PM club)');
INSERT INTO `todo_types` (`id`,`name`) VALUES (15,'Manage 3 pers.');
INSERT INTO `todo_types` (`id`,`name`) VALUES (16,'Buddy 5 pers.');



/* drop table if exists `users_groups`;

CREATE TABLE `users_groups` (
  `user_id`  int(20) not null AUTO_INCREMENT,
  `group_id` int(20) not null,
  `registered_date` datetime,
  PRIMARY KEY (`user_id`, `group_id`)
);

INSERT INTO `users_groups` (`user_id`, `group_id`) VALUES (1, 1);
INSERT INTO `users_groups` (`user_id`, `group_id`) VALUES (2, 1);
INSERT INTO `users_groups` (`user_id`, `group_id`) VALUES (3, 1);
INSERT INTO `users_groups` (`user_id`, `group_id`) VALUES (4, 1);
INSERT INTO `users_groups` (`user_id`, `group_id`) VALUES (5, 1);
*/


drop table if exists groups;

  create table `groups` (
  `id` int(20) not null AUTO_INCREMENT,
  `role` varchar(64) not null,
  PRIMARY KEY (`id`),
  UNIQUE (`role`)
);

INSERT INTO `groups` (`id`, `role`) VALUES (1,'USER');
INSERT INTO `groups` (`id`, `role`) VALUES (2,'ADMIN');


drop table if exists `users`;

CREATE TABLE `users` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(64) NOT NULL,
  `first_name` varchar(64) NOT NULL,
  `username` varchar(64) NOT NULL,
  `password_hash` varchar(64) NOT NULL,
  `email` varchar(64) NOT NULL,
  `career_level_id` int(20) NOT NULL,
  `group_id` int(20) NOT NULL,
   PRIMARY KEY (`id`),
   UNIQUE (`username`, `email`)
);

INSERT INTO `users` (`id`, `last_name`, `first_name`, `username`, `password_hash`, `email`, `career_level_id`, `group_id`) VALUES (1,'Goodman', 'John','admin', '$2a$10$y4tU2GY6BGz6/B.qMbs.6eBetMOHW2SkNhnOOq/y/Id5NaTYW37DO', 'goodman@gmail.com', 1, 2);
INSERT INTO `users` (`id`, `last_name`, `first_name`, `username`, `password_hash`, `email`, `career_level_id`, `group_id`) VALUES (2,'Ivanov', 'Alexandr','user', '$2a$10$xZV57Td6nvKOnTsW986XO.j2dr10gow506U1.fC1u0aJMB6XtJG6C', 'ivanov@gmail.com', 2, 1);
INSERT INTO `users` (`id`, `last_name`, `first_name`, `username`, `password_hash`, `email`, `career_level_id`, `group_id`) VALUES (3,'Doe', 'John','john123', '$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6', 'john@mail.com', 1, 1);
INSERT INTO `users` (`id`, `last_name`, `first_name`, `username`, `password_hash`, `email`, `career_level_id`, `group_id`) VALUES (4,'Public', 'Mary', 'public123', '$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6', 'mary@mail.com', 2, 1);
INSERT INTO `users` (`id`, `last_name`, `first_name`, `username`, `password_hash`, `email`, `career_level_id`, `group_id`) VALUES (5,'Queue', 'Susan', 'queue1111', '$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6', 'susan@mail.com', 3, 1);
INSERT INTO `users` (`id`, `last_name`, `first_name`, `username`, `password_hash`, `email`, `career_level_id`, `group_id`) VALUES (6,'Jackson', 'Michael', 'jackson1111', '$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6', 'michael@mail.com', 4, 1);
INSERT INTO `users` (`id`, `last_name`, `first_name`, `username`, `password_hash`, `email`, `career_level_id`, `group_id`) VALUES (7,'Smith', 'John', 'smith1111', '$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6', 'john@mail.com', 5, 1);
INSERT INTO `users` (`id`, `last_name`, `first_name`, `username`, `password_hash`, `email`, `career_level_id`, `group_id`) VALUES (8,'Smith', 'James','smith123', '$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6', 'james@mail.com', 1, 1);
INSERT INTO `users` (`id`, `last_name`, `first_name`, `username`, `password_hash`, `email`, `career_level_id`, `group_id`) VALUES (9,'Sweater', 'Peter', 'sweater123', '$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6', 'sweater@mail.com', 2, 1);
INSERT INTO `users` (`id`, `last_name`, `first_name`, `username`, `password_hash`, `email`, `career_level_id`, `group_id`) VALUES (10,'Black', 'Arnold', 'arnold1111', '$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6', 'black@mail.com', 1, 1);


drop table if exists `career_levels`;

CREATE TABLE `career_levels` (
  `id` int (20) not null AUTO_INCREMENT,
  `name` varchar(64) not null,
  PRIMARY KEY (`id`),
  UNIQUE (`name`)
);

INSERT INTO `career_levels` (`id`,`name`) VALUES (1,'Internship');
INSERT INTO `career_levels` (`id`,`name`) VALUES (2,'Baby on board');
INSERT INTO `career_levels` (`id`,`name`) VALUES (3,'First steps');
INSERT INTO `career_levels` (`id`,`name`) VALUES (4,'You are good!');
INSERT INTO `career_levels` (`id`,`name`) VALUES (5,'You rock!');


