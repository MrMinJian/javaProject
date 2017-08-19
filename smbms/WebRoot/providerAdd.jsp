<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
</head>
<body>
<div class="main">
	<div class="optitle clearfix">
		<div class="title">供应商管理&gt;&gt;${addResult.msg}</div>
	</div>
	<form id="form1" name="form1" method="post" action="provider/providerRest">
		<div class="content">
			<table class="box">
			   <tbody><tr>
					<td class="field">供应商名称：</td>
					<td><input type="text" name="proname" class="text" id="proName" value=""> <font color="red">*</font><font color="red" id="proName_span"></font></td>
				</tr>
				 <tr>
					<td class="field">联系人：</td>
					<td><input type="text" name="procontact" class="text" id="proContact" value=""> <font color="red">*</font><font color="red" id="proContact_span"></font></td>
				</tr>
				<tr>
					<td class="field">联系电话：</td>
					<td><input type="text" name="prophone" class="text" id="proPhone" value=""> <font color="red">*</font><font color="red" id="proPhone_span"></font></td>
				</tr>
				<tr>
					<td class="field">联系地址：</td>
					<td><input name="proaddress" id="proAddress" class="text" value=""></td>
				</tr>
			   <tr>
					<td class="field">传真：</td>
					<td><input type="text" name="profax" class="text" id="proFax" value=""> </td>

				</tr>
				 <tr>
					<td class="field">描述：</td>
					<td><input type="text" name="prodesc" class="text" id="proDesc" value=""> </td>

				</tr>
			</tbody></table>
		</div>
		<div class="buttons">
			<input type="submit" name="add" id="add" value="保存" class="input-button">
			<input type="button" name="button" id="button" onclick="history.back(-1)" value="返回" class="input-button"> 
		</div>

	</form>
</div>
<script type="text/javascript" src="js/provider/add.js"></script>


</body></html>