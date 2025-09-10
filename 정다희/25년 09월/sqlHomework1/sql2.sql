-- 실습 2
-- 날짜형 함수 사용 (날짜 데이터 처리)
-- 1. employees 테이블에서 각 직원의 입사 연도(year)를 조회하세요.
SELECT CONCAT(first_name, ' ', last_name) AS name, YEAR(hire_date) AS hire_year FROM employees;

-- 2. job_history 테이블에서 각 기록의 근무 기간을 월(months) 단위로 계산하세요.
SELECT TIMESTAMPDIFF(MONTH, start_date, end_date) AS months_worked FROM job_history;

-- 3. employees 테이블에서 오늘로부터 입사한 지 30년이 된 직원들의 이름과 입사 날짜를 조회하세요.
SELECT CONCAT(first_name, ' ', last_name) AS name, hire_date
FROM employees WHERE TIMESTAMPDIFF(YEAR, hire_date, CURDATE()) = 30;

-- 4. employees 테이블에서 이번 달이 입사월인 직원들의 이름과 이메일을 조회하세요.
SELECT CONCAT(first_name, ' ', last_name) AS name, email
FROM employees WHERE MONTH(hire_date) = MONTH(CURDATE());

-- 5. employees 테이블에서 입사 날짜가 최근 30년 이내인 직원들의 이름과 입사 날짜를 조회하세요.
SELECT CONCAT(first_name, ' ', last_name) AS name, hire_date
FROM employees WHERE TIMESTAMPDIFF(YEAR, hire_date, CURDATE()) <= 30;

-- 6. job_history 테이블에서 직원이 특정 부서에 근무한 기간을 일(days) 단위로 조회하세요.
SELECT CONCAT(e.first_name, ' ', e.last_name) AS name,
       d.department_name AS dpt_name,
       DATEDIFF(j.end_date, j.start_date) AS worked_day
FROM job_history j
JOIN employees e ON j.employee_id = e.employee_id
JOIN departments d ON j.department_id = d.department_id;

-- 7. employees 테이블에서 가장 오래전에 입사한 직원의 이름과 입사 날짜를 조회하세요.
SELECT CONCAT(first_name, ' ', last_name) AS name, hire_date
FROM employees
ORDER BY hire_date ASC
LIMIT 1;

-- 8. employees 테이블에서 각 직원의 입사일로부터 경과한 일수를 조회하세요.
SELECT CONCAT(first_name, ' ', last_name) AS name,
       DATEDIFF(NOW(), hire_date) AS worked_day
FROM employees;

-- 9. job_history 테이블에서 1999년대에 시작된 모든 근무 기록을 조회하세요.
SELECT * FROM job_history WHERE YEAR(start_date) = '1999';

-- 10. employees 테이블에서 각 직원의 입사 날짜를 요일로 표시하세요.
SELECT CONCAT(first_name, ' ', last_name) AS name,
       hire_date,
       DATE_FORMAT(hire_date, '%W') AS week
FROM employees;


-- 숫자형 함수 사용 (수치 데이터 처리)
-- 1. employees 테이블에서 각 직원의 급여에 10% 인상된 금액을 계산하여 조회하세요.
SELECT CONCAT(first_name, ' ', last_name) AS name,
       salary,
       salary + (salary * 0.1) AS inc_salary
FROM employees;

-- 2. jobs 테이블에서 각 직업의 최소 급여와 최대 급여의 차이를 계산하세요.
SELECT (max_salary - min_salary) AS diff_salary FROM jobs;

-- 3. employees 테이블에서 각 직원의 급여를 원화(KRW)로 환산하여 조회하세요 (환율 가정: 1 USD = 1200 KRW).
SELECT CONCAT(first_name, ' ', last_name) AS name, (salary * 1200) AS KRW FROM  employees;

-- 4. employees 테이블에서 전체 직원의 평균 급여보다 높은 급여를 받는 직원들의 이름과 급여를 조회하세요.
SELECT CONCAT(first_name, ' ', last_name) AS name, salary
FROM employees WHERE salary > (SELECT AVG(salary) FROM employees);

-- 5. employees 테이블에서 각 직원의 급여에서 평균 급여를 뺀 금액을 계산하여 조회하세요.
SELECT (salary - (SELECT ROUND(AVG(salary),2) FROM employees)) AS diff FROM employees;

-- 6. employees 테이블에서 급여의 표준 편차를 계산하여 조회하세요.
SELECT STD(salary) FROM employees;

-- 7. employees 테이블에서 각 직원의 연봉을 계산하고, 연봉이 가장 높은 순으로 정렬하여 조회하세요.
SELECT (salary * 12) AS annual_salary FROM employees ORDER BY annual_salary DESC;

-- 8. job_history 테이블에서 각 기록에 대해 부서 변경 횟수를 계산하세요.
SELECT employee_id, (COUNT(department_id) - 1) AS change_cnt
FROM job_history
GROUP BY employee_id;

-- 9. employees 테이블에서 직원들의 급여를 오름차순으로 정렬하여 조회하세요.
SELECT salary FROM employees ORDER BY salary ASC;