<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="calendar/WdatePicker.js"></script>
</head>
<body>
<div class="main">
	<div class="optitle clearfix">
		<div class="title">用户管理&gt;&gt;</div>

	</div>
	<form id="form1" name="form1" method="post" action="user/userRest">
		<input type="hidden" name="method" value="add">
		<div class="content">
			<table class="box">
			   <tbody><tr>
					<td class="field">用户名：</td>
					<td><input type="text" name="username" class="text" id="name" value=""> <font color="red">*</font><font color="red" id="name_span">${result.msg}</font></td>
				</tr>
				 <tr>
					<td class="field">用户账号：</td>
					<td><input type="text" name="usercode" class="text" id="loginName" value=""> <font color="red">*</font><font color="red" id="loginName_span"></font></td>
				</tr>
				 <tr>
					<td class="field">用户密码：</td>
					<td><input type="password" name="userpassword" class="text" id="password" value=""> <font color="red">*</font><font color="red" id="password_span"></font></td>
				</tr>
				 <tr>
					<td class="field">确认密码：</td>
					<td><input type="password" name="rpassword" class="text" id="rpassword" value=""> <font color="red">*</font></td>
				</tr>
				<tr>
					<td class="field">用户性别：</td>
					<td><select name="gender" id="gender">
						    <option value="2" checked="">男</option>
						    <option value="1">女</option>
						 </select></td>
				</tr>
				<tr>
					<td class="field">出生日期：</td>
					<td><input type="text" name="birthday" onfocus="WdatePicker()" class="text" id="birthDate" value=""> <font color="red">*</font><font color="red" id="birthDate_span"></font></td>
				</tr>
				<tr>
					<td class="field">用户电话：</td>
					<td><input type="text" name="phone" class="text" id="phone" value=""> <font color="red">*</font><font color="red" id="phone_span"></font></td>

				</tr>
				<tr>
					<td class="field">用户地址：</td>
					<td><input name="address" id="address" class="text" value=""></td>
				</tr>
				<tr>
					<td class="field">用户权限：</td>

					<td><input type="radio" name="userrole" value="1">管理员<input type="radio" name="userrole" value="2" checked="true">经理
					<input type="radio" name="userrole" value="3">普通用户</td>
				</tr>
			</tbody></table>
		</div>
		<div class="buttons">
			<input type="submit" name="add" id="add" value="保存" class="input-button">
			<input type="button" name="button" id="button" onclick="history.back(-1)" value="返回" class="input-button"> 
		</div>

	</form>
</div>
</body></html>