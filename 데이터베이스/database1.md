select * from tab;
--아리가또 
/*
아리가또 
아리가또 
아리가또 
아리가또 
아리가또 
아리가또 
*/
desc emp;  -- 테이블 구조 확인
select * from emp;  -- emp 테이블을 모든 사원을 검색하라 
select * from emp ORDER by empno desc; emp 테이블을 모든 사원을 사원번호 기준으로 내침차순 검색하라 
select empno, ename from emp where deptno = 20; 
desc dept;


/*
  select 
  데이터를 조회 하기 위한 dml
  형식
  select 열이름 or 컬럼명  from  테이블명;
*/

select * from tab;  -- 현재 데이터베이스에 저장된 테이블을 출력해라 
show user;

-- dept 테이블의 모든 내용을 출력 하시오 
select * from dept;
select * from emp;


-- 컬럼 이름에 별칭 지정하기
-- 컬럼을 기술한 다음에 as라는 키워드를 쓴 후에 별칭을 기술하면 됨
-- 별칭을 부여할 때 공백문자, $_ # 특수문자를 표현하고 싶거나 대소문자를 구별하고 싶으면 
-- ""을 사용함 as 생략하고 ""를 사용하여 별칭을 부여해도 된다.

select deptno as departmentNo, dname as departmentName from dept;
select deptno departmentNo, dname departmentName from dept;
select deptno "departmentNo", dname "departmentName" from dept;
select deptno "$no", dname "$name" from dept;
select deptno 부서번호, dname 부서이름 from dept;

/*
중복된 데이터를 한번만 출력하는 명령어 
    distinct
    - 조회하고자 하는 컬럼명 앞에 기술한다. 
    ex) emp 테이블에서 컬럼job을 표시하되 중복된 값일 경우 한번만 출력하시오
*/

select distinct job from emp;

/*
where 조건절과 비교연산자 
비교연산자 
= , >, <. >=, <=, 같지 않다, (<>, !=, ^=)
*/

select * from emp;
-- 급여를 3000 이상 받는 사원을 출력하라. 
select empno, ename, sal from emp where sal >= 3000;

-- 급여를 3000 미만인 사원을 출력하라. 
select empno, ename, sal from emp where sal < 3000;


-- 사원 테이블 중에서 부서번호가 10번인 사원을 모든 정보를 출력하라 
select * from emp where deptno = 10;
-- 사원 테이블에서 급여가 2000미만이되는 사원의 정보중 사원번호, 이름, 급여를 출력하라
select empno,ename,sal from emp where sal < 2000;

-- 문자 데이터 조회 
-- 문자 데이터는 반드시 싱글쿼터안에 표시해야한다. 대소문자는 반드시 구분한다.
-- 이름이 scott인 사원에 대하여 사원번호, 사원이름, 급여를 출력하라.
select  empno, ename, sal from emp where ename = 'SCOTT'; 
-- 이름이 MILLER인 사원에 대하여 사원번호, 사원이름, 급여를 출력하라.
select empno, ename, sal from emp where ename = 'MILLER';


-- 날짜 데이터 조회 
-- 반드시 싱글쿼터안에 표시해야한다.
-- 형식: 년/월/일 형식으로 기술함
-- 1985년 이후에 입사한 사원에 사원이름과 입사일을 출력하라 
select ename, hiredate from emp where hiredate >= '1985/01/01';

/*
논리 연산자
and: 두 조건을 모두 만족해야함  
or: 두 조건중 하나라도 만족해도됨 
not: 조건에 만족하지 못하는 것
*/

-- and 연산자는 여러 조건을 만족해야하는 경우 사용함
-- 부서번호가 10번이고 직급이 manager인 사원을 이름, 번호, 직급을 출력하시오
select ename, empno, job from emp where deptno = 10 and job = 'MANAGER';

--급여가 1000에서 3000 사이에 있는 사원을 출력하시오. 
select * from emp where sal >= 1000 and sal <= 3000;

/*
between and 연산자
    - 특정 범위 내에 속하는 데이터를 알아보려고 할때 사용하는 연산자 
      형식:  컬럼명  between 시작 and 종료 
*/
select sal from emp where sal BETWEEN 1000 and 3000;
select sal from emp where sal BETWEEN 1500 and 2500;
select sal from emp where sal not BETWEEN 1500 and 2500;
select sal from emp where sal not BETWEEN 1000 and 3000;

-- or 연산자: 두 조건 중 한가지라도 만족한 경우에 사용함 
--부서 번호가 10번이거나 직급이 manager인 사원을 이름, 번호, 부서번호, 직급을 출력해라
select ename, empno, deptno, job from emp where deptno=10 or job = 'MANAGER';

