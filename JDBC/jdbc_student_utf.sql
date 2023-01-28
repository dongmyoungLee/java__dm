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

comment on column member.member_id is '회원 아이디';
comment on column member.member_pwd is '비밀번호';
comment on column member.member_name is '비밀번호';
comment on column member.gender is '성별(M,F)';
comment on column member.age is '나이';
comment on column member.email is '이메일';
comment on column member.phone is '전화번호';
comment on column member.address is '주소';
comment on column member.hobby is '취미';
comment on column member.enroll_date is '가입일';
select * from member;

insert into member values('admin','admin','관리자','M', 30, 'admin@iei.or.kr', '0101234678','서울시 강남구 역삼동 테헤란로 7','기타,독서,운동','16/03/15');
insert into member values('user11','pass11','홍길동','M', 23, 'hong@kh.org', '01017778888','경기도 수원시 팔달구 팔달동 77','운동,등산,기타','17/09/21');
insert into member values('user22','pass22','신사임당','F', 48, 'shin50@kh.org', '01050005555','강원도 강릉시 오죽헌 5','독서,그림,요리','17/05/05');
insert into member values('user77','user77','이순신','M', 50, 'dltnstls@naver.com', '01021226374','경기도 시흥시','음악','17/12/08');
insert into member values('lsj','lsj','이선주','F', 24, 'dltjswn@naver.com', '01021226377','경기도 안산시','운동,음악,댄스','17/08/25');
insert into member values('seonn','seonn','김공부','F', 28, 'study11@naver.com', '01021226312','경기도 성남시','공부,책읽기','17/11/08');

commit;
select * from member;
