SELECT * FROM TAB;

/* ���̺� ������ �߰�, ����, ����
���̺� ���ο� ���� �߰��ϴ� INSERT��
1. Ư�� �÷����� �����͸� �Է��ϴ� ���
����: INSERT INTO ���̺�� (�÷���1, �÷���2... �÷���N)VALUES (�� 1, �� ...��N)

2. ��� �÷��� �����͸� �Է��ϴ� ���
����: INSERT INTO ���̺�� VALUES(��1, ��2,.... ��N);

*/
-- DEPT01 ���̺� ����?
DESC DEPT;
CREATE TABLE DEPT01(
DEPTNO NUMBER(2),
DNAME VARCHAR2(14),
LOC? VARCHAR2(10));

SELECT * FROM DEPT01;

-- �μ���ȣ 10, �μ��̸� ACCOUNTING ���� NEW YOIRK;
INSERT INTO DEPT01 VALUES(10, 'ACCOUNTING', 'NEW YORK');
INSERT INTO DEPT01 VALUES(20, 'RESEARCH', 'DALLAS');
SHOW USER;
INSERT INTO DEPT01 SELECT * FROM DEPT;
DELETE FROM DEPT01;
INSERT INTO DEPT01(DEPTNO, DNAME) VALUES (10, 'ACCOUNTING');--? �Ͻ��� NULL�� ����
INSERT INTO DEPT01(DEPTNO, DNAME,LOC) VALUES(20, 'RESEARCH', NULL);? -- ����� NULL�� ����
INSERT INTO DEPT01(DEPTNO, DNAME) VALUES (30, 'SALES'); -- ����� NULL�� ����

/* ���̺� ������ �����ϱ� ���� UPDATE
����
UPDATE ���̺�� SET? �÷���= �� WHERE ����
*/

SELECT * FROM EMP01;
CREATE TABLE EMP01 AS SELECT * FROM EMP;

-- ��� ����� �μ���ȣ�� 30�� �����Ͻÿ�?
UPDATE EMP01 SET DEPTNO=30; --��� �����͸� �����Ұ�� �������� �����ȴ�?
ROLLBACK;

-- ��� ����� �޿��� 10% �ø���.?
UPDATE EMP01 SET SAL = SAL *1.10;?

-- �Ի����� ���÷� �����Ͻÿ�
UPDATE EMP01 SET HIREDATE = SYSDATE;

-- Ư�� �ุ ����?
-- UPDATE���� WHERE���� �߰��ϸ� ��?

-- �μ� ��ȣ�� 10���� ����� �μ���ȣ�� 30������ �����Ͻÿ�?
UPDATE EMP01 SET DEPTNO= 30 WHERE DEPTNO= 10;

-- ������ �޿��� 3000�̻��� ����� 10% �λ��Ͻʼ�
UPDATE EMP01 SET SAL = SAL*1.1 WHERE SAL >= 3000;

-- 1987�⿡ �Ի��� ����� �Ի����� ���÷� �ٲ��?
UPDATE EMP01 SET HIREDATE=SYSDATE WHERE EXTRACT(YEAR FROM HIREDATE) = 1987;
ROLLBACK;
SELECT * FROM EMP01;


/* ���̺��� 2���̻��� �÷��� ����
���̺��� �ϳ��� �÷��� �ƴ� �������� �÷� ���� �����Ϸ��� ���� SET����?
, �� �߰��ϰ� �÷��� ���� �߰���?
*/

-- SCOTT�� �μ���ȣ�� 20��, ������ MANAGER�� ����
UPDATE EMP01 SET DEPTNO= 20, JOB = 'MANAGER' WHERE ENAME= 'SCOTT';
SELECT * FROM EMP01;
ROLLBACK;

-- SCOTT�� �Ի����� ���÷�, �޿��� 50, Ŀ�̼� 4000�� ����
UPDATE EMP01 SET HIREDATE = SYSDATE, SAL = 50, COMM= 4000 WHERE ENAME='SCOTT';
SELECT * FROM EMP01;


/*
���̺� ���ʿ��� ���� �����ϱ� ���� DELETE?
����
Ư�� �������� ����?
DELETE FROM ���̺�� WHERE ����
��� �����͸� ����?
DELETE FROM? ���̺��
*/

SELECT * FROM TAB;
SELECT * FROM DEPT01;
-- ��� ������ ����?
DELETE FROM DEPT01;
-- �μ���ȣ�� 30���� �����͸� ����
DELETE FROM DEPT01 WHERE DEPTNO = 30;
ROLLBACK;

