<%@page import="org.apache.struts2.components.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>欢迎登录</title>

<link href="/Jxcdc/source/CSS/jqueryui.css" rel="stylesheet"
	type="text/css" />
<link href="/Jxcdc/source/CSS/mainformCSS.css" rel="stylesheet"
	type="text/css" />
<link href="/Jxcdc/source/CSS/welcome.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="/Jxcdc/source/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="/Jxcdc/source/js/jquery-ui.min.js"></script>

<script type="text/javascript">
	$("#rabise").click(function(){
		
		
		
		
	});
</script>

<style type="text/css">

</style>
</head>
<body style="width: 100%;">

	<div id="main" style="width: 100%; margin-left: auto; margin-right: auto;">
		<div id="top">
			<img src="source/images/logo_01.png">
		</div>
		<div class="mid" style='height: 100%; border: 0px;'>
			<!--导航begin-->
			<div class="nav">
				<div style="text-align: left; text-overflow: ellipsis;" class="l">欢迎您登录</div>				
			</div>

			<!--列表begin-->
			<div class="list" style="width: 100%;">
				<ul>
					<li class="img">
						<a href="rabiseMain.action"> 
							<img src="source/images/rabise.png" width="200" height="200" />
						</a>
					</li>
					<li class="t">
						<a href="rabiseMain.action">狂      犬</a>
					</li>
				</ul>
				<ul>
					<li class="img">
						<a href="infMain.action"> 
							<img src="source/images/inf.png" width="200" height="200" />
						</a>
					</li>
					<li class="t">
						<a href="infMain.action">流      感</a>
					</li>
				</ul>
			</div>
			<!--列表end-->
		</div>
	</div>
</body>
</html>