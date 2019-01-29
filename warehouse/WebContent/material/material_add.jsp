<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>物料添加</title>
<script src="../js/jquery-1.7.2.min.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body><script src="/demos/googlegg.js"></script>
<div class="user_mesg">
<form action="../MaterialServlet?flag=add" method="post" enctype="multipart/form-data" id="msgform" class="fl">
		<div class="quick_liuyan_con">
			<div class="item">
				<span>物料编号：</span>
				<div class="item-right">
					<input type="text" value="" name="material_id" id="material_id">
				</div>
				<div style="clear: both"></div>
			</div>
			<div class="item">
				<span>物料名称：</span>
				<div class="item-right">
					<input type="text" value="" name="material_name" id="material_name">
				</div>
				<div style="clear: both"></div>
			</div>
			<div class="item">
				<span>物料类别：</span>
				<div class="item-right">
					<input type="text" value="" name="c_name" id="c_name">
				</div>
				<div style="clear: both"></div>
			</div>
			<div class="item">
				<span>物料数量：</span>
				<div class="item-right">
					<input type="text" value="" name="number" id="number">
				</div>
				<div style="clear: both"></div>
			</div>
			<div class="item">
				<span>物料单价：</span>
				<div class="item-right">
					<input type="text" value="" name="price" id="price">
				</div>
				<div style="clear: both"></div>
			</div>
			<div class="item">
				<span>物料信息：</span>
				<div class="item-right">
					<textarea name="information" id="information" class="Message" cols="30" rows="10"></textarea>
				</div>
				<div style="clear: both"></div>
			</div>
			<div class="item">
				<input type="hidden" name="flag" value="add" />
				<input type="submit" class="btn-mesSubmit" id="imgBtnUp1"  value="添加物料">
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

