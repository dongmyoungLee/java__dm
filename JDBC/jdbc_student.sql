drop table member;
create table member(
Member_id varchar2(15) primary key,
member_pwd varchar2(15) not null,
member_name varchar2(20) not null,
gender char(1) check(gender in ('M','F')),
age number not null,
email varchar2(30),
phone char(11),
address varchar2(500),
hobby varchar2(50),
enroll_date date default sysdate
);

comment on column member.member_id is 'ȸ�� ���̵�';
comment on column member.member_pwd is '��й�ȣ';
comment on column member.member_name is '��й�ȣ';
comment on column member.gender is '����(M,F)';
comment on column member.age is '����';
comment on column member.email is '�̸���';
comment on column member.phone is '��ȭ��ȣ';
comment on column member.address is '�ּ�';
comment on column member.hobby is '���';
comment on column member.enroll_date is '������';
select * from member;

insert into member values('admin','admin','������','M', 30, 'admin@iei.or.kr', '0101234678','����� ������ ���ﵿ ������� 7','��Ÿ,����,�','16/03/15');
insert into member values('user11','pass11','ȫ�浿','M', 23, 'hong@kh.org', '01017778888','��⵵ ������ �ȴޱ� �ȴ޵� 77','�,���,��Ÿ','17/09/21');
insert into member values('user22','pass22','�Ż��Ӵ�','F', 48, 'shin50@kh.org', '01050005555','������ ������ ������ 5','����,�׸�,�丮','17/05/05');
insert into member values('user77','user77','�̼���','M', 50, 'dltnstls@naver.com', '01021226374','��⵵ �����','����','17/12/08');
insert into member values('lsj','lsj','�̼���','F', 24, 'dltjswn@naver.com', '01021226377','��⵵ �Ȼ��','�,����,��','17/08/25');
insert into member values('seonn','seonn','�����','F', 28, 'study11@naver.com', '01021226312','��⵵ ������','����,å�б�','17/11/08');

commit;
select * from member;
