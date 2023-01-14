-- �������� ���������� �����ϴ� �Լ�
SELECT '1,000,000', TO_NUMBER('1,000,000','999,999,999')+2000 AS A FROM DUAL;

-- ����, ���ڸ� ��¥������ �������ִ� �Լ�
-- TO_DATE() ��¥ �������� ��¥������ ��ȯ
SELECT TO_DATE('22/12/25', 'YY/MM/DD')-SYSDATE A, TO_DATE('221225', 'YYMMDD') B, TO_DATE(20230108, 'YYYYMMDD') FROM DUAL;


-- NVL
-- NULL ���� ó�����ִ� �Լ�
SELECT EMP_NAME, DEPT_CODE, NVL(DEPT_CODE, '����'), BONUS, NVL(BONUS,0) FROM EMPLOYEE WHERE NVL(DEPT_CODE,'����') = '����';

-- NVL2 : NULL ���϶� ��, NULL���� �ƴҶ� ���� ����
SELECT EMP_NAME, DEPT_CODE, NVL2(DEPT_CODE, '������', '����') FROM EMPLOYEE;

-- ���ǿ����� ��°��� �������ִ� �Լ�
-- 1. DECODE
-- DECODE(�÷���||���ڿ�, '������Ұ�', '��������', '������Ұ�', '�������� ����� ��')
SELECT EMP_NAME, JOB_CODE, DECODE(JOB_CODE, 'J1', '��ǥ', 'J2', '�λ���', 'J3', '����') FROM EMPLOYEE;

-- ������ ��,�� �� ����ϴ� �÷� �����
SELECT EMP_NAME, SALARY, DECODE(SUBSTR(EMP_NO,8,1), '1', '��', '2', '��') AS GENDER FROM EMPLOYEE WHERE DECODE(SUBSTR(EMP_NO,8,1), '1', '��', '2', '��') = '��';


SELECT EMP_NAME, JOB_CODE,
    CASE
        WHEN JOB_CODE = 'J1' THEN '��ǥ'
        WHEN JOB_CODE = 'J2' THEN '�λ���'
        WHEN JOB_CODE = 'J3' THEN '����'
        WHEN JOB_CODE = 'J4' THEN '����'
        ELSE '���'
    END AS ��å,
    CASE
        WHEN SALARY > 3000000 THEN '��׿���'
        WHEN SALARY <= 3000000 THEN '�⺻����'
    END AS �޿�����
FROM EMPLOYEE;


-- ������̺��� ���糪�̱��ϱ�
-- EXTRACT ��¥���� ���� ����
-- ����Ŭ���� �⵵�� ǥ���ϴ� ���ϰ��� 2���� Y(���缼��)
-- RR�� �⵵�� ����Ҷ�
-- ����⵵       �Է³⵵      ���⵵
-- 00~49         00~49        ������
-- 00~49         50~99        ������
-- 50~99         00~49        ��������
-- 50~99         50~99        ������

SELECT EMP_NO, EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO,1,2), 'YY')) AS YY, EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO,1,2), 'YY')) AS RR FROM EMPLOYEE;

-- �׷��Լ� Ȱ��
-- ���̺��� �����͸� �����ؼ� �ϳ��� ROW �� ����� ����ϴ� �Լ� -> ����� �ϳ��� ����
-- �÷����� ���� �հ�, ���, ����, ���Ҷ� ���
-- �׷��Լ��� �̿��ϸ� SELECT �������� �÷��� ��������� * �׷��Լ����� ����� �÷��� ����̰���.
-- ����
-- SUM : �հ�
-- AVG : ���
-- COUNT : ROW �� ���
-- MIN : �ּҰ�
-- MAX: �ִ밪

SELECT SUM(SALARY) FROM EMPLOYEE;

SELECT SUM(SALARY) AS �հ�, AVG(SALARY) AS ��� FROM EMPLOYEE WHERE DEPT_CODE = 'D5';

-- SUB, AVG �̿�� NULL ���� �ִ� ���? NULL �� ��� ���꿡�� ���� ������ ���Խ�Ű���� NVL ó���ؾ���.
SELECT TRUNC(AVG(BONUS),3), TRUNC(AVG(NVL(BONUS,0)),3) FROM EMPLOYEE;

