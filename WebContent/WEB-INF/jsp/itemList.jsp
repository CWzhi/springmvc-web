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
<form action="${pageContext.request.contextPath }/queryitem.action" method="post">
查询条件：
<table width="100%" border=1>
<tr>
<tr>
<td>商品id<input type="text" name="item.id" /></td>
<td>商品名称<input type="text" name="item.name" /></td>
<td><input type="submit" value="查询"/></td>
</tr>
</tr>
</table>
商品列表：
<table width="100%" border=1>
<tr>
	<!-- 复选框 -->
	<td>选择框</td>
	<!-- <td>商品ID</td> -->
	<td>商品名称</td>
	<td>商品价格</td>
	<td>生产日期</td>
	<td>商品描述</td>
	<td>操作</td>
</tr>
<%-- <c:forEach items="${itemList }" var="item">
<tr>
	<td><input type="checkbox" name="ids" value="${item.id}"/></td>
	<td>${item.id }</td>
	<td>
	<input  value="${item.name }">
	 ${item.name } 
	</td>
	<td>${item.price }</td>
	<td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	<td>${item.detail }</td>
	
	<td><a href="${pageContext.request.contextPath }/itemEdit.action?id=${item.id}">修改</a></td>
								<!-- 获取项目根路径   springmvc-web -->
</tr>
</c:forEach>  --%>

<!-- itemList[${s.index}].price        
		解释:先获取集合里面的对象,在获得对象里面的属性 -->
		
<!--  下面的用来提交表单对象,提交多条对象,到后台,后台用list集合来接收List<对象> list  
									这个list对象作为VO里面的一个属性
									vo作为这个这个方法的参数来接收
									数据直接封装到list集合属性中
			但是提交的这个input框 的name值为list.索引.属性作为name
									
		-->		

 <c:forEach items="${itemList }" var="item" varStatus="s">
<tr>
	<td><input type="checkbox" name="ids" value="${item.id}"/></td>
	<td>
		<input type="hidden" name="itemList[${s.index}].id" value="${item.id }"/>
		<input type="text" name="itemList[${s.index}].name" value="${item.name }"/>
	</td>
	<td><input type="text" name="itemList[${s.index}].price" value="${item.price }"/></td>
	<td><input type="text" name="itemList[${s.index}].createtime" value="<fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/></td>
	<td><input type="text" name="itemList[${s.index}].detail" value="${item.detail }"/></td>
	
	<td><a href="${pageContext.request.contextPath }/item/itemEdit.action?id=${item.id}">修改</a></td>

</tr>
</c:forEach> 


</table>
</form>
</body>

</html>