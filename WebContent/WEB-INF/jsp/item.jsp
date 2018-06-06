<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
</head>
<body> 
<form  id="form" action="${pageContext.request.contextPath }/updateItem.action" method="post" >

<table width="100%" border=1>
<tr>
<td><input type="submit" value="查询"/></td>
</tr>
</table>
商品列表：
<table width="100%" border=1>
<tr>
	<td>商品名称</td>
	<td>商品价格</td>
	<td>生产日期</td>
	<td>商品描述</td>
	<td>操作</td>
</tr>
<%-- <c:forEach items="${itemList }" var="item"> --%>

<tr>
	<input name = "id" value="${item.id }" style="display:none" >
	<td><input name = "name" value="${item.name }"></td>
	<td><input name = "price" value="${item.price }"></td>
	<td><input name = "createtime" value='<fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>'></td>
	<td><input name = "detail" value="${item.detail }"></td>
	
	<td><input type="submit" method="post"  value="修改"></td>
								<!-- 获取项目根路径   springmvc-web -->
</tr>
<%-- </c:forEach> --%>

</table>
</form>
</body>

</html>