<%@page import="org.apache.struts2.components.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>流感系统</title>

<link href="/Jxcdc/source/CSS/jqueryui.css" rel="stylesheet"
	type="text/css" />
<link href="/Jxcdc/source/CSS/mainformCSS.css" rel="stylesheet"
	type="text/css" />

<script type="text/javascript" src="/Jxcdc/source/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="/Jxcdc/source/js/jquery-ui.min.js"></script>

<script type="text/javascript">
	$(function(){
		$("#list1 li").mousemove(function(){
			$(this).css("cursor","pointer");		
		});
		
		$("#inf1").click(function(){
			$("#infFrame").attr("src","inf/infDataImport.action");		
		});
		$("#inf2").click(function(){
			$("#infFrame").attr("src","inf/infDataNameUpdate.action");		
		});
		$("#inf4").click(function(){
			$("#infFrame").attr("src","inf/infNucleinReport.action");		
		});
		$("#inf7").click(function(){
			$("#infFrame").attr("src","inf/infNucleinAnalysis.action");		
		});
		
		$("#inf8").click(function(){
			$("#infFrame").attr("src","inf/infSeparationAnalysis.action");		
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
					<div id="title1">信息导入</div>
					<div id="list1">
						<ul>
							<li id="inf1">流感资料导入</li>
							<li id="inf2">流感病人姓名录入</li>
						</ul>
					</div>
					<div id="title1">生成报告</div>
					<div id="list1">
						<ul>
							<li id="inf3">病毒分离报告</li>
							<li id="inf4">核酸检测报告</li>
							<li id="inf5">实验原始记录</li>
							<li id="inf6">实验记录表</li>
						</ul>
					</div>
					<div id="title1">流感数据分析</div>
					<div id="list1">
						<ul>
							<li id="inf7">核酸数据分析</li>
							<li id="inf8">细胞分离数据分析</li>
						</ul>
					</div>
				</div>
			</div>
			<div id="right">
				<div id="content">
					<iframe id="infFrame" src="" width="100%" height="100%"></iframe>
				</div>
			</div>
		</div>
	</div>

</body>
</html>