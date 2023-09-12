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
<div align="center">
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
                <a href="/view/writePage.jsp">글작성</a>
            </td>
        </tr>
    </table>
    <%-- Paging --%>
    <%--<div>
        ${pagingStr}
    </div>--%>

    <%-- PagingEx--%>
    <div>
        <c:if test="${pagingEx.firstPage eq true}">
            <a href="/list.do?page=1">[맨 처음]</a>
        </c:if>
        <c:if test="${pagingEx.preBlock eq true}">
            <a href="/list.do?page=${pagingEx.blockStartNum - 1}">[이전 블록]</a>
        </c:if>
        <c:forEach var="i" begin="${pagingEx.blockStartNum}" end="${pagingEx.blockEndNum}" step="1">
            <c:choose>
                <c:when test="${i == pagingEx.pageNum}">
                    ${i}
                </c:when>
                <c:otherwise>
                    <a href="/list.do?page=${i}">${i}</a>
                </c:otherwise>
            </c:choose>
            <c:if test="${i != pagingEx.blockEndNum}"> | </c:if>
        </c:forEach>
        <c:if test="${pagingEx.nextBlock eq true}">
            <a href="/list.do?page=${pagingEx.blockEndNum + 1}">[다음 블록]</a>
        </c:if>
        <c:if test="${pagingEx.lastPage eq true}">
            <a href="/list.do?page=${pagingEx.totalPage}">[맨 끝]</a>
        </c:if>
    </div>
</div>
</body>
</html>
