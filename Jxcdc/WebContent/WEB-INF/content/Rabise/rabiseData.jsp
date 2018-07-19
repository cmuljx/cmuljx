<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>狂犬病病例资料录入</title>
<link href="/Jxcdc/source/CSS/jqueryui.css" rel="stylesheet" type="text/css"/>
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
		
		$("#caption").attr("onselectstart","return false;");
		$(".td1").attr("onselectstart","return false;");
		$(".td3").attr("onselectstart","return false;");
		$("input[type='text']").addClass("item-text");
		$("select").addClass("item-select");
		$("input[type='submit']").addClass("item-submit");
		
		$("#num").change(function(){
			var num_val = $("#num option:selected").val();			
			switch(num_val){
				case "1":
					$("#type1 .td1").text("标本类型：");
					$("#type2").css("display","none");
					$("#type3").css("display","none");
					$("#type4").css("display","none");
					break;
				case "2":
					$("#type1 .td1").text("标本类型1：");
					$("#type2").css("display","");
					$("#type3").css("display","none");
					$("#type4").css("display","none");
					break;
				case "3":
					$("#type1 .td1").text("标本类型1：");
					$("#type2").css("display","");
					$("#type3").css("display","");
					$("#type4").css("display","none");
					break;
				case "4":
					$("#type1 .td1").text("标本类型1：");
					$("#type2").css("display","");
					$("#type3").css("display","");
					$("#type4").css("display","");
					break;				
			}		
		});
		
		$("#laboratoryNumber").change(function(){
			$.post("rabise/rabiseResultLocations",$("#laboratoryNumber").serializeArray(),function(response){
				if(response.specimeAmount != "0"){
					$("#laboratoryNumberMessage").text("样本编号重复，请重新输入");
					$("#laboratoryNumber").val("");
				}else{
					$("#laboratoryNumberMessage").text("");
				}
			});
		});
		
		$("#rabiseDataForm").validate({
			rules: {
				laboratoryNumber: {
					required:true,
					rabiseNum:true
				},
				name: {
					required:true
				},
			    ageNum: {
			    	digits:true,
			    	range:[0,120]
			    },
			    accidentDate: {
			    	required:true,
			    	sDate:true
			    },
			    samplingDate: {
			    	required:true,
			    	sDate:true
			    },
			    deliveryDate: {
			    	required:true,
			    	sDate:true
				},
				collectionDate: {
					required:true,
			    	sDate:true
				},
				samplingCompany: {
					required:true
				},
				collectionPerson: {
					required:true
				}
			}
		});
	
	});
	
</script>
<style type="text/css">
	#rabiseData{
		height: 100%;
	}
