SELECT * FROM TAB;

/* 테이블에 내용을 추가, 수정, 삭제
테이블에 새로운 행을 추가하는 INSERT문
1. 특정 컬럼에만 데이터를 입력하는 경우
형식: INSERT INTO 테이블명 (컬럼명1, 컬럼명2... 컬럼명N)VALUES (값 1, 값 ...값N)

2. 모든 컬럼에 데이터를 입력하는 경우
형식: INSERT INTO 테이블명 VALUES(값1, 값2,.... 값N);

*/
-- DEPT01 테이블 생성?
DESC DEPT;
CREATE TABLE DEPT01(
DEPTNO NUMBER(2),
DNAME VARCHAR2(14),
LOC? VARCHAR2(10));

SELECT * FROM DEPT01;

-- 부서번호 10, 부서이름 ACCOUNTING 지역 NEW YOIRK;
INSERT INTO DEPT01 VALUES(10, 'ACCOUNTING', 'NEW YORK');
INSERT INTO DEPT01 VALUES(20, 'RESEARCH', 'DALLAS');
SHOW USER;
INSERT INTO DEPT01 SELECT * FROM DEPT;
DELETE FROM DEPT01;
INSERT INTO DEPT01(DEPTNO, DNAME) VALUES (10, 'ACCOUNTING');--? 암시적 NULL값 삽입
INSERT INTO DEPT01(DEPTNO, DNAME,LOC) VALUES(20, 'RESEARCH', NULL);? -- 명시적 NULL값 삽입
INSERT INTO DEPT01(DEPTNO, DNAME) VALUES (30, 'SALES'); -- 명시적 NULL값 삽입

/* 테이블 내용을 수정하기 위한 UPDATE
형식
UPDATE 테이블명 SET? 컬럼명= 값 WHERE 조건
*/

SELECT * FROM EMP01;
CREATE TABLE EMP01 AS SELECT * FROM EMP;

-- 모든 사원을 부서번호를 30로 수정하시오?
UPDATE EMP01 SET DEPTNO=30; --모든 데이터를 수정할경우 조건절이 생략된다?
ROLLBACK;

-- 모든 사원의 급여를 10% 올린다.?
UPDATE EMP01 SET SAL = SAL *1.10;?

-- 입사일을 오늘로 변경하시오
UPDATE EMP01 SET HIREDATE = SYSDATE;

-- 특정 행만 변경?
-- UPDATE문에 WHERE절을 추가하면 됨?

-- 부서 번호가 10번인 사원의 부서번호를 30번으로 변경하시오?
UPDATE EMP01 SET DEPTNO= 30 WHERE DEPTNO= 10;

-- 다음은 급여가 3000이상인 사람만 10% 인상하십쇼
UPDATE EMP01 SET SAL = SAL*1.1 WHERE SAL >= 3000;

-- 1987년에 입사한 사원의 입사일을 오늘로 바꿔라?
UPDATE EMP01 SET HIREDATE=SYSDATE WHERE EXTRACT(YEAR FROM HIREDATE) = 1987;
ROLLBACK;
SELECT * FROM EMP01;


/* 테이블에서 2개이상의 컬럼값 변경
테이블에서 하나의 컬럼이 아닌 여러개의 컬럼 값을 변경하려면 기존 SET절에?
, 를 추가하고 컬럼의 값을 추가함?
*/

-- SCOTT의 부서번호는 20번, 직급은 MANAGER로 변경
UPDATE EMP01 SET DEPTNO= 20, JOB = 'MANAGER' WHERE ENAME= 'SCOTT';
SELECT * FROM EMP01;
ROLLBACK;

-- SCOTT의 입사일을 오늘로, 급여는 50, 커미션 4000로 변경
UPDATE EMP01 SET HIREDATE = SYSDATE, SAL = 50, COMM= 4000 WHERE ENAME='SCOTT';
SELECT * FROM EMP01;


/*
테이블에 불필요한 행을 삭제하기 위한 DELETE?
형식
특정 조건으로 삭제?
DELETE FROM 테이블명 WHERE 조건
모든 데이터를 삭제?
DELETE FROM? 테이블명
*/

SELECT * FROM TAB;
SELECT * FROM DEPT01;
-- 모든 데이터 삭제?
DELETE FROM DEPT01;
-- 부서번호가 30번인 데이터만 삭제
DELETE FROM DEPT01 WHERE DEPTNO = 30;
ROLLBACK;

