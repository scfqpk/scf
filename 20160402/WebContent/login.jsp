<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://www.dzq.com/UserTag" prefix="UserTag" %>
<html>
<head>

</head>
<body>
<div align="center">
<h1>我的网站_登录</h1><hr>
<font color="red">${msg }</font>
<form action="${pageContext.request.contextPath }/LoginServlet" method="post">
<table border="1">
       <tr>
          <td>用户名：</td>
          
          <td><input type="text" name="username" value="<UserTag:URLDecoder content="${cookie.remname.value }" encode="utf-8"/>"/></td>
       </tr>
       <tr>
          <td>密码：</td>
          <td><input type="password" name="password"/></td>
       </tr>
       <tr>
          <td><input type="submit" value="登录"/></td>
          <td><input type="checkbox" value="ok" name="remname" 
          <c:if test="${cookie.remname!=null }">
          checked="checked"
          </c:if>
          />记住用户名</td>
       </tr>
</table>
</form>
</div>
</body>
</html>