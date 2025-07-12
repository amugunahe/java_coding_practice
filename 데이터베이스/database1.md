SELECT * FROM TAB; -- 아리가또 /* 아리가또 아리가또 아리가또 아리가또 아리가또 아리가또 */

DESC EMP; -- 테이블 구조 확인
SELECT * FROM EMP; -- EMP 테이블의 모든 사원을 검색하라
SELECT * FROM EMP ORDER BY EMPNO DESC; -- EMP 테이블의 모든 사원을 사원번호 기준으로 내림차순 검색하라
SELECT EMPNO, ENAME FROM EMP WHERE DEPTNO = 20;
DESC DEPT;

/* SELECT 데이터를 조회하기 위한 DML 형식
SELECT 열이름 OR 컬럼명 FROM 테이블명; */

SELECT * FROM TAB; -- 현재 데이터베이스에 저장된 테이블을 출력해라
SHOW USER;

-- DEPT 테이블의 모든 내용을 출력하시오
SELECT * FROM DEPT;
SELECT * FROM EMP;

-- 컬럼 이름에 별칭 지정하기
-- 컬럼을 기술한 다음에 AS라는 키워드를 쓴 후에 별칭을 기술하면 됨.
-- 별칭을 부여할 때 공백문자, 특수문자($, #)를 표현하고 싶거나 대소문자를 구별하고 싶으면
-- ""을 사용함. AS 생략하고 ""를 사용하여 별칭을 부여해도 된다.
SELECT DEPTNO AS DEPARTMENTNO, DNAME AS DEPARTMENTNAME FROM DEPT;
SELECT DEPTNO DEPARTMENTNO, DNAME DEPARTMENTNAME FROM DEPT;
SELECT DEPTNO "departmentNo", DNAME "departmentName" FROM DEPT;
SELECT DEPTNO "$no", DNAME "$name" FROM DEPT;
SELECT DEPTNO 부서번호, DNAME 부서이름 FROM DEPT;

/* 중복된 데이터를 한 번만 출력하는 명령어 DISTINCT
- 조회하고자 하는 컬럼명 앞에 기술한다.
EX) EMP 테이블에서 JOB 컬럼을 표시하되 중복된 값일 경우 한 번만 출력하시오.
*/
SELECT DISTINCT JOB FROM EMP;

/* WHERE 조건절과 비교연산자
비교연산자: = , >, <. >=, <=, 같지 않다 (<>, !=, ^=)
*/
SELECT * FROM EMP;
-- 급여를 3000 이상 받는 사원을 출력하라.

SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL >= 3000;
-- 급여를 3000 미만인 사원을 출력하라.

SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL < 3000;
-- 사원 테이블 중에서 부서번호가 10번인 사원의 모든 정보를 출력하라.

SELECT * FROM EMP WHERE DEPTNO = 10;
-- 사원 테이블에서 급여가 2000 미만인 사원의 정보 중 사원번호, 이름, 급여를 출력하라.

SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL < 2000;

-- 문자 데이터 조회
-- 문자 데이터는 반드시 싱글 쿼터 안에 표시해야 한다. 대소문자는 반드시 구분한다.
-- 이름이 SCOTT인 사원에 대하여 사원번호, 사원이름, 급여를 출력하라.
SELECT EMPNO, ENAME, SAL FROM EMP WHERE ENAME = 'SCOTT';
-- 이름이 MILLER인 사원에 대하여 사원번호, 사원이름, 급여를 출력하라.
SELECT EMPNO, ENAME, SAL FROM EMP WHERE ENAME = 'MILLER';

-- 날짜 데이터 조회
-- 반드시 싱글 쿼터 안에 표시해야 한다.
-- 형식: 년/월/일 형식으로 기술함.
-- 1985년 이후에 입사한 사원의 사원이름과 입사일을 출력하라.
SELECT ENAME, HIREDATE FROM EMP WHERE HIREDATE >= '1985/01/01';

/* 논리 연산자
AND: 두 조건을 모두 만족해야 함.
OR: 두 조건 중 하나라도 만족해도 됨.
NOT: 조건에 만족하지 못하는 것.
*/

-- AND 연산자는 여러 조건을 만족해야 하는 경우 사용함.
-- 부서번호가 10번이고 직급이 MANAGER인 사원을 이름, 번호, 직급을 출력하시오.
SELECT ENAME, EMPNO, JOB FROM EMP WHERE DEPTNO = 10 AND JOB = 'MANAGER';
-- 급여가 1000에서 3000 사이에 있는 사원을 출력하시오.
SELECT * FROM EMP WHERE SAL >= 1000 AND SAL <= 3000;

/* BETWEEN AND 연산자
- 특정 범위 내에 속하는 데이터를 알아보려고 할 때 사용하는 연산자.
형식: 컬럼명 BETWEEN 시작 AND 종료*/

SELECT SAL FROM EMP WHERE SAL BETWEEN 1000 AND 3000;
SELECT SAL FROM EMP WHERE SAL BETWEEN 1500 AND 2500;
SELECT SAL FROM EMP WHERE SAL NOT BETWEEN 1500 AND 2500;
SELECT SAL FROM EMP WHERE SAL NOT BETWEEN 1000 AND 3000;

-- OR 연산자: 두 조건 중 한 가지라도 만족한 경우에 사용함.

-- 부서 번호가 10번이거나 직급이 MANAGER인 사원을 이름, 번호, 부서번호, 직급을 출력해라.
SELECT ENAME, EMPNO, DEPTNO, JOB FROM EMP WHERE DEPTNO = 10 OR JOB = 'MANAGER';

-- 사원번호가 7844이거나 7654이거나 7521인 사원을 이름, 번호를 출력하라.
SELECT ENAME, EMPNO FROM EMP WHERE EMPNO = 7844 OR EMPNO = 7654 OR EMPNO = 7521;

/* IN 연산자
- 동일한 컬럼이 여러 개의 값 중에 하나인지를 알아보고자 할 때 사용하는 연산자.
형식: 컬럼명 IN (값1, 값2, 값3....);*/
SELECT EMPNO, ENAME FROM EMP WHERE EMPNO IN (7844, 7654, 7521);

/* NOT: 반대되는 논리값을 구함 */
-- 부서번호가 10번이 아닌 사원을 부서번호, 이름, 직급을 출력하라.
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE NOT DEPTNO = 10;

-- 사원번호가 7844이거나 7654이거나 7521인 사원이 아닌 사원을 번호, 이름을 출력하라.
SELECT EMPNO, ENAME FROM EMP WHERE NOT (EMPNO = 7844 OR EMPNO = 7654 OR EMPNO = 7521);
SELECT EMPNO, ENAME FROM EMP WHERE EMPNO NOT IN (7844, 7654, 7521);

/* LIKE 연산자
검색하고자 하는 값을 정확히 모를 경우 와일드 카드와 같이 사용하여 원하는 값을 얻고자 할 경우 사용.
컬럼명 LIKE 패턴

와일드 카드
% : 문자가 없거나 하나 이상의 문자가 어떤 값이 오든 상관이 없다. 검색하고자 하는 값을 정확히 모를 경우 사용.
_ : 하나의 문자가 어떤 값이 오든 상관 없음. 한 문자 대신해서 사용하는 것임.
*/

-- %: 사원 이름이 K로 시작하는 사원의 정보를 출력하라.
SELECT EMPNO, ENAME FROM EMP WHERE ENAME LIKE 'K%';

-- %: 사원 이름이 K로 끝나는 사원의 정보를 출력하라.
SELECT EMPNO, ENAME FROM EMP WHERE ENAME LIKE '%K';

-- %: 사원 이름이 K를 포함하고 있는 사원의 정보를 출력하라.
SELECT EMPNO, ENAME FROM EMP WHERE ENAME LIKE '%K%';

-- 이름의 두 번째 글자가 A인 사원의 정보를 출력하라.
SELECT EMPNO, ENAME FROM EMP WHERE ENAME LIKE '_A%';

-- %: 이름에 A를 포함하지 않는 사원을 출력하라.
SELECT EMPNO, ENAME FROM EMP WHERE ENAME NOT LIKE '%A%';

/* NULL을 위한 연산자
오라클에서 컬럼에 NULL값이 저장되는 것을 허용함.
NULL은 미확정, 알 수 없는 값, 0도 아닌 빈 공간도 아닌 어떤 값이 존재하지만 어떤 값인지 알 수 없다는 의미임.
NULL은 연산, 할당, 비교가 불가능하다.
*/

-- 커미션을 받지 않는 사원을 출력해라.
-- SELECT ENAME, COMM, JOB FROM EMP WHERE COMM = NULL; -- NULL이 저장되어 있는 경우에는 비교 연산자로 판정할 수 없다.

/* IS NULL과 IS NOT NULL
- 특정 컬럼값이 NULL인지를 비교할 경우에는 IS NULL 연산자를 사용하지만, NULL이 아닐 경우에는 IS NOT NULL 연산자를 사용함.
IS NULL: NULL이면 만족함.
IS NOT NULL: NULL이 아니면 만족함.
- NULL은 값이 아니므로 = 또는 !=으로 비교할 수 없음.

*/
SELECT ENAME, COMM, JOB FROM EMP WHERE COMM IS NOT NULL;
-- 자신의 직속 상관이 없는 사원의 이름과 직급과 직속 상관의 사원번호를 출력하라.

SELECT EMPNO, ENAME, MGR, JOB FROM EMP WHERE MGR IS NULL;

/* 정렬을 위한 ORDER BY 절
ORDER BY 절은 행을 정렬하는 데 사용하며, 쿼리를 맨 뒤에 기술하며, 정렬의 기준이 되는 컬럼명 뒤에 또는 SELECT 절에서 명시된 별칭을 사용할 수 있음.
    오름차순 (ASC)          내림차순 (DESC)

숫자  작은값부터 큰값으로      큰값부터 작은값으로
문자  사전순으로             사전 역순으로
날짜  빠른 날짜순으로        늦은 날짜순으로
NULL 가장 마지막에 나옴     가장 먼저 나옴
(영문자의 경우 소문자를 가장 큰 값으로, NULL 값은 모든 값 중에서 가장 작은 값으로 인식함.)
*/

-- ASC -- 사원번호를 기준으로 오름차순 정렬하시오.
SELECT EMPNO, ENAME FROM EMP ORDER BY EMPNO ASC;

-- DESC 내림차순
SELECT EMPNO, ENAME FROM EMP ORDER BY EMPNO DESC;

-- 급여가 높은 순으로 출력
SELECT EMPNO, ENAME FROM EMP ORDER BY SAL DESC;

-- 입사일이 가장 최근인 사원순으로 번호, 이름, 입사일을 출력하라.
SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC;

SELECT 246060 FROM DUAL;
DESC DUAL;

-- 한 개의 문자만을 저장할 수 있고, X라는 값을 가진 단 하나의 행만을 저장하고 있다.
SELECT * FROM DUAL;
