<%--
  Created by IntelliJ IDEA.
  User: Martin_working
  Date: 2018/8/25
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>信息导入系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <div class="jumbotron">
        <h1 align="center">个人信息统计系统</h1>
        <p align="center">在这里提交你的信息</p>
    </div>

    <div class="row" align="center">
        <form action="/leave" method="post">
            <input type="text" name="leaveName" class="form-control" style="height:40px;width:450px" placeholder="请假人姓名">
            <div class="panel panel-info" style="width: 450px">
                <div class="panel-heading">
                    <h3 class="panel-title" align="center">请假原因</h3>
                </div>
                <textarea  name="leaveText" class="form-control" rows="5" style="resize: none;width: 100%"></textarea>
            </div>

            <div>
                <input type="submit" class="btn btn-success" value="提交">
            </div>
        </form>
    </div>


</div>

</body>

</body>
</html>
