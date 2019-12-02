<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/10/15
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="/bootstrap3/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/bootstrap3/datatable/DataTables-1.10.18/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="/bootstrap3/datatable/DataTables-1.10.18/js/dataTables.bootstrap.min.js"></script>
    <script type="text/javascript" src="/bootstrap3/js/dateFormat.js"></script>
    <script type="text/javascript" src="/layui/layui.all.js"></script>
    <script type="text/javascript" src="/js/bootbox.min.js"></script>
    <script type="text/javascript" src="/js/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="/js/fileInput/js/fileinput.min.js"></script>
    <script type="text/javascript" src="/js/fileInput/js/locales/zh.js"></script>

    <link type="text/css" rel="stylesheet" href="/bootstrap3/datatable/DataTables-1.10.18/css/dataTables.bootstrap.min.css"/>
    <link type="text/css" rel="stylesheet" href="/bootstrap3/css/bootstrap.min.css"/>
    <link type="text/css" rel="stylesheet" href="/js/style.css"/>
    <link type="text/css" rel="stylesheet" href="/layui/css/layui.css"/>
    <link type="text/css" rel="stylesheet" href="/js/fileInput/css/fileinput.min.css"/>
</head>
<body>
    <div class="panel panel-danger">
        <div class="panel-heading">
            条件查询
        </div>
        <div class="panel-body">
            <form class="form-horizontal">
                <div class="row">
                    <div class="form-inline">
                        <div class="form-group col-md-3">
                            <label>真实姓名:</label>
                            <input type="text" id="realName"/>
                        </div>
                        <div class="form-group col-md-3">
                            <label class="control-label">用户状态:</label>
                            <label class="radio-inline ">
                                <input type="radio" name="status" value="1"/>正常使用
                            </label>
                            <label class="radio-inline ">
                                <input type="radio" name="status" value="2"/>用户无效
                            </label>
                        </div>
                        <div class="form-group col-md-3">
                            <label class="control-label">性别:</label>
                            <label class="radio-inline ">
                                <input type="radio" name="sex" value="1"/>男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="sex" value="2"/>女
                            </label>
                        </div>
                    </div>
                    <div class="form-inline">
                        <div class="form-group col-md-3">
                            <label class="control-label">登录时间:</label>
                            <div class="input-group">
                                <input type="text" class="form-control" id="startTime" onclick="WdatePicker()"/>
                                <div class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></div>
                                <input type="text" class="form-control" id="endTime" onclick="WdatePicker()"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row" align="center" >
                    <button type="button" class="btn btn-primary" onclick="searchUser()">搜索</button>
                    <button type="reset" class="btn btn-primary">重置</button>
                </div>
            </form>
        </div>
    </div>
    <div class="panel panel-danger">
        <div class="panel-heading">用户列表</div>
        <div class="panel-body">
            <div>
                <button name="orderBtn" type="button" class = "defaultStyle" orderName="realName">姓名</button>
                <button name="orderBtn" type="button" class = "defaultStyle" orderName="status">用户状态</button>
                <button name="orderBtn" type="button" class = "defaultStyle" orderName="lastLoginTime" orderBy="desc">登录时间</button>
            </div>
            <!-- 按钮触发模态框 -->
            <center>
                <button type="button" class="btn btn-default btn-sm btn-info" data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-plus"></span>新增用户</button>
                <button type="button" class="btn btn-default btn-sm btn-info"><a href="/user/importExcel">导出Excel</a></button>
            </center>
            <!-- 模态框（Modal） -->
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title">新增用户</h4>
                        </div>
                        <div class="modal-body">
                            <form class="form-horizontal" role="form">
                                <input type="hidden" name="imgUrl"/>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">用户名:</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="userName" placeholder="请输入用户名">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">密码:</label>
                                    <div class="col-sm-10">
                                        <input type="password" class="form-control" name="password" placeholder="请输入密码">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">真实姓名:</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="realName" placeholder="请输入真实姓名">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">邮箱:</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="mailbox" placeholder="请输入邮箱">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">性别:</label>
                                    <div class="col-sm-10">
                                        <label class="radio-inline">
                                            <input type="radio" name="sex" value="1" checked>男
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" name="sex" value="2">女
                                        </label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">用户状态:</label>
                                    <div class="col-sm-10">
                                        <label class="radio-inline">
                                            <input type="radio" name="status" id="optionsRadios3" value="1" checked>正常使用
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" name="status" id="optionsRadios4"  value="2">用户无效
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
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            <button type="button" class="btn btn-primary" onclick="saveUser()">新增数据</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal -->
            </div>
            <table class="table table-bordered table-striped col-lg-9" id="table_g"></table>
        </div>
    </div>
    <script>
        $(function(){
            //按钮的鼠标移上事件
            $("[name='orderBtn']").mouseover(function(){
                $(this).removeClass("defaultStyle");
                $(this).addClass("mouseOverStyle");
            });
            //按钮的鼠标移出事件
            $("[name='orderBtn']").mouseout(function(){
                $(this).removeClass("mouseOverStyle");
                $(this).addClass("defaultStyle");
            });
        })

        //文件上传
        $(function () {
            $("[name='photo']").fileinput({
                language:"zh",
                uploadUrl:"/user/uploadFile",  //用于跳转后台写的上传文件的方法
                showCaption:false,  //是否显示上传的文件名的文本框
                dropZoneEnabled:false  //是否显示拖拽文件的文本域
            }).on("fileuploaded",function (event, result) {
                var url=result.response.upload;
                $("[name='imgUrl']").val(url);
            })
        })
        function saveUser() {
            var userName = $("[name='userName']").val();
            var password = $("[name='password']").val();
            var realName = $("[name='realName']").val();
            var mailbox = $("[name='mailbox']").val();
            var sex = $("[name='sex']:checked").val();
            var status = $("[name='status']:checked").val();
            var imgUrl = $("[name='imgUrl']").val();
            $.ajax({
                url:"/user/saveUser",
                data:{"userName":userName,"password":password,"realName":realName,"mailbox":mailbox,"sex":sex,"status":status,"imgUrl":imgUrl},
                success:function (res) {
                    location.href="/user/userJsp";
                }
            })
        }
        var table_g=$("#table_g").DataTable({
            autoWidth:true,  //自适应宽度
            info:true,  //展示表格左下角的信息,也就是分页栏
            lengthChange:true,  //是否改变每页展示的条数
            lengthMenu:[2, 5, 10],  //下拉框 控制每页展示条数
            ordering:true,  //是否允许排序
            paging:true,  //是否允许开启本地分页
            processing:true,  //是否先处理状态
            serverSide:true,  //true是服务器模式 false是客户端模式
            //和后台进行交互
            ajax:{
                url:"/user/pagingQueryUser",
                dataSrc:function(res){
                    return res.data;
                }
            },
            //将数据渲染到页面的table表格中
            columns:[
                {data:"id", title:"编号"},
                {data:"userName", title:"用户名"},
                {data:"realName", title:"真实姓名"},
                {data:"mailbox", title:"邮箱"},
                {data:"sex", title:"性别", render:function(data, type, row, meta){
                        if(data == 1){
                            return "男";
                        }
                        return "女";
                    }},
                {data:"status", title:"状态", render:function(data, type, row, meta){
                        if(data == 1){
                            return "正常使用";
                        }
                        return "用户无效";
                    }},
                {data:"loginCount", title:"登录次数"},
                {data:"lastLoginTime", title:"上次登陆时间", render:function(data, type, row, meta){
                        if(data != null){
                            return new Date(data).Format("yyyy-MM-dd hh:mm:ss");
                        }
                        return "该用户还未登录";
                    }},
                {data:function (data) {
                        return '<img src="'+data.imgUrl+'" width="80" height="80"/>';
                    }, title:"用户头像"},
                {data:function (data) {
                        return '<button class="layui-btn layui-btn-xs" onclick="updateUserStatus(\''+data.id+'\')"><span class="glyphicon glyphicon-pencil" style="color: #ffffff;" lay-event="edit">修改用户状态</span></button>'+
                                '<button class="layui-btn layui-btn-xs" onclick="queryUserById(\''+data.id+'\')"><span class="glyphicon glyphicon-pencil" style="color: #ffffff;" lay-event="edit">修改信息</span></button>';
                    },title:"操作"}
            ]
        })
        function queryUserById(id) {
            var editUserHtml = "";
            $.ajax({
                url:"/user/queryUserById",
                data:{"id":id},
                type:"post",
                dataType:"html",
                async:false,
                success:function (res) {
                    editUserHtml=res;
                }
            })
            bootbox.dialog({
                message:editUserHtml,
                title:"修改用户信息",
                buttons:{
                    cancel:{
                        label:"取消",
                        className:"btn-danger"
                    },
                    update:{
                        label:"修改",
                        className:"btn-Info",
                        callback:function (res) {
                            if(res != false){
                                $.ajax({
                                    url:"/user/updateUser",
                                    data:$("#userForm").serialize(),
                                    success:function (res) {
                                        location.href="/user/userJsp";
                                    },
                                    error:function () {
                                        alert(111111111);
                                    }
                                })
                            }
                        }
                    }
                }
            })
        }
        function updateUserStatus(id){
            $.ajax({
                url:"/user/updateUserStatus",
                data:{"id":id, "confirm":confirm},
                success:function (res) {
                    if(res.wudi == true){
                        if(confirm("确定将此用户状态设置成正常吗?")){
                            location.href="/user/userJsp";
                        }
                    }else {
                        if(confirm("确定将此用户状态设置成无效吗?")){
                            location.href="/user/userJsp";
                        }
                    }
                }
            })
        }
        function searchUser(){
            var jsonData={};
            var realName = $("#realName").val();
            var sex = $("[name='sex']:checked").val();
            var status = $("[name='status']:checked").val();
            var startTime = $("#startTime").val();
            var endTime = $("#endTime").val();
            var orderName = $("[name='orderBtn'].clickStyle").attr("orderName");
            var orderBy = $("[name='orderBtn'].clickStyle").attr("orderBy");
            jsonData.realName=realName;
            jsonData.sex=sex;
            jsonData.status=status;
            jsonData.startTime=startTime;
            jsonData.endTime=endTime;
            jsonData.orderName=orderName;
            jsonData.orderBy=orderBy;
            table_g.settings()[0].ajax.data=jsonData;
            table_g.ajax.reload();
        }
        //按钮的鼠标单击事件
        $("[name='orderBtn']").click(function(){
            $("[name='orderBtn']").removeClass("clickStyle");
            $("[name='orderBtn']").addClass("defaultStyle");
            $(this).removeClass("mouseOverStyle");
            $(this).removeClass("defaultStyle");
            $(this).addClass("clickStyle");
            var orderBy = $(this).attr("orderBy");
            if(typeof (orderBy)!="undefined"){
                if(orderBy == null || orderBy == ""){
                    $(this).attr("orderBy","desc");
                }else {
                    if(orderBy == "desc"){
                        $(this).attr("orderBy","asc");
                    }else {
                        $(this).attr("orderBy","desc");
                    }
                }
            }
            searchUser();
        });
    </script>
</body>
</html>
