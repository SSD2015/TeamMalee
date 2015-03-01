# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table vote (
  id                        integer primary key AUTOINCREMENT,
  sel1                      integer,
  sel2                      integer,
  sel3                      integer)
;




# --- !Downs

PRAGMA foreign_keys = OFF;

drop table vote;

PRAGMA foreign_keys = ON;

