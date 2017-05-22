<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<h2 class="contentTitle"><c:if test="${flag==1 }">团队成员代表性论著（论文）信息</c:if><c:if test="${flag==0 }">个人代表性论著（论文）信息</c:if></h2>
<div class="pageContent">

	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" target="navTab"
				href="<c:url value='paperController.do?add&flag=${flag }'/>" title="代表性论著"><span>添加论著</span></a></li>
			<li class="line">line</li>
			<li><a class="edit" target="navTab"
				href="<c:url value='paperController.do?edit&paperId={slt_eduId}&flag=${flag }'/>"
				title="代表性论著"><span>修改论著</span></a></li>
			<li class="line">line</li>
			<li><a class="delete" target="ajaxToDo"
				href="<c:url value='paperController.do?delete&paperId={slt_eduId}&callbackType=forward&flag=${flag }'/>"
				title="确定要删除吗?"><span>删除论著</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="125px">
		<thead>
			<tr>
				<th width="50px"></th>
				<th>发表时间</th>
				<th>论著名称</th>
				<th>发表载体</th>
				<th>论著作者</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${ paperList}" varStatus="s">
				<tr target="slt_eduId" rel="${item.paperId }">
					<td algin="center">${s.index + 1}</td>
					<td algin="center">${item.publishedDate}</td>
					<td algin="center">${item.paperName }</td>
					<td algin="center">${item.publishedVector }</td>
					<td algin="center">${item.paperAuthor }</td>
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
					<a href="<c:url value='researchController.do?list&flag=0'/>"
						style="text-decoration:none;" target="navTab" title="代表性研究项目"
						rel="pyrcsb">上&nbsp;&nbsp;一&nbsp;&nbsp;步</a>
						</c:if>
					<c:if test="${flag==1 }">
					<a href="<c:url value='researchController.do?list&flag=1&type=2'/>"
						style="text-decoration:none;" target="navTab" title="代表性研究项目"
						rel="pyrcsb">上&nbsp;&nbsp;一&nbsp;&nbsp;步</a>
						</c:if>
				</div>
			</div></li>
		<li><div class="button">
				<div class="buttonContent"
					style="width:70px;padding-top:6px;padding-left:15px;">
					<a href="<c:url value='rewardController.do?list&flag=${flag }'/>"
						style="text-decoration:none;" target="navTab" title="科技奖励信息"
						rel="pyrcsb">下&nbsp;&nbsp;一&nbsp;&nbsp;步</a>
				</div>
			</div></li>
	</ul>
</div>
