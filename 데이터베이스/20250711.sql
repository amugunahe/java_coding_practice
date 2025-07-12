SELECT * FROM TAB;

/* 테이블에 내용을 추가, 수정, 삭제
테이블에 새로운 행을 추가하는 INSERT문
1. 특정 컬럼에만 데이터를 입력하는 경우
형식: INSERT INTO 테이블명 (컬럼명1, 컬럼명2... 컬럼N) VALUES (값1, 값2...값N);

2. 모든 컬럼에 데이터를 입력하는 경우
형식: INSERT INTO 테이블명 VALUES(값1, 값2,...값N);

*/
-- DEPT01 테이블 생성
DESC DEPT;
CREATE TABLE DEPT01(
DEPTNO NUMBER(2),
DNAME VARCHAR2(14),
LOC VARCHAR2(10));

SELECT * FROM DEPT01;

-- 부서번호 10, 부서이름 ACCOUNTING, 지역 NEW YORK;
INSERT INTO DEPT01 VALUES(10, 'ACCOUNTING', 'NEW YORK');
INSERT INTO DEPT01 VALUES(20, 'RESEARCH', 'DALLAS');
SHOW USER;
INSERT INTO DEPT01 SELECT * FROM DEPT;
DELETE FROM DEPT01;
INSERT INTO DEPT01(DEPTNO, DNAME) VALUES (10, 'ACCOUNTING');-- 암시적 NULL값 삽입
INSERT INTO DEPT01(DEPTNO, DNAME,LOC) VALUES(20, 'RESEARCH', NULL); -- 명시적 NULL값 삽입
INSERT INTO DEPT01(DEPTNO, DNAME) VALUES (30, 'SALES'); -- 명시적 NULL값 삽입

/* 테이블 내용을 수정하기 위한 UPDATE
형식
UPDATE 테이블명 SET 컬럼명 = 값 WHERE 조건;
*/

SELECT * FROM EMP01;
CREATE TABLE EMP01 AS SELECT * FROM EMP;

-- 모든 사원의 부서번호를 30으로 수정하시오.
UPDATE EMP01 SET DEPTNO = 30; -- 모든 데이터를 수정할 경우 조건절이 생략된다.
ROLLBACK;

-- 모든 사원의 급여를 10% 올린다.
UPDATE EMP01 SET SAL = SAL * 1.10;

-- 입사일을 오늘로 변경하시오
UPDATE EMP01 SET HIREDATE = SYSDATE;

-- 특정 행만 변경
-- UPDATE문에 WHERE절을 추가하면 됨.

-- 부서 번호가 10번인 사원의 부서번호를 30번으로 변경하시오.
UPDATE EMP01 SET DEPTNO = 30 WHERE DEPTNO = 10;

-- 다음은 급여가 3000 이상인 사람만 10% 인상하시오.
UPDATE EMP01 SET SAL = SAL * 1.1 WHERE SAL >= 3000;

-- 1987년에 입사한 사원의 입사일을 오늘로 바꿔라.
UPDATE EMP01 SET HIREDATE = SYSDATE WHERE EXTRACT(YEAR FROM HIREDATE) = 1987;
ROLLBACK;
SELECT * FROM EMP01;


/* 테이블에서 2개 이상의 컬럼값 변경
테이블에서 하나의 컬럼이 아닌 여러 개의 컬럼 값을 변경하려면 기존 SET절에
, 를 추가하고 컬럼의 값을 추가함.
*/

-- SCOTT의 부서번호는 20번, 직급은 MANAGER로 변경
UPDATE EMP01 SET DEPTNO = 20, JOB = 'MANAGER' WHERE ENAME = 'SCOTT';
SELECT * FROM EMP01;
ROLLBACK;

-- SCOTT의 입사일을 오늘로, 급여는 50, 커미션 4000으로 변경
UPDATE EMP01 SET HIREDATE = SYSDATE, SAL = 50, COMM = 4000 WHERE ENAME = 'SCOTT';
SELECT * FROM EMP01;


