-- 문자형을 숫자형으로 변경하는 함수
SELECT '1,000,000', TO_NUMBER('1,000,000','999,999,999')+2000 AS A FROM DUAL;

-- 문자, 숫자를 날짜형으로 변경해주는 함수
-- TO_DATE() 날짜 패턴으로 날짜형으로 변환
SELECT TO_DATE('22/12/25', 'YY/MM/DD')-SYSDATE A, TO_DATE('221225', 'YYMMDD') B, TO_DATE(20230108, 'YYYYMMDD') FROM DUAL;


-- NVL
-- NULL 값을 처리해주는 함수
SELECT EMP_NAME, DEPT_CODE, NVL(DEPT_CODE, '인턴'), BONUS, NVL(BONUS,0) FROM EMPLOYEE WHERE NVL(DEPT_CODE,'인턴') = '인턴';

-- NVL2 : NULL 값일때 값, NULL값이 아닐때 값을 설정
SELECT EMP_NAME, DEPT_CODE, NVL2(DEPT_CODE, '정규직', '인턴') FROM EMPLOYEE;

-- 조건에따라 출력값을 변경해주는 함수
-- 1. DECODE
-- DECODE(컬럼명||문자열, '동등비교할값', '같았을때', '동등비교할값', '같았을때 출력할 값')
SELECT EMP_NAME, JOB_CODE, DECODE(JOB_CODE, 'J1', '대표', 'J2', '부사장', 'J3', '부장') FROM EMPLOYEE;

-- 성별을 남,녀 로 출력하는 컬럼 만들기
SELECT EMP_NAME, SALARY, DECODE(SUBSTR(EMP_NO,8,1), '1', '남', '2', '여') AS GENDER FROM EMPLOYEE WHERE DECODE(SUBSTR(EMP_NO,8,1), '1', '남', '2', '여') = '남';


SELECT EMP_NAME, JOB_CODE,
    CASE
        WHEN JOB_CODE = 'J1' THEN '대표'
        WHEN JOB_CODE = 'J2' THEN '부사장'
        WHEN JOB_CODE = 'J3' THEN '부장'
        WHEN JOB_CODE = 'J4' THEN '과장'
        ELSE '사원'
    END AS 직책,
    CASE
        WHEN SALARY > 3000000 THEN '고액월급'
        WHEN SALARY <= 3000000 THEN '기본월급'
    END AS 급여구분
FROM EMPLOYEE;


-- 사원테이블에서 현재나이구하기
-- EXTRACT 날짜에서 연도 뺴옴
-- 오라클에서 년도를 표시하는 패턴값은 2가지 Y(현재세기)
-- RR로 년도를 출력할때
-- 현재년도       입력년도      계산년도
-- 00~49         00~49        현세기
-- 00~49         50~99        전세기
-- 50~99         00~49        다음세기
-- 50~99         50~99        현세기

SELECT EMP_NO, EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO,1,2), 'YY')) AS YY, EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO,1,2), 'YY')) AS RR FROM EMPLOYEE;

-- 그룹함수 활용
-- 테이블의 데이터를 종합해서 하나의 ROW 로 결과를 출력하는 함수 -> 결과가 하나만 나옴
-- 컬럼값에 대한 합계, 평균, 갯수, 구할때 사용
-- 그룹함수를 이용하면 SELECT 문에서의 컬럼의 사용이제한 * 그룹함수에서 사용한 컬럼만 사용이가능.
-- 종류
-- SUM : 합계
-- AVG : 평균
-- COUNT : ROW 수 출력
-- MIN : 최소값
-- MAX: 최대값

SELECT SUM(SALARY) FROM EMPLOYEE;

SELECT SUM(SALARY) AS 합계, AVG(SALARY) AS 평균 FROM EMPLOYEE WHERE DEPT_CODE = 'D5';

-- SUB, AVG 이용시 NULL 값이 있는 경우? NULL 인 경우 연산에서 빼기 때문에 포함시키려면 NVL 처리해야함.
SELECT TRUNC(AVG(BONUS),3), TRUNC(AVG(NVL(BONUS,0)),3) FROM EMPLOYEE;

SELECT COUNT(*) FROM EMPLOYEE WHERE DEPT_CODE = 'D9';

SELECT COUNT(*) FROM EMPLOYEE WHERE SALARY > 4000000;

SELECT COUNT(*) FROM EMPLOYEE WHERE BONUS IS NOT NULL;