SELECT COUNT(*) FROM EMPLOYEE WHERE DEPT_CODE = 'D9';

SELECT COUNT(*) FROM EMPLOYEE WHERE SALARY > 4000000;

SELECT COUNT(*) FROM EMPLOYEE WHERE BONUS IS NOT NULL;

SELECT COUNT(*) AS ��, TRUNC(AVG(SALARY), -2) AS ���, SUM(SALARY) AS �հ� FROM EMPLOYEE WHERE DEPT_CODE IN('D6','D5','D7');

SELECT COUNT(*), COUNT(DEPT_CODE), COUNT(BONUS) FROM EMPLOYEE;

-- GROUP BY �� �̿��ϱ�
-- GROUP BY �� Ư�� �÷��� ���� �������� ��� ������� ����ϴ� ��ɾ�
-- �μ��� �޿��� �հ�, ���
SELECT SUM(SALARY), AVG(SALARY), DEPT_CODE FROM EMPLOYEE GROUP BY DEPT_CODE;

-- ��å��
SELECT JOB_CODE, SUM(SALARY), AVG(SALARY) FROM EMPLOYEE GROUP BY JOB_CODE;

-- �μ��� �ο� ��ȸ
SELECT DEPT_CODE, JOB_CODE, COUNT(DEPT_CODE) AS �� FROM EMPLOYEE WHERE DEPT_CODE IS NOT NULL GROUP BY DEPT_CODE, JOB_CODE;

-- �׷��Լ��� �������� ����Ҷ��� HAVING ���� �̿�
-- �μ� �� �ο����� 3���̻��� �μ��� ��ȸ
SELECT DEPT_CODE, COUNT(*) FROM EMPLOYEE GROUP BY DEPT_CODE HAVING COUNT(*) >= 4;

-- �Ŵ����� �����ϴ� ����� 2���̻��� �Ŵ��� ���

SELECT MANAGER_ID AS "2���̻� �����ϴ� �Ŵ��� ID"  FROM EMPLOYEE WHERE MANAGER_ID IS NOT NULL GROUP BY MANAGER_ID HAVING COUNT(*) >= 2;

SELECT * FROM EMPLOYEE WHERE EMP_ID IN (SELECT MANAGER_ID FROM EMPLOYEE GROUP BY MANAGER_ID HAVING COUNT(*) >= 2);

-- ROLLUP, CUBE �̿��ϱ�
-- �׷캰 �������� �� �������� ������ִ� �Լ�
-- �÷��� �Ѱ��� ���������� ROLLUP �� CUBE�� ����
-- �÷��� ������ ���������� ROLLUP -> ���ʿ� �ִ� �÷��� �������� ����, �� ����
--                       CUBE -> ����� �÷��� �������� ���� (�ΰ���), �� ����

-- ROLLUP �� ����Ͽ� ������ �����Ϳ� ���� ��Ż
SELECT NVL(DEPT_CODE,'TOTAL'), SUM(SALARY) FROM EMPLOYEE WHERE DEPT_CODE IS NOT NULL GROUP BY ROLLUP(DEPT_CODE);

-- CUBE �� ����Ͽ� 1��° ROW�� �����̳����� ������ �μ��� �հ�
SELECT NVL(DEPT_CODE,'TOTAL'), SUM(SALARY) FROM EMPLOYEE WHERE DEPT_CODE IS NOT NULL GROUP BY CUBE(DEPT_CODE);

-- �ΰ� �÷� �̻��� GROUP ���� �������� �� ó���ϴ°� �ٸ���
SELECT NVL(DEPT_CODE,'�Ѱ�'), NVL(JOB_CODE, '�μ��� ��'), SUM(SALARY) FROM EMPLOYEE WHERE DEPT_CODE IS NOT NULL GROUP BY ROLLUP(DEPT_CODE, JOB_CODE);

-- CUBE�� ����ؼ� ������ �÷� 2���� ���� ���踦 ������
SELECT NVL(DEPT_CODE,'�Ѱ�'), NVL(JOB_CODE, '�μ��� ��'), SUM(SALARY) FROM EMPLOYEE WHERE DEPT_CODE IS NOT NULL GROUP BY CUBE(DEPT_CODE, JOB_CODE);

