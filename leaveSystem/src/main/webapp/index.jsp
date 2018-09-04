<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>路遥知马力-导航你的方向</title>
    <link rel="shortcut icon" href="road.ico" />
    <link rel="stylesheet" href=" css/iconfont.css">
    <link rel="stylesheet" href="../plug-in/normalize.css">
    <link rel="stylesheet" href="css/style.css">
</head>

<body>
<div class="container" id="container">

    <section class="main">
        <!-- 开发社区 -->
        <div class="box">
            <div>
                <a target="_blank" href="/leave/leavePage">
                    <div class="item">
                        <div class="logo"><img src="img/leave.png" alt="leaveSystem"> leaveSystem </div>
                        <div class="desc">在线请假系统</div>
                    </div>
                </a>


                <a href="/overtime/">
                    <div class="item">
                        <div class="logo"><img src="img/overtime.png" alt="overtime"> overtimeRecoders </div>
                        <div class="desc">加班信息筛选（当天加班到20:00，那天考勤会导出）</div>
                    </div>
                </a>
            </div>
        </div>
    </section>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script>
        var oMenu = document.getElementById('menu');
        var oLeftBar = document.getElementById('leftBar');
        var menuFrom = document.getElementById('menu-form');

        oMenu.onclick = function() {
            if (oLeftBar.offsetLeft == 0) {
                oLeftBar.style.left = -249 + 'px';
            }
            else {
                oLeftBar.style.left = 0;
            }
        }


        // 监听页面宽度变化
        window.onresize = function() {
            judgeWidth();
            // console.log(document.documentElement.clientWidth);
        };

        // 判断页面宽度
        function judgeWidth() {
            if (document.documentElement.clientWidth > 481) {
                oLeftBar.style.left = 0;
            } else {
                oLeftBar.style.left = -249 + 'px';
            }
        }


        var oNavItem = document.getElementById('navItem');
        var aA = oNavItem.getElementsByTagName('a');
        for (var i = 0; i < aA.length; i++) {
            aA[i].onclick = function() {
                for (var j = 0; j < aA.length; j++) {
                    aA[j].className = '';
                }
                this.className = 'active';
                if (oLeftBar.offsetLeft == 0) {
                    if (document.documentElement.clientWidth <= 481) {
                        oLeftBar.style.left = -249 + 'px';
                        menuFrom.checked = false;

                    }
                }
            }
        }


        $(window).scroll(function() {
            if($(window).scrollTop() >= 200){
                $('#fixedBar').fadeIn(300);
            }else{
                $('#fixedBar').fadeOut(300);
            }
        });
        $('#fixedBar').click(function() {
            $('html,body').animate({scrollTop:'0px'},800);
        })
    </script>
</div>
</body>
</html>