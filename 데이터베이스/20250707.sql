/* 
단일행 함수 
    문자함수
        LOWER: 모든 문자를 소문자로 변환
        UPPER: 모든 문자를 대문자로 변환 
        INITCAP: 각 단어의 첫 글자만 대문자로 변환 
        CONCAT: 두 문자열을 연결
        SUBSTR: 지정한 위치부터 부분 문자열 추출
        LENGTH: 문자열 길이 반환
        INSTR: 특정 문자의 위치 반환  
        LPAD, RPAD: 왼쪽에 문자 채워넣기, 오른쪽에 문자 채워넣기                                                        
        CONVERT: 문자셋 변환
        CHR: 아스키 코드값으로 변환 
        ASCII: 아스키 코드 값을 문자로 변환 
        REPLACE: 문자열에서 특정 문자열을 찾아서 변경 
        
    숫자함수
        ABS: 절댓값 반환
        COS: 코사인 값 반환
        EXP: 지수 함수 (e^x)ㅡ 승수로 반환(2의 N승) 
        FLOOR: 소수점 아래는 무조건 잘라버림
        LOG: 로그값 반환
        POWER: 제곱값 계산  
        SIGN: 부호 확인 (+, -, 0) n<0이면 -1, N=0이면 0, N>0이면 1을 반환 
        SIN: 사인값 반환 
        TAN: 탄젠트 값 반환 
        ROUND: 특정 자릿수 반올림
        TRUNC: 특정 자릿수 잘라 버림
        MOD: 나머지를 값을 반환
        
    날짜함수
        SYSDATE: 현재 날짜와 시간 반환
        MONTHS_BETWEEN: 두 날짜 사이가 몇개월인지 반환
        ADD_MONTHS: 특정 날짜에 개월 수를 더함 
        NEXT_DAY: 특정 날짜에서 최초로 도래하는 인자로 받은 요일의 날짜 
        LAST_DAY: 해당 월의 마지막 날짜 
        ROUND: 인자로 받은 날짜를 특정 기준으로 반올림
        TRUNCE: 인자로 받는 날짜를 특정 기준으로 버림
        
    변환함수
        TO_CHAR: 숫자/날짜 → 문자로 변환 
        TO_DATE: 문자 → 날짜형 변환 
        TO_NUMBER: 문자 → 숫자형 변환 
        
    일반함수
        MVL: 첫번째 인자로 받은 값이 NULL일 경우 두번째 인자 값으로 변경  
        DBCODE: 첫번째 인자로 받은 값을 조건에 맞춰 변경함 (if-else 유사) 
        CASE: 조건에 맞는 문장을 수행함 (switch-case 유사)
        
그룹 함수 
            sum, average, count, max, min, stdev, variance 
*/

select 'DataBase', lower('DataBase') from dual;
select lower(ename) from emp;
select 'DataBase', upper('DataBase') from dual;

-- 직급이 manager인 사원을 검색하시오. 
select empno, ename, job from emp where job = upper ('manager');

select INITCAP('DATA BASE FROGRAMMING') from dual;

-- 사원 테이블의 10번 부서 소속의 이름의 첫글자만 대문자로 출력하시오 
select ename, initcap(ename) from emp where deptno = 10;

-- 'Smith'란 이름을 가진 사원의 번호, 이름, 급여, 커미션을 출력하되, (initcap, upper) 사용하여 출력 
select empno, initcap(ename), sal, comm from emp where ename = upper('Smith');

select concat('Data', 'Base') from dual;
select length ('DataBase'), length('데이터베이스'), lengthB('데이터베이스') from dual;

-- 직원중 이름이 4자인 직원의 이름을 소문자로 출력하시오 
select empno, lower(ename) from emp where length(ename)=4;

-- 이름이 6글자 이상인 사원의 사원 번호, 이름, 급여를 출력하시오.
select empno, ename, sal from emp where length(ename)>=6;

select  substr('database', -4, 3) from dual;

-- 20번 부서 사원들중 입사년도를 추출하여 출력하시오.
select ename, hiredate,substr(hiredate, 1, 2)from emp where deptno = 20 and substr(hiredate, 1, 2) =87;

-- 이름이 K로 끝나는 직원을 검색하시오
select ename from emp where substr(ename, -1, 1)='K';
select ename from emp where ename like '%K';

select instr('DataBase','a', 1, 3) from dual;
select instr('DataBase','B') from dual;
select instrb('데이터베이스','이', 7, 1) from dual;

-- 이름의 두번째 자리에 A가 있는 사원의 사원번호, 이름, 직급을 출력하라
select empno, ename from emp where ename like '_A%';
select empno, ename from emp where instr(ename, 'A', 2, 1) = 2;

select  LPAD ('DataBase' ,20,'#') from dual;
select  RPAD ('DataBase' ,20,'#') from dual;

select  trim (LEADING from '        DataBase        ' ) from dual;
select  trim (TRAILING from '        DataBase        ' ) from dual;
select  trim (BOTH from '        DataBase        ' ) from dual;
-- smith => mit 

select ename, trim ('S' from ename) from emp where ename = 'SMITH';
select ename, trim ('H' from ename) from emp where ename = 'SMITH';

-- 숫자함수
select abs(-41) from  dual;
select floor(34.5678) from dual;
select round (35.12, 1) from dual;
select round(47.51,0) from dual;

-- 일의 자리에서 반올림 
select round(834.12, -1) from dual;

-- 십의 자리에서 반올림
select round(834.12, -2) from dual;

select trunc(12.345, 2) from dual;

select mod(34, 5) from dual;


--사원번호가 짝수인 사원들의 사번과 이름과 직급을 출력해라 

select empno, ename, job from emp where mod(empno, 2)=0;

-- 날짜함수
-- 현재 날짜
select sysdate-1 어제, sysdate 오늘, sysdate+1 내일 from dual; 

-- 부서번호가 10번인 사원을 대상으로 입사한 날로 부터 오늘까지 며칠이 흘렀을까 근무일수를 구하시오 
select empno, hiredate, trunc(sysdate-hiredate) 근무일수 from emp;   

-- 오늘의 기준으로 
select sysdate, hiredate, trunc(months_between(sysdate, hiredate)) from emp where deptno = 10; 

-- 개울수를 더하는 add_months 함수
-- 입사일에서 3개월이 지난 날짜를 구하여 출력하시오. 
select ename, hiredate, add_months(hiredate, 3) from emp where deptno = 10;


-- 해당 요일의 가장 가까운 날짜를 반환하는 함수 (next_day) 
-- 오늘을 기준으로 최초로 다가오는 일요일은 언제인가
select sysdate, next_day(sysdate, '일요일') from dual; 
select sysdate, next_day(sysdate, '일') from dual; 
select sysdate, next_day(sysdate, 1) from dual;
-- 요일의 영어로 사용할 경우에는 언어를 AMERICAN 으로 지정하면 됨 
alter session set nls_language = American; --영어일 경우
alter session set nls_language = KOREAN;   --한글일 경우
select sysdate, next_day(sysdate, 'sunday') from dual;
select sysdate, next_day(sysdate, 'sun') from dual;
select sysdate, next_day(sysdate, 1) from dual;