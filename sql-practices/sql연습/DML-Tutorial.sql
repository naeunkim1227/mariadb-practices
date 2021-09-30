
-- 테이블 생성
create table pet(
	name varchar(20),
    owner varchar(20),
    species varchar(20),
    gender char(1),
    birth DATE,
    death DATE
);


-- 테이블 조회, scheme 확인
desc pet;


-- 테이블 삭제
-- drop table pet;

-- 조회
select name,owner from pet;
select * from pet;

-- 데이터 넣기
insert into pet
 value ('미키', '김나은' , 'cat' , 'm' , '2021-05-30' , null);


-- 데이터 삭제
 -- delete from pet where name = '미키';


-- load data (txt file) local infile
load data local infile "C:\\pet.txt" into table pet;


-- 조회 연습 1 : where 절 사용

-- 1990 년 이후에 태어난 아이들
select name, species , birth 
from pet 
where birth >= '1990-12-31';


-- Gwen 과 함께사는 아이들은>
select name, species, owner
from pet
where owner = 'Gwen';

-- null 다루기 1 : 살아있는 애들은

select * from pet 
where death is null;

-- update death
update pet set death=null where name != 'Bowser';

-- 2. 죽은 애들은?
select * from pet where death is not null; 


-- like 검색(패턴 매칭) : 이름이 b로 시작하는 아이들?

select name from pet where name like 'b%';

-- like 검색(패턴 매칭) : 이름이 b로 시작하는 아이들 중에 이름이 6자인 아이는?
select name from pet where name like 'b_____';

-- 집계(통계) 함수
select count(death) from pet;
select count(*) from pet where death is not null;

select count(*) from pet;











