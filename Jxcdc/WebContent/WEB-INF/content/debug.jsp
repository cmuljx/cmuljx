<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<s:iterator value="userList" var="name">
		<s:property value="name.username"/>
		<s:property value="name.password"/>
	</s:iterator>
 	<s:debug/><br/>
</body>
</html>