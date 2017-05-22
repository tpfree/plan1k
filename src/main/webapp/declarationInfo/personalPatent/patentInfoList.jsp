<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<h2 class="contentTitle"><c:if test="${flag==0 }">个人专利信息</c:if><c:if test="${flag==1 }">团队成员专利信息</c:if></h2>
<div class="pageContent">

	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" target="navTab"
				href="<c:url value='patentController.do?add&flag=${flag }'/>" title="个人专利"><span>添加专利</span></a></li>
			<li class="line">line</li>
			<li><a class="edit" target="navTab"
				href="<c:url value='patentController.do?edit&patentId={slt_eduId}&flag=${flag }'/>"
				title="个人专利"><span>修改专利</span></a></li>
			<li class="line">line</li>
			<li><a class="delete" target="ajaxToDo"
				href="<c:url value='patentController.do?delete&patentId={slt_eduId}&callbackType=forward&flag=${flag }'/>"
				title="确定要删除吗?"><span>删除专利</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="125px">
		<thead>
			<tr>
				<th width="50px"></th>
				<th>专利保护期</th>
				<th>专利名称</th>
				<th>专利类型</th>
				<th>授权国家</th>
				<th>专利所有者</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${ patentList}" varStatus="s">
				<tr target="slt_eduId" rel="${item.patentId }">
					<td algin="center">${s.index + 1}</td>
					<td algin="center">${item.protectPeriod}</td>
					<td algin="center">${item.patentName }</td>
					<td algin="center">
						<c:if test="${item.patentType==0 }">发明</c:if>
						<c:if test="${item.patentType==1 }">实用新型</c:if>
						<c:if test="${item.patentType==2 }">外观设计</c:if>
					</td>
					<td algin="center">${item.authorizedCountry }</td>
					<td algin="center">${item.patentOwner }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</div>
<div class="formBar">
	<ul>
		<li><div class="button">
				<div class="buttonContent"
					style="width:70px;padding-top:6px;padding-left:15px;">
					<a href="<c:url value='rewardController.do?list&flag=${flag }'/>"
						style="text-decoration:none;" target="navTab" title="个人专利"
						rel="pyrcsb">下&nbsp;&nbsp;一&nbsp;&nbsp;步</a>
				</div>
			</div></li>
	</ul>
</div>
