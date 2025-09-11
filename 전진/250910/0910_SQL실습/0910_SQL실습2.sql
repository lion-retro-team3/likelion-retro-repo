-- 날짜형 함수 사용 (날짜 데이터 처리)
-- employees 테이블에서 각 직원의 입사 연도(year)를 조회하세요.
select *, year(hire_date) as year from employees;
-- job_history 테이블에서 각 기록의 근무 기간을 월(months) 단위로 계산하세요.
SELECT *, TIMESTAMPDIFF(MONTH, start_date, end_date) AS 근무월 FROM job_history;
-- employees 테이블에서 오늘로부터 입사한 지 30년이 된 직원들의 이름과 입사 날짜를 조회하세요.
select first_name, hire_date from employees WHERE DATE_ADD(hire_date, INTERVAL 30 YEAR) = CURDATE();
-- employees 테이블에서 이번 달이 입사월인 직원들의 이름과 생일을 조회하세요.
select first_name, email from employees where Month(now()) = month(hire_date);
-- employees 테이블에서 입사 날짜가 최근 30년 이내인 직원들의 이름과 입사 날짜를 조회하세요.
select first_name, hire_date from employees where timestampdiff(year,now(),hire_date)<=30;
-- job_history 테이블에서 직원이 특정 부서에 근무한 기간을 일(days) 단위로 조회하세요.
select *,datediff(end_date,start_date) as days from job_history;
-- employees 테이블에서 가장 오래전에 입사한 직원의 이름과 입사 날짜를 조회하세요.
select first_name,hire_date from employees order by hire_date limit 1;
-- employees 테이블에서 각 직원의 입사일로부터 경과한 일수를 조회하세요.
select *, datediff(now(),hire_date) as days from employees;
-- job_history 테이블에서 1999년대에 시작된 모든 근무 기록을 조회하세요.
select * from job_history where start_date like '%1999%';
-- employees 테이블에서 각 직원의 입사 날짜를 요일로 표시하세요.
select *, dayname(hire_date) as day from employees;

-- 숫자형 함수 사용 (수치 데이터 처리)
-- employees 테이블에서 각 직원의 급여에 10% 인상된 금액을 계산하여 조회하세요.
select *, salary*1.1 as plussalary from employees;
-- jobs 테이블에서 각 직업의 최소 급여와 최대 급여의 차이를 계산하세요.
select *, max_salary-min_salary as diff_salary from jobs;
-- employees 테이블에서 각 직원의 급여를 원화(KRW)로 환산하여 조회하세요 (환율 가정: 1 USD = 1200 KRW).
select *,salary*1200 as KRW from employees;
-- employees 테이블에서 전체 직원의 평균 급여보다 높은 급여를 받는 직원들의 이름과 급여를 조회하세요.
select first_name,salary from employees WHERE salary > (SELECT AVG(salary) FROM employees);
-- employees 테이블에서 각 직원의 급여에서 평균 급여를 뺀 금액을 계산하여 조회하세요.
select *, salary - (SELECT AVG(salary) FROM employees) as diff from employees;
-- employees 테이블에서 급여의 표준 편차를 계산하여 조회하세요.
SELECT STD(salary) AS std_salary FROM employees;
-- employees 테이블에서 각 직원의 연봉을 계산하고, 연봉이 가장 높은 순으로 정렬하여 조회하세요.
select *,salary*12 as year_salary from employees order by year_salary DESC;
-- job_history 테이블에서 각 기록에 대해 부서 변경 횟수를 계산하세요.
select *, count(employee_id) from job_history group by(employee_id);
-- employees 테이블에서 직원들의 급여를 오름차순으로 정렬하여 조회하세요.
select salary from employees order by salary;