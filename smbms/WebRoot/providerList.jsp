<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html><head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>超市账单管理系统-供应商管理</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<div class="menu">
		<table>
			<tbody>
				<tr>
					<td><form method="post" action="provider.do">
							<input name="method" value="query" class="input-text" type="hidden"> 供应商名称：<input name="proName" class="input-text" type="text" value="">&nbsp;&nbsp;&nbsp;&nbsp;
							<input value="查 询" type="submit">
						</form>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="main">
		<div class="optitle clearfix">
			<em><input value="添加供应商" class="input-button" onclick="window.location='${pageContext.request.contextPath}/providerAdd.jsp'" type="button">
			</em>
			<div class="title">供应商管理&gt;&gt;</div>
		</div>
		<div class="content">
			<table class="list">
				<tbody>
					<tr>
						<td width="70" height="29"><div class="STYLE1" align="center">编号</div>
						</td>
						<td width="80"><div class="STYLE1" align="center">供应商名称</div>
						</td>
						<td width="80"><div class="STYLE1" align="center">联系人</div>
						</td>
						<td width="100"><div class="STYLE1" align="center">联系电话</div>
						</td>
						<td width="100"><div class="STYLE1" align="center">传真</div>
						</td>
						<td width="100"><div class="STYLE1" align="center">操作时间</div>
						</td>
					</tr>					
					<c:forEach items="${pList}" var="provider">				
					<tr>
						<td height="23"><span class="STYLE1">${provider.id}</span>
						</td>
						<td><span class="STYLE1"><a href="providerRest/${provider.id}">${provider.proname}</a>
						</span>
						</td>
						<td><span class="STYLE1">${provider.procontact}</span>
						</td>
						<td><span class="STYLE1">${provider.prophone}</span>
						</td>
						<td><span class="STYLE1">${provider.profax}</span>
						</td>
						<td><span class="STYLE1"><f:formatDate value="${provider.creationdate}" pattern="yyyy-MM-dd"/></span>
						</td>
					</tr>					
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body></html>