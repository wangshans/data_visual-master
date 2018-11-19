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
					<a href="index.jsp"><i class="icon-home"></i> 主页</a>
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
				<span class="divider">以太坊大数据分析系统</span>
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
							<h2>实时合约信息</h2>
						</div>
						
						<table data-toggle="table" id="table" data-pagination="true">
				        <thead>
				            <tr>
				                <th data-field="id">合约ID</th>
				                <th data-field="ddate">合约时间</th>
				                
				            </tr>
				        </thead>
				        <div>
				        </div>
				    </table>

					</div>
					</div>
				
				</div>
				
			
			
			
			
		<div class="row">
		
			<div class="span10 footer">
			
				<p>&copy; 以太坊大数据挖掘</p>
			
			</div>
		
		</div>
		
	</div>
	
	</div> 
		
	</div> 
		
</div> 
<div style="display" id="p"></div> 

<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/bootstrap.js"></script>
<script src="assets/js/bootstrap-table.js"></script>
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