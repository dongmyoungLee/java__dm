SELECT * FROM DBA_USERS;
-- 실습을 위한 사용자 계정만들기
-- SYSTEM(관리자계정)으로 생성을 해줘야한다.
-- CREATE USER 사용자명 IDENTIFIED BY 비밀번호 DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;
-- 18C 버전부터는 사용자명에 C##을 부여하게 되어있음, -> 해제할 수 있음, 해제해서 사용하자
ALTER SESSION SET "_ORACLE_SCRIPT"=TRUE;
CREATE USER BS IDENTIFIED BY BS DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;
-- 생성된 계정 확인하기
SELECT * FROM DBA_USERS;--데이터베이스에 등록된 계정을 조회하는 명령어

-- 생성된 계정으로 접속하기 -> 접속만들기 -> 접속
-- 생성된 계정으로 접속이 금지되어있음 -> 권한이 없음
-- 관리자 계정으로 사용자에게 접속권한 부여해주기 -> CONNECT권한 부여
-- GRANT 권한명||ROLE이름 TO 부여할 사용자명
GRANT CONNECT TO BS;

-- BS계정으로 접속해서 명령어 실행해보기
SELECT * FROM TAB; -- BS계정이 가지고 있는 테이블(데이터를 저장하는 공간) 조회하기
--  저장공간 생성해보기
-- 샘플로 TEST이름의 저장공간을 생성하는 구문
-- 기본적으로 저장공간을 생성할 수 있는 권한은 부여되어 있지않다.! -> SYSTEM계정으로 부여를 해줘야함.
CREATE TABLE TEST(
    TEST_NAME VARCHAR2(200)
);

-- 저장공간생성하는 권한 부여하기
GRANT RESOURCE TO BS;

-- 사용자가 생성한 테이블 조회
SELECT * FROM TAB;

-- 새로운 계정을 생성을 하게 되면 SYSTEM계정으로 알맞는 권한을 부여해줘야한다.
-- 기본적으로 RESOURCE, CONNECT권한을 부여한다.

-- BS계정에 추가된 데이터 확인하기
-- 추가된 테이블(저장공간) 확인하기
SELECT * FROM TAB;
-- EMPLOYEE : 사원정보 저장테이블
SELECT * FROM EMPLOYEE;
-- DEPARTMENT : 부서정보 저장테이블
SELECT * FROM DEPARTMENT;
-- JOB : 직책정보 저장테이블
SELECT * FROM JOB;
-- LOCATION : 부서지역정보 저장테이블
SELECT * FROM LOCATION;
-- NATIONAL : 국가정보 저장 테이블
SELECT * FROM NATIONAL;
-- SAL_GRADE : 급여 수준 저장 테이블
SELECT * FROM SAL_GRADE;

-- SELECT문 활용하기
-- 기본 SELECT 문
-- SELECT 컬럼명, 컬럼명,.....(컬럼을 선택)
-- FROM 테이블명

-- EMPLOYEE 테이블의 EMP_ID, EMP_NAME, SALARY 컬럼을 조회하기
SELECT EMP_ID, EMP_NAME, SALARY 
FROM EMPLOYEE;

-- DEPARTMENT테이블의 DEPT_TITLE조회하기
SELECT DEPT_TITLE
FROM DEPARTMENT;

-- EMPLOYEE테이블에 있는 전체 컬럼을 조회하기
-- SELECT문에 컬럼을 설정부분에 * 을 사용하면 된다.
SELECT * 
FROM EMPLOYEE;

-- DEPARTMENT테이블에 있는 전체 컬럼을 조회하기
SELECT * FROM DEPARTMENT;

-- 계정에 저장되어있는 테이블과 컬럼 확인하기
-- 테이블조회
SELECT * FROM TAB;
-- 테이블의 컬럼명 조회하기
DESC DEPARTMENT;

-- SELECT문을 이용해서 산술연산 처리결과를 확인할 수 있음
-- SELECT  1+10 FROM EMPLOYEE;
-- 테스트용 기본 테이블 제공 -> DUAL테이블
-- 간단한 계산, 오라클제공함수실행할 때 사용
SELECT 1+10,5*3,10/2 FROM DUAL;
-- 계산결과를 출력해주는 컬럼 -> 가상컬럼이라고 함.
-- 데이터가 있는 테이블의 컬럼과 산술연산이 가능
-- EMPLOYEE테이블의 SALARY에 100더하기
SELECT EMP_NAME, SALARY,SALARY+100
FROM EMPLOYEE;

