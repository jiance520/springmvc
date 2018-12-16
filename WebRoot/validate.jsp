<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

request.setAttribute("times", new Date());
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'validate.jsp' starting page</title>
    
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
    <h1>验证测试</h1>
    <fmt:setBundle basename="message"/>
    <form action="/springmvc/hello" method="post">
    	<p>
    		<fmt:message key="id"/>:<input type="text" name="id" />
    	</p>
    	<p>
    		<fmt:message key="name"/>:<input type="text" name="name"/>
    	</p>
    	<p>
    		<input type="submit" value="<fmt:message key='submit'/>"/>
    	</p>
    </form>
    <h1>
    	<fmt:formatDate value="${times}" pattern="yyyy-MM-dd"/>
    </h1>
  </body>
</html>