/*
테이블에 불필요한 행을 삭제하기 위한 DELETE
형식
특정 조건으로 삭제
DELETE FROM 테이블명 WHERE 조건;
모든 데이터를 삭제
DELETE FROM 테이블명;
*/

SELECT * FROM TAB;
SELECT * FROM DEPT01;
-- 모든 데이터 삭제
DELETE FROM DEPT01;
-- 부서번호가 30번인 데이터만 삭제
DELETE FROM DEPT01 WHERE DEPTNO = 30;
ROLLBACK;

-- DELETE와 TRUNCATE 명령의 차이점
/*
DELETE
    DELETE 명령어를 사용하여 행을 삭제할 경우 행이 많으면 행이 삭제될 때마다
    많은 자원이 소모된다.
    DELETE 명령은 삭제 이전 상태로 원상복구할 수 있는 경우를 생각해서
    ROLLBACK 정보를 저장하고 있기 때문임.
    
TRUNCATE
    DDL 명령문으로 ROLLBACK 할 수 없음.
    ROLLBACK 정보를 만들지 않고 즉시 COMMIT하기에 빠르고 효율적인 방법이다.
*/


/*
트랜잭션
데이터베이스에서 데이터를 처리하는 하나의 논리적인 작업 단위를 의미한다.

트랜잭션은 INSERT, UPDATE, DELETE 명령은 메모리상에만 변경되다가
특정 단위로 하드디스크의 실제 파일인 데이터베이스에 저장되는 단위를 의미한다.

COMMIT과 ROLLBACK

COMMIT
- 모든 작업들을 정상적으로 처리하겠다고 확정하는 명령어로 트랜잭션의 처리 과정을
데이터베이스에 모두 반영하기 위해서 변경된 내용을 모두 영구 저장함.
COMMIT 명령어를 수행하게 되면 하나의 트랜잭션 과정이 종료됨.

ROLLBACK
작업 중 문제가 발생되어서 트랜잭션 처리 과정에서 변경된 사항을 취소하는 명령어.
ROLLBACK 명령어 역시 트랜잭션 과정을 종료하게 된다.
ROLLBACK은 트랜잭션으로 인한 하나의 묶음 처리가 시작되기 이전 상태로 되돌림.

여러 DML 명령어들을 하나의 논리적인 작업 단위인 트랜잭션으로 묶을 수 있음.
마지막으로 실행한 커밋 명령 이후부터 새로운 커밋 명령을 실행하는 시점까지 수행된
모든 DML 명령어를 의미함.

장점
1. 데이터의 무결성을 보장한다.
2. 영구적인 변경 전에 데이터의 변경 사항을 확인할 수 있다.
3. 논리적으로 연관된 작업을 그룹화 할 수 있다.

ROLLBACK은 이전 COMMIT한 곳까지만 복구됨.
자동 COMMIT 명령과 자동 ROLLBACK 명령이 되는 경우
SQLPLUS가 정상적으로 종료되면 자동으로 COMMIT 되고
비정상적으로 종료되면 자동으로 ROLLBACK됨.

*/

DROP TABLE DEPT01;
CREATE TABLE DEPT01
AS SELECT * FROM DEPT;
SELECT * FROM DEPT01;
DELETE FROM DEPT01;
SELECT * FROM DEPT01;
ROLLBACK;
SELECT * FROM DEPT01;

-- 부서번호 20번 사원에 대한 정보만 삭제
DELETE FROM DEPT01 WHERE DEPTNO = 20;
SELECT * FROM DEPT01;
COMMIT;
ROLLBACK;

-- 커밋 이후에는 ROLLBACK 명령어는 아무 소용이 없다.

