-- 서브쿼리

-- 1) from 절의 서브쿼리
select now() as n, sysdate() as b, 3+1 as c;

select * 
from (select now() as n, sysdate() as b, 3+1 as c) s;



-- 예제 : 현재 Fai Bale이 근무하는 부서에서 근무하는 직원의 사번, 전체 이름을 출력해보세요
select b.dept_no
from employees a , dept_emp b
where a.emp_no = b.emp_no 
and b.to_date = '9999-01-01'
and concat(a.first_name , ' ' , a.last_name) ='Fai Bale';


select a.emp_no ,a.first_name
from employees a , dept_emp b
where a.emp_no = b.emp_no 
and b.to_date = '9999-01-01'
and b.dept_no = 'd004';

select a.emp_no ,a.first_name
from employees a , dept_emp b
where a.emp_no = b.emp_no 
and b.to_date = '9999-01-01'
and b.dept_no = (select b.dept_no
				from employees a , dept_emp b
				where a.emp_no = b.emp_no 
				and b.to_date = '9999-01-01'
				and concat(a.first_name , ' ' , a.last_name) ='Fai Bale');


-- 2-1) 단일행 연산자 : = , >,<, >=, <= , <>, !=
-- 실습문제 1: 현재 전체 사원의 평균 연봉보다 적은 급여를 받는 사원의 이름, 급여를 출력하세요.
select avg(salary) from salaries where to_date = '9999-01-01';

select a.first_name, b.salary
from employees a , salaries b
where a.emp_no = b.emp_no
and b.to_date = '9999-01-01'
and b.salary < (select avg(salary) from salaries where to_date = '9999-01-01')
order by b.salary desc;

-- 실습문제2 :  현재 가장 적은 평균 급여의 직책과 평균급여를 출력하세요.
-- Engineer 2000
-- min_avg_salary


-- 1) 직책별 평균 급여
select a.title ,avg(b.salary) as avg_salary
from titles a, salaries b
where a.emp_no = b.emp_no
and a.to_date = '9999-01-01'
and b.to_date = '9999-01-01'
group by a.title
order by avg_salary asc;

-- 2) 가장 적은 평균급여
select min(avg_salary)
from (select a.title ,avg(b.salary) as avg_salary
		from titles a, salaries b
		where a.emp_no = b.emp_no
		and a.to_date = '9999-01-01'
		and b.to_date = '9999-01-01'
		group by a.title) a;
        
        
        
        
select a.title ,avg(b.salary)
	from titles a, salaries b
	where a.emp_no = b.emp_no
	and a.to_date = '9999-01-01'
	and b.to_date = '9999-01-01'
	group by a.title
    having avg(b.salary) = (select min(avg_salary)
							from (select a.title ,avg(b.salary) as avg_salary
								from titles a, salaries b
								where a.emp_no = b.emp_no
								and a.to_date = '9999-01-01'
								and b.to_date = '9999-01-01'
								group by a.title) a);
            
            
-- 2번째 방법
select a.title ,avg(b.salary)
	from titles a, salaries b
	where a.emp_no = b.emp_no
	and a.to_date = '9999-01-01'
	and b.to_date = '9999-01-01'
	group by a.title
    order by avg(b.salary) asc limit 0,1;
    
    
-- 2-2) 복수행 연산자 : in, not in, any, all
-- 1. =any: in
-- 2. >any, >=any 최소값
-- 3. <any, <=any 최대값
-- 4. <>any : not in 동일 alter

-- all 사용법
-- 1. =all (x)
-- 2. >all , >=all 최대값
-- 3. <all, <=all 최소값

-- 실습문제3 : 현재 급여가 50000 이상인 직원의 이름을 출력하세요.

-- 1 ) sol1 : 조인사용
select a.first_name, b.salary
from employees a, salaries b
where a.emp_no = b.emp_no 
and b.to_date = '9999-01-01'
and b.salary > 50000
order by b.salary;

 -- 2) sol2 : 서브쿼리 사용
 -- 서브쿼리 작성
 select emp_no, salary
 from salaries where to_date = '9999-01-01' and salary > 50000; 
 
 select a.first_name, b.salary
 from employees a, salaries b
 where a.emp_no = b.emp_no
 and b.to_date= '9999-01-01' 
 and (a.emp_no, b.salary) in (select emp_no, salary
								from salaries where to_date = '9999-01-01' 
								and salary > 50000);
 
 
-- 실습문제4 : 각 부서별로 최고 월급을 받는 직원의 이름과 월급을 출력하시오.

-- 서브 쿼리 작성
select a.dept_no,max(b.salary)
from dept_emp a,salaries b
where a.emp_no = b.emp_no
and a.to_date = '9999-01-01'
and b.to_date = '9999-01-01'
group by a.dept_no;


-- 내 풀이...
select a.first_name, b.salary
from employees a, salaries b, dept_emp c
where a.emp_no = b.emp_no 
and a.emp_no = c.emp_no
and  c.to_date = '9999-01-01'
and  b.to_date = '9999-01-01'
and (c.dept_no,b.salary ) in (select c.dept_no,max(b.salary)
									from dept_emp c,salaries b
									where c.emp_no = b.emp_no
									and c.to_date = '9999-01-01'
									and b.to_date = '9999-01-01'
									group by c.dept_no);

-- 풀이
select c.first_name, b.salary
from dept_emp a, salaries b, employees c,departments d
where a.emp_no = b.emp_no
and b.emp_no = c.emp_no
and a.dept_no = d.dept_no
and a.to_date = '9999-01-01'
and b.to_date = '9999-01-01'
and (a.dept_no , b.salary) in (select a.dept_no,max(b.salary)
									from dept_emp a,salaries b
									where a.emp_no = b.emp_no
									and a.to_date = '9999-01-01'
									and b.to_date = '9999-01-01'
									group by a.dept_no);
								
						


    

            
        