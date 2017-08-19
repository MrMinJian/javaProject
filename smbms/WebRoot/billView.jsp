<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
</head>
<body>
<div class="main">
	<div class="optitle clearfix">
		<div class="title">账单管理&gt;&gt;</div>
	</div>
		<div class="content">
			<table class="box">
			  <tbody><tr>
					<td class="field">账单编号：</td>
					<td>${bill.id}</td>
				</tr>
			   <tr>
					<td class="field">商品名称：</td>
					<td>${bill.productname}</td>
				</tr>
				 <tr>
					<td class="field">商品单位：</td>
					<td>${bill.productunit}</td>
				</tr>
				<tr>
					<td class="field">商品数量：</td>
					<td>${bill.productcount}</td>
				</tr>
				<tr>
					<td class="field">总额：</td>
					<td>${bill.totalprice}</td>
				</tr>
			   <tr>
					<td class="field">供应商：</td>
					<td>${bill.providerid}</td>
				</tr>
				 <tr>
					<td class="field">是否付款：</td>
						<td>${bill.ispayment==1?"是":"否"}</td>
				</tr>
			</tbody></table>
		</div>
		<div class="buttons">
			<input type="button" name="update" id="update" value="修改" class="input-button">
			<input type="button" name="del" id="del" value="删除" class="input-button">
			<input type="button" name="button" id="button" onclick="history.back(-1)" value="返回" class="input-button"> 
		</div>

</div>
<script type="text/javascript" src="js/bill/view.js"></script>


</body></html>