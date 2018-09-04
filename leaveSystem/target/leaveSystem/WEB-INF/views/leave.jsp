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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
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
        <form action="/leave/admin" id = "myform" method="post">
            <input type="text" name="leaveName" class="form-control" style="height:40px;width:450px"
                   placeholder="请假人姓名">
            <div class="panel panel-info" style="width: 450px">
                <div class="panel-heading">
                    <h3 class="panel-title" align="center">请假原因</h3>
                </div>
                <textarea name="leaveText" class="form-control" rows="5" style="resize: none;width: 100%"></textarea>
            </div>

            <div>
                <input type="submit" class="btn btn-success"  onclick="login()" value="提交">
            </div>
        </form>
    </div>


</div>

<script>
    function login() {
        $.ajax({
            //几个参数需要注意一下
            type: "POST",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            url: "/leave/leave" ,//url
            data: $('#myform').serialize(),
            success: function (result) {
                console.log(result);//打印服务端返回的数据(调试用)
                if (result.resultCode == 200) {
                    alert("SUCCESS");
                }
                ;
            },
            error : function() {
                alert("异常！");
            }
        });
    }
</script>
</body>
</html>
