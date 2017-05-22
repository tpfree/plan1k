<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<h2 class="contentTitle">团队成员教育经历信息</h2>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" target="navTab"
				href="<c:url value='eduInfoController.do?add&flag=1'/>" width="600"
				height="450"><span>添加经历</span></a></li>
			<li class="line">line</li>
			<li><a class="edit" target="navTab"
				href="<c:url value='eduInfoController.do?edit&eduId={slt_eduId}&flag=1'/>"
				title="修改数据"><span>修改经历</span></a></li>
			<li class="line">line</li>
			<li><a class="delete" target="ajaxToDo"
				href="<c:url value='eduInfoController.do?delete&eduId={slt_eduId}&callbackType=forward&flag=1'/>"
				title="确定要删除吗?"><span>删除经历</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="125px">
		<thead>
			<tr>
				<th width="50px"></th>
				<th width="200px">时间</th>
				<th>国家</th>
				<th>院校</th>
				<th>专业</th>
				<th>学位</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${eduList}" varStatus="s">
				<tr target="slt_eduId" rel="${item.eduId }">
					<td algin="center">${s.index + 1}</td>
					<td algin="center">${item.startDate}<span>——</span>${item.endDate}</td>
					<td algin="center">${item.country }</td>
					<td algin="center">${item.school }</td>
					<td algin="center">${item.profession }</td>
					<td algin="center">${item.degree }</td>
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
					<a href="<c:url value='baseInfoController.do?baseList'/>"
						style="text-decoration:none;" target="navTab" title="成员信息列表"
						rel="pyrcsb">上&nbsp;&nbsp;一&nbsp;&nbsp;步</a>
				</div>
			</div></li>
		<li><div class="button">
				<div class="buttonContent"
					style="width:70px;padding-top:6px;padding-left:15px;">
					<a href="<c:url value='workController.do?list&flag=1'/>"
						style="text-decoration:none;" target="navTab" title="工作经历"
						rel="pyrcsb">下&nbsp;&nbsp;一&nbsp;&nbsp;步</a>
				</div>
			</div></li>

	</ul>
</div>