-- 각 사원의 이름, 월급 연봉을 조회하기
SELECT EMP_NAME, SALARY, SALARY * 12
FROM EMPLOYEE;

-- 컬럼값이 NULL인 경우 산술연산이 불가능 -> 함수를 이용해서 NULL일때 대체값을 지정할 수 있음
SELECT * FROM EMPLOYEE;
SELECT EMP_NAME, BONUS, NVL(BONUS,0)+0.5
FROM EMPLOYEE;

-- 컬럼과 산술연산을 할 경우 컬럼의 타입이 숫자형이어야 한다.
--SELECT EMP_NAME+100
--FROM EMPLOYEE;

-- FROM절에서 사용한 테이블에 있는 컬럼만 조회가 가능하다
--SELECT DEPT_ID, DEPT_TITLE,EMP_NAME 
--FROM DEPARTMENT;

-- 컬럼명을 새롭게 지정할 수 있음 -> 별칭부여하기
SELECT EMP_ID, EMP_NAME, EMAIL
FROM EMPLOYEE;
-- 컬럼을 선택하고 AS예약어를 이용해서 별칭을 부여
SELECT EMP_ID AS 사원번호,EMP_NAME AS 사원명, EMAIL AS 이메일
FROM EMPLOYEE;
-- 가상컬럼에 별칭을 부여하는 경우가 많음
SELECT EMP_ID, EMP_NAME, SALARY, SALARY*12 AS YEAR_SALARY
FROM EMPLOYEE;
-- 별칭은 ""을 이용해서 띄어쓰기 할 수 있다.
SELECT EMP_ID AS "사원 번호",EMP_NAME AS "이$름"
FROM EMPLOYEE;

-- 중복데이터(ROW)을 제거 조회하기
-- DISTINCT예약어를 사용해서 조회를 한다
SELECT DISTINCT DEPT_CODE
FROM EMPLOYEE;
SELECT DISTINCT JOB_CODE
FROM EMPLOYEE;
-- DISTINCT는 SELECT 예약어 다음에만 사용이 가능
-- SELECT EMP_NAME, DISTINCT DEPT_CODE
-- FROM EMPLOYEE;
SELECT DISTINCT DEPT_CODE, JOB_CODE
FROM EMPLOYEE;

-- 문자열을 결합해주는 연산처리하기
-- 문자열||문자열 -> 문자열을 결합
-- 오라클에서 문자열 리터럴표시 -> ''
SELECT '여러분 '||'점심맛있게 먹었나요?' AS MSG
FROM DUAL;

-- 문자열 컬럼을 결합하여 출력할때도 사용
SELECT EMP_NAME||'님의 이메일은 '||EMAIL
FROM EMPLOYEE;

SELECT * FROM EMPLOYEE;
-- 데이터(ROW)를 필터하기 -> 조건에 맞는 데이터(ROW) 조회하기
-- WHERE 예약어를 사용
-- 사용
-- SELECT *||컬럼명,컬럼명.....
-- FROM 테이블명
-- WHERE 조건문(비교연산(=, >=, <=, !=), 논리연산(AND, OR))
-- EMPLOYEE 테이블에서 월급이 300만원이상인 사원을 조회하자
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE SALARY>=3000000;

-- EMPLOYEE 테이블에서 DEPT_CODE가 D5인 사원의 전체컬럼을 조회하기
SELECT * 
FROM EMPLOYEE
WHERE DEPT_CODE='D5';

-- EMPLOYEE 테이블에서 JOB_CODE가 J2인 사원의 이름, 급여, 직책코드 조회하기
SELECT EMP_NAME, SALARY, JOB_CODE
FROM EMPLOYEE
WHERE  JOB_CODE='J2';

-- EMPLOYEE테이블에서 부서코드가 D5가 아닌 사원의 이름, 부서코드 조회하기
SELECT EMP_NAME, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE != 'D5';

