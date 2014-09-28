<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <title>coderme的博客</title>
  	<%@ include file="common/head.jsp"%> 
  </head>
    
  <body>
  	<%@ include file="common/top.jsp"%> 
    <div class="wrap container">
	  	<div id="content" class="row">
			  <div class="col-md-9"  style="margin-top: 20px;">
			    <c:if test="${!empty pageDto.rows }">
			    <c:forEach items="${pageDto.rows}" var="row">
			    	<div style="height: 100px">
			    		<h4 style="border-bottom: 1px solid #CCC;padding-bottom: 10px;"><a href="<%=request.getContextPath() %>${row.articlePermalink}" style="color: black;">${row.articleTitle }</a></h4>
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
			    	    <div>
				    		<p>${row.articleAbstract }</p>
				    	</div>
			    	</div>
			    </c:forEach>
			    </c:if>
			    <ul id="example"></ul>
			  </div>
			  <%@ include file="common/right.jsp"%> 
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
            			return "<%=path%>/index?pageNo="+page;  
            		 }
        };
		$(document).ready(function(){
        	$("#example").bootstrapPaginator(options);
		});
     </script>
  </body>
</html>
