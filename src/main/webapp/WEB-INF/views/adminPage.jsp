<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
</head>
<body>

<div class="row">
    <div class="col-md-3"></div>
    <div class="col-md-6">
        <table class="table table-striped " style="table-layout: fixed" align="center">
            <thead>
            <tr>
                <th>请假ID</th>
                <th>请假人姓名</th>
                <th>请假原因</th>
            </tr>
            </thead>
            <c:forEach items="${leaveList}" var="leave">
                <tbody>
                <tr>
                    <td>${leave.id}</td>
                    <td>${leave.leaveName}</td>
                    <td>${leave.leaveText}</td>
                </tr>
                </tbody>
            </c:forEach>
        </table>
    </div>
    <div class="col-md-3">
        <button type="button" class="btn btn-info" onclick="deletel()">清空数据库</button>
        <button type="button" class="btn btn-info" onclick="downLeave()">下载</button>
    </div>
</div>

</body>
<script>
    function deletel() {
        location.href="/delete"
    }
    function downLeave() {
        location.href="/downLeave"
    }
</script>
</html>
