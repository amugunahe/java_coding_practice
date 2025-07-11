---------------------------------VIEW-----------------------------------
/* VIEW
? ? ? ? 보다란 의미를 갖고 있다.
? ? ? ? 실제 테이블 (물리테이블)에 저장된 데이터를 뷰를 통해서 볼 수 있도록한다.
? ? ? ??
? ? ? ? 뷰는 가상테이블 이는 실제 테이블과 거의 동일하게 사용함
? ? ? ??
? ? ? ? 뷰의 사용 목적
? ? ? ? 1. 직접적인 테이블 접근을 제한하기 위해 사용한다.
? ? ? ? 2. 복잡한 질의를 쉽게 만들기 위해서 사용한다.
? ? ? ??
? ? ? ? 뷰의 특징
? ? ? ? 뷰는 테이블에 대한 제한을 가지고 테이블의 일정한 부분만 보일 수 있는 가상의 테이블이다.
? ? ? ??
? ? ? ? 뷰는 실제 자료를 갖지는 않지만, 뷰를 통해서 테이블은 관리할 수 있다.
? ? ? ? 하나의 테이블에 뷰의 개수는 제한이 없다.?
? ? ? ??
? ? ? ? 기본 테이블
? ? ? ? 뷰에 의해 제한적으로 접근해서 사용하는 실질적으로 데이터를 저장하고 있는
? ? ? ? 물리적인 테이블을 말함
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
?뷰는 테이블처럼 하나의 개체로서 테이블을 생성할 때 유사하게 CREATE VIEW 명령으로 생성한다.
?
?CREATE [OR REPLACE][FORCE]][NOFORCE]VIEW VIEW_NAME
?AS SUBQUERY
?WITH CHECK OPTION
?WITH READ ONLY: -- 조회(SELECT)만 가능함 (INSERT/UPDATE/DELETE) 명령은 사용 불가
?
?[OR REPALCE]
?- 새로운 뷰를 만들 수 있을 뿐만 아니라 기존에 뷰가 존재하더라도 삭제하지 않고?
?새로운 구조의 뷰로 변경할 수 있다.?
?
?[FORCE][NOFORCE]
?- 기본 테이블의 존재 여부에 상괍없이 뷰를 생성한다.
?WITH CHECK OPTION?
?- 해당 뷰를 통해서 볼 수 있는 범위 내에서만 UPDATE 또는 INSERT가 가능함
*/

CREATE VIEW VIEW_EMP01
AS?
SELECT EMPNO, ENAME, SAL, DEPTNO
FROM EMP01
WHERE DEPTNO=10;

SELECT * FROM VIEW_EMP01; -- VIEW_EMP10이 아니라 VIEW_EMP01을 조회하도록 수정했다.

-- 뷰를 작성할 때 기술한 서브쿼리분이 어떻게 작성되어있는지를 확인함
SELECT VIEW_NAME, TEXT FROM USER_VIEWS;


/*
USER VIEWS -> 데이터딕셔너리?
사용자가 생성한 뷰의 모든 뷰에대한 정의가 저장되어 있음
뷰의 이름을 위한 VIEW_NAME, 서브쿼리를 확인할 수 있다.
*/

SELECT VIEW_NAME, TEXT FROM USER_VIEWS;

/*
뷰의 동작 원리
- 사용자가 뷰에 대해서 질의를 하면 USER_VIEWS에서 뷰에 대한 정의를 조회한다.
- 기본 테이블에 대한 뷰의 접근 권한 살핀다.
- 뷰에대한 질의를 기본 테이블에대한 질의로 벼놘한다.
- 기본테이블에 대한 질의를 통해 데이터를 검색한다?
- 검색 결과를 출력한다

뷰의 종류?

단순뷰 (기본테이블이 1개)와 복합뷰 (기본테이블이 1개 이상: 최소 2개 )?
단순뷰와 복합뷰의 비교?
? ? ? ? ? ? ?단순뷰? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ?복합뷰
-----------------------------------------------------------------------
하나의 테이블로 생성? ? ? ? ? ? ? ? ? ? ? ? ? ? ?여러개의 테이블로 생성
그룹함수의 사용이 불가능? ? ? ? ? ? ? ? ? ? ? ? ? ?그룹 함수의 사용이 가능함
DISTINCT 사용이 불가능? ? ? ? ? ? ? ? ? ? ? ? ? ? DISTINCT 사용이 가능함
DML(INSERT/UPDATE/DELETE)이 사용 가능? ? ? ? ? ? ? DML이 사용 불가능
---------------------------------------------------------------
*/

--단순뷰 DML(INSERT/UPDATE/DELTE)이 사용 가능
INSERT INTO VIEW_EMP10 VALUES(8000, 'ANGEL', 7000, 10);
DELETE FROM VIEW_EMP10 WHERE EMPNO=8000;
SELECT * FROM VIEW_EMP10;
SELECT * FROM EMP01;

