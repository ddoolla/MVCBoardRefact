# MVCBoardRefact  
## [jsp/servlet 유튜브 강의 게시판 프로젝트](https://youtu.be/Aw-lOlR0I28?si=5n7JQ1UmRWkj4Poo)  
  
## 테이블 생성 쿼리 - MySQL
```
create table mvc_board (
	bId int(4) primary key auto_increment,
	bName varchar(20),
	bTitle varchar(100),
	bContent varchar(300),
	bDate datetime now(),
	bHit int(4) default 0,
	bGroup int(4),
	bStep int(4),
	bIndent int(4)
);

// 더미 데이터
insert into mvc_board (bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent)
values ('abcd', 'is title', 'is content', 0, last_insert_id( ) +1, 0, 0);
```

## /src/main/webapp/META-INF/context.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<Context path="/">
    <Resource auth="Container"
              driverClassName="com.mysql.cj.jdbc.Driver"
              type="javax.sql.DataSource"
              url="jdbc:mysql://호스트:포트/스키마"
              name="jdbc/mysql"
              username="아이디"
              password="비밀번호"
              maxActive="50"
              maxWait="1000"
    />
</Context>
```
