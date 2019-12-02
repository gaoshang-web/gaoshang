<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/10/18
  Time: 15:03
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
                            <label>水果名称:</label>
                            <input type="text" id="fruitName"/>
                        </div>
                        <div class="form-group col-md-3">
                            <label class="control-label">是否上架:</label>
                            <label class="radio-inline ">
                                <input type="radio" name="racking" value="1"/>是
                            </label>
                            <label class="radio-inline ">
                                <input type="radio" name="racking" value="2"/>否
                            </label>
                        </div>
                    </div>
                    <div class="form-inline">
                        <div class="form-group col-md-3">
                            <label class="control-label">上架日期:</label>
                            <div class="input-group">
                                <input type="text" class="form-control" id="startTime" onclick="WdatePicker()"/>
                                <div class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></div>
                                <input type="text" class="form-control" id="endTime" onclick="WdatePicker()"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row" align="center" >
                    <button type="button" class="btn btn-primary" onclick="searchFruit()">搜索</button>
                    <button type="reset" class="btn btn-primary">重置</button>
                </div>
            </form>
        </div>
    </div>
    <div class="panel panel-danger">
        <div class="panel-heading">水果列表</div>
        <div class="panel-body">
            <div>
                <button name="orderBtn" type="button" class = "defaultStyle" orderName="fruitName" orderBy="desc">水果名称</button>
                <button name="orderBtn" type="button" class = "defaultStyle" orderName="racking" orderBy="desc">是否上架</button>
                <button name="orderBtn" type="button" class = "defaultStyle" orderName="rackingDate" orderBy="desc">上架时间</button>
            </div>
            <!-- 按钮触发模态框 -->
            <center>
                <button type="button" class="btn btn-default btn-sm btn-info" data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-plus"></span>新增水果</button>
                <button type="button" class="btn btn-default btn-sm btn-info"><a href="importExcel">导出Excel</a></button>
            </center>
            <!-- 模态框（Modal） -->
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title">新增水果</h4>
                        </div>
                        <div class="modal-body">
                            <form class="form-horizontal" role="form">
                                <input type="hidden" name="imgUrl"/>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">水果名称:</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="fruitName" placeholder="请输入水果">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">是否上架:</label>
                                    <div class="col-sm-10">
                                        <label class="radio-inline">
                                            <input type="radio" name="racking" value="1" checked>是
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" name="racking" value="2">否
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
                            <button type="button" class="btn btn-primary" onclick="saveFruit()">新增数据</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal -->
            </div>
            <table class="table table-bordered table-striped col-lg-9" id="table_g"></table>
        </div>
    </div>
</body>
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
            uploadUrl:"uploadFile",  //用于跳转后台写的上传文件的方法
            showCaption:false,  //是否显示上传的文件名的文本框
            dropZoneEnabled:false  //是否显示拖拽文件的文本域
        }).on("fileuploaded",function (event, result) {
            var url=result.response.data;
            $("[name='imgUrl']").val(url);
        })
    })
    function saveFruit() {
        var fruitName = $("#fruitName").val();
        var racking = $("[name='racking']:checked").val();
        var imgUrl = $("[name='imgUrl']").val();
        $.ajax({
            url:"saveFruit",
            data:{"fruitName":fruitName,"racking":racking,"imgUrl":imgUrl},
            success:function (res) {
                location.href="/fruitJsp";
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
            url:"pagingQueryFruit",
            dataSrc:function(res){
                return res.data;
            }
        },
        //将数据渲染到页面的table表格中
        columns:[
            {data:"id", title:"编号"},
            {data:"fruitName", title:"水果名称"},
            {data:"racking", title:"是否上架", render:function(data, type, row, meta){
                    if(data == 1){
                        return "是";
                    }
                    return "否";
                }},
            {data:"rackingDate", title:"上架时间", render:function(data, type, row, meta){
                    if(data != null){
                        return new Date(data).Format("yyyy-MM-dd");
                    }
                    return "";
                }},
            {data:function (data) {
                    return '<img src="'+data.imgUrl+'" width="80" height="80"/>';
                }, title:"水果图片"},
            {data:function (data) {
                    return '<button class="layui-btn layui-btn-xs" onclick="updateFruitRackings(\''+data.id+'\')"><span class="glyphicon glyphicon-pencil" style="color: #ffffff;" lay-event="edit">修改上架状态</span></button>'+
                        '<button class="layui-btn layui-btn-xs" onclick="queryFruitByIds(\''+data.id+'\')"><span class="glyphicon glyphicon-pencil" style="color: #ffffff;" lay-event="edit">修改信息</span></button>';
                },title:"操作"}
        ]
    })
    function queryFruitByIds(id) {
        var editFruitHtml = "";
        $.ajax({
            url:"queryFruitById",
            data:{"id":id},
            type:"post",
            dataType:"html",
            async:false,
            success:function (res) {
                editFruitHtml=res;
            }
        })
        bootbox.dialog({
            message:editFruitHtml,
            title:"修改水果信息",
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
                                url:"/updateFruit",
                                data:$("#fruitForm").serialize(),
                                success:function (res) {
                                    location.href="fruitJsp";
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
    function updateFruitRackings(id){
        $.ajax({
            url:"/updateFruitRacking",//, "confirm":confirm("确定将此上架状态设置成是或者否吗")
            data:{"id":id},
            success:function (res) {
                if (res.racking == 1) {
                    bootbox.confirm("确定将此上架状态设置成'否'吗？", function (result) {
                        if (result == true) {
                            return location.href = "fruitJsp";
                        }
                    });
                } else {
                    bootbox.confirm("确定将此上架状态设置成'是'吗？", function (result) {
                        if (result == true) {
                            return location.href = "fruitJsp";
                        }
                    });
                }
                /*location.href="fruitJsp";*/
                /*if(res.eye == true){
                    if(confirm("确定将此上架状态设置成是吗?")){
                        location.href="fruitJsp";
                    }
                }else {
                    if(confirm("确定将此上架状态设置成否吗?")){
                        location.href="fruitJsp";
                    }
                }*/
            }
        })
    }
    function searchFruit(){
        var jsonData={};
        var fruitName = $("#fruitName").val();
        var racking = $("[name='racking']:checked").val();
        var startTime = $("#startTime").val();
        var endTime = $("#endTime").val();
        var orderName = $("[name='orderBtn'].clickStyle").attr("orderName");
        var orderBy = $("[name='orderBtn'].clickStyle").attr("orderBy");
        jsonData.fruitName=fruitName;
        jsonData.racking=racking;
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
        searchFruit();
    });
</script>
</html>