-- GRUOPING() : ����� �÷��� Ȯ�����ִ� �Լ�
SELECT JOB_CODE, DEPT_CODE, COUNT(*),
    CASE
        WHEN GROUPING(JOB_CODE) = 1 AND GROUPING(DEPT_CODE) = 0 THEN '�μ��� �ο�'
        WHEN GROUPING(JOB_CODE) = 0 AND GROUPING(DEPT_CODE) = 1 THEN '��å�� �ο�'
        WHEN GROUPING(JOB_CODE) = 0 AND GROUPING(DEPT_CODE) = 0 THEN '�׷캰 �ο�'
        WHEN GROUPING(JOB_CODE) = 1 AND GROUPING(DEPT_CODE) = 1 THEN '�� �ο�'
    END AS ���
FROM EMPLOYEE WHERE DEPT_CODE IS NOT NULL GROUP BY CUBE(JOB_CODE, DEPT_CODE);

-- ��ȸ�� ������ �����ϱ�
SELECT SALARY FROM EMPLOYEE ORDER BY SALARY DESC;

SELECT EMP_NAME FROM EMPLOYEE ORDER BY EMP_NAME DESC;

-- NULLS LAST �� NULL �� �ڵ鸵 ����
SELECT BONUS FROM EMPLOYEE ORDER BY BONUS DESC NULLS LAST;

--ORDER BY �÷��� �÷��� INDEX ��ȣ�� ��ü ����
SELECT * FROM EMPLOYEE ORDER BY 2 DESC;

-- ���� ������
-- �������� SELECT ���� �Ѱ��� ����� ������ִ� ��
-- ù��° SELECT ���� �÷����� �� ���� SELECT���� �÷����� ���ƾ� ��
-- �� �÷��� TYPE �� ���ƾ� ��
-- UNION 
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >= 3000000;

-- UNION ALL ��ø�Ǵ� ���� ���� ���ǥ��
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION ALL
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >= 3000000;

-- SELECT ���� ������ �÷��� ���� �ٸ� ���� ����ȵǴ� DEFAULT �� 0������ 
SELECT EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION
SELECT EMP_ID, EMP_NAME, 0
FROM EMPLOYEE
WHERE SALARY >= 3000000;

--SELECT ���� �÷� �� �� ������ TYPE�� �ٸ����� �� Ÿ���� ������߾���
SELECT EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION
SELECT EMP_ID, EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE SALARY >= 3000000;

-- ���տ����� �ٸ����̺������ (�÷������� TYPE�� ���߸� �����ϱ���)
SELECT EMP_ID, EMP_NAME
FROM EMPLOYEE
WHERE JOB_CODE = 'J5'
UNION
SELECT DEPT_ID, DEPT_TITLE
FROM DEPARTMENT;

-- MINUS, INTERSECT (�ذ���� ��ġ�¾� ��)
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
MINUS
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >= 3000000;

-- �ذ���� ��ġ�µ����͸�
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
INTERSECT
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >= 3000000;


-- JOIN
-- �ΰ� �̻��� ���̺��� Ư�� ���ذ����� �������ִ� ��� (ROW�� ����)
-- JOIN ����
-- INNER JOIN : Ư�� ���ذ��� ��ġ�ϴ� ROW�� ��� -> �����Ǵ� �����Ͱ� ����
-- OUTER JOIN : �������̺��� �����ؼ� ���� ���̺��� ��� ROW�� ����ϰ��ϴ� JOIN -> �����Ǵ� �����Ͱ� ����

-- INNER JOIN ������ ���� ����� ���, ���� ���� �� ������� ���� ���������� ���̺��� ��ģ�� �ƴ�
SELECT EMP_NAME, DEPT_TITLE, SALARY, BONUS
FROM EMPLOYEE JOIN DEPARTMENT ON DEPT_CODE = DEPT_ID;

-- �μ��� �ѹ����� ����� ��ȸ�ϱ�
SELECT * FROM EMPLOYEE JOIN DEPARTMENT ON DEPT_CODE = DEPT_ID
WHERE DEPT_TITLE = '�ѹ���';

-- ����� �̸�, ��å��, ���� ���ʽ��� ��ȸ�ϱ�
SELECT EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE JOIN JOB ON JOB_CODE = JOB_CODE;

