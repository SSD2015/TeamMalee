# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table account (
  id                        bigint auto_increment not null,
  username                  varchar(255),
  password                  varchar(255),
  groupid                   bigint,
  name                      varchar(255),
  type                      varchar(255),
  constraint pk_account primary key (id))
;

create table criteria (
  id                        bigint auto_increment not null,
  projectid                 varchar(255),
  acc_id                    integer,
  constraint pk_criteria primary key (id))
;

create table image (
  id                        bigint auto_increment not null,
  project_id                bigint,
  data                      longblob,
  constraint pk_image primary key (id))
;

create table project (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  description               varchar(255),
  manager                   varchar(255),
  constraint pk_project primary key (id))
;

create table vote (
  id                        bigint auto_increment not null,
  sel1                      integer,
  sel2                      integer,
  sel3                      integer,
  sel4                      integer,
  sel5                      integer,
  project_id                integer,
  voter_id                  integer,
  constraint pk_vote primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table account;

drop table criteria;

drop table image;

drop table project;

drop table vote;

SET FOREIGN_KEY_CHECKS=1;

