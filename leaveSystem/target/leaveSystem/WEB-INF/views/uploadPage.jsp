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
    <title>上传文件</title>
</head>
<body>
<h1>上传界面</h1>

<form method="post" action="/overtime/uploadFile" enctype="multipart/form-data">
    选择文件:
    <input type="file" name="uploadFile"/>
    <br/><br/>
    <input type="submit" value="上传"/>
</form>


</body>
</html>
