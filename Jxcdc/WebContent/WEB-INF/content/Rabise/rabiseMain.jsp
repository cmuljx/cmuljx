<%@page import="org.apache.struts2.components.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>

<link href="/Jxcdc/source/CSS/jqueryui.css" rel="stylesheet" type="text/css" />
<link href="/Jxcdc/source/CSS/mainformCSS.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="/Jxcdc/source/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="/Jxcdc/source/js/jquery-ui.min.js"></script>

<script type="text/javascript">
	$(function(){
		$("#list1 li").mousemove(function(){
			$(this).css("cursor","pointer");		
		});
		
		$("#rabiseLi1").click(function(){
			$("#rabiseiframe").attr("src","rabise/rabiseData.action");		
		});
		
		$("#rabiseLi2").click(function(){
			$("#rabiseiframe").attr("src","rabise/rabiseResult.action");		
		});
		
		$("#rabiseLi3").click(function(){
			$("#rabiseiframe").attr("src","rabise/rabiseQuery.action");		
		});
		
		$("#rabiseLi4").click(function(){
			$("#rabiseiframe").attr("src","rabise/rabiseReport.action");		
		});
		$("#rabiseLi5").click(function(){
			$("#rabiseiframe").attr("src","rabise/rabiseCollectionAndResultForm.action");		
		});
	})		
	
</script>

<style type="text/css">

</style>
</head>
<body>

<div id="main">
	<div id="top">
		<img src="/Jxcdc/source/images/logo_01.png">
	</div>
	<div id="bottom">
		<div id="left">
			<div id="list">
				<div id="title1">
					信息录入
				</div>
				<div id="list1">
					<ul>
						<li id="rabiseLi1">病例资料</li>
						<li id="rabiseLi2">检测结果</li>
					</ul>	
				</div>
				<div id="title1">
					信息查询修改
				</div>
				<div id="list1">
					<ul>
						<li id="rabiseLi3">病例查询</li>
					</ul>	
				</div>
				<div id="title1">
					生成报告
				</div>
				<div id="list1">
					<ul>
						<li id="rabiseLi4">核酸检测报告</li>
						<li id="rabiseLi5">收样及结果登记表</li>
					</ul>	
				</div>
			</div>
		</div>
		<div id="right">
			<div id="content">
				<iframe id="rabiseiframe" src="" width="100%" height="100%"></iframe>
			</div>
		</div>
	</div>
</div>

</body>
</html>