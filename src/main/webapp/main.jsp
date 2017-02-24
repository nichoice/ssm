<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <script language="JavaScript" type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
    <script language="JavaScript" type="text/javascript" src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">

    <script type="text/javascript">
        $(function () {
            var msg = "${msg}";
            if (msg == "该用户存在！") {
                alert(msg);
            }
        });
    </script>
</head>
<body>
<div>
    当前用户： ${msg.username}
    <a href="/logout.do">退出</a>
</div>

<br/>
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
    添加用户
</button>
<br/>
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">添加账号</h4>
            </div>
            <form action="/add.do" method="post">
                <div class="modal-body">
                    <input type="text" class="form-control" placeholder="用户账号" required autofocus name="username">
                    <input type="password" class="form-control" placeholder="用户密码" required name="password">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Save changes</button>
                </div>
            </form>
        </div>
    </div>
</div>


<div class="row">
    <div class="col-md-6">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>#</th>
                <th>用户</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="c">
                <tr>
                    <td>${c.id}</td>
                    <td>${c.username}</td>
                    <td>
                        <a href="${c.id }/update">更新</a>
                        <a href="javascript:;" onClick="del(${c.id});" name="id">删除</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script type="text/javascript">
    function del(id) {
        if (confirm("你确定要删除这条记录吗？")) {
            window.location = id + "/delete.do";
        }
    }
</script>
</body>
</html>
