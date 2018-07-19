<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>狂犬病样本结果录入</title>
<link href="/Jxcdc/source/CSS/jqueryui.css" rel="stylesheet" type="text/css" />
<link href="/Jxcdc/source/CSS/jquery.dataTables.css" rel="stylesheet" type="text/css" />
<link href="/Jxcdc/source/CSS/formCSS.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript" src="/Jxcdc/source/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="/Jxcdc/source/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="/Jxcdc/source/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="/Jxcdc/source/js/jquery.validate.js"></script>
<script type="text/javascript" src="/Jxcdc/source/js/jquery.validate.extend.js"></script>
<script type="text/javascript" src="/Jxcdc/source/js/messages_zh.js"></script>

<script>
	$(function() {
		$( "#time1" ).datepicker({changeMonth:true,changeYear:true,dateFormat:'yy-mm-dd'});
		$( "#time2" ).datepicker({changeMonth:true,changeYear:true,dateFormat:'yy-mm-dd'});	
		
		$("input[type='text']").addClass("item-text");
		$("input[type='submit']").addClass("item-submit");
		
		$("#rabiseQueryTable").dataTable({
			
			"ajax":{
				"url":"rabise/rabiseQueryAction",
				"data":function(){
			    	return $('#rabiseQueryForm').serializeArray();
			    },
				"dataSrc":"rabiseQueryLists",
				"type":"POST"
			},
			"columnDefs" : [{
				"targets" : 8,
				"data" : null,
				"render" : function(data, type, row, meta) {
					var html = "<span><input id='check' type='button' value='查看'></span>"
					html += "<span><input id='modify' type='button' value='编辑'></span>"
					html += "<span><input id='delete' type='button' value='删除'></span>"
					return html;
				}
				}],
			"columns":[
				{"data":"laboratoryNumber"},
				{"data":"name"},
				{"data":"sex"},
				{"data":"age"},
				{"data":"accidentDate"},
				{"data":"samplingDate"},
				{"data":"deliveryDate"},
				{"data":"samplingCompany"},
				{"data":null}
			],
			"language":{
				"url":"/Jxcdc/source/json/DataTable_language.json"
			},
			"order": [[ 0, 'asc' ]],
			
			"autoWidth": true,
			"lengthChange": true,
			"info": true,
			"scrollX": true,
			"filter":false,
			"stateSave": true,		
		});
		
		$("#checkButton").click(function(){
			$("#rabiseQueryTable").DataTable().ajax.reload().draw(); 		
		});
		
		$("#exportButton").click(function(){
			$("#rabiseQueryForm").attr("action","rabise/rabiseDataToExcel");
			$("#rabiseQueryForm").submit();
		});
		
/*		$.post("rabise/rabiseQueryAction",$("#rabiseQueryForm").serializeArray(),function(response){
			
			$("#rabiseQueryTable").dataTable({
				"data":response.rabiseQueryLists,
				"columnDefs" : [ {
					"targets" : 8,
					"data" : null,
					"render" : function(data, type, row, meta) {
						var html = "<span><input id='check' type='button' value='查看'></span>"
						html += "<span><input id='modify' type='button' value='编辑'></span>"
						html += "<span><input id='delete' type='button' value='删除'></span>"
						return html;
					}
					} ],
				"columns":[
					{"data":"laboratoryNumber"},
					{"data":"name"},
					{"data":"sex"},
					{"data":"age"},
					{"data":"accidentDate"},
					{"data":"samplingDate"},
					{"data":"deliveryDate"},
					{"data":"samplingCompany"},
					{"data":null}
				],
				"language":{
					"url":"/Jxcdc/source/json/DataTable_language.json"
				},
				"autoWidth": true,
				"lengthChange": true,
				"info": true,
				"scrollX": true,
				"filter":false,
				"stateSave": true,		
			});
		});	
		
		$("#checkButton").click(function(){
			$.post("rabise/rabiseQueryAction",$("#rabiseQueryForm").serializeArray(),function(response){
				$("#rabiseQueryTable").dataTable({
					"data":response.rabiseQueryLists,
					"columnDefs" : [ {
						"targets" : 8,
						"data" : null,
						"render" : function(data, type, row, meta) {
							var html = "<span><input id='check' type='button' value='查看'></span>"
							html += "<span><input id='modify' type='button' value='编辑'></span>"
							html += "<span><input id='delete' type='button' value='删除'></span>"
							return html;
						}
						} ],
					"columns":[
						{"data":"laboratoryNumber"},
						{"data":"name"},
						{"data":"sex"},
						{"data":"age"},
						{"data":"accidentDate"},
						{"data":"samplingDate"},
						{"data":"deliveryDate"},
						{"data":"samplingCompany"},
						{"data":null}
					],
					"language":{
						"url":"/Jxcdc/source/json/DataTable_language.json"
					},
					"destroy":true,
					"autoWidth": true,
					"lengthChange": true,
					"info": true,
					"scrollX": true,
					"filter":false,
					"stateSave": true,		
				});
			});
		});	
*/		
		
		
		$("#rabiseQueryTable tbody").on("click","#check",function(){
			var row = $("#rabiseQueryTable tr").index($(this).closest("tr"));
			var checkNum = $("#rabiseQueryTable").find("tr").eq(row).find("td").eq(0).text();
			$("#checkNum").val(checkNum);
			$("#rabiseQueryForm").attr("action","rabise/rabiseCheckAction");
			$("#rabiseQueryForm").submit();
		});
		
		$("#rabiseQueryTable tbody").on("click","#modify",function(){
			var row = $("#rabiseQueryTable tr").index($(this).closest("tr"));
			var checkNum = $("#rabiseQueryTable").find("tr").eq(row).find("td").eq(0).text();
			$("#checkNum").val(checkNum);
			$("#rabiseQueryForm").attr("action","rabise/rabiseModifyAction");
			$("#rabiseQueryForm").submit();
		});
		
		$("#rabiseQueryTable tbody").on("click","#delete",function(){
			var row = $("#rabiseQueryTable tr").index($(this).closest("tr"));
			var checkNum = $("#rabiseQueryTable").find("tr").eq(row).find("td").eq(0).text();
			$("#checkNum").val(checkNum);
			var msg = "是否确认删编号"+checkNum+"的病例资料？";
			if(confirm(msg)==true){
				$("#rabiseQueryForm").attr("action","rabise/rabiseDeleteAction");
				$("#rabiseQueryForm").submit();
			}
		});
		
	});
