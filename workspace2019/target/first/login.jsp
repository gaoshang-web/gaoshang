<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/10/15
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="/layui/layui.all.js"></script>
    <link rel="stylesheet" href="/layui/css/layui.css"/>

    <script>
        function login(){
            var userName=$("#userName").val();
            var password=$("#password").val();
            $.ajax({
                url:"/user/login",
                data:{"userName":userName, "password":password},
                success:function(res){
                    if(res.success == "登录成功!"){
                        alert("登录成功!");
                        location.href = "/index.jsp";
                    }else {
                        alert("用户无效!");
                        location.href = "/login.jsp";
                    }
                    if (res.error == "用户名或密码错误!"){
                        alert(res.error);
                    }
                }
            })
        }
    </script>
</head>
<body>
    <center>
        <h1>登录页面</h1>
        <form class="layui-form" >
            <div class="layui-form-item layui-col-md6">
                <label class="layui-form-label">用户名</label>
                <div class="layui-input-block">
                    <input type="text" id="userName"  lay-verify="required" autocomplete="off" placeholder="请输入用户名" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item layui-col-md6">
                <label class="layui-form-label">密码</label>
                <div class="layui-input-block">
                    <input type="password" id="password"  lay-verify="required" autocomplete="off" placeholder="请输入密码" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button type="button" class="layui-btn" lay-submit="" lay-filter="login" onclick="login()">登录</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>
    </center>
</body>
</html>