SELECT COUNT(*) AS 수, TRUNC(AVG(SALARY), -2) AS 평균, SUM(SALARY) AS 합계 FROM EMPLOYEE WHERE DEPT_CODE IN('D6','D5','D7');

SELECT COUNT(*), COUNT(DEPT_CODE), COUNT(BONUS) FROM EMPLOYEE;

-- GROUP BY 절 이용하기
-- GROUP BY 는 특정 컬럼의 값을 기준으로 묶어서 결과값을 출력하는 명령어
-- 부서별 급여의 합계, 평균
SELECT SUM(SALARY), AVG(SALARY), DEPT_CODE FROM EMPLOYEE GROUP BY DEPT_CODE;

-- 직책별
SELECT JOB_CODE, SUM(SALARY), AVG(SALARY) FROM EMPLOYEE GROUP BY JOB_CODE;

-- 부서별 인원 조회
SELECT DEPT_CODE, JOB_CODE, COUNT(DEPT_CODE) AS 수 FROM EMPLOYEE WHERE DEPT_CODE IS NOT NULL GROUP BY DEPT_CODE, JOB_CODE;

-- 그룹함수를 조건으로 사용할때는 HAVING 절을 이용
-- 부서 별 인원수가 3명이상힌 부서를 조회
SELECT DEPT_CODE, COUNT(*) FROM EMPLOYEE GROUP BY DEPT_CODE HAVING COUNT(*) >= 4;

-- 매니저가 관리하는 사원이 2명이상인 매니저 출력

SELECT MANAGER_ID AS "2명이상 관리하는 매니저 ID"  FROM EMPLOYEE WHERE MANAGER_ID IS NOT NULL GROUP BY MANAGER_ID HAVING COUNT(*) >= 2;

SELECT * FROM EMPLOYEE WHERE EMP_ID IN (SELECT MANAGER_ID FROM EMPLOYEE GROUP BY MANAGER_ID HAVING COUNT(*) >= 2);

-- ROLLUP, CUBE 이용하기
-- 그룹별 집계결과와 총 집계결과를 출력해주는 함수
-- 컬럼을 한개만 지정했을때 ROLLUP 과 CUBE가 동일
-- 컬럼을 여러개 지정했을때 ROLLUP -> 왼쪽에 있는 컬럼을 기준으로 집계, 총 집계
--                       CUBE -> 선언된 컬럼을 기준으로 집계 (두개다), 총 집계

-- ROLLUP 을 사용하여 집계한 데이터에 대한 토탈
SELECT NVL(DEPT_CODE,'TOTAL'), SUM(SALARY) FROM EMPLOYEE WHERE DEPT_CODE IS NOT NULL GROUP BY ROLLUP(DEPT_CODE);

-- CUBE 를 사용하여 1번째 ROW에 총합이나오고 나머지 부서별 합계
SELECT NVL(DEPT_CODE,'TOTAL'), SUM(SALARY) FROM EMPLOYEE WHERE DEPT_CODE IS NOT NULL GROUP BY CUBE(DEPT_CODE);

-- 두개 컬럼 이상을 GROUP 으로 연결했을 때 처리하는게 다르다
SELECT NVL(DEPT_CODE,'총계'), NVL(JOB_CODE, '부서별 계'), SUM(SALARY) FROM EMPLOYEE WHERE DEPT_CODE IS NOT NULL GROUP BY ROLLUP(DEPT_CODE, JOB_CODE);

-- CUBE를 사용해서 지정한 컬럼 2개의 대한 집계를 먼저함
SELECT NVL(DEPT_CODE,'총계'), NVL(JOB_CODE, '부서별 계'), SUM(SALARY) FROM EMPLOYEE WHERE DEPT_CODE IS NOT NULL GROUP BY CUBE(DEPT_CODE, JOB_CODE);

-- GRUOPING() : 집계된 컬럼을 확인해주는 함수
SELECT JOB_CODE, DEPT_CODE, COUNT(*),
    CASE
        WHEN GROUPING(JOB_CODE) = 1 AND GROUPING(DEPT_CODE) = 0 THEN '부서별 인원'
        WHEN GROUPING(JOB_CODE) = 0 AND GROUPING(DEPT_CODE) = 1 THEN '직책별 인원'
        WHEN GROUPING(JOB_CODE) = 0 AND GROUPING(DEPT_CODE) = 0 THEN '그룹별 인원'
        WHEN GROUPING(JOB_CODE) = 1 AND GROUPING(DEPT_CODE) = 1 THEN '총 인원'
    END AS 비고
