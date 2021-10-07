-- 서브쿼리(SUBQUERY) SQL 문제입니다.

-- 문제1.현재 평균 연봉보다 많은 월급을 받는 직원은 몇 명이나 있습니까?
 -- 1) 평균연봉
select count(*)
from employees a, salaries b
where a.emp_no = b.emp_no 
and b.to_date = '9999-01-01'
and b.salary >= (select avg(salary) from salaries);

-- 문제2. 현재, 각 부서별로 최고의 급여를 받는 사원의 사번, 이름, 부서 연봉을 조회하세요. 단 조회결과는 연봉의 내림차순으로 정렬되어 나타나야 합니다. 
select c.emp_no as '사번' , concat(c.first_name, ' ' ,c.last_name) as '이름' , b.salary
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
 

-- 문제3.현재, 자신의 부서 평균 급여보다 연봉(salary)이 많은 사원의 사번, 이름과 연봉을 조회하세요 
select a.emp_no, concat(a.first_name, ' ' , a.last_name), b.salary
from employees a 
join salaries b on a.emp_no = b.emp_no
join dept_emp c on c.emp_no = a.emp_no 
join (select b.dept_no,avg(a.salary) as 'avgsal'
		from salaries a, dept_emp b
		where a.emp_no = b.emp_no
		and b.to_date = '9999-01-01'
		and a.to_date = '9999-01-01'
		group by b.dept_no) d on d.dept_no = c.dept_no
where b.salary > d.avgsal
and b.to_date = '9999-01-01'
and c.to_date = '9999-01-01';


-- 정답 풀이
SELECT 
    a.emp_no, CONCAT(a.first_name, ' ', a.last_name), b.salary
FROM
    employees a,
    salaries b,
    dept_emp c,
    (SELECT 
        c.dept_no, AVG(b.salary) AS avg_salary
    FROM
        employees a, salaries b, dept_emp c
    WHERE
        a.emp_no = b.emp_no
            AND a.emp_no = c.emp_no
            AND b.to_date = '9999-01-01'
            AND c.to_date = '9999-01-01'
    GROUP BY c.dept_no) d
WHERE
    a.emp_no = b.emp_no
        AND a.emp_no = c.emp_no
        AND c.dept_no = d.dept_no
        AND b.salary > d.avg_salary
        AND b.to_date = '9999-01-01'
        AND c.to_date = '9999-01-01';                                   
                                    
                                    

-- 문제4.현재, 사원들의 사번, 이름, 매니저 이름, 부서 이름으로 출력해 보세요.
select a.emp_no, concat(a.first_name,' ' ,a.last_name) as '이름', e.mng_name as '매니저 이름', d.dept_name as '부서 이름'
from employees a, dept_manager b , dept_emp c, departments d,
		(select b.dept_no,concat(a.first_name,' ' ,a.last_name) as 'mng_name'
			from employees a 
			join dept_manager b on b.emp_no = a.emp_no) e
where a.emp_no = b.emp_no
and c.emp_no = a.emp_no
and d.dept_no = c.dept_no
and e.dept_no = c.dept_no
and c.to_date = '9999-01-01'
and b.to_date = '9999-01-01';

-- 매니저 이름...
select b.dept_no,concat(a.first_name,' ' ,a.last_name) as '매니저 이름'
	from employees a 
		join dept_manager b on b.emp_no = a.emp_no;
        
SELECT 
    a.emp_no,
    CONCAT(a.first_name, ' ', a.last_name) as name,
    CONCAT(d.first_name, ' ', d.last_name) as manage_name,
    e.dept_name
FROM
    employees a,
    dept_emp b,
    dept_manager c,
    employees d,
    departments e
WHERE
    a.emp_no = b.emp_no
        AND b.dept_no = c.dept_no
        AND d.emp_no = d.emp_no
        AND c.dept_no = e.dept_no
        AND b.to_date = '9999-01-01'
        AND c.to_date = '9999-01-01';


-- 문제5.현재, 평균연봉이 가장 높은 부서의 사원들의 사번, 이름, 직책, 연봉을 조회하고 연봉 순으로 출력하세요.
	-- 1) 평균연봉이 가장 높은 부서
    select dept_no
    from (select b.dept_no, avg(a.salary)
    from salaries a join dept_emp b  on a.emp_no = b.emp_no
    where a.to_date = '9999-01-01' 
    and b.to_date = '9999-01-01'
    group by b.dept_no order by avg(a.salary) desc limit 0,1) a;
    
    -- 2)
    select a.emp_no as '사번',  concat(a.first_name, ' ', a.last_name) as '이름'
    , b.title as '직책', c.salary as '연봉'
    from employees a join titles b on a.emp_no = b.emp_no 
    join salaries c on a.emp_no = c.emp_no
    join dept_emp d on d.emp_no = a.emp_no
    where b.to_date = '9999-01-01'
    and c.to_date = '9999-01-01'
    and d.dept_no = ( select dept_no
    from (select b.dept_no, avg(a.salary)
			from salaries a join dept_emp b  on a.emp_no = b.emp_no
			where a.to_date = '9999-01-01' 
			and b.to_date = '9999-01-01'
			group by b.dept_no order by avg(a.salary) desc limit 0,1) a)
    order by c.salary desc;        
	
								
 -- 정답
 SELECT 
    a.emp_no,
    CONCAT(a.first_name, ' ', a.last_name) AS name,
    b.title,
    c.salary
