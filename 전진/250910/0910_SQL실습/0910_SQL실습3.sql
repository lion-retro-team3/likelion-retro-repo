use hr;
-- 문자 함수를 이용한 SQL 연습 문제
-- 직원의 성(last_name)을 대문자로 변환하여 조회하기:
select upper(last_name) from employees;
-- 직원의 이름(first_name)의 첫 글자를 추출하기:
select left(first_name,1) from employees;
-- 직원의 성(last_name)에서 'a'가 몇 번 나오는지 세기:
SELECT last_name, (CHAR_LENGTH(last_name) - CHAR_LENGTH(REPLACE(last_name, 'a', ''))) AS cnt_a FROM employees;
-- 직원의 이메일에서 도메인 부분만 추출하기 (@ 이후 문자열):
select email, substring_index(email,'@',1) from employees;
-- 직원의 전체 이름을 성과 이름으로 구분하여 조회하기:
SELECT CONCAT(last_name, ', ', first_name) AS formatted_name FROM employees;
-- 직원의 이름(first_name)에서 세 번째 문자부터 세 글자 가져오기:
select substring(first_name,3,3) from employees;
-- 모든 직원의 성(last_name)을 쉼표와 공백 후 이름(first_name)으로 표시하기:
SELECT CONCAT(last_name, ', ', first_name) AS full_name FROM employees;
-- 직원의 이름(first_name)의 길이를 구하여 조회하기:
SELECT first_name, CHAR_LENGTH(first_name) AS name_length FROM employees;
-- 직원의 성(last_name)이 'King'인 직원 찾기 (대소문자 구분 없이):
select * from employees where last_name = 'King';
-- 직원의 성(last_name) 중 'M'으로 시작하는 사람들의 수 구하기:
select count(last_name) from employees where last_name like 'M%';