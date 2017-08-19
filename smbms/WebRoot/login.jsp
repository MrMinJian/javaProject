<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>系统登录 - 超市账单管理系统</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript">
	$(function(){
		$(".submiton").on("click",function(){
			var usercode = $(":text").val();
			var userpassword = $(":password").val();
			$.getJSON("user/login.do",{"usercode":usercode,"userpassword":userpassword},function(rd){
				if(rd!=null){
					if(rd.flag==1){
						window.location.href="frame.jsp";
					}else{
						$("#loginNameSpan").html(rd.msg);
					}					
				}				
			});
		});
	});
</script>
</head>
<body class="blue-style">
<div id="login">
	<div class="icon"></div>
	<div class="login-box">
		<form  action="user/login"  name="actionForm" id="actionForm"  method="post" >
			<dl>
				<dt>用户名：</dt>
				<dd><input type="text" class="input-text" name="usercode"/> <span id="loginNameSpan"></span></dd>
				<dt>密　码：</dt>
				<dd><input type="password" class="input-text" name="userpassword"/><span id="passwordSpan"></span></dd>
			</dl>
			<div class="buttons">
				<input type="button"   value="登录系统" class="input-button submiton" />
				<input type="reset"  value="重　　填" class="input-button" />
			</div>
		</form>
	</div>
</div>
</body>
</html>
