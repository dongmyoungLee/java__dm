SELECT * FROM DBA_USERS;
-- �ǽ��� ���� ����� ���������
-- SYSTEM(�����ڰ���)���� ������ ������Ѵ�.
-- CREATE USER ����ڸ� IDENTIFIED BY ��й�ȣ DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;
-- 18C �������ʹ� ����ڸ� C##�� �ο��ϰ� �Ǿ�����, -> ������ �� ����, �����ؼ� �������
ALTER SESSION SET "_ORACLE_SCRIPT"=TRUE;
CREATE USER BS IDENTIFIED BY BS DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;
-- ������ ���� Ȯ���ϱ�
SELECT * FROM DBA_USERS;--�����ͺ��̽��� ��ϵ� ������ ��ȸ�ϴ� ��ɾ�

-- ������ �������� �����ϱ� -> ���Ӹ���� -> ����
-- ������ �������� ������ �����Ǿ����� -> ������ ����
-- ������ �������� ����ڿ��� ���ӱ��� �ο����ֱ� -> CONNECT���� �ο�
-- GRANT ���Ѹ�||ROLE�̸� TO �ο��� ����ڸ�
GRANT CONNECT TO BS;

-- BS�������� �����ؼ� ��ɾ� �����غ���
SELECT * FROM TAB; -- BS������ ������ �ִ� ���̺�(�����͸� �����ϴ� ����) ��ȸ�ϱ�
--  ������� �����غ���
-- ���÷� TEST�̸��� ��������� �����ϴ� ����
-- �⺻������ ��������� ������ �� �ִ� ������ �ο��Ǿ� �����ʴ�.! -> SYSTEM�������� �ο��� �������.
CREATE TABLE TEST(
    TEST_NAME VARCHAR2(200)
);

-- ������������ϴ� ���� �ο��ϱ�
GRANT RESOURCE TO BS;

-- ����ڰ� ������ ���̺� ��ȸ
SELECT * FROM TAB;

-- ���ο� ������ ������ �ϰ� �Ǹ� SYSTEM�������� �˸´� ������ �ο�������Ѵ�.
-- �⺻������ RESOURCE, CONNECT������ �ο��Ѵ�.

-- BS������ �߰��� ������ Ȯ���ϱ�
-- �߰��� ���̺�(�������) Ȯ���ϱ�
SELECT * FROM TAB;
-- EMPLOYEE : ������� �������̺�
SELECT * FROM EMPLOYEE;
-- DEPARTMENT : �μ����� �������̺�
SELECT * FROM DEPARTMENT;
-- JOB : ��å���� �������̺�
SELECT * FROM JOB;
-- LOCATION : �μ��������� �������̺�
SELECT * FROM LOCATION;
-- NATIONAL : �������� ���� ���̺�
SELECT * FROM NATIONAL;
-- SAL_GRADE : �޿� ���� ���� ���̺�
SELECT * FROM SAL_GRADE;

-- SELECT�� Ȱ���ϱ�
-- �⺻ SELECT ��
-- SELECT �÷���, �÷���,.....(�÷��� ����)
-- FROM ���̺��

-- EMPLOYEE ���̺��� EMP_ID, EMP_NAME, SALARY �÷��� ��ȸ�ϱ�
SELECT EMP_ID, EMP_NAME, SALARY 
FROM EMPLOYEE;

-- DEPARTMENT���̺��� DEPT_TITLE��ȸ�ϱ�
SELECT DEPT_TITLE
FROM DEPARTMENT;

-- EMPLOYEE���̺� �ִ� ��ü �÷��� ��ȸ�ϱ�
-- SELECT���� �÷��� �����κп� * �� ����ϸ� �ȴ�.
SELECT * 
FROM EMPLOYEE;

-- DEPARTMENT���̺� �ִ� ��ü �÷��� ��ȸ�ϱ�
SELECT * FROM DEPARTMENT;

-- ������ ����Ǿ��ִ� ���̺�� �÷� Ȯ���ϱ�
-- ���̺���ȸ
SELECT * FROM TAB;
-- ���̺��� �÷��� ��ȸ�ϱ�
DESC DEPARTMENT;

-- SELECT���� �̿��ؼ� ������� ó������� Ȯ���� �� ����
-- SELECT  1+10 FROM EMPLOYEE;
-- �׽�Ʈ�� �⺻ ���̺� ���� -> DUAL���̺�
-- ������ ���, ����Ŭ�����Լ������� �� ���
SELECT 1+10,5*3,10/2 FROM DUAL;
-- ������� ������ִ� �÷� -> �����÷��̶�� ��.
-- �����Ͱ� �ִ� ���̺��� �÷��� ��������� ����
-- EMPLOYEE���̺��� SALARY�� 100���ϱ�
SELECT EMP_NAME, SALARY,SALARY+100
FROM EMPLOYEE;

-- �� ����� �̸�, ���� ������ ��ȸ�ϱ�
SELECT EMP_NAME, SALARY, SALARY * 12
FROM EMPLOYEE;

-- �÷����� NULL�� ��� ��������� �Ұ��� -> �Լ��� �̿��ؼ� NULL�϶� ��ü���� ������ �� ����
SELECT * FROM EMPLOYEE;
SELECT EMP_NAME, BONUS, NVL(BONUS,0)+0.5
FROM EMPLOYEE;

-- �÷��� ��������� �� ��� �÷��� Ÿ���� �������̾�� �Ѵ�.
--SELECT EMP_NAME+100
--FROM EMPLOYEE;

-- FROM������ ����� ���̺� �ִ� �÷��� ��ȸ�� �����ϴ�
--SELECT DEPT_ID, DEPT_TITLE,EMP_NAME 
--FROM DEPARTMENT;

-- �÷����� ���Ӱ� ������ �� ���� -> ��Ī�ο��ϱ�
SELECT EMP_ID, EMP_NAME, EMAIL
FROM EMPLOYEE;
-- �÷��� �����ϰ� AS���� �̿��ؼ� ��Ī�� �ο�
SELECT EMP_ID AS �����ȣ,EMP_NAME AS �����, EMAIL AS �̸���
FROM EMPLOYEE;
-- �����÷��� ��Ī�� �ο��ϴ� ��찡 ����
SELECT EMP_ID, EMP_NAME, SALARY, SALARY*12 AS YEAR_SALARY
FROM EMPLOYEE;
-- ��Ī�� ""�� �̿��ؼ� ���� �� �� �ִ�.
SELECT EMP_ID AS "��� ��ȣ",EMP_NAME AS "��$��"
FROM EMPLOYEE;

-- �ߺ�������(ROW)�� ���� ��ȸ�ϱ�
-- DISTINCT���� ����ؼ� ��ȸ�� �Ѵ�
SELECT DISTINCT DEPT_CODE
FROM EMPLOYEE;
SELECT DISTINCT JOB_CODE
FROM EMPLOYEE;
-- DISTINCT�� SELECT ����� �������� ����� ����
-- SELECT EMP_NAME, DISTINCT DEPT_CODE
-- FROM EMPLOYEE;
SELECT DISTINCT DEPT_CODE, JOB_CODE
FROM EMPLOYEE;

-- ���ڿ��� �������ִ� ����ó���ϱ�
-- ���ڿ�||���ڿ� -> ���ڿ��� ����
-- ����Ŭ���� ���ڿ� ���ͷ�ǥ�� -> ''
SELECT '������ '||'���ɸ��ְ� �Ծ�����?' AS MSG
FROM DUAL;

-- ���ڿ� �÷��� �����Ͽ� ����Ҷ��� ���
SELECT EMP_NAME||'���� �̸����� '||EMAIL
FROM EMPLOYEE;

SELECT * FROM EMPLOYEE;
-- ������(ROW)�� �����ϱ� -> ���ǿ� �´� ������(ROW) ��ȸ�ϱ�
-- WHERE ���� ���
-- ���
-- SELECT *||�÷���,�÷���.....
-- FROM ���̺��
-- WHERE ���ǹ�(�񱳿���(=, >=, <=, !=), ������(AND, OR))
-- EMPLOYEE ���̺��� ������ 300�����̻��� ����� ��ȸ����
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE SALARY>=3000000;

-- EMPLOYEE ���̺��� DEPT_CODE�� D5�� ����� ��ü�÷��� ��ȸ�ϱ�
SELECT * 
FROM EMPLOYEE
WHERE DEPT_CODE='D5';

-- EMPLOYEE ���̺��� JOB_CODE�� J2�� ����� �̸�, �޿�, ��å�ڵ� ��ȸ�ϱ�
SELECT EMP_NAME, SALARY, JOB_CODE
FROM EMPLOYEE
WHERE  JOB_CODE='J2';

-- EMPLOYEE���̺��� �μ��ڵ尡 D5�� �ƴ� ����� �̸�, �μ��ڵ� ��ȸ�ϱ�
SELECT EMP_NAME, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE != 'D5';

-- EMPLOYEE ���̺��� �μ��ڵ尡 D5�̰� ������ 300�����̻��� ����� ��ü�÷� ��ȸ�ϱ�
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE='D5' AND SALARY>=3000000;

-- EMPLOYEE ���̺��� �μ��ڵ尡 D5�̰ų� ������ 300���� ������ ����� ��ü�÷� ��ȸ�ϱ�
SELECT * 
FROM EMPLOYEE
WHERE DEPT_CODE='D5' OR SALARY<=3000000;

-- ��¥�� �����͵� ��Һ񱳰� �����ϴ�
-- ��¥ǥ�ô� ���ڿ��� ���Ͽ� ���缭 ǥ�� -> 'YYYY/MM/DD' 'YY/MM/DD'
-- EMPLOYEE���̺��� �Ի���(HIRE_DATE)�� 2000�⵵ ������ ����� ���ϱ�
SELECT *
FROM EMPLOYEE
WHERE HIRE_DATE < '00/01/01';


-- Ư�������� ��ȸ�ϴ� ����
-- AND �����Ͽ� ���, BETWEEN AND�� ����ؼ� ó���ϴ� ���
-- EMPLOYEE���̺��� ������ 200���� �̻� 300���� ���Ϸ� �޴� ����� �̸�, �޿�, ���ʽ�, �Ի��� ��ȸ�ϱ�
SELECT *
FROM EMPLOYEE
--WHERE SALARY>=2000000 AND SALARY<=3000000;
WHERE SALARY BETWEEN 2000000 AND 3000000;

-- EMPLOYEE���̺��� �Ի����� 2000���� ����� ��ȸ�ϱ�
SELECT *
FROM EMPLOYEE
--WHERE HIRE_DATE>='00/01/01' AND HIRE_DATE<='00/12/31';
WHERE HIRE_DATE BETWEEN '00/01/01' AND '00/12/31'; 


-- LIKE������ �̿��ϱ�
-- ���ڿ� �����͸� �������� ���ϴ� ���� -> �κ���ġ, ���Ͽ� �´� ���ڿ��� ã�� ���
-- �̸��� 'EA'�� �ִ� ���, ���� �达�� ���, �ֹι�ȣ�� 32�� �ִ� ���
-- �÷��� LIKE '���ҹ�������'
-- % : ���ڰ� 0���̻� �ƹ����ڳ� ��� 
-- ��) '%��%' : ���� �ִ� ���Ե� ���ڿ� �Ѱ�(O), ����(o) ���϶�(0),��������(0), �谭��(0),������������������������������(0)'
--     '��%' : ������ �����ϴ� ���ڿ�
-- _ : ���ڰ� 1�� �ƹ����ڳ� ���
-- ��) '_��_' : 3���� ���ڿ� �߰��� ���� �ִ°�
-- ��) '_��%' : 2�����̻� ���ڿ� �ι�° ���ڰ� '��'�� ���ڿ�

-- ��� �� �������� ���� ����� �����, ����, �μ��ڵ� ��ȸ�ϱ�
SELECT EMP_NAME, SALARY, DEPT_CODE
FROM EMPLOYEE
--WHERE EMP_NAME LIKE '��%';
WHERE EMP_NAME LIKE '��__';
-- EMAIL�� YO�� �����ϰ� �ִ� ����� �̸�, �̸����� ��ȸ�ϱ�
SELECT EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE EMAIL LIKE '%y%';

