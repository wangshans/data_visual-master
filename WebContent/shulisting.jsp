<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="loginCheck.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>

	<meta charset="utf-8">
    <title>以太坊合约大数据分析系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    
   
    <link href="http://fonts.googleapis.com/css?family=Oxygen|Marck+Script" rel="stylesheet" type="text/css">
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <link href="assets/css/font-awesome.css" rel="stylesheet">
    <link href="assets/css/admin.css" rel="stylesheet">
    <link href="assets/css/bootstrap-table.css" rel="stylesheet">
    <script type='text/javascript' src="assets/js/echarts.min.js" charset='utf-8'></script>
<script type='text/javascript' src="assets/js/jquery.js" charset='utf-8'></script>
    
   

</head>    
<body>

<div class="container">
		
	<div class="row">
		
		<div class="span2">
		
		<div class="main-left-col">
			
			<ul class="side-nav">

				<li class="active">
					<a href="index.jsp"><i class="icon-home"></i> 主页</a><!--dashboard-->
				</li>
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="collapse" data-target="#reports-dropdown" href="#"><i class="icon-signal"></i> 详细报表 <b class="caret"></b></a>
					<ul id="reports-dropdown" class="collapse">
						<li><a href="report.jsp">合约量统计</a></li>
						<li><a href="listing.jsp">合约信息</a></li>
						<li><a href="doublisting.jsp">合约双方信息</a></li>
						<li><a href="biglisting.jsp">大户信息</a></li>
					</ul>
				</li>
				
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="collapse" data-target="#help-dropdown" href="#"><i class="icon-info-sign"></i> 帮助 <b class="caret"></b></a>
					<ul id="help-dropdown" class="collapse">
						<li><a href="content.jsp">景区规章制度</a></li>
					</ul>
				</li>
			</ul>
		
		</div> 
	
	</div> 
	
	<div class="span10">
		
	<div class="secondary-masthead">
	
		<ul class="nav nav-pills pull-right">
			<li class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown" href="#"><i class="icon-user"></i> 管理员 <b class="caret"></b>
				</a>
				<ul class="dropdown-menu">
					<li><a href="OutServlet">退出</a></li>
				</ul>
			</li>
		</ul>

		<ul class="breadcrumb">
			<li>
				<span class="divider">以太坊合约大数据分析系统</span>
			</li>
		</ul>
	</div>
	
	<div class="main-area dashboard">
			
			<div class="row">
			
			</div>
			
			<div class="row">
				
				<div class="span10">
				
					<div class="slate">
					
						<div class="page-header">
							<h2>实时Tokens详细信息</h2>
						</div>
				        <div>
						<div id="shuStart" style="width:800px; height:800px;text-align: center;"></div>
								<script type="text/javascript">
									$(function() {
									
										$.ajax({
											type : 'post',
											async : false,
											url : 'bar5.do',
											data : {},
											dataType : 'json',
											success : function(result) {
											console.log(result);
												var myChart = echarts.init(document.getElementById('shuStart'));
												var option = {
														    title : {
														        text: '某个token的top100用户占有率',
														        subtext: '0x05435983b4736d18d3c56e860d607f2825dc5d64'
														    },
														    tooltip : {
														        trigger: 'item',
														        formatter: "{b}: {c}"
														    },
														    toolbox: {
														        show : true,
														        feature : {
														            mark : {show: true},
														            dataView : {show: true, readOnly: false},
														            restore : {show: true},
														            saveAsImage : {show: true}
														        }
														    },
														    calculable : false,
														    series : [
														        {
														            name:'矩形图',
														            type:'treemap',
														            itemStyle: {
														                normal: {
														                    label: {
														                        show: true,
														                        formatter: "{b}"
														                    },
														                    borderWidth: 1
														                },
														                emphasis: {
														                    label: {
														                        show: true
														                    }
														                }
														            },
														            data:result
														        }
														    ]
														};
														myChart.setOption(option);
											},
											error : function() {
												alert("错误");
											}
										});
									});   
								
								</script>				        	
				        
				        
				        </div>

					</div>
					</div>
				
				</div>
				
			
			
			
			
		<div class="row">
		
			<div class="span10 footer">
			
				<p>&copy; 以太坊合约分析</p>
			
			</div>
		
		</div>
		
	</div>
	
	</div> 
		
	</div> 
		
</div> 


</body>
</html>