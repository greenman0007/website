<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <title>${article.articleTitle }</title>
    <%@ include file="common/head.jsp"%> 
  </head>
  
  <body>
    <%@ include file="common/top.jsp"%> 
    <div class="wrap container">
	  	<div id="content" class="row">
			  <div class="col-md-9"  style="margin-top: 20px;">
			  	<h3 class="text-center" style="border-bottom: 1px solid #CCC;padding-bottom: 10px;">${article.articleTitle }</h3>
			  	<p class="text-justify">${article.articleContent }</p>
			  </div>
			  <%@ include file="common/right.jsp"%> 
		</div>
	</div>
  </body>
</html>