FROM EMPLOYEE WHERE DEPT_CODE IS NOT NULL GROUP BY CUBE(JOB_CODE, DEPT_CODE);

-- 조회한 데이터 정렬하기
SELECT SALARY FROM EMPLOYEE ORDER BY SALARY DESC;

SELECT EMP_NAME FROM EMPLOYEE ORDER BY EMP_NAME DESC;

-- NULLS LAST 로 NULL 값 핸들링 가능
SELECT BONUS FROM EMPLOYEE ORDER BY BONUS DESC NULLS LAST;

--ORDER BY 컬럼은 컬럼의 INDEX 번호로 대체 가능
SELECT * FROM EMPLOYEE ORDER BY 2 DESC;

-- 집합 연산자
-- 여러개의 SELECT 문을 한개의 결과로 출력해주는 것
-- 첫번째 SELECT 문의 컬럼수와 그 이후 SELECT문의 컬럼수가 같아야 함
-- 각 컬럼의 TYPE 도 같아야 함
-- UNION 
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >= 3000000;

-- UNION ALL 중첩되는 값에 대해 모두표시
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION ALL
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >= 3000000;

-- SELECT 문의 선택한 컬럼의 수가 다를 때는 실행안되니 DEFAULT 값 0으로줌 
SELECT EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION
SELECT EMP_ID, EMP_NAME, 0
FROM EMPLOYEE
WHERE SALARY >= 3000000;

--SELECT 문의 컬럼 수 는 같은데 TYPE이 다른경우는 꼭 타입을 맞춰줘야야함
SELECT EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION
SELECT EMP_ID, EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE SALARY >= 3000000;

-- 집합연산은 다른테이블과연결 (컬럼개수랑 TYPE만 맞추면 가능하긴함)
SELECT EMP_ID, EMP_NAME
FROM EMPLOYEE
WHERE JOB_CODE = 'J5'
UNION
SELECT DEPT_ID, DEPT_TITLE
FROM DEPARTMENT;

-- MINUS, INTERSECT (밑결과랑 겹치는애 뺌)
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
MINUS
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >= 3000000;

-- 밑결과랑 겹치는데이터만
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
INTERSECT
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >= 3000000;


-- JOIN
-- 두개 이상의 테이블을 특정 기준값으로 연결해주는 기능 (ROW를 연결)
-- JOIN 종류
-- INNER JOIN : 특정 기준값이 일치하는 ROW만 출력 -> 누락되는 데이터가 있음
-- OUTER JOIN : 기준테이블을 설정해서 기준 테이블의 모든 ROW를 출력하게하는 JOIN -> 누락되는 데이터가 없음

-- INNER JOIN 조건이 같은 결과만 출력, 같지 않은 건 출력하지 않음 물리적으로 테이블을 합친건 아님
SELECT EMP_NAME, DEPT_TITLE, SALARY, BONUS
FROM EMPLOYEE JOIN DEPARTMENT ON DEPT_CODE = DEPT_ID;

-- 부서가 총무부인 사원을 조회하기
SELECT * FROM EMPLOYEE JOIN DEPARTMENT ON DEPT_CODE = DEPT_ID
WHERE DEPT_TITLE = '총무부';

-- 사원의 이름, 직책명, 월급 보너스를 조회하기
SELECT EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE JOIN JOB ON JOB_CODE = JOB_CODE;

-- USING 을 사용하면 테이블의 별칭을 부여할 수 없음
-- 테이블 별칭을 사용하면 비교한 컬럼이 같은 컬럼이 2개 생김 USING으로 하면 컬럼이 하나만있음.
SELECT EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE JOIN JOB USING(JOB_CODE);

-- JOIN 한 테이블ㄹ에 WHERE, GROUP BY, HAVING, ORDER BY 모두 사용이 가능
-- 부서별 인원과 급여 평균을 구하기 , 부서명, 인원수, 평균
-------
SELECT DEPT_TITLE AS 부서명, COUNT(*) AS 인원수, AVG(SALARY) AS 평균
FROM EMPLOYEE JOIN DEPARTMENT ON DEPT_CODE = DEPT_ID
GROUP BY DEPT_TITLE;

SELECT DEPT_TITLE, SALARY 
FROM DEPARTMENT JOIN EMPLOYEE ON DEPT_ID = DEPT_CODE;

-- 직책이 과장인 사원의 이름, 직책명, 직책코드, 월급 조회
SELECT JOB_NAME, JOB_CODE, SALARY, EMP_NAME
FROM EMPLOYEE JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '과장';