-- LIKE���������ϱ�
-- ����� ���� ���� �ƴ� ����� ��ȸ�ϱ�
SELECT * 
FROM EMPLOYEE
WHERE EMP_NAME NOT LIKE '��%';

-- �̸����ּҿ� _�ձ��ڰ� 3������ ����� �����, �̸��� ��ȸ�ϱ�
SELECT EMP_NAME, EMAIL 
FROM EMPLOYEE
WHERE EMAIL LIKE '___\_%' ESCAPE '\';

-- NULL�� ���ϱ�
-- �⺻������ NULL���� �񱳿��� ó���� �� �� ����.
-- NULL���� ó���ϱ� ���� �����ڸ� ����� ����
-- IS NULL / IS NOT NULL
-- ����� ���ʽ��� �޴� ����� �̸�, �޿�, ���ʽ��� ��ȸ�ϱ�
SELECT * 
FROM EMPLOYEE
WHERE BONUS IS NOT NULL;
--WHERE BONUS = NULL

-- ����� �Ŵ����� ������������ ����� ��ȸ�ϱ�
SELECT * FROM EMPLOYEE;
SELECT * 
FROM EMPLOYEE
WHERE MANAGER_ID IS NULL;

-- �μ��� ���� ��� ��ȸ�ϱ�
-- �μ��ڵ忡 �������� �ۼ��ϱ�
SELECT E.*, NVL(DEPT_CODE,'����')
FROM EMPLOYEE E 
WHERE DEPT_CODE IS NULL;

-- ���߰� ������ϱ�
-- OR�� �����ؼ� ó���ϱ� IN�� Ȱ���ϱ�
-- ����� �μ��� D5�̰ų� D6�� ����� ����� �μ��ڵ带 ��ȸ�ϱ�
SELECT EMP_NAME, DEPT_CODE
FROM EMPLOYEE
--WHERE DEPT_CODE='D5' OR DEPT_CODE='D6';
--WHERE DEPT_CODE IN ('D5','D6');
WHERE DEPT_CODE IN (SELECT DEPT_CODE FROM EMPLOYEE WHERE EMP_NAME IN('�ɺ���','������'));
-- �ź���, ���������� ���� �μ��� ������ϱ�
SELECT DEPT_CODE FROM EMPLOYEE WHERE EMP_NAME IN('�ɺ���','������');

-- NOT IN()����ϱ�
-- D5, D6�� �ƴ� ��� ��ȸ�ϱ�
SELECT * 
FROM EMPLOYEE
WHERE DEPT_CODE NOT IN ('D5','D6');

-- ��������� ������ �켱������ ��������.
-- ��å�� J7�̰ų� J2�� ��� �� �޿��� 200���� �̻��� ����� ��ȸ
SELECT EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE (JOB_CODE='J7' OR JOB_CODE='J2') AND SALARY>=2000000;

-- WHERE ������ ��������� ����� �� �ִ�.
SELECT *
FROM EMPLOYEE
WHERE SALARY > SALARY*12;


-- ����Ŭ���� �����ϴ� �Լ��� ����غ���
-- �Լ��� ����Ҷ��� SELECT������ ����� �Ѵ�.
-- SELECT���� �÷����� ���̳� WHERE�� ����� �� �� �ִ�.

-- �������Լ� ������ ���̺� �ִ� ��� ROW�� ����� ������ִ� �Լ�
-- ���ڿ� ó���Լ�
-- LENGTH() : �Ű������� ���޵� �÷��̳� ���ͷ��� ���̸� ������ִ� �Լ�
SELECT LENGTH('������') FROM DUAL;
-- �̸��� ���� Ȯ���ϱ�
SELECT LENGTH(EMAIL), EMAIL FROM EMPLOYEE;

-- �̸����� ���̰� 13�̻��� ���
SELECT EMAIL 
FROM EMPLOYEE
WHERE LENGTH(EMAIL)>=13;

--LENGTHB()

-- INSTR() : JAVA INDEXOF()�޼ҵ�� ����
-- ���ڿ��� �ε��� ��ġ�� ��ȯ���ִ� �Լ�
-- INSTR(����ڿ�||�÷�,ã�����ڿ�[,�˻�������ġ]) : ã�� ���ڿ��� �ε�����ȣ�� ��ȯ
SELECT INSTR('�ް����͵�IT','IT'), INSTR('�ް����͵�IT','�ް�')
FROM DUAL;
SELECT EMAIL, INSTR(EMAIL,'j')
FROM EMPLOYEE;

SELECT INSTR('�ް� ���͵� �ް����͵� IT �ް� ���͵� �̿�','�ް�',4),
INSTR('�ް� ���͵� �ް����͵� IT �ް� ���͵� �̿�','�ް�',1,3)
FROM DUAL;

-- LPAD/RPAD : ������ ���̿� ���ڿ��� ä������ �ʾ����� Ư�����ڷ� ä���ִ� �Լ�
-- LPAD||RPAD(���ڿ�||�÷���,����,�����ä���ٹ���)
SELECT LPAD('�ް�',10,'*'),RPAD('�ް�',10,'*')
FROM DUAL;
SELECT RPAD(EMP_NAME,8,'��')
FROM EMPLOYEE;

-- LTRIM/RTRIM : ���� �Ǵ� Ư�� ���ڸ� �������ִ� ���
SELECT '    ������',LTRIM('    ������'),'1111����',LTRIM('1111����','1'),LTRIM('11211����','1')
FROM DUAL;

-- TRIM : ������ ���� �����ϴ� �Լ�, �⺻ : ����, ������ ���� ����
SELECT '     ����      ',TRIM('     ����      '),
TRIM('Z' FROM 'ZZZZZ����ZZZZZ'),
TRIM(LEADING 'Z' FROM 'ZZZZZ����ZZZZZ'),
TRIM(TRAILING 'Z' FROM 'ZZZZZ����ZZZZZ'),
TRIM(BOTH 'Z' FROM 'ZZZZZ����ZZZZZ')
FROM DUAL;

-- SUBSTR : JAVA SUBSTRING�޼ҵ�� ������ �Լ�
-- SUBSTR(����ڿ�,�����ε���[,���ε���])
SELECT EMP_NAME, SUBSTR(EMP_NAME,1,1)
FROM EMPLOYEE;
SELECT DISTINCT SUBSTR(EMP_NAME,1,1)
FROM EMPLOYEE;

SELECT * FROM EMPLOYEE;
SELECT SUBSTR(EMP_NO,1,2) AS �⵵, SUBSTR(EMP_NO,8,1) AS ����
FROM EMPLOYEE;

SELECT * 
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO,1,2) BETWEEN 80 AND 89;

SELECT *
 FROM EMPLOYEE
 WHERE SUBSTR(EMP_NO,8,1) IN ('2','4');
 
-- ����� �̸��Ͽ��� ���̵� ����ϱ�
SELECT EMAIL,SUBSTR(EMAIL,1,INSTR(EMAIL,'@')-1)
FROM EMPLOYEE;
SELECT EMAIL,SUBSTR(EMAIL,1,INSTR(EMAIL,'@')-1)
FROM EMPLOYEE
WHERE LENGTH(SUBSTR(EMAIL,1,INSTR(EMAIL,'@')-1))>=7;

-- �����ڸ� ó���ϴ� �Լ�
-- UPPER, LOWER, INITCAP
SELECT LOWER('Welcome to oRACLE world'),
UPPER('Welcome to oRACLE world'),
INITCAP('Welcome to oRACLE world')
FROM DUAL;
SELECT * 
FROM EMPLOYEE
WHERE DEPT_CODE = UPPER('d5');

-- REPLACE : ��󹮿��� �������ڸ� ã�Ƽ� ��ü���ڷ� �������ִ� �Լ�
-- REPLACE(���ڿ�||�÷���,'ã������','��ü����')
SELECT EMAIL, REPLACE(EMAIL,'or.kr','BS.or.kr')
FROM EMPLOYEE;
UPDATE EMPLOYEE SET EMAIL=REPLACE(EMAIL,'or.kr','BS.or.kr');
SELECT * FROM EMPLOYEE;
COMMIT;

-- ����ó���Լ�
-- �Ҽ����� ���� ó��, ��꿡 ���� ó���� �ִ�...
-- ABS : ���밪
SELECT ABS(-10), ABS(10)
FROM DUAL;

--MOD() : ���������ϴ��Լ� -> %
SELECT MOD(3,2)
FROM DUAL;
SELECT E.*, MOD(SALARY,3)
FROM EMPLOYEE E;

-- �Ҽ����� ó���ϴ� �Լ�
-- ROUND(�ݿø�), FLOOR(�Ҽ�������), TRUNC(�Ҽ�������, ������ �ڸ�������), CEIL(�����ǿø�)
SELECT ROUND(126.456),FLOOR(126.567),TRUNC(126.567,1),CEIL(126.123) 
FROM DUAL;

-- ���ʽ��� ������ ���ޱ��ϱ�
SELECT EMP_NAME,SALARY,FLOOR(SALARY+(SALARY*NVL(BONUS,0)-(SALARY*0.03))) AS SALARY
FROM EMPLOYEE;

-- ��¥ó���Լ�
-- ����Ŭ���� ��¥�� ����Ҷ� �ΰ���
-- SYSDATE���� ��� -> ���ó�¥���(DB������ǻ�Ϳ� ������ ��¥)
-- SYSTIMESTAMP����� ��� ��¥,�ð��� �������
SELECT SYSDATE, SYSTIMESTAMP FROM DUAL;

-- ��¥�� ������ ������. +, - �ϼ��� ���
SELECT SYSDATE, SYSDATE+3, SYSDATE-10
FROM DUAL;
-- NEXT_DAY : ���ڷ� ���޵� ������ ���� ����� ������¥�� ���
SELECT NEXT_DAY(SYSDATE,'ȭ'), NEXT_DAY(SYSDATE,'��')
FROM DUAL;
SELECT * FROM V$NLS_PARAMETERS;
ALTER SESSION SET NLS_LANGUAGE='KOREAN';

-- LAST_DAY : �״��� ���������� ������ִ� �Լ�
SELECT LAST_DAY(SYSDATE)
FROM EMPLOYEE;

SELECT NEXT_DAY(HIRE_DATE,'��'), LAST_DAY(HIRE_DATE)
FROM EMPLOYEE;

-- �������� ������ִ�(�����ִ�) �Լ�
-- ADD_MONTHS()
SELECT ADD_MONTHS(SYSDATE,-3), ADD_MONTHS(SYSDATE,3)
FROM DUAL;
-- �� ��¥�� ���������̸� ������ִ� �Լ�
-- MONTHS_BETWEEN(��¥, ��¥)
SELECT FLOOR(MONTHS_BETWEEN(SYSDATE,'23/04/20'))
FROM DUAL;

-- ��¥�� �⵵, ��, ���� ���� ������ִ� �Լ�
-- EXTRACT(YEAR||MONTH||DAY FROM ��¥) : ����
SELECT EXTRACT(YEAR FROM SYSDATE), EXTRACT(MONTH FROM SYSDATE), EXTRACT(DAY FROM SYSDATE)
FROM DUAL;

SELECT EXTRACT(YEAR FROM SYSDATE)-1995
FROM DUAL;

-- ����� 12���� �Ի��� ��� ��ȸ�ϱ�
SELECT * 
FROM EMPLOYEE
WHERE EXTRACT(MONTH FROM HIRE_DATE)=12;

-- ����� 2000��� �Ի��� ��� ��ȸ�ϱ�
SELECT * 
FROM EMPLOYEE
WHERE EXTRACT(YEAR FROM HIRE_DATE) BETWEEN 2000 AND 2009;

-- ���úη� ���ƾ��� ����� �������� �Ǿ����ϴ�.�Ф� �߰� ���ƾ�~ ���뺹���Ⱓ�� 1�� 6������
-- �������ڸ� ���ϰ�, �����ϼ�, ���������� �Ա� «�䰹��(�Ϸ� 3��)�� ���ϱ�
SELECT ADD_MONTHS(SYSDATE,18) AS ������, ADD_MONTHS(SYSDATE,18)-SYSDATE AS �����ϼ�,
    (ADD_MONTHS(SYSDATE,18)-SYSDATE)*3 AS «���
FROM DUAL;

