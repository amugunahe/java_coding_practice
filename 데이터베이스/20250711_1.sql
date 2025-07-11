---------------------------------VIEW-----------------------------------
/* VIEW
? ? ? ? ���ٶ� �ǹ̸� ���� �ִ�.
? ? ? ? ���� ���̺� (�������̺�)�� ����� �����͸� �並 ���ؼ� �� �� �ֵ����Ѵ�.
? ? ? ??
? ? ? ? ��� �������̺� �̴� ���� ���̺�� ���� �����ϰ� �����
? ? ? ??
? ? ? ? ���� ��� ����
? ? ? ? 1. �������� ���̺� ������ �����ϱ� ���� ����Ѵ�.
? ? ? ? 2. ������ ���Ǹ� ���� ����� ���ؼ� ����Ѵ�.
? ? ? ??
? ? ? ? ���� Ư¡
? ? ? ? ��� ���̺� ���� ������ ������ ���̺��� ������ �κи� ���� �� �ִ� ������ ���̺��̴�.
? ? ? ??
? ? ? ? ��� ���� �ڷḦ ������ ������, �並 ���ؼ� ���̺��� ������ �� �ִ�.
? ? ? ? �ϳ��� ���̺� ���� ������ ������ ����.?
? ? ? ??
? ? ? ? �⺻ ���̺�
? ? ? ? �信 ���� ���������� �����ؼ� ����ϴ� ���������� �����͸� �����ϰ� �ִ�
? ? ? ? �������� ���̺��� ����
*/

DESC EMP01;
CREATE VIEW VIEW_EMP10
AS SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP01 WHERE DEPTNO = 10;

DROP VIEW VIEW_EMP10;
DROP TABLE EMP01;

CREATE TABLE EMP01 AS SELECT * FROM EMP;
SELECT * FROM EMP01;


SELECT EMPNO, ENAME, SAL, DEPTNO FROM EMP01 WHERE DEPTNO=10;


/* �� ����
?��� ���̺�ó�� �ϳ��� ��ü�μ� ���̺��� ������ �� �����ϰ� CREATE VIEW ������� �����Ѵ�.
?
?CREATE [OR REPLACE][FORCE]][NOFORCE]VIEW VIEW_NAME
?AS SUBQUERY
?WITH CHECK OPTION
?WITH READ ONLY: -- ��ȸ(SELECT)�� ������ (INSERT/UPDATE/DELETE) ����� ��� �Ұ�
?
?[OR REPALCE]
?- ���ο� �並 ���� �� ���� �Ӹ� �ƴ϶� ������ �䰡 �����ϴ��� �������� �ʰ�?
?���ο� ������ ��� ������ �� �ִ�.?
?
?[FORCE][NOFORCE]
?- �⺻ ���̺��� ���� ���ο� �󱢾��� �並 �����Ѵ�.
?WITH CHECK OPTION?
?- �ش� �並 ���ؼ� �� �� �ִ� ���� �������� UPDATE �Ǵ� INSERT�� ������
*/

CREATE VIEW VIEW_EMP01
AS?
SELECT EMPNO, ENAME, SAL, DEPTNO
FROM EMP01
WHERE DEPTNO=10;

SELECT * FROM VIEW_EMP01; -- VIEW_EMP10�� �ƴ϶� VIEW_EMP01�� ��ȸ�ϵ��� �����ߴ�.

-- �並 �ۼ��� �� ����� ������������ ��� �ۼ��Ǿ��ִ����� Ȯ����
SELECT VIEW_NAME, TEXT FROM USER_VIEWS;


/*
USER VIEWS -> �����͵�ųʸ�?
����ڰ� ������ ���� ��� �信���� ���ǰ� ����Ǿ� ����
���� �̸��� ���� VIEW_NAME, ���������� Ȯ���� �� �ִ�.
*/

SELECT VIEW_NAME, TEXT FROM USER_VIEWS;

/*
���� ���� ����
- ����ڰ� �信 ���ؼ� ���Ǹ� �ϸ� USER_VIEWS���� �信 ���� ���Ǹ� ��ȸ�Ѵ�.
- �⺻ ���̺� ���� ���� ���� ���� ���ɴ�.
- �信���� ���Ǹ� �⺻ ���̺����� ���Ƿ� �����Ѵ�.
- �⺻���̺� ���� ���Ǹ� ���� �����͸� �˻��Ѵ�?
- �˻� ����� ����Ѵ�

���� ����?

�ܼ��� (�⺻���̺��� 1��)�� ���պ� (�⺻���̺��� 1�� �̻�: �ּ� 2�� )?
�ܼ���� ���պ��� ��?
? ? ? ? ? ? ?�ܼ���? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ?���պ�
-----------------------------------------------------------------------
�ϳ��� ���̺�� ����? ? ? ? ? ? ? ? ? ? ? ? ? ? ?�������� ���̺�� ����
�׷��Լ��� ����� �Ұ���? ? ? ? ? ? ? ? ? ? ? ? ? ?�׷� �Լ��� ����� ������
DISTINCT ����� �Ұ���? ? ? ? ? ? ? ? ? ? ? ? ? ? DISTINCT ����� ������
DML(INSERT/UPDATE/DELETE)�� ��� ����? ? ? ? ? ? ? DML�� ��� �Ұ���
---------------------------------------------------------------
*/

--�ܼ��� DML(INSERT/UPDATE/DELTE)�� ��� ����
INSERT INTO VIEW_EMP10 VALUES(8000, 'ANGEL', 7000, 10);
DELETE FROM VIEW_EMP10 WHERE EMPNO=8000;
SELECT * FROM VIEW_EMP10;
SELECT * FROM EMP01;

