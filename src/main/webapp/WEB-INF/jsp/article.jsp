<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>主页</title>
    <script type="text/javascript" src="<%=path%>/static/js/jquery-1.11.0.min.js"></script>
  	<link rel="stylesheet" href="<%=path%>/static/css/bootstrap.min.css" type="text/css"></link>
  	<link rel="stylesheet" href="<%=path%>/static/css/style.css" type="text/css"></link>
  	<script type="text/javascript" src="<%=path%>/static/js/bootstrap-paginator.min.js"></script>
  	<script type="text/javascript" src="<%=path%>/static/js/bootstrap.min.js"></script>
  	<style type="text/css">
  		body{
  			background: #f3f3f3;
  			padding: 50px;
  			font-family: 微软雅黑;
  		}
  	</style>
  </head>
    
  <body>
  	<div class="navbar navbar-inverse navbar-fixed-top header">
        <div class="container">
          <ul class="nav navbar-nav">
	        <li class="active"><a href="#">首页</a></li>
	        <li><a href="#">分类</a></li>
	        <li><a href="#">排行榜</a></li>
	        <li><a href="#">关于</a></li>
	        <li><a href="#">友情链接</a></li>
	      </ul>
        </div>
    </div>
    <div class="container" style="margin-top: 20px;">
	  	<div id="content" class="row">
			  <div class="col-md-9" >
			  	<div class="panel panel-default">
				   <div class="panel-body">
				       	公告：<br/>
				       	总文章数：${pageDto.total} 
				   </div>
				</div>
			    <c:if test="${!empty pageDto.rows }">
			    <c:forEach items="${pageDto.rows}" var="row">
			    	<div style="height: 100px">
			    		<h4 style="border-bottom: 1px solid #CCC;padding-bottom: 10px;"><a href="#" style="color: black;">${row.articleTitle }</a></h4>
			    	    <div class="col-md-3" style="padding-left: 0px;">
			    	      <small><label class="glyphicon glyphicon-user"><a href="#" data-toggle="tooltip" data-placement="bottom" title="作者：${row.articleAuthorEmail }">${row.articleAuthorEmail }</a></label></small>
			    	    </div>
			    	    <div class="col-md-3" style="padding-left: 0px;">
			    	      <small><span class="glyphicon glyphicon-calendar"></span> ${row.articleCreateDate }</small>
			    	    </div>
			    	    <div class="col-md-3" style="text-align: left">
			    	      <small><label class="glyphicon glyphicon-folder-open"> <a href="#" data-toggle="tooltip" data-placement="bottom" title="浏览次数：${row.articleViewCount }">${row.articleViewCount }</a></label></small>
			    	    </div>
			    	    <div class="col-md-3" style="text-align: left">
			    	      <small><label class="glyphicon glyphicon-comment"> <a href="#" data-toggle="tooltip" data-placement="bottom" title="评论数：${row.articleCommentCount }">${row.articleCommentCount }</a></label></small>
			    	    </div>
			    	</div>
			    </c:forEach>
			    </c:if>
			    <ul id="example"></ul>
			  </div>
			  <div class="col-md-3">
			    <h2>Sidebar</h2>
			    <ul class="nav nav-pills nav-stacked">
				  <li class="active"><a href='#'>Another Link 1</a></li>
				  <li><a href='#'>Another Link 2</a></li>
				  <li><a href='#'>Another Link 3</a></li>
				</ul>
				<div class="panel panel-default">
				   <div class="panel-heading">最近更新</div>
				   <ul class="list-group">
				      <li class="list-group-item">免费域名注册</li>
				      <li class="list-group-item">免费 Window 空间托管</li>
				      <li class="list-group-item">图像的数量</li>
				      <li class="list-group-item">24*7 支持</li>
				      <li class="list-group-item">每年更新成本</li>
				   </ul>
				</div>
			  </div>
		</div>
	</div>
	
	<script type="text/javascript">
		var options = {
			bootstrapMajorVersion: 3,//bootstrap版本
            alignment:"center",
            currentPage:"${pageDto.currentPage}",
            numberOfPages:5,
            totalPages: "${pageDto.totalPages}",
            pageUrl: function(type, page, current){
            			return "<%=path%>/article?pageNo="+page;  
            		 }
        };
		$(document).ready(function(){
        	$("#example").bootstrapPaginator(options);
		});
     </script>
  </body>
</html>
