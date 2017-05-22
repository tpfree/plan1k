<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<h2 class="contentTitle"><c:if test="${flag==0 }">个人入选的人才计划或工程信息</c:if><c:if test="${flag==1 }">团队成员入选的人才计划或工程信息</c:if></h2>
<div class="pageContent">

	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" target="navTab"
				href="<c:url value='selectedController.do?add&flag=${flag }'/>" ><span>添加人才计划或工程</span></a></li>
			<li class="line">line</li>
			<li><a class="edit" target="navTab"
				href="<c:url value='selectedController.do?edit&proId={slt_eduId}&flag=${flag }'/>"
				title="修改数据"><span>修改人才计划或工程</span></a></li>
			<li class="line">line</li>
			<li><a class="delete" target="ajaxToDo"
				href="<c:url value='selectedController.do?delete&proId={slt_eduId}&callbackType=forward&flag=${flag }'/>"
				title="确定要删除吗?"><span>删除人才计划或工程</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="125">
		<thead>
			<tr>
				<th width="50px"></th>
				<th>入选计划工程名称</th>
				<th>入选时间</th>
				<th>级别</th>
				<th>备注</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${selectedProList}" varStatus="s">
				<tr target="slt_eduId" rel="${item.proId }">
					<td algin="center">${s.index + 1}</td>
					<td algin="center">${item.proName}</td>
					<td algin="center">${item.selectedTime }</td>
					<td algin="center">
						<c:if test="${item.proLevel==0 }">厅局级</c:if>
						<c:if test="${item.proLevel==1 }">省部级</c:if>
						<c:if test="${item.proLevel==2 }">国家级</c:if>
					</td>
					<td algin="center">${item.memo }</td>
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
					<c:if test="${flag==0 }">
						<a href="<c:url value='workController.do?list&flag=0'/>"
								style="text-decoration:none;" target="navTab" title="工作经历"
								rel="pyrcsb">上&nbsp;&nbsp;一&nbsp;&nbsp;步</a>
					</c:if>
					<c:if test="${flag==1 }">
						<a href="<c:url value='declarationInfo.do?getmembers'/>"
						style="text-decoration:none;" target="navTab" title="成员信息"
						rel="pyrcsb">上&nbsp;&nbsp;一&nbsp;&nbsp;步</a>
					</c:if>
					
				</div>
			</div></li>
		<li><div class="button">
				<div class="buttonContent"
					style="width:70px;padding-top:6px;padding-left:15px;">
					<a href="<c:url value='researchController.do?list&type=2&flag=${flag }'/>"
						style="text-decoration:none;" target="navTab" title="代表性研究项目"
						rel="pyrcsb">下&nbsp;&nbsp;一&nbsp;&nbsp;步</a>
				</div>
			</div></li>
	</ul>
</div>

