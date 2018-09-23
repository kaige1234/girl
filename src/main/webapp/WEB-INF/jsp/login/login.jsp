<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/tags.jsp"%>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
   <form action="${ctx}/pc/login.do" enctype="application/x-www-form-urlencoded">
       <span>用户名:</span>
       <input type="text" name="userName" id="userName" value="${ctx}"/>
       <span>密码:</span>
       <input type="text" name="password" id="password" value=""/>
       <input type="submit" value="提交"/>
   </form>
</body>
</html>
