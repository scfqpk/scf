<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {font-size: 12px}
.STYLE3 {font-size: 12px; font-weight: bold; }
.STYLE4 {
	color: #03515d;
	font-size: 12px;
}
-->
</style>

<script>
var  highlightcolor='#c1ebff';
//此处clickcolor只能用win系统颜色代码才能成功,如果用#xxxxxx的代码就不行,还没搞清楚为什么:(
var  clickcolor='#51b2f6';
function  changeto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=highlightcolor&&source.id!="nc"&&cs[1].style.backgroundColor!=clickcolor)
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=highlightcolor;
}
}

function  changeback(){
if  (event.fromElement.contains(event.toElement)||source.contains(event.toElement)||source.id=="nc")
return
if  (event.toElement!=source&&cs[1].style.backgroundColor!=clickcolor)
//source.style.backgroundColor=originalcolor
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}

function  clickto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=clickcolor&&source.id!="nc")
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=clickcolor;
}
else
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}
</script>
<script>
		$(function(){
			var basePath = '<%=basePath %>';
			$(".button").click(function(){
				var val =$(":text").val();
				var result = (val.trim()=='');
				if(result){
					alert("不能为空");
					return;
				} 
				$.ajax({
					url:basePath+"newsAddServlet",
					data:{title:val},
					success:function(data){
					if('successAdd' == data){
         				 $("#infonewsAdd").html("<div style='border-color: #9adf8f;background:#d5ffce;width:200px;height:25px;float:left;border-radius:100px;'><img src='<%=basePath%>resources/images/icons/tick_circle.png' />添加成功!</div>");
         		    }else if('failAdd' == data){
            			 $("#infonewsAdd").html("<div style='border-color: #df8f8f;background:#ffcece;width:200px;height:25px;float:left;border-radius:100px'><img src='<%=basePath%>resources/images/icons/cross_circle.png' />添加失败!</div>");
					}
					}
				});
			});
		});
	
	</script>
	
</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30" background="<%=basePath%>images/tab_05.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="30"><img src="<%=basePath%>images/tab_03.gif" width="12" height="30" /></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="46%" valign="middle"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="5%"><div align="center"><img src="<%=basePath%>images/tb.gif" width="16" height="16" /></div></td>
                <td width="95%" class="STYLE1"><span class="STYLE3">你当前的位置</span>：[新闻中心]-[新增文章]</td>
              </tr>
            </table></td>
         	</tr></table></td></tr></table></td></tr>
         	</table>
		 <div class="content-box">
      <!-- Start Content Box -->
      <div class="content-box-header">
        <h3>新增文章</h3>
         <span style="color:red">${infonewsAdd}</span>
       <!--  <ul class="content-box-tabs">
          <li><a href="#tab1" class="default-tab">Table</a></li>
          <li><a href="#tab2">Forms</a></li>
        </ul> -->
        <div class="clear"></div>
      </div>
      <!-- End .content-box-header  default-tab-->
      <div class="content-box-content">
        <div class="tab-content default-tab" id="tab2">
         <form action="<%=basePath%>NewsAddServlet" method="get">
            <fieldset>
            <!-- Set class to "column-left" or "column-right" on fieldsets to divide the form into columns -->
            <p>
              <label>文章标题</label>
              <input class="text-input small-input" type="text" id="small-input" name="title" />
              <!--错误/正确提示 <span class="input-notification success png_bg">Successful message</span> -->
              <!-- Classes for input-notification: success, error, information, attention -->
              <br />
              <!--提示信息   <small>A small description of the field</small>  -->
			 </p> 
			 
            <p>
              <label>作者</label>
              <input class="text-input medium-input datepicker" type="text" id="medium-input" name="writer" />
              <!-- <span class="input-notification error png_bg">Error message</span>  -->
			  </p>
            <p>
              <label>关键字</label>
              <input class="text-input large-input" type="text" id="large-input" name="keywords" />
            </p>
            <!-- <p>
              <label>Checkboxes</label>
              <input type="checkbox" name="checkbox1" />
              This is a checkbox
              <input type="checkbox" name="checkbox2" />
              And this is another checkbox </p>
            <p>
              <label>Radio buttons</label>
              <input type="radio" name="radio1" />
              This is a radio button<br />
              <input type="radio" name="radio2" />
              This is another radio button </p> -->
            <p>
              <label>所属栏目</label>
              <select name="dropdown" class="small-input" >
         
             <c:forEach var="i" items="${cates}">
               
                <option value="${i.cateID}">${i.catename}</option>
             </c:forEach>
            </p>
				
              </select>
            <p>
              <label>文章内容</label>
              <textarea class="text-input textarea wysiwyg" id="textarea" name="content" cols="79" rows="15"></textarea>
            </p>
            
            <p>
              <input class="button" type="submit" value="提交" />
            </p>
           
            </fieldset>
            <div class="clear"></div>
            <!-- End .clear -->
           
          </form>
        </div>
        <!-- End #tab2 -->
      </div>
      <!-- End .content-box-content -->
    </div>
    <div class="clear"></div>
    <div id="footer"> <small>
      <!-- Remove this notice or replace it with whatever you want -->
      &#169; Copyright 2010 Your Company | Powered by <a href="#">admin templates</a> | <a href="#">Top</a> </small> </div>
    <!-- End #footer -->
  </div>
</body>
</html>
