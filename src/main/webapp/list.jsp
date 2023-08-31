<%--
  Created by IntelliJ IDEA.
  User: 이주현
  Date: 2023-08-30
  Time: 오전 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <th>번호</th>
        <th>이름</th>
        <th>제목</th>
        <th>날짜</th>
        <th>히트</th>
    </tr>
    <c:forEach var="list" items="${bDtos}" varStatus="i">
        <tr>
            <td>${totalCnt - i.index}</td>
            <td>${list.bName}</td>
            <td>
                <a href="/content_view.do?id=${list.bId}">
                    <c:forEach begin="1" end="${list.bIndent}" step="1">-</c:forEach>${list.bTitle}
                </a>
            </td>
            <td>${list.bDate}</td>
            <td>${list.bHit}</td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="5">
            <a href="/writePage.jsp">글작성</a>
        </td>
    </tr>
</table>
</body>
</html>
