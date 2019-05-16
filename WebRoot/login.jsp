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
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function mysubmit(){
			var userName = document.getElementsByName("user.name")[0].value;
			var password = document.getElementsByName("user.password")[0].value;
			if(userName=="" || userName ==null){
				alert("用户名不能为空。");
				return false;
			}
			if(password=="" || password ==null){
				alert("密码不能为空。");
				return false;
			}
			return true;
		}
	</script>

  </head>
  
  <body>
	 <s:form action="loginAction!login.action" name="loginAction">
     	<s:textfield name="user.name" label="用户名："></s:textfield>
    	<s:password name="user.password" label="密码："></s:password>
    	<s:submit value="登录" onclick="return mysubmit()"></s:submit>
     </s:form>
  </body>
</html>