/*
무결성 제약조건의 개념과 종류
무결성 제약조건은 데이터를 추가, 수정, 삭제하는 과정에서 무결성을 유지할 수 있도록 제약을 주는 것을 말함.
무결성이란 데이터베이스 내에 데이터의 정확성과 일관성을 유지하는 것을 의미하고
제약조건이란 바람직하지 않은 데이터가 저장되는 것을 방지하는 것을 말함.

무결성 제약
NOT NULL : NULL을 허용하지 않는다.
UNIQUE : 중복된 값을 허용하지 않는다. 항상 유일한 값을 갖도록 한다.
PRIMARY KEY: NOT NULL과 UNIQUE가 결합한 형태임.
FOREIGN KEY: 참조되는 테이블의 컬럼의 값이 존재하면 허용.
CHECK : 저장 가능한 데이터 값의 범위나 조건을 지정하여 설정한 값만을 허용함.
*/

-- NOT NULL 제약 조건
DROP TABLE EMP01;

-- 사원명, 사원번호, 직급, 부서번호로 구성된 제약조건이 없는 EMP01 테이블을 생성
CREATE TABLE EMP01(
EMPNO NUMBER(4),
ENAME VARCHAR2(10),
JOB VARCHAR2(9),
DEPTNO NUMBER(2));

INSERT INTO EMP01 VALUES(NULL, NULL, 'SALESMAN',30);
SELECT * FROM EMP01;
DROP TABLE EMP02;

CREATE TABLE EMP02(
EMPNO NUMBER(4) NOT NULL,
ENAME VARCHAR2(10) NOT NULL,
JOB VARCHAR2(9),
DEPTNO NUMBER(2));

-- INSERT INTO EMP02 VALUES(NULL, NULL, 'SALESMAN',30); -- 이 라인은 에러를 발생시키므로 주석 처리
INSERT INTO EMP02 VALUES(7499, 'ALLEN', 'SALESMAN',30);
SELECT * FROM EMP02;

CREATE TABLE EMP03(
EMPNO NUMBER(4) UNIQUE,
ENAME VARCHAR2(10) NOT NULL,
JOB VARCHAR2(9),
DEPTNO NUMBER(2)
);

INSERT INTO EMP03 VALUES(NULL, 'ALLEN', 'SALESMAN', 30);
SELECT * FROM EMP03;

CREATE TABLE EMP04(
EMPNO NUMBER(4) UNIQUE NOT NULL,
ENAME VARCHAR2(10) NOT NULL,
JOB VARCHAR2(9),
DEPTNO NUMBER(2)
);

INSERT INTO EMP04 VALUES(7499, 'ALLEN', 'SALESMAN', 30);
-- INSERT INTO EMP04 VALUES(NULL, 'ALLEN', 'SALESMAN', 30); -- 이 라인은 에러를 발생시키므로 주석 처리

CREATE TABLE EMP05(
EMPNO NUMBER(4) PRIMARY KEY,
ENAME VARCHAR2(10) NOT NULL,
JOB VARCHAR2(9),
DEPTNO NUMBER(2)
);

-- 개체 무결성 제약조건
INSERT INTO EMP05 VALUES(7499, 'ALLEN', 'SALESMAN', 30);
-- INSERT INTO EMP05 VALUES(NULL, 'ALLEN', 'SALESMAN', 30); -- 이 라인은 에러를 발생시키므로 주석 처리

/* 제약조건 확인
제약조건 (CONSTRAINTS)의 에러 메시지에 대한 정확한 원인을 알기 위해서
오라클에서 제공해주는 USER_CONSTRAINTS 데이터 딕셔너리가 있다.
제약조건명, 제약조건 유형, 제약조건이 속한 테이블명
*/

-- 제약조건 확인
SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME='EMP05';

/*
CONSTRAINT_TYPE은 P, R, U, C 4가지가 있음
    P : PRIMARY KEY
    R : FOREIGN KEY
    U : UNIQUE
    C : CHECK (NOT NULL 포함)
*/

