CREATE TABLE TEMP_DEPT
AS SELECT * FROM DEPARTMENT WHERE 1 = 0;

-- 그냥 넣기
INSERT INTO TEMP_DEPT VALUES('D1', '자바학부', '1');
-- 컬럼 지정해서 넣기
INSERT INTO TEMP_DEPT (DEPT_ID, DEPT_TITLE, LOCATION_ID) VALUES('D2','메가스터디', '1');

SELECT * FROM TEMP_DEPT;

CREATE TABLE TEST_TAB(
    TEST_NAME VARCHAR2(20) DEFAULT '없음' NOT NULL,
    TEST_NUM NUMBER
);

-- DEFAULT 값 있으면 다 안넣어줘도 됨
INSERT INTO TEST_TAB (TEST_NUM) VALUES(100);
SELECT * FROM TEST_TAB;

-- JOIN INSERT
CREATE TABLE INSERT_SUB
AS SELECT EMP_ID, EMP_NAME, DEPT_TITLE
   FROM EMPLOYEE JOIN DEPARTMENT ON DEPT_CODE = DEPT_ID WHERE 1=0;
   
INSERT INTO INSERT_SUB(SELECT EMP_ID, EMP_NAME, DEPT_TITLE 
                        FROM EMPLOYEE JOIN DEPARTMENT ON DEPT_CODE = DEPT_ID
                        WHERE DEPT_CODE = 'D5');

SELECT * FROM INSERT_SUB;

-- INSERT ALL
-- 서브쿼리를 이용해서 두개 이상의 테이블에 데이터를 삽입하는 명령어

CREATE TABLE EMP_HIRE_DATE
AS SELECT EMP_ID, EMP_NAME, HIRE_DATE FROM EMPLOYEE;
DELETE FROM EMP_HIRE_DATE;

CREATE TABLE EMP_MANAGER2
AS SELECT EMP_ID, EMP_NAME, MANAGER_ID FROM EMPLOYEE WHERE 1=0;

INSERT ALL
INTO EMP_HIRE_DATE VALUES(EMP_ID, EMP_NAME, HIRE_DATE)
INTO EMP_MANAGER2 VALUES(EMP_ID, EMP_NAME, MANAGER_ID)
SELECT EMP_ID, EMP_NAME, HIRE_DATE, MANAGER_ID
FROM EMPLOYEE;

SELECT * FROM EMP_HIRE_DATE;
SELECT * FROM EMP_MANAGER2;

-- INSERT ALL 을 이용해서 테이블에 값을 넣을때 조건에 맞춰 넣기
CREATE TABLE EMP_OLD
AS SELECT EMP_ID, EMP_NAME, HIRE_DATE FROM EMPLOYEE WHERE 1= 0;
CREATE TABLE EMP_NEW
AS SELECT EMP_ID, EMP_NAME, HIRE_DATE FROM EMPLOYEE WHERE 1 = 0;

-- EMP_OLD 테이블에 00년 01월 01일 이전에 입사한 사원들의 데이터를 삽입
-- EMP_NEW 테이블에 00년 01월 01일 이후에 입사한 사원들의 데이터를 삽입

INSERT ALL
    WHEN '00/01/01' > HIRE_DATE THEN INTO EMP_OLD VALUES(EMP_ID, EMP_NAME, HIRE_DATE)
    WHEN '00/01/01' <= HIRE_DATE THEN INTO EMP_NEW VALUES(EMP_ID, EMP_NAME, HIRE_DATE)
SELECT EMP_ID, EMP_NAME, HIRE_DATE
FROM EMPLOYEE;

SELECT * FROM EMP_OLD;
SELECT * FROM EMP_NEW;

