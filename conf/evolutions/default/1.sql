# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table account (
  id                        integer primary key AUTOINCREMENT,
  username                  varchar(255),
  password                  varchar(255),
  groupid                   integer,
  name                      varchar(255),
  type                      varchar(255))
;

create table project (
  id                        integer primary key AUTOINCREMENT,
  name                      varchar(255),
  description               varchar(255),
  manager                   varchar(255))
;

create table vote (
  id                        integer primary key AUTOINCREMENT,
  sel1                      integer,
  sel2                      integer,
  sel3                      integer,
  project_id                integer,
  voter_id                  integer)
;




# --- !Downs

PRAGMA foreign_keys = OFF;

drop table account;

drop table project;

drop table vote;

PRAGMA foreign_keys = ON;

