<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>狂犬病收样及结果登记表</title>
<link href="/Jxcdc/source/CSS/jqueryui.css" rel="stylesheet" type="text/css" />
<link href="/Jxcdc/source/CSS/formCSS.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript" src="/Jxcdc/source/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="/Jxcdc/source/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="/Jxcdc/source/js/jquery.validate.js"></script>
<script type="text/javascript" src="/Jxcdc/source/js/jquery.validate.extend.js"></script>
<script type="text/javascript" src="/Jxcdc/source/js/messages_zh.js"></script>

<script>
	$(function() {
		
		$("input[type='text']").addClass("item-text");
		$("input[type='submit']").addClass("item-submit");	
		
	});
</script>
<style type="text/css">


</style>
</head>
<body>
	<div id="rabiseCollectionAndResult" >		
		<form id="rabiseCollectionAndResultForm" action="rabise/rabiseCollectionAndResultFormAction.action">
			<table>
				<caption class="caption">
					狂犬病病例报告生成
				</caption>
				<tr>
					<td class="td1">年份： </td>
					<td class="td2">
						<input id="year" type="text" name="year" style="width: 160px;" autocomplete="off"/>
					</td>
					<td class="td3" style="text-align: left;">
						<input type="submit" style="width: 80px;" value="生成表" onkeydown= "if(event.keyCode==13){event.keyCode=0;return false;}"/>
					</td>
					<td  class="td4"></td>
				</tr>				
			</table>
		</form>
	</div>
</body>
</html>