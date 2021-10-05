drop table member;

create table member(
no int(11) not null auto_increment,
email varchar(200) not null,
password varchar(64) not null,
name varchar(100) not null,
department varchar(100),
primary key(no)
);

alter table member add juminbunho char(13) not null after email;
desc member;
alter table member drop juminbunho; 
alter table member add join_date datetime not null;
drop table member;
alter table member add self_info text;



-- transaction
select @@autocommit;
set autocommit = 0;

-- insert
insert into member 
values (null, 'qwerty@qert.com', password('1234'), '마자용' , '개발팀' , now() , null);

insert into member(no,email, password, name, department, join_date) 
values (null, 'qwerty@qert.com', password('1234'), '마자용2' , '개발팀' , now());

-- update
update member
set email = 'kicks@gamil.com' , password = password('5678')
where no = 3;

select * from member;

-- delete
delete from member where no = 3;

commit;
select * from member;

set autocommit=1;