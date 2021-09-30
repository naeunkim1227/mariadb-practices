
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
 value ('미키', '김땡땡' , 'cat' , 'm' , '2021-05-30' , null);


-- 데이터 삭제
 -- delete from pet where name = '미키';


-- load data (txt file) local infile
load data local infile "C:\\pet.txt" into table pet;


-- 조회 연습 1 : where 절 사용

-- 1990 년 이후에 태어난 아이들
select name, species , birth 
from pet 
where birth >= '1990-12-31';