</style>
</head>
<body>
	<div id="rabiseData">
		<form id="rabiseDataForm" action="rabise/rabiseDataAction.action">
			<table>
				<caption id="caption">
					狂犬病标本病例信息登记表
				</caption>
				<tr>
					<td class="td1">送检单位： </td>
					<td class="td2">
						<input type="text" name="samplingCompany" style="width: 160px;" placeholder="***疾病预防控制中心" autocomplete="off"/>
					</td>
					<td class="td3">采样人： </td>
					<td class="td4">
						<input type="text" name="samplingPerson" autocomplete="off"/>
					</td>
				</tr>
				<tr>
					<td class="td1">实验室编号： </td>
					<td class="td2">
						<input id="laboratoryNumber" type="text" style="width: 160px;" name="laboratoryNumber" placeholder="格式：2018KQ01" autocomplete="off"/>
					</td>
					<td colspan="2" id="laboratoryNumberMessage" style="color: red;"></td>
				</tr>
				<tr>
					<td class="td1">患者姓名： </td>
					<td class="td2">
						<input type="text" name="name" placeholder="请输入患者姓名" autocomplete="off"/>
					</td>
					<td class="td3">职业： </td>
					<td class="td4">
						<input type="text" name="profession"/>
					</td>
				</tr>
				<tr>
					<td class="td1">性别： </td>
					<td colspan="3" class="td5">
						<select id="sex" size="1" name="sex">
							<option value="男" selected="selected">男</option>
							<option value="女">女</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="td1">年龄： </td>
					<td class="td2">
						<input type="text" name="ageNum"/>
					</td>
					<td colspan="2" class="td6">
						<input name="ageUnit" value="岁" type="radio" checked="checked"/>岁
						<input name="ageUnit" value="月" type="radio" />月
					</td>					
				</tr>
				<tr>
					<td class="td1">家庭住址： </td>
					<td colspan="3" class="td5">
						<input type="text" style="width: 70%;" name="address" autocomplete="off"/>
					</td>
				</tr>				
				<tr>
					<td class="td1">发病日期： </td>
					<td class="td2">
						<input id="time1" type="text" name="accidentDate" placeholder="格式：2018-01-01" autocomplete="off" tip="请输入发病日期"/>
					</td>
					<td class="td3">采样日期： </td>
					<td class="td4">
						<input id="time2" type="text" name="samplingDate" placeholder="格式：2018-01-01" autocomplete="off" tip="请输入采样日期"/>
					</td>
				</tr>
				<tr>
					<td class="td1">送样日期： </td>
					<td class="td2">
						<input id="time3" type="text" name="deliveryDate" placeholder="格式：2018-01-01" autocomplete="off" tip="请输入送样日期"/>
					</td>
					<td class="td3">收样日期： </td>
					<td class="td4">
						<input id="time4" type="text" name="collectionDate" placeholder="格式：2018-01-01" autocomplete="off" tip="请输入收样日期"/>
					</td>
				</tr>
				<tr>
					<td class="td1">标本数量： </td>
					<td colspan="3" class="td5">
						<select id="num" size="1" name="specimeAmount">
							<option value="1" selected="selected">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
						</select>
					</td>
				</tr>
				<tr id="type1">
					<td class="td1">标本类型： </td>
					<td colspan="3" class="td5">
						<select id="type" size="1" name="type1">
							<option value="唾液" selected="selected">唾液</option>
							<option value="咽拭子">咽拭子</option>
							<option value="痰液">痰液</option>
							<option value="尿液">尿液</option>
						</select>
					</td>
				</tr>
				<tr id="type2" style="display: none;">
					<td class="td1">标本类型2： </td>
					<td colspan="3" class="td5">
						<select id="type" size="1" name="type2">
							<option value="唾液" selected="selected">唾液</option>
							<option value="咽拭子">咽拭子</option>
							<option value="痰液">痰液</option>
							<option value="尿液">尿液</option>
						</select>
					</td>
				</tr>
				<tr id="type3" style="display: none;">
					<td class="td1">标本类型3： </td>
					<td colspan="3" class="td5">
						<select id="type" size="1" name="type3">
							<option value="唾液" selected="selected">唾液</option>
							<option value="咽拭子">咽拭子</option>
							<option value="痰液">痰液</option>
							<option value="尿液">尿液</option>
						</select>
					</td>
				</tr>
				<tr id="type4" style="display: none;">
					<td class="td1">标本类型4： </td>
					<td colspan="3" class="td5">
						<select id="type" size="1" name="type4">
							<option value="唾液" selected="selected">唾液</option>
							<option value="咽拭子">咽拭子</option>
							<option value="痰液">痰液</option>
							<option value="尿液">尿液</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="td1">送样人： </td>
					<td class="td2">
						<input type="text" name="deliveryPerson" autocomplete="off"/>
					</td>
					<td class="td3">收样人： </td>
					<td class="td4">
						<input type="text" name="collectionPerson" value="李健雄"/>
					</td>					
				</tr>
				<tr>
					<td  class="td7" colspan="4" style="text-align:center;">
						<input id="save" type="submit" style="margin-left: 450px;" value="保存" onkeydown = "if(event.keyCode==13){event.keyCode=0;return false;}"/>				
					</td>			
				</tr>
			</table>
		</form>
	
	</div>
</body>
</html>