-- DELETE�� TRUNCATE ����� ������?
/*
DELETE
? ? DELETE ��ɾ ����Ͽ� ���� ������ ��� ���� ������ ���� �����ɶ�����?
? ? ���� �ڿ��� �Ҹ�ȴ�.?
? ? DELETE ����� ���� ���� ���·� ���󺹱��� �� �ִ� ��츦 �����ؼ�
? ? ROLLBACK ������ �����ϰ� �ֱ� ������
? ??
TRUNCATE
? ? DDL��ɹ����� ROLLBACK �� �� ����
? ? ROLLBACK ������ ������ �ʰ� ��� COMMIT�ϱ⿡ ������ ȿ������ ����̴�
*/


/*??
Ʈ�����
�����ͺ��̽����� �����͸� ó���ϴ� �ϳ��� ������ �۾������� �ǹ��Ѵ�.

Ʈ������� INSERT, UPDATE,DELETE ����� �޸𸮻󿡸� ����Ǵٰ�
Ư�� ������ �ϵ��ũ�� ���� ������ �����ͺ��̽��� ����Ǵ� ������ �ǹ��Ѵ�.

COMMIT�� ROLLBACK

COMMIT
- ��� �۾����� ���������� ó���ϰڴٰ� Ȯ���ϴ� ��ɾ�� Ʈ������� ó��������
�����ͺ��̽��� ��� �ݿ��ϱ����ؼ� ����� ������ ��� ����������
COMMIT ��ɾ �����ϰ� �Ǹ� �ϳ��� Ʈ����� ������ �����

ROLLBACK
�۾��� ������ �߻��Ǿ Ʈ����� ó���������� ����� ������ ����ϴ� ��ɾ�
ROLLBACK ��ɾ� ���� Ʈ����� ������ �����ϰ� �ȴ�.
ROLLBACK�� Ʈ��������� ���� �ϳ��� ���� ó���� ���۵Ǳ� ���� ���·� �ǵ���

���� DML ��ɾ���� �ϳ��� ������ �۾������� Ʈ��������� ���� �� ����?
���������� ������ Ŀ�� ��� ���ĺ��� ���ο� Ŀ�� ����� �����ϴ� �������� �����?
��� DML ��ɾ �ǹ���

����
1. �������� ���Ἲ�� �����Ѵ�.
2. �������� �������� �������� ��������� Ȯ���� �� �ִ�.?
3. �������� ������ �۾��� �׷�ȭ �� �� �ִ�.

ROLLBACK�� ���� COMMIT�� �������� ������
�ڵ� COMMIT ��ɰ� �ڵ� ROLLBACK ����� �Ǵ� ���?
SQLPLUS�� ���������� ����Ǹ� �ڵ����� COMMIT �ǰ�?
������������ ����Ǹ� �ڵ����� ROLLBACK��?

*/

DROP TABLE DEPT01;
CREATE TABLE DEPT01
AS SELECT * FROM DEPT;
SELECT * FROM DEPT01;?
DELETE FROM DEPT01;
SELECT * FROM DEPT01;
ROLLBACK;
SELECT * FROM DEPT01;

-- �μ���ȣ 20�� ����� ���� ������ ����
DELETE FROM DEPT01 WHERE DEPTNO= 20;
SELECT * FROM DEPT01;
COMMIT;
ROLLBACK;

--Ŀ�� ���Ŀ��� ROLLBACK ��ɾ�� �ƹ� �ҿ��� ����?

/*
���Ἲ ���������� ����� ����
���Ἲ ���������� �����͸� �߰�, ����, �����Ѵ� �������� ���Ἲ�� �����Ҽ� �ֵ��� ������ �ִ� ���� ����
���Ἲ�̶� �����ͺ��̽� ���� ������ Ȯ�强�� �����ϴ� ���� �ǹ��ϰ�?
���������̶� �ٶ������� ���� �����Ͱ� ����Ǵ� ���� �����ϴ� ���� ����

���Ἲ ����
NOT NULL? ?: NULL�� ������� �ʴ´�.
UNIQUE? ? ?: �ߺ��� ���� ������� �ʴ´�. �׻� ������ ���� ������ �Ѵ�.
PRIMARY KEY: NOT NULL�� UNIQUE�� ������ ������??
FOREIGN KEY: �����Ǵ� ���̺��� �÷��� ���� �����ϸ� ���
CHECK? ? ? : ���� ������ ������ ���� ������ ������ �����Ͽ� ������ ������ �����
*/

-- NOT NULL ���� ����
DROP TABLE EMP01;

-- �����, �����ȣ, ����, �μ���ȣ���� �̷���� ������ ���������� ���� EMP01���̺��� ����
CREATE TABLE EMP01(
EMPNO? NUMBER(4),
ENAME? VARCHAR2(10),
JOB? ? VARCHAR2(9),
DEPTNO NUMBER(2));

