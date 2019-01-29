<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>物料修改</title>
<script src="../js/jquery-1.7.2.min.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body><script src="/demos/googlegg.js"></script> 
<div class="user_mesg">
<form action="../MaterialServlet" method="post" onsubmit="return check()" class="fl">
		<div class="quick_liuyan_con">
			<div class="item">
				<span>物料编号：</span>
				<div class="item-right">
					<input type="text" value="${sessionScope.material.material_id}" name="material_id" id="material_id"/>
				</div>
				<div style="clear: both"></div>
			</div>
			<div class="item">
				<span>物料名称：</span>
				<div class="item-right">
					<input type="text" value="${sessionScope.material.material_name}" name="material_name" id="material_name"/>
				</div>
				<div style="clear: both"></div>
			</div>
			<div class="item">
				<span>物料类别：</span>
				<div class="item-right">
					<input type="text" value="${sessionScope.material.c_name}" name="c_name" id="c_name"/>
				</div>
				<div style="clear: both"></div>
			</div>
			<div class="item">
				<span>物料数量：</span>
				<div class="item-right">
					<input type="text" value="${sessionScope.material.number}" name="number" id="number"/>
				</div>
				<div style="clear: both"></div>
			</div>
			<div class="item">
				<span>物料单价：</span>
				<div class="item-right">
					<input type="text" value="${sessionScope.material.price}" name="price" id="price"/>
				</div>
				<div style="clear: both"></div>
			</div>
			<div class="item">
				<span>物料信息：</span>
				<div class="item-right">
					<textarea name="information" id="information"class="Message" cols="30" rows="10">${sessionScope.material.information}</textarea>
				</div>
				<div style="clear: both"></div>
			</div>
			<div class="item">
				<input name="flag" type="hidden" value="update" />
				<input name="mid" type="hidden" value="${sessionScope.material.mid}" />
				<input type="submit" value="确认修改" class="btn-mesSubmit"/>
			</div>
			<div class="item">
			<input value="返回首页" type="button" onclick="window.location='interface.jsp'"class="btn-mesSubmit">
			</div>
		</div>
	</form>
</div>
<script src="../js/script.js" type="text/javascript"></script>
<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</div>
</body>
</html>
<%
	//清除编辑页面和添加页面数据的影响
	session.removeAttribute("mid");
	session.removeAttribute("material_name");
%>