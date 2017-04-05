create database if not exists internship;

use internship


drop table if exists `users_benefit_types`;

CREATE TABLE `users_benefit_types` (
	`user_id` int (20) not null AUTO_INCREMENT,
	`benefit_type_id` int (20) not null,
	`quantity` integer not null default 1,
	`date_of_completion` datetime,
	`description` varchar(256),
	PRIMARY KEY (`user_id`, `benefit_type_id`)
);

# Benefits for Internship level
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (1, 1);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (1, 2);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (1, 3);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (1, 4);

# Benefits for Baby on Board level
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (2, 5);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (2, 6);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (2, 2);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (2, 7);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (2, 8);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (2, 3);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (2, 9);

# Benefits for First Steps level
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (3, 5);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (3, 6);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (3, 10);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (3, 7);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (3, 8);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (3, 3);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (3, 9);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (3, 11);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (3, 12);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (3, 13);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (3, 14);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (3, 15);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (3, 16);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (3, 17);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (3, 18);

# Benefits for You are Good! level
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (4, 5);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (4, 6);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (4, 19);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (4, 7);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (4, 8);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (4, 3);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (4, 9);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (4, 20);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (4, 21);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (4, 22);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (4, 14);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (4, 15);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (4, 23);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (4, 24);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (4, 25);

# Benefits for You Rock! level
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (5, 5);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (5, 6);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (5, 26);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (5, 7);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (5, 8);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (5, 3);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (5, 9);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (5, 27);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (5, 28);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (5, 29);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (5, 14);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (5, 15);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (5, 30);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (5, 31);
INSERT INTO `users_benefit_types` (`user_id`, `benefit_type_id`) VALUES (5, 25);


drop table if exists `career_levels_benefit_types`;

CREATE TABLE `career_levels_benefit_types` (
	`career_level_id` int (20) not null AUTO_INCREMENT,
	`benefit_type_id` int (20) not null,
	PRIMARY KEY (`career_level_id`, `benefit_type_id`)
);

# Benefits for Internship level
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (1, 1);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (1, 2);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (1, 3);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (1, 4);

# Benefits for Baby on Board level
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (2, 5);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (2, 6);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (2, 2);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (2, 7);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (2, 8);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (2, 3);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (2, 9);

# Benefits for First Steps level
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (3, 5);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (3, 6);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (3, 10);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (3, 7);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (3, 8);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (3, 3);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (3, 9);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (3, 11);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (3, 12);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (3, 13);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (3, 14);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (3, 15);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (3, 16);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (3, 17);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (3, 18);

# Benefits for You are Good! level
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (4, 5);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (4, 6);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (4, 19);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (4, 7);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (4, 8);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (4, 3);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (4, 9);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (4, 20);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (4, 21);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (4, 22);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (4, 14);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (4, 15);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (4, 23);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (4, 24);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (4, 25);

# Benefits for You Rock! level
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (5, 5);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (5, 6);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (5, 26);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (5, 7);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (5, 8);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (5, 3);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (5, 9);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (5, 27);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (5, 28);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (5, 29);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (5, 14);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (5, 15);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (5, 30);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (5, 31);
INSERT INTO `career_levels_benefit_types` (`career_level_id`, `benefit_type_id`) VALUES (5, 25);


drop table if exists `benefit_types`;

