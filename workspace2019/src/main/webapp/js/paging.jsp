<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/10/9
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <center>
        <c:if test="${pageInfo.newPage == 1}">
            首页&nbsp;上一页
        </c:if>
        <c:if test="${pageInfo.newPage > 1}">
            <a href="javascript:;" onclick="ajaxQuery(1)">首页</a>
            <a href="javascript:;" onclick="ajaxQuery(${pageInfo.newPage - 1})">上一页</a>
        </c:if>
        <c:if test="${pageInfo.newPage == pageInfo.totalPage}">
            下一页&nbsp;尾页
        </c:if>
        <c:if test="${pageInfo.newPage < pageInfo.totalPage}">
            <a href="javascript:;" onclick="ajaxQuery(${pageInfo.newPage + 1})">下一页</a>
            <a href="javascript:;" onclick="ajaxQuery(${pageInfo.totalPage})">尾页</a>
        </c:if>
        共${pageInfo.totalPage}页
        当前第${pageInfo.newPage}页
        共${pageInfo.totalCount}条数据
        显示
        <select id = "pageSize" onchange="ajaxQuery(1)">
            <option value="2" ${pageInfo.pageSize ==2 ?"selected" :""}>2</option>
            <option value="5" ${pageInfo.pageSize ==5 ?"selected" :""}>5</option>
            <option value="10" ${pageInfo.pageSize ==10 ?"selected" :""}>10</option>
        </select>
        条
    </center>
</body>
</html>
