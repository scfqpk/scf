<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" import="entity.SpiltPage"
	import="java.text.SimpleDateFormat"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<script src="<%=basePath%>jquery/jquery-1.10.2.js"></script>
<title>无标题文档</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

.STYLE1 {
	font-size: 12px
}

.STYLE3 {
	font-size: 12px;
	font-weight: bold;
}

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
      $(".clean").click(function(){
      $("#select :text").val("");
      location.href="<%=basePath%>NewsMgServlet?curpage=1";
      })
      })

</script>
<script>
$(function(){
			$("#checkAll").click(function(){
				 $('input[name="cbk"]').prop("checked",this.checked);
		 });
		 var $cbk = $("input[name='cbk']");
		 $cbk.click(function(){
                $("#checkAll").prop("checked",$cbk.length == $("input[name='cbk']:checked").length ? true : false);
            });
        });
	</script>


<script>
		function delAll(){
		var basePath = "<%=basePath%>";
			var ids = "";
			$("input[name='cbk']:checked").each(function(){
				//取每个元素的id值
				var id = $(this).val();
				ids += ",'"+id+"'";
			})
			ids = ids.substring(1);
			$.ajax({
				url:basePath+"NewsDeleteAllServlet",
				data:{'ids':ids},
				success:function(data){
					if(data == 'success'){
						alert("删除成功!");
					}else{
						alert("删除失败!");
					}
					history.go(0);	
					}
					});
	
				}

	</script>
</head>