-- 사원번호가 7844이거나 7654이거나 7521인 사원을 이름 번호를 출력하라
select ename, empno from emp where empno='7844' or empno='7654' or empno ='7521';

/* in 연산자: 동일한 컬럼이 여러 개의 값 중에 하나인지를 알아보고자할때 사용하는 연산자 
            형식: 컬럼명 in(값1, 값2, 값3....) ;
*/
select empno, ename from emp where empno in(7844, 7654, 7521);/* 


/* not: 반대되는 논리값을 구함
*/
-- 부서번호가 10번이 아닌 사원을 부서번호, 이름, 직급을 출력하라
select empno, ename, job, deptno from emp where not deptno = 10;

-- 사원번호가 7844이거나 7654이거나 7521인 사원이 아닌 사원을 번호, 이름을 출력하라 
select empno, ename from emp where not empno = 7844 or empno= 7654 or empno=7521;
select empno, ename from emp where empno not in(7844,7654,7521);


/*
LIKE 연산자
- 검색하고자하는 값을 정확히 모를 경우 와일드 카드와 같이 사용하여 원하는 값을 얻고자할 경우 사용
    컬럼명 like 패턴
    
    와일드 카드 
    % : 문자가 없거나 하나 이상의 문자가 어떤 값이 오든 상관이 없다.
        검색하고자 하는 값을 정확히 모를 경우 사용 
        $는 몇 개 문자가 오든 상관없다는 의미임  
    _: 하나의 문자가 어떤 값이 오든 상관 없음   
    한 문자 대신해서 사용하는 것임
*/

-- %: => 사원 이름이 k로 시작하는 사원의 정보를 출력하라 
select empno, ename from emp where ename like 'K%';
-- %: => 사원 이름이 k로 끝나는 사원의 정보를 출력하라 
select empno, ename from emp where ename like '%K';
-- %: => 사원 이름이 k를 포함하고 있는 사원의 정보를 출력하라 
select empno, ename from emp where ename like '%K%';

-- 이름의 두번째 글자가 A인 사원을 정보를 출력하라 
select empno, ename from emp where ename like '_A%';

-- %: => 이름에 A를 포함하지 않는 사원을 출력하라 
select empno, ename from emp where ename not like '%A%';


/* NULL을 위한 연산자
    오라클에서 컬럼에 null값이 저장되는 것을 허용함.
    null은 미확정, 알 수 없는 값, 0도 아닌 빈공간도 아닌 어떤 값이 존재하지만 어떤 값인지 알수 없다는 의미임 
    
    null은 연산, 할당, 비교가 불가능하다. 
*/

-- 커미션을 받지 않는 사원을 출력해라.
 select ename, comm, job from emp where comm = null;
 -- null이 저장되어 있는 경우에는 비교 연산자로 판정할 수 없다.
 /* is null과 is not null
    - 득점 컬럼값인지를 비교할 경우에는 비교연산자를 사용하지만 null일 경우에는 
    is null 연산자를 사용함 null값이 아닌 경우 is not null 연산자를 사용함
    
    is null: null이면 만족함
    is not null: null이 아니면 만족함 
    - null은 값이 아니므로  = 또는 !=으로 비교할 수 없음
 */
 
  select ename, comm, job from emp where comm is not null;
  
  -- 자신의 직속 상관이 없는 사원의 이름과 직급과 직속 상관의 사원번호를 출력하라 
  select empno, ename, mgr, job from emp where mgr is null; 
  
  
 /*
   정렬을 위한 order by 절
   order by 절은 행을 정렬하는데 사용하며 ,쿼리를 맨 뒤에 기술하며, 정렬의 기준이 되는 
   컬럼명 뒤에 또는 select 절에서 명시된 별칭을 사용할 수 있음 
    
        오름(ASC)             내림(DESC)
 숫자     작은값부터           큰값부터
 문자     사전순으로           사전역순으로    
 날짜     빠른 날짜순으로       늦은 날짜순으로  
 null    가장 마지막에 나옴     가장 먼저 나옴 
 영문자의 경우 소문자를 가장 큰 값으로, null 값은 모든 값중에서 가장 작은 값으로 인식함
 */
 
 --ASC
  -- 사원번호를 기준으로 오름차순 정렬하시오. 
  select empno, ename from emp order by empno asc ;
 -- desc 내림
 select empno, ename from emp order by empno desc ;
 -- 급여가 높은 순으로 출력
 select empno, ename from emp order by sal desc ;
 
-- 입사일이 가장 최근인 사원순으로 번호, 이름, 입사일을 출력하라 
select empno, ename, hiredate from emp order by hiredate desc;


select 24*60*60 from dual;

desc dual;

-- 한개의 문자만을 저장할 수 있고, X라는 값을 가진 단 하나의 행만을 저장하고 있다.
select * from dual;


 
 