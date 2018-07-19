<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>狂犬病样本结果录入</title>
<link href="/Jxcdc/source/CSS/jqueryui.css" rel="stylesheet" type="text/css" />
<link href="/Jxcdc/source/CSS/formCSS.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript" src="/Jxcdc/source/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="/Jxcdc/source/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="/Jxcdc/source/js/jquery.validate.js"></script>
<script type="text/javascript" src="/Jxcdc/source/js/jquery.validate.extend.js"></script>
<script type="text/javascript" src="/Jxcdc/source/js/messages_zh.js"></script>

<script>
	$(function() {
		$( "#time1" ).datepicker({changeMonth:true,changeYear:true,dateFormat:'yy-mm-dd'});
		$( "#time2" ).datepicker({changeMonth:true,changeYear:true,dateFormat:'yy-mm-dd'});
		$( "#time3" ).datepicker({changeMonth:true,changeYear:true,dateFormat:'yy-mm-dd'});
		$( "#time4" ).datepicker({changeMonth:true,changeYear:true,dateFormat:'yy-mm-dd'});
		
		$("input[type='text']").addClass("item-text");
		$("select").addClass("item-select");
		$("input[type='submit']").addClass("item-submit");
		
		$("#rabiseResultLocationForm #submit").click(function(){			
			$.post("rabise/rabiseResultLocations",$("#rabiseResultLocationForm").serializeArray(),function(response){			
				if(response.specimeAmount == "0"){
					$("#rabiseResult2").css("display","none");
					$("#rabiseResult3").css("display","none");
					$("#rabiseResult1 #massageTR").css("display","");
					$("#rabiseResult1 #massageTR #massageTD").text("无此样本编号。请重新输入");
				}else{
					$("#rabiseResult1 #massageTR").css("display","none");
					$("#rabiseResult2").css("display","");
					$("#rabiseResult3").css("display","");
					$("#laboratoryNumber1").val($("#number").val());
					$("#samplingCompany").val(response.samplingCompany);
					$("#name").val(response.name);
					$("#specimeAmount").val(response.specimeAmount);
					$("#detector").val(response.rabiseResults[0].detector);
					$("#type11").css("display","none");
					$("#type12").css("display","none");
					$("#type21").css("display","none");
					$("#type22").css("display","none");
					$("#type31").css("display","none");
					$("#type32").css("display","none");
					$("#type41").css("display","none");
					$("#type42").css("display","none");
					switch(response.specimeAmount){
						case 4:
							$("#type41").css("display","");
							$("#type42").css("display","");
							$("#specimeNumber4").val(response.rabiseResults[3].sampleNumber);
							$("#result4").val(response.rabiseResults[3].result);
							if(response.rabiseResults[3].detectionDate !== null){
								$("#time4").val(response.rabiseResults[3].detectionDate.substring(0,10));
							}
						case 3:	
							$("#type31").css("display","");
							$("#type32").css("display","");
							$("#specimeNumber3").val(response.rabiseResults[2].sampleNumber);
							$("#result3").val(response.rabiseResults[2].result);
							if(response.rabiseResults[2].detectionDate !== null){
								$("#time3").val(response.rabiseResults[2].detectionDate.substring(0,10));
							}
						case 2:
							$("#type21").css("display","");
							$("#type22").css("display","");
							$("#specimeNumber2").val(response.rabiseResults[1].sampleNumber);
							$("#result2").val(response.rabiseResults[1].result);
							if(response.rabiseResults[1].detectionDate !== null){
								$("#time2").val(response.rabiseResults[1].detectionDate.substring(0,10));
							}
						case 1:
							$("#type11").css("display","");
							$("#type12").css("display","");
							$("#specimeNumber1").val(response.rabiseResults[0].sampleNumber);
							$("#result1").val(response.rabiseResults[0].result);
							if(response.rabiseResults[0].detectionDate !== null){
								$("#time1").val(response.rabiseResults[0].detectionDate.substring(0,10));		
							}
					}
				}			
			});
		});	
		
		$("#rabiseResultLocationForm").validate({
			rules: {
				laboratoryNumber: {
					required:true,
					rabiseNum:true
				}
			}
		});
		
		$("#rabiseResultForm").validate({
			rules: {
				laboratoryNumber: {
					required:true,
					rabiseNum:true
				},
				"rabiseResults[0].time": {
					sDate:true
				},
				"rabiseResults[1].time": {
					sDate:true
				},
				"rabiseResults[2].time": {
					sDate:true
				},
				"rabiseResults[3].time": {
					sDate:true
				},
				detector: {
					required:true
				}
			}
		});
		
	});
</script>
<style type="text/css">
	#rabiseResult{
		height: 100%;
		position: relative;
		left: 5%;
		top: 5%;
	}
