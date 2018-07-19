<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>狂犬病报告生成</title>
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
		
		$("#laboratoryNumber").change(function(){			
			$.post("rabise/rabiseResultLocations",$("#laboratoryNumber").serializeArray(),function(response){			
				if(response.specimeAmount == "0"){
					$("#massageTD").text("无此样本编号。请重新输入");
					$("#submit").attr("disabled","disabled");
				}else{
					$("#massageTD").text("");
					$("#submit").removeAttr("disabled");					
				}		
			});
		});	
		
		$("#rabiseReportForm").validate({
			rules: {
				laboratoryNumber: {
					required:true,
					rabiseNum:true
				},
				specimenSpecification: {
					required:true
				},
				specimenNum: {
					required:true
			    },
			    specimenState: {
			    	required:true
			    },
			    specimenPacking: {
			    	required:true
			    }
			}
		});
		
	});
</script>
<style type="text/css">
	#rabiseReport{
		height: 100%;
	}

</style>
</head>
<body>
	<div id="rabiseReport" >		
		<form id="rabiseReportForm" action="rabise/rabiseReportAction.action">
			<table>
				<caption class="caption">
					狂犬病病例报告生成
				</caption>
				<tr>
					<td class="td1">病例编号： </td>
					<td class="td2">
						<input id="laboratoryNumber" type="text" name="laboratoryNumber" style="width: 160px;" placeholder="格式：2018KQ01" autocomplete="off"/>
					</td>
					<td class="td3" style="text-align: left;">
						<input id="submit" type="submit" style="width: 80px;" value="生成报告" disabled="disabled" onkeydown= "if(event.keyCode==13){event.keyCode=0;return false;}"/>
					</td>
					<td  class="td4"></td>
				</tr>
				<tr id="massageTR">
					<td class="td1"> </td>
					<td id="massageTD" class="td2"></td>
					<td class="td3"></td>
					<td class="td4"></td>
				</tr>				
			</table>
			<table>
				<caption class="caption">
					狂犬病病例报告信息确认
				</caption>
				<tr>
					<td class="td1">样品规格： </td>
					<td class="td2">
						<input id="specimenSpecification" type="text" name="specimenSpecification" value="3.0ml/管"/>
					</td>
					<td class="td3">样品数量： </td>
					<td class="td4">
						<input id="specimenNum" type="text" name="specimenNum" value="1管"/>
					</td>					
				</tr>
				<tr>
					<td class="td1">样品状态：</td>
					<td  class="td2">
						<input id="specimenState" type="text" name="specimenState" value="液态"/>
					</td>
					<td class="td3">样品包装：</td>
					<td class="td4">
						<input id="specimenPacking" type="text" name="specimenPacking" value="采样管"/>
					</td>
				</tr>				
			</table>
		</form>
	</div>
</body>
</html>