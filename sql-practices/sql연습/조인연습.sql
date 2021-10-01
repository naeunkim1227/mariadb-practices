-- join

-- inner join

-- 예제: employees 테이블과 title 테이블을 join 하여 직원의 이름과 직책을 모두 출력
select *
from employees e, titles t
where e.emp_no = t.emp_no -- join 조건
and t.to_date = '9999-01-01'; -- row 선택조건


-- 예제2 : employees 테이블과 titles 테이블을 join하여 직원의 이름과 직책을 출력하되, 여성 엔지니어만 출력하세요.
select e.first_name, t.title, e.gender
from employees e, titles t
where e.emp_no = t.emp_no
and t.to_date = '9999-01-01'
and e.gender = 'f'
and t.title = 'engineer';

-- ANSI/ISO SQL1999 JOIN 표준 문법

-- 1) natural join 
-- 두 테이블에 공통 컬럼이 있으면 별다른 조인 조건 없이 암묵적으로 조인이 됨
-- 쓸일 없음
select *  from employees natural join titles;

select a.first_name, b.title
from employees a natural join titles b
-- on a.emp_no = b.emp_no 생략 가능
where b.to_date = '9999-01-01';


-- 2) join ~ using
select a.first_name, b.title
from employees a join titles b
using (emp_no)
where b.to_date = '9999-01-01';




-- 3) join ~ on(가장 많이 사용, outer join에서도 사용한다.)
select a.first_name, b.title
from employees a join titles b
on a.emp_no = b.emp_no
where b.to_date = '9999-01-01';



-- outer join
-- insert into dept values(null, '총무');
-- insert into dept values(null, '영업');
-- insert into dept values(null, '개발');
-- insert into dept values(null, '기획');

select * from emp;

-- insert into emp values (null,'둘리',1);
-- insert into emp values (null,'또치',2);
-- insert into emp values (null,'마이콜',3);
 -- insert into emp values (null,'길동', null);

select a.name as '이름' , b.name as '부서'
from emp a join dept b on a.dept_no = b.no;

select a.name as '이름' , ifnull(b.name, '없음') as '부서'
from emp a left join dept b on a.dept_no = b.no;

select a.name as '이름' , b.name  as '부서'
from emp a right join dept b on a.dept_no = b.no;

