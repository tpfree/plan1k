<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<h2 class="contentTitle"><c:if test="${flag==0 }">个人科技奖励信息</c:if><c:if test="${flag==1 }">团队成员科技奖励信息</c:if></h2>
<div class="pageContent">

	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" target="navTab"
				href="<c:url value='rewardController.do?add&flag=${flag }'/>" title=""><span>添加奖励</span></a></li>
			<li class="line">line</li>
			<li><a class="edit" target="navTab"
				href="<c:url value='rewardController.do?edit&rewardId={slt_eduId}&flag=${flag }'/>"
				title=""><span>修改奖励</span></a></li>
			<li class="line">line</li>
			<li><a class="delete" target="ajaxToDo"
				href="<c:url value='rewardController.do?delete&rewardId={slt_eduId}&callbackType=forward&flag=${flag }'/>"
				title="确定要删除吗?"><span>删除奖励</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="125px">
		<thead>
			<tr>
				<th width="50px"></th>
				<th>奖励名称</th>
				<th>奖励编号</th>
				<th>奖励部门</th>
				<th>奖励等级</th>
				<th>本人排名</th>
				<th>总人数</th>
				<th>获奖时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${rewardList}" varStatus="s">
				<tr target="slt_eduId" rel="${item.rewardId }">
					<td algin="center">${s.index + 1}</td>
					<td algin="center">${item.rewardName}</td>
					<td algin="center">${item.rewardNumber }</td>
					<td algin="center">${item.department }</td>
					<td algin="center">
						<c:if test="${item.rewardLevel==0 }">厅局级</c:if>
						<c:if test="${item.rewardLevel==1 }">省部级</c:if>
						<c:if test="${item.rewardLevel==2 }">国家级</c:if>
					</td>
					<td algin="center">${item.rewardRanking }</td>
					<td algin="center">${item.totalNumber }</td>
					<td algin="center">${item.rewardDate }</td>
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
				<a href="<c:url value='paperController.do?list&flag=${flag }'/>"
					style="text-decoration:none;" target="navTab" title="代表性论著"
					rel="pyrcsb">上&nbsp;&nbsp;一&nbsp;&nbsp;步</a>
			</div>
		</div></li>
		<li><div class="button">
				<div class="buttonContent"
					style="width:70px;padding-top:6px;padding-left:15px;">
					<a href="<c:url value='honorController.do?list&flag=${flag }'/>"
						style="text-decoration:none;" target="navTab" title="科技荣誉"
						rel="pyrcsb">下&nbsp;&nbsp;一&nbsp;&nbsp;步</a>
				</div>
			</div></li>
	</ul>
</div>