-- WHY (SELECT 문 에서도 명확히 값을 적어줘야함)
SELECT JOB_NAME, E.JOB_CODE, SALARY, EMP_NAME
FROM EMPLOYEE E JOIN JOB J ON E.JOB_CODE = J.JOB_CODE
WHERE JOB_NAME = '과장';

SELECT * FROM EMPLOYEE;
SELECT * FROM JOB;

-- OUTER 조인 활용하기
-- 연결테이블에 기준을 설정해서 기준이 된 테이블의 모든 데이터를 출력되게 하는 것
-- LEFT || RIGHT
SELECT *
FROM EMPLOYEE LEFT OUTER JOIN DEPARTMENT ON DEPT_CODE = DEPT_ID;

SELECT *
FROM EMPLOYEE LEFT OUTER JOIN DEPARTMENT ON DEPT_CODE = DEPT_ID
WHERE DEPT_TITLE IS NOT NULL;

-- CROSS JOIN
-- 연결조건을 설정하지 않아서 모든 ROW가 전부 연결이 되는 테이블 생성
SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE CROSS JOIN DEPARTMENT
ORDER BY 1, 2;

-- SELF JOIN
-- 물리적테이블 한개를 가지고 두개의 테이블처럼 연결하는 JOIN
-- 한 테이블 동일한 데이터를 가지는 컬럼이 있어야한다.

SELECT * FROM EMPLOYEE;

-- NAMAGER 가 있는 사원의 이름, 사원번호, 매니저 이름, 매니저 사원번호 를 조회
-- MANAGER 가 없는 사원은 매니저 이름에 '없다' 로 출력
SELECT E.EMP_NAME, E.EMP_ID, E.MANAGER_ID, NVL(M.EMP_NAME, '없다'), M.EMP_ID
FROM EMPLOYEE E LEFT JOIN EMPLOYEE M ON E.MANAGER_ID = M.EMP_ID;

-- 다중조인
-- 두개이상의 테이블 조인해서 조회하기
-- 사원이 이름, 부서명, 직책명, 급여, 보너스를 조회하기
SELECT EMP_NAME, DEPT_TITLE, JOB_NAME, SALARY, BONUS
FROM EMPLOYEE
    JOIN DEPARTMENT ON DEPT_CODE = DEPT_ID
    JOIN JOB USING(JOB_CODE);
    
--  사원의 사원명, 부서명, 직책명, 근무지역명 조회하기

SELECT EMP_NAME, DEPT_TITLE, JOB_NAME, LOCAL_NAME
FROM EMPLOYEE
    JOIN JOB USING(JOB_CODE)
    LEFT JOIN DEPARTMENT ON DEPT_CODE = DEPT_ID
    LEFT JOIN LOCATION ON LOCATION_ID = LOCAL_CODE;
    
-- 비동등조인 활용하기
-- 범위에 따라서 ROW를 연결하는 JOIN방식
-- 범위를 나타내는 컬럼을 가지는 테이블이 있어야한다.
SELECT *
FROM SAL_GRADE;

-- 포인트별 회원등급설정, 점수에 따른 제품상태 설정
SELECT *
FROM EMPLOYEE
    JOIN SAL_GRADE ON SALARY BETWEEN MIN_SAL AND MAX_SAL;
    
-- 서브쿼리
-- 전지연 사원의 매니저의 정보를 출력하기
SELECT MANAGER_ID
FROM EMPLOYEE
WHERE EMP_NAME = '전지연';

SELECT *
FROM EMPLOYEE
WHERE EMP_ID = '214';

------- 이 두개의 쿼리를 밑처럼 합친다
SELECT *
FROM EMPLOYEE
WHERE EMP_ID = (SELECT MANAGER_ID FROM EMPLOYEE WHERE EMP_NAME='전지연');

-- D5 부서의 평균급여보다 많이 받는 사원 조회하기
SELECT *
FROM EMPLOYEE
WHERE SALARY >= (SELECT AVG(SALARY) FROM EMPLOYEE WHERE DEPT_CODE = 'D5');

-- 1. 단일행 서브쿼리
-- SELECT 문의 결과가 1개 컬럼, 1개 ROW 갖는 것
-- WHERE 절, SELECT 컬럼에 많이 사용
-- 사원들의 급여 평균보다 많은 급여를 받는 사원의 이름, 급여 , 부서코드 조회
SELECT EMP_NAME, SALARY, DEPT_CODE
FROM EMPLOYEE
WHERE SALARY >= (SELECT AVG(SALARY) FROM EMPLOYEE);

