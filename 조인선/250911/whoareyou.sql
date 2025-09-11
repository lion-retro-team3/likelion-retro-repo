DROP TABLE IF EXISTS `job`;
DROP TABLE IF EXISTS `lawyers`;
-- 법조인정보 테이블
create table lawyers(
id int primary key auto_increment,
name varchar(50) not null,
job varchar(50) not null check(job IN('공인노무사', '공인중개사', '법무사', '변리사', '세무사', '행정사', '변호사', '판사', '검사')),
exam_name varchar(100) not null,
exam_num int null,
office_name varchar(500) not null,
birth_year year not null
);
INSERT INTO lawyers (name, job, exam_name, exam_num, office_name, birth_year) VALUES
('홍길동', '변호사', '사법시험', 40, '홍길동 법률사무소', 1970),
('이순신', '변호사', '변호사시험', 1, '이순신 법률사무소', 1975),
('박판', '판사', '사법시험', 35, '서울중앙지방법원', 1972),
('박검사', '검사', '사법시험', 36, '서울중앙지방검찰청', 1973),
('최세무', '세무사', '세무사시험', 20, '최세무 세무회계사무소', 1980),
('홍길동', '변호사', '사법시험', 41, '법무법인 활빈당', 1971),
('을지문덕', '변호사', '변호사시험', 1, '법무법인 살수', 1985),
('김판사', '판사', '사법시험', 35, '춘천중앙지방법원', 1974),
('강검사', '검사', '사법시험', 36, '제주지방검찰청', 1976),
('김세무', '세무사', '세무사시험', 20, '최고 세무법인', 1981),
('김노동', '공인노무사', '공인노무사시험', 12, '김노동 노무법인', 1978),
('정중개', '공인중개사', '공인중개사시험', 25, '정중개 공인중개사 사무소', 1982),
('조법무', '법무사', '법무사시험', 5, '조법무 법무사무소', 1979),
('유특허', '변리사', '변리사시험', 35, '유특허 특허법률사무소', 1983),
('장행정', '행정사', '행정사시험', 3, '장행정 행정사무소', 1977),
('홍길동', '행정사', '행정사시험', 1, '홍길동 행정사사무소', 1970),
('김판결', '판사', '사법시험', 35, '서울중앙지방법원', 1972),
('김검찰', '검사', '사법시험', 36, '서울중앙지검찰청', 1973);

select*from lawyers;
-- 직업 테이블
CREATE TABLE job (
  jname VARCHAR(50) NOT NULL
    CHECK (jname IN ('공인노무사','공인중개사','법무사','변리사','세무사','행정사','변호사','판사','검사')),
  jclass VARCHAR(100) NULL,
  jnum int null
);

INSERT INTO job (jname, jclass,jnum) VALUES
('변호사','사법연수원', 40),
('변호사','로스쿨', 1),
('판사','사법연수원', 35),
('검사','사법연수원', 36),
('세무사',NULL,NULL),
('공인노무사',NULL,NULL),
('공인중개사',NULL,NULL),
('법무사',NULL,NULL),
('변리사',NULL,NULL),
('행정사',NULL,NULL);
SELECT * FROM job;

-- 변호사 기수정보
select l.name, l.job, l.exam_name, l.exam_num, l.office_name, j.jclass, j.jnum
from lawyers l
join job j
on l.job = j.jname;