CREATE TABLE `benefit_types` (
  `id` int(20) not null AUTO_INCREMENT,
  `name` varchar(64) not null,
  `quantity` integer not null default 1,
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
INSERT INTO `benefit_types` (`id`,`name`) VALUES (12,'150EURO personal budget');
INSERT INTO `benefit_types` (`id`,`name`) VALUES (13,'200MDL monthly for sports');
INSERT INTO `benefit_types` (`id`,`name`) VALUES (14,'Private health insurance');
INSERT INTO `benefit_types` (`id`,`name`) VALUES (15,'Self-development club (1.25h per week)');
INSERT INTO `benefit_types` (`id`,`name`) VALUES (16,'Suggest 1 book per year');
INSERT INTO `benefit_types` (`id`,`name`) VALUES (17,'OCA Java');
INSERT INTO `benefit_types` (`id`,`name`) VALUES (18,'Visit to NL');
INSERT INTO `benefit_types` (`id`,`name`) VALUES (19,'Flexible schedule2 (9:00-18:00)+/-1h');
INSERT INTO `benefit_types` (`id`,`name`) VALUES (20,'New equipment priority 2');
INSERT INTO `benefit_types` (`id`,`name`) VALUES (21,'300EURO personal budget');
INSERT INTO `benefit_types` (`id`,`name`) VALUES (22,'300MDL monthly for sports');
INSERT INTO `benefit_types` (`id`,`name`) VALUES (23,'Suggest 3 books per year');
INSERT INTO `benefit_types` (`id`,`name`) VALUES (24,'1 day per month work from home');
INSERT INTO `benefit_types` (`id`,`name`) VALUES (25,'8000EURO credit');
INSERT INTO `benefit_types` (`id`,`name`) VALUES (26,'Flexible schedule3 (40h per week)');
INSERT INTO `benefit_types` (`id`,`name`) VALUES (27,'New equipment priority 1');
INSERT INTO `benefit_types` (`id`,`name`) VALUES (28,'500EURO personal budget');
INSERT INTO `benefit_types` (`id`,`name`) VALUES (29,'500MDL monthly for sports');
INSERT INTO `benefit_types` (`id`,`name`) VALUES (30,'Suggest 5 books per year');
INSERT INTO `benefit_types` (`id`,`name`) VALUES (31,'3 days per month work from home');


drop table if exists `users_todo_types`;

CREATE TABLE `users_todo_types` (
  `user_id` int(20) not null AUTO_INCREMENT,
  `todo_type_id` int (20) not null,
  `done` boolean not null DEFAULT false,
  `quantity` integer not null default 1,
  `date_of_completion` datetime,
  `description` varchar(256),
  PRIMARY KEY (`user_id`, `todo_type_id`)
);

# Todos for Internship level
INSERT INTO `users_todo_types` (`user_id`,`todo_type_id`) VALUES (1, 1);

# Todos for Baby on Board level
INSERT INTO `users_todo_types` (`user_id`,`todo_type_id`) VALUES (2, 2);
INSERT INTO `users_todo_types` (`user_id`,`todo_type_id`) VALUES (2, 3);
INSERT INTO `users_todo_types` (`user_id`,`todo_type_id`) VALUES (2, 4);
INSERT INTO `users_todo_types` (`user_id`,`todo_type_id`) VALUES (2, 5);
INSERT INTO `users_todo_types` (`user_id`,`todo_type_id`) VALUES (2, 6);
INSERT INTO `users_todo_types` (`user_id`,`todo_type_id`) VALUES (2, 7);
INSERT INTO `users_todo_types` (`user_id`,`todo_type_id`) VALUES (2, 8);

# Todos for First Steps level
INSERT INTO `users_todo_types` (`user_id`,`todo_type_id`) VALUES (3, 9);
INSERT INTO `users_todo_types` (`user_id`,`todo_type_id`) VALUES (3, 4);
INSERT INTO `users_todo_types` (`user_id`,`todo_type_id`) VALUES (3, 10);
INSERT INTO `users_todo_types` (`user_id`,`todo_type_id`) VALUES (3, 11);
INSERT INTO `users_todo_types` (`user_id`,`todo_type_id`) VALUES (3, 12);
INSERT INTO `users_todo_types` (`user_id`,`todo_type_id`) VALUES (3, 13);
INSERT INTO `users_todo_types` (`user_id`,`todo_type_id`) VALUES (3, 14);
INSERT INTO `users_todo_types` (`user_id`,`todo_type_id`) VALUES (3, 15);

# Todos for You are good! level
INSERT INTO `users_todo_types` (`user_id`,`todo_type_id`) VALUES (4, 16);
INSERT INTO `users_todo_types` (`user_id`,`todo_type_id`) VALUES (4, 4);
INSERT INTO `users_todo_types` (`user_id`,`todo_type_id`) VALUES (4, 17);
INSERT INTO `users_todo_types` (`user_id`,`todo_type_id`) VALUES (4, 18);
INSERT INTO `users_todo_types` (`user_id`,`todo_type_id`) VALUES (4, 19);
INSERT INTO `users_todo_types` (`user_id`,`todo_type_id`) VALUES (4, 20);
INSERT INTO `users_todo_types` (`user_id`,`todo_type_id`) VALUES (4, 21);
INSERT INTO `users_todo_types` (`user_id`,`todo_type_id`) VALUES (4, 22);
INSERT INTO `users_todo_types` (`user_id`,`todo_type_id`) VALUES (4, 23);
INSERT INTO `users_todo_types` (`user_id`,`todo_type_id`) VALUES (4, 24);

# Todos for You rock! level
INSERT INTO `users_todo_types` (`user_id`,`todo_type_id`) VALUES (5, 25);
INSERT INTO `users_todo_types` (`user_id`,`todo_type_id`) VALUES (5, 4);
INSERT INTO `users_todo_types` (`user_id`,`todo_type_id`) VALUES (5, 26);
INSERT INTO `users_todo_types` (`user_id`,`todo_type_id`) VALUES (5, 27);
INSERT INTO `users_todo_types` (`user_id`,`todo_type_id`) VALUES (5, 28);
INSERT INTO `users_todo_types` (`user_id`,`todo_type_id`) VALUES (5, 20);
INSERT INTO `users_todo_types` (`user_id`,`todo_type_id`) VALUES (5, 21);
INSERT INTO `users_todo_types` (`user_id`,`todo_type_id`) VALUES (5, 22);
INSERT INTO `users_todo_types` (`user_id`,`todo_type_id`) VALUES (5, 23);
INSERT INTO `users_todo_types` (`user_id`,`todo_type_id`) VALUES (5, 24);


drop table if exists `career_levels_todo_types`;

CREATE TABLE `career_levels_todo_types` (
  `career_level_id` int(20) not null AUTO_INCREMENT,
  `todo_type_id` int (20) not null,
  PRIMARY KEY (`career_level_id`, `todo_type_id`)
);

# Todos for Internship level
INSERT INTO `career_levels_todo_types` (`career_level_id`,`todo_type_id`) VALUES (1, 1);

# Todos for Baby on Board level
INSERT INTO `career_levels_todo_types` (`career_level_id`,`todo_type_id`) VALUES (2, 2);
INSERT INTO `career_levels_todo_types` (`career_level_id`,`todo_type_id`) VALUES (2, 3);
INSERT INTO `career_levels_todo_types` (`career_level_id`,`todo_type_id`) VALUES (2, 4);
INSERT INTO `career_levels_todo_types` (`career_level_id`,`todo_type_id`) VALUES (2, 5);
INSERT INTO `career_levels_todo_types` (`career_level_id`,`todo_type_id`) VALUES (2, 6);
INSERT INTO `career_levels_todo_types` (`career_level_id`,`todo_type_id`) VALUES (2, 7);
INSERT INTO `career_levels_todo_types` (`career_level_id`,`todo_type_id`) VALUES (2, 8);

# Todos for First Steps level
INSERT INTO `career_levels_todo_types` (`career_level_id`,`todo_type_id`) VALUES (3, 9);
INSERT INTO `career_levels_todo_types` (`career_level_id`,`todo_type_id`) VALUES (3, 4);
INSERT INTO `career_levels_todo_types` (`career_level_id`,`todo_type_id`) VALUES (3, 10);
INSERT INTO `career_levels_todo_types` (`career_level_id`,`todo_type_id`) VALUES (3, 11);
INSERT INTO `career_levels_todo_types` (`career_level_id`,`todo_type_id`) VALUES (3, 12);
INSERT INTO `career_levels_todo_types` (`career_level_id`,`todo_type_id`) VALUES (3, 13);
INSERT INTO `career_levels_todo_types` (`career_level_id`,`todo_type_id`) VALUES (3, 14);
INSERT INTO `career_levels_todo_types` (`career_level_id`,`todo_type_id`) VALUES (3, 15);

# Todos for You are good! level
INSERT INTO `career_levels_todo_types` (`career_level_id`,`todo_type_id`) VALUES (4, 16);
INSERT INTO `career_levels_todo_types` (`career_level_id`,`todo_type_id`) VALUES (4, 4);
INSERT INTO `career_levels_todo_types` (`career_level_id`,`todo_type_id`) VALUES (4, 17);
INSERT INTO `career_levels_todo_types` (`career_level_id`,`todo_type_id`) VALUES (4, 18);
INSERT INTO `career_levels_todo_types` (`career_level_id`,`todo_type_id`) VALUES (4, 19);
INSERT INTO `career_levels_todo_types` (`career_level_id`,`todo_type_id`) VALUES (4, 20);
INSERT INTO `career_levels_todo_types` (`career_level_id`,`todo_type_id`) VALUES (4, 21);
INSERT INTO `career_levels_todo_types` (`career_level_id`,`todo_type_id`) VALUES (4, 22);
INSERT INTO `career_levels_todo_types` (`career_level_id`,`todo_type_id`) VALUES (4, 23);
INSERT INTO `career_levels_todo_types` (`career_level_id`,`todo_type_id`) VALUES (4, 24);

# Todos for You rock! level
INSERT INTO `career_levels_todo_types` (`career_level_id`,`todo_type_id`) VALUES (5, 25);
INSERT INTO `career_levels_todo_types` (`career_level_id`,`todo_type_id`) VALUES (5, 4);
INSERT INTO `career_levels_todo_types` (`career_level_id`,`todo_type_id`) VALUES (5, 26);
INSERT INTO `career_levels_todo_types` (`career_level_id`,`todo_type_id`) VALUES (5, 27);
INSERT INTO `career_levels_todo_types` (`career_level_id`,`todo_type_id`) VALUES (5, 28);
INSERT INTO `career_levels_todo_types` (`career_level_id`,`todo_type_id`) VALUES (5, 20);
INSERT INTO `career_levels_todo_types` (`career_level_id`,`todo_type_id`) VALUES (5, 21);
INSERT INTO `career_levels_todo_types` (`career_level_id`,`todo_type_id`) VALUES (5, 22);
INSERT INTO `career_levels_todo_types` (`career_level_id`,`todo_type_id`) VALUES (5, 23);
INSERT INTO `career_levels_todo_types` (`career_level_id`,`todo_type_id`) VALUES (5, 24);


drop table if exists `todo_types`;

CREATE TABLE `todo_types` (
  `id` int(20) not null AUTO_INCREMENT,
  `name` varchar(64) not null,
  `quantity` integer not null default 1,
  PRIMARY KEY (`id`),
  UNIQUE (`name`)
);

INSERT INTO `todo_types` (`id`,`name`) VALUES (1,'Prove you are proactive');
INSERT INTO `todo_types` (`id`,`name`) VALUES (2,'Finish trial period');
INSERT INTO `todo_types` (`id`,`name`) VALUES (3,'Read '' Warehouse & Distribution Science''');
INSERT INTO `todo_types` (`id`,`name`) VALUES (4,'Daily time tracking report');
INSERT INTO `todo_types` (`id`,`name`) VALUES (5,'3 ideas for the company');
INSERT INTO `todo_types` (`id`,`name`) VALUES (6,'3 months in the company');
INSERT INTO `todo_types` (`id`,`name`) VALUES (7,'1 article');
INSERT INTO `todo_types` (`id`,`name`) VALUES (8,'1 presentation');
INSERT INTO `todo_types` (`id`,`name`) VALUES (9,'4 books per year');
INSERT INTO `todo_types` (`id`,`name`) VALUES (10,'5 ideas for the company');
INSERT INTO `todo_types` (`id`,`name`) VALUES (11,'3 articles');
INSERT INTO `todo_types` (`id`,`name`) VALUES (12,'3 presentations');
INSERT INTO `todo_types` (`id`,`name`) VALUES (13,'English upper-intermediate');
INSERT INTO `todo_types` (`id`,`name`) VALUES (14,'1 Responsibility');
INSERT INTO `todo_types` (`id`,`name`) VALUES (15,'Be independent');
INSERT INTO `todo_types` (`id`,`name`) VALUES (16,'7 books per year');
INSERT INTO `todo_types` (`id`,`name`) VALUES (17,'10 ideas for the company');
INSERT INTO `todo_types` (`id`,`name`) VALUES (18,'5 articles');
INSERT INTO `todo_types` (`id`,`name`) VALUES (19,'5 presentations');
INSERT INTO `todo_types` (`id`,`name`) VALUES (20,'English advanced');
INSERT INTO `todo_types` (`id`,`name`) VALUES (21,'3 Responsibilities');
INSERT INTO `todo_types` (`id`,`name`) VALUES (22,'PM for 3 projects (incl. 5PM club)');
INSERT INTO `todo_types` (`id`,`name`) VALUES (23,'Manage 3 pers.');
INSERT INTO `todo_types` (`id`,`name`) VALUES (24,'Buddy 5 pers.');
INSERT INTO `todo_types` (`id`,`name`) VALUES (25,'10 books per year');
INSERT INTO `todo_types` (`id`,`name`) VALUES (26,'15 ideas for the company');
INSERT INTO `todo_types` (`id`,`name`) VALUES (27,'10 articles');
INSERT INTO `todo_types` (`id`,`name`) VALUES (28,'10 presentations');


drop table if exists `users_groups`;

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


drop table if exists groups;

  create table `groups` (
  `id` int(20) not null AUTO_INCREMENT,
  `name` varchar(64) not null,
  PRIMARY KEY (`id`),
  UNIQUE (`name`)
  
);

INSERT INTO `groups` (`id`, `name`) VALUES (1,'user');
INSERT INTO `groups` (`id`, `name`) VALUES (2,'admin');


drop table if exists `users`;

CREATE TABLE `users` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(64) DEFAULT NULL,
  `first_name` varchar(64) DEFAULT NULL,
  `username` varchar(64) NOT NULL,
  `password` varchar(64) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  `career_level_id` int(20) NOT NULL,
   PRIMARY KEY (`id`),
   UNIQUE (`login`, `email`)
);

