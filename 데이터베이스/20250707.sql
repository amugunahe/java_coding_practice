/* 
������ �Լ� 
    �����Լ�
        LOWER: ��� ���ڸ� �ҹ��ڷ� ��ȯ
        UPPER: ��� ���ڸ� �빮�ڷ� ��ȯ 
        INITCAP: �� �ܾ��� ù ���ڸ� �빮�ڷ� ��ȯ 
        CONCAT: �� ���ڿ��� ����
        SUBSTR: ������ ��ġ���� �κ� ���ڿ� ����
        LENGTH: ���ڿ� ���� ��ȯ
        INSTR: Ư�� ������ ��ġ ��ȯ  
        LPAD, RPAD: ���ʿ� ���� ä���ֱ�, �����ʿ� ���� ä���ֱ�                                                        
        CONVERT: ���ڼ� ��ȯ
        CHR: �ƽ�Ű �ڵ尪���� ��ȯ 
        ASCII: �ƽ�Ű �ڵ� ���� ���ڷ� ��ȯ 
        REPLACE: ���ڿ����� Ư�� ���ڿ��� ã�Ƽ� ���� 
        
    �����Լ�
        ABS: ���� ��ȯ
        COS: �ڻ��� �� ��ȯ
        EXP: ���� �Լ� (e^x)�� �¼��� ��ȯ(2�� N��) 
        FLOOR: �Ҽ��� �Ʒ��� ������ �߶����
        LOG: �αװ� ��ȯ
        POWER: ������ ���  
        SIGN: ��ȣ Ȯ�� (+, -, 0) n<0�̸� -1, N=0�̸� 0, N>0�̸� 1�� ��ȯ 
        SIN: ���ΰ� ��ȯ 
        TAN: ź��Ʈ �� ��ȯ 
        ROUND: Ư�� �ڸ��� �ݿø�
        TRUNC: Ư�� �ڸ��� �߶� ����
        MOD: �������� ���� ��ȯ
        
    ��¥�Լ�
        SYSDATE: ���� ��¥�� �ð� ��ȯ
        MONTHS_BETWEEN: �� ��¥ ���̰� ������� ��ȯ
        ADD_MONTHS: Ư�� ��¥�� ���� ���� ���� 
        NEXT_DAY: Ư�� ��¥���� ���ʷ� �����ϴ� ���ڷ� ���� ������ ��¥ 
        LAST_DAY: �ش� ���� ������ ��¥ 
        ROUND: ���ڷ� ���� ��¥�� Ư�� �������� �ݿø�
        TRUNCE: ���ڷ� �޴� ��¥�� Ư�� �������� ����
        
    ��ȯ�Լ�
        TO_CHAR: ����/��¥ �� ���ڷ� ��ȯ 
        TO_DATE: ���� �� ��¥�� ��ȯ 
        TO_NUMBER: ���� �� ������ ��ȯ 
        
    �Ϲ��Լ�
        MVL: ù��° ���ڷ� ���� ���� NULL�� ��� �ι�° ���� ������ ����  
        DBCODE: ù��° ���ڷ� ���� ���� ���ǿ� ���� ������ (if-else ����) 
        CASE: ���ǿ� �´� ������ ������ (switch-case ����)
        
�׷� �Լ� 
            sum, average, count, max, min, stdev, variance 
*/

select 'DataBase', lower('DataBase') from dual;
select lower(ename) from emp;
select 'DataBase', upper('DataBase') from dual;

-- ������ manager�� ����� �˻��Ͻÿ�. 
select empno, ename, job from emp where job = upper ('manager');

select INITCAP('DATA BASE FROGRAMMING') from dual;

-- ��� ���̺��� 10�� �μ� �Ҽ��� �̸��� ù���ڸ� �빮�ڷ� ����Ͻÿ� 
select ename, initcap(ename) from emp where deptno = 10;

-- 'Smith'�� �̸��� ���� ����� ��ȣ, �̸�, �޿�, Ŀ�̼��� ����ϵ�, (initcap, upper) ����Ͽ� ��� 
select empno, initcap(ename), sal, comm from emp where ename = upper('Smith');

select concat('Data', 'Base') from dual;
select length ('DataBase'), length('�����ͺ��̽�'), lengthB('�����ͺ��̽�') from dual;

-- ������ �̸��� 4���� ������ �̸��� �ҹ��ڷ� ����Ͻÿ� 
select empno, lower(ename) from emp where length(ename)=4;

-- �̸��� 6���� �̻��� ����� ��� ��ȣ, �̸�, �޿��� ����Ͻÿ�.
select empno, ename, sal from emp where length(ename)>=6;

select  substr('database', -4, 3) from dual;

-- 20�� �μ� ������� �Ի�⵵�� �����Ͽ� ����Ͻÿ�.
select ename, hiredate,substr(hiredate, 1, 2)from emp where deptno = 20 and substr(hiredate, 1, 2) =87;

-- �̸��� K�� ������ ������ �˻��Ͻÿ�
select ename from emp where substr(ename, -1, 1)='K';
select ename from emp where ename like '%K';

select instr('DataBase','a', 1, 3) from dual;
select instr('DataBase','B') from dual;
select instrb('�����ͺ��̽�','��', 7, 1) from dual;

-- �̸��� �ι�° �ڸ��� A�� �ִ� ����� �����ȣ, �̸�, ������ ����϶�
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

-- �����Լ�
select abs(-41) from  dual;
select floor(34.5678) from dual;
select round (35.12, 1) from dual;
select round(47.51,0) from dual;

-- ���� �ڸ����� �ݿø� 
select round(834.12, -1) from dual;

-- ���� �ڸ����� �ݿø�
select round(834.12, -2) from dual;

select trunc(12.345, 2) from dual;

select mod(34, 5) from dual;


--�����ȣ�� ¦���� ������� ����� �̸��� ������ ����ض� 

select empno, ename, job from emp where mod(empno, 2)=0;

-- ��¥�Լ�
-- ���� ��¥
select sysdate-1 ����, sysdate ����, sysdate+1 ���� from dual; 

-- �μ���ȣ�� 10���� ����� ������� �Ի��� ���� ���� ���ñ��� ��ĥ�� �귶���� �ٹ��ϼ��� ���Ͻÿ� 
select empno, hiredate, trunc(sysdate-hiredate) �ٹ��ϼ� from emp;   

-- ������ �������� 
select sysdate, hiredate, trunc(months_between(sysdate, hiredate)) from emp where deptno = 10; 

-- ������� ���ϴ� add_months �Լ�
-- �Ի��Ͽ��� 3������ ���� ��¥�� ���Ͽ� ����Ͻÿ�. 
select ename, hiredate, add_months(hiredate, 3) from emp where deptno = 10;


-- �ش� ������ ���� ����� ��¥�� ��ȯ�ϴ� �Լ� (next_day) 
-- ������ �������� ���ʷ� �ٰ����� �Ͽ����� �����ΰ�
select sysdate, next_day(sysdate, '�Ͽ���') from dual; 
select sysdate, next_day(sysdate, '��') from dual; 
select sysdate, next_day(sysdate, 1) from dual;
-- ������ ����� ����� ��쿡�� �� AMERICAN ���� �����ϸ� �� 
alter session set nls_language = American; --������ ���
alter session set nls_language = KOREAN;   --�ѱ��� ���
select sysdate, next_day(sysdate, 'sunday') from dual;
select sysdate, next_day(sysdate, 'sun') from dual;
select sysdate, next_day(sysdate, 1) from dual;