-- USING �� ����ϸ� ���̺��� ��Ī�� �ο��� �� ����
-- ���̺� ��Ī�� ����ϸ� ���� �÷��� ���� �÷��� 2�� ���� USING���� �ϸ� �÷��� �ϳ�������.
SELECT EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE JOIN JOB USING(JOB_CODE);

-- JOIN �� ���̺��� WHERE, GROUP BY, HAVING, ORDER BY ��� ����� ����
-- �μ��� �ο��� �޿� ����� ���ϱ� , �μ���, �ο���, ���
-------
SELECT DEPT_TITLE AS �μ���, COUNT(*) AS �ο���, AVG(SALARY) AS ���
FROM EMPLOYEE JOIN DEPARTMENT ON DEPT_CODE = DEPT_ID
GROUP BY DEPT_TITLE;

SELECT DEPT_TITLE, SALARY 
FROM DEPARTMENT JOIN EMPLOYEE ON DEPT_ID = DEPT_CODE;

-- ��å�� ������ ����� �̸�, ��å��, ��å�ڵ�, ���� ��ȸ
SELECT JOB_NAME, JOB_CODE, SALARY, EMP_NAME
FROM EMPLOYEE JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '����';

-- WHY (SELECT �� ������ ��Ȯ�� ���� ���������)
SELECT JOB_NAME, E.JOB_CODE, SALARY, EMP_NAME
FROM EMPLOYEE E JOIN JOB J ON E.JOB_CODE = J.JOB_CODE
WHERE JOB_NAME = '����';

SELECT * FROM EMPLOYEE;
SELECT * FROM JOB;

-- OUTER ���� Ȱ���ϱ�
-- �������̺� ������ �����ؼ� ������ �� ���̺��� ��� �����͸� ��µǰ� �ϴ� ��
-- LEFT || RIGHT
SELECT *
FROM EMPLOYEE LEFT OUTER JOIN DEPARTMENT ON DEPT_CODE = DEPT_ID;

SELECT *
FROM EMPLOYEE LEFT OUTER JOIN DEPARTMENT ON DEPT_CODE = DEPT_ID
WHERE DEPT_TITLE IS NOT NULL;

-- CROSS JOIN
-- ���������� �������� �ʾƼ� ��� ROW�� ���� ������ �Ǵ� ���̺� ����
SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE CROSS JOIN DEPARTMENT
ORDER BY 1, 2;

-- SELF JOIN
-- ���������̺� �Ѱ��� ������ �ΰ��� ���̺�ó�� �����ϴ� JOIN
-- �� ���̺� ������ �����͸� ������ �÷��� �־���Ѵ�.

SELECT * FROM EMPLOYEE;

-- NAMAGER �� �ִ� ����� �̸�, �����ȣ, �Ŵ��� �̸�, �Ŵ��� �����ȣ �� ��ȸ
-- MANAGER �� ���� ����� �Ŵ��� �̸��� '����' �� ���
SELECT E.EMP_NAME, E.EMP_ID, E.MANAGER_ID, NVL(M.EMP_NAME, '����'), M.EMP_ID
FROM EMPLOYEE E LEFT JOIN EMPLOYEE M ON E.MANAGER_ID = M.EMP_ID;

-- ��������
-- �ΰ��̻��� ���̺� �����ؼ� ��ȸ�ϱ�
-- ����� �̸�, �μ���, ��å��, �޿�, ���ʽ��� ��ȸ�ϱ�
SELECT EMP_NAME, DEPT_TITLE, JOB_NAME, SALARY, BONUS
FROM EMPLOYEE
    JOIN DEPARTMENT ON DEPT_CODE = DEPT_ID
    JOIN JOB USING(JOB_CODE);
    
--  ����� �����, �μ���, ��å��, �ٹ������� ��ȸ�ϱ�

SELECT EMP_NAME, DEPT_TITLE, JOB_NAME, LOCAL_NAME
FROM EMPLOYEE
    JOIN JOB USING(JOB_CODE)
    LEFT JOIN DEPARTMENT ON DEPT_CODE = DEPT_ID
    LEFT JOIN LOCATION ON LOCATION_ID = LOCAL_CODE;
    
-- �񵿵����� Ȱ���ϱ�
-- ������ ���� ROW�� �����ϴ� JOIN���
-- ������ ��Ÿ���� �÷��� ������ ���̺��� �־���Ѵ�.
SELECT *
FROM SAL_GRADE;

