<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>流感核酸检测情况分析</title>
<link href="/Jxcdc/source/CSS/jqueryui.css" rel="stylesheet"type="text/css" />
<link href="/Jxcdc/source/CSS/formCSS.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="/Jxcdc/source/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="/Jxcdc/source/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="/Jxcdc/source/js/jquery.validate.js"></script>
<script type="text/javascript" src="/Jxcdc/source/js/jquery.validate.extend.js"></script>
<script type="text/javascript" src="/Jxcdc/source/js/messages_zh.js"></script>

<script type="text/javascript" src="/Jxcdc/source/js/echarts.js"></script>
<script type="text/javascript" src="/Jxcdc/source/js/echarts-gl.js"></script>
<script type="text/javascript" src="/Jxcdc/source/js/macarons.js"></script>
<script type="text/javascript" src="/Jxcdc/source/js/jiangxi.js"></script>

<script>
$(function() {
	$( "#startTime" ).datepicker({changeMonth:true,changeYear:true,dateFormat:'yy-mm-dd'});
	$( "#endTime" ).datepicker({changeMonth:true,changeYear:true,dateFormat:'yy-mm-dd'});
	
	var today=new Date();
	var endTime=today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
	var startTime=(today.getFullYear()-1) +'-'+(today.getMonth()+1)+'-'+today.getDate();
	$("#endTime").attr('value',endTime);
	$("#startTime").attr('value',startTime);
	
	var optionWeek = {
	    title : {
	        text: '按周次流感病毒细胞分离情况'
	    },
	    tooltip : {
	        trigger: 'axis',
	        axisPointer : {           
            	type : 'shadow'
        	}
	    },
	    toolbox: {
	    	top:'bottom',
	    	left:'left',
	        show : true,
	        feature : {
	            mark : {show: true},
	            restore : {show: true},
	            saveAsImage : {show: true}
	        }
	    },
	    legend: {
	        left: 'right'
	    },
	    calculable : true,
	    xAxis : {
	        type : 'category'
	    },
	    yAxis : [
	    	{
		    	name:'阳性数',	
		        type : 'value'
	    	},
	    	{
		    	name:'阳性率',	
		        type : 'value',
	        	axisLabel: {  
	                show: true,  
	                interval: 'auto',  
	                formatter: '{value} %'  
	            } 
	    	}
	    ],
       series : [
	        {
	        	type: 'bar',
	        	stack: '总量'
	        },
	        {
	        	type: 'bar',
	        	stack: '总量'
	        },
	        {
	        	type: 'bar',
	        	stack: '总量'
	        },
	        {
	        	type: 'bar',
	        	stack: '总量'
	        },
	        {
	            name:'阳性率',
	            type:'line',
	            yAxisIndex: 1  
	        }
    	]
	}; 
	
	var optionCompany ={
		title : {
			text: "细胞分离阳性检出率",
			left: 'left'
		},
		tooltip: {
		    trigger: 'item',
		    showDelay: 0,
		    transitionDuration: 0.2,
		    formatter: function (params) {
					var value = (params.value + '').split('.');
					if(isNaN(value[0])){
						value[0] = 0;
					}
					if(value[1] !== undefined){
						value = value[0] + "." + value[1].substring(0,2);
					}else{
						value = value[0] + ".00"
					}
					return params.seriesName + '<br/>' + value + "%";
		    }
		},
		visualMap: {
			top:'bottom',
		    left: 'right',
		    min: 0,
		    max: 50,
		    inRange: {
		    	color: ['#e0f3f8', '#ffffbf', '#fee090', '#fdae61', '#f46d43', '#d73027', '#a50026']
		  	},
		    text:['High','Low'],
		    calculable: true
		},
		toolbox: {
			show: true,
			left: 'left',
			top: 'bottom',
			feature: {
			    restore: {},
			    saveAsImage: {}
			}
	 	},
	    series : {
			name: '细胞分离阳性率',
			type: 'map', 
			map: '江西',
			itemStyle: {
			    normal: {
			        show: true,
			        areaColor:"#CECECE",
			        borderColor:"#FCFCFC",
			        borderWidth:"1"
			    },
			    emphasis: {
			        show: true,
			        areaColor:"#C8A5DF",
			    }
			},
			label: {
			    normal: {
			        show: true
			    },
			    emphasis: {
			        show: true
			    }
			},
			data:[]
		}			    
	};
	
	var optionType = {
		title : {
			text: "基因分型",
			left: 'left'
		},
	    legend: {
	        orient: 'vertical',
	        left: 'right'
	    },
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    series : [
	        {
	            name: '核酸分型',
	            type: 'pie',
	            radius : '55%',
	            center: ['50%', '60%'],
	            data:[],
	            itemStyle: {
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            }
	        }
	    ]
	};

	var myChartWeek = echarts.init(document.getElementById("week"));
	var myChartCompany = echarts.init(document.getElementById("cdc"));
	var myChartType = echarts.init(document.getElementById("type"));
	
	myChartWeek.setOption(optionWeek);
	myChartCompany.setOption(optionCompany);
	myChartType.setOption(optionType);
	
	var list;
	function getData(){
		$.post("inf/infSeparationAnalysisAction",$("#infCellAnalysisForm").serializeArray(),function(data){
			list = data;
			myChartWeek.setOption({
				title : {
			        text: data.company.replace("疾病预防控制中心","") +'按周次流感细胞分离情况'
			    },
				dataset : {
					dimensions: ['group', 'h3', 'SH1', 'yamagata' , 'victoria' , 'positiveRate'],
					source:data.listWeek
				}			
			});
			myChartCompany.setOption({
	            series:{
	            	data:[
	            		{
		            		name:data.listCompany.group,
		            		value:data.listCompany.positiveRate,	
	            		},
	            		{
		            		name:data.listCompany[1].group,
		            		value:data.listCompany[1].positiveRate,	
	            		},
	            		{
		            		name:data.listCompany[2].group,
		            		value:data.listCompany[2].positiveRate,	
	            		},
	            		{
		            		name:data.listCompany[3].group,
		            		value:data.listCompany[3].positiveRate,	
	            		},
	            		{
		            		name:data.listCompany[4].group,
		            		value:data.listCompany[4].positiveRate,	
	            		},
	            		{
		            		name:data.listCompany[5].group,
		            		value:data.listCompany[5].positiveRate,	
	            		},
	            		{
		            		name:data.listCompany[6].group,
		            		value:data.listCompany[6].positiveRate,	
	            		},
	            		{
		            		name:data.listCompany[7].group,
		            		value:data.listCompany[7].positiveRate,	
	            		},
	            		{
		            		name:data.listCompany[8].group,
		            		value:data.listCompany[8].positiveRate,	
	            		},
	            		{
		            		name:data.listCompany[9].group,
		            		value:data.listCompany[9].positiveRate,	
	            		},
	            		{
		            		name:data.listCompany[10].group,
		            		value:data.listCompany[10].positiveRate,	
	            		},
	            		{
		            		name:data.listCompany[11].group,
		            		value:data.listCompany[11].positiveRate,	
	            		},
	            		{
		            		name:data.listCompany[12].group,
		            		value:data.listCompany[12].positiveRate,	
	            		},
	            	]
	            }
            });	
		});
	}
	
	getData();

	$("#company").change(function(){
		getData();
		myChartCompany.setOption({
			title : {
		        text: '细胞分离阳性率'
		    }
		});
	});

	$("#startTime").change(function(){
		getData();
		myChartCompany.setOption({
			title : {
		        text: '细胞分离阳性率'
		    }
		});
	});
	
	$("#endTime").change(function(){
		getData();
		myChartCompany.setOption({
			title : {
		        text: '细胞分离阳性率'
		    }
		});
	});
	
	$("#returnButton").click(function(){
		getData();
		myChartType.setOption({
            series:{
            	data:[]
            }
        });	
		myChartCompany.setOption({
			title : {
		        text: '细胞分离阳性率'
		    }
		});
	});
	
	myChartWeek.on('click',function(param){	
		var week0 = param.name;
		var week1 = week0.split('年');
		var week2 = week1[1].split('周');
		var year = week1[0];
		var week = week2[0];
		$("#yearNum").val(year);
		$("#weekNum").val(week);
		getData();
		$("#yearNum").val("");
		$("#weekNum").val("");
		myChartCompany.setOption({
			title : {
		        text: param.name +'细胞分离阳性率'
		    }
		});	
	});
	
	myChartCompany.on('click',function(param){
		
		var index = 20;
		
		for(i=0;i<list.listCompany.length;i++){
			if(param.name == list.listCompany[i].group){
				index = i;
			}		
		}
		myChartType.setOption({
            series:{
            	data:[
            		{
	            		name:"H3",
	            		value:list.listCompany[index].h3,	
            		},
            		{
	            		name:"SH1",
	            		value:list.listCompany[index].SH1,
            		},
            		{
	            		name:"victoria",
	            		value:list.listCompany[index].victoria,
            		},
            		{
	            		name:"yamagata",
	            		value:list.listCompany[index].yamagata,
            		},
            	]
            }
        });	
		
	});
	
});
</script>


