<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";	
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'update.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
		#myimg{
			width:100px;
			height:100px
		}
	</style>
  </head>
  
  <body>
  	 <s:form action="productAction!update.action" enctype="multipart/form-data">
     	<s:hidden name="id" value="%{id}"></s:hidden>
    	<s:textfield name="productName" label="学号" value="%{productName}"></s:textfield>
    	<s:textfield name="price" label="姓名" value="%{price}"></s:textfield>
    	<s:file name='photo' label="图片" value="%{photoFileName}"></s:file>
    	<img id="myimg" src="${picture}"/>
    	<s:submit value="修改"></s:submit>
    </s:form>
  </body>
</html>
