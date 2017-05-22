<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>

<h2 class="contentTitle"><c:if test="${flag==0 }">个人工作经历信息</c:if><c:if test="${flag==1 }">成员工作经历信息</c:if></h2>
<div class="pageContent">

	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" target="navTab"
				href="<c:url value='workController.do?add&flag=${flag }'/>"><span>添加经历</span></a></li>
			<li class="line">line</li>
			<li><a class="edit" target="navTab"
				href="<c:url value='workController.do?edit&workId={slt_eduId}&flag=${flag }'/>"
				title="修改数据"><span>修改经历</span></a></li>
			<li class="line">line</li>
			<li><a class="delete" target="ajaxToDo"
				href="<c:url value='workController.do?delete&workId={slt_eduId}&callbackType=forward&flag=${flag }'/>"
				title="确定要删除吗?"><span>删除经历</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="125px">
		<thead>
			<tr>
				<th width="50px"></th>
				<th width="200px">时间</th>
				<th>单位</th>
				<th>职位</th>
				<th>国家</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${ workList}" varStatus="s">
				<tr target="slt_eduId" rel="${item.historyId }">
					<td algin="center">${s.index + 1}</td>
					<td algin="center">${item.startDate}<span>——</span>${item.endDate}</td>
					<td algin="center">${item.workUnit }</td>
					<td algin="center">${item.position }</td>
					<td algin="center">${item.country }</td>
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
						<a href="<c:url value='eduInfoController.do?List&flag=0'/>"
						style="text-decoration:none;" target="navTab" title="教育经历"
						rel="pyrcsb">上&nbsp;&nbsp;一&nbsp;&nbsp;步</a>
					</c:if>
					<c:if test="${flag==1 }">
						<a href="<c:url value='eduInfoController.do?teamList'/>"
						style="text-decoration:none;" target="navTab" title="团队成员教育经历"
						rel="pyrcsb">上&nbsp;&nbsp;一&nbsp;&nbsp;步</a>
					</c:if>
					
				</div>
			</div></li>
		<li><div class="button">
				<div class="buttonContent"
					style="width:70px;padding-top:6px;padding-left:15px;">
					<c:if test="${flag==0 }">
						<a href="<c:url value='selectedController.do?list&flag=0'/>"
							style="width:70px;text-decoration:none;" target="navTab"
							title="入选人才计划或工程" rel="pyrcsb">下&nbsp;&nbsp;一&nbsp;&nbsp;步</a>
					</c:if>
					<c:if test="${flag==1 }">
						<a href="<c:url value='baseInfoController.do?toPersonal'/>"
							style="text-decoration:none;" target="navTab" title="成员个人业绩"
							rel="pyrcsb">下&nbsp;&nbsp;一&nbsp;&nbsp;步</a>
					</c:if>
				</div>
			</div></li>
	</ul>
</div>
