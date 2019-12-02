<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/10/20
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <div class="panel-heading">日志表</div>
    <div class="panel-body">
        <table class="table table-bordered table-striped col-lg-9" id="table_g"></table>
    </div>
</div>
<script>
    $("#table_g").DataTable({
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
            url:"pagingQueryLog",
            dataSrc:function(res){
                return res.data;
            }
        },
        //将数据渲染到页面的table表格中
        columns:[
            {data:"id", title:"编号"},
            {data:"operationUser", title:"操作人"},
            {data:"classUrl", title:"类路径"},
            {data:"methodName", title:"方法名"},
            {data:"ipAddr", title:"ip地址"},
            {data:"methodMessage", title:"方法描述"},
            {data:"consumeTime", title:"耗时"},
            {data:"status", title:"日志状态", render:function(data, type, row, meta){
                    if(data == 1){
                        return "正常";
                    }
                    return "异常";
                }},
            {data:"currentTime", title:"当前时间", render:function(data, type, row, meta){
                    if(data != null){
                        return new Date(data).Format("yyyy-MM-dd");
                    }
                    return "";
                }}
        ]
    })
</script>
</body>
</html>