-- 제약 조건이 지정된 컬럼명으로 확인
SELECT * FROM USER_CONS_COLUMNS WHERE TABLE_NAME='EMP05';

DESC EMP;
SELECT * FROM EMP04;

DESC DEPT;

DROP TABLE DEPT01;

CREATE TABLE DEPT01(
    DEPTNO NUMBER(2) PRIMARY KEY,
    DNAME VARCHAR2(14),
    LOC VARCHAR2(13)
);

DESC DEPT01;
SELECT * FROM DEPT;
INSERT INTO DEPT01 VALUES(10, 'ACCOUNTING', 'NEW YORK');
INSERT INTO DEPT01 VALUES(20, 'RESEARCH', 'NEW YORK');
INSERT INTO DEPT01 VALUES(30, 'SALES', 'CHICAGO');
INSERT INTO DEPT01 VALUES(40, 'OPERATION', 'BOSTON');
COMMIT;

DROP TABLE EMP05;

CREATE TABLE EMP05(
    EMPNO NUMBER(4) PRIMARY KEY,
    ENAME VARCHAR2(10) NOT NULL,
    JOB VARCHAR2(9),
    DEPTNO NUMBER(4) REFERENCES DEPT01(DEPTNO)
);

-- INSERT INTO EMP05 VALUES(7499, 'ALLEN', 'SALESMAN', 50); -- 부모 테이블에 50번 부서 번호가 존재하지 않기 때문에 에러 발생
INSERT INTO EMP05 VALUES(7499, 'ALLEN', 'SALESMAN', 30);
SELECT * FROM EMP05;
SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME, R_CONSTRAINT_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME ='EMP05';

/* CHECK 제약 조건
- 입력되는 값을 체크하여 설정된 값 이외의 값이 들어오면 오류 메시지와 함께 수행을 못 한다.
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
    제약 조건명 명명 규칙
        [테이블]_[컬럼명]_[제약조건유형]
        
        EX) EMP06_EMPNO_PK
*/

DROP TABLE EMP05;

CREATE TABLE EMP05(
    EMPNO NUMBER(4) CONSTRAINT EMP05_EMPNO_PK PRIMARY KEY,
    ENAME VARCHAR2(10) CONSTRAINT EMP05_ENAME_NN NOT NULL,
    JOB VARCHAR2(9) CONSTRAINT EMP05_JOB_UK UNIQUE,
    DEPTNO NUMBER(2) CONSTRAINT EMP05_DEPTNO_FK REFERENCES DEPT01(DEPTNO)
);

INSERT INTO EMP05 VALUES(7499, 'ALLEN', 'SALESMAN', 30);

SELECT * FROM EMP05;

SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME, R_CONSTRAINT_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME='EMP05';

DELETE FROM DEPT01 WHERE DEPTNO = 10;
SELECT * FROM DEPT01;
SELECT * FROM EMP05;


-- DELETE FROM DEPT01 WHERE DEPTNO = 30; -- 자식 테이블인 EMP05는 부모 테이블인 DEPT01의 기본키인 부서번호를 참조하고 있어서 삭제할 수 없다.

/* 부서번호 30번을 삭제하기 위해서는 다음과 같은 절차로 진행한다.
1. 부서 테이블의 30번 부서에서 근무하는 사원을 삭제한 후 부서 테이블에서 30번 부서를 삭제한다.

- 참조 무결성 때문에 삭제가 불가능하므로 EMP05 테이블의 외래키 제약조건을 제거한 후 30번 부서를 삭제한다.
*/

/*
제약조건 비활성화와 활성화
- 제약 조건이 설정되면 항상 그 규칙에 따라 데이터 무결성이 보장된다.
오라클에서는 제약조건을 비활성화시킴으로써 제약조건을 삭제하지 않고도
제약조건을 잠시 보류할 수 있으며 비활성화된 제약조건은 원하는 작업을 한 후에는
다시 활성화 상태로 만들어 주는 기능을 가지고 있다.

제약조건 비활성화 형식
ALTER TABLE 테이블명 DISABLE CONSTRAINT 제약조건명;

제약조건 활성화 형식
ALTER TABLE 테이블명 ENABLE CONSTRAINT 제약조건명;
*/

