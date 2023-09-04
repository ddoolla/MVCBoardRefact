# MVCBoardRefact 



## 테이블 생성 쿼리 - MySQL
```

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
