<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<h2 class="contentTitle">团队依托的创新机构信息</h2>
<div class="pageContent">

	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" target="navTab"
				href="<c:url value='orgController.do?add'/>" title="代依托机构"><span>添加论依托机构</span></a></li>
			<li class="line">line</li>
			<li><a class="edit" target="navTab"
				href="<c:url value='orgController.do?edit&orgId={slt_eduId}'/>"
				title="依托机构"><span>修改依托机构</span></a></li>
			<li class="line">line</li>
			<li><a class="delete" target="ajaxToDo"
				href="<c:url value='orgController.do?delete&orgId={slt_eduId}&callbackType=forward'/>"
				title="确定要删除吗?"><span>删除依托</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="125px">
		<thead>
			<tr>
				<th width="50px"></th>
				<th>机构类别</th>
				<th>机构名称</th>
				<th>批准部门</th>
				<th>批准时间</th>
				<th>资助金额（近五年获得）</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${ orgList}" varStatus="s">
				<tr target="slt_eduId" rel="${item.orgId }">
					<td algin="center">${s.index + 1}</td>
					<td algin="center">${item.orgType}</td>
					<td algin="center">${item.orgName }</td>
					<td algin="center">${item.ratifyDepartment }</td>
					<td algin="center">${item.ratifyDate }</td>
					<td algin="center">${item.amountSubsidy }</td>
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
					<a href="<c:url value='honorController.do?list&flag=1'/>"
						style="text-decoration:none;" target="navTab" title="科技荣誉"
						rel="pyrcsb">上&nbsp;&nbsp;一&nbsp;&nbsp;步</a>
				</div>
			</div></li>
		<li><div class="button">
				<div class="buttonContent"
					style="width:70px;padding-top:6px;padding-left:15px;">
					<a href="<c:url value='researchController.do?list&flag=1&type=1'/>"
						style="text-decoration:none;" target="navTab" title="正在展开的科研项目"
						rel="pyrcsb">下&nbsp;&nbsp;一&nbsp;&nbsp;步</a>
				</div>
			</div></li>
	</ul>
</div>