-- DELETE와 TRUNCATE 명령의 차이점?
/*
DELETE
? ? DELETE 명령어를 사용하여 행을 삭제할 경우 행이 많으면 행이 삭제될때마다?
? ? 많은 자원이 소모된다.?
? ? DELETE 명령은 삭제 이전 상태로 원상복구할 수 있는 경우를 생각해서
? ? ROLLBACK 정보를 저장하고 있기 때문임
? ??
TRUNCATE
? ? DDL명령문으로 ROLLBACK 할 수 없음
? ? ROLLBACK 정보를 만들지 않고 즉시 COMMIT하기에 빠르고 효율적인 방법이다
*/


/*??
트랜잭션
데이터베이스에서 데이터를 처리하는 하나의 논리적인 작업단위를 의미한다.

트랜잭션은 INSERT, UPDATE,DELETE 명령은 메모리상에만 변경되다가
특정 단위로 하드디스크의 실제 파일인 데이터베이스에 저장되는 단위를 의미한다.

COMMIT과 ROLLBACK

COMMIT
- 모든 작업들을 정상적으로 처리하겠다고 확정하는 명령어로 트랜잭션의 처리과정을
데이터베이스에 모두 반영하기위해서 변경된 내용을 모두 영구저장함
COMMIT 명령어를 수행하게 되면 하나의 트랜잭션 과정이 종료됨

ROLLBACK
작업중 문제가 발생되어서 트랜잭션 처리과정에서 변경된 사항을 취소하는 명령어
ROLLBACK 명령어 역시 트랜잭션 과정을 종료하게 된다.
ROLLBACK은 트랜잭션으로 인한 하나의 묶음 처리가 시작되기 이전 상태로 되돌림

여러 DML 명령어들을 하나의 논리적인 작업단위인 트랜잭션으로 묶을 수 있음?
마지막으로 실행한 커밋 명령 이후부터 새로운 커밋 명령을 실행하는 시점까지 수행된?
모든 DML 명령어를 의미함

장점
1. 데이터의 무결성을 보장한다.
2. 영구적인 변경전에 데이터의 변경사항을 확인할 수 있다.?
3. 논리적으로 연관된 작업을 그룹화 할 수 있다.

ROLLBACK은 이전 COMMIT한 곳까지만 복구됨
자동 COMMIT 명령과 자동 ROLLBACK 명령이 되는 경우?
SQLPLUS가 정상적으로 종료되면 자동으로 COMMIT 되고?
비정상적으로 종료되면 자동으로 ROLLBACK됨?

*/

DROP TABLE DEPT01;
CREATE TABLE DEPT01
AS SELECT * FROM DEPT;
SELECT * FROM DEPT01;?
DELETE FROM DEPT01;
SELECT * FROM DEPT01;
ROLLBACK;
SELECT * FROM DEPT01;

-- 부서번호 20번 사원에 대한 정보만 삭제
DELETE FROM DEPT01 WHERE DEPTNO= 20;
SELECT * FROM DEPT01;
COMMIT;
ROLLBACK;

--커밋 이후에는 ROLLBACK 명령어는 아무 소용이 없다?

/*
무결성 제약조건의 개념과 종류
무결성 제약조건은 데이터를 추가, 수정, 삭제한느 과정에서 무결성을 유지할수 있도록 제약을 주는 것을 말함
무결성이란 데이터베이스 내에 데이터 확장성을 유지하는 것을 의미하고?
제약조건이란 바람직하지 않은 데이터가 저장되는 것을 방지하는 것을 말함

무결성 제약
NOT NULL? ?: NULL을 허용하지 않는다.
UNIQUE? ? ?: 중복된 값을 허용하지 않는다. 항상 유일한 값을 갖도록 한다.
PRIMARY KEY: NOT NULL과 UNIQUE가 결합한 형태임??
FOREIGN KEY: 참조되는 테이블의 컬럼의 값이 존재하면 허용
CHECK? ? ? : 저장 가능한 데이터 값의 범위나 조건을 지정하여 설정한 값만을 허용함
*/

-- NOT NULL 제약 조건
DROP TABLE EMP01;

