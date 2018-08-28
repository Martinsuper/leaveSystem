<%--
  Created by IntelliJ IDEA.
  User: Martin_working
  Date: 2018/8/25
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>success</h1>



<table>
    <tr>
        <th>姓名</th>
        <th>请假原因</th>
    </tr>
    <c:forEach items="${queryAll}" var="leave">
        <tr>
            <th>${leave.leaveName}</th>
            <th>${leave.leaveText}</th>
        </tr>
    </c:forEach>
</table>
</body>
</html>