<body>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="30" background="<%=basePath%>images/tab_05.gif"><table
					width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="12" height="30"><img
							src="<%=basePath%>images/tab_03.gif" width="12" height="30" /></td>
						<td><table width="100%" border="0" cellspacing="0"
								cellpadding="0">
								<tr>
									<td width="46%" valign="middle"><table width="100%"
											border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td width="5%"><div align="center">
														<img src="<%=basePath%>images/tb.gif" width="16"
															height="16" />
													</div></td>
												<td width="95%" class="STYLE1"><span class="STYLE3">你当前的位置</span>：[新闻中心]-[文章管理]<input
													type="text" id="select" value="${select}" />&nbsp&nbsp<a
													href="javascript:void(0);"
													onclick="location.href='<%=basePath%>NewsMgServlet?name='+document.getElementById('select').value"
													Title="查询">查询</a><input type="button" class="clean"
													value="清除查询">
												</td>
											</tr>
										</table></td>
									<td width="54%"><table border="0" align="right"
											cellpadding="0" cellspacing="0">
											<tr>
												<td width="60"><table width="87%" border="0"
														cellpadding="0" cellspacing="0">
														<tr>
															<td class="STYLE1"><div align="center">
																	<input type="checkbox" name="checkbox62" id="checkAll" />
																</div></td>
															<td class="STYLE1"><div align="center">全选</div></td>
														</tr>
													</table></td>
												<td width="60"><table width="90%" border="0"
														cellpadding="0" cellspacing="0">
														<tr>
															<td class="STYLE1"><div align="center">
																	<img src="<%=basePath%>images/22.gif" width="14"
																		height="14" />
																</div></td>
															<td class="STYLE1"><div align="center"><a href ="<%=basePath%>CateMgShowServlet2" target="I2">新增</a></div></td>
														</tr>
													</table></td>
											
												<td width="52"><table width="88%" border="0"
														cellpadding="0" cellspacing="0">
														<tr>
															<td class="STYLE1"><div align="center">
																	<img src="<%=basePath%>images/11.gif" width="14"
																		height="14" />
																</div></td>
															<td class="STYLE1"><div align="center">
																	<a href="javascript:viod(0)" onclick="delAll()">删除</a>
																</div></td>
														</tr>
													</table></td>
											</tr>
										</table></td>
								</tr>
							</table></td>
						<td width="16"><img src="<%=basePath%>images/tab_07.gif"
							width="16" height="30" /></td>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td><table width="100%" border="0" cellspacing="0"
					cellpadding="0">
					<tr>
						<td width="8" background="<%=basePath%>images/tab_12.gif">&nbsp;</td>
						<td><table width="100%" border="0" cellpadding="0"
								cellspacing="1" bgcolor="b5d6e6" onmouseover="changeto()"
								onmouseout="changeback()">


								<tr>
									<td width="3%" height="22"
										background="<%=basePath%>images/bg.gif" bgcolor="#FFFFFF"><div
											align="center">
											<input type="checkbox" name="checkbox" value="checkbox" />
										</div></td>
									<td width="3%" height="22"
										background="<%=basePath%>images/bg.gif" bgcolor="#FFFFFF"><div
											align="center">
											<span class="STYLE1">序号</span>
										</div></td>
									<td width="12%" height="22"
										background="<%=basePath%>images/bg.gif" bgcolor="#FFFFFF"><div
											align="center">
											<span class="STYLE1">标题</span>
										</div></td>
									<td width="12%" height="22"
										background="<%=basePath%>images/bg.gif" bgcolor="#FFFFFF"><div
											align="center">
											<span class="STYLE1">所属栏目</span>
										</div></td>
									<td width="12%" height="22"
										background="<%=basePath%>images/bg.gif" bgcolor="#FFFFFF"><div
											align="center">
											<span class="STYLE1">创建时间</span>
										</div></td>
									<td width="12%" height="22"
										background="<%=basePath%>images/bg.gif" bgcolor="#FFFFFF"><div
											align="center">
											<span class="STYLE1">作者</span>
										</div></td>


									<td width="15%" height="22"
										background="<%=basePath%>images/bg.gif" bgcolor="#FFFFFF"
										class="STYLE1"><div align="center">基本操作</div></td>
								</tr>


								<tr>
									<c:forEach items="${page.ls}" var="i">
										<td height="20" bgcolor="#FFFFFF"><div align="center">
												<input type="checkbox" name="cbk" value="${i.articleID}" />
											</div></td>

										<td height="20" bgcolor="#FFFFFF"><div align="center"
												class="STYLE1">
												<div align="center">${i.articleID}</div>
											</div></td>

										<td height="20" bgcolor="#FFFFFF"><div align="center">
												<span class="STYLE1">${i.title}</span>
											</div></td>
										<td height="20" bgcolor="#FFFFFF"><div align="center">
												<span class="STYLE1">${i.keywords}</span>
											</div></td>
										<td height="20" bgcolor="#FFFFFF"><div align="center">
												<span class="STYLE1"><fmt:parseDate value="${i.createtime}" pattern="yyyy-MM-dd HH:mm" var="test"/>
												<fmt:formatDate value="${test}" pattern="yyyy-MM-dd　HH:mm"/>
												</span>
											</div></td>
										<td height="20" bgcolor="#FFFFFF"><div align="center">
												<span class="STYLE1">${i.writer}</span>
											</div></td>
										<td height="20" bgcolor="#FFFFFF"><div align="center">
												<span class="STYLE4"><img
													src="<%=basePath%>images/edt.gif" width="16" height="16" />
													<a
													href="<%=basePath%>manager/new.jsp?id=${i.articleID}&title=${i.title}}&keywords=${i.keywords}&createtime=${i.createtime}&writer=${i.writer}">编辑</a>&nbsp;
													&nbsp; 
												</span>
											</div></td>
								</tr>
								</c:forEach>

							</table></td>
						<td width="8" background="<%=basePath%>images/tab_15.gif">&nbsp;</td>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td height="35" background="<%=basePath%>images/tab_19.gif"><table
					width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="12" height="35"><img
							src="<%=basePath%>images/tab_18.gif" width="12" height="35" /></td>
						<td><table width="100%" border="0" cellspacing="0"
								cellpadding="0">

								<tr>
									<td class="STYLE4">&nbsp;&nbsp;共有 ${page.countpage}
										条记录，当前第 ${page.curpage}/ ${page.maxpage} 页</td>
									<td><table border="0" align="right" cellpadding="0"
											cellspacing="0">
											<tr>
												<td width="40"><a
													href="<%=basePath%>NewsMgServlet?curpage=1&name=${select}"><img
														src="<%=basePath%>images/first.gif" width="37" height="15" />
												</a></td>
												<c:if test="${page.curpage<1}">
													<td width="40"><a
														href="<%=basePath%>NewsMgServlet?curpage=1&name=${select}"><img
															src="<%=basePath%>images/back.gif" width="37" height="15" />
													</a></td>
												</c:if>
												<td width="45"><a
													href="<%=basePath%>NewsMgServlet?curpage=${curpage-1}&name=${select}"><img
														src="<%=basePath%>images/back.gif" width="43" height="15" />
												</a></td>
												<c:if test="${page.curpage>
												page.maxpage}">
													<td width="45"><a
														href="<%=basePath%>NewsMgServlet?curpage=${page.maxpage}&name=${select}"><img
															src="<%=basePath%>images/next.gif" width="43" height="15" />
													</a></td>
												</c:if>
												<td width="40"><a
													href="<%=basePath%>NewsMgServlet?curpage=${page.curpage+1}&name=${select}"><img
														src="<%=basePath%>images/next.gif" width="37" height="15" />
												</a></td>

												<td width="45"><a
													href="<%=basePath%>NewsMgServlet?curpage=${page.maxpage}&name=${select}"><img
														src="<%=basePath%>images/last.gif" width="43" height="15" />
												</a></td>
												<td width="100"><div align="center">
														<span class="STYLE1">转到第 <input name="textfield"
															type="text" size="4"
															style="height:12px; width:20px; border:1px solid #999999;" />
															页 </span>
													</div></td>
												<td width="40"><img src="<%=basePath%>images/go.gif"
													width="37" height="15" />
												</td>
											</tr>
										</table></td>
								</tr>
							</table></td>
						<td width="16"><img src="<%=basePath%>images/tab_20.gif"
							width="16" height="35" /></td>
					</tr>
				</table></td>
		</tr>
	</table>
</body>
</html>