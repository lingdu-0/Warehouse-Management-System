<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<meta http-equiv="Pragma" content="no-cache"> 
<meta http-equiv="Cache-Control" content="no-cache"> 
<meta http-equiv="Expires" content="0"> 
<title>仓储管理系统</title>
<link href="css/login.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="login_box">
      <div class="login_l_img"><img src="images/login-img.png" /></div>
      <div class="login">
          <div class="login_logo"><a href="#"><img src="images/login_logo.png" /></a></div>
          <div class="login_name">
               <p>仓储管理系统</p>
          </div>
          <form action="UserServlet" method="post">
              <input name="uname" id="uname" type="text"  value="用户名" onfocus="this.value=''" onblur="if(this.value==''){this.value='用户名'}" class="login_input">
               <span id="password_text" onclick="this.style.display='none';document.getElementById('password').style.display='block';document.getElementById('password').focus().select();" >密码</span>
              <input name="upwd" type="password" id="password" style="display:none;" onblur="if(this.value==''){document.getElementById('password_text').style.display='block';this.style.display='none'};"/>
              <input type="hidden" name="flag" value="login">
              <input value="登录" style="width:100%;" type="submit" class="login_sub">
              <label id="error" style="color:red">${requestScope.mess}</label>
          </form>
      </div>
</div>
<div style="text-align:center;">
<p>五男一女组<a href="#" target="_blank"></a></p>
</div>
</body>
</html>