-- �並 ������� ������ DML ����� �⺻ ���̺� ������ ��ģ��.?

CREATE OR REPLACE VIEW VIEW_EMP10(�����ȣ, �����, �޿�, �μ���ȣ)
AS SELECT EMPNO, ENAME, SAL, DEPTNO FROM EMP01; 

-- �÷��� ��Ī�� ����ؼ� �並 �����ϴ��� �⺻ ���̺��� �÷����� ������ ���� ���Ѵ�.
SELECT * FROM EMP01;

-- ���պ�
-- �μ��� �޿��Ѿװ� ����� ���ϴ� ���ϴ� �۾��� ��� �����غ��� 
CREATE VIEW VIEW_SAL
AS
SELECT
    DEPTNO,
    SUM(SAL) AS "SALSUM", 
    TRUNC(AVG(SAL)) AS "SALAVG" 
FROM
    EMP01
GROUP BY
    DEPTNO;

SELECT * FROM VIEW_SAL;
DESC EMP;
DESC DEPT;

CREATE VIEW VIEW_EMP_DEPT
AS
SELECT
    E.EMPNO,    
    E.ENAME,
    E.SAL,
    E.DEPTNO,
    D.DNAME,
    D.LOC
FROM
    EMP E,
    DEPT D
WHERE
    E.DEPTNO = D.DEPTNO
ORDER BY
    EMPNO DESC;


-- ����� 
-- �並 �����ϴ� ���� �������̺��̱� ������ USER_VIEWS�� ����� ���� ���Ǹ� �����ϴ� ����
DROP VIEW VIEW_SAL;
SELECT VIEW_NAME, TEXT FROM USER_VIEWS;

/*
�⺻ ���̺��� ���� �並 �����ϱ� ����  FORCE �ɼ�
- �⺻ ���̺��� ������ �並 ������ �� �ִ�. 
*/
SELECT *FROM TAB;
CREATE OR REPLACE FORCE VIEW VIEW_NOTABLE
AS
SELECT EMPNO, ENAME, DEPTNO FROM EMP20 WHERE DEPTNO=10;
SELECT*FROM VIEW_NOTABLE;
/*
WITH CHECK OPTION 
 - �� ������ �������� ������ �÷����� ��������
    ���ϵ��� �ϴ� ����
*/

CREATE OR REPLACE VIEW VIEW_CHK20
AS
SELECT EMPNO, ENAME, COMM, DEPTNO FROM EMP01 WHERE DEPTNO = 20 WITH CHECK OPTION;

UPDATE VIEW_CHK20
SET DEPTNO = 10
WHERE SAL >= 5000;
-- �޿��� 5000�̻��� ����� 10�� �μ��� �̵��Ѵ�. 
SELECT *FROM VIEW_CHK20; 

-- WITH READ ONLY: ���� ���̺��� � �÷��� ���ؼ��� ������ ���� ������ �� ����
CREATE OR REPLACE VIEW VIEW_READ30
AS
SELECT EMPNO, ENAME, SAL, COMM,DEPTNO FROM EMP01
WHERE DEPTNO=30 WITH READ ONLY; 
UPDATE VIEW_READ30 SET COMM=1000;
----------------------------END VIEW----------------------------------

/* �������� ������ ���� �������ִ� ����Ŭ ��ü�̴�. 
�������� �����ϸ� �⺻Ű�� ���� ���������� �����ϴ� �÷��� �ڵ������� ������ �� �ְ� �Ѵ�.

������ ���� ����

CREATE SEQUENCE ��������
START WITH N
INCREMENT BY N 
MAXVALUE N /NOMAXVALUE
MINVALUE N / NOMINVALUE
CYCLE/NOCYCLE
CACHE N / NOCACHE;

START WITH N
- �������� ���۰��� ������
INCREMENT BY N 
- �������� ���� ���� ������
MAXVALUE N / NOMAXVALUE
- �ִ밪 ����/ ���Ѵ�� 
�Ѥ���VALUE N / NOMINVALUE
- �ּҰ� ����/ ���� ��
CYCLE/ NOCYCLE
-�ִ밪���� �����ϸ� �ٽ� �ּҰ����� ����
�⺻��: �������� ������ -> NOCYCLE 
CATCH N / NOCACHE
-�޸� �� ������ ���� ����
�⺻���� 20��

NOCACHE�� ���� ���ϰڴ�
*/

-- ���� 1�̰� 1�� ����, �ִ밪 1000000�� �Ǵ� �������� �����϶�.
CREATE SEQUENCE EMP_SEQ
START WITH 1
INCREMENT BY 1
MAXVALUE 100000;

DROP TABLE EMP01;

CREATE TABLE EMP01
AS SELECT EMPNO, ENAME, HIREDATE FROM EMP WHERE 1=0;
SELECT*FROM EMP01;

INSERT INTO EMP01 VALUES(EMP_SBQ.NEXTVAL, 'JULIA', SYSDATE);

-- CURRVAL: �������� ���� ���� ��ȯ 
SELECT EMP_SEQ.CURRVAL FROM DUAL;
-- NEXTVAL : ���� ������ ���� ���� ���� ��ȯ


/*
currval, nextval�� ����� �� �ִ� ���
1. ���������� �ƴ� select ��
2. insert���� select ��
3. insert���� value ��
4. update���� set ��

currval, nextval�� ����� �� ���� ���
1. view�� select��
2. distinct Ű���尡 �ִ� select��
3. group by, having, order by ���� �ִ� select ��
4. select, delete, update�� ��������
5. create table, alter table ����� �⺻��

�������� ���� ����
drop sequence ��������;

*/