INSERT INTO EMP01 VALUES(NULL, NULL, 'SALESMAN',30);
SELECT * FROM EMP01;
DROP TABLE EMP02;

CREATE TABLE EMP02(
EMPNO? NUMBER(4) NOT NULL,
ENAME? VARCHAR2(10) NOT NULL,
JOB? ? VARCHAR2(9),
DEPTNO NUMBER(2));

INSERT INTO EMP02 VALUES(NULL, NULL, 'SALESMAN',30);
INSERT INTO EMP02 VALUES(7499, 'ALLEN', 'SALESMAN',30);
SELECT * FROM EMP02;

CREATE TABLE EMP03(
EMPNO? NUMBER(4) UNIQUE,
ENAME? VARCHAR2(10) NOT NULL,
JOB? ? VARCHAR2(9),
DEPTNO NUMBER(2)
);

INSERT INTO EMP03 VALUES(NULL, 'ALLEN', 'SALESMAN', 30);
SELECT * FROM EMP03;

CREATE TABLE EMP04(
EMPNO? NUMBER(4) UNIQUE NOT NULL,
ENAME? VARCHAR2(10) NOT NULL,
JOB? ? VARCHAR2(9),
DEPTNO NUMBER(2)
);

INSERT INTO EMP04 VALUES(7499, 'ALLEN', 'SALESMAN', 30);
INSERT INTO EMP04 VALUES(NULL, 'ALLEN', 'SALESMAN', 30);

CREATE TABLE EMP05(
EMPNO? NUMBER(4) PRIMARY KEY,
ENAME? VARCHAR2(10) NOT NULL,
JOB? ? VARCHAR2(9),
DEPTNO NUMBER(2)
);

-- ��ü���Ἲ ��������?
INSERT INTO EMP05 VALUES(7499, 'ALLEN', 'SALESMAN', 30);
INSERT INTO EMP05 VALUES(NULL, 'ALLEN', 'SALESMAN', 30);

/* �������� Ȯ��?
�������� (CONSTRAINTS)�� ���� �޼����� ���� ��Ȯ�� ������ �˱����ؼ�?
����Ŭ���� �������ִ� USER_CONSTRAINTS ������ ��ųʸ��� �ִ�.
�������Ǹ�, ���� ���� ����, ���������� ���� ���̺��
*/

-- �������� Ȯ��?
SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME='EMP05';

/*
CONSTRAINT_TYPE�� P, R, U, C 4������ ����
? ? P : PRIMARY KEY
? ? R : FOREIGN KEY
? ? U : UNIQUE
? ? C : CHECK NOT NULL
*/

--���� ������ ������ �÷������� Ȯ��
SELECT * FROM USER_CONS_COLUMNS WHERE TABLE_NAME='EMP05';

DESC EMP;
SELECT * FROM EMP04;?

DESC DEPT;

DROP TABLE DEPT01;

CREATE TABLE DEPT01(
? ? DEPTNO? NUMBER(2)? ? PRIMARY KEY,?
? ? DNAME? ?VARCHAR2(14),
? ? LOC? ? ?VARCHAR2(13)?
);

DESC DEPT01;
SELECT * FROM DEPT;
INSERT INTO DEPT01 VALUES(10, 'ACCOUNT', 'NEW YORK');
INSERT INTO DEPT01 VALUES(20, 'RESEARCH', 'NEW YORK');
INSERT INTO DEPT01 VALUES(30, 'SALES', 'CHICAGO');
INSERT INTO DEPT01 VALUES(40, 'OPERATION', 'BOSTON');
COMMIT;

DROP TABLE EMP05;

CREATE TABLE EMP05(
? ? EMPNO? ?NUMBER(4) PRIMARY KEY,
? ? ENAME? ?VARCHAR2(10) NOT NULL,
? ? JOB? ? ?VARCHAR2(9),
? ? DEPTNO? NUMBER(4)? ? REFERENCES DEPT01(DEPTNO)?
);

INSERT INTO EMP05 VALUES(7499, 'ALLEN', 'SALESMAN', 50);?
-- �θ� ���̺� 50�� �μ� ��ȣ�� �������� �ʱ� ������
INSERT INTO EMP05 VALUES(7499, 'ALLEN', 'SALESMAN', 30);
SELECT * FROM EMP05;
SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME, R_CONSTRAINT_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME ='EMP05';

/* CHECK ���� ����
- �ԷµǴ� ���� üũ�Ͽ� �������� �� �̿��� ���� ������ �����޽����� �Բ� ������ ���Ѵ�.
*/

DROP TABLE EMP06;

CREATE TABLE EMP06(
EMPNO NUMBER(4) PRIMARY KEY,
ENAME VARCHAR2(10) NOT NULL,
GENDER VARCHAR2(1) CHECK(GENDER IN('M','F'))
);

