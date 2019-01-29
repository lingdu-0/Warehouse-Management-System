<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>仓储管理系统</title>

<link href="../jqgrid/css/ui.jqgrid-bootstrap.min.css" rel="stylesheet" />
<link href="../jqgrid/css/bootstrap.min.css" rel="stylesheet"/>

<script type="text/javascript" charset="utf-8"src="../jqgrid/js/jquery-3.0.0.min.js"></script>	
<script type="text/javascript" charset="utf-8"src="../jqgrid/js/jquery.jqGrid.min.js"></script>
<script type="text/javascript" charset="utf-8"src="../jqgrid/js/grid.locale-cn.min.js"></script>
<script type="text/javascript" charset="utf-8"src="../jqgrid/js/layer/layer.min.js"></script>
<script type="text/javascript" charset="utf-8"src="../jqgrid/js/layer/extend/layer.ext.min.js"></script>
<script type="text/javascript" charset="utf-8" src="../jqgrid/js/form.min.js"></script>
<script>

	$(function() {
		loadGrid();
	}); 
	//装载表格
	function loadGrid() {
		 $("#grid").jqGrid(
				{ 
					height : 800,
					rownumbers : true,
					colModel : [
							{
								label : '物料编号',
								 name : 'material_id',
								index : 'material_id', 
								sortable : false,
								width : 40
							},
							{
								label : '物料名称',
								 name : 'material_name',
								index : 'material_name', 
								sortable : false,
								width : 40
							},
							{
								label : '类别',
								 name : 'c_name',
								index : 'c_name', 
								sortable : false,
								width : 40
							},
							{
								label : '物料信息',
								 name : 'information',
								index : 'information', 
								sortable : false,
								width : 60
							},
							{
								label : '物料数量',
								 name : 'number',
								index : 'number', 
								sortable : false,
								width : 40
							},
							{
								label : '物料单价',
								 name : 'price',
								index : 'price', 
								sortable : false,
								width : 40
							},
							{
								label : '修改信息',
								 name : 'load',
								index : 'load', 
								sortable : false,
								width : 60
							},
							{
								label : '删除信息',
								 name : 'delete',
								index : 'delete', 
								sortable : false,
								width : 60
							}
								]	
				});
		 
    var rows = [  
    	 <c:forEach items="${sessionScope.materialList}" var="material">
    			{"mid":" ${material.mid}","material_id":" ${material.material_id} ","material_name":"${material.material_name}","c_name":" ${material.c_name}","information":"${material.information}","number":"${material.number}","price":"${material.price}","load":"<a href='../MaterialServlet?mid=${material.mid}&flag=load' class='mesq'>修改信息</a>","delete":"<a href='../MaterialServlet?mid=${material.mid}&flag=delete' class='mesq'>删除信息</a>"},
    			
    			</c:forEach>
    			];
			for(var i = 0; i < rows.length; i++) {
				$("#grid").jqGrid('addRowData', i + 1, rows[i]);
			} 
	}
	
	//窗口变化时自适应宽度
	window.onresize = function() {
		$("#grid").setGridWidth(document.body.clientWidth - 12);
	}
</script>
</head>  
<body>
<script src="/demos/googlegg.js"></script>
<style>
.in{height:30px;border-radius:4px;}
.getS{background:#69Ea7c;color:#fff;padding:5px;padding-left:20px;padding-right:20px;border-radius:4px;}
.getS:HOVER{background:#49D44d;cursor:pointer;}
.mesd{color:#C12E2A}
.mesq{color:#4CAE4C}
</style>
<div style="padding-Top:5px;background:#ddd; height:40px">
    <form action="../MaterialServlet?flag=check" method="post">
    <label style="margin-left:45px">物料名称：</label> 
     <input name="material_name" id="material_name" type="text" class="in" placeholder="  查询信息" />
	      <input name="flag" type="hidden" value="check" />
	      <input name="material_name" type="hidden" value="${sessionScope.material.material_name}" />
	      <input type="submit" value="查询" class="getS" />
	      <input value="添加物料" type="button" onclick="window.location='material_add.jsp'"class="getS">
	</form>	 	
 </div>

<div class="row">
	<div class="col-sm-12" style="background:#eee">
		<table id="grid" style="background:#eff"></table>
		<div id="pager" style="height:35px;"></div>
	</div>
</div>
<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">
</div>
</body>
</html>