-- 부서가 총무부인 사원을 조회하기 (왠만하면 서브쿼리보다 조인문으로 해결 하는게 좋긴 함 이유는 속도적인 측면)
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_ID FROM DEPARTMENT WHERE DEPT_TITLE='총무부');

SELECT *
FROM EMPLOYEE JOIN DEPARTMENT ON DEPT_ID = DEPT_CODE
WHERE DEPT_TITLE = '총무부';

-- 다중행 서브쿼리
-- RESULT SET SELECT 문의 결과가 다수 ROW로 출력되는것
-- 직책이 부장, 과장인 사원을 조회하기
SELECT *
FROM EMPLOYEE
WHERE JOB_CODE IN(SELECT JOB_CODE FROM JOB WHERE JOB_NAME IN('과장','부장'));

-- 송중기, 박나라와 같이 근무하는 사원 조회하기
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE IN(SELECT DEPT_CODE FROM EMPLOYEE WHERE EMP_NAME IN('송종기','박나라'));

-- 부서별 최고급여 받는 사원 구하기
SELECT *
FROM EMPLOYEE
WHERE SALARY IN(SELECT MAX(SALARY) FROM EMPLOYEE GROUP BY DEPT_CODE);

-- 대소 비교하기
-- ANY : 다수 값 중 하나만 참이어도 참, ALL 함수 이용
SELECT *
FROM EMPLOYEE
WHERE SALARY < ANY(SELECT MIN(SALARY) FROM EMPLOYEE GROUP BY DEPT_CODE);

-- ALL : 다수 값 비교 다중값의 최대값보다 크면 참... 작으면 참
SELECT MIN(SALARY) FROM EMPLOYEE GROUP BY DEPT_CODE;

SELECT *
FROM EMPLOYEE
WHERE SALARY > ALL(SELECT MIN(SALARY) FROM EMPLOYEE GROUP BY DEPT_CODE);

-- 2000년 1월 1일 이전에 입사자 중 200년 1월 1일 이후 입사한 사원 중 급여를 가장 높게 받는 사원보다 급여가 많은 사원 조회하기
SELECT *
FROM EMPLOYEE
WHERE HIRE_DATE < '00/01/01'
AND SALARY > ALL(SELECT SALARY FROM EMPLOYEE WHERE HIRE_DATE > '00/01/01');

-- 다중열 서브쿼리 : ROW 1개 COLUMN 여러개
-- 퇴직한 여사원의 같은 부서 같은 직급에 해당하는 사원 조회하기
SELECT DEPT_CODE FROM EMPLOYEE WHERE ENT_YN = 'Y';

SELECT *
FROM EMPLOYEE
WHERE (DEPT_CODE, JOB_CODE) IN (SELECT DEPT_CODE, JOB_CODE FROM EMPLOYEE WHERE ENT_YN ='Y');

-- 기술 지원부 이면서 급여가 200만원인 사원이 있다고 한다. 그 사원의 정보를 조회하기
SELECT *
FROM EMPLOYEE
WHERE (DEPT_CODE, SALARY) IN (SELECT DEPT_CODE, SALARY FROM EMPLOYEE JOIN DEPARTMENT ON DEPT_CODE = DEPT_ID WHERE DEPT_TITLE = '기술지원부' AND SALARY = 2000000);

-- 다중행 다중열
-- 총무부 이면서 300만원 이상 급여를 받는 사원
SELECT DEPT_CODE, SALARY
FROM EMPLOYEE JOIN DEPARTMENT ON DEPT_CODE = DEPT_ID
WHERE DEPT_TITLE = '총무부' AND SALARY >= 3000000;

SELECT *
FROM EMPLOYEE
WHERE (DEPT_CODE, SALARY) IN (SELECT DEPT_CODE, SALARY
                            FROM EMPLOYEE JOIN DEPARTMENT ON DEPT_CODE = DEPT_ID
                            WHERE DEPT_TITLE = '총무부' AND SALARY >= 3000000
                          );

-- 상관서브쿼리
-- 서브쿼리를 구성할 때 메인쿼리에 값을 가져와 사용하게 구성하여 서브쿼리 결과가 메인쿼리값에 영향을 받고 서브쿼리의 결과가 메인쿼리 결과에영향을 미치게되는 쿼리