-- EMPLOYEE 테이블에서 부서코드가 D5이고 월급이 300만원이상인 사원의 전체컬럼 조회하기
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE='D5' AND SALARY>=3000000;

-- EMPLOYEE 테이블에서 부서코드가 D5이거나 월급이 300만원 이하인 사원의 전체컬럼 조회하기
SELECT * 
FROM EMPLOYEE
WHERE DEPT_CODE='D5' OR SALARY<=3000000;

-- 날짜형 데이터도 대소비교가 가능하다
-- 날짜표시는 문자열로 패턴에 맞춰서 표현 -> 'YYYY/MM/DD' 'YY/MM/DD'
-- EMPLOYEE테이블에서 입사일(HIRE_DATE)이 2000년도 이전인 사원을 구하기
SELECT *
FROM EMPLOYEE
WHERE HIRE_DATE < '00/01/01';


-- 특정범위를 조회하는 구문
-- AND 연결하여 사용, BETWEEN AND를 사용해서 처리하는 방법
-- EMPLOYEE테이블에서 월급을 200만원 이상 300만원 이하로 받는 사원의 이름, 급여, 보너스, 입사일 조회하기
SELECT *
FROM EMPLOYEE
--WHERE SALARY>=2000000 AND SALARY<=3000000;
WHERE SALARY BETWEEN 2000000 AND 3000000;

-- EMPLOYEE테이블에서 입사일이 2000년인 사원을 조회하기
SELECT *
FROM EMPLOYEE
--WHERE HIRE_DATE>='00/01/01' AND HIRE_DATE<='00/12/31';
WHERE HIRE_DATE BETWEEN '00/01/01' AND '00/12/31'; 


-- LIKE연산자 이용하기
-- 문자열 데이터를 패턴으로 비교하는 연산 -> 부분일치, 패턴에 맞는 문자열을 찾을 사용
-- 이메일 'EA'가 있는 사원, 성이 김씨인 사원, 주민번호에 32가 있는 사원
-- 컬럼명 LIKE '비교할문자패턴'
-- % : 문자가 0개이상 아무문자나 허용 
-- 예) '%강%' : 강이 있는 포함된 문자열 한강(O), 강사(o) 강하라(0),강강술래(0), 김강우(0),ㅁㄴㅇㄻㄴㄹㄴ강ㅁㄴㅇㄻㄴㅇㄹ(0)'
--     '강%' : 강으로 시작하는 문자열
-- _ : 문자가 1개 아무무자나 허용
-- 예) '_강_' : 3글자 문자열 중간에 강이 있는것
-- 예) '_유%' : 2글자이상 문자열 두번째 글자가 '유'인 문자열

-- 사원 중 유씨성을 가진 사원의 사원명, 월급, 부서코드 조회하기
SELECT EMP_NAME, SALARY, DEPT_CODE
FROM EMPLOYEE
--WHERE EMP_NAME LIKE '유%';
WHERE EMP_NAME LIKE '유__';
-- EMAIL에 YO를 포함하고 있는 사원의 이름, 이메일을 조회하기
SELECT EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE EMAIL LIKE '%y%';

-- LIKE부정연산하기
-- 사원의 성이 유가 아닌 사원들 조회하기
SELECT * 
FROM EMPLOYEE
WHERE EMP_NAME NOT LIKE '유%';

-- 이메일주소에 _앞글자가 3글자인 사원의 사원명, 이메일 조회하기
SELECT EMP_NAME, EMAIL 
FROM EMPLOYEE
WHERE EMAIL LIKE '___\_%' ESCAPE '\';

-- NULL값 비교하기
-- 기본적으로 NULL값은 비교연산 처리를 할 수 없다.
-- NULL값을 처리하기 위한 연산자를 만들어 놓음
-- IS NULL / IS NOT NULL
-- 사원중 보너스를 받는 사원의 이름, 급여, 보너스를 조회하기
SELECT * 
FROM EMPLOYEE
WHERE BONUS IS NOT NULL;
--WHERE BONUS = NULL

-- 사원중 매니저가 지정되지않은 사원을 조회하기
SELECT * FROM EMPLOYEE;
SELECT * 
FROM EMPLOYEE
WHERE MANAGER_ID IS NULL;

