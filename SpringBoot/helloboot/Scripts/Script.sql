SELECT * FROM MEMBER;


INSERT INTO MEMBER VALUES('admin', '수원시', 17, 'pajang1515@daum.net', '2023-05-07', '남', '축구', 1234, '관리자');

INSERT INTO MEMBER VALUES('admin1', '수원시2', 17, 'pajang12515@daum.net', '2023-08-07', '남', '농구', 1234, '관리자');

DELETE FROM MEMBER WHERE USERID = 'admin1';

UPDATE member SET username = '관리자' WHERE userid = 'user6';