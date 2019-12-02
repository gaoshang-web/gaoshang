<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/10/16
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="/js/fileInput/js/fileinput.min.js"></script>
    <script type="text/javascript" src="/js/fileInput/js/locales/zh.js"></script>

    <link type="text/css" rel="stylesheet" href="/js/fileInput/css/fileinput.min.css"/>
    <script>
        $(function () {
            var arr = [];
            var url = $("#imgUrl").val();//
            if(url!=null && url!=''){
                arr.push(url);
            }
            $("[name='photo']").fileinput({
                language:"zh",
                uploadUrl:"/user/uploadFile",  //用于跳转后台写的上传文件的方法
                showCaption:false,  //是否显示上传的文件名的文本框
                dropZoneEnabled:false,  //是否显示拖拽文件的文本域
                initialPreview:arr,
                initialPreviewAsData: true
            }).on("fileuploaded",function (event, result, previewId, index) {
                var url=result.response.upload;
                $("[name='imgUrl']").val(url);
            })
        })
    </script>
</head>
<body>
    <form class="form-horizontal" role="form" id="userForm">
        <input type="hidden" name="id" value="${userInfo.id}"/>
        <input type="hidden" id="imgUrl" name="imgUrl" value="${userInfo.imgUrl}"/>
        <input type="hidden" name="loginCount" value="${userInfo.loginCount}"/>
        <input type="hidden" name="lastLoginTime" <fmt:formatDate value="${userInfo.lastLoginTime}" pattern="yyyy-MM-dd HH:mm:ss"/>/>
        <div class="form-group">
            <label class="col-sm-2 control-label">用户名:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="userName" placeholder="请输入用户名" value="${userInfo.userName}">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">密码:</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" name="password" placeholder="请输入密码" value="${userInfo.password}">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">真实姓名:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="realName" placeholder="请输入真实姓名" value="${userInfo.realName}">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">邮箱:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="mailbox" placeholder="请输入邮箱" value="${userInfo.mailbox}">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">性别:</label>
            <div class="col-sm-10">
                <label class="radio-inline">
                    <input type="radio" name="sex" value="1" ${userInfo.sex ==1 ?"checked":""}>男
                </label>
                <label class="radio-inline">
                    <input type="radio" name="sex" value="2" ${userInfo.sex ==2 ?"checked":""}>女
                </label>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">用户状态:</label>
            <div class="col-sm-10">
                <label class="radio-inline">
                    <input type="radio" name="status" id="optionsRadios3" value="1" ${userInfo.status ==1 ?"checked":""}>正常使用
                </label>
                <label class="radio-inline">
                    <input type="radio" name="status" id="optionsRadios4"  value="2" ${userInfo.status ==2 ?"checked":""}>用户无效
                </label>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">用户头像:</label>
            <div class="col-sm-10">
                <input type="file" class="form-control" name="photo">
            </div>
        </div>
    </form>
</body>
</html>
