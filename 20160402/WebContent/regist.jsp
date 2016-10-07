<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<script type="text/javascript">
function changeImg(img){
	img.src=img.src+"?time="+new Date().getTime();
}
</script>
</head>
 <font color="red" >${msg }</font>
<body>
<div align="center">
<h1>我的网站_注册</h1>
<form action="${pageContext.request.contextPath }/RegistServlet" method="post">
<table border="1">
    <tr>
        <td>用户名：</td>
        <td><input type="text" name="username" value="${param.username }"/></td>
    <tr/>
     <tr>
        <td>密码：</td>
        <td><input type="password" name="password" /></td>
    <tr/>
     <tr>
        <td>确认密码：</td>
        <td><input type="password" name="password2" /></td>
    <tr/>
     <tr>
        <td>昵称：</td>
        <td><input type="text" name="nickname" value="${param.nickname }"/></td>
    <tr/>
     <tr>
        <td>邮箱</td>
        <td><input type="email" name="email" value="${param.email }"/></td>
    <tr/>
     <tr>
        <td>验证码：</td>
        <td><input type="text" name="valistr" /></td>
    <tr/>
     <tr>
        <td><input type="submit" value="注册"/></td>
        <td><img src="${pageContext.request.contextPath }/ValiImg" style="cursor: pointer;" onclick="changeImg(this)"></td>
    <tr/>

</table>
</form>
</div>
</body>
</html>