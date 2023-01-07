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



