ALTER TABLE EMP05
DISABLE CONSTRAINT EMP05_DEPTNO_FK;

SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME, R_CONSTRAINT_NAME, STATUS FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'EMP05';

DELETE FROM DEPT01 WHERE DEPTNO = 30;
ROLLBACK;
ALTER TABLE EMP05
ENABLE CONSTRAINT EMP05_DEPTNO_FK;

/*
CASCADE 옵션
    CASCADE 옵션은 부모 테이블과 자식 테이블 간의 참조 설정이 되어 있을 때
    부모 테이블이 제약 조건을 비활성화하면 이를 참조하고 있는 자식 테이블의 제약 조건까지
    같이 비활성화시켜주는 옵션이다.
*/

ALTER TABLE DEPT01
DISABLE PRIMARY KEY;

/*
WHY > 제약조건을 모르더라도 PRIMARY KEY로 비활성화를 할 수 있다.
그러나, DEPT01 테이블의 기본키는 EMP05 테이블의 외래키에서 참조하고 있어서 비활성화 할 수 없다.
*/

ALTER TABLE DEPT01
DISABLE PRIMARY KEY CASCADE;
SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME, R_CONSTRAINT_NAME, STATUS FROM USER_CONSTRAINTS
WHERE TABLE_NAME IN ('DEPT01','EMP05');

ALTER TABLE DEPT01 DROP PRIMARY KEY CASCADE;

---------------------------------VIEW-----------------------------------
/* VIEW
    보다라는 의미를 갖고 있다.
    실제 테이블 (물리테이블)에 저장된 데이터를 뷰를 통해서 볼 수 있도록 한다.
    
    뷰는 가상테이블이며 실제 테이블과 거의 동일하게 사용함.
    
    뷰의 사용 목적
    1. 직접적인 테이블 접근을 제한하기 위해 사용한다.
    2. 복잡한 질의를 쉽게 만들기 위해서 사용한다.
    
    뷰의 특징
    뷰는 테이블에 대한 제한을 가지고 테이블의 일정한 부분만 보일 수 있는 가상의 테이블이다.
    
    뷰는 실제 자료를 갖지는 않지만, 뷰를 통해서 테이블을 관리할 수 있다.
    하나의 테이블에 뷰의 개수는 제한이 없다.
    
    기본 테이블
    뷰에 의해 제한적으로 접근해서 사용하는 실질적으로 데이터를 저장하고 있는
    물리적인 테이블을 말함.
*/

DESC EMP01;
CREATE VIEW VIEW_EMP10
AS SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP01 WHERE DEPTNO = 10;

DROP VIEW VIEW_EMP10;
DROP TABLE EMP01;

CREATE TABLE EMP01 AS SELECT * FROM EMP;
SELECT * FROM EMP01;


SELECT EMPNO, ENAME, SAL, DEPTNO FROM EMP01 WHERE DEPTNO=10;


/* 뷰 생성
뷰는 테이블처럼 하나의 개체로서 테이블을 생성할 때 유사하게 CREATE VIEW 명령으로 생성한다.

CREATE [OR REPLACE][FORCE][NOFORCE] VIEW VIEW_NAME
AS SUBQUERY
[WITH CHECK OPTION]
[WITH READ ONLY]; -- 조회(SELECT)만 가능함 (INSERT/UPDATE/DELETE 명령은 사용 불가)

[OR REPLACE]
- 새로운 뷰를 만들 수 있을 뿐만 아니라 기존에 뷰가 존재하더라도 삭제하지 않고
새로운 구조의 뷰로 변경할 수 있다.

[FORCE][NOFORCE]
- 기본 테이블의 존재 여부에 상관없이 뷰를 생성한다.

[WITH CHECK OPTION]
- 해당 뷰를 통해서 볼 수 있는 범위 내에서만 UPDATE 또는 INSERT가 가능함.
*/

