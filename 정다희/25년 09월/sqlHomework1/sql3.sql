-- 실습 3
-- 문자 함수를 이용한 SQL 연습 문제

-- 1. 직원의 성(last_name)을 대문자로 변환하여 조회하기
SELECT UPPER(last_name) FROM employees;

-- 2. 직원의 이름(first_name)의 첫 글자를 추출하기
SELECT SUBSTR(first_name, 1, 1) FROM employees;

-- 3. 직원의 성(last_name)에서 'a'가 몇 번 나오는지 세기
SELECT last_name,
       (LENGTH(last_name) - LENGTH(REPLACE(last_name,'a', ''))) AS A_CNT
FROM employees;

-- 4. 직원의 이메일에서 도메인 부분만 추출하기 (@ 이후 문자열)
SELECT email,
       SUBSTRING_INDEX(email, '@', -1) AS domain
FROM employees;

-- 5. 직원의 전체 이름을 성과 이름으로 구분하여 조회하기
SELECT SUBSTRING_INDEX(full_name, ' ', 1) AS last_name,
       SUBSTRING_INDEX(full_name, ' ', -1) AS first_name
FROM employees;

-- 6. 직원의 이름(first_name)에서 세 번째 문자부터 세 글자 가져오기
SELECT first_name, SUBSTR(first_name, 3, 3) FROM employees;

-- 7. 모든 직원의 성(last_name)을 쉼표와 공백 후 이름(first_name)으로 표시하기
SELECT CONCAT(last_name, ', ', first_name) AS name FROM employees;

-- 8. 직원의 이름(first_name)의 길이를 구하여 조회하기
SELECT first_name, LENGTH(first_name) AS length FROM employees;

-- 9. 직원의 성(last_name)이 'King'인 직원 찾기 (대소문자 구분 없이)
SELECT * FROM employees WHERE UPPER(last_name) = 'KING';
SELECT * FROM employees WHERE LOWER(last_name) = 'king';

-- 10. 직원의 성(last_name) 중 'M'으로 시작하는 사람들의 수 구하기
SELECT COUNT(*) FROM employees WHERE last_name LIKE 'M%';

