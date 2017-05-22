<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<h2 class="contentTitle">团队负责人及核心成员信息</h2>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" target="navTab"
				href="<c:url value='baseInfoController.do?addCharge'/>" ><span>添加负责人信息</span></a></li>
			<li class="line">line</li>
			<li><a class="add" target="navTab"
				href="<c:url value='baseInfoController.do?addCore'/>" "><span>添加核心成员信息</span></a></li>
			<li class="line">line</li>
			<li><a class="delete" target="ajaxToDo"
				href="<c:url value='baseInfoController.do?delete&baseId={slt_eduId}&callbackType=forward'/>"
				title="确定要删除吗?"><span>删除成员</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="125px">
		<thead>
			<tr>
				<th width="50px"></th>
				<th>姓名</th>
				<th>性别</th>
				<th>出生日期</th>
				<th>民族</th>
				<th>政治面貌</th>
				<th>毕业院校</th>
				<th>工作单位</th>
				<th>成员类别</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${baseInfoList}" varStatus="s">
				<tr target="slt_eduId" rel="${item.base_id }">
					<td algin="center">${s.index + 1}</td>
					<td algin="center">${item.name_en}</td>
					<td algin="center"><c:if test="${item.sex==0 }">男</c:if><c:if test="${item.sex==1 }">女</c:if></td>
					<td algin="center">${item.birthday }</td>
					<td algin="center">${item.nation }</td>
					<td algin="center">${item.political_status }</td>
					<td algin="center">${item.graduated_school_zh }</td>
					<td algin="center">${item.unit_pre }</td>
					<td algin="center"><c:if test="${item.flag==1 }">负责人</c:if><c:if test="${item.flag==2 }">核心成员</c:if></td>
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
					<a href="<c:url value='declarationInfo.do?getInfo'/>"
						style="text-decoration:none;" target="navTab" title="团队申报"
						rel="pyrcsb">上&nbsp;&nbsp;一&nbsp;&nbsp;步</a>
				</div>
			</div></li>
		<li><div class="button">
				<div class="buttonContent"
					style="width:70px;padding-top:6px;padding-left:15px;">
					<a href="<c:url value='declarationInfo/teamDeclare/memberInfos.jsp'/>"
							style="width:70px;text-decoration:none;" target="navTab"
							title="团队其他成员信息" rel="pyrcsb">下&nbsp;&nbsp;一&nbsp;&nbsp;步</a>
				</div>
			</div></li>
	</ul>
</div>
