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
                uploadUrl:"uploadFile",  //用于跳转后台写的上传文件的方法
                showCaption:false,  //是否显示上传的文件名的文本框
                dropZoneEnabled:false,  //是否显示拖拽文件的文本域
                initialPreview:arr,
                initialPreviewAsData: true
            }).on("fileuploaded",function (event, result, previewId, index) {
                var url=result.response.data;
                $("[name='imgUrl']").val(url);
            })
        })
    </script>
</head>
<body>
    <form class="form-horizontal" role="form" id="fruitForm">
        <input type="hidden" name="id" value="${fruitInfo.id}"/>
        <input type="hidden" id="imgUrl" name="imgUrl" value="${fruitInfo.imgUrl}"/>
        <div class="form-group">
            <label class="col-sm-2 control-label">水果名称:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="fruitName" placeholder="请输入水果名称" value="${fruitInfo.fruitName}">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">是否上架:</label>
            <div class="col-sm-10">
                <label class="radio-inline">
                    <input type="radio" name="racking" value="1" ${fruitInfo.racking ==1 ?"checked":""}>是
                </label>
                <label class="radio-inline">
                    <input type="radio" name="racking" value="2" ${fruitInfo.racking ==2 ?"checked":""}>否
                </label>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">上架日期:</label>
            <div class="col-sm-10">
                <input type="date" name="rackingDate" value="<fmt:formatDate value="${fruitInfo.rackingDate}" pattern="yyyy-MM-dd"/>"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">水果图片:</label>
            <div class="col-sm-10">
                <input type="file" class="form-control" name="photo">
            </div>
        </div>
    </form>
</body>
</html>