CREATE VIEW VIEW_EMP01
AS
SELECT EMPNO, ENAME, SAL, DEPTNO
FROM EMP01
WHERE DEPTNO=10;

SELECT * FROM VIEW_EMP01; -- VIEW_EMP01을 조회하도록 수정했다.

-- 뷰를 작성할 때 기술한 서브쿼리문이 어떻게 작성되어있는지를 확인함.
SELECT VIEW_NAME, TEXT FROM USER_VIEWS;


/*
USER_VIEWS -> 데이터 딕셔너리
사용자가 생성한 뷰의 모든 뷰에 대한 정의가 저장되어 있음.
뷰의 이름을 위한 VIEW_NAME, 서브쿼리를 확인할 수 있다.
*/

SELECT VIEW_NAME, TEXT FROM USER_VIEWS;

/*
뷰의 동작 원리
- 사용자가 뷰에 대해서 질의를 하면 USER_VIEWS에서 뷰에 대한 정의를 조회한다.
- 기본 테이블에 대한 뷰의 접근 권한을 살핀다.
- 뷰에 대한 질의를 기본 테이블에 대한 질의로 변환한다.
- 기본 테이블에 대한 질의를 통해 데이터를 검색한다.
- 검색 결과를 출력한다.

뷰의 종류

단순뷰 (기본테이블이 1개)와 복합뷰 (기본테이블이 1개 이상: 최소 2개)
단순뷰와 복합뷰의 비교
                        단순뷰                                  복합뷰
---------------------------------------------------------------------------------------
하나의 테이블로 생성                                  여러 개의 테이블로 생성
그룹 함수의 사용이 불가능                             그룹 함수의 사용이 가능함
DISTINCT 사용이 불가능                                DISTINCT 사용이 가능함
DML(INSERT/UPDATE/DELETE)이 사용 가능                 DML이 사용 불가능
---------------------------------------------------------------------------------------
*/

-- 단순뷰 DML(INSERT/UPDATE/DELETE)이 사용 가능
INSERT INTO VIEW_EMP10 VALUES(8000, 'ANGEL', 7000, 10);
DELETE FROM VIEW_EMP10 WHERE EMPNO = 8000;
SELECT * FROM VIEW_EMP10;
SELECT * FROM EMP01;

-- 뷰를 대상으로 실행한 DML 명령은 기본 테이블에 영향을 미친다.

CREATE OR REPLACE VIEW VIEW_EMP10(사원번호, 사원명, 급여, 부서번호)
AS SELECT EMPNO, ENAME, SAL, DEPTNO FROM EMP01;

-- 컬럼에 별칭을 사용해서 뷰를 생성하더라도 기본 테이블의 컬럼명에는 영향을 주지 못한다.
SELECT * FROM EMP01;

-- 복합뷰
-- 부서별 급여 총액과 평균을 구하는 작업을 뷰로 생성해보자
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


-- 뷰 삭제
-- 뷰를 삭제하는 것은 가상테이블이기 때문에 USER_VIEWS에 저장된 뷰의 정의를 삭제하는 것임.
DROP VIEW VIEW_SAL;
SELECT VIEW_NAME, TEXT FROM USER_VIEWS;

/*
기본 테이블이 없이 뷰를 생성하기 위한 FORCE 옵션
- 기본 테이블이 없더라도 뷰를 생성할 수 있다.
*/
SELECT * FROM TAB;
CREATE OR REPLACE FORCE VIEW VIEW_NOTABLE
AS
SELECT EMPNO, ENAME, DEPTNO FROM EMP20 WHERE DEPTNO = 10;
SELECT * FROM VIEW_NOTABLE;