-- 뷰를 대상으로 실행한 DML 명령은 기본 테이블에 영향을 미친다.?

CREATE OR REPLACE VIEW VIEW_EMP10(사원번호, 사원명, 급여, 부서번호)
AS SELECT EMPNO, ENAME, SAL, DEPTNO FROM EMP01; 

-- 컬럼에 별칭을 사용해서 뷰를 생성하더라도 기본 테이블의 컬럼명에는 영향을 주지 못한다.
SELECT * FROM EMP01;

-- 복합뷰
-- 부서별 급여총액과 평균을 구하는 구하는 작업을 뷰로 생성해보자 
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


-- 뷰삭제 
-- 뷰를 삭제하는 것은 가상테이블이기 때문에 USER_VIEWS에 저장된 뷰의 정의를 삭제하는 것임
DROP VIEW VIEW_SAL;
SELECT VIEW_NAME, TEXT FROM USER_VIEWS;

/*
기본 테이블이 없이 뷰를 생성하기 위한  FORCE 옵션
- 기본 테이블이 없더라도 뷰를 생성할 수 있다. 
*/
SELECT *FROM TAB;
CREATE OR REPLACE FORCE VIEW VIEW_NOTABLE
AS
SELECT EMPNO, ENAME, DEPTNO FROM EMP20 WHERE DEPTNO=10;
SELECT*FROM VIEW_NOTABLE;
/*
WITH CHECK OPTION 
 - 뷰 생성시 조건으로 지정한 컬럼값을 변경하지
    못하도록 하는 것임
*/

CREATE OR REPLACE VIEW VIEW_CHK20
AS
SELECT EMPNO, ENAME, COMM, DEPTNO FROM EMP01 WHERE DEPTNO = 20 WITH CHECK OPTION;

UPDATE VIEW_CHK20
SET DEPTNO = 10
WHERE SAL >= 5000;
-- 급여가 5000이상인 사원을 10번 부서로 이동한다. 
SELECT *FROM VIEW_CHK20; 

-- WITH READ ONLY: 기존 테이블이 어떤 컬럼에 대해서도 내용을 절대 변경할 수 없다
CREATE OR REPLACE VIEW VIEW_READ30
AS
SELECT EMPNO, ENAME, SAL, COMM,DEPTNO FROM EMP01
WHERE DEPTNO=30 WITH READ ONLY; 
UPDATE VIEW_READ30 SET COMM=1000;
----------------------------END VIEW----------------------------------

/* 시퀀스는 유일한 값을 생성해주는 오라클 객체이다. 
시퀀스를 생성하면 기본키와 같이 순차적으로 증가하는 컬럼을 자동적으로 생성할 수 있게 한다.

시퀀스 생성 형식

CREATE SEQUENCE 시퀀스명
START WITH N
INCREMENT BY N 
MAXVALUE N /NOMAXVALUE
MINVALUE N / NOMINVALUE
CYCLE/NOCYCLE
CACHE N / NOCACHE;

START WITH N
- 시퀀스의 시작값을 지정함
INCREMENT BY N 
- 시퀀스의 증가 값을 지정함
MAXVALUE N / NOMAXVALUE
- 최대값 지정/ 무한대로 
ㅡㅑㅜVALUE N / NOMINVALUE
- 최소값 지정/ 무한 소
CYCLE/ NOCYCLE
-최대값까지 증가하면 다시 최소값부터 시작
기본값: 지정하지 않으면 -> NOCYCLE 
CATCH N / NOCACHE
-메모리 상에 시퀀스 값을 관리
기본값은 20임

NOCACHE는 관리 안하겠다
*/

-- 시작 1이고 1씩 증가, 최대값 1000000이 되는 시퀀스를 생성하라.
CREATE SEQUENCE EMP_SEQ
START WITH 1
INCREMENT BY 1
MAXVALUE 100000;

DROP TABLE EMP01;

CREATE TABLE EMP01
AS SELECT EMPNO, ENAME, HIREDATE FROM EMP WHERE 1=0;
SELECT*FROM EMP01;

INSERT INTO EMP01 VALUES(EMP_SBQ.NEXTVAL, 'JULIA', SYSDATE);

-- CURRVAL: 시퀀스의 현재 값을 판환 
SELECT EMP_SEQ.CURRVAL FROM DUAL;
-- NEXTVAL : 현재 시퀀스 값을 다음 값을 반환


/*
currval, nextval을 사용할 수 있는 경우
1. 서브쿼리가 아닌 select 문
2. insert문의 select 문
3. insert문의 value 절
4. update문의 set 절

currval, nextval을 사용할 수 없는 경우
1. view의 select절
2. distinct 키워드가 있는 select절
3. group by, having, order by 절이 있는 select 문
4. select, delete, update의 서브쿼리
5. create table, alter table 명령의 기본값

시퀀스의 수정 삭제
drop sequence 시퀀스명;

*/


