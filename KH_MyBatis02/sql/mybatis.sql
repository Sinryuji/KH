create table "MEMBER02"(
 "USER_NO" number primary key,
 "USER_ID" varchar2(20) not null,
 "USER_PW" varchar2(20) not null,
 "USER_NAME" varchar2(20) not null,
 "USER_ADDR" varchar2(50) not null,
 "REG_DATE" date default sysdate
);

create sequence "SEQ_MEMBER02";

insert into member02 values(SEQ_MEMBER02.nextval, 'test1', '1234', '테스트', '서울시', default);
insert into member02 values(SEQ_MEMBER02.nextval, 'test2', '2222', '테스터', '경기도', default);
insert into member02 values(SEQ_MEMBER02.nextval, 'test3', '3333', '테스터3', '강원도', default);

commit;

select * from "MEMBER02";