<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>人才在线申报系统</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="人才在线申报系统">
<meta http-equiv="description" content="人才在线申报系统">
<link rel="stylesheet" type="text/css" href="<c:url value='css/login.css' />">
<script type="text/javascript" src="<c:url value='styles/dwz/js/jquery-1.7.2.js'/>"></script>
<script type="text/javascript">
$(document).ready(function() {
	document.onkeydown = function(e){
        if(!e) e = window.event;//火狐中是 window.event
        if((e.keyCode || e.which) == 13){
        	$("#login").submit();
        }
    }
	$("#validateCode").click(function(){
		$("#validateCode").attr("src","userController.do?validateCode&a＝"+Math.random());
	});
	$("#registerBtn").click(function(){
		window.location.href="userController.do?toReg";
	});
});
function confirm(){
	var userName=$("[name=username]").val();
	var password=$("[name=password]").val();
	var validateCode=$("[name=validateCode]").val();
	if(typeof(userName)=="undefined"||userName==""){
		return false;
	}
	if(typeof(password)=="undefined"||password==""){
		return false;
	}
	if(typeof(validateCode)=="undefined"||validateCode==""){
		return false;
	}
	return true;
};
</script>
</head>

<body>
	<div id="main">
		<div id="header">
			<span>人才在线申报系统</span>
		</div>
		<div id="loginFrom">
			<form id="login" method="post" action="userController.do?login"  onSubmit="return confirm();">
				<img src="images/left.png" />
				<ul>
					<li>
						<span>用户登录</span> 
					</li>
					<li>
						<span>用户名：</span> 
						<input name="username" type="text" placeholder="请输入用户名"></input>
					</li>
					<li>
						<span>密码：</span> 
						<input name="password" type="password" placeholder="请输入密码"></input>
					</li>
					<li>
						<span>验证码：</span> 
						<input name="validateCode" type="text" placeholder="请输入验证码"></input>
						<img id="validateCode" alt="验证码" src="userController.do?validateCode" />
					</li>
					<c:if test="${not empty errorText}"><li id="error" style="diplay:block;"><span id="errorText"
						style="width:300px;display:inline-block;color:#ff0000;text-align: center;">${errorText}</span>
					</li></c:if>
					<li>
						<input name="loginBtn" id="loginBtn" type="submit" value="登&nbsp&nbsp录" style="width:148px;"></input>
						<input name="registerBtn" id="registerBtn" type="button" value="注&nbsp&nbsp册" style="width:148px;"></input>
					</li>
				</ul>
			</form>
		</div>
	</div>
</body>
</html>
