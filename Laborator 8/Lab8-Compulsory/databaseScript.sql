drop table countries
drop table continents
--  id, name, code, continent
create table countries (
    id int,
    name varchar2(255) not null,
    code int,
    continent varchar2(255) 
);

-- id, name 
create table continents (
    id int,
    name varchar2(255) not null
);
select * from continents;
select * from countries;