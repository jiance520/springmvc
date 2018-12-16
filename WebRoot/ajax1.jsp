<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ajax1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	<script type="text/javascript" src="/springmvc/js/jquery-1.12.4.js"></script>
	-->
  <script type="text/javascript" src="<%=basePath %>js/jquery-1.12.4.js"></script>
  <script type="text/javascript">
  
        $(function(){
        	//alert(0);
        	$("#test1").click(function(){
        		//
        		$.post("ajax1",{user:'小明',num:12},function(data){
        			alert(data.title);
        			
        		},"json");
        		//
        		alert(1);
        	});
        	
        	$("#test2").click(function(){
        		//
        	    $.ajax({
        	    	  type: "POST",
        	    	  url: "/springmvc/ajax1",
        	    	  data: "user=小明&num=12",
        	    	  dataType: "json",
        	    	  async: false,
        	    	  success: function(data){
        	    	    alert(data.title);
        	    	  }
        	    }) ;
        		//
        		alert(1);
        	});
        	
        	$("#test3").click(function(){
        		//
        		$.post("ajax2",{user:'小明',num:12},function(data){
        			alert(data.title);
        			
        		},"json");
        		
        	});
        })
        
  </script>
  </head>
  
  <body>
    <h1>test ajax1</h1>
    <div>
         <p><input type="button" id="test1" value="流实现ajax"></p>
         <p><input type="button" id="test2" value="ajax同步测试"></p>
         <p><input type="button" id="test3" value="ResponseBody实现ajax"></p>
    </div>
  </body>
</html>
