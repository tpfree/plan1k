<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>人才在线申报系统</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="人才在线申报系统">
<meta http-equiv="description" content="人才在线申报系统">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/register.css">
<script type="text/javascript" src="<%=basePath%>styles/dwz/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	
});
function confirm(){
	var userName=$("[name=username]").val();
	var password=$("[name=password]").val();
	var confirmPassword=$("[name=confirmPassword]").val();
	var phone=$("[name=phone]").val();
	var email=$("[name=email]").val();
	var tip;
	$(".tip").css("cssText","display:none !important");
	if(typeof(userName)=="undefined"||userName==""){
		tip=$("[name=username]").parent().find(".tip");
		tip.css("cssText","display:inline-block !important");
		tip.text("不能为空");
		return false;
	}
	if(typeof(password)=="undefined"||password==""){
		tip=$("[name=password]").parent().find(".tip");
		tip.css("cssText","display:inline-block !important");
		tip.text("不能为空");
		return false;
	}
	if(typeof(confirmPassword)=="undefined"||confirmPassword==""){
		tip=$("[name=confirmPassword]").parent().find(".tip");
		tip.css("cssText","display:inline-block !important");
		tip.text("不能为空");
		return false;
	}
	if(confirmPassword!=password){
		tip=$("[name=confirmPassword]").parent().find(".tip");
		tip.css("cssText","display:inline-block !important");
		tip.text("密码不一致");
		return false;
	}
	
	if(!(/^1[34578]\d{9}$/.test(phone))){ 
		tip=$("[name=phone]").parent().find(".tip");
		tip.text("号码错误");
		tip.css("cssText","display:inline-block !important");
        return false; 
    }
	
	var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	if(!myreg.test(email))
	{
		tip=$("[name=email]").parent().find(".tip");
		tip.text("邮箱错误");
		tip.show();
	 	return false;
	}
	return true;
}
</script>
</head>

<body>
	<div id="main">
		<div id="header">
			<span>人才在线申报系统</span>
		</div>
		<div id="registerFrom">
			<form id="register" action="userController.do?reg" method="POST" onSubmit="return confirm();">
				<ul>
					<li>
						<span>用户注册</span> 
					</li>
					<li>
					</li>
					<li>
						<span>用户名:</span> 
						<input name="username" type="text" placeholder="请输入用户名"></input>
						<span class="tip">fdsf</span>
					</li>
					<li>
						<span>密码:</span> 
						<input name="password" type="password" placeholder="请输入密码"></input>
						<span class="tip">fds</span>
					</li>
					<li>
						<span>确认密码:</span> 
						<input name="confirmPassword" type="password" placeholder="确认密码"></input>
						<span class="tip">fds</span>
					</li>
					<li>
						<span>手机号码:</span> 
						<input name="phone" type="text" placeholder="请输入电话号码"></input>
						<span class="tip">fds</span>
					</li>
					<li>
						<span>邮箱:</span> 
						<input name="email" type="text" placeholder="请输入邮箱"></input>
						<span class="tip">fds</span>
					</li>
					<li>
						<span>主管单位:</span> 
						<select name="unitCode">
						<option value="">-请选择-</option>
						<c:forEach var="item" items="${unitList}">
						<option value="${item.id }">${item.name }</option>
						</c:forEach>
					</select>
						<span class="tip">fds</span>
					</li>
					<c:if test="${not empty errorText}"><li id="error" style="diplay:block;"><span id="errorText"
						style="width:300px;display:inline-block;color:#ff0000;text-align: center;">${errorText}</span>
					</li>
					</c:if>
					<li>
						<input name="registerBtn" id="registerBtn" type="submit" value="注&nbsp&nbsp册"></input>
					</li>
				</ul>
			</form>
		</div>
	</div>
</body>
</html>