-- ����Ʈ�� ȸ����޼���, ������ ���� ��ǰ���� ����
SELECT *
FROM EMPLOYEE
    JOIN SAL_GRADE ON SALARY BETWEEN MIN_SAL AND MAX_SAL;
    
-- ��������
-- ������ ����� �Ŵ����� ������ ����ϱ�
SELECT MANAGER_ID
FROM EMPLOYEE
WHERE EMP_NAME = '������';

SELECT *
FROM EMPLOYEE
WHERE EMP_ID = '214';

------- �� �ΰ��� ������ ��ó�� ��ģ��
SELECT *
FROM EMPLOYEE
WHERE EMP_ID = (SELECT MANAGER_ID FROM EMPLOYEE WHERE EMP_NAME='������');

-- D5 �μ��� ��ձ޿����� ���� �޴� ��� ��ȸ�ϱ�
SELECT *
FROM EMPLOYEE
WHERE SALARY >= (SELECT AVG(SALARY) FROM EMPLOYEE WHERE DEPT_CODE = 'D5');

-- 1. ������ ��������
-- SELECT ���� ����� 1�� �÷�, 1�� ROW ���� ��
-- WHERE ��, SELECT �÷��� ���� ���
-- ������� �޿� ��պ��� ���� �޿��� �޴� ����� �̸�, �޿� , �μ��ڵ� ��ȸ
SELECT EMP_NAME, SALARY, DEPT_CODE
FROM EMPLOYEE
WHERE SALARY >= (SELECT AVG(SALARY) FROM EMPLOYEE);

-- �μ��� �ѹ����� ����� ��ȸ�ϱ� (�ظ��ϸ� ������������ ���ι����� �ذ� �ϴ°� ���� �� ������ �ӵ����� ����)
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_ID FROM DEPARTMENT WHERE DEPT_TITLE='�ѹ���');

SELECT *
FROM EMPLOYEE JOIN DEPARTMENT ON DEPT_ID = DEPT_CODE
WHERE DEPT_TITLE = '�ѹ���';

-- ������ ��������
-- RESULT SET SELECT ���� ����� �ټ� ROW�� ��µǴ°�
-- ��å�� ����, ������ ����� ��ȸ�ϱ�
SELECT *
FROM EMPLOYEE
WHERE JOB_CODE IN(SELECT JOB_CODE FROM JOB WHERE JOB_NAME IN('����','����'));

-- ���߱�, �ڳ���� ���� �ٹ��ϴ� ��� ��ȸ�ϱ�
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE IN(SELECT DEPT_CODE FROM EMPLOYEE WHERE EMP_NAME IN('������','�ڳ���'));

-- �μ��� �ְ�޿� �޴� ��� ���ϱ�
SELECT *
FROM EMPLOYEE
WHERE SALARY IN(SELECT MAX(SALARY) FROM EMPLOYEE GROUP BY DEPT_CODE);

-- ��� ���ϱ�
-- ANY : �ټ� �� �� �ϳ��� ���̾ ��, ALL �Լ� �̿�
SELECT *
FROM EMPLOYEE
WHERE SALARY < ANY(SELECT MIN(SALARY) FROM EMPLOYEE GROUP BY DEPT_CODE);

-- ALL : �ټ� �� �� ���߰��� �ִ밪���� ũ�� ��... ������ ��
SELECT MIN(SALARY) FROM EMPLOYEE GROUP BY DEPT_CODE;

SELECT *
FROM EMPLOYEE
WHERE SALARY > ALL(SELECT MIN(SALARY) FROM EMPLOYEE GROUP BY DEPT_CODE);

-- 2000�� 1�� 1�� ������ �Ի��� �� 200�� 1�� 1�� ���� �Ի��� ��� �� �޿��� ���� ���� �޴� ������� �޿��� ���� ��� ��ȸ�ϱ�
SELECT *
FROM EMPLOYEE
WHERE HIRE_DATE < '00/01/01'
AND SALARY > ALL(SELECT SALARY FROM EMPLOYEE WHERE HIRE_DATE > '00/01/01');

-- ���߿� �������� : ROW 1�� COLUMN ������
-- ������ ������� ���� �μ� ���� ���޿� �ش��ϴ� ��� ��ȸ�ϱ�
SELECT DEPT_CODE FROM EMPLOYEE WHERE ENT_YN = 'Y';

