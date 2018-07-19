<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>狂犬病病例资料</title>
<link href="/Jxcdc/source/CSS/jqueryui.css" rel="stylesheet" type="text/css" />
<link href="/Jxcdc/source/CSS/formCSS.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript" src="/Jxcdc/source/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="/Jxcdc/source/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="/Jxcdc/source/js/jquery.validate.js"></script>
<script type="text/javascript" src="/Jxcdc/source/js/jquery.validate.extend.js"></script>
<script type="text/javascript" src="/Jxcdc/source/js/messages_zh.js"></script>

<script>
$(function() {
	$( "#accidentDate" ).datepicker({changeMonth:true,changeYear:true,dateFormat:'yy-mm-dd'});
	$( "#samplingDate" ).datepicker({changeMonth:true,changeYear:true,dateFormat:'yy-mm-dd'});
	$( "#deliveryDate" ).datepicker({changeMonth:true,changeYear:true,dateFormat:'yy-mm-dd'});
	$( "#collectionDate" ).datepicker({changeMonth:true,changeYear:true,dateFormat:'yy-mm-dd'});
	$( "#time1" ).datepicker({changeMonth:true,changeYear:true,dateFormat:'yy-mm-dd'});
	$( "#time2" ).datepicker({changeMonth:true,changeYear:true,dateFormat:'yy-mm-dd'});
	$( "#time3" ).datepicker({changeMonth:true,changeYear:true,dateFormat:'yy-mm-dd'});
	$( "#time4" ).datepicker({changeMonth:true,changeYear:true,dateFormat:'yy-mm-dd'});
	
	$("input[type='text']").addClass("item-text");
	$("select").addClass("item-select");
	$("input[type='submit']").addClass("item-submit");
	
	if("${flag}" == "check"){
		$("#rabiseCheck1 :input").attr("disabled","disabled");
		$("#return").removeAttr("disabled");
		$("#queryLaboratoryNumber").removeAttr("disabled");
		$("#queryName").removeAttr("disabled");
		$("#queryTime1").removeAttr("disabled");
		$("#queryTime2").removeAttr("disabled");
		$("#save").css("display","none");
	}
	
	$("#sex").val("${rabiseVO.rabiseData.sex}");
	$("input:radio[value='${rabiseVO.rabiseData.ageUnit}']").attr('checked','true');
	$("#type1").val("${rabiseVO.rabiseResults[0].type}");
	$("#result1").val("${rabiseVO.rabiseResults[0].result}");
	$("#type2").val("${rabiseVO.rabiseResults[1].type}");
	$("#result2").val("${rabiseVO.rabiseResults[1].result}");
	$("#type3").val("${rabiseVO.rabiseResults[2].type}");
	$("#result3").val("${rabiseVO.rabiseResults[2].result}");
	$("#type4").val("${rabiseVO.rabiseResults[3].type}");
	$("#result4").val("${rabiseVO.rabiseResults[3].result}");
	switch("${rabiseVO.rabiseData.specimeAmount}"){
	case "4":
		$("#type41").css("display","");
		$("#type42").css("display","");
	case "3":	
		$("#type31").css("display","");
		$("#type32").css("display","");
	case "2":
		$("#type21").css("display","");
		$("#type22").css("display","");
	case "1":
		$("#type11").css("display","");
		$("#type12").css("display","");
	}
	
	$("#return").click(function(){
		$("#rabiseCheckForm").submit();
	});
	
	$("#save").click(function(){
		$("#rabiseCheckForm").attr("action","rabise/rabiseSaveAction.action");
		$("#rabiseCheckForm").submit();
	});
	
	$("#rabiseCheckForm").validate({
		rules: {
			"rabiseData.name": {
				required:true
			},
			"rabiseData.ageNum": {
		    	digits:true,
		    	range:[0,120]
		    },
		    "rabiseData.accidentDate": {
		    	required:true,
		    	sDate:true
		    },
		    "rabiseData.samplingDate": {
		    	required:true,
		    	sDate:true
		    },
		    "rabiseData.deliveryDate": {
		    	required:true,
		    	sDate:true
			},
			"rabiseData.collectionDate": {
				required:true,
		    	sDate:true
			},
			"rabiseData.samplingCompany": {
				required:true
			},
			"rabiseData.collectionPerson": {
				required:true
			},
			"rabiseResults[0].detectionDate": {
				sDate:true
			},
			"rabiseResults[1].detectionDate": {
				sDate:true
			},
			"rabiseResults[2].detectionDate": {
				sDate:true
			},
			"rabiseResults[3].detectionDate": {
				sDate:true
			},
			"rabiseData.detector": {
				required:true
			}
		}
	});
	
	
	
	
});


</script>
<style type="text/css">
	#rabiseCheck{
		height: 100%;
		position: relative;
		left: 5%;
		top: 5%;
	}
	.td10{
		width: 700px;
		text-align: center;
	}
