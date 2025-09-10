
SELECT first_name last_name FROM employees e ;
SELECT department_name,location_id FROM departments;
SELECT job_id,job_title FROM jobs;
SELECT street_address,postal_code  FROM locations;
SELECT country_id,country_name FROM countries;
SELECT region_id,region_name FROM regions;
SELECT job_id FROM employees e;
SELECT department_id,department_name FROM departments d;
SELECT employee_id,department_id FROM job_history jh;
SELECT employee_id,first_name,last_name FROM employees e ;

SELECT e.employee_id,e.first_name,e.last_name,e.salary FROM employees e  WHERE e.salary >= 10000;
SELECT * FROM departments d WHERE d.location_id  = 1700;
SELECT * FROM employees e WHERE e.job_id = 'IT_PROG';
SELECT e.department_id , e.first_name,e.last_name,e.salary FROM employees e WHERE e.department_id = 90;
SELECT j.job_title FROM jobs j WHERE j.min_salary >= 5000;
SELECT * FROM employees e WHERE  e.last_name ='king';
SELECT * FROM locations l WHERE l.country_id ='US';
SELECT * FROM job_history jh WHERE jh.start_date < '2001-01-01';
SELECT e.first_name ,e.last_name ,e.email FROM employees e WHERE e.last_name LIKE '%a%';
SELECT * FROM employees e JOIN departments d ON e.department_id = d.department_id WHERE d.department_name ='sales';

SELECT YEAR(e.hire_date) FROM employees e;
SELECT MONTH(jh.start_date),MONTH(jh.end_date) FROM job_history jh ;
SELECT * FROM employees e WHERE TIMESTAMPDIFF(YEAR,e.hire_date,NOW()) = 30;
SELECT * FROM employees e WHERE MONTH(e.hire_date ) -MONTH(NOW()) = 0; 
SELECT * FROM employees e WHERE TIMESTAMPDIFF(YEAR,e.hire_date,NOW()) <= 30;
SELECT jh.department_id ,TIMESTAMPDIFF(DAY,jh.start_date,jh.end_date) as 근무일수 FROM job_history jh;
SELECT e.first_name ,e.last_name ,e.hire_date FROM employees e ORDER BY e.hire_date ASC LIMIT 1;
SELECT TIMESTAMPDIFF(DAY,e.hire_date,NOW()) as 근무일수 FROM employees e;
SELECT * FROM job_history WHERE YEAR(start_date) = 1999;
SELECT e.hire_date,dayname(e.hire_date) as hire_day FROM employees e;
SELECT e.salary ,e.salary*1.1 as increased_salary FROM employees e ;
SELECT e.salary,e.salary*1200 as salary_krw FROM employees e ;
SELECT e.first_name,e.last_name,e.salary FROM employees e WHERE salary > (SELECT AVG(e2.salary) FROM employees e2 );
SELECT e.salary - (SELECT AVG(e2.salary) FROM employees e2) as 급여_평균급여 FROM employees e ;
SELECT STDDEV_POP(e.salary) as 표준편차 FROM employees e ;
SELECT e.salary * 12 as 연봉 FROM employees e ORDER BY 연봉 DESC;
SELECT jh.job_id ,COUNT(jh.employee_id) as 변경횟수 FROM job_history jh GROUP by jh.job_id ;
SELECT * FROM employees e order by e.salary desc;

SELECT UPPER(e.last_name) FROM employees e;
SELECT SUBSTRING(e.first_name,1,1) FROM employees e;
SELECT e.last_name, LENGTH(e.last_name) - LENGTH(REPLACE(e.last_name,'a','')) FROM employees e;
SELECT e.email,SUBSTRING(e.email,LOCATE('@',e.email)+1) as mail_format from employees e;