</script>
<style type="text/css">
	#rabiseQueryForm input{
		width:150px;
	}
	.table>tbody>tr>td{
        text-align:center;
	}

</style>
</head>
<body>

<div id="rabiseQuery">
	<div id="rabiseQuery1">
		<form action="" id="rabiseQueryForm">
			<table>
				<caption class="caption">
					狂犬病病例信息查询
				</caption>
				<tr>
					<td class="td1">病例编号： </td>
					<td class="td2">
						<input id="laboratoryNumber" type="text" name="queryLaboratoryNumber" value="${queryLaboratoryNumber}" placeholder="格式：2018KQ01" autocomplete="off"/>
					</td>
					<td class="td3">姓名： </td>					
					<td  class="td4">
						<input id="name" type="text" name="queryName" value="${queryName}"/>
					</td>
				</tr>
				<tr>
					<td class="td1">采样日期 ：</td>
					<td class="td2">
						<input id="time1" type="text" name="queryTime1" value="${queryTime1}" placeholder="格式：2018-01-01" autocomplete="off"/>
					</td>
					<td class="td3" style="text-align: center;">
						~
					</td>
					<td class="td4">
						<input id="time2" type="text" name="queryTime2" value="${queryTime2}" placeholder="格式：2018-01-01" autocomplete="off"/>
					</td>
				</tr>
				<tr>
					<td class="td1">
						<input id="checkNum" type="hidden" name="checkNum"/>
					</td>
					<td class="td2">
						<input id="exportButton" type="button" style="width: 60px;display: none;" value="下载"/>
					</td>
					<td colspan="2" style="text-align: center;">
						<input id="checkButton" type="button" style="width: 60px" value="查找"/>
					</td>
				</tr>	
			</table>
		</form>
	</div>
	<hr style="height:10px;border:none;border-top:10px groove skyblue;"/>
	<div id="rabiseQuery2">
		<table id="rabiseQueryTable" class="table" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>样本编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>发病日期</th>
                <th>采样日期</th>
                <th>送样日期</th>
                <th>送样单位</th> 
                <th>操作</th>      
            </tr>
        </thead>
        <tbody></tbody>
        </table>
	</div>		
</div>
</body>
</html>