-- 부서가 없는 사원 조회하기
-- 부서코드에 인턴으로 작성하기
SELECT E.*, NVL(DEPT_CODE,'인턴')
FROM EMPLOYEE E 
WHERE DEPT_CODE IS NULL;

-- 다중값 동등비교하기
-- OR로 연결해서 처리하기 IN을 활용하기
-- 사원중 부서가 D5이거나 D6인 사원의 사원명 부서코드를 조회하기
SELECT EMP_NAME, DEPT_CODE
FROM EMPLOYEE
--WHERE DEPT_CODE='D5' OR DEPT_CODE='D6';
--WHERE DEPT_CODE IN ('D5','D6');
WHERE DEPT_CODE IN (SELECT DEPT_CODE FROM EMPLOYEE WHERE EMP_NAME IN('심봉선','송종기'));
-- 신봉선, 송종기사원과 같은 부서인 사원구하기
SELECT DEPT_CODE FROM EMPLOYEE WHERE EMP_NAME IN('심봉선','송종기');

-- NOT IN()사용하기
-- D5, D6이 아닌 사원 조회하기
SELECT * 
FROM EMPLOYEE
WHERE DEPT_CODE NOT IN ('D5','D6');

-- 논리연산사용시 연산자 우선순위에 유의하자.
-- 직책이 J7이거나 J2인 사원 중 급여가 200만원 이상인 사원을 조회
SELECT EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE (JOB_CODE='J7' OR JOB_CODE='J2') AND SALARY>=2000000;

-- WHERE 절에도 산술연산을 사용할 수 있다.
SELECT *
FROM EMPLOYEE
WHERE SALARY > SALARY*12;


-- 오라클에서 제공하는 함수를 사용해보자
-- 함수를 사용할때는 SELECT문에서 사용을 한다.
-- SELECT문의 컬럼쓰는 곳이나 WHERE에 사용을 할 수 있다.

-- 단일행함수 선택한 테이블에 있는 모든 ROW에 결과를 출력해주는 함수
-- 문자열 처리함수
-- LENGTH() : 매개변수로 전달된 컬럼이나 리터럴의 길이를 출력해주는 함수
SELECT LENGTH('유병승') FROM DUAL;
-- 이메일 길이 확인하기
SELECT LENGTH(EMAIL), EMAIL FROM EMPLOYEE;

-- 이메일의 길이가 13이상이 사원
SELECT EMAIL 
FROM EMPLOYEE
WHERE LENGTH(EMAIL)>=13;

--LENGTHB()

-- INSTR() : JAVA INDEXOF()메소드와 유사
-- 문자열의 인덱스 위치를 반환해주는 함수
-- INSTR(대상문자열||컬럼,찾을문자열[,검색시작위치]) : 찾은 문자열의 인덱스번호를 반환
SELECT INSTR('메가스터디IT','IT'), INSTR('메가스터디IT','메가')
FROM DUAL;
SELECT EMAIL, INSTR(EMAIL,'j')
FROM EMPLOYEE;

SELECT INSTR('메가 스터디 메가스터디 IT 메가 스터디 미용','메가',4),
INSTR('메가 스터디 메가스터디 IT 메가 스터디 미용','메가',1,3)
FROM DUAL;

-- LPAD/RPAD : 지정한 길이에 문자열이 채워지지 않았을대 특정문자로 채워주는 함수
-- LPAD||RPAD(문자열||컬럼명,길이,공백시채워줄문자)
SELECT LPAD('메가',10,'*'),RPAD('메가',10,'*')
FROM DUAL;
SELECT RPAD(EMP_NAME,8,'님')
FROM EMPLOYEE;

-- LTRIM/RTRIM : 공백 또는 특정 문자를 삭제해주는 기능
SELECT '    유병승',LTRIM('    유병승'),'1111병승',LTRIM('1111병승','1'),LTRIM('11211병승','1')
FROM DUAL;

