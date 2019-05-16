<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String loginName = (String)request.getAttribute("LOGINNAME");
if(loginName==null){
	Cookie[] cookieArr = request.getCookies();
	if(cookieArr!=null){
		for(Cookie c:cookieArr){
			if("LOGINNAME".equals(c.getName())){
				loginName = c.getValue();
			}
		}
	}
}
String msg = (String)request.getAttribute("MSG");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function myload(){
			var mg = "<%=msg%>";
			if(mg!="null"){
				alert(mg);
			}
		}
		function myschool(){
			var minPrice = document.getElementsByName("minprice").value();
			var maxPrice = document.getElementsByName("maxprice").value();
			if(minPrice>maxPrice){
				alert("最小价格要小于最大价格");
				return false;
			}
			if(minPrice!=0&&maxPrice==0){
				alert("若输入最小价格请输入最大价格");
				return false;
			}
		}
	</script>
  </head>
  
  <body onload="myload()">
  	<%=loginName %>,你好
  	<s:form action="productAction!preAdd.action" name = "preaddForm">
  	 	<s:submit value="增加"/>
  	</s:form>
  	<table border="1">
  		<caption>产品表</caption>
  		<tr>
   			<th>产品名</th>
   			<th>价格</th>
   			<th>图片</th>
   			<th>删除栏</th>
   			<th>修改栏</th>
   		</tr>
   		<s:iterator value="proList">
   			<tr>
   				<td><s:property value="productName"/></td>
   				<td><s:property value="price"/></td>
   				<td><img alt="图片未找到" src="${picture}" width="100" height="100"></td>
   				<td><a href="productAction!delete.action?id=<s:property value='id'/>">删除</a></td>
   				<td><a href="productAction!preUpdate.action?id=<s:property value='id'/>">修改</a></td>
   			</tr>
   		</s:iterator>
  	</table>
  <s:form action="productAction!query.action">
  	<s:textfield name="pv.productName" label="商品名"></s:textfield>
  	<s:textfield name="pv.minprice" label="最小价格"></s:textfield>
  	<s:textfield name="pv.maxprice" label="最大价格"></s:textfield>
 	<s:submit value="查询" onclick="return myschool()"></s:submit>
  </s:form>
  </body>
</html>
