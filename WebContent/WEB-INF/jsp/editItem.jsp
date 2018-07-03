<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改商品信息</title>

<!-- 引入jquery -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
<!-- //页面刚进来的情况下,加载一段程序   -->
	$(function() {
		/*写一个ajax */
		//alert(1);
		/* var jsonSendParam = {//这是json格式的js对象 不是字符串   map形式的对象 (大括号包起来是一个map)
			"id" : 1,
			"name" : "测试商品",
			"price" : 99.9,
			"detail" : "测试商品描述",
			"pic" : "123456.jpg"
		}; */
		//我们要发送json字符串    要发送的是一个字符串
		//格式是json格式,类型是字符串
		var param = '{"id" : 1,"name" : "测试商品","price" : 99.9,"detail" : "测试商品描述","pic" : "123456.jpg"}';
		//json对象
		//var param = {"id" : 1,"name" : "测试商品","price" : 99.9,"detail" : "测试商品描述","pic" : "123456.jpg"};
		
		//$.post不能发送json格式,只能发送字符串,即不能定义param的数据类型,只能接收json数据,只能定义返回的数据类型
		
		/* ${pageContext.request.contextPath} 获取项目名称 */
		$.ajax({
			url:"${pageContext.request.contextPath }/json.action",
			data:param,
			contentType:"application/json;charset=UTF-8",//发送数据的内容类型为json类型(将要转成json类型的json格式的字符串)   要是$.post方式的话,加了单引号就只能是字符串了,不能是别的了,(即不能是json类型的字符串了)
			type:"post",
			dataType:"text",//回调的数据类型是json类型
			success:function(data){//回调函数  data为回调数据
				//前端返回的是data这个串:即param   可以通过对象调用属性来取值
				//alert(data.name);
				var data1 = JSON.parse(data);
				alert(data1);
				//alert(console.log(typeof data));  
				alert( data);  
                for(var i= 0;i<data.length;i++){  
                	alert( console.log(data[i].name));  
                } 
				
			}
			
		});
		/* $.post(url,param,function(data){
		//回调时,对返回的数据进行逻辑编写
	},"json")//这个json是返回的数据格式,是data的数据格式. */
	});
</script>

</head>
<body>
	<!-- 上传图片是需要指定属性 enctype="multipart/form-data" -->
	<!-- <form id="itemForm" action="" method="post" enctype="multipart/form-data"> -->
	<form id="itemForm"
		action="${pageContext.request.contextPath }/item/updateitem.action"
		method="post" enctype="multipart/form-data">
		<input type="hidden" name="items.id" value="${item.id }" /> 修改商品信息：
		<table width="100%" border=1>
			<tr>
				<td>商品名称</td>
				<td><input type="text" name="items.name" value="${item.name }" /></td>
			</tr>
			<tr>
				<td>商品价格</td>
				<td><input type="text" name="items.price"
					value="${item.price }" /></td>
			</tr>

			<tr>
				<td>商品生产日期</td>
				<td><input type="text" name="items.createtime"
					value="<fmt:formatDate value="${ item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>" /></td>
			</tr>
			<tr>
				<td>商品图片</td>
				<td><c:if test="${item.pic !=null}">
						<img name="items.pic" src="/upload/${item.pic}" width=100
							height=100 />
						<br />
					</c:if> <input type="file" name="pictureFile" /></td>
			</tr>

			<tr>
				<td>商品简介</td>
				<td><textarea rows="3" cols="30" name="items.detail">${ item.detail }</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="提交" />
				</td>
			</tr>
		</table>

	</form>
</body>

</html>