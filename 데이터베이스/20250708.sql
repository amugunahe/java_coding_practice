-- last_day: 해당 월의 마지막 날짜
select sysdate, LAST_DAY(SYSDATE)from dual;

-- round: 한달의 기준일때 16일을 기준으로 반올림
--        한주일때 한주가 시작되는 날짜

-- 입사일을 달 기준으로 반올림 
select hiredate, round(hiredate, 'MONTH') from emp;

-- trunc 함수: 날짜도 잘라낼 수 있다.
--      형식: trunc(date, 'MONTH')
-- 입사일을 월 기준으로 잘라내기

select hiredate, trunc(hiredate, 'MONTH') from emp;

-------------- 변환함수
select sysdate, to_char(sysdate, 'yyyy-mm-dd') from dual;
-- 사원들의 입사일을 출력하되 요일까지 함께 출력하시오.
select to_char(hiredate, 'yyyy/mm/dd day') from emp; 
select to_char(hiredate, 'yyyy/mm/dd dy') from emp;

select ename, hiredate from emp where hiredate = to_date(19810220, 'yyyymmdd');

-- 올해 며칠이 지났는지 계산하는 쿼리문을 작성하시오.
select trunc(sysdate-to_date('2025/01/01', 'yyyy/mm/dd'))from dual;

-- to_number: 문자형의 숫자형으로 변환
select '1000'+ '2000' from dual;
select to_number('10,000', '999,999') + to_number('20,000', '999,999') from dual;

-- 일반 함수 
-- nvl, decode, case 

select nvl(null,3) + 0 from dual;
select ename, sal, comm, job from emp;

-- 연봉을 계산하기 위새 급여에 12를 곱하고 커미션을 더함.
select ename, sal , comm, sal*12, sal*12+nvl(comm, 0) from emp;

-- 모든 사원은 자신의 상관이 있다. 그런데 사원 테이블에 유일하게 상관이 없는 행이 존재한다. 
-- 그 사원의 mgr 컬럼 값이 null임, 상관이 없는 사원만 출력하되, 
-- mgr 컬럼값은 null대신 CEO로 출력하시오.
select ename,nvl(to_char(mgr, '9999'), 'CEO') from emp where ename='KING'; 

--  decode: 조건문 (조건에 맞을 경우 처리하는 함수)

/*
형식 
decode (표현식, 조건1, 결과1,
                조건2, 결과2,
                조건3, 결과3,
                기본결과, n)
*/

select * from dept;
select * from emp;

select deptno,
        decode(deptno,10, 'ACCOUNTING',
                      20, 'RESEARCH',
                      30, 'SALES',
                      40, 'OPPERATIONS') as dname from emp;
                      
                      
/* 조건에 따라 서로 다른 처리가 가능한 case 함수

case 표현식 when 조건1 then 결과1
           when 조건2 then 결과2
           when 조건3 then 결과3
           when 조건4 then 결과4
           else 결과 n
end
*/

select ename, deptno,
        case when deptno=10 then 'ACCOUNTING' 
             when deptno=20 then 'RESEARCH' 
             when deptno=30 then 'SALES'
             when deptno=40 then 'OPERATIONS'
             end dname
             from emp;
             
             
/*
직급에 따라 급여를 인상한다. 
사원명, 사원번호, 직급, 급여를 출력
직급이 'ANALYST' => 5%
      'SALESMAN' => 10%
      'MANAGER' => 15%
      'CLERK' => 20% 인상
      decode 함수를 이용하여 쿼리문을 작성하시오. 
*/

select ename, job,
         decode(job, 'ANALYST', sal * 1.20,
                     'SALESMAN', sal *1.15,
                     'MANAGER', sal *1.10,
                     'CLERK', sal * 1.05,
                sal) as "급여인상" from emp;
                

select ename, job,
         case when job ='ANALYST' then sal * 1.20
              when job = 'SALESMAN'then sal *1.15
              when job = 'MANAGER'then sal *1.10
              when job = 'CLERK'then sal * 1.0
               else sal end as "급여인상" from emp;
               
-- 그룹함수
select sum(sal) from emp;
select avg(sal) from emp;
select max(sal) from emp;
select min(sal) from emp;
select count(comm) from emp;
select count(*), count(comm) from emp;
select count(*), (count(DISTINCT job)) from emp;


-- 사람들을 사원번호를 기준으로 그룹지어라 
select deptno from emp GROUP by deptno;
select deptno, sum(sal), trunc(avg(sal)) from emp GROUP by deptno;
select deptno, max(sal), min(sal) from emp GROUP by deptno;

