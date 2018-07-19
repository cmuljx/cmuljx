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

<script>
	$(function() {
		
		$("input[type='submit']").addClass("item-submit");
		
		
		$("#rabiseReportForm").validate({
			rules: {
				laboratoryNumber: {
					required:true,
					rabiseNum:true
				}
			}
		});
		
		$("#upload").click(function(){
			$("#uploadTip").text("导入中");
			$("#infDataImportForm").submit();
		});
		
	});
</script>
<style type="text/css">

</style>
</head>
<body>
	<div id="infDataImport">
		<s:form id="infDataImportForm" enctype="multipart/form-data" action="inf/infDataImportAction.action" theme="simple">
			<table>
				<caption class="caption">流感数据导入</caption>
				<tr>
					<td class="td1">导入文件(.CSV)：</td>
					<td class="td2">
						<s:file id="InfImport" name="InfImport" style="width: 200px;"/>
					</td>
					<td class="td3" style="text-align: left;">
						<input id="upload" type="button" style="width: 80px;" value="导入" 
						onkeydown="if(event.keyCode==13){event.keyCode=0;return false;}" />
					</td>
					<td class="td4" id="uploadTip">
						
					</td>
				</tr>
				<tr id="massageTR">
					<td class="td1" ></td>
					<td class="td2" colspan="2"><s:fielderror/></td>
					<td class="td4"></td>
				</tr>
			</table>
		</s:form>
	</div>
</body>
</html>