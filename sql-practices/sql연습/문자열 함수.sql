desc employees;

-- select 연습
select * from departments;
select dept_no, dept_name from departments;


-- alias (as 생략가능)
-- 예제 : employees 테이블에서 직원의 이름, 성별 , 입사일을 출력해라
desc employees;
select  first_name as '이름' , gender as '성별' ,  hire_date as  '입사일' from employees;


-- 예제2 :  employees 테이블에서 직원의 이름, 성별 , 입사일을 출력해라 + concat
select  concat(first_name, ' ' , last_name) as '이름' , gender as '성별' ,  hire_date as  '입사일' from employees;


-- distinct
-- 예제 : title 테이블에서 모든 직급을 출력하라 (중복 제거)
select distinct title from titles;


-- limit 0 행에서 3행까지 출력하게 함
select distinct title from titles limit 0,3; 


-- where 절 #1
desc employees;
select concat(first_name, ' ' , last_name) as '이름',
gender as '성별', hire_date as '입사일'
from employees
where hire_date < '1991-01-01'
order by hire_date desc;


-- where절 #2: 논리연산자
-- ㅇㅖ제 : 1989년 이전에 입사한 여직원의 이름, 입사일을 출력
select first_name, gender, hire_date
from employees
where hire_date < '1989-01-01' and gender = 'f';


-- where절 #3 : in연산자
-- 예제 : dept_emp 테이블에서 부서번호가 d005 나 d009에 속한 사원의 사번, 부서번호 출력
select * from dept_emp where dept_no = 'd005' or dept_no = 'd009';
select * from dept_emp where dept_no in( 'd005','d009');


-- where절 #4 like 검색
-- 예제: 1989년 이후에 입사한 직원의 이름, 입사일 출력
select first_name, hire_date from employees
where '1989-01-01' <= hire_date;

select first_name, hire_date from employees
where hire_date like '1989%'
order by hire_date asc;

select first_name, hire_date from employees
where hire_date between '1989-01-01' and '1989-12-31';

-- order by
-- 예제1 : 남자 직원의 전체 이름, 성별, 입사일을 입사일순(선임순) 으로 출력해라
select concat(first_name, '', last_name) as '이름',
gender, hire_date
from employees
where gender = 'm'
order by hire_date asc;

-- 예제2 : 직원들의 사번, 월급을 사번, 월급순으로 출력
select emp_no, salary
from salaries 
order by emp_no asc, salary desc;


-- upper
select upper('buSan'), upper('busan') ,upper('Douzone');
select upper(first_name) from employees;

-- lower
select lower('buSan'),lower('busan'), lower('Douzone');

-- substring(문자열,index,length)
select substring('Hello World',3,2);

-- 예제: 1989년에 입사한 사원들의 이름, 입사일 출력
select first_name , hire_date from employees
where substring(hire_date, 1,4) = '1989';

-- lpad(오른쪽 정렬), rpad
select lpad('1234', 10 , '-');
select rpad('1234', 10 , '-');

-- 예제) 직원들의 월급을 오른쪽으로 정렬(빈공간은 *)
select lpad(salary, 10, '*') from salaries;

-- trim, ltrim, rtrim
select concat('---', ltrim('   hello    '),'---'),
concat('---', rtrim('   hello    '),'---'),
concat('---', trim('   hello    '),'---');

select concat('---', ltrim('   hello    '),'---'),
concat('---', rtrim('   hello    '),'---'),
concat('---', trim(both 'x' from 'xxxhelloxxx'), '---');

