<%--
  Created by IntelliJ IDEA.
  User: 이주현
  Date: 2023-08-30
  Time: 오전 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/write.do" method="post">
        <table border="1">
            <tr>
                <td>이름</td>
                <td><input type="text" name="bName" size="20"/></td>
            </tr>
            <tr>
                <td>제목</td>
                <td><input type="text" name="bTitle" size="20"/></td>
            </tr>
            <tr>
                <td>내용</td>
                <td><textarea name="bContent" cols="10" rows="10"></textarea></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="입력">&nbsp;&nbsp;
                    <a href="/list.do">목록보기</a>
                </td>
            </tr>
        </table>
    </form>


</body>
</html>
