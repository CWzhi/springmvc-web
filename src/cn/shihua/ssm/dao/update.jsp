<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改商品</title>
</head>
<body> 
<form action="#">
查询条件：
<table width="100%" border=1>
<tr>
<td>
<%-- <c:if test="${item }==1">
恭喜你修改成功
</c:if> --%>
<c:choose>
<c:when test="${insert==1 }">    <!-- 这里注意,不是test="${insert }==1" -->
恭喜你修改成功
</c:when>
<c:otherwise>
很遗憾修改失败
</c:otherwise>
</c:choose>

</td>
</tr>
</table>
</form>
</body>

</html>