-- TRIM : 양쪽의 값을 제거하는 함수, 기본 : 공백, 설정한 값을 제거
SELECT '     병승      ',TRIM('     병승      '),
TRIM('Z' FROM 'ZZZZZ병승ZZZZZ'),
TRIM(LEADING 'Z' FROM 'ZZZZZ병승ZZZZZ'),
TRIM(TRAILING 'Z' FROM 'ZZZZZ병승ZZZZZ'),
TRIM(BOTH 'Z' FROM 'ZZZZZ병승ZZZZZ')
FROM DUAL;

-- SUBSTR : JAVA SUBSTRING메소드와 유사한 함수
-- SUBSTR(대상문자열,시작인덱스[,끝인덱스])
SELECT EMP_NAME, SUBSTR(EMP_NAME,1,1)
FROM EMPLOYEE;
SELECT DISTINCT SUBSTR(EMP_NAME,1,1)
FROM EMPLOYEE;

SELECT * FROM EMPLOYEE;
SELECT SUBSTR(EMP_NO,1,2) AS 년도, SUBSTR(EMP_NO,8,1) AS 성별
FROM EMPLOYEE;

SELECT * 
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO,1,2) BETWEEN 80 AND 89;

SELECT *
 FROM EMPLOYEE
 WHERE SUBSTR(EMP_NO,8,1) IN ('2','4');
 
-- 사원의 이메일에서 아이디만 출력하기
SELECT EMAIL,SUBSTR(EMAIL,1,INSTR(EMAIL,'@')-1)
FROM EMPLOYEE;
SELECT EMAIL,SUBSTR(EMAIL,1,INSTR(EMAIL,'@')-1)
FROM EMPLOYEE
WHERE LENGTH(SUBSTR(EMAIL,1,INSTR(EMAIL,'@')-1))>=7;

-- 영문자를 처리하는 함수
-- UPPER, LOWER, INITCAP
SELECT LOWER('Welcome to oRACLE world'),
UPPER('Welcome to oRACLE world'),
INITCAP('Welcome to oRACLE world')
FROM DUAL;
SELECT * 
FROM EMPLOYEE
WHERE DEPT_CODE = UPPER('d5');

-- REPLACE : 대상문에서 지정문자를 찾아서 대체문자로 변경해주는 함수
-- REPLACE(문자열||컬럼명,'찾을문자','대체문자')
SELECT EMAIL, REPLACE(EMAIL,'or.kr','BS.or.kr')
FROM EMPLOYEE;
UPDATE EMPLOYEE SET EMAIL=REPLACE(EMAIL,'or.kr','BS.or.kr');
SELECT * FROM EMPLOYEE;
COMMIT;

-- 숫자처리함수
-- 소수점에 대한 처리, 계산에 대한 처리도 있다...
-- ABS : 절대값
SELECT ABS(-10), ABS(10)
FROM DUAL;

--MOD() : 나머지구하는함수 -> %
SELECT MOD(3,2)
FROM DUAL;
SELECT E.*, MOD(SALARY,3)
FROM EMPLOYEE E;

-- 소수점을 처리하는 함수
-- ROUND(반올림), FLOOR(소수점버림), TRUNC(소수점버림, 버리는 자리수정함), CEIL(무조건올림)
SELECT ROUND(126.456),FLOOR(126.567),TRUNC(126.567,1),CEIL(126.123) 
FROM DUAL;

-- 보너스를 포함한 월급구하기
SELECT EMP_NAME,SALARY,FLOOR(SALARY+(SALARY*NVL(BONUS,0)-(SALARY*0.03))) AS SALARY
FROM EMPLOYEE;

-- 날짜처리함수
-- 오라클에서 날짜를 출력할때 두가지
-- SYSDATE예약어를 사용 -> 오늘날짜출력(DB서버컴퓨터에 설정한 날짜)
-- SYSTIMESTAMP예약어 사용 날짜,시간을 동시출력
SELECT SYSDATE, SYSTIMESTAMP FROM DUAL;

-- 날짜는 연산이 가능함. +, - 일수를 계산
SELECT SYSDATE, SYSDATE+3, SYSDATE-10
FROM DUAL;
-- NEXT_DAY : 인자로 전달된 요일중 가장 가까운 다음날짜를 출력
SELECT NEXT_DAY(SYSDATE,'화'), NEXT_DAY(SYSDATE,'금')
FROM DUAL;
SELECT * FROM V$NLS_PARAMETERS;
ALTER SESSION SET NLS_LANGUAGE='KOREAN';

