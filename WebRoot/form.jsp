<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'form.jsp' starting page</title>
    
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
    <form action="form4" method="post">
      <p>编码：<input type="text" name="id"/></p>
      <p>名称：<input type="text" name="name"/></p>
      <p><input type="submit" value="提交"/></p>
    </form>
    <hr/>
    <form action="form6" method="post">
      <p>名称1：<input type="text" name="names"/></p>
      <p>名称2：<input type="text" name="names"/></p>
      <p>名称2：<input type="text" name="names"/></p>
      <p><input type="submit" value="提交"/></p>
    </form>
    <hr/>
    <form action="form5" method="post">
      <p>编码：<input type="text" name="did"/></p>
      <p>标题：<input type="text" name="title"/></p>
      <p><input type="submit" value="提交"/></p>
    </form>
    <hr/>
    <form action="form7" method="post">
      <p>编码：<input type="text" name="demo.did"/></p>
      <p>标题：<input type="text" name="demo.title"/></p>
      <p>时间：<input type="text" name="demo.dtime"/></p>
      <p><input type="submit" value="提交"/></p>
    </form>
    <hr/>
  </body>
</html>
