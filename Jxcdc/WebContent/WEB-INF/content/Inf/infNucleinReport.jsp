<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>流感核酸检测报告</title>
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
		
		$( "#collectionDate" ).datepicker({changeMonth:true,changeYear:true,dateFormat:'yy-mm-dd'});	
		
		$("#infNucleinReportForm").validate({
			rules: {
				collectionDate: {
					required:true,
					sDate:true
				}
			}
		});
		
		$("#collectionDate").change(function(){			
			$.post("inf/infReportAction!collectionDateFind",$("#infNucleinReportForm").serializeArray(),function(response){			
				if(response == false){
					$("#massageTD").text("无核酸检测信息。请重新输入收样日期");
					$("#submit").attr("disabled","disabled");
				}else{
					$("#massageTD").text("");
					$("#submit").removeAttr("disabled");					
				}		
			});
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
	<div id="infNucleinReport" >		
		<form id="infNucleinReportForm" action="inf/infReportAction.action">
			<table>
				<caption class="caption">
					流感核酸报告生成
				</caption>
				<tr>
					<td class="td1">收样时间： </td>
					<td class="td2">
						<input id="collectionDate" type="text" name="collectionDate" style="width: 160px;" placeholder="格式：2018KQ01" autocomplete="off"/>
					</td>
					<td class="td3" style="text-align: left;">
						<input id="submit" type="submit" style="width: 80px;" value="生成报告" disabled/>
					</td>
					<td  class="td4"></td>
				</tr>
				<tr id="massageTR">
					<td class="td1"> </td>
					<td id="massageTD" class="td2"></td>
					<td class="td3">
						<input id="flag" name="flag" type="hidden" value="N"/>
					</td>
					<td class="td4"></td>
				</tr>				
			</table>
			<table>
				<caption class="caption">
					流感核酸检测报告信息确认
				</caption>
				<tr>
					<td class="td1">送检单位： </td>
					<td class="td2">
						<input id="samplingCompany" type="text" name="samplingCompany" value="南大一附院"/>
					</td>
					<td class="td3">样本名称： </td>
					<td class="td4">
						<input id="specimenType" type="text" name="specimenType" value="流感样病例鼻咽拭子"/>
					</td>					
				</tr>
				<tr>
					<td class="td1">检测依据：</td>
					<td  class="td2">
						<input id="detectionPrinciple" type="text" name="detectionPrinciple" value="《全国流感监测技术指南(2017年版)》附件1"/>
					</td>
					<td class="td3">检测方法：</td>
					<td class="td4">
						<input id="detectionMethod" type="text" name="detectionMethod" value="Real-time RT-PCR"/>
					</td>
				</tr>	
				<tr>
					<td class="td1">样品规格： </td>
					<td class="td2">
						<input id="specimenSize" type="text" name="specimenSize" value="3ml/管"/>
					</td>
					<td class="td3">样品数量： </td>
					<td class="td4">
						<input id="specimenNum" type="text" name="specimenNum" value="各1管"/>
					</td>					
				</tr>
				<tr>
					<td class="td1">样品状态：</td>
					<td  class="td2">
						<input id="specimenState" type="text" name="specimenState" value="液体"/>
					</td>
					<td class="td3">样品包装：</td>
					<td class="td4">
						<input id="specimenPacking" type="text" name="specimenPacking" value="15ml离心管"/>
					</td>
				</tr>	
				<tr>
					<td class="td1">检测者：</td>
					<td  class="td2">
						<input id="detector" type="text" name="detector" value="李健雄       肖  芳"/>
					</td>
				</tr>			
			</table>
		</form>
	</div>
</body>
</html>