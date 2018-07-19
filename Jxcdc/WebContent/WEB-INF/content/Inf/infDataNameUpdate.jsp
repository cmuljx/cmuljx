<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>流感病例姓名录入</title>
<link href="/Jxcdc/source/CSS/jqueryui.css" rel="stylesheet"
	type="text/css" />
<link href="/Jxcdc/source/CSS/formCSS.css" rel="stylesheet"
	type="text/css" />

<script type="text/javascript" src="/Jxcdc/source/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="/Jxcdc/source/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="/Jxcdc/source/js/jquery.validate.js"></script>
<script type="text/javascript"
	src="/Jxcdc/source/js/jquery.validate.extend.js"></script>
<script type="text/javascript" src="/Jxcdc/source/js/messages_zh.js"></script>

<script>
	$(function() {
		$( "#collectionDate" ).datepicker({changeMonth:true,changeYear:true,dateFormat:'yy-mm-dd'});
		
		$("input[type='text']").addClass("item-text");
		$("input[type='submit']").addClass("item-submit");
		
		$("#SamplingDataFindButton").click(function(){			
			$.post("inf/infDataNameUpdateAction",$("#infSamplingDataFind").serializeArray(),function(response){			
				if(response.flag){
					$("#collectionDate1").val($("#collectionDate").val());
					$("#massageTD").text("");
					$("#collectionDate").attr("disabled" , "disabled");
					$("#SamplingDataFindButton").attr("disabled" , "disabled");
					$("#laboratoryNumber").val(response.laboratoryNumber);
					$("#name").val(response.name);
					$("#number").val(response.number);
					$("#preButton").removeAttr("disabled");
					$("#nextButton").removeAttr("disabled");
					$("#name").removeAttr("disabled");
				}else{
					$("#massageTD").text("查不到样本信息，请重新输入收样日期！");				
				}	
			});
		});	
		
		$("#preButton").click(function(){			
			$.post("inf/infDataNameUpdateAction!pre",$("#infNameUpdate").serializeArray(),function(response){			
				if(response.flag){
					$("#massageTE").text("");
					$("#laboratoryNumber").val(response.laboratoryNumber);
					$("#name").val(response.name);
					$("#number").val(response.number);
				}else{
					$("#massageTE").text("已经是第一个");				
				}			
			});
		});	
		
		$("#nextButton").click(function(){			
			$.post("inf/infDataNameUpdateAction!next",$("#infNameUpdate").serializeArray(),function(response){			
				if(response.flag){
					$("#massageTE").text("");
					$("#laboratoryNumber").val(response.laboratoryNumber);
					$("#name").val(response.name);
					$("#number").val(response.number);
				}else{
					$("#massageTE").text("已经是最后一个");				
				}		
			});
		});	
		
		$("#infSamplingDataFind").validate({
			rules: {
				"collectionDate": {
					sDate:true,
					required:true
				}
			}
		});
		
	});
</script>
<style type="text/css">

</style>
</head>
<body>
	<div>
		<div>
			<form id="infSamplingDataFind">
				<table>
					<caption class="caption">流感病例姓名录入</caption>
					<tr>
						<td class="td1">采样日期：</td>
						<td class="td2"><input id="collectionDate" type="text"
							name="collectionDate" style="width: 160px;"
							placeholder="格式：2018-01-01" autocomplete="off" /></td>
						<td class="td3">
							<input id="SamplingDataFindButton" type="button" style="width: 60px" value="查找" />
						</td>
						<td class="td4">
						</td>
					</tr>
					<tr id="massageTR">
						<td class="td1"></td>
						<td id="massageTD" class="td2" colspan="2"></td>
						<td class="td4"></td>
					</tr>
				</table>
			</form>
		</div>
		<form id="infNameUpdate">
			<div>
				<table>
					<caption class="caption">标本信息</caption>
					<tr>
						<td class="td1">病例编号：</td>
						<td class="td2">
							<input id="laboratoryNumber" type="text" name="laboratoryNumber" readonly />
						</td>
						<td class="td3">
							<input id="number" name="number" type="hidden" />
						</td>
						<td class="td4">
							<input id="collectionDate1" name="collectionDate" type="hidden" />
						</td>
					</tr>
					<tr>
						<td class="td1">姓名：</td>
						<td class="td2">
							<input id="name" type="text" name="name" disabled="disabled"/>
						</td>
						<td id="massageTE" class="td3" colspan="2" style="text-align: left;"></td>
					</tr>
					<tr>
						<td></td>
						<td class="td7" style="text-align: left;" colspan="2">
							<input id="preButton" type="button" style="width: 60px" value="上一个" disabled="disabled"/>
							<input id="nextButton" type="button" style="width: 60px" value="下一个" disabled="disabled"/>
						</td>
					</tr>
				</table>
			</div>
		</form>
	</div>
</body>
</html>