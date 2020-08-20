CREATE SEQUENCE MEMBER_SEQ
START WITH 1
INCREMENT BY 1
MINVALUE 1
MAXVALUE 99999;

drop sequence MEMBER_SEQ;

create table MEMBER(
  ID int primary key,
  EMAIL varchar(255) unique,
  PASSWORD varchar2(100),
  NAME varchar2(100),
  REGDATE date
);

insert into MEMBER values(MEMBER_SEQ.nextval, 'garnet2929@naver.com', '1234', 'lkc', sysdate);

delete from MEMBER;

select * from MEMBER;

commit;