-- ����ȯ �Լ� -> (�ڷ���), parseOOO, String.valueOf
-- ����Ŭ�� �ڵ�����ȯ�� �� �۵�.
-- ������ ����ȯ�� �̿��ؼ� ó���� �� ����
-- ���� : NUMBER
-- ���ڿ� : VARCHAR2
-- ��¥ : DATE, TIMESTAMP

-- TO_CHAR : ����, ��¥�� ���������� �������ִ� �Լ�
-- ��¥���� ���������� �����ϱ�
-- ��¥�� ��ȣ�� ǥ���ؼ� ���������� ������ 
-- Y:��, M:��, D:��, H:��, MI:��, SS:��
SELECT SYSDATE, TO_CHAR(SYSDATE,'YYYY-MM-DD'),
TO_CHAR(SYSDATE,'YY.MM.DD'), TO_CHAR(SYSDATE,'YY.MM.DD HH24:MI:SS')
FROM DUAL;

-- ���ڸ� ���ڷ� ��ȯ�ϱ� 
-- ���Ͽ� ���缭 ��ȯ -> �ڸ����� ���� ������ ����
-- 0 : ��ȯ�ϴ� ���� �ش��ڸ��� ������ 0���� ǥ��, �ڸ��� ���� ������ �� ���ڷ� ǥ��
-- 9 : ��ȯ�ϴ� ���� �ش��ڸ��� ������ ǥ�� ����, �ڸ��� ���� ������ �� ���ڷ� ǥ�� 
-- ��ȭ�� ǥ���Ϸ��� Lǥ����
SELECT 12345678, TO_CHAR(12345678,'999,999,999'),
TO_CHAR(1234567,'000,000,000'),
TO_CHAR(12345678,'L999,999,999'),
TO_CHAR(180.5,'FM999.99'),
TO_CHAR(180.5,'FM999.00')
FROM DUAL;
SELECT EMP_NAME, SALARY, TO_CHAR(SALARY,'L999,999,999') AS CONVERT
FROM EMPLOYEE;

-- �������� ���������� �����ϴ� �Լ�
-- TO_NUMBER()
-- �������� ����
SELECT '1,000,000', TO_CHAR(TO_NUMBER('1,000,000','999,999,999')+100,'L999,999,999')
FROM DUAL;

-- ����, ���ڸ� ��¥������ �������ִ� �Լ�
-- TO_DATE() ��¥�������� ��¥������ ��ȯ
-- Y M D, �⺻��¥���� : YY/MM/DD
SELECT TO_DATE('22/12/25','YY/MM/DD')-SYSDATE, TO_DATE('221225','YYMMDD'),
    TO_DATE(221225,'YYMMDD'),TO_DATE(20230108,'YYYYMMDD'),
    TO_DATE(TO_CHAR(001225,'009999'),'YYMMDD')
FROM DUAL;

-- NULL ���� ó�����ִ� �Լ�
-- NVL() : Ư���÷����� NULL�� ��� ��ü������ ������ִ°�
SELECT EMP_NAME, DEPT_CODE,NVL(DEPT_CODE,'����'),BONUS,NVL(BONUS,0)
FROM EMPLOYEE
WHERE NVL(DEPT_CODE,'����')='����';
-- NVL2() : NULL���϶� ��, NULL���� �ƴҶ� ���� ����
SELECT EMP_NAME, DEPT_CODE, NVL2(DEPT_CODE,'������','����')
FROM EMPLOYEE;

-- ���ǿ� ���� ��°��� �������ִ� �Լ�
-- 1. DECODE
-- DECODE(�÷���||���ڿ�,'������Ұ�','�������� ����Ұ�','������Ұ�','������������Ұ�')
SELECT EMP_NAME, JOB_CODE,DECODE(JOB_CODE,'J1','��ǥ','J2','�λ���','J3','����','���')
FROM EMPLOYEE;
-- ������ ��,�� �� ����ϴ� �÷������
SELECT EMP_NAME, SALARY, DECODE(SUBSTR(EMP_NO,8,1),'1','��','2','��') AS GENDER
FROM EMPLOYEE
WHERE DECODE(SUBSTR(EMP_NO,8,1),'1','��','2','��')='��';
-- 2. CASE WHEN THEN
-- CASE
--  WHEN ���ǹ� THEN ���೻��(��±���)
--  WHEN ���ǹ� THEN ���೻��(��±���)
--  WHEN ���ǹ� THEN ���೻��(��±���)
--  ELSE ���೻��
-- END
SELECT EMP_NAME, JOB_CODE,
    CASE
        WHEN JOB_CODE='J1' THEN '��ǥ'
        WHEN JOB_CODE='J2' THEN '�λ���'
        WHEN JOB_CODE='J3' THEN '����'
        WHEN JOB_CODE='J4' THEN '����'
        ELSE '���'
    END AS ��å,
    CASE
        WHEN SALARY>3000000 THEN '��׿���'
        WHEN SALARY<=3000000 THEN '�⺻'
    END AS ���
FROM EMPLOYEE;

-- ������̺��� ���糪�̱��ϱ�
-- ����Ŭ���� �⵵�� ǥ���ϴ� ���ϰ��� 2���� Y, R
SELECT EMP_NAME, EXTRACT(YEAR FROM SYSDATE)-EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO,1,2),'RR')) AS ����,
    EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO,1,2),'YY')) AS YY,
    EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO,1,2),'RR')) AS RR
FROM EMPLOYEE;

-- RR�� �⵵�� ����Ҷ� 
--����⵵       �Է³⵵     ���⵵
--00~49         00~49       ������
--00~49         50~99       ������
--50~99         00~49       ��������
--50~99         50~99       ������

-- �׷��Լ� Ȱ���ϱ�
-- ���̺��� �����͸� �����ؼ� �ϳ��� ROW�� ����� ����ϴ� �Լ� -> ����� �Ѱ��� ����
-- �÷����� ���� �հ�, ���, ���� ���Ҵ� ���
-- �׷��Լ��� �̿��ϸ� SELECT������ �÷��� ����� ���� * �׷��Լ����� ����� �÷��� ����� ����
-- ���� 
-- SUM : �÷����� ���� �հ踦 ������ִ� �Լ�
-- AVG : �÷����� ���� ����� ������ִ� �Լ�
-- COUNT : ���̺��� ROW���� ������ִ� �Լ� * �÷����� ����
-- MIN : �÷����� ���� �������� ������ִ� �Լ�
-- MAX : �÷����� ���� ū���� ������ִ� �Լ�

-- ������̺��� ����� �޴� �޿��� �հ踦 ��ȸ�ϱ�
SELECT * FROM EMPLOYEE;
SELECT SUM(SALARY) FROM EMPLOYEE;
-- ����� �޴� �޿��� ����� ��ȸ
SELECT FLOOR(AVG(SALARY)) FROM EMPLOYEE;

SELECT SUM(SALARY), AVG(SALARY) FROM EMPLOYEE;
--SELECT SUM(EMP_NAME) FROM EMPLOYEE;
-- �μ��� D5�� ����� �޿� �հ�, ����� ���ϱ�
SELECT SUM(SALARY) AS �հ�, AVG(SALARY) AS ���
FROM EMPLOYEE
WHERE DEPT_CODE='D5';

-- SUM, AVG�̿�� NULL���� �ִ� ���? -> ���꿡�� ������
SELECT TRUNC(AVG(BONUS),3), TRUNC(AVG(NVL(BONUS,0)),3)
FROM EMPLOYEE;

-- ROW�� ������ ������ִ� �Լ�
-- EMPLOYEE�� ��ϵ� ����� ���ϱ�
SELECT COUNT(*) 
FROM EMPLOYEE;
-- D5�μ��� ����� ���ϱ�
SELECT COUNT(*) 
FROM EMPLOYEE
WHERE DEPT_CODE='D9';

-- 400�鸸�� �̻� �޿��� �޴� ��� ��
SELECT COUNT(*)
FROM EMPLOYEE
WHERE SALARY>=4000000;

-- ���� ���ʽ��� �ް� �ִ� �����
SELECT COUNT(*)
FROM EMPLOYEE
WHERE BONUS IS NOT NULL;

-- �μ��� D6,D5,D9�� ����� ��, �޿����, �޿��հ踦 ��ȸ�ϱ�
SELECT COUNT(*) AS ��, TRUNC(AVG(SALARY),-2) AS ���, SUM(SALARY) AS �հ�
FROM EMPLOYEE
WHERE DEPT_CODE IN('D6','D5','D9') AND SALARY >= 3000000;

-- COUNT(*) VS COUNT(�÷���)
SELECT COUNT(*), COUNT(DEPT_CODE), COUNT(BONUS)
FROM EMPLOYEE;

-- MIN/MAX
SELECT MAX(SALARY), MIN(SALARY) 
FROM EMPLOYEE;

-- �׷��Լ��� WHERE���� ����� �Ұ�����
--SELECT * 
--FROM EMPLOYEE
--WHERE MAX(SALARY)=SALARY;

-- GROUP BY �� �̿��ϱ�
-- GROUP BY �� Ư���÷��� ���� �������� ��� ������� ����ϴ� ��ɾ�
-- �μ��� �޿��� �հ�, ���
SELECT DEPT_CODE,SUM(SALARY),AVG(SALARY)
FROM EMPLOYEE
WHERE DEPT_CODE IS NOT NULL
GROUP BY DEPT_CODE;