/*
WITH CHECK OPTION
- 뷰 생성 시 조건으로 지정한 컬럼값을 변경하지
  못하도록 하는 것임.
*/

CREATE OR REPLACE VIEW VIEW_CHK20
AS
SELECT EMPNO, ENAME, COMM, DEPTNO FROM EMP01 WHERE DEPTNO = 20 WITH CHECK OPTION;

UPDATE VIEW_CHK20
SET DEPTNO = 10
WHERE SAL >= 5000;
-- 급여가 5000 이상인 사원을 10번 부서로 이동한다.
SELECT * FROM VIEW_CHK20;

-- WITH READ ONLY: 기존 테이블의 어떤 컬럼에 대해서도 내용을 절대 변경할 수 없다.
CREATE OR REPLACE VIEW VIEW_READ30
AS
SELECT EMPNO, ENAME, SAL, COMM, DEPTNO FROM EMP01
WHERE DEPTNO = 30 WITH READ ONLY;
-- UPDATE VIEW_READ30 SET COMM = 1000; -- 이 라인은 에러를 발생시키므로 주석 처리
----------------------------END VIEW----------------------------------

/* 시퀀스는 유일한 값을 생성해주는 오라클 객체이다.
시퀀스를 생성하면 기본키와 같이 순차적으로 증가하는 컬럼을 자동적으로 생성할 수 있게 한다.

시퀀스 생성 형식

CREATE SEQUENCE 시퀀스명
START WITH N
INCREMENT BY N
MAXVALUE N / NOMAXVALUE
MINVALUE N / NOMINVALUE
CYCLE / NOCYCLE
CACHE N / NOCACHE;

START WITH N
- 시퀀스의 시작값을 지정함.
INCREMENT BY N
- 시퀀스의 증가 값을 지정함.
MAXVALUE N / NOMAXVALUE
- 최대값 지정 / 무한대
MINVALUE N / NOMINVALUE
- 최소값 지정 / 무한 소 (이 부분은 '최소값 지정 / 최소값 없음'으로 해석될 수 있습니다.)
CYCLE / NOCYCLE
- 최대값까지 증가하면 다시 최소값부터 시작.
기본값: 지정하지 않으면 -> NOCYCLE
CACHE N / NOCACHE
- 메모리 상에 시퀀스 값을 관리.
기본값은 20임.

NOCACHE는 관리 안 하겠다.
*/

-- 시작 1이고 1씩 증가, 최대값 100000이 되는 시퀀스를 생성하라.
CREATE SEQUENCE EMP_SEQ
START WITH 1
INCREMENT BY 1
MAXVALUE 100000;

DROP TABLE EMP01;

CREATE TABLE EMP01
AS SELECT EMPNO, ENAME, HIREDATE FROM EMP WHERE 1=0;
SELECT * FROM EMP01;

INSERT INTO EMP01 VALUES(EMP_SEQ.NEXTVAL, 'JULIA', SYSDATE); -- EMP_SBQ를 EMP_SEQ로 수정

-- CURRVAL: 시퀀스의 현재 값을 반환
SELECT EMP_SEQ.CURRVAL FROM DUAL;
-- NEXTVAL : 현재 시퀀스 값을 다음 값을 반환


/*
CURRVAL, NEXTVAL을 사용할 수 있는 경우
1. 서브쿼리가 아닌 SELECT 문
2. INSERT문의 SELECT 문
3. INSERT문의 VALUES 절
4. UPDATE문의 SET 절

CURRVAL, NEXTVAL을 사용할 수 없는 경우
1. VIEW의 SELECT 절
2. DISTINCT 키워드가 있는 SELECT 절
3. GROUP BY, HAVING, ORDER BY 절이 있는 SELECT 문
4. SELECT, DELETE, UPDATE의 서브쿼리
5. CREATE TABLE, ALTER TABLE 명령의 기본값

시퀀스의 수정 삭제
DROP SEQUENCE 시퀀스명;

*/
