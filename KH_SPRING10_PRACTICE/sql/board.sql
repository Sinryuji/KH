create sequence BOARD_SEQ
  start with 1
  increment by 1
  minvalue 1
  maxvalue 99999;
  
create table BOARD(
  SEQ int primary key,
  TITLE varchar2(255) not null,
  CONTENT varchar(1000) not null,
  WRITER varchar(10) not null,
  PASSWORD int not null,
  REGDATE timestamp not null,
  cnt int not null
);

insert into BOARD values (BOARD_SEQ.nextval, 't1', 'c1', 'w1', 1234, '2015-10-10 14:21:12', 1);

insert into BOARD values (BOARD_SEQ.nextval, 't2', 'c2', 'w2', 1234, '2015-10-10 14:21:12', 2);

insert into BOARD values (BOARD_SEQ.nextval, 't3', 'c3', 'w3', 1234, '2015-10-10 14:21:12', 3);

insert into BOARD values (BOARD_SEQ.nextval, 't4', 'c4', 'w4', 1234, '2015-10-10 14:21:12', 4);

insert into BOARD values (BOARD_SEQ.nextval, 't5', 'c5', 'w5', 1234, '2015-10-10 14:21:12', 5);

insert into BOARD values (BOARD_SEQ.nextval, 't6', 'c6', 'w6', 1234, '2015-10-10 14:21:12', 6);

insert into BOARD values (BOARD_SEQ.nextval, 't7', 'c7', 'w7', 1234, '2015-10-10 14:21:12', 7);

select * from BOARD;

SELECT * FROM BOARD ORDER BY SEQ;

drop table BOARD;

drop sequence BOARD_SEQ;

commit;