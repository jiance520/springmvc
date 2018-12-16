<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'upload.jsp' starting page</title>
    
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
    <h2><a href="/springmvc/download?realName=ojdbc14.jar">文件下载</a></h2>
    <h2>文件上传</h2>
    <form action="upload2" method="post" enctype="multipart/form-data">
    	标题： <input type="text" name="title" /><br/>
    	文件1：<input type="file" name="files" /><br/>
    	文件2：<input type="file" name="files" /><br/>
    	文件3：<input type="file" name="files" /><br/>
    	<input type="submit" value="提交">
    </form>
  </body>
</html>