SELECT *
FROM EMPLOYEE
WHERE (DEPT_CODE, JOB_CODE) IN (SELECT DEPT_CODE, JOB_CODE FROM EMPLOYEE WHERE ENT_YN ='Y');

-- ��� ������ �̸鼭 �޿��� 200������ ����� �ִٰ� �Ѵ�. �� ����� ������ ��ȸ�ϱ�
SELECT *
FROM EMPLOYEE
WHERE (DEPT_CODE, SALARY) IN (SELECT DEPT_CODE, SALARY FROM EMPLOYEE JOIN DEPARTMENT ON DEPT_CODE = DEPT_ID WHERE DEPT_TITLE = '���������' AND SALARY = 2000000);

-- ������ ���߿�
-- �ѹ��� �̸鼭 300���� �̻� �޿��� �޴� ���
SELECT DEPT_CODE, SALARY
FROM EMPLOYEE JOIN DEPARTMENT ON DEPT_CODE = DEPT_ID
WHERE DEPT_TITLE = '�ѹ���' AND SALARY >= 3000000;

SELECT *
FROM EMPLOYEE
WHERE (DEPT_CODE, SALARY) IN (SELECT DEPT_CODE, SALARY
                            FROM EMPLOYEE JOIN DEPARTMENT ON DEPT_CODE = DEPT_ID
                            WHERE DEPT_TITLE = '�ѹ���' AND SALARY >= 3000000
                          );

-- �����������
-- ���������� ������ �� ���������� ���� ������ ����ϰ� �����Ͽ� �������� ����� ������������ ������ �ް� ���������� ����� �������� ����������� ��ġ�ԵǴ� ����

-- �� ����� ���� �μ��� �ο��� ��ȸ�ϱ�
-- ��ø �ݺ����� ����� ����
SELECT EMP_NAME, DEPT_CODE, (SELECT COUNT(*) FROM EMPLOYEE WHERE DEPT_CODE = E.DEPT_CODE) AS �ο���
FROM EMPLOYEE E;

SELECT COUNT(*) FROM EMPLOYEE WHERE DEPT_CODE = 'D9';
SELECT COUNT(*) FROM EMPLOYEE WHERE DEPT_CODE = 'D6';

-- �ڽ��� ���� �μ��� ��ձ޿����� �޿��� ���� �޴� ����� ��ȸ�ϱ�
SELECT *
FROM EMPLOYEE E
WHERE SALARY > (SELECT AVG(SALARY) FROM EMPLOYEE WHERE DEPT_CODE = E.DEPT_CODE);

-- FROM ������ �������� ����ϱ�
-- INLINE VIEW -> ������ ���߿� ���������� ���
-- �����÷��� �߰��� SELECT ���̳� ���տ����� ����� SELECT ���� LINE VIEW �� ���� ���
-- STORED VIEW -> ����Ŭ���� �����ϴ� �ϳ��� OBJECT
-- INLINE VIEW -> �� 1ȸ��
-- STORE VIEW �� Ư����Ī���� INLINE VIEW �� �����ؼ� ��� -> VIEWTABLE �̶�� ��
SELECT *
FROM (SELECT E.*, DECODE(SUBSTR(EMP_NO,8,1),'1','��','2','��') AS GENDER FROM EMPLOYEE E)
WHERE GENDER = '��';

-- JOIN��
SELECT *
FROM (SELECT E.*, D.*, JOB_NAME,
(SELECT TRUNC(AVG(SALARY), -1) FROM EMPLOYEE WHERE DEPT_CODE = E.DEPT_CODE) AS DEPT_SAL,
(SELECT COUNT(*) FROM EMPLOYEE WHERE JOB_CODE = E.JOB_CODE) AS JOB_COUNT
FROM EMPLOYEE E LEFT JOIN DEPARTMENT D ON DEPT_CODE = DEPT_ID
                JOIN JOB J ON E.JOB_CODE = J.JOB_CODE)
                WHERE DEPT_SAL > 3000000 AND JOB_COUNT = 4;

-- INLINE VIEW �� ���� ���� �� INLINE VIEW ���� ������ �÷��� �̿� ����
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

