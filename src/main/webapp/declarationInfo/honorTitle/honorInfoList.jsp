<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<h2 class="contentTitle"><c:if test="${flag==0 }">个人科技荣誉信息</c:if><c:if test="${flag==1 }">团队成员科技荣誉信息</c:if></h2>
<div class="pageContent">

	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" target="navTab"
				href="<c:url value='honorController.do?add&flag=${flag }'/>" title="科技荣誉"><span>添加荣誉</span></a></li>
			<li class="line">line</li>
			<li><a class="edit" target="navTab"
				href="<c:url value='honorController.do?edit&honorId={slt_eduId}&flag=${flag }'/>"
				title="个人专利"><span>修改荣誉</span></a></li>
			<li class="line">line</li>
			<li><a class="delete" target="ajaxToDo"
				href="<c:url value='honorController.do?delete&honorId={slt_eduId}&callbackType=forward&flag=${flag }'/>"
				title="确定要删除吗?"><span>删除荣誉</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="125px">
		<thead>
			<tr>
				<th width="50px"></th>
				<th>荣誉名称</th>
				<th>获奖时间</th>
				<th>颁发部门</th>
				<th>荣誉等级</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${ honorList}" varStatus="s">
				<tr target="slt_eduId" rel="${item.honorId }">
					<td algin="center">${s.index + 1}</td>
					<td algin="center">${item.honorName}</td>
					<td algin="center">${item.honorDate }</td>
					<td algin="center">${item.department }</td>
					<td algin="center">
						<c:if test="${item.honorlevel==0 }">厅局级</c:if>
						<c:if test="${item.honorlevel==1 }">省部级</c:if>
						<c:if test="${item.honorlevel==2 }">国家级</c:if>
					</td>
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
						style="text-decoration:none;" target="navTab" title="科技奖励"
						rel="pyrcsb">上&nbsp;&nbsp;一&nbsp;&nbsp;步</a>
				</div>
			</div></li>
		<li><div class="button">
				<div class="buttonContent"
					style="width:70px;padding-top:6px;padding-left:15px;">
					<c:if test="${flag==0 }">
					<a href="<c:url value='declarationInfo/qkjjInfo.jsp'/>"
						style="text-decoration:none;" target="navTab" title="个人业绩简介"
						rel="pyrcsb">下&nbsp;&nbsp;一&nbsp;&nbsp;步</a>
						</c:if>
					<c:if test="${flag==1 }">
					<a href="<c:url value='orgController.do?list'/>"
						style="text-decoration:none;" target="navTab" title="团队依托机构"
						rel="pyrcsb">下&nbsp;&nbsp;一&nbsp;&nbsp;步</a>
						</c:if>
				</div>
			</div></li>
	</ul>
</div>