-- 부서별로 사원수와 커미션을 받는 사원수를 구하시오.
select count(*), count(comm) from emp group by deptno;

-- 급여의 평균이 2000 이상인 부서
select deptno, trunc(avg(sal)) from emp group by deptno having avg(sal) >= 2000;
select deptno, max(sal), min(sal) from emp group by deptno having max(sal) >= 2900;



/* 
join
    한 개 이상의 테이블에서 원하는 결과를 얻기위한 방법
    
    join 종류 
    equi join: 동일한 컬럼을 기준으로 조인 
    NonEqui join: 동일한 컬럼이 없을 경우 조인
    outer join: join 조건에 만족하지 않는 행도 출력
    self join: 한 테이블 내에서 조인
    
    join의 기본 규칙
    1, 기본키와 외래키를 통한 다른 테이블을 행과 연결
    2. 연결 키  사용으로 테이블과 테이블이 결합
    3. where절에서 join 조건을 사용함
    4. 명확성을 위해 컬럼 이름 앞에 테이블명 또는 테이블 별칭을 사용함
*/

select * from emp , dept;  -- cross join: 2개 이상의 테이블이 join될때 공통되는 컬럼의 의한 결합

select ename, dname from emp, dept where emp.deptno= dept. deptno;
select e.ename, d.dname from emp e, dept d where e.deptno= d. deptno and e.ename = 'SCOTT';
select * from  salgrade;
select e.ename, e.sal, s.grade from emp e, salgrade s where e.sal between s.losal and s.hisal;

-- outer join
-- 행이 join 조건에 만족하지 않을 경우 그 행은 결과에 나타나지 않게 되는데 
-- 이때 join 조건에 만족하지 않은 행들도 출력하게 하는 join을 outer join이라고 함

select distinct(deptno) from emp;
select deptno from dept;

--Outer join을 하기 위해서 사용하는 기호는 (+)이며 join 조건에서 정보가 부족한 컬럼명 뒤에 위치하게 하면 된다.
select e.ename, d.deptno, d.dname from emp e, dept d where e.deptno(+)= d.deptno;

-- self join: 자기 자신과 조인을 맺는 것을 말함
select work.ename 사원, manager.ename 매니저  from emp work, emp manager where work.mgr = manager.empno;

-- 사원의 이름과 그의 매니저 이름을 출력하는 쿼리문을 작성하시오.
select w.ename ||'의 매니저는'|| m.ename||'이다' as "그의 매니저" from emp w, emp m where w.mgr=m.empno;


/*
아래의 모든 문제는 조인을 활용하여 쿼리문을 작성하시오.

1. 사원들의 이름, 부서번호, 부서이름을 출력하시오 

2. 부서번호가 30번인 사원들의 이름, 직급, 부서번호, 부서위치를 출력하시오

3. 커미션을 받는 사원의 이름, 커미션, 부서 이름 및 부서 위치 출력하시오 

4. DALAS에 근무하는 사원에 이름, 직급, 부서번호, 부서이름을 출력하시오

5. 이름에 A가 들어가는 사원들의 이름과 부서 이름을 출력하시오

6. 사원 이름과 직급, 급여, 급여 등급을 출력하시오 

7. 사원 이름, 부서이름, 부서번호와 해당 사원과 같은 부서에서 근무하는 사람을 출력하시오. (SELF JOIN)

*/

SELECT E.ENAME, D.DEPTNO, D.DNAME FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO;  --1

SELECT E.ENAME, D.DEPTNO, E.MGR, D.LOC FROM EMP E, DEPT D WHERE E.DEPTNO= 30;   --2

SELECT E.ENAME, D.DEPTNO, D.DNAME FROM EMP E, DEPT D WHERE E.COMM IS NOT NULL;  --3

SELECT E.ENAME, E.JOB, E.DEPTNO, D.DNAME FROM EMP E, DEPT D WHERE D.LOC = 'DALLAS'; --4

SELECT E.ENAME, D.DNAME FROM EMP E, DEPT D WHERE E.ENAME LIKE '%A%'; --5

SELECT E.ENAME, E.JOB, E.SAL, S.GRADE from emp e, salgrade s where e.sal between s.losal and s.hisal; --6

SELECT E.ENAME, E.DEPTNO, D.DNAME FROM EMP E, EMP S, DEPT D  WHERE D.DEPTNO= E.DEPTNO AND E.DEPTNO = S.DEPTNO; --7