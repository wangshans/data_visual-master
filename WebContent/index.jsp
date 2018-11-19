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
    <title>以太坊大数据分析系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    
    <script src="assets/js/echarts-all.js"></script>
	<script src="assets/js/jquery.js"></script>
   
    <link href="http://fonts.googleapis.com/css?family=Oxygen|Marck+Script" rel="stylesheet" type="text/css">
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <link href="assets/css/font-awesome.css" rel="stylesheet">
    <link href="assets/css/admin.css" rel="stylesheet">
    <link href="assets/css/bootstrap-table.css" rel="stylesheet">
 

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
						<li><a href="gxlisting.jsp">雷达图</a></li>
						<li><a href="shulisting.jsp">矩形数据图</a></li>
						<li><a href="show1listing.jsp">昨日交易量TOP</a></li>
						<li><a href="show2listing.jsp">总交易量TOP</a></li>
						<li><a href="show3listing.jsp">昨日交易额TOP</a></li>
						<li><a href="show4listing.jsp">总交易额TOP</a></li>
						<li><a href="show5listing.jsp">创建合约数量TOP</a></li>
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
				<span class="divider">以太坊大数据分析系统</span>
			</li>
		</ul>
		
	</div>
	
	<div class="main-area dashboard">

		<div class="row">
		
			<div class="span10">
			
				<div class="slate clearfix">
				
				
					<div class="stat-column" href="#">
						
						<span class="number"><script type="text/javascript">
						$.ajax({
							type : 'post',	
							async : false,	
							url : 'bar.do',
							data : {},
							dataType : 'json', 
							success : function(result) {
											document.write(result[result.length-1].num);
							},
							error : function(errorMsg) {
								alert("加载数据失败");
							}
						});
						</script></span>
						<span>本日合约统计</span>
						
					</div>
					
					<div class="stat-column" href="#">
						<span class="number">
						<script type="text/javascript">
						var d=new Date();
						$.ajax({
							type : 'post',	
							async : false,	
							url : 'bar.do',
							data : {},
							dataType : 'json', 
							success : function(result) {
								var sum=0;
								for(var i=0;i<d.getDate();i++){
									sum=sum+result[result.length-1-i].num;
								}
								document.write(sum);
							},
							error : function(errorMsg) {
								alert("加载数据失败");
							}
						});
						</script>
						</span>
						<span>本月合约统计</span>
						
					</div>

					<div class="stat-column" href="#">
						<span class="number">
						<script type="text/javascript">
						var d2=Math.ceil(( new Date() - new Date(new Date().getFullYear().toString()))/(24*60*60*1000))+1;
						$.ajax({
							type : 'post',	
							async : false,	
							url : 'bar.do',
							data : {},
							dataType : 'json', 
							success : function(result) {
								var sum1=0;
								for(var i=0;i<d2;i++){
									sum1=sum1+result[result.length-1-i].num;
								}
								document.write(sum1);
							},
							error : function(errorMsg) {
								alert("加载数据失败");
							}
						});
						</script>
						</span>
						<span>本年合约统计</span>
						
					</div>

				
				</div>
			
			</div>
		
		</div>
		
		<div class="row">
		
			<div class="span5">
			
				<div class="slate">
				
					<div class="page-header">
						<h2><i class="icon-signal pull-right"></i>最近七天合约数量</h2>
					</div>
						<div id="myBarDiv" style="height: 300px; width: 430px;display:inline-block" ></div>
	
				
				</div>
			
			</div>
		
			<div class="span5">
			
				<div class="slate">
				
					<div class="page-header">
						<h2></i>实时合约信息</h2>
					</div>
					
					<table data-toggle="table" id="table" data-pagination="true">
				        <thead>
				            <tr>
				                <th data-field="id">合约ID</th>
				                <th data-field="ddate">合约生成时间</th>
				            </tr>
				        </thead>
				    </table>
				   <table style="float:right" >
					<tr>
							<td colspan="2"><a href="listing.jsp" class="label label-warning">查看更多</a></td>
					</tr>
					</table>
			
			</div>
		
		</div>
		
		
		</div>
		
		<div class="row">
		
			<div class="span10 footer">
			
				<p>&copy; 以太坊数据挖掘</p>
			
			</div>
		
		</div>
		
	</div>
	
	</div> 
		
	</div> 
		
</div> 


<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/bootstrap.js"></script>
<script src="assets/js/excanvas.min.js"></script>
<script src="assets/js/jquery.flot.min.js"></script>
<script src="assets/js/jquery.flot.resize.js"></script>
<script src="assets/js/bootstrap-table2.js"></script>
<script type="text/javascript">
	function sub(){ 
		var j = {"name":$("#myName").val(),"num":$("#myNum").val()};
		$.ajax({
	        type: 'post',
	        url: 'jso.do',
	        dataType: 'json',
	        data: {"name":$("#myName").val(),"num":$("#myNum").val()},  
	        contentType:"application/x-www-form-urlencoded",
	        success: function (message) {
	        	alert("success");
	        }
	       
	    });
		window.location.reload();
	}
	</script>

		<script type="text/javascript">
	
		function loadData(option) {
			$.ajax({
				type : 'post',	
				async : false,	
				url : 'bar.do',	
				data : {},
				dataType : 'json', 
				success : function(result) {
					if (result) {
						option.xAxis[0].data = [];
						option.series[0].data = [];
						for (var i=0; i<7; i++) {
							option.xAxis[0].data.push(result[result.length-7+i].name);
							option.series[0].data.push(result[result.length-7+i].num);
						}
						
					}
				},
				error : function(errorMsg) {
					alert("加载数据失败");
				}
			});
		}
		
		var myChart = echarts.init(document.getElementById('myBarDiv'));
		var option = {
			tooltip : {
				show : true
			},
			
			xAxis : [ {
				type : 'category'
				
			} ],
			yAxis : [ {
				type : 'value'
			} ],
			series : [ {
				name : '访问量',
				type : 'bar'
			} ]
		};
		
		loadData(option);
		
		myChart.setOption(option);
	</script>

 <script type="text/javascript">
        $(function () {
            $.ajax({
                type : 'post',  
                async : false,  
                url : 'bar2.do',
                data : {},
                dataType : 'json', 
                success: function (result) {
                    $("#table").bootstrapTable('load', result);
                },
                error: function () {
                    alert("错误");
                }
            });
        });
    </script>

</body>
</html>