FROM
    employees a,
    titles b,
    salaries c,
    dept_emp d
WHERE
    a.emp_no = b.emp_no
        AND a.emp_no = c.emp_no
        AND a.emp_no = d.emp_no
        AND b.to_date = '9999-01-01'
        AND c.to_date = '9999-01-01'
        AND d.to_date = '9999-01-01'
        AND d.dept_no = (SELECT dept_no
FROM (SELECT dept_no, AVG(salary) AS avg_salary
            FROM
                salaries a, dept_emp b
            WHERE
                a.emp_no = b.emp_no
                    AND a.to_date = '9999-01-01'
                    AND b.to_date = '9999-01-01'
            GROUP BY dept_no
            ORDER BY avg_salary DESC
            LIMIT 0 , 1) a)
ORDER BY c.salary DESC;
 
-- 문제6.평균 연봉이 가장 높은 부서는? 
-- 1)평균연봉 내림차순 쿼리
SELECT  MAX(avg_salary) FROM (SELECT 
								ROUND(AVG(b.salary)) AS avg_salary
							FROM
								employees a, salaries b, dept_emp c
							WHERE
								a.emp_no = b.emp_no
									AND a.emp_no = c.emp_no
									AND b.to_date = '9999-01-01'
									AND c.to_date = '9999-01-01'
							GROUP BY c.dept_no) a;



select a.dept_name, avg(c.salary)
from departments a join dept_emp b on a.dept_no = b.dept_no
join salaries c on c.emp_no = b.emp_no 
join employees d on d.emp_no = c.emp_no
where b.to_date = '9999-01-01' and c.to_date = '9999-01-01'
group by b.dept_no
having avg(c.salary) = (SELECT  MAX(avg_salary) 
						FROM 
							(SELECT 
								AVG(b.salary) AS avg_salary
								FROM
									employees a, salaries b, dept_emp c
								WHERE
									a.emp_no = b.emp_no
										AND a.emp_no = c.emp_no
										AND b.to_date = '9999-01-01'
										AND c.to_date = '9999-01-01'
								GROUP BY c.dept_no) a);


-- 답
SELECT 
    d.dept_name, ROUND(AVG(b.salary)) AS avg_salary
FROM
    employees a,
    salaries b,
    dept_emp c,
    departments d
WHERE
    a.emp_no = b.emp_no
        AND a.emp_no = c.emp_no
        AND c.dept_no = d.dept_no
        AND b.to_date = '9999-01-01'
        AND c.to_date = '9999-01-01'
GROUP BY c.dept_no
HAVING avg_salary = (SELECT 
        MAX(avg_salary)
    FROM
        (SELECT 
            ROUND(AVG(b.salary)) AS avg_salary
        FROM
            employees a, salaries b, dept_emp c
        WHERE
            a.emp_no = b.emp_no
                AND a.emp_no = c.emp_no
                AND b.to_date = '9999-01-01'
                AND c.to_date = '9999-01-01'
        GROUP BY c.dept_no) a);
-- 문제7.평균 연봉이 가장 높은 직책?
-- 1) 평균연봉
select max(avg_salary) from (select avg(salary) as avg_salary
					from salaries a join titles b 
                    on a.emp_no = b.emp_no
                    where a.to_date = '9999-01-01'
                    and b.to_date = '9999-01-01'
                    group by b.title) a;

select a.title, avg(b.salary)
from titles a join salaries b on a.emp_no = b.emp_no
where a.to_date = '9999-01-01' and b.to_date = '9999-01-01'
group by a.title
having avg(b.salary) = (select max(avg_salary) from 
								(select avg(salary) as avg_salary
								from salaries a join titles b 
								on a.emp_no = b.emp_no
								where a.to_date = '9999-01-01'
								and b.to_date = '9999-01-01'
								group by b.title) a);

-- 문제8.현재 자신의 매니저보다 높은 연봉을 받고 있는 직원은?
-- 부서이름, 사원이름, 연봉, 매니저 이름, 메니저 연봉 순으로 출력합니다.

-- 1) 매니저 연봉
select f.dept_name, a.first_name, d.salary , g.first_name , e.salary
from employees a 
join dept_emp b on a.emp_no = b.emp_no
join dept_manager c on c.emp_no = a.emp_no
join salaries d on a.emp_no = d.emp_no
join salaries e on a.emp_no = d.emp_no
join departments f on f.dept_no =b.dept_no
join employees g on c.emp_no = g.emp_no
where d.salary > e.salary;



-- 매니저 연봉
select a.emp_no as '매니저 사번 ', b.emp_no as '사원 사번' , c.salary as '매니저 월급' , d.salary as '사원 월급'
from dept_manager a
join dept_emp b on a.dept_no = b.dept_no
join salaries c on c.emp_no = a.emp_no
join salaries d on d.emp_no = b.emp_no;


-- 부서이름, 사원이름, 연봉, 매니저 이름, 메니저 연봉
select  a.emp_no as '사번', a.first_name as '사원 이름' , c.salary as '사원 연봉' , b.first_name as '매니저 이름', d.salary as '매니저 연봉'
from employees a, -- 직원
employees b, -- 매니저
salaries c, -- 직원
salaries d, -- 매니저
dept_emp e,
departments f,
dept_manager g
where a.emp_no = c.emp_no
and b.emp_no = d.emp_no
and g.emp_no = b.emp_no
and e.emp_no = a.emp_no
and e.dept_no = f.dept_no
and c.salary > d.salary;