create table "STUDENT"(
	"STUDENT_NO" number primary key,
	"STUDENT_NAME" varchar2(30) not null,
	"STUDENT_TEL" char(11) not null,
	"STUDENT_EMAIL" varchar2(50),
	"STUDENT_ADDR" varchar2(256),
	"REG_DATE" date default sysdate
);

create sequence "STUDENT_SEQ";

insert into STUDENT values (
	 STUDENT_SEQ.nextval, '홍길동', '01012345678', 'test@naver.com', '서울 강남', 
	default);
  
commit;
  
select * from "STUDENT" order by "REG_DATE" desc;

