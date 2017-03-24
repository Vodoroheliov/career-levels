create database if not exists internship;
#create database if not exists internship_test;

use internship;
#use internship_test;

drop table if exists `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(64) DEFAULT NULL,
  `first_name` varchar(64) DEFAULT NULL,
  `login` varchar(64) NOT NULL,
  `password` varchar(64) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  `career_level` varchar(64) NOT NULL,
   PRIMARY KEY (`id`),
   UNIQUE (`login`, `email`)
);

drop table if exists `career_levels`;

CREATE TABLE `career_levels` (
  `id` int (10) not null AUTO_INCREMENT,
  `level_name` varchar(64) not null,
  primary key (`id`),
  UNIQUE (`level_name`)
);

drop table if exists `users_benefits`;

CREATE TABLE `users_benefits` (
	`user_id` int (10) not null AUTO_INCREMENT,
	`benefit_id` int (10) not null,
	primary key (`user_id`, `benefit_id`)
);

drop table if exists `benefits`;

CREATE TABLE `benefits` (
  `id` int(10) not null AUTO_INCREMENT,
  `benefit_name` varchar(64) not null,
  primary key (`id`),
  UNIQUE (`benefit_name`)
);

drop table if exists `users_todos`;

CREATE TABLE `users_todos` (
  `user_id` int(10) not null AUTO_INCREMENT,
  `todo_id` int (10) not null,
  primary key (`user_id`,`todo_id`)
);

drop table if exists `todos`;

CREATE TABLE `todos` (
  `id` int(10) not null AUTO_INCREMENT,
  `task` varchar(64) not null,
  primary key (`id`),
  UNIQUE (`task`)
);

drop table if exists `users_groups`;

CREATE TABLE `users_groups` (
  `user_id`  int(10) not null AUTO_INCREMENT,
  `group_id` int(10) not null,
  PRIMARY KEY (`user_id`, `group_id`)
);

drop table if exists groups;

  create table `groups` (
  `id` int(10) not null AUTO_INCREMENT,
  `group_name` varchar(64) not null,
  primary key (`id`),
  UNIQUE (`group_name`)
  
);

