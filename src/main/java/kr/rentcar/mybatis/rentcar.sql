create database rentcarDB;
use rentcarDB;
drop table if exists user;
create table user(
  num int auto_increment primary key,
  name varchar(30) not null,
  userid varchar(30) unique key not null,
  pwd varchar(30) not null,
  email varchar(30) not null,
  phone varchar(30) not null
);
select* from user;

drop table if exists rentcar;
CREATE TABLE rentcar(
	num INT auto_increment primary key, -- 렌트카 고유 번호 
    name VARCHAR(20), -- 차량 이름
    category INT, -- 차량 종류 
    price INT, -- 렌트 가격
    usepeople INT, -- 승차 인원
	total_qty int, -- 렌트카 총 수량 
    company VARCHAR(50), -- 차량 회사 정보
    img VARCHAR(50), -- 차량 이미지 
    info VARCHAR(500) -- 차량 정보 
);
INSERT INTO rentcar VALUES (1, '아반테', 1,  2000, 4, 10,'기아', '1.jpg' , '아반테 자동차 입니다.');
INSERT INTO rentcar VALUES (2, 'BMW', 3,  6000, 4, 1, 'BMW', '2.jpg' , 'BMW 자동차 입니다.');
INSERT INTO rentcar VALUES (3, '카니발', 1,  4000, 7, 3,'기아', '3.jpg' , '카니발 자동차 입니다.');
INSERT INTO rentcar VALUES (4, '카렌스', 2,  2500, 4, 0,'기아', '4.jpg' , '카렌스 자동차 입니다.');
INSERT INTO rentcar VALUES (5, '코란도', 1,  3000, 4, 5,'현대', '5.jpg' , '코란도 자동차 입니다.');
INSERT INTO rentcar VALUES (6, '에쿠스', 3,  6000, 4, 2,'BMW', '6.jpg' , '에쿠스 자동차 입니다.');
INSERT INTO rentcar VALUES (7, '제네시스', 1,  3000, 4, 4,'기아', '7.jpg' , '제네시스 자동차 입니다.');
INSERT INTO rentcar VALUES (8, '그랜져', 1,  2400, 4, 10,'현대', '8.jpg' , '그랜져 자동차 입니다.');
INSERT INTO rentcar VALUES (9, 'k3', 1,  2700, 4, 2,'현대', '9.jpg' , 'k3 자동차 입니다.');
INSERT INTO rentcar VALUES (10, 'k5', 2,  5000, 4, 3,'기아', '10.jpg' , 'k5 자동차 입니다.');
INSERT INTO rentcar VALUES (11, 'k9', 1,  6000, 4, 2,'현대', '11.jpg' , 'k9 자동차 입니다.');
INSERT INTO rentcar VALUES (12, '라세티', 2,  2000, 5,4, '기아', '12.jpg' , '라세티 자동차 입니다.');
INSERT INTO rentcar VALUES (13, '소나타', 1,  2000, 4, 7,'현대', '13.jpg' , 'lf소나타 자동차 입니다.');
INSERT INTO rentcar VALUES (14, '말리부', 3,  2000, 4, 8,'BMW', '14.jpg' , '말리부 자동차 입니다.');
INSERT INTO rentcar VALUES (15, '모닝', 1,  23000, 4, 9,'현대', '15.jpg' , '모닝 자동차 입니다.');
INSERT INTO rentcar VALUES (16, '올라도', 3,  5000, 4, 10,'BMW', '16.jpg' , '올라도 자동차 입니다.');
INSERT INTO rentcar VALUES (17, '레이', 2,  4000, 4, 10,'현대', '17.jpg' , '레이 자동차 입니다.');
INSERT INTO rentcar VALUES (18, 'SM5', 1,  2700, 4, 10,'BMW', '18.jpg' , 'SM5 자동차 입니다.');
drop table if exists reservation;
CREATE TABLE reservation(
	reserve_seq int auto_increment primary key, -- 차량 예약 정보 번호
    num INT, -- 렌트카 고유 번호 
    userid VARCHAR(50),-- 고객 id 
    qty INT, -- 렌트한 수량 
    dday INT, -- 대여기간
    rday VARCHAR(50), -- 대여일 
    usein INT, -- 운전자 보험여부
    usewifi INT,-- 인터넷 여부 
    usenavi INT,-- 네비게이션 대여 여부 
    useseat INT-- 베이비시트 적용 
-- CONSTRAINT fk_num FOREIGN KEY(num) REFERENCES rentcar(num) ON DELETE CASCADE on update cascade ,
--  CONSTRAINT fk_id FOREIGN KEY(userid) REFERENCES user(userid) ON DELETE CASCADE on update cascade
);