-- 사원명, 사원번호, 직급, 부서번호으로 이루어진 구성된 제약조건이 없는 EMP01테이블을 생성
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

-- 개체무결성 제약조건?
INSERT INTO EMP05 VALUES(7499, 'ALLEN', 'SALESMAN', 30);
INSERT INTO EMP05 VALUES(NULL, 'ALLEN', 'SALESMAN', 30);

/* 제약조건 확인?
제약조건 (CONSTRAINTS)의 에러 메세지에 대한 정확한 원인을 알기위해서?
오라클에서 제공해주는 USER_CONSTRAINTS 데이터 딕셔너리가 있다.
제약조건명, 제약 조건 유형, 제약조건이 속한 테이블명
*/

-- 제약조건 확인?
SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME='EMP05';

/*
CONSTRAINT_TYPE은 P, R, U, C 4가지가 있음
? ? P : PRIMARY KEY
? ? R : FOREIGN KEY
? ? U : UNIQUE
? ? C : CHECK NOT NULL
*/

--제약 조건이 지정된 컬럼명으로 확인
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
-- 부모 테이블에 50번 부서 번호가 존재하지 않기 때문에
INSERT INTO EMP05 VALUES(7499, 'ALLEN', 'SALESMAN', 30);
SELECT * FROM EMP05;
SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME, R_CONSTRAINT_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME ='EMP05';

/* CHECK 제약 조건
- 입력되는 값을 체크하여 설정도니 값 이외의 값이 들어오면 오류메시지와 함께 수행을 못한다.
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


/* 제약 조건명 지정
? ? ?제약 조건명 명명규칙
? ? ? ? [테이블]_[컬럼명]_[제약조건유형]
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
-- 자식 테이블인emp05는 부모 테이블인 dept01의 기본키인 부서번호를 참조하고 잇어서 삭제할 수 없다.

/* 부서번호 30번을 삭제하기 위해선느 다음과 같은 절차로 진행한다.
1. 부서테이블의 30번 부서에서 근무하는 사원을 삭제한 후 부서 테이블에서 30번 부서를 삭제한다.

- 참조 무결성 때문에 삭제가 불가능하므로 emp05테이블의 외래키 제약조건을 제거한 후 30번 부서를 삭제한다
*/

/*
제약조건 비활성화와 활성화?
?- 제약 조건이 설정되면 항상 그 규칙에 따라 데이터 무결성이 보장된다.
?오라클에서는 제약조건을 비활성화시키므로써 제약조건을 삭제하지 않고도?
?제약조건을 잠시 보류할 수 있으며 비활성화된 제약조건은 원하는 작업을 한 후에는?
?다시 활성화 상태로 만들어 주는 기능을 가지고 있다.?

제약조건 비활성화 형식
alter table 테이블명
disable constraint 제약조건명:?

제약조건 활성화 형식
alter table 테이블명
enable constraint 제약조건명:?
*/

ALTER TABLE EMP05
DISABLE CONSTRAINT EMP05_DEPTNO_FK;

SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME, R_CONSTRAINT_NAME, STATUS FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'EMP05';

DELETE FROM DEPT01 WHERE DEPTNO = 30;
ROLLBACK;
ALTER TABLE EMP05
ENABLE CONSTRAINT EMP05_DEPTNO_FK;

/*
cascade 옵션
? ? cascade 옵션은 부모 테이블과 자식 테이블간의 참조 설정이 되어 있을때?
? ? 부모 테이블이 제약 조건을 비활성화하면 이를 참조하고 있는 자식 테이블의 제약 조건까지?
? ? 같이 비활성화 시켜주는 옵션이다.?
*/

ALTER TABLE DEPT01
DISABLE PRIMARY KEY;
?
?/*
?why > 제약조건을 모르더라도 primary key로 비활성화를 할 수 잇다.
?그러나, dept01테이블의 기본키는 emp05테이블의 외래키에서 참조하고 있기 때문에 비활성화 할 수 없다
?*/
?
ALTER TABLE DEPT01
DISABLE PRIMARY KEY CASCADE;
SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME, R_CONSTRAINT_NAME, STATUS FROM USER_CONSTRAINTS
WHERE TABLE_NAME IN ('DEPT01','EMP05');

ALTER TABLE DEPT01 DROP PRIMARY KEY CASCADE;
