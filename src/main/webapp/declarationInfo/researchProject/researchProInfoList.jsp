<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<h2 class="contentTitle"><c:if test="${flag==0 }">个人代表性研究项目信息</c:if>
<c:if test="${flag==1&&type==2 }">团队成员代表性研究项目信息</c:if>
<c:if test="${flag==1&&type==1 }">团队成员正在展开的科研项目信息</c:if></h2>
<div class="pageContent">

	<div class="panelBar">
			<ul class="toolBar">
			<li><a class="add" target="navTab"
				href="<c:url value='researchController.do?add&flag=${flag }&type=${type }'/>" ><span>添加项目</span></a></li>
			<li class="line">line</li>
			<li><a class="edit" target="navTab"
				href="<c:url value='researchController.do?edit&resId={slt_eduId}&flag=${flag }&type=${type }'/>"
				title="修改数据"><span>修改项目</span></a></li>
			<li class="line">line</li>
			<li><a class="delete" target="ajaxToDo"
				href="<c:url value='researchController.do?delete&resId={slt_eduId}&callbackType=forward&flag=${flag }&type=${type }'/>"
				title="确定要删除吗?"><span>删除项目</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="125">
		<thead>
			<tr>
				<th width="50px"></th>
				<th>项目名称</th>
				<th>起止时间</th>
				<th>项目性质</th>
				<th>项目来源</th>
				<th>经费总额</th>
				<th>参与人数</th>
				<th>申报人具体位置</th>
				<th>申报人具体任务</th>
				<th>项目进展情况</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${ researchList}" varStatus="s">
				<tr target="slt_eduId" rel="${item.proId }">
					<td algin="center">${s.index + 1}</td>
					<td algin="center">${item.proName }</td>
					<td algin="center">${item.startDate}<span>——</span>${item.endDate}</td>
					<td algin="center">${item.proNature }</td>
					<td algin="center">${item.proSource }</td>
					<td algin="center">${item.totalAmonut }</td>
					<td algin="center">${item.peopleNumber }</td>
					<td algin="center">${item.specificPosition }</td>
					<td algin="center">${item.specificTask }</td>
					<td algin="center">${item.proProgress }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="formBar">
		<ul>
		<li><div class="button">
				<div class="buttonContent"
					style="width:70px;padding-top:6px;padding-left:15px;">
					<c:if test="${type==2 }">
					<a href="<c:url value='selectedController.do?list&flag=${flag }'/>"
						style="text-decoration:none;" target="navTab" title="人才入选计划或工程"
						rel="pyrcsb">上&nbsp;&nbsp;一&nbsp;&nbsp;步</a>
					</c:if>
					<c:if test="${type==1 }">
					<a href="<c:url value='orgController.do?list'/>"
						style="text-decoration:none;" target="navTab" title="人才入选计划或工程"
						rel="pyrcsb">上&nbsp;&nbsp;一&nbsp;&nbsp;步</a>
					</c:if>
				</div>
			</div></li>
		<li><div class="button">
				<div class="buttonContent"
					style="width:70px;padding-top:6px;padding-left:15px;">
					<c:if test="${type==2 }">
					<a href="<c:url value='paperController.do?list&flag=${flag }'/>"
						style="text-decoration:none;" target="navTab" title="代表性论著"
						rel="pyrcsb">下&nbsp;&nbsp;一&nbsp;&nbsp;步</a>
						</c:if>
					<c:if test="${type==1 }">
					<a href="<c:url value='declarationInfo/teamDeclare/teamqkjjInfo.jsp'/>"
						style="text-decoration:none;" target="navTab" title="团队工作业绩简介"
						rel="pyrcsb">下&nbsp;&nbsp;一&nbsp;&nbsp;步</a>
						</c:if>
				</div>
			</div></li>
	</ul>
	</div>
</div>
