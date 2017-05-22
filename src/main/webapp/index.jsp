<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>青海千人计划培养人才申报系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="青海千人计划培养人才申报系统">
	<meta http-equiv="description" content="青海千人计划培养人才申报系统">
	<meta http-equiv="X-UA-Compatible" content="IE=7">
	<link href="<c:url value='/styles/dwz/themes/default/style.css'/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value='/styles/dwz/themes/css/core.css'/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value='/styles/management/misc.css'/>" rel="stylesheet" type="text/css" />
	<!--[if IE]>
	<link href="<c:url value='/styles/dwz/themes/css/ieHack.css'/>" rel="stylesheet" type="text/css" />
	<![endif]-->
	<script src="<c:url value='/styles/dwz/js/speedup.js'/>" type="text/javascript"></script>
	<script src="<c:url value='/styles/dwz/js/jquery-1.7.2.js'/>" type="text/javascript"></script>
	<script src="<c:url value='/styles/dwz/js/jquery.cookie.js'/>" type="text/javascript"></script>
	<script src="<c:url value='/styles/dwz/js/jquery.validate.js'/>" type="text/javascript"></script>
	<script src="<c:url value='/styles/dwz/js/jquery.bgiframe.js'/>" type="text/javascript"></script>
	<script src="<c:url value='/styles/xheditor/xheditor-1.2.1.min.js'/>" type="text/javascript"></script>
	<script src="<c:url value='/styles/xheditor/xheditor_lang/zh-cn.js'/>" type="text/javascript"></script>
	
	<script src="<c:url value='/styles/dwz/js/dwz.min.js'/>" type="text/javascript"></script>
	<script src="<c:url value='/styles/dwz/js/dwz.regional.zh.js'/>" type="text/javascript"></script>
	<script src="<c:url value='/styles/management/misc.js'/>" type="text/javascript"></script>
	
	<script type="text/javascript">
		$(function(){
			DWZ.init("<c:url value='/styles/dwz/dwz.frag.xml'/>", {
				//loginTitle:"Login",	// 弹出登录对话框
				loginUrl:"<c:url value='/login' />",	// 跳到登录页面
				pageInfo:{pageNum:"pageNum", numPerPage:"pageSize", orderField:"orderField", orderDirection:"orderDirection"}, 
				debug:false,	// 调试模式 【true|false】
				callback:function(){
					initEnv();
					$("#themeList").theme({themeBase:"<c:url value='/styles/dwz/themes'/>"});
				}
			});
		});
	</script>
  </head>
  <body scroll="no">
  	<div id="layout">
		<div id="header">
			<div class="headerNav">
				<a class="logo" href="javascript:void(0)">Logo</a>
				<ul class="nav">
					<li><a href="<c:url value='/'/>" target="website">Home</a></li>
					<li><a href="<c:url value='/userController.do?logout'/>">退出</a></li>
				</ul>
				<ul class="themeList" id="themeList">
					<li theme="default"><div>blue</div></li>
					<li theme="green"><div>green</div></li>
					<li theme="purple"><div class="selected">purple</div></li>
					<li theme="silver"><div>silver</div></li>
					<li theme="azure"><div>天蓝</div></li>
				</ul>
			</div>
		</div>
		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse"><div></div></div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse"><h2>菜单</h2><div>collapse</div></div>
			
				<div class="accordion" fillSpace="sideBar">
					<c:forEach var="tree" items="${treeList}">  
					    <div class="accordionHeader">
							<h2><span>Folder</span>${tree.text}</h2>
						</div>
						<c:if test="${fn:length(tree.children)>0}">
							<div class="accordionContent">
								<ul class="tree treeFolder">
									<c:forEach var="childTree" items="${tree.children}">
										<li>
											<c:choose>
											   <c:when test="${not empty childTree.url}">
											   		<a href="<c:url value='${childTree.url}'/>" target="navTab" rel="${childTree.code}" > ${childTree.text} </a>    
											   </c:when>
											   <c:otherwise> 
											   		<a> ${childTree.text} </a> 
											   </c:otherwise>
											</c:choose>
											<c:if test="${fn:length(childTree.children)>0}">
												<ul>
													<c:forEach var="thirdTree" items="${childTree.children}">
															<li><c:choose>
															   <c:when test="${not empty thirdTree.url}">
															   		<a href="<c:url value='${thirdTree.url}'/>" target="navTab" rel="${thirdTree.code}" > ${thirdTree.text} </a>    
															   </c:when>
															   <c:otherwise> 
															   		<a> ${thirdTree.text} </a> 
															   </c:otherwise>
															</c:choose></li>
													</c:forEach>
												</ul>
											</c:if> 
										</li>
									</c:forEach>
								</ul>
							</div>
						</c:if> 
					</c:forEach> 
					<div class="accordionHeader">
						<h2><span>Folder</span>其它</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:void(0)"><span><span class="home_icon">首页</span></span></a></li>
						</ul>
					</div>
					<div class="tabsLeft">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:void(0)">首页</a></li>
				</ul>
				<div class="navTab-panel tabsPageContent layoutBox">
					<div>
						<div class="accountInfo">
							<%-- <c:set var="contextUser" value="${info:contextUser()}"></c:set> --%>
							<div class="right">
								<p>Today is ${nowdate}</p>
							</div>
							<p><span>Welcome: ${userName}</span></p>
						</div>
						
						<div class="pageFormContent" layoutH="80">
							<p>
								<a href="resources/pysmsh.doc">青海千人计划培养人才申报书填写说明</a>
							</p>
							<br/>
							<br/>
							<br/>
							<p>
								<a href="resources/yjsmsh.doc">青海千人计划引进人才申报书填写说明</a>
							</p>
<br/>
							<br/>
							<br/>
							<p>
								<a href="resources/tdsmsh.doc">青海千人计划团队申报书填写说明</a>
							</p>
							<p>
								
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
  	</div>
	<div id="footer">copyright@2017</div>
  </body>
</html>
