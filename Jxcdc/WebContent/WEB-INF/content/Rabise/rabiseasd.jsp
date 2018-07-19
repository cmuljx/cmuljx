<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<link href="/Jxcdc/source/CSS/jqueryui.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/Jxcdc/source/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="/Jxcdc/source/js/jquery-ui.min.js"></script>

<script>
	$(function() {
		$( "#time1" ).datepicker({changeMonth:true,changeYear:true,dateFormat:'yy-mm-dd'});
		$( "#time2" ).datepicker({changeMonth:true,changeYear:true,dateFormat:'yy-mm-dd'});
		$( "#time3" ).datepicker({changeMonth:true,changeYear:true,dateFormat:'yy-mm-dd'});
		$( "#time4" ).datepicker({changeMonth:true,changeYear:true,dateFormat:'yy-mm-dd'});

		$("#rabiseDataForm").validate({
			rules: {
				laboratoryNumber: {
					required:true,
					rangelength:[8,8]
				},
				name: {
					required:true
				},
				profession: {
			        required:true
			    },
			    ageNum: {
			    	required:true,
			    	digits:true,
			    	range:[0,120]
			    },
			    profession: {
			    	required:true
			    },
			    address: {
			    	required:true
			    },
			    accidentDate: {
			    	required:true
			    	date:true
			    },
			    samplingDate: {
			    	required:true
			    	date:true
			    },
			    deliveryDate: {
			    	required:true,
			    	date:true
				},
				collectionDate: {
					required:true,
					date:true
				},
				samplingCompany: {
					required:true
				},
				samplingPerson: {
					required:true
				},
				deliveryPerson: {
					required:true
				},
				collectionPerson: {
					required:true
				}
			},
			messages: {
				laboratoryNumber: {
					required:"请输入病例编号(年份+KQ+流水号)",
					rangelength:"请按格式输入病例编号(年份+KQ+流水号)"
				},
				name: {
					required:"请输入患者姓名"
				},
				profession: {
			        required: "请输入患者职业"
			    },
			    ageNum: {
			    	required:"请输入患者年龄",
			    	digits:"年龄必须为整数",
			    	range:"年龄必须为0-120之间的整数"
			    },
			    profession: {
			    	required:"请输入患者职业",
			    },
			    address: {
			    	required:"请输入患者地址",
			    },
			    accidentDate: {
			    	required:"请输入发病日期",
			    	date:"必须为正确的日格式"
			    },
			    samplingDate: {
			    	required:"请输入采样日期",
			    	date:"必须为正确的日格式"
			    },
			    deliveryDate: {
			    	required:"请输入送样日期",
			    	date:"必须为正确的日格式"
				},
				collectionDate: {
					required:"请输入收样日期",
					date:"必须为正确的日格式"
				},
				samplingCompany: {
					required:"请输入送样单位"
				},
				samplingPerson: {
					required:"请输入采样人"
				},
				deliveryPerson: {
					required:"请输入送样人"
				},
				collectionPerson: {
					required:"请输入样品接收人"
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
	form{
		height: 100%;
		width: 100%
	}
	caption{
		font-size: 18pt;
		height: 40px;
		border-width: 4px;
		border-style: solid;
		border-color: #ccc #ccc #444 #444; 
		background-color: silver;
		line-height: 40px;
	}
	tr{
		height: 35px;
	}
	.td1{
		width: 200px;
		text-align: right;
	}	
	.td2{
		width: 200px;
	}
	.td3{
		width: 100px;
		text-align: right;
	}
	.td4{
		width: 200px;
	}
</style>
</head>
<body>
	<s:debug/>
	<div id="rabiseResult">
		<div id="rabiseResult1">
			<form id="rabiseResultLocation" action="rabise/rabiseResultLocation.action">
				<table>
					<caption class="caption">
						狂犬病标本核酸检查结果录入
					</caption>
					<tr>
						<td class="td1">样本编号： </td>
						<td class="td2">
							<input id="number" type="text" name="laboratoryNumber"/>
						</td>
						<td class="td3"></td>
						<td  class="td4">
							<input id="submit" type="submit" style="width: 60px" value="查找"/>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div id="rabiseResult2" style="display: none">
			<table>
				<caption class="caption">
					标本信息
				</caption>
				<tr>
					<td class="td1">姓名： </td>
					<td class="td2">
						<label id="name"></label>
					</td>
				</tr>
				<tr>
					<td class="td1">送检单位： </td>
					<td class="td2">
						<label id="samplingCompany"></label>
					</td>
				</tr>
			</table>
		</div>
		<div id="rabiseResult3" style="display:none">
			<form>
				<table>
					<caption class="caption">
						核酸检测结果
					</caption>
					<tr>
						<td class="td1">样本数量： </td>
						<td class="td2">
							<label id="specimeAmount"></label>
						</td>
					</tr>
					<tr id="type1" style="display:none;">
						<td class="td1">样本编号： </td>
						<td class="td2">
							<label id="id1"></label>
						</td>
					</tr>
					<tr id="type1" style="display:none;">
						<td class="td1">检测结果： </td>
						<td class="td2">
							<select id="type1" size="1">
								<option value="1" selected="selected">阴性</option>
								<option value="2">阳性</option>
							</select>
						</td>
						<td class="td3">检测日期： </td>
						<td class="td4">
							<input id="time1" type="text" />
						</td>
					</tr>					
					<tr id="type2" style="display: none;">
						<td class="td1">样本编号： </td>
						<td class="td2">
							<label id="id2"></label>
						</td>
					</tr>
					<tr id="type2" style="display: none;">
						<td class="td1">检测结果： </td>
						<td class="td2">
							<select id="type2" size="1">
								<option value="1" selected="selected">阴性</option>
								<option value="2">阳性</option>
							</select>
						</td>
						<td class="td3">检测日期： </td>
						<td class="td4">
							<input id="time2" type="text" />
						</td>
					</tr>	
					<tr id="type3" style="display: none;">
						<td class="td1">样本编号： </td>
						<td class="td2">
							<label id="id3"></label>
						</td>
					</tr>
					<tr id="type3" style="display: none;">
						<td class="td1">检测结果： </td>
						<td class="td2">
							<select id="type3" size="1">
								<option value="1" selected="selected">阴性</option>
								<option value="2">阳性</option>
							</select>
						</td>
						<td class="td3">检测日期： </td>
						<td class="td4">
							<input id="time3" type="text" />
						</td>
					</tr>	
					<tr id="type4" style="display: none;">
						<td class="td1">样本编号： </td>
						<td class="td2">
							<label id="id4"></label>
						</td>
					</tr>
					<tr id="type4" style="display: none;">
						<td class="td1">检测结果： </td>
						<td class="td2">
							<select id="type4" size="1">
								<option value="1" selected="selected">阴性</option>
								<option value="2">阳性</option>
							</select>
						</td>
						<td class="td3">检测日期： </td>
						<td class="td4">
							<input id="time4" type="text" />
						</td>
					</tr>	
					<tr>
						<td class="td1"></td>
						<td class="td2" style="text-align: right;">检测人： </td>
						<td class="td3">
							<input type="text" style="width: 80px;"/>
						</td>
					</tr>
					<tr>
						<td> </td>
						<td  class="td7" style="text-align: center;">
							<input id="submit" type="submit" style="width: 60px" value="保存"/>				
						</td>
						<td  class="td8" style="text-align: center;">
							<input id="clear" type="button" style="width: 60px" value="返回"/>
						</td>	
						<td> </td>				
					</tr>											
				</table>
			</form>
		</div>		
	</div>
</body>
</html>