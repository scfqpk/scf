<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'new.jsp' starting page</title>
    
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
  
       <c:if test="${info eq '修改成功'}">
          ${info}
       </c:if>
  
   <%
   int articleID=Integer.parseInt(request.getParameter("id"));
   String title=request.getParameter("title");
   String keywords=request.getParameter("keywords");
   String writer=request.getParameter("writer");
    %>
   
    <form action="<%=basePath %>NewsModifyServlet">
   <input type="hidden" name="id" value="<%=articleID %>" >
   标题<input type="text"name="title" value="<%=title%>">  
   所属栏目<input type="text"name="keywords" value="<%=keywords %>"> 
   作者<input type="text"name="writer" value="<%=writer %>">
    <input type="submit" value="提交">
   </form>
     </body>
</html>