INSERT INTO `users` (`id`, `last_name`, `first_name`, `username`, `password`, `email`, `career_level_id`) VALUES (1,'Doe', 'John','john123', 'doe1111', 'john@mail.com', 1);
INSERT INTO `users` (`id`, `last_name`, `first_name`, `username`, `password`, `email`, `career_level_id`) VALUES (2,'Public', 'Mary', 'public123', 'mary111', 'mary@mail.com', 2);
INSERT INTO `users` (`id`, `last_name`, `first_name`, `username`, `password`, `email`, `career_level_id`) VALUES (3,'Queue', 'Susan', 'queue1111', 'susan123', 'susan@mail.com', 3);
INSERT INTO `users` (`id`, `last_name`, `first_name`, `username`, `password`, `email`, `career_level_id`) VALUES (4,'Jackson', 'Michael', 'jackson1111', 'michael123', 'michael@mail.com', 4);
INSERT INTO `users` (`id`, `last_name`, `first_name`, `username`, `password`, `email`, `career_level_id`) VALUES (5,'Smith', 'John', 'smith1111', 'john123', 'john@mail.com', 5);


drop table if exists `career_levels`;

CREATE TABLE `career_levels` (
  `id` int (20) not null AUTO_INCREMENT,
  `level_name` varchar(64) not null,
  PRIMARY KEY (`id`),
  UNIQUE (`level_name`)
);

INSERT INTO `career_levels` (`id`,`level_name`) VALUES (1,'Internship');
INSERT INTO `career_levels` (`id`,`level_name`) VALUES (2,'Baby on board');
INSERT INTO `career_levels` (`id`,`level_name`) VALUES (3,'First steps');
INSERT INTO `career_levels` (`id`,`level_name`) VALUES (4,'You are good!');
INSERT INTO `career_levels` (`id`,`level_name`) VALUES (5,'You rock!');


