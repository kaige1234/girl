<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>">

    <title>修改信息</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <script src="${ctx}/resources/js/jquery-3.2.1.min.js"></script>
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

</head>


<body>
<form action="${pageContext.request.contextPath }/saveUser.do" method="post" enctype="multipart/form-data">
    <input type="file" name="user_pic"/>
    <input type="submit" value="提交"/>
    <input type="button" value="保存单个数据" onclick="savaSimple()"/>
    <input type="button" value="修改" onclick="upUser()"/>
    <input type="button" value="测试forecth" onclick="queryUsers()"/>
    <input type="button" value="获取后台返回来的值" onclick="getValue()"/>
</form>

</body>

<script>
    $(function () {
        console.log("dddd");
    })

    //保存单个表单
    function savaSimple() {
        console.log($("form"));
        $("form").attr("action", "${pageContext.request.contextPath }/saveUser.do");
        console.log($("form").attr("action"));
    }

    function upUser() {
        $("form").attr("action", "${pageContext.request.contextPath }/upUser.do")
    }

    function queryUsers() {
        $("form").attr("action", "${pageContext.request.contextPath }/queryUsers.do");
    }

    function getValue(){
        var aa = '${usr}';
        alert(aa);
        console.log(aa);
    }
</script>
</html>