<style type="text/css">
#week {
	float: left;
	width: 55vw;
	height: 600px;
}

#cdc {
	float:left;
	width: 25vw;
	height: 600px;
}

#content{
	float:left;
	width: 5vwpx;
	height: 600px;
}

#return{
	text-align:center;
	width: 100px;
	height:40px;	
}

#type{
	width: 200px;
	height: 400px;
}
</style>
</head>
<body>
<div id="infCellAnalysis">
	<form id="infCellAnalysisForm">
		<table>
			<caption class="caption">流感病毒细胞分离情况</caption>
			<tr>
				<td class="td1">检测单位：</td>
				<td class="td2">
					<select id="company" size="1" name="company">
						<option value="全部" selected="selected">全部</option>
						<option value="江西省疾病预防控制中心">江西省</option>
						<option value="南昌市疾病预防控制中心">南昌市</option>
						<option value="九江市疾病预防控制中心">九江市</option>
						<option value="赣州市疾病预防控制中心">赣州市</option>
						<option value="吉安市疾病预防控制中心">吉安市</option>
						<option value="宜春市疾病预防控制中心">宜春市</option>
						<option value="新余市疾病预防控制中心">新余市</option>
						<option value="萍乡市疾病预防控制中心">萍乡市</option>
						<option value="上饶市疾病预防控制中心">上饶市</option>
						<option value="鹰潭市疾病预防控制中心">鹰潭市</option>
						<option value="抚州市疾病预防控制中心">抚州市</option>
						<option value="景德镇市疾病预防控制中心">景德镇市</option>
					</select>
				</td>
				<td class="td3">
					<input id="yearNum" type="hidden" name="yearNum"/>
				</td>
				<td class="td4">
					<input id="weekNum" type="hidden" name="weekNum"/>
				</td>
			</tr>
			<tr>
				<td class="td1">开始时间：</td>
				<td class="td2">
					<input id="startTime" type="text" name="startTime" style="width: 160px;" placeholder="格式：2018-6-1"/>
				</td>
				<td class="td3">结束时间：</td>
				<td class="td4">
					<input id="endTime" type="text" name="endTime" style="width: 160px;" placeholder="格式：2018-6-1"/>
				</td>
			</tr>
		</table>
	</form>
</div>
<hr style="height: 10px; border: none; border-top: 10px groove skyblue;" />
<div>
	<div id="week"></div>
	<div id="cdc"></div>
	<div id="content">
		<div id="return">
			<form>
				<input type="button" id="returnButton" value="重置"/>
			</form>
		</div>
		<div id="type"></div>
	</div>
</div>
</body>
</html>