</style>



</head>
<body>
<div id="rabiseCheck1">
	<form id="rabiseCheckForm" action="rabise/rabiseQueryReturnAction.action" method="post">
		<input id="queryLaboratoryNumber" type="hidden" name="queryLaboratoryNumber" value="${queryLaboratoryNumber}"/>
		<input id="queryName" type="hidden" name="queryName" value="${queryName}"/>
		<input id="queryTime1" type="hidden" name="queryTime1" value="${queryTime1}"/>
		<input id="queryTime2" type="hidden" name="queryTime2" value="${queryTime2}"/>
		<table>
			<caption id="caption">
				狂犬病病例信息
			</caption>
			<tr>
				<td class="td1">实验室编号： </td>
				<td colspan="3" class="td5">
					<input type="text" name="rabiseData.laboratoryNumber" readonly value="${rabiseVO.rabiseData.laboratoryNumber}"/>
				</td>
			</tr>
			<tr>
				<td class="td1">患者姓名： </td>
				<td class="td2">
					<input id="name" type="text" name="rabiseData.name" value="${rabiseVO.rabiseData.name}"/>
				</td>
				<td class="td3"></td>
				<td class="td4"></td>
			</tr>
			<tr>
				<td class="td1">职业： </td>
				<td class="td2">
					<input type="text" name="rabiseData.profession" value="${rabiseVO.rabiseData.profession}"/>
				</td>
			</tr>
			
			<tr>
				<td class="td1">性别： </td>
				<td colspan="3" class="td5">
					<select id="sex" size="1" name="rabiseData.sex">
						<option value="男" selected="selected">男</option>
						<option value="女">女</option>
					</select>
				</td>
			</tr>
			<tr>
				<td class="td1">年龄： </td>
				<td class="td2">
					<input id="ageNum" type="text" name="rabiseData.ageNum" value="${rabiseVO.rabiseData.ageNum}"/>
				</td>
				<td colspan="2" class="td6">
					<input name="rabiseData.ageUnit" value="岁" type="radio" checked="checked"/>岁
					<input name="rabiseData.ageUnit" value="月" type="radio" />月
				</td>					
			</tr>
			<tr>
				<td class="td1">发病日期： </td>
				<td class="td2">
					<input id="accidentDate" type="text" name="rabiseData.accidentDate" value="${rabiseVO.rabiseData.accidentDate}" placeholder="格式：2018-01-01" autocomplete="off"/>
				</td>
			</tr>
			<tr>
				<td class="td1">家庭住址： </td>
				<td colspan="3" class="td5">
					<input type="text" style="width: 70%;" name="rabiseData.address" value="${rabiseVO.rabiseData.address}"/>
				</td>
			</tr>
		</table>
		<table>
			<caption id="caption">
				狂犬病样本采样信息
			</caption>
			<tr>
				<td class="td1">送检单位： </td>
				<td class="td2">
					<input id="samplingCompany" type="text" name="rabiseData.samplingCompany" value="${rabiseVO.rabiseData.samplingCompany}"/>
				</td>
			</tr>
			<tr>
				<td class="td1">采样日期： </td>
				<td class="td2">
					<input id="samplingDate" type="text" name="rabiseData.samplingDate" value="${rabiseVO.rabiseData.samplingDate}" placeholder="格式：2018-01-01" autocomplete="off"/>
				</td>
				<td class="td3">采样人： </td>
				<td class="td4">
					<input type="text" name="rabiseData.samplingPerson"  value="${rabiseVO.rabiseData.samplingPerson}"/>
				</td>
			</tr>
			<tr>
				<td class="td1">送样日期： </td>
				<td class="td2">
					<input id="deliveryDate" type="text" name="rabiseData.deliveryDate" value="${rabiseVO.rabiseData.samplingDate}" placeholder="格式：2018-01-01" autocomplete="off"/>
				</td>
				<td class="td3">送样人： </td>
				<td class="td4">
					<input type="text" name="rabiseData.deliveryPerson"  value="${rabiseVO.rabiseData.deliveryPerson}"/>
				</td>
				
			<tr>
				<td class="td1">收样日期： </td>
				<td class="td2">
					<input id="collectionDate" type="text" name="rabiseData.collectionDate" value="${rabiseVO.rabiseData.collectionDate}" placeholder="格式：2018-01-01" autocomplete="off"/>
				</td>
				<td class="td3">收样人： </td>
				<td class="td4">
					<input id="collectionPerson" type="text" name="rabiseData.collectionPerson" value="${rabiseVO.rabiseData.collectionPerson}"/>
				</td>	
			</tr>
		</table>
		<table>
			<caption id="caption">
				狂犬病样本检测结果
			</caption>
			<tr>
				<td class="td1">样本数量： </td>
				<td class="td2">
					<input id="specimeAmount" type="text" name="rabiseData.specimeAmount" value="${rabiseVO.rabiseData.specimeAmount}" readonly/>
				</td>
				<td class="td3"></td>
				<td class="td4"></td>
			</tr>
			<tr id="type11" style="display: none;">
				<td class="td1">样本编号： </td>
				<td class="td2">
					<input id="specimeNumber1" type="text" name="rabiseResults[0].sampleNumber" value="${rabiseVO.rabiseResults[0].sampleNumber}" readonly/>
				</td>
				<td class="td3">标本类型： </td>
				<td class="td4">
					<select id="type1" size="1" name="rabiseResults[0].type">
						<option value="唾液" selected="selected">唾液</option>
						<option value="咽拭子">咽拭子</option>
						<option value="痰液">痰液</option>
						<option value="尿液">尿液</option>
					</select>
				</td>
			</tr>
			<tr id="type12" style="display: none;">
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
					<input id="time1" type="text" name="rabiseResults[0].detectionDate" value="${rabiseVO.rabiseResults[0].detectionDate}" placeholder="格式：2018-01-01" autocomplete="off"/>
				</td>
			</tr>		
			<tr id="type21" style="display: none;">
				<td class="td1">样本编号： </td>
				<td class="td2">
					<input id="specimeNumber2" type="text" name="rabiseResults[1].sampleNumber" value="${rabiseVO.rabiseResults[1].sampleNumber}" readonly/>
				</td>
				<td class="td3">标本类型： </td>
				<td class="td4">
					<select id="type2" size="1" name="rabiseResults[1].type">
						<option value="唾液" selected="selected">唾液</option>
						<option value="咽拭子">咽拭子</option>
						<option value="痰液">痰液</option>
						<option value="尿液">尿液</option>
					</select>
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
					<input id="time2" type="text" name="rabiseResults[1].detectionDate" value="${rabiseVO.rabiseResults[1].detectionDate}" placeholder="格式：2018-01-01" autocomplete="off"/>
				</td>
			</tr>
			<tr id="type31" style="display: none;">
				<td class="td1">样本编号： </td>
				<td class="td2">
					<input id="specimeNumber3" type="text" name="rabiseResults[2].sampleNumber" value="${rabiseVO.rabiseResults[2].sampleNumber}" readonly/>
				</td>
				<td class="td3">标本类型： </td>
				<td class="td4">
					<select id="type3" size="1" name="rabiseResults[2].type">
						<option value="唾液" selected="selected">唾液</option>
						<option value="咽拭子">咽拭子</option>
						<option value="痰液">痰液</option>
						<option value="尿液">尿液</option>
					</select>
				</td>
			</tr>
			<tr id="type32" style="display: none;">
				<td class="td1">检测结果： </td>
				<td class="td2">
					<select id="result3" size="1" name="rabiseResults[2].result">
						<option value="未检测" selected="selected">未检测</option>
						<option value="阴性">阴性</option>
						<option value="阳性">阳性</option>
					</select>
				</td>
				<td class="td3">检测日期： </td>
				<td class="td4">
					<input id="time3" type="text" name="rabiseResults[2].detectionDate" value="${rabiseVO.rabiseResults[2].detectionDate}" placeholder="格式：2018-01-01" autocomplete="off"/>
				</td>
			</tr>
			<tr id="type41" style="display: none;">
				<td class="td1">样本编号： </td>
				<td class="td2">
					<input id="specimeNumber4" type="text" name="rabiseResults[3].sampleNumber" value="${rabiseVO.rabiseResults[3].sampleNumber}" readonly/>
				</td>
				<td class="td3">标本类型： </td>
				<td class="td4">
					<select id="type4" size="1" name="rabiseResults[3].type">
						<option value="唾液" selected="selected">唾液</option>
						<option value="咽拭子">咽拭子</option>
						<option value="痰液">痰液</option>
						<option value="尿液">尿液</option>
					</select>
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
					<input id="time4" type="text" name="rabiseResults[3].detectionDate" value="${rabiseVO.rabiseResults[3].detectionDate}" placeholder="格式：2018-01-01" autocomplete="off"/>
				</td>
			</tr>
			<tr>
				<td class="td1"></td>
				<td class="td2" style="text-align: right;">检测人： </td>
				<td class="td3">
					<input type="text" style="width: 80px;" name="rabiseData.detector" value="${rabiseVO.rabiseData.detector}"/>
				</td>
			</tr>
			<tr>
				<td style="text-align: center;" colspan="4">
				<span>
					<input type="button" id="save" value="保存" onkeydown= "if(event.keyCode==13){event.keyCode=0;return false;}"/>
				</span>
				&nbsp&nbsp&nbsp&nbsp
				<span>
					<input type="button" id="return" value="返回" onkeydown= "if(event.keyCode==13){event.keyCode=0;return false;}"/>
				</span>
			</tr>	
		</table>

	</form>
</div>
</body>
</html>