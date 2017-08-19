<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html><head><meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
</head>
<body>
	<div class="main">
		<div class="optitle clearfix">
			<div class="title">用户管理&gt;&gt;</div>
		</div>
			<div class="content">
				<table class="box"> 
					<tbody><tr>
						<td class="field">用户编号：</td>
						<td>${result.id}</td>
						
					</tr>
					<tr>
						<td class="field">用户名：</td>
						<td>${result.username}</td>
					</tr>
					<tr>
						<td class="field">用户账号：</td>
						<td>${result.usercode}</td>
					</tr>

					<tr>
						<td class="field">用户性别：</td>
						<td>
							${result.gender==2?"男":"女"}
						</td>
					</tr>
					<tr>
						<td class="field">出生日期：</td>
						<td><f:formatDate value="${result.birthday}" pattern="yyyy-MM-dd"/>
						</td>
					</tr>
					<tr>
						<td class="field">用户电话：</td>
						<td>${result.phone}
						</td>

					</tr>
					<tr>
						<td class="field">用户地址：</td>
						<td>${result.address}
						</td>
					</tr>
					<tr>
						<td class="field">用户权限：</td>
						<td>
							${result.userrole==1?"系统管理员":result.userrole==2?"经理":"普通员工"}
						</td>
					</tr>
				</tbody></table>
			</div>
			<div class="buttons">
				<input type="button" id="update" value="修改" onclick="window.location.href='${pageContext.request.contextPath}/user/toUpdate/${result.id}'" class="input-button">				
				<form class="delForm" action="${pageContext.request.contextPath }/user/userRest/${result.id}" method="post">
					<input type="hidden" name="_method" value="delete">
					<input type="submit" id="del" value="删除" class="input-button">${delresult.msg} 
				</form>
				<input type="button" id="repassword" value="重置密码" class="input-button"> 
				<input type="button" id="backButton" onclick="history.back(-1)" value="返回" class="input-button">
			</div>
	</div>
</body></html>