-- 각 사원이 속한 부서의 인원수 조회하기
-- 중첩 반복문과 비슷한 개념
SELECT EMP_NAME, DEPT_CODE, (SELECT COUNT(*) FROM EMPLOYEE WHERE DEPT_CODE = E.DEPT_CODE) AS 인원수
FROM EMPLOYEE E;

SELECT COUNT(*) FROM EMPLOYEE WHERE DEPT_CODE = 'D9';
SELECT COUNT(*) FROM EMPLOYEE WHERE DEPT_CODE = 'D6';

-- 자신이 속한 부서의 평균급여보다 급여를 많이 받는 사원을 조회하기
SELECT *
FROM EMPLOYEE E
WHERE SALARY > (SELECT AVG(SALARY) FROM EMPLOYEE WHERE DEPT_CODE = E.DEPT_CODE);

-- FROM 절에서 서브쿼리 사용하기
-- INLINE VIEW -> 다중행 다중열 서브쿼리를 사용
-- 가상컬럼이 추가된 SELECT 문이나 집합연산을 사용한 SELECT 문을 LINE VIEW 로 많이 사용
-- STORED VIEW -> 오라클에서 관리하는 하나의 OBJECT
-- INLINE VIEW -> 는 1회용
-- STORE VIEW 는 특정명칭으로 INLINE VIEW 를 저장해서 사용 -> VIEWTABLE 이라고 함
SELECT *
FROM (SELECT E.*, DECODE(SUBSTR(EMP_NO,8,1),'1','남','2','여') AS GENDER FROM EMPLOYEE E)
WHERE GENDER = '남';

-- JOIN문
SELECT *
FROM (SELECT E.*, D.*, JOB_NAME,
(SELECT TRUNC(AVG(SALARY), -1) FROM EMPLOYEE WHERE DEPT_CODE = E.DEPT_CODE) AS DEPT_SAL,
(SELECT COUNT(*) FROM EMPLOYEE WHERE JOB_CODE = E.JOB_CODE) AS JOB_COUNT
FROM EMPLOYEE E LEFT JOIN DEPARTMENT D ON DEPT_CODE = DEPT_ID
                JOIN JOB J ON E.JOB_CODE = J.JOB_CODE)
                WHERE DEPT_SAL > 3000000 AND JOB_COUNT = 4;

-- INLINE VIEW 를 생성 했을 때 INLINE VIEW 에서 선언한 컬럼만 이용 가능
SELECT *
FROM (SELECT EMP_NAME, SALARY, DEPT_CODE FROM EMPLOYEE)
WHERE DEPT_CODE = 'D5';

SELECT *
FROM (
    SELECT EMP_ID AS CODE, EMP_NAME AS TITLE
    FROM EMPLOYEE
    UNION
    SELECT DEPT_ID, DEPT_TITLE
    FROM DEPARTMENT
    UNION
    SELECT JOB_CODE, JOB_NAME
    FROM JOB
    );

--  데이터를 기준으로 순위 출력하는 구문 작성하기
--  2가지 방법
--  1. 오라클에서 제공하는 ROWNUM 컬럼을 이용해서 출력
--  -> SELECT 문이 실행되면 자동으로 오라클이 부여하는 가상컬럼. SELECT 문이 실행될때 ROW에 번호를 부여한 컬럼
SELECT ROWNUM, E.*
FROM EMPLOYEE E
WHERE ROWNUM BETWEEN 1 AND 3;

-- 급여를 많이 받는 사원 1등 부터 3등까지 조회
SELECT ROWNUM, E.*
FROM EMPLOYEE E
WHERE ROWNUM BETWEEN 1 AND 3
ORDER BY SALARY;

--ROWNUM 을 사용해서 정상적인 순위를 출력하려면 INLINE VIEW 를 이용해야한다.
--중간순위에 대한 데이터를 출력할 수 없음
-- 1번부터 시작이 되어야 ROWNUM이 만들어짐
-- 그래서 한번 더 감싸줘서 1번부터 한번 만들어 지고 나서 실행해야 가능함
-- PAGENATION 처리에 아주 유용하고 중요한 정보임.
SELECT *
FROM(
    SELECT ROWNUM AS RNUM, E.*
    FROM (SELECT * FROM EMPLOYEE ORDER BY SALARY DESC) E
)
WHERE RNUM BETWEEN 5 AND 10;

--  2. 오라클에서 제공하는 WINDOW 함수르 이용해서 출력하는 방법

SELECT * FROM EMPLOYEE;
SELECT * FROM JOB;
SELECT * FROM DEPARTMENT;
SELECT * FROM LOCATION;