</style>
</head>
<body>
	<div id="rabiseResult">
		<div id="rabiseResult1">
			<form id="rabiseResultLocationForm">
				<table>
					<caption class="caption">
						狂犬病标本核酸检查结果录入
					</caption>
					<tr>
						<td class="td1">病例编号： </td>
						<td class="td2">
							<input id="number" type="text" name="laboratoryNumber" style="width: 160px;" placeholder="格式：2018KQ01" autocomplete="off"/>
						</td>
						<td class="td3"></td>
						<td  class="td4">
							<input id="submit" type="button" style="width: 60px" value="查找"/>
						</td>
					</tr>
					<tr id="massageTR" style="display:none;">
						<td class="td1"> </td>
						<td id="massageTD" class="td2"></td>
						<td class="td3"></td>
						<td class="td4"></td>
					</tr>
				</table>
			</form>
		</div>
		<form id="rabiseResultForm" action="rabise/rabiseResultAction.action">
		<div id="rabiseResult2" style="display: none">
			<table>
				<caption class="caption">
					标本信息
				</caption>
				<tr>
					<td class="td1">病例编号： </td>
					<td class="td2">
						<input id="laboratoryNumber1" type="text" name="laboratoryNumberRead" readonly/>
					</td>
					<td class="td3"></td>
					<td class="td4"></td>
				</tr>
				<tr>
					<td class="td1">姓名： </td>
					<td class="td2">
						<input id="name" type="text" name="name" disabled/>
					</td>
					<td class="td3"></td>
					<td class="td4"></td>
				</tr>
				<tr>
					<td class="td1">送检单位： </td>
					<td class="td2">
						<input id="samplingCompany" type="text" name="samplingCompany" disabled/>
					</td>
					<td class="td3"></td>
					<td class="td4"></td>
				</tr>
			</table>
		</div>
		<div id="rabiseResult3" style="display:none">
				<table>
					<caption class="caption">
						核酸检测结果
					</caption>
					<tr>
						<td class="td1">样本数量： </td>
						<td class="td2">
							<input id="specimeAmount" type="text" name="specimeAmount" readonly/>
						</td>
						<td class="td3"></td>
						<td class="td4"></td>
					</tr>
					<tr id="type11" style="display:none;">
						<td class="td1">样本编号： </td>
						<td class="td2">
							<input id="specimeNumber1" type="text" name="rabiseResults[0].specimeNumber" readonly/>
						</td>
					</tr>
					<tr id="type12" style="display:none;">
						<td class="td1">检测结果： </td>
						<td class="td2">
							<select id="result1" size="1" name="rabiseResults[0].result">
								<option value="未检测" selected="selected">未检测</option>
								<option value="阴性">阴性</option>
								<option value="阳性">阳性</option>
							</select>
						</td>
						<td class="td3">检测日期： </td>
						<td class="td4">
							<input id="time1" type="text" name="rabiseResults[0].time" placeholder="格式：2018-01-01" autocomplete="off"/>
						</td>
					</tr>					
					<tr id="type21" style="display: none;">
						<td class="td1">样本编号： </td>
						<td class="td2">
							<input id="specimeNumber2" type="text" name="rabiseResults[1].specimeNumber" readonly/>
						</td>
					</tr>
					<tr id="type22" style="display: none;">
						<td class="td1">检测结果： </td>
						<td class="td2">
							<select id="result2" size="1" name="rabiseResults[1].result">
								<option value="未检测" selected="selected">未检测</option>
								<option value="阴性">阴性</option>
								<option value="阳性">阳性</option>
							</select>
						</td>
						<td class="td3">检测日期： </td>
						<td class="td4">
							<input id="time2" type="text" name="rabiseResults[1].time" placeholder="格式：2018-01-01" autocomplete="off"/>
						</td>
					</tr>	
					<tr id="type31" style="display: none;">
						<td class="td1">样本编号： </td>
						<td class="td2">
							<input id="specimeNumber3" type="text" name="rabiseResults[2].specimeNumber" readonly/>
						</td>
					</tr>
					<tr id="type32" style="display: none;">
						<td class="td1">检测结果： </td>
						<td class="td2">
							<select id="result3" size="1" name="rabiseResults[2].result" >
								<option value="未检测" selected="selected">未检测</option>
								<option value="阴性">阴性</option>
								<option value="阳性">阳性</option>
							</select>
						</td>
						<td class="td3">检测日期： </td>
						<td class="td4">
							<input id="time3" type="text" name="rabiseResults[2].time" placeholder="格式：2018-01-01" autocomplete="off"/>
						</td>
					</tr>	
					<tr id="type41" style="display: none;">
						<td class="td1">样本编号： </td>
						<td class="td2">
							<input id="specimeNumber4" type="text" name="rabiseResults[3].specimeNumber" readonly/>
						</td>
					</tr>
					<tr id="type42" style="display: none;">
						<td class="td1">检测结果： </td>
						<td class="td2">
							<select id="result4" size="1" name="rabiseResults[3].result">
								<option value="未检测" selected="selected">未检测</option>
								<option value="阴性">阴性</option>
								<option value="阳性">阳性</option>
							</select>
						</td>
						<td class="td3">检测日期： </td>
						<td class="td4">
							<input id="time4" type="text" name="rabiseResults[3].time" placeholder="格式：2018-01-01" autocomplete="off"/>
						</td>
					</tr>	
					<tr>
						<td class="td1"></td>
						<td class="td2" style="text-align: right;">检测人： </td>
						<td class="td3">
							<input id="detector" type="text" style="width: 80px;" name="detector"/>
						</td>
					</tr>
					<tr>
						<td></td>
						<td class="td7" style="text-align: center;" colspan="2">
							<input id="submit" type="submit" style="width: 60px" value="保存" onkeydown= "if(event.keyCode==13){event.keyCode=0;return false;}"/>				
						</td>				
					</tr>											
				</table>			
		</div>
		</form>		
	</div>
</body>
</html>