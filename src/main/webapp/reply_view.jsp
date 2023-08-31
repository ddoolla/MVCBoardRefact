<%--
  Created by IntelliJ IDEA.
  User: Blue
  Date: 2023-08-30
  Time: 오후 1:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/reply.do" method="post">
    <input type="hidden" name="bStep" value="${bDto.bStep}">
    <input type="hidden" name="bIndent" value="${bDto.bIndent}">
    <input type="hidden" name="bGroup" value="${bDto.bGroup}">
    <table border="1">
        <tr>
            <td>번호</td>
            <td><input type="text" name="bId" value="${bDto.bId}" readonly></td>
        </tr>
        <tr>
            <td>히트</td>
            <td><input type="text" name="bHit" value="${bDto.bHit}" readonly></td>
        </tr>
        <tr>
            <td>이름</td>
            <td><input type="text" name="bName" value="${bDto.bName}"></td>
        </tr>
        <tr>
            <td>제목</td>
            <td><input type="text" name="bTitle" value="${bDto.bTitle}"></td>
        </tr>
        <tr>
            <td>내용</td>
            <td><textarea name="bContent">${bDto.bContent}</textarea></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="답변"> &nbsp;&nbsp;
                <a href="/list.do">목록</a>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