INSERT INTO EMP06 VALUES(7566, 'JONES', 'M');
SELECT * FROM EMP06;

SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME, SEARCH_CONDITION FROM USER_CONSTRAINTS
WHERE TABLE_NAME='EMP06';


/* ���� ���Ǹ� ����
? ? ?���� ���Ǹ� ����Ģ
? ? ? ? [���̺�]_[�÷���]_[������������]
? ? ? ??
? ? ? ? EX) EMP06_EMPNO_PK?
*/

DROP TABLE EMP05;

CREATE TABLE EMP05(
? ? EMPNO? ?NUMBER(4)? ? CONSTRAINT EMP05_EMPNO_PK PRIMARY KEY,
? ? ENAME? ?VARCHAR2(10) CONSTRAINT EMP05_ENAME_NN NOT NULL,
? ? JOB? ? ?VARCHAR2(9)? CONSTRAINT EMP05_JOB_UK UNIQUE,
? ?DEPTNO? NUMBER(2)? ? CONSTRAINT EMP05_DEPTNO_FK REFERENCES DEPT01(DEPTNO)
);

INSERT INTO EMP05 VALUES(7499, 'ALLEN', 'SALESMAN', 30);

SELECT * FROM EMP05;

SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME, R_CONSTRAINT_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME='EMP05';

DELETE FROM DEPT01 WHERE DEPTNO = 10;
SELECT * FROM DEPT01;
SELECT * FROM EMP05;


DELETE FROM DEPT01 WHERE DEPTNO = 30;
-- �ڽ� ���̺���emp05�� �θ� ���̺��� dept01�� �⺻Ű�� �μ���ȣ�� �����ϰ� �վ ������ �� ����.

/* �μ���ȣ 30���� �����ϱ� ���ؼ��� ������ ���� ������ �����Ѵ�.
1. �μ����̺��� 30�� �μ����� �ٹ��ϴ� ����� ������ �� �μ� ���̺��� 30�� �μ��� �����Ѵ�.

- ���� ���Ἲ ������ ������ �Ұ����ϹǷ� emp05���̺��� �ܷ�Ű ���������� ������ �� 30�� �μ��� �����Ѵ�
*/

/*
�������� ��Ȱ��ȭ�� Ȱ��ȭ?
?- ���� ������ �����Ǹ� �׻� �� ��Ģ�� ���� ������ ���Ἲ�� ����ȴ�.
?����Ŭ������ ���������� ��Ȱ��ȭ��Ű�Ƿν� ���������� �������� �ʰ�?
?���������� ��� ������ �� ������ ��Ȱ��ȭ�� ���������� ���ϴ� �۾��� �� �Ŀ���?
?�ٽ� Ȱ��ȭ ���·� ����� �ִ� ����� ������ �ִ�.?

�������� ��Ȱ��ȭ ����
alter table ���̺��
disable constraint �������Ǹ�:?

�������� Ȱ��ȭ ����
alter table ���̺��
enable constraint �������Ǹ�:?
*/

ALTER TABLE EMP05
DISABLE CONSTRAINT EMP05_DEPTNO_FK;

SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME, R_CONSTRAINT_NAME, STATUS FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'EMP05';

DELETE FROM DEPT01 WHERE DEPTNO = 30;
ROLLBACK;
ALTER TABLE EMP05
ENABLE CONSTRAINT EMP05_DEPTNO_FK;

/*
cascade �ɼ�
? ? cascade �ɼ��� �θ� ���̺�� �ڽ� ���̺��� ���� ������ �Ǿ� ������?
? ? �θ� ���̺��� ���� ������ ��Ȱ��ȭ�ϸ� �̸� �����ϰ� �ִ� �ڽ� ���̺��� ���� ���Ǳ���?
? ? ���� ��Ȱ��ȭ �����ִ� �ɼ��̴�.?
*/

ALTER TABLE DEPT01
DISABLE PRIMARY KEY;
?
?/*
?why > ���������� �𸣴��� primary key�� ��Ȱ��ȭ�� �� �� �մ�.
?�׷���, dept01���̺��� �⺻Ű�� emp05���̺��� �ܷ�Ű���� �����ϰ� �ֱ� ������ ��Ȱ��ȭ �� �� ����
?*/
?
ALTER TABLE DEPT01
DISABLE PRIMARY KEY CASCADE;
SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME, R_CONSTRAINT_NAME, STATUS FROM USER_CONSTRAINTS
WHERE TABLE_NAME IN ('DEPT01','EMP05');

ALTER TABLE DEPT01 DROP PRIMARY KEY CASCADE;