select * from rentcar;

INSERT INTO user (name, userid, pwd, email, phone)
VALUES
  ('관리자', 'admin', 'admin', 'admin@example.com', '010-555-1234'),
  ('테스트1', 'qwer', '1234', 'qwer@example$ㅖ{.com', '010-555-5678'),
  ('테스트2', 'abcd', '1234', 'abcd@example.com', '010-555-9012');

INSERT INTO reservation (num, userid, qty, dday, rday, usein, usewifi, usenavi, useseat) VALUES
(1, 'qwer', 1, 3, '2024-02-01', 1, 1, 0, 0),
(2, 'qwer', 1, 5, '2024-02-02', 0, 1, 1, 1),
(3, 'qwer', 1, 7, '2024-02-03', 1, 0, 1, 1),
(1, 'qwer', 1, 4, '2024-02-04', 1, 1, 0, 0),
(4, 'qwer', 1, 6, '2024-02-04', 0, 0, 1, 1),
(2, 'qwer', 1, 8, '2024-02-02', 0, 1, 1, 1);

CREATE TABLE board(
	board_num INT auto_increment primary key, -- 게시글 고유 번호 
    category INT, -- 게시글 종류
    userid VARCHAR(50), -- 작성자 id
    num INT, -- 이용 차량 번호
    title VARCHAR(50), -- 게시글 제목
    score INT, -- 평점
    content VARCHAR(500), -- 게시 내용 
    img VARCHAR(50), -- 첨부 이미지 
    datetime VARCHAR(50) -- 게시 날짜시간 
);
drop table if exists board;
INSERT INTO board (category, userid, num, title, score, content, img, datetime) VALUES
(1,"admin",0,"사이트 이용안내",0,"로그인 후 예약 진행하시면 됩니다.","logo.png","2025-03-07 21:04:33"),
(1,"admin",0,"사이트 이용안내",0,"로그인 후 예약 진행하시면 됩니다.","logo.png","2025-03-07 21:04:33"),
(2,"qwer",1,"이용 후기 1",5,"너무 좋아요.",null,"2025-03-07 21:04:33"),
(2,"qwer",1,"이용 후기 2",5,"너무 좋아요.",null,"2025-03-07 21:04:33"),
(2,"qwer",1,"이용 후기 3",5,"너무 좋아요.",null,"2025-03-07 21:04:33"),
(2,"qwer",1,"이용 후기 4",5,"너무 좋아요.",null,"2025-03-07 21:04:33"),
(2,"qwer",1,"이용 후기 5",5,"너무 좋아요.",null,"2025-03-07 21:04:33"),
(2,"qwer",1,"이용 후기 6",5,"너무 좋아요.",null,"2025-03-07 21:04:33"),
(2,"qwer",1,"이용 후기 7",5,"너무 좋아요.",null,"2025-03-07 21:04:33"),
(2,"qwer",1,"이용 후기 8",5,"너무 좋아요.",null,"2025-03-07 21:04:33"),
(2,"qwer",1,"이용 후기 9",4,"너무 좋아요.",null,"2025-03-07 21:04:33"),
(2,"qwer",1,"이용 후기 10",5,"너무 좋아요.",null,"2025-03-07 21:04:33"),
(2,"qwer",1,"이용 후기 11",3,"너무 좋아요.",null,"2025-03-07 21:04:33"),
(2,"qwer",1,"이용 후기 12",5,"너무 좋아요.",null,"2025-03-07 21:04:33"),
(2,"qwer",1,"이용 후기 13",5,"너무 좋아요.",null,"2025-03-07 21:04:33"),
(2,"qwer",1,"이용 후기 14",2,"너무 좋아요.",null,"2025-03-07 21:04:33"),
(2,"qwer",1,"이용 후기 15",5,"너무 좋아요.",null,"2025-03-07 21:04:33"),
(2,"qwer",1,"이용 후기 16",5,"너무 좋아요.",null,"2025-03-07 21:04:33"),
(2,"qwer",1,"이용 후기 17",1,"너무 좋아요.",null,"2025-03-07 21:04:33"),
(3,"admin",1,"사이트 이용안내",0,"로그인 후 예약 진행하시면 됩니다.","logo.png","2025-03-07 21:04:33"),
(3,"admin",1,"사이트 이용안내",0,"로그인 후 예약 진행하시면 됩니다.","logo.png","2025-03-07 21:04:33");
UPDATE board SET title="123" WHERE title="이용 후기 1"

select * from board;
select * from user;
select * from rentcar;
select * from reservation;