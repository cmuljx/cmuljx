<%@ page language="java" contentType="text/html; charset=UTF-8" errorPage=""%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>流感数据导入</title>
<link href="/Jxcdc/source/CSS/jqueryui.css" rel="stylesheet" type="text/css" />
<link href="/Jxcdc/source/CSS/formCSS.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="/Jxcdc/source/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="/Jxcdc/source/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="/Jxcdc/source/js/jquery.validate.js"></script>
<script type="text/javascript" src="/Jxcdc/source/js/jquery.validate.extend.js"></script>
<script type="text/javascript" src="/Jxcdc/source/js/messages_zh.js"></script>

<style type="text/css">
div{
	position: relative; 
	top:100px;
	left: 100px;
	font-size: 40px;
	color: red;
	

}

</style>
</head>
<body>
	<div id="infDataImport">
		${importTip}
	</div>
</body>
</html>