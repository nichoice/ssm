<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <meta charset="utf-8">
    <script language="JavaScript" type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
    <script language="JavaScript" type="text/javascript" src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">

    <script type="text/javascript">
        <!-- -->
        $(function () {
            var msg = "${msg}";
            if (msg == "该用户已存在！") {
                alert(msg);
            }
        });

        <!-- 删除用户 -->
        function del(id){
            $.get("<%=basePath%>/delete.do?id=" + id , function(data){
                if("success" == data.result){
                    alert("删除成功");
                    window.location.reload(true);
                }else{
                    alert("删除失败");
                }
            });
        }
    </script>
</head>
<body>
<div class="panel panel-heading">
    <div style="float: right">
    当前用户： ${msg.username}
    <a href="/logout.do">退出</a>
    </div>
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
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="submit" class="btn btn-primary">保存</button>
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
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>
                        <a href="${c.id }/update">编辑</a>
                        <a href="javascript:del('${user.id}')">删除</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