-- LAST_DAY : 그달의 마지막날을 출력해주는 함수
SELECT LAST_DAY(SYSDATE)
FROM EMPLOYEE;

SELECT NEXT_DAY(HIRE_DATE,'토'), LAST_DAY(HIRE_DATE)
FROM EMPLOYEE;

-- 개월수를 계산해주는(더해주는) 함수
-- ADD_MONTHS()
SELECT ADD_MONTHS(SYSDATE,-3), ADD_MONTHS(SYSDATE,3)
FROM DUAL;
-- 두 날짜의 개월수차이를 출력해주는 함수
-- MONTHS_BETWEEN(날짜, 날짜)
SELECT FLOOR(MONTHS_BETWEEN(SYSDATE,'23/04/20'))
FROM DUAL;

-- 날짜의 년도, 월, 일을 따로 출력해주는 함수
-- EXTRACT(YEAR||MONTH||DAY FROM 날짜) : 숫자
SELECT EXTRACT(YEAR FROM SYSDATE), EXTRACT(MONTH FROM SYSDATE), EXTRACT(DAY FROM SYSDATE)
FROM DUAL;

SELECT EXTRACT(YEAR FROM SYSDATE)-1995
FROM DUAL;

-- 사원중 12월에 입사한 사원 조회하기
SELECT * 
FROM EMPLOYEE
WHERE EXTRACT(MONTH FROM HIRE_DATE)=12;

-- 사원중 2000년대 입사한 사원 조회하기
SELECT * 
FROM EMPLOYEE
WHERE EXTRACT(YEAR FROM HIRE_DATE) BETWEEN 2000 AND 2009;

-- 오늘부로 태훈씨가 군대로 끌려가게 되었습니다.ㅠㅠ 잘가 태훈씨~ 군대복무기간은 1년 6개월로
-- 전역일자를 구하고, 복무일수, 전역때까지 먹그 짬밥갯수(하루 3끼)를 구하기
SELECT ADD_MONTHS(SYSDATE,18) AS 전역일, ADD_MONTHS(SYSDATE,18)-SYSDATE AS 복무일수,
    (ADD_MONTHS(SYSDATE,18)-SYSDATE)*3 AS 짬밥수
FROM DUAL;

-- 형변환 함수 -> (자료형), parseOOO, String.valueOf
-- 오라클은 자동형변환이 잘 작동.
-- 강제적 형변환을 이용해서 처리할 수 있음
-- 숫자 : NUMBER
-- 문자열 : VARCHAR2
-- 날짜 : DATE, TIMESTAMP

-- TO_CHAR : 숫자, 날짜를 문자형으로 변경해주는 함수
-- 날짜형을 문자형으로 변경하기
-- 날짜를 기호로 표시해서 문자형으로 변경함 
-- Y:년, M:월, D:일, H:시, MI:분, SS:초
SELECT SYSDATE, TO_CHAR(SYSDATE,'YYYY-MM-DD'),
TO_CHAR(SYSDATE,'YY.MM.DD'), TO_CHAR(SYSDATE,'YY.MM.DD HH24:MI:SS')
FROM DUAL;

-- 숫자를 문자로 변환하기 
-- 패턴에 맞춰서 변환 -> 자리수에 대한 패턴을 설정
-- 0 : 변환하는 값이 해당자리에 없으면 0으로 표시, 자리에 값이 있으면 그 숫자로 표현
-- 9 : 변환하는 값이 해당자리에 없으면 표시 생략, 자리에 값이 있으면 그 숫자로 표현 
-- 통화를 표시하려면 L표시함
SELECT 12345678, TO_CHAR(12345678,'999,999,999'),
TO_CHAR(1234567,'000,000,000'),
TO_CHAR(12345678,'L999,999,999'),
TO_CHAR(180.5,'FM999.99'),
TO_CHAR(180.5,'FM999.00')
FROM DUAL;
SELECT EMP_NAME, SALARY, TO_CHAR(SALARY,'L999,999,999') AS CONVERT
FROM EMPLOYEE;



