-- ��å�� �޿��� �հ�, ���
SELECT JOB_CODE, SUM(SALARY), AVG(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE;

-- �μ��� �ο� ��ȸ�ϱ�
SELECT DEPT_CODE, COUNT(DEPT_CODE)
FROM EMPLOYEE
WHERE DEPT_CODE IS NOT NULL
GROUP BY DEPT_CODE;

-- GROUP BY������ �ټ��� �÷��� ����� �� ����
-- GROUP BY �÷�, �÷�,....
SELECT DEPT_CODE, JOB_CODE, COUNT(*), SUM(SALARY),AVG(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE, JOB_CODE;

-- �μ��� �ְ�޿�,�ּұ޿� ��ȸ�ϱ�
SELECT DEPT_CODE, MAX(SALARY), MIN(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- �׷��Լ��� �������� ����Ҷ��� HAVING���� �̿�����
-- �μ��� �ο����� 4���̻��� �μ��� ��ȸ
SELECT DEPT_CODE, COUNT(*)
FROM EMPLOYEE
--WHERE COUNT(*)>=4
GROUP BY DEPT_CODE
HAVING COUNT(*)>=4;

-- �Ŵ����� �����ϴ»���� 2�� �̻��� �Ŵ��� ����ϱ�
SELECT * FROM EMPLOYEE;
SELECT MANAGER_ID, COUNT(*)
FROM EMPLOYEE
WHERE MANAGER_ID IS NOT NULL
GROUP BY MANAGER_ID
HAVING COUNT(*)>=2;

--SELECT * 
--FROM EMPLOYEE
--WHERE EMP_ID IN(SELECT MANAGER_ID FROM EMPLOYEE GROUP BY MANAGER_ID HAVING COUNT(*)>=2);

-- ROLLUP, CUBE�̿��ϱ�
-- �׷캰 �������� �� �������� ������ִ� �Լ�
-- �÷��� �Ѱ��� ���������� ROLLUP�� CUBE�� ����
-- �÷��� ������ ���������� ROLLUP -> ���ʿ� �ִ� �÷��� �������� ����, �� ����
--                       CUBE -> ����� �÷��� �������� ����(�ΰ���), �� ���� 
-- ROLLUP
SELECT NVL(DEPT_CODE,'TOTAL'), SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_CODE IS NOT NULL
GROUP BY ROLLUP(DEPT_CODE);
-- CUBE
SELECT NVL(DEPT_CODE,'TOTAL'), SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_CODE IS NOT NULL
GROUP BY CUBE(DEPT_CODE);

-- �ΰ��÷� �̻��� GROUP���� ���������� ó���ϴ°� �ٸ�
SELECT DEPT_CODE, JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_CODE IS NOT NULL
GROUP BY ROLLUP(DEPT_CODE, JOB_CODE);

SELECT DEPT_CODE, JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_CODE IS NOT NULL
GROUP BY CUBE(DEPT_CODE,JOB_CODE);

-- GOURPING() : ����� �÷��� Ȯ�����ִ� �Լ�
SELECT COUNT(*) AS �ο���, 
    CASE 
        WHEN GROUPING(JOB_CODE)=1 AND GROUPING(DEPT_CODE)=0 THEN '�μ����ο�'
        WHEN GROUPING(JOB_CODE)=0 AND GROUPING(DEPT_CODE)=1 THEN '��å���ο�'
        WHEN GROUPING(JOB_CODE)=0 AND GROUPING(DEPT_CODE)=0 THEN '�׷캰�ο�'
        WHEN GROUPING(JOB_CODE)=1 AND GROUPING(DEPT_CODE)=1 THEN '���ο�'
    END AS ���
FROM EMPLOYEE
WHERE DEPT_CODE IS NOT NULL
GROUP BY CUBE(JOB_CODE,DEPT_CODE);

-- ��ȸ�� �����͸� �����ϱ�
-- ORDER BY �� ���
-- SELECT �÷�,�÷�
-- FROM ���̺�
-- [WHERE ���ǽ�]
-- [GROUP BY �÷���]
-- [HAVING �׷��Լ��̿� ����]
-- [ORDER BY �÷��� ���Ŀɼ�(DESC,ASC:DEFAULT)]
-- ��ü����� �޿� ���� �޴� ������ �����ؼ� ��ȸ�ϱ�
SELECT * 
FROM EMPLOYEE
ORDER BY SALARY DESC;

-- ����� �̸������� ��ü��� ��ȸ�ϱ�
SELECT *
FROM EMPLOYEE
ORDER BY EMP_NAME DESC;

-- ORDER BY ������ �Ѱ��̻��� �÷��� ����� �� ����
SELECT * 
FROM EMPLOYEE
ORDER BY DEPT_CODE DESC, SALARY DESC;
-- DESC, ASC : NULL��
-- DESC : NULL���� �ֻ������.. 
-- ASC : NULL���� ���ϴ�����.. 
-- NULLS FIRST||LAST �ɼ��� �̿��ϸ� NULL�����ġ�� ������ �� ����
SELECT BONUS
FROM EMPLOYEE
ORDER BY BONUS NULLS LAST;

-- ORDER BY �÷��� �ε�����ȣ�� ��ü�� �� �ִ�.
SELECT * FROM EMPLOYEE;
SELECT * 
FROM EMPLOYEE
ORDER BY 6 DESC NULLS LAST, 9;

-- ���տ�����
-- �������� SELECT���� �Ѱ��� ����� ������ִ°�
-- ù��° SELECT���� �÷����� �� ���� SELECT���� �÷����� ���ƾ� ��, �� �÷��� TYPE�� ���ƾ���.
-- UNION
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE='D5'
UNION
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY>=3000000;
-- UNION ALL
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE='D5'
UNION ALL
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY>=3000000;

-- SELECT���� ������ �÷��� ���� �ٸ��� ����ȵ�!
SELECT EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE='D5'
UNION
SELECT EMP_ID, EMP_NAME, 0
FROM EMPLOYEE
WHERE SALARY>=3000000;

-- SELECT���� �÷����� ������ TYPE�� �ٸ� ���
SELECT EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE='D5'
UNION
SELECT EMP_ID, EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE SALARY>=3000000;

-- ���տ����� �ٸ����̺�� ����
SELECT EMP_ID, EMP_NAME
FROM EMPLOYEE
WHERE JOB_CODE='J5'
UNION
SELECT DEPT_ID, DEPT_TITLE
FROM DEPARTMENT
UNION
SELECT JOB_CODE,JOB_NAME
FROM JOB;

-- MINUS, INTERSECT
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE='D5'
MINUS
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY>=3000000;

SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE='D5'
INTERSECT
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY>=3000000;

-- JOIN�� ���� �˾ƺ���
-- �ΰ��̻��� ���̺��� Ư�� ���ذ����� �������ִ� ���(ROW�� ����)
-- JOIN ����
-- INNER JOIN : Ư�����ذ��� ��ġ�ϴ� ROW�� ��� -> �����Ǵ� �����Ͱ� ����
-- OUTER JOIN : �������̺��� �����ؼ� �������̺��� ���ROW�� ����ϰ��ϴ� JOIN -> �����Ǵ� �����Ͱ� ����

-- INNER JOIN�� ����غ���
-- EMPLOYEE, DEPARTMENT ���̺� �����ϱ�
SELECT * FROM EMPLOYEE;
SELECT * FROM DEPARTMENT;

SELECT EMP_NAME, DEPT_TITLE, SALARY, BONUS
FROM EMPLOYEE JOIN DEPARTMENT ON DEPT_CODE=DEPT_ID;

-- �μ��� �ѹ����� ����� ��ȸ�ϱ�
SELECT * 
FROM EMPLOYEE JOIN DEPARTMENT ON DEPT_CODE=DEPT_ID
WHERE DEPT_TITLE='�ѹ���';

-- ����� �̸�, ��å��, ���� ���ʽ��� ��ȸ�ϱ�
SELECT EMP_NAME, JOB.JOB_CODE, JOB_NAME
-- FROM EMPLOYEE E JOIN JOB J ON E.JOB_CODE=J.JOB_CODE;
FROM EMPLOYEE JOIN JOB ON EMPLOYEE.JOB_CODE=JOB.JOB_CODE;
-- FROM EMPLOYEE JOIN JOB USING(JOB_CODE);-- �����̺� ������ �̸��� �÷��� ��� ��밡��
-- USING�� ����ϸ� ���̺� ��Ī�� �ο����� ����.

-- JOIN�� ���̺� WHERE, GROUP BY, HAVING, ORDER BY ��� ����̰���

-- �μ��� �ο��� �޿� ����� ������ �μ���, �ο���, ���
SELECT DEPT_TITLE AS �μ���, COUNT(*) AS �ο���, AVG(SALARY) AS ���
FROM EMPLOYEE JOIN DEPARTMENT ON DEPT_CODE=DEPT_ID
GROUP BY DEPT_TITLE;

SELECT DEPT_CODE,COUNT(*) AS �ο���, AVG(SALARY) AS ���
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- ��å�� ������ ����� �̸�, ��å��, ��å�ڵ�, ������ ��ȸ�ϱ�
SELECT EMP_NAME,JOB_NAME, JOB_CODE, SALARY
FROM EMPLOYEE JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME='����';

-- OUTER JOIN Ȱ���ϱ�
-- �������̺� ������ �����ؼ� ������ �� ���̺��� ��� �����͸� ����ϰ� �ϴ� ��
-- �������̺��� ����
-- LEFT||RIGHT JOIN
SELECT * 
FROM EMPLOYEE LEFT OUTER JOIN DEPARTMENT ON DEPT_CODE=DEPT_ID
--FROM EMPLOYEE RIGHT OUTER JOIN DEPARTMENT ON DEPT_CODE=DEPT_ID
WHERE DEPT_TITLE IS NULL;

-- CROSS JOIN
-- ���������� ���������ʾ� ��� ROW�� ���� ������ �Ǵ� ���̺� ����
SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE CROSS JOIN DEPARTMENT
ORDER BY 1,2;

-- SELF JOIN 
-- ���������̺� �Ѱ��� ������ �ΰ��� ���̺�ó�� �����ϴ� JOIN
-- �� ���̺� ������ �����͸� ������ �÷��� �־���Ѵ�.
SELECT * FROM EMPLOYEE;
-- MANAGER�� �ִ� ����� �̸�, �����ȣ, �Ŵ��� �̸�, �Ŵ��� �����ȣ�� ��ȸ
-- MANAGER�� ���� ����� �Ŵ��� �̸��� '����' ���
SELECT E.EMP_NAME, E.EMP_ID,E.MANAGER_ID, NVL(M.EMP_NAME,'����'), M.EMP_ID
FROM EMPLOYEE E LEFT JOIN EMPLOYEE M ON E.MANAGER_ID=M.EMP_ID;

-- �������� 
-- �ΰ��̻��� ���̺� �����ؼ� ��ȸ�ϱ�
-- ����� �̸�, �μ���, ��å��, �޿�, ���ʽ��� ��ȸ�ϱ�

SELECT EMP_NAME,DEPT_TITLE, JOB_NAME, SALARY, BONUS
FROM EMPLOYEE 
    LEFT JOIN DEPARTMENT ON DEPT_CODE=DEPT_ID
    JOIN JOB USING(JOB_CODE);
    
-- ����� �����, �μ���, ��å��, �ٹ�������(LOCALNAME) ��ȸ�ϱ�

SELECT * FROM LOCATION;
SELECT * FROM DEPARTMENT;

SELECT EMP_NAME, DEPT_TITLE, JOB_NAME, LOCATION_ID, LOCAL_NAME
FROM EMPLOYEE
    LEFT JOIN DEPARTMENT ON DEPT_ID=DEPT_CODE
    LEFT JOIN LOCATION ON LOCATION_ID=LOCAL_CODE
    JOIN JOB USING(JOB_CODE);
 
-- �񵿵����� Ȱ���ϱ�
-- ������ ���� ROW�� �����ϴ� JOIN���
-- ������ ��Ÿ���� �÷��� ������ ���̺��� �־����.
SELECT * FROM SAL_GRADE;
 -- ����Ʈ�� ȸ����޼���, ������ ���� ��ǰ���¼���
 SELECT * 
 FROM EMPLOYEE 
    JOIN SAL_GRADE ON SALARY BETWEEN MIN_SAL AND MAX_SAL;
   
-- �������� -> SELECT�� �ȿ� �Ǵٸ� SELECT���� �ۼ��ϴ� ��
-- MAIN QUERY-> ���������� ���ΰ� �ִ� SELECT��
-- SUB QUERY -> MAIN QUERY���ο� �ִ� SELECT��
-- ������ ����� �Ŵ����� ������ ����ϱ�
SELECT MANAGER_ID FROM EMPLOYEE WHERE EMP_NAME='������';
SELECT * FROM EMPLOYEE WHERE EMP_ID='214';
--�������� �̿��ؼ� ó���ϱ�
SELECT *
FROM EMPLOYEE
WHERE EMP_ID=(SELECT MANAGER_ID FROM EMPLOYEE WHERE EMP_NAME='������');

-- D5�μ��� ��ձ޿����� ���� �޴� ��� ��ȸ�ϱ�
SELECT AVG(SALARY) FROM EMPLOYEE WHERE DEPT_CODE='D5';
SELECT * 
FROM EMPLOYEE
WHERE SALARY>=(SELECT AVG(SALARY) FROM EMPLOYEE WHERE DEPT_CODE='D5');

-- 1. ������ ��������
--  SELECT���� ����� 1�� �÷�, 1�� ROW���� ��
-- WHERE��, SELECT �÷��� ���� ���
-- ������� �޿� ��պ��� ���� �޿��� �޴� ����� �̸�, �޿�, �μ��ڵ� ��ȸ
SELECT EMP_NAME, SALARY, DEPT_CODE, FLOOR((SELECT AVG(SALARY) FROM EMPLOYEE)) AS ��ձ޿�
FROM EMPLOYEE
WHERE SALARY>=(SELECT AVG(SALARY) FROM EMPLOYEE);

-- �μ��� �ѹ����� ����� ��ȸ�ϱ� 
SELECT * 
FROM EMPLOYEE
WHERE DEPT_CODE=(SELECT DEPT_ID FROM DEPARTMENT WHERE DEPT_TITLE='�ѹ���');

SELECT *
FROM EMPLOYEE JOIN DEPARTMENT ON DEPT_CODE=DEPT_ID
WHERE DEPT_TITLE ='�ѹ���';


-- ������ �������� 
-- RESULT SET SELECT���� ����� �ټ� ROW�� ��µǴ� ��
-- ��å�� ����, ������ ����� ��ȸ�ϱ�
SELECT JOB_CODE FROM JOB WHERE JOB_NAME IN ('����','����');
SELECT *
FROM EMPLOYEE
WHERE JOB_CODE IN (SELECT JOB_CODE FROM JOB WHERE JOB_NAME IN('����','����'));

-- ������, �ڳ���� ���� �ٹ��ϴ� ��� ��ȸ�ϱ�
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE IN (SELECT DEPT_CODE FROM EMPLOYEE WHERE EMP_NAME IN('������','�ڳ���'));

-- �μ��� �ְ�޿��� �޴� ��� ���ϱ�
SELECT  *
FROM EMPLOYEE 
WHERE SALARY NOT IN(SELECT MAX(SALARY) FROM EMPLOYEE GROUP BY DEPT_CODE);

-- ��Һ��ϱ� 
-- ANY, ALL�Լ��� �̿��Ͽ� ó��
-- ANY : �� �ټ��� �� �ϳ��� ���̸� ��
-- �÷� >(=) ANY(���߰�) : ���߰� �� �ϳ��� �÷����� ������ �� -> ���߰��� �ּҰ����� ũ�� ��
-- �÷� <(=) ANY(���߰�) : ���߰� �� �ϳ��� �÷����� ũ�� �� -> ���߰��� �ִ밪���� ������ ��

SELECT *
FROM EMPLOYEE
--WHERE SALARY > ANY(SELECT MIN(SALARY)FROM EMPLOYEE GROUP BY DEPT_CODE);
WHERE SALARY < ANY(SELECT MIN(SALARY)FROM EMPLOYEE GROUP BY DEPT_CODE);

-- ALL : ���߰� ��ΰ� ���϶� ��
-- �÷� >(=) ALL(���߰�) : ���߰��� �ִ밪���� ũ�� ��
-- �÷� <(=) ALL(���߰�) : ���߰��� �ּҰ����� ������ ��
SELECT *
FROM EMPLOYEE
WHERE SALARY > ALL(SELECT MIN(SALARY)FROM EMPLOYEE GROUP BY DEPT_CODE);

-- 2000�� 1�� 1�� ������ �Ի��� �� 200�� 1��1�� ���� �Ի��� ��� �� �޿��� ���� ���� �޴� ������� �޿��� ���� �����ȸ�ϱ�
SELECT *
FROM EMPLOYEE
WHERE HIRE_DATE<'00/01/01'
--AND SALARY>(SELECT MAX(SALARY) FROM EMPLOYEE WHERE HIRE_DATE>'00/01/01');
AND SALARY> ALL(SELECT SALARY FROM EMPLOYEE WHERE HIRE_DATE>'00/01/01');

-- ���߿� �������� : ROW 1�� COLUMN ������
-- ������ ������� �����μ� ���� ���޿� �ش��ϴ� ��� ��ȸ�ϱ�
SELECT DEPT_CODE, JOB_CODE FROM EMPLOYEE WHERE ENT_YN='Y';

SELECT *
FROM EMPLOYEE
WHERE (DEPT_CODE, JOB_CODE) IN (SELECT DEPT_CODE, JOB_CODE FROM EMPLOYEE WHERE ENT_YN='Y');

-- ����������̸鼭 �޿��� 200������ ����� �ִٰ� �Ѵ� �� ����� ������ ��ȸ�ϱ�
SELECT *
FROM EMPLOYEE
WHERE (DEPT_CODE,SALARY) IN (SELECT DEPT_CODE, SALARY 
                            FROM EMPLOYEE JOIN DEPARTMENT ON DEPT_CODE=DEPT_ID 
                            WHERE DEPT_TITLE='���������' AND SALARY=2000000);

-- ������ ���߿�
-- �ѹ����̸鼭 300�����̻� �޿��� �޴� ���
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE 
WHERE (DEPT_CODE, SALARY) IN (SELECT DEPT_CODE, SALARY
                                FROM EMPLOYEE JOIN DEPARTMENT ON DEPT_CODE=DEPT_ID
                                WHERE DEPT_TITLE='�ѹ���' AND SALARY>=3000000);

-- �����������
-- ���������� �����Ҷ� ���������� ���� ������ ����ϰ� �����Ͽ� �������� ����� ������������ ������ �ް� ���������� �����
-- �������� ����� ������ ��ġ�Ǵ� ����

-- �� ����� ���� �μ��� �ο��� ��ȸ�ϱ�
-- ��ø �ݺ����� �����ϴ°Ͱ� ���
SELECT EMP_NAME, DEPT_CODE,(SELECT COUNT(*) FROM EMPLOYEE WHERE DEPT_CODE=E.DEPT_CODE) AS �ο���
FROM EMPLOYEE E;
SELECT COUNT(*) FROM EMPLOYEE WHERE DEPT_CODE='D9';
SELECT COUNT(*) FROM EMPLOYEE WHERE DEPT_CODE='D6';

-- �ڽ��� ���� �μ��� ��ձ޿����� �޿��� ���� �޴� ����� ��ȸ�ϱ�
SELECT * 
FROM EMPLOYEE E
WHERE SALARY > (SELECT AVG(SALARY) FROM EMPLOYEE WHERE DEPT_CODE=E.DEPT_CODE);


-- FROM���� �������� ����ϱ�
-- INLINE VIEW -> ������ ���߿� ���������� ���
-- �����÷��� �߰��� SELECT���̳� ���տ����� ����� SELEC���� INLINE VIEW�� ���� ���
-- STORED VIEW -> ����Ŭ���� �����ϴ� �ϳ��� OBJECT
-- INLINE VIEW�� 1ȸ��
-- STORED VIEW�� Ư����Ī���� INLINE VIEW�� �����ؼ� ��� -> VIEWTABLE�̶�� ��
SELECT *
FROM EMPLOYEE;
SELECT * 
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO,8,1)='2';

SELECT *
FROM (SELECT E.*,DECODE(SUBSTR(EMP_NO,8,1),'1','��','2','��') AS GENDER FROM EMPLOYEE E)
WHERE GENDER='��';

-- JOIN�� 

SELECT * 
FROM (SELECT E.*,D.*, JOB_NAME,
        (SELECT TRUNC(AVG(SALARY),-1) FROM EMPLOYEE WHERE DEPT_CODE=E.DEPT_CODE) AS DEPT_SAL,
        (SELECT COUNT(*) FROM EMPLOYEE WHERE JOB_CODE=E.JOB_CODE) AS JOB_COUNT
        FROM EMPLOYEE E LEFT JOIN DEPARTMENT D ON DEPT_CODE=DEPT_ID
        JOIN JOB J ON E.JOB_CODE=J.JOB_CODE)
WHERE DEPT_SAL>3000000 AND JOB_COUNT=4;

-- INLINE VIEW�� ���������� INLINE VIEW���� ������ �÷��� �̿��� �� ����
SELECT *
FROM  (SELECT EMP_NAME, SALARY, DEPT_CODE FROM EMPLOYEE)
WHERE DEPT_CODE='D5';

SELECT CODE, TITLE 
FROM (
    SELECT EMP_ID AS CODE, EMP_NAME AS TITLE
    FROM EMPLOYEE 
    UNION
    SELECT DEPT_ID, DEPT_TITLE
    FROM DEPARTMENT
    UNION
    SELECT JOB_CODE, JOB_NAME
    FROM JOB)
WHERE CODE LIKE '%1%';

-- �����͸� �������� ���� ����ϴ� ���� �ۼ��ϱ�
-- 2���� ���
-- 1. ����Ŭ���� �����ϴ� ROWNUM�÷��� �̿��ؼ� ���
--  SELECT���� ����Ǹ� �ڵ����� ����Ŭ �ο��ϴ� �����÷�, SELECT���� ����ɶ� ROW�� ��ȣ�� �ο��� �÷�
SELECT ROWNUM, E.*
FROM EMPLOYEE E
WHERE ROWNUM BETWEEN 1 AND 3;
-- �޿��� ���� �޴� ��� 1�� 3����� ��ȸ�ϱ�
SELECT ROWNUM, E.*
FROM EMPLOYEE E
WHERE ROWNUM BETWEEN 1 AND 3
ORDER BY SALARY;

-- ROWNUM�� ����ؼ� �������� ������ ����Ϸ��� INLINE VIEW�� �̿��ؾ��Ѵ�.
-- �߰������� ���� �����͸� ����� ���� ����!
SELECT *
FROM (
    SELECT ROWNUM AS RNUM, E.*
    FROM (SELECT * FROM EMPLOYEE ORDER BY SALARY) E
    )
WHERE RNUM BETWEEN 5 AND 10;


-- 2. ����Ŭ���� �����ϴ� WINDOW�Լ��� �̿��ؼ� ����ϴ� ���
-- RANK OVER() : 
-- DENSE_RANK OVER() : 
SELECT *
FROM (
    SELECT 
        RANK() OVER(ORDER BY SALARY DESC) AS RANK, 
        DENSE_RANK() OVER(ORDER BY SALARY DESC) AS RANK2,
        SALARY, EMP_NAME
    FROM EMPLOYEE
    );
--WHERE RANK BETWEEN 5 AND 10;

-- DDL
-- �����͸� �����ϴ� ��� ����Ŭ���� ����ϴ� ��ü�� ����, ���� �����Ҷ� ����ϴ� ��ɾ�
-- TABLE, USER, SEQUENCE, INDEX ���...
-- CREATE : ����
-- ALTER : ����
-- DROP : ����

-- CREATE TABLE -> ���̺�, ����Ҹ� �����ϴ� ��ɾ�
-- ������� �̸�,Ÿ���� ���������.
--CREATE TABLE ���̺��(
--    �÷��� �ڷ���, -> �ڹٿ��� ��������� ���
--    �÷��� �ڷ���,
--)
-- ����Ŭ �ڷ���
-- ������ : NUMBER
-- ������ : CHAR, VARCHAR2,NCHAR, NVARCHAR2
-- ��¥�� : DATE, TIMESTAMP
-- ������ �÷�������
CREATE TABLE TBL_STR(
    A CHAR(6),
    B VARCHAR2(6),
    C NCHAR(6),
    D NVARCHAR2(6)
);
SELECT * FROM TBL_STR;
INSERT INTO TBL_STR VALUES('ABC','ABC','ABC','ABC');
INSERT INTO TBL_STR VALUES('ABCDEF','ABCDEF','ABCDEF','ABCDEF');
SELECT LENGTH(A), LENGTH(B), LENGTH(C), LENGTH(D) FROM TBL_STR;
-- �ִ� 2000BYTE���� ������ ����
-- �ѱ��� 2BYTE����, EXPRESS ���� 1, �ѱ��� 3

-- �����ڷ��� : ����, �Ǽ�, ����, ��� ��� ����
-- ���
-- NUMBER
-- NUMBER(PRECISION, SCALE)
-- PRECISION : ǥ���� �� �ִ� ��ü �ڸ���(1 ~ 38)
-- SCALE : �Ҽ��� ���� �ڸ���(-84 ~ 127)
CREATE TABLE TBL_NUMBER(
    A NUMBER,
    B NUMBER(5),
    C NUMBER(5,1),
    D NUMBER(5,-1)
);
INSERT INTO TBL_NUMBER VALUES(1234.567,1234.567,1234.567,1234.567);
INSERT INTO TBL_NUMBER VALUES(123456.127,12345.127,1234.127,12345.127);

INSERT INTO TBL_NUMBER VALUES('1234.123','1234.123','1234.123','1234.123');
INSERT INTO TBL_NUMBER VALUES('1234.123��','1234.123','1234.123','1234.123');
SELECT * FROM TBL_NUMBER;

--��¥
CREATE TABLE TBL_DATE(
    DAY DATE
);

SELECT * FROM TBL_DATE;
INSERT INTO TBL_DATE VALUES('23/01/14');
INSERT INTO TBL_DATE VALUES(TO_DATE('23/01/14','RR/MM/DD'));
CREATE TABLE TBL_TIMESTAMP(
    TIMEDATE TIMESTAMP
);
INSERT INTO TBL_TIMESTAMP VALUES('99/02/24 10:14:20');
INSERT INTO TBL_TIMESTAMP VALUES(TO_TIMESTAMP('19990224101420','YYYYMMDDHH24MISS'));
SELECT * FROM TBL_TIMESTAMP;

-- ���̺� �����غ���
-- ȸ���� �����ϴ� ���̺� �����
-- ���̵�, �н�����, �̸�, ����, �������, ��ȭ��ȣ
CREATE TABLE TBL_MEMBER(
    MEMBER_ID VARCHAR2(30),
    MEMBER_PWD VARCHAR2(30),
    MEMBER_NAME VARCHAR2(15),
    MEMBER_AGE NUMBER,
    MEMBER_BIRTHDAY DATE,
    MEMBER_PHONE VARCHAR2(20)
);
SELECT * FROM TBL_MEMBER;
-- ������ ���̺��� �÷��� �����ۼ��ϱ�
COMMENT ON COLUMN TBL_MEMBER.MEMBER_ID IS 'ȸ�����̵� �ּ� 8���� �̻� �ۼ�';
SELECT * 
FROM USER_COL_COMMENTS
WHERE TABLE_NAME='TBL_MEMBER';
-- ���̺� ���� �����ۼ��ϱ�
COMMENT ON TABLE TBL_MEMBER IS 'ȸ�������������̺�';
SELECT *
FROM USER_TAB_COMMENTS;

-- ������ ���̺� �������� �����ϱ�
-- �� �÷��� ����, �÷��� ������ �����͸� ���͸��Ѵ�.
-- NOT NULL(C) : �÷��� NULL���� �������� ����
-- UNIQUE(U) : �÷��� �ߺ��Ȱ��� �������� �ʴ´�.
-- PRIMARYKEY(P) : ���̺� �� �Ѱ��� PRIMARYKEY�� ����, ���̺� ����� ������(ROW)�� �����ϴ� ������, 
--                 -> NOT NULL, UNIQUE�������Ǽ���
-- FOREIGNKEY(R) : �ٸ����̺��� �÷��� �ִ� ���� �����ϰ� ���� �ٸ����̺� ���� ���� �������� ����,
-- CHECK(C) : �÷��� ����� �����͸� ���ǿ� ���� ����(����, Ư��������)

-- �� ���̺� ������ �������� Ȯ���ϱ�
SELECT * FROM USER_CONSTRAINTS;
SELECT * FROM USER_CONS_COLUMNS;
--�ΰ��� ���̺��� �����ؼ� ������ Ȯ�� �Ѵ�.
SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, COLUMN_NAME
FROM USER_CONSTRAINTS JOIN USER_CONS_COLUMNS USING(CONSTRAINT_NAME);

-- ���̺� ���������� �����غ���
-- ���������� �����ϴ� ��� 2������ ����
-- 1. �÷��������� ����
-- �÷��� �����ϴ� �κп��� ���������� ���� ���� -> �������Ǽ����Ҷ� 
-- 2. ���̺������� ����
-- �÷������� ������ �κп��� ���������� ���� -> �ټ��� �÷��� ������ ���������� �����Ҷ�,

-- NOT NULL �������� �����ϱ�
CREATE TABLE BASIC_MEMBER(
    MEMBER_ID VARCHAR2(30),
    MEMBER_PWD VARCHAR2(30)
);
SELECT * FROM BASIC_MEMBER;
INSERT INTO BASIC_MEMBER VALUES(NULL, NULL);
-- NOT NULL���������� �÷����������� ������ ����
CREATE TABLE NN_MEMBER(
    MEMBER_ID VARCHAR2(30) NOT NULL,
    MEMBER_PWD VARCHAR2(30) NOT NULL
);
SELECT * FROM NN_MEMBER;
INSERT INTO NN_MEMBER VALUES(NULL, NULL);
INSERT INTO NN_MEMBER VALUES('ADMIN','1234');

-- UNIQUE��������
-- �÷��� �����Ͱ� ���ϰ��� �����ؾ��Ҷ� ����
CREATE TABLE UQ_MEMBER(
    MEMBER_ID VARCHAR2(30) UNIQUE,
    MEMBER_PWD VARCHAR2(30)
);
INSERT INTO BASIC_MEMBER VALUES('ADMIN', '1234');
SELECT * FROM BASIC_MEMBER;
INSERT INTO UQ_MEMBER VALUES('ADMIN1','1234');
SELECT * FROM UQ_MEMBER;

-- UNIQUE�������� ���̺� �������� �����ϱ�
CREATE TABLE UQ_MEMBER2(
    MEMBER_ID VARCHAR2(30),
    MEMBER_PWD VARCHAR2(30),
    UNIQUE(MEMBER_ID)
);
SELECT * FROM UQ_MEMBER2;
INSERT INTO UQ_MEMBER2 VALUES('ADMIN','1234');
-- �ΰ��̻��� �÷��� ���� UNIQUE���������� ������ �� �ִ�.
CREATE TABLE UQ_MEMBER3(
    MEMBER_ID VARCHAR2(30) UNIQUE,
    MEMBER_PWD VARCHAR2(30),
    MEMBER_NAME VARCHAR2(20) UNIQUE,
    UNIQUE(MEMBER_ID,MEMBER_NAME)
);
SELECT * FROM UQ_MEMBER3;
INSERT INTO UQ_MEMBER3 VALUES('ADMIN','1234','������');
INSERT INTO UQ_MEMBER3 VALUES('USER','1234','������');

-- ������ ���̺� PRIMARY KEY(PK)�����ϱ�
-- PRIMARY KEY�� ����� �÷��� ���� ���� -> IDX, NO 
-- SEQUENCE�� �̿��ؼ� ���� ��������.
CREATE TABLE PK_MEMBER(
    MEMBER_NO NUMBER PRIMARY KEY,
    MEMBER_ID VARCHAR2(30),
    MEMBER_PWD VARCHAR2(30),
    MEMBER_NAME VARCHAR2(20)
);
INSERT INTO PK_MEMBER VALUES(1, 'ADMIN','1234','������');
INSERT INTO PK_MEMBER VALUES(2, 'USER','1234','����');
INSERT INTO PK_MEMBER VALUES(1, 'USER1','1111','����1');
INSERT INTO PK_MEMBER VALUES(NULL, 'USER1','1111','����1');
SELECT * FROM PK_MEMBER;

-- �����÷��� PRIMARY KEY�� �����ϱ�
-- ����Ű

CREATE TABLE PK_MEMBER2(
    MEMBER_NO NUMBER,
    MEMBER_ID VARCHAR2(30),
    MEMBER_PWD VARCHAR2(30),
    MEMBER_NAME VARCHAR2(20),
    PRIMARY KEY(MEMBER_NO, MEMBER_ID)    
);
SELECT * FROM PK_MEMBER2;
INSERT INTO PK_MEMBER2 VALUES(1, 'ADMIN','1234','������');
INSERT INTO PK_MEMBER2 VALUES(2, 'ADMIN','1234','������');
INSERT INTO PK_MEMBER2 VALUES(NULL, 'ADMIN','1234','������');
INSERT INTO PK_MEMBER2 VALUES(3, NULL,'1234','������');
INSERT INTO PK_MEMBER2 VALUES(2, 'ADMIN','1234','������');
INSERT INTO PK_MEMBER2 VALUES(2, 'USER','1234','������');


-- ��ٱ��� 
CREATE TABLE CART(
    MEMBER_ID VARCHAR2(20),
    PRODUCNT_NO NUMBER,
    DAY DATE, 
    STOCK NUMBER,
    PRIMARY KEY(MEMBER_ID, PRODUCT_NO,DAY)
);

-- FOREIGN KEY�������� �����ϱ�
-- �ٸ����̺��� �����͸� ������ �����ϴ°� -> ����
-- �ٸ����̺� ���� ���� ������ �� �����ϴ� ��
-- �Խñ�, ��� || �Խñ�, ÷������ || �繰��, ȸ�� || �а�, �л�|| ���, �μ�
CREATE TABLE BOARD(
    BOARD_NO NUMBER PRIMARY KEY,
    BOARD_TITLE VARCHAR2(200) NOT NULL,
    BOARD_CONTENT VARCHAR2(2000),
    BOARD_WRITER VARCHAR2(20) NOT NULL,
    BOARD_DATE DATE
);
SELECT * FROM BOARD;

CREATE TABLE BOARD_COMMENT(
    BOARD_COMMENT_NO NUMBER PRIMARY KEY,
    BOARD_COMMENT_CONTENT VARCHAR2(800) NOT NULL,
    BOARD_COMMENT_DATE DATE,
    BOARD_REF NUMBER REFERENCES BOARD(BOARD_NO)
);
-- DROP TABLE BOARD_COMMENT;
INSERT INTO BOARD VALUES(1, 'ù��°�Խñ�','���� ù �Խñ�','ADMIN',SYSDATE);
INSERT INTO BOARD VALUES(2, '��°�Խñ�','���� �� �Խñ�','ADMIN',SYSDATE);
SELECT * FROM BOARD;
INSERT INTO BOARD_COMMENT VALUES(1,'ù�Խñ� ������',SYSDATE,1);
INSERT INTO BOARD_COMMENT VALUES(2,'ù�Խñ� ������2',SYSDATE,1);
INSERT INTO BOARD_COMMENT VALUES(3,'ù�Խñ� ������2',SYSDATE,2);
INSERT INTO BOARD_COMMENT VALUES(4,'ù�Խñ� ������3',SYSDATE,2);
SELECT * FROM BOARD_COMMENT;
-- ���� �÷��� �Ѱ��� ����!

SELECT * FROM BOARD WHERE BOARD_NO=1;
SELECT * FROM BOARD_COMMENT WHERE BOARD_REF=1;
SELECT * FROM BOARD JOIN BOARD_COMMENT ON BOARD_NO=BOARD_REF
WHERE BOARD_NO=1;

-- UNIQUE�������� ������ �÷��� NULL�� �ֱ� -> NULL���� �ߺ�üũ ���Ѵ�.
-- UNIQUE���������� ������ �÷��� NOT NULL�������Ǳ��� ������ �ؾ��Ѵ�. 
SELECT * FROM UQ_MEMBER;
INSERT INTO UQ_MEMBER VALUES(NULL,'4444');

CREATE TABLE UQ_MEMBER4 (
    MEMBER_ID VARCHAR2(30) UNIQUE NOT NULL,-- �Ѱ� �÷��� ���� �������ǵ� ������ �����ϴ�.
    MEMBER_PWD VARCHAR2(30) NOT NULL
);

INSERT INTO UQ_MEMBER4 VALUES(NULL, '1234');
INSERT INTO UQ_MEMBER4 VALUES('ADMIN', '1234');
INSERT INTO UQ_MEMBER4 VALUES('ADMIN', '1234');

-- FK���� ������ ���������� NULL�� - NOT NULL���������� �߰��� ����
-- NULLABLE�� �Ǿ� ������ ����
-- NOT NULL�� �Ǿ� ������ �ʼ�
INSERT INTO BOARD_COMMENT VALUES(5,'NULL��',SYSDATE, NULL);
SELECT * FROM BOARD_COMMENT;

-- ���̺��� FK���谡 �ִ� ��� ROW�����Ҷ� �����ؾ� �Ѵ�.
-- FK�����ϸ� �ΰ��� ���̺��� �θ�, �ڽ� ����� ������ �ȴ�.
-- �θ����̺� �ִ� ROW�� �Ժη� ������ �� ����. * �����ϴ� �ڽ����̺��� ROW�� �ִ� ���!!!
CREATE TABLE FK_PRODUCT(
  PRODUCT_NO NUMBER PRIMARY KEY,
  PRODUCT_NAME VARCHAR2(200) NOT NULL,
  PRICE NUMBER
);
SELECT * FROM FK_PRODUCT;
INSERT INTO FK_PRODUCT VALUES(1, '��Ʈ��',3000000);
INSERT INTO FK_PRODUCT VALUES(2, 'Ű����',500000);
INSERT INTO FK_PRODUCT VALUES(3, '���콺',70000);
-- FK�� �ٸ� ���̺��� �÷����� �����Ҷ��� �ݵ�� ���� ����÷��� �ߺ����� ������ �ȵ�. -> UNIQUE, PRIMARY KEY �������Ǽ����ؾ���.

CREATE TABLE FK_BUY(
    BUY_NO NUMBER PRIMARY KEY,
    MEMBER_ID VARCHAR2(20) REFERENCES UQ_MEMBER4(MEMBER_ID),
    PRODUCT_NO NUMBER REFERENCES FK_PRODUCT(PRODUCT_NO) 
);
DROP TABLE FK_BUY;
INSERT INTO FK_BUY VALUES(1, 'ADMIN',1);
INSERT INTO FK_BUY VALUES(2, 'ADMIN',2);
SELECT * FROM FK_BUY;
DELETE FROM FK_PRODUCT WHERE PRODUCT_NO=3;
-- �������迡 �ִ� �θ����̺� ������ �ɼ��� ����� �� �ִ�.
-- ON DELETE CASCADE||SET NULL 
-- CASCADE : �θ����Ͱ� �������� �ڽĵ����͵� ���� ����
-- SET NULL : �����÷��� NULL�� ����! * FK������ NOT NULL���������� �����Ǹ� �ȵ�!
CREATE TABLE FK_BUY(
    BUY_NO NUMBER PRIMARY KEY,
    MEMBER_ID VARCHAR2(20) REFERENCES UQ_MEMBER4(MEMBER_ID),
    --PRODUCT_NO NUMBER REFERENCES FK_PRODUCT(PRODUCT_NO) ON DELETE CASCADE
    PRODUCT_NO NUMBER NOT NULL, --REFERENCES FK_PRODUCT(PRODUCT_NO) ON DELETE SET NULL,
    FOREIGN KEY(PRODUCT_NO) REFERENCES FK_PRODUCT(PRODUCT_NO)
);
DROP TABLE FK_BUY;
INSERT INTO FK_BUY VALUES(1, 'ADMIN',2);
INSERT INTO FK_BUY VALUES(2, 'ADMIN',3);
SELECT * FROM FK_BUY;
DELETE FROM FK_PRODUCT WHERE PRODUCT_NO=3;


-- CHECK �������� �����ϱ�
-- �÷��� ������ �� �ִ� �����͸� ����
CREATE TABLE CK_MEMBER(
    MEMBER_ID VARCHAR2(20),
    MEMBER_PWD VARCHAR2(20),
    GENDER VARCHAR2(5)CHECK(GENDER IN ('��','��')) NOT NULL,
    AGE NUMBER CHECK(AGE > 0)
);
SELECT * FROM CK_MEMBER;
INSERT INTO CK_MEMBER VALUES('AMDIN','1234','��',19);
INSERT INTO CK_MEMBER VALUES('AMDIN','1234','��',19);
INSERT INTO CK_MEMBER VALUES('AMDIN','1234','��',-19);
INSERT INTO CK_MEMBER VALUES('AMDIN','1234','��',NULL);

-- �÷��� DEFAULT���� ������ �� ����
CREATE TABLE TBL_DEFAULT(
    TEST_NO NUMBER PRIMARY KEY,
    TEST_DATE DATE DEFAULT SYSDATE,
    TEST_LEVEL VARCHAR2(20) DEFAULT '����'
);
INSERT INTO TBL_DEFAULT VALUES(1, DEFAULT, DEFAULT);
SELECT * FROM TBL_DEFAULT;
INSERT INTO TBL_DEFAULT(TEST_NO) VALUES(2);

SELECT * FROM USER_CONSTRAINTS;
-- ���������� �����Ҷ� �̸��� ������ �� �ִ�.
-- �̸��������������� SYS_0000 ����Ŭ�� �ڵ����� �������Ǹ��� ����
CREATE TABLE CONS_NAME(
    TEST_NO NUMBER CONSTRAINT PK_CONSNAME_TESTNO PRIMARY KEY,
    TEST_NAME VARCHAR2(20) CONSTRAINT NN_TESTNAME NOT NULL
);
SELECT * FROM USER_CONSTRAINTS
WHERE TABLE_NAME='CONS_NAME';

-- ���̺��� �����Ҷ� ���������� �̿��� �� ����
-- �������̺� �ִ� ���̺��� ����
CREATE TABLE EMP_COPY
AS SELECT * FROM EMPLOYEE;

SELECT * FROM EMP_COPY;
SELECT * FROM EMPLOYEE;

-- JOIN, UNION,���������� �̿��� RESULT SET�� ������ ������� ����

CREATE TABLE EMP_ALL_COPY
AS SELECT * FROM EMPLOYEE 
            JOIN DEPARTMENT ON DEPT_CODE= DEPT_ID 
            JOIN JOB USING(JOB_CODE);
SELECT * FROM EMP_ALL_COPY;
-- ���������� ������ ���̺��� NOT NULL�������� �̿��� ������ ���������� �����Ѵ�.
-- �ʿ��� ���������� �߰��� ������ �ؾ��Ѵ�.

-- �÷��� �����Ͽ� ���ο� ���̺��� �����Ϸ���
-- ���������� ������ ��� FALSE�� ����� �ȴ�.
CREATE TABLE COLUMN_COPY
AS SELECT * FROM EMPLOYEE WHERE 1=0;
SELECT * FROM COLUMN_COPY;


-- DML�� ���� �˾ƺ���
-- INSERT �� Ȱ���ϱ�
-- INERT�� ���̺� �Ѱ� ������(ROW) �߰��ϴ� ��ɾ�
-- �ѹ��� �Ѱ��� �����͸� ������ ����
-- ���
-- 1. ��ü�÷��� ���� ���� �����ϴ°�
-- 2. ���Կ��ϴ� �÷��� �����Ͽ� �����ϴ°� * �������� ���� �÷��� NULL�� �Ǵ� DEFAULT�� ����, 
--     **���������������� NOT NULL���������� �����Ǿ������� ������ �Ұ�����.
CREATE TABLE TEMP_DEPT
AS SELECT * FROM DEPARTMENT WHERE 1=0;
SELECT * FROM TEMP_DEPT;
-- �⺻ INSERT ��
-- INSERT INTO ���̺�� [(�÷���, �÷���......)] VALUES(��, ��, ��......)
INSERT INTO TEMP_DEPT VALUES('D1','�ڹ��к�','L1');
DESC TEMP_DEPT;
SELECT * FROM TEMP_DEPT;
INSERT INTO TEMP_DEPT VALUES('D1','�ڹ��к�');
INSERT INTO TEMP_DEPT VALUES('D1','�ڹ��к�','1',2,3);

-- �÷��� �����ؼ� �� �ֱ�
-- ������������ �÷��� NOT NULL���������� �����Ǿ� ������ INSERT���� ������ �� ����.
INSERT INTO TEMP_DEPT (DEPT_ID,DEPT_TITLE) VALUES('D2','�ް����͵�');-- LOCATION_ID��NOT NULL���������� �����Ǽ� �Ұ���
INSERT INTO TEMP_DEPT(DEPT_ID,LOCATION_ID) VALUES('D2','L2');-- ���� DEPT_TITLE�� NULLABLE�̱� ������
DESC TEMP_DEPT;
SELECT * FROM TEMP_DEPT;

-- ������������ �÷��� NOTNULL���������� �����Ǿ��ִ��� DEFAULT���� �����Ǿ��ִٸ�
-- ������ �����ϴ�.
CREATE TABLE TEST_TAB(
    TEST_NAME VARCHAR2(20) DEFAULT '����' NOT NULL,
    TEST_NUM NUMBER
);
INSERT INTO TEST_TAB (TEST_NUM) VALUES(100);
SELECT * FROM TEST_TAB;

-- ���������� �̿��ؼ� INSERT�ϱ�
CREATE TABLE INSERT_SUB
AS SELECT EMP_ID, EMP_NAME, DEPT_TITLE
    FROM EMPLOYEE JOIN DEPARTMENT ON DEPT_CODE=DEPT_ID WHERE 1=0;
    
SELECT * FROM INSERT_SUB;
INSERT INTO INSERT_SUB(SELECT EMP_ID, EMP_NAME,DEPT_TITLE
                        FROM EMPLOYEE JOIN DEPARTMENT ON DEPT_CODE=DEPT_ID
                        WHERE DEPT_CODE='D5');
INSERT INTO INSERT_SUB(SELECT EMP_ID, EMP_NAME, DEPT_TITLE
                            FROM EMPLOYEE JOIN DEPARTMENT ON DEPT_CODE=DEPT_ID
                            WHERE JOB_CODE='J2');
SELECT * FROM INSERT_SUB;               

INSERT INTO INSERT_SUB(EMP_ID, EMP_NAME)(SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE DEPT_CODE='D9');

-- INSERT ALL
-- ���������� �̿��ؼ� �ΰ��̻��� ���̺� �����͸� �����ϴ� ��ɾ�
CREATE TABLE EMP_HIRE_DATE
AS SELECT EMP_ID, EMP_NAME, HIRE_DATE FROM EMPLOYEE;
DELETE FROM EMP_HIRE_DATE;
CREATE TABLE EMP_MANAGER
AS SELECT EMP_ID, EMP_NAME, MANAGER_ID FROM EMPLOYEE WHERE 1=0;
SELECT * FROM EMP_HIRE_DATE;
SELECT * FROM EMP_MANAGER;

INSERT ALL
INTO EMP_HIRE_DATE VALUES(EMP_ID,EMP_NAME,HIRE_DATE)
INTO EMP_MANAGER VALUES(EMP_ID, EMP_NAME,MANAGER_ID)
SELECT EMP_ID, EMP_NAME, HIRE_DATE, MANAGER_ID
FROM EMPLOYEE;

-- INSERT ALL�� �̿��ؼ� ���̺� ���� ������ ���ǿ� ���缭 �ֱ�
CREATE TABLE EMP_OLD
AS SELECT EMP_ID,EMP_NAME, HIRE_DATE FROM EMPLOYEE WHERE 1=0;
CREATE TABLE EMP_NEW
AS SELECT EMP_ID,EMP_NAME, HIRE_DATE FROM EMPLOYEE WHERE 1=0;
-- EMP_OLD���̺� 00��01��01�� ���� �Ի��� ������� �����͸� ����
-- EMP_NEW���̺� 00��01��01�� ���Ŀ� �Ի��� ������� �����͸� ����
INSERT ALL
    WHEN '00/01/01'>HIRE_DATE THEN INTO EMP_OLD VALUES(EMP_ID, EMP_NAME, HIRE_DATE)
    WHEN '00/01/01'<=HIRE_DATE THEN INTO EMP_NEW VALUES(EMP_ID, EMP_NAME, HIRE_DATE)
SELECT EMP_ID, EMP_NAME, HIRE_DATE
FROM EMPLOYEE;
SELECT * FROM EMP_OLD;
SELECT * FROM EMP_NEW;

-- UPDATE Ȱ���ϱ�
-- UPDATE ���̺�� SET �÷���=��, �÷���=��..... [WHERE ���ǽ�]
-- WHERE ���� ������ WHERE���� ������ TRUE�Ǵ� ROW�� �����ϰ�
-- WHERE ���� ������ ���̺� ��ü ROW�� �����Ѵ�.
CREATE TABLE EMP_SALARY
AS SELECT  EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, SALARY, BONUS
FROM EMPLOYEE;
SELECT * FROM EMP_SALARY;
-- WHERE�� ���� UPDATE�� �����ϱ�
-- SALARY 300�������� �����ϱ�
UPDATE EMP_SALARY SET SALARY=3000000;
ROLLBACK;--Ʈ������
-- BONUS�� ���� ����� ���ʽ����� 0.2�� �����ϱ�
UPDATE EMP_SALARY SET BONUS=0.2 WHERE BONUS IS NULL;
SELECT * FROM EMP_SALARY;
-- ������ �޿��� 300����, ���ʽ��� 0.3���� �����ϱ�
UPDATE EMP_SALARY SET BONUS=0.3, SALARY=3000000 WHERE EMP_NAME='����';
SELECT * FROM EMP_SALARY;

-- �������� ���� ����� �޿��� ���� �޿����� 50����, ���ʽ��� 0.3 �÷�����
UPDATE EMP_SALARY SET SALARY=SALARY+500000, BONUS=BONUS+0.3 WHERE EMP_NAME LIKE '��%';
SELECT * FROM EMP_SALARY;

-- �ڽ��� ���� �μ��� ��� �޿��� �޿��� �����ϱ�
UPDATE EMP_SALARY SET SALARY=(SELECT FLOOR(AVG(SALARY)) FROM EMPLOYEE WHERE EMP_SALARY.DEPT_CODE=DEPT_CODE);

-- ���������� �̿��ؼ� UPDATE�ϱ�
-- �ΰ��÷� �����ϱ�
UPDATE EMP_SALARY SET (SALARY, BONUS) = (SELECT SALARY,BONUS FROM EMPLOYEE WHERE EMP_ID=200) 
WHERE DEPT_CODE IS NULL;
SELECT * FROM EMP_SALARY;

-- UPDATE ������ �Լ� ����ϱ�
UPDATE EMP_SALARY SET SALARY=LENGTH('ASDLFKJASDLFKJASDFLKJ');
SELECT * FROM EMP_SALARY;

-- DELETE�� Ȱ���ϱ�
-- ���̺��� ROW�� �����ϴ� ��ɾ�
-- DELETE FROM ���̺�� [WHERE ���ǽ�]
DELETE FROM EMP_SALARY WHERE DEPT_CODE='D2';
DELETE FROM EMP_SALARY;

ROLLBACK;
SELECT * FROM EMP_SALARY;

-- TRUNCATE 
-- ���̺� �ִ� �����͸� �����ϴ� ���� ��ü���� �ӵ��� ����
-- ������ �Ұ�����.
TRUNCATE TABLE EMP_SALARY;
SELECT * FROM EMP_SALARY;
ROLLBACK;

-- Ʈ������ó���ϴ� ��ɾ�
-- Ʈ������ : �Ѱ��� �۾�����, �����͸� �����ϴ� �۾��� ����
-- �Ѱ� ���񽺿��� �����͸� ����(����,����,����)�ϴ� ��ɾ �������̸� ������ ������Ѵ�.
-- ����, ������� ������ �� �ִ�, -> COMMIT, ROLLBACK���� ��.
-- ���ݱ����� �۾��� �����Ϸ��� COMMIT�� ����
-- ���ݱ����� �۾��� ��� ����Ϸ��� ROLLBACK
-- �۾� -> DML - INSERT, UPDATE, DELETE�� ����̴�.
SELECT * FROM TEMP_DEPT;
INSERT INTO TEMP_DEPT VALUES('D3','COMMIT��','L4');
COMMIT;

-- ALTER, DROP ��ɾ� ����ϱ�
-- ������Ʈ�� ����/ �����ϴ� ��ɾ�
-- ALTER TABLE : TABLE�� ���ǵǾ��ִ� ������ ������ �� ���
-- �÷�, ���������� ������ �� �ִ�.

CREATE TABLE TBL_USERALTER(
    USER_NO NUMBER PRIMARY KEY,
    USER_ID VARCHAR2(20),
    USER_PWD VARCHAR2(20)
);

SELECT * FROM TBL_USERALTER;
-- ���̺� �÷� �߰��ϱ�
-- ALTER TABLE ���̺�� ADD( �÷������(�÷��� Ÿ�� ��������) )
ALTER TABLE TBL_USERALTER ADD(USER_NAME VARCHAR2(20));
INSERT INTO TBL_USERALTER VALUES(1,'ADMIN','1234','������');
COMMIT;
SELECT * FROM TBL_USERALTER;
-- �������̺� �����Ͱ� ������ �÷��� �߰��غ���.
ALTER TABLE TBL_USERALTER ADD(EMAIL VARCHAR2(50));
-- �������̺� �����Ͱ� ������ �߰��Ǵ� �÷��� NOT NULL���������� �����ϸ� ������ �߻���.
-- NOT NULL���������� �����Ϸ��� DEFAULT�� �����ϸ� ��.
ALTER TABLE TBL_USERALTER ADD(NICKNAME VARCHAR2(20) DEFAULT '�̼���' NOT NULL);

-- �÷� �����ϱ�
DESC TBL_USERALTER;
-- ALTER TABLE ���̺�� MODIFY ������ �÷��� �ڷ���
ALTER TABLE TBL_USERALTER MODIFY USER_ID VARCHAR2(30);
SELECT * FROM TBL_USERALTER;
ALTER TABLE TBL_USERALTER MODIFY USER_NAME VARCHAR2(5);

-- �÷������ϱ�
-- ALTER TABLE ���̺�� DROP COLUMN �÷���
ALTER TABLE TBL_USERALTER DROP COLUMN NICKNAME;
SELECT * FROM TBL_USERALTER;

-- �������� �߰�
-- ALTER TABLE ���̺�� ADD CONSTRAINT �������Ǹ� ��������
ALTER TABLE TBL_USERALTER ADD CONSTRAINT UQ_USERID UNIQUE(USER_ID);
INSERT INTO TBL_USERALTER VALUES(2,'ADMIN','1111','����','USER@USER');


-- �������� ����
-- �����ϴ� �������Ǹ��� �˾ƾ��Ѵ�.
-- ������ �÷��� ��� NULLABLE������ �Ǿ������Ƿ� NOT NULL�������� �߰��ÿ���
-- MODIFY�� �ؾ��Ѵ�.
ALTER TABLE TBL_USERALTER
MODIFY USER_PWD CONSTRAINT UQ_USER_PWD NOT NULL;

-- �������� �����ϱ�
ALTER TABLE TBL_USERALTER
DROP CONSTRAINT UQ_USER_PWD;
DESC TBL_USERALTER;

-- �÷��� �����ϱ� 
ALTER TABLE TBL_USERALTER RENAME COLUMN EMAIL TO USER_EMAIL;
SELECT * FROM TBL_USERALTER;
-- �������Ǹ� �����ϱ�
ALTER TABLE TBL_USERALTER RENAME CONSTRAINT SYS_C007731 TO PK_USERID;

-- ���̺� �� �����ϱ�
RENAME TBL_USERALTER TO TBL_USER;
SELECT * FROM TBL_USERALER;
SELECT * FROM TBL_USER;

-- ���̺� �����ϱ�
DROP TABLE TBL_USER;
SELECT * FROM TBL_USER;
-- ���̺� ������ FK�� ����� ���̺��� ������ �Ұ�����.
SELECT * FROM EMP_COPY;
-- EMP_ID�� �÷��� PK�����ϱ�
ALTER TABLE EMP_COPY ADD CONSTRAINT PK_EMP_ID PRIMARY KEY(EMP_ID);

CREATE TABLE TEST_FKTBL(
    EMP_ID VARCHAR2(20) REFERENCES EMP_COPY(EMP_ID),
    CONTENT VARCHAR2(500)
);

INSERT INTO TEST_FKTBL VALUES(200,'�ϳ�');
INSERT INTO TEST_FKTBL VALUES(201,'��');
INSERT INTO TEST_FKTBL VALUES(202,'��');
INSERT INTO TEST_FKTBL VALUES(203,'��');
SELECT * FROM TEST_FKTBL;

DROP TABLE EMP_COPY;

-- ���������� ������ ���̺� �����Ҷ��� �ɼ��� �����Ͽ� ���� �� ����
DROP TABLE EMP_COPY CASCADE CONSTRAINT;

-- ����Ŭ�� �����ϴ� ������Ʈ�� ���� �˾ƺ���.
-- VIEW, SEQUENCE
-- VIEW ������ ���̺� ���� �������� �ʴ� ���̺�
-- RESULT SET(SELECT��)���� ���� ���̺� -> �������̺� ������� �����Ѵ�.
-- VIEW -> �������� �����÷��� ����ϴ� ���̺� �̿��Ҷ� 
-- JOIN, UNION,UNION ALL, �׷��Լ��� ����� SELECT��
-- �����ϴ� ���
-- CREATE VIEW VIW�̸� 
-- AS SELECT��....
-- VIEW���̺��� �����Ϸ��� ������ ���������� �ʿ���. 
CREATE VIEW V_EMP_DEPT
AS SELECT * FROM EMPLOYEE JOIN DEPARTMENT ON DEPT_CODE=DEPT_ID;

-- BS������ VIEW�������� �ο��ϱ�
GRANT CREATE VIEW TO BS;

SELECT *
FROM V_EMP_DEPT;

SELECT EMP_NAME, DEPT_TITLE, SALARY
FROM V_EMP_DEPT;

--�� �оߺ� ������ ���
SELECT DEPT_CODE, FLOOR(AVG(SALARY)) FROM EMPLOYEE GROUP BY DEPT_CODE;
SELECT JOB_CODE, FLOOR(AVG(SALARY)) FROM EMPLOYEE GROUP BY JOB_CODE;

CREATE VIEW V_AVG_TYPE
AS
SELECT DEPT_CODE AS TYPE, FLOOR(AVG(SALARY)) AS AVG_SAL FROM EMPLOYEE GROUP BY DEPT_CODE
UNION
SELECT JOB_CODE, FLOOR(AVG(SALARY)) FROM EMPLOYEE GROUP BY JOB_CODE;

SELECT * FROM V_AVG_TYPE;

-- 1. VIEW���̺� �����ÿ� ������ �÷��� ����� �� ����
SELECT AVG_SAL FROM V_AVG_TYPE;
-- 2. VIEW���̺��� �����͸� ��ȸ�ϱ� �뵵�� DML������ VIEW���̺�� �Ϲ������� �����������


--������ VIEW���̺� ��ȸ�ϱ�
SELECT * FROM USER_VIEWS;


-- SEQUENCE �̿��ϱ�
-- ����Ŭ���� �����ϴ� �ڵ���ȣ �߻���
-- 1. SEQUENCE�� �����ϱ�
-- 2. ������ SEQUENCE�� ������ ��ȣ�� �����ϰ� �����´�.
--   NEXTVAL, CURRVAL
-- PK�� �����ϴ� �÷��� ���
-- �⺻ SEQUENCE �����ϱ�
CREATE SEQUENCE SEQ_BASIC; -- �⺻������ �������� 1���� 1�������ϴ� ��ȣ�� ��������
SELECT SEQ_BASIC.NEXTVAL FROM DUAL;
SELECT * FROM BOARD;
INSERT INTO BOARD VALUES(SEQ_BASIC.NEXTVAL,'�׹�° ��', '���� ����° ��','ADMIN',SYSDATE);

-- ����߱޵� ��ȣ�� Ȯ��
SELECT SEQ_BASIC.CURRVAL FROM DUAL;

-- �ɼ��� �����ؼ� ������ �� �ִ�.
-- START WITH ���� : ������ȣ�� ������ ���ں��� ���� DEFAULT 1
-- INCREMENT BY ���� : ��ȣ ���� ���� DEFAULT 1
-- MAXVALUE : ������ȣ�� �ִ밪
-- MINVALUE : ������ȣ�� �ּҰ�
-- CYCLE/NOCYCLE : ��ȣ�� ��Ȱ���� ���� *MAXVALUE, MINVALUE�� �־����.
-- CACHE : �̸� ��ȣ�� ������ ���°� * �ӵ� DEFAULT 20
CREATE SEQUENCE SEQ_01
START WITH 100
INCREMENT BY 5;
SELECT SEQ_01.NEXTVAL FROM DUAL;

CREATE SEQUENCE SEQ_02
START WITH 100
INCREMENT BY 10
MAXVALUE 200;
SELECT SEQ_02.NEXTVAL FROM DUAL;
CREATE SEQUENCE SEQ_03
START WITH 100
INCREMENT BY -20
MAXVALUE 200
MINVALUE 0;
SELECT SEQ_03.NEXTVAL FROM DUAL;
CREATE SEQUENCE SEQ_04
START WITH 100
INCREMENT BY -20
MAXVALUE 200
MINVALUE 0
CYCLE
NOCACHE;
SELECT SEQ_04.NEXTVAL FROM DUAL;

SELECT * FROM USER_SEQUENCES;

-- 1. CURRVAL ����� ���� SESSION���� NEXTVAL�� �ѹ��̶� ������ �ؾ��Ѵ�.
CREATE SEQUENCE SEQ_TEST;
SELECT SEQ_TEST.NEXTVAL FROM DUAL;
SELECT SEQ_TEST.CURRVAL FROM DUAL;
-- 2. PK p_1, P_001
SELECT 'P_'||SEQ_TEST.NEXTVAL FROM DUAL;
SELECT 'P_'||TRIM(TO_CHAR(SEQ_TEST.NEXTVAL,'000')) FROM DUAL;


-- ������ ���� 
-- ROW�� ������ ���缭 ������� �������� ��
SELECT LEVEL, EMP_ID, EMP_NAME, MANAGER_ID
FROM EMPLOYEE
    START WITH EMP_ID=200
    CONNECT BY PRIOR EMP_ID=MANAGER_ID;
    
SELECT LEVEL||' '||LPAD(' ',(LEVEL-1)*5,' ')||EMP_NAME||NVL2(MANAGER_ID,'('||MANAGER_ID||')','') AS ������
FROM EMPLOYEE
    START WITH EMP_ID=200
    CONNECT BY PRIOR EMP_ID=MANAGER_ID;
    
-- PL/SQL, FUNCTION, PROCEDURE, TRIGGER



























                






























































    
























































