--  �����͸� �������� ���� ����ϴ� ���� �ۼ��ϱ�
--  2���� ���
--  1. ����Ŭ���� �����ϴ� ROWNUM �÷��� �̿��ؼ� ���
--  -> SELECT ���� ����Ǹ� �ڵ����� ����Ŭ�� �ο��ϴ� �����÷�. SELECT ���� ����ɶ� ROW�� ��ȣ�� �ο��� �÷�
SELECT ROWNUM, E.*
FROM EMPLOYEE E
WHERE ROWNUM BETWEEN 1 AND 3;

-- �޿��� ���� �޴� ��� 1�� ���� 3����� ��ȸ
SELECT ROWNUM, E.*
FROM EMPLOYEE E
WHERE ROWNUM BETWEEN 1 AND 3
ORDER BY SALARY;

--ROWNUM �� ����ؼ� �������� ������ ����Ϸ��� INLINE VIEW �� �̿��ؾ��Ѵ�.
--�߰������� ���� �����͸� ����� �� ����
-- 1������ ������ �Ǿ�� ROWNUM�� �������
-- �׷��� �ѹ� �� �����༭ 1������ �ѹ� ����� ���� ���� �����ؾ� ������
-- PAGENATION ó���� ���� �����ϰ� �߿��� ������.
SELECT *
FROM(
    SELECT ROWNUM AS RNUM, E.*
    FROM (SELECT * FROM EMPLOYEE ORDER BY SALARY DESC) E
)
WHERE RNUM BETWEEN 5 AND 10;

--  2. ����Ŭ���� �����ϴ� WINDOW �Լ��� �̿��ؼ� ����ϴ� ���

SELECT * FROM EMPLOYEE;
SELECT * FROM JOB;
SELECT * FROM DEPARTMENT;
SELECT * FROM LOCATION;


-- 2. ����Ŭ���� �����ϴ� WINDOW �Լ��� �̿��ؼ� ����ϴ� ���
-- RANK OVER();
-- DENSE_RANK OVER();
SELECT *
FROM (
    SELECT RANK() OVER(ORDER BY SALARY DESC) AS RANK, SALARY, EMP_NAME
    FROM EMPLOYEE
)
WHERE RANK BETWEEN 5 AND 10;

SELECT *
FROM (
    SELECT
        RANK() OVER(ORDER BY SALARY DESC) AS RANK,
        DENSE_RANK() OVER(ORDER BY SALARY DESC) AS RANK2,
        SALARY, EMP_NAME
        FROM EMPLOYEE
);

-- DDL
-- �����͸� �����ϴ� ��� ����Ŭ���� ����ϴ� ��ü�� ����, ����, �����Ҷ� ����ϴ� ��ɾ�

-- CREATE TABLE -> ���̺�, ����Ҹ� �����ϴ� ��ɾ�
-- ������� �̸�, Ÿ���� ������� ��.

-- ����Ŭ�ڷ���
-- ������ : NUMBER
-- ������ : CHAR, VARCHAR2, NCHER, NVARCHAR2
-- ��¥�� : DATE, TIMESTAMP

CREATE TABLE TBL_STR(
    A CHAR(6),
    B VARCHAR(6),
    C NCHAR(6),
    D NVARCHAR2(6)
);

SELECT * FROM TBL_STR;
INSERT INTO TBL_STR VALUES('ABC', 'ABC', 'ABC', 'ABC');
-- VARCHAR �� �����°��� ���� ������
SELECT LENGTH(A), LENGTH(B), LENGTH(C),  LENGTH(D) FROM TBL_STR;

-- �ִ� 2000BYTE ���� ������ ����
-- �ѱ��� 2BYTE ����, EXPRESS ����1, �ѱ�3

-- �����ڷ��� : ����, �Ǽ�, ����, ��� ��� ����
-- ���
-- NUMBER(PRECISION, SCALE)
-- PRECISION : ǥ���Ҽ� �ִ� ��ü�ڸ��� (1~38)
-- SCALE : �Ҽ��� ���� �ڸ���(-84 ~ 127 )

CREATE TABLE TBL_NUMBER(
    A NUMBER,
    B NUMBER(5),
    C NUMBER(5,1),
    D NUMBER(5,-1)
)

INSERT INTO TBL_NUMBER VALUES(1234.567, 1234.567, 1234.567, 1234.567);

SELECT * FROM TBL_NUMBER;








