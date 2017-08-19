<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html><head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>超市账单管理系统-账单管理</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

</head>
<body>

	<div class="menu">

		<table>
			<tbody>
				<tr>
					<td><form method="post" action="bill.do">
							<input name="method" value="query" class="input-text" type="hidden"> 
							商品名称：<input name="productName" class="input-text" type="text" value="">
							供应商名称：<input name="proName" class="input-text" type="text" value="">
							
							是否付款：<input type="radio" name="payed" value="1">是<input type="radio" name="payed" value="0">否
							<input value="查 询" type="submit">
						</form>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="main">

		<div class="optitle clearfix">
			<em><input value="添加账单" class="input-button" onclick="window.location='${pageContext.request.contextPath}/billAdd.jsp'" type="button">
			</em>
			<div class="title">账单管理&gt;&gt;</div>
		</div>
		<div class="content">
			<table class="list">
				<tbody>
					<tr>
						<td width="70" height="29"><div class="STYLE1" align="center">编号</div>
						</td>
						<td width="80"><div class="STYLE1" align="center">商品名称</div>
						</td>
						<td width="80"><div class="STYLE1" align="center">供应商</div>
						</td>
						<td width="100"><div class="STYLE1" align="center">账单金额</div>
						</td>
						<td width="100"><div class="STYLE1" align="center">是否付款</div>
						</td>
						<td width="100"><div class="STYLE1" align="center">操作时间</div>
						</td>
					</tr>
					<c:forEach items="${bList}" var="bill">
					<tr>
						<td height="23"><span class="STYLE1">${bill.id}</span>
						</td>
						<td><span class="STYLE1"><a href="billRest/${bill.id}" style="color:red" >${bill.productname}</a>
						</span>
						</td>
						<td><span class="STYLE1">${bill.providerid}</span>
						</td>
						<td><span class="STYLE1">${bill.totalprice}</span>
						</td>
						<td><span class="STYLE1">${bill.ispayment==1?"是":"否"}</span>
						</td>
						<td><span class="STYLE1"><f:formatDate value="${bill.creationdate}" pattern="yyyy-MM-dd"/></span>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body></html>