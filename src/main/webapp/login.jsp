<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <script language="JavaScript" type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/signin.css">

<script type="text/javascript">
    $(function () {
       var msg = "${msg}";
       if(msg == "用户名或者密码不对。"){
           alert(msg);
       }
    });
</script>

</head>
<body>
<div class="container">
    <form class="form-signin" action="/login.do" method="post">
        <h2 class="form-signin-heading">登录</h2>
        <label for="inputuser" class="sr-only">用户账号</label>
        <input type="text" id="inputuser" class="form-control" placeholder="用户账号" required autofocus name="username">
        <label for="inputPassword" class="sr-only">用户密码</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="用户密码" required name="password">
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> 记住密码
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
    </form>
</div>

</body>
</html>
