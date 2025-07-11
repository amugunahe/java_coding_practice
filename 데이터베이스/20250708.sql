-- last_day: �ش� ���� ������ ��¥
select sysdate, LAST_DAY(SYSDATE)from dual;

-- round: �Ѵ��� �����϶� 16���� �������� �ݿø�
--        �����϶� ���ְ� ���۵Ǵ� ��¥

-- �Ի����� �� �������� �ݿø� 
select hiredate, round(hiredate, 'MONTH') from emp;

-- trunc �Լ�: ��¥�� �߶� �� �ִ�.
--      ����: trunc(date, 'MONTH')
-- �Ի����� �� �������� �߶󳻱�

select hiredate, trunc(hiredate, 'MONTH') from emp;

-------------- ��ȯ�Լ�
select sysdate, to_char(sysdate, 'yyyy-mm-dd') from dual;
-- ������� �Ի����� ����ϵ� ���ϱ��� �Բ� ����Ͻÿ�.
select to_char(hiredate, 'yyyy/mm/dd day') from emp; 
select to_char(hiredate, 'yyyy/mm/dd dy') from emp;

select ename, hiredate from emp where hiredate = to_date(19810220, 'yyyymmdd');

-- ���� ��ĥ�� �������� ����ϴ� �������� �ۼ��Ͻÿ�.
select trunc(sysdate-to_date('2025/01/01', 'yyyy/mm/dd'))from dual;

-- to_number: �������� ���������� ��ȯ
select '1000'+ '2000' from dual;
select to_number('10,000', '999,999') + to_number('20,000', '999,999') from dual;

-- �Ϲ� �Լ� 
-- nvl, decode, case 

select nvl(null,3) + 0 from dual;
select ename, sal, comm, job from emp;

-- ������ ����ϱ� ���� �޿��� 12�� ���ϰ� Ŀ�̼��� ����.
select ename, sal , comm, sal*12, sal*12+nvl(comm, 0) from emp;

-- ��� ����� �ڽ��� ����� �ִ�. �׷��� ��� ���̺� �����ϰ� ����� ���� ���� �����Ѵ�. 
-- �� ����� mgr �÷� ���� null��, ����� ���� ����� ����ϵ�, 
-- mgr �÷����� null��� CEO�� ����Ͻÿ�.
select ename,nvl(to_char(mgr, '9999'), 'CEO') from emp where ename='KING'; 

--  decode: ���ǹ� (���ǿ� ���� ��� ó���ϴ� �Լ�)

/*
���� 
decode (ǥ����, ����1, ���1,
                ����2, ���2,
                ����3, ���3,
                �⺻���, n)
*/

select * from dept;
select * from emp;

select deptno,
        decode(deptno,10, 'ACCOUNTING',
                      20, 'RESEARCH',
                      30, 'SALES',
                      40, 'OPPERATIONS') as dname from emp;
                      
                      
/* ���ǿ� ���� ���� �ٸ� ó���� ������ case �Լ�

case ǥ���� when ����1 then ���1
           when ����2 then ���2
           when ����3 then ���3
           when ����4 then ���4
           else ��� n
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
���޿� ���� �޿��� �λ��Ѵ�. 
�����, �����ȣ, ����, �޿��� ���
������ 'ANALYST' => 5%
      'SALESMAN' => 10%
      'MANAGER' => 15%
      'CLERK' => 20% �λ�
      decode �Լ��� �̿��Ͽ� �������� �ۼ��Ͻÿ�. 
*/

select ename, job,
         decode(job, 'ANALYST', sal * 1.20,
                     'SALESMAN', sal *1.15,
                     'MANAGER', sal *1.10,
                     'CLERK', sal * 1.05,
                sal) as "�޿��λ�" from emp;
                

select ename, job,
         case when job ='ANALYST' then sal * 1.20
              when job = 'SALESMAN'then sal *1.15
              when job = 'MANAGER'then sal *1.10
              when job = 'CLERK'then sal * 1.0
               else sal end as "�޿��λ�" from emp;
               
-- �׷��Լ�
select sum(sal) from emp;
select avg(sal) from emp;
select max(sal) from emp;
select min(sal) from emp;
select count(comm) from emp;
select count(*), count(comm) from emp;
select count(*), (count(DISTINCT job)) from emp;


-- ������� �����ȣ�� �������� �׷������ 
select deptno from emp GROUP by deptno;
select deptno, sum(sal), trunc(avg(sal)) from emp GROUP by deptno;
select deptno, max(sal), min(sal) from emp GROUP by deptno;

-- �μ����� ������� Ŀ�̼��� �޴� ������� ���Ͻÿ�.
select count(*), count(comm) from emp group by deptno;

-- �޿��� ����� 2000 �̻��� �μ�
select deptno, trunc(avg(sal)) from emp group by deptno having avg(sal) >= 2000;
select deptno, max(sal), min(sal) from emp group by deptno having max(sal) >= 2900;



/* 
join
    �� �� �̻��� ���̺��� ���ϴ� ����� ������� ���
    
    join ���� 
    equi join: ������ �÷��� �������� ���� 
    NonEqui join: ������ �÷��� ���� ��� ����
    outer join: join ���ǿ� �������� �ʴ� �൵ ���
    self join: �� ���̺� ������ ����
    
    join�� �⺻ ��Ģ
    1, �⺻Ű�� �ܷ�Ű�� ���� �ٸ� ���̺��� ��� ����
    2. ���� Ű  ������� ���̺�� ���̺��� ����
    3. where������ join ������ �����
    4. ��Ȯ���� ���� �÷� �̸� �տ� ���̺�� �Ǵ� ���̺� ��Ī�� �����
*/

select * from emp , dept;  -- cross join: 2�� �̻��� ���̺��� join�ɶ� ����Ǵ� �÷��� ���� ����

select ename, dname from emp, dept where emp.deptno= dept. deptno;
select e.ename, d.dname from emp e, dept d where e.deptno= d. deptno and e.ename = 'SCOTT';
select * from  salgrade;
select e.ename, e.sal, s.grade from emp e, salgrade s where e.sal between s.losal and s.hisal;

-- outer join
-- ���� join ���ǿ� �������� ���� ��� �� ���� ����� ��Ÿ���� �ʰ� �Ǵµ� 
-- �̶� join ���ǿ� �������� ���� ��鵵 ����ϰ� �ϴ� join�� outer join�̶�� ��

select distinct(deptno) from emp;
select deptno from dept;

--Outer join�� �ϱ� ���ؼ� ����ϴ� ��ȣ�� (+)�̸� join ���ǿ��� ������ ������ �÷��� �ڿ� ��ġ�ϰ� �ϸ� �ȴ�.
select e.ename, d.deptno, d.dname from emp e, dept d where e.deptno(+)= d.deptno;

-- self join: �ڱ� �ڽŰ� ������ �δ� ���� ����
select work.ename ���, manager.ename �Ŵ���  from emp work, emp manager where work.mgr = manager.empno;

-- ����� �̸��� ���� �Ŵ��� �̸��� ����ϴ� �������� �ۼ��Ͻÿ�.
select w.ename ||'�� �Ŵ�����'|| m.ename||'�̴�' as "���� �Ŵ���" from emp w, emp m where w.mgr=m.empno;


/*
�Ʒ��� ��� ������ ������ Ȱ���Ͽ� �������� �ۼ��Ͻÿ�.

1. ������� �̸�, �μ���ȣ, �μ��̸��� ����Ͻÿ� 

2. �μ���ȣ�� 30���� ������� �̸�, ����, �μ���ȣ, �μ���ġ�� ����Ͻÿ�

3. Ŀ�̼��� �޴� ����� �̸�, Ŀ�̼�, �μ� �̸� �� �μ� ��ġ ����Ͻÿ� 

4. DALAS�� �ٹ��ϴ� ����� �̸�, ����, �μ���ȣ, �μ��̸��� ����Ͻÿ�

5. �̸��� A�� ���� ������� �̸��� �μ� �̸��� ����Ͻÿ�

6. ��� �̸��� ����, �޿�, �޿� ����� ����Ͻÿ� 

7. ��� �̸�, �μ��̸�, �μ���ȣ�� �ش� ����� ���� �μ����� �ٹ��ϴ� ����� ����Ͻÿ�. (SELF JOIN)

*/

SELECT E.ENAME, D.DEPTNO, D.DNAME FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO;  --1

SELECT E.ENAME, D.DEPTNO, E.MGR, D.LOC FROM EMP E, DEPT D WHERE E.DEPTNO= 30;   --2

SELECT E.ENAME, D.DEPTNO, D.DNAME FROM EMP E, DEPT D WHERE E.COMM IS NOT NULL;  --3

SELECT E.ENAME, E.JOB, E.DEPTNO, D.DNAME FROM EMP E, DEPT D WHERE D.LOC = 'DALLAS'; --4

SELECT E.ENAME, D.DNAME FROM EMP E, DEPT D WHERE E.ENAME LIKE '%A%'; --5

SELECT E.ENAME, E.JOB, E.SAL, S.GRADE from emp e, salgrade s where e.sal between s.losal and s.hisal; --6

SELECT E.ENAME, E.DEPTNO, D.DNAME FROM EMP E, EMP S, DEPT D  WHERE D.DEPTNO= E.DEPTNO AND E.DEPTNO = S.DEPTNO; --7