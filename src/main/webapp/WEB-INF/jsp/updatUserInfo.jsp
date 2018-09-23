<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   	<form action="${pageContext.request.contextPath }/saveUser.do" method="post" enctype="multipart/form-data">
   		<input type="hidden" id="id" name="id" value="${User.id}"/>
   		<table align="center">
   			<tr>
				<td>
					<label>姓名：</label>
					<input id="userName" name="userName" value="${User.userName}"/>
				</td>   			
   			</tr>
   			<tr>
   				<td>
   					<label>性别：</label>
   					<input id="sex" name="sex" value="${User.sex}"/>
   				</td>
   			</tr>
   			<tr>
   				<td>
   					<label>地址：</label>
   					<input id="address" name="address" value="${User.address}"/>
   				</td>
   			</tr>
   			<tr>
   				<td>
   					<label>生日</label>
   					<input type="text" name="createtime" value="<fmt:formatDate value="${User.birtyDay}" pattern="yyyy-MM-dd HH:mm:ss"/>"/>
   				</td>
   			</tr>
   			<tr>
				<td>
				
					<label>商品图片</label>
					<c:if test="${User.id != null}">
						<img src="/pic/${User.picPath}" width=100 height=100/>
						<br/>
					</c:if>
					<input type="file"  name="user_pic"/> 
				</td>
			</tr>
   			<tr>
   				<td>
   					<input type="submit" value="提交"/>
   				</td>
   			</tr>
   		</table>
   	</form>
  </body>
</html>