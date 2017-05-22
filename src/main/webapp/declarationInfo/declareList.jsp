<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>

<div class="pageHeader">
	<form class="pageForm" onsubmit="return navTabSearch(this);" action=""
		method="post">
		<div class="searchBar">
			<ul class="searchContent">
				<li><label style="width:100px">申报人/团队名称：</label> <input
					type="text" name="applicant" /></li>
			</ul>

			<div class="subBar">
				<ul>
					<li><div class="buttonActive">
							<div class="buttonContent" style="width:50px;">
								<button type="submit" style="width:50px;">查&nbsp;&nbsp;&nbsp;&nbsp;询</button>
							</div>
						</div></li>
				</ul>
			</div>
		</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a title="确实要删除这些记录吗?" target="selectedTodo" rel="ids"
				href="declarationInfo.do?deleteIds&callbackType=forward"
				class="delete"><span>批量删除</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="22"><input type="checkbox" group="ids"
					class="checkboxCtrl"></th>
				<th>申报人/团队)</th>
				<th>申报类别</th>
				<th>专业领域</th>
				<th>申报单位</th>
				<th>人才类型</th>
				<th>申报形式</th>
				<th>资料状态</th>
				<th>审核状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${declareList }">
				<tr target="sid_ids" rel="${item.declareId }">
					<td><input name="ids" value="${item.declareId }"
						type="checkbox"></td>
					<td>${item.applicant }</td>
					<td><c:choose>
							<c:when test="${item.flag==0 }">
								<c:if test="${item.declareType==0 }">杰出人才</c:if>
								<c:if test="${item.declareType==1 }">领军人才</c:if>
								<c:if test="${item.declareType==2 }">拔尖人才</c:if>
							</c:when>
							<c:otherwise>
								<c:if test="${item.declareType==2 }">培养团队</c:if>
								<c:if test="${item.declareType==1 }">引进团队</c:if>
							</c:otherwise>
						</c:choose></td>
					<td><c:choose>
							<c:when test="${item.flag==0 }">
								<c:if test="${item.declareFields==1 }">生态环保</c:if>
								<c:if test="${item.declareFields==2 }">企业技术</c:if>
								<c:if test="${item.declareFields==3 }">企业管理</c:if>
								<c:if test="${item.declareFields==4 }">创业</c:if>
								<c:if test="${item.declareFields==5 }">科技创新</c:if>
								<c:if test="${item.declareFields==6 }">社会科学</c:if>
								<c:if test="${item.declareFields==7 }">医疗卫生</c:if>
								<c:if test="${item.declareFields==8 }">文化艺术</c:if>
								<c:if test="${item.declareFields==9 }">农林技术推广</c:if>
								<c:if test="${item.declareFields==10 }">社会工作</c:if>
								<c:if test="${item.declareFields==11 }">其他</c:if>
							</c:when>
							<c:otherwise>
								<c:if test="${item.declareFields==1 }">科技创新</c:if>
								<c:if test="${item.declareFields==2 }">产业发展</c:if>
								<c:if test="${item.declareFields==3 }">企业管理</c:if>
								<c:if test="${item.declareFields==4 }">生态环保</c:if>
								<c:if test="${item.declareFields==5 }">技术推广应用</c:if>
								<c:if test="${item.declareFields==6 }">创业</c:if>
								<c:if test="${item.declareFields==7 }">文化艺术</c:if>
								<c:if test="${item.declareFields==8 }">社会科学</c:if>
								<c:if test="${item.declareFields==9 }">其他</c:if>
							</c:otherwise>
						</c:choose></td>
					<td><c:forEach var="unit" items="${unitList }">
							<c:if test="${item.declareUnit==unit.id }">${unit.name }</c:if>
						</c:forEach></td>
					<td><c:if test="${item.personType==0 }">培养</c:if> <c:if
							test="${item.personType==2 }">柔性引进</c:if> <c:if
							test="${item.personType==1 }">直接引进</c:if></td>
					<td><c:if test="${item.flag==0 }">个人</c:if> <c:if
							test="${item.flag==1 }">团队</c:if></td>
					<td><c:if test="${item.ifvalid==0 }">无效</c:if> <c:if
							test="${item.ifvalid==1 }">有效</c:if></td>
					<td><c:if test="${item.auditStatus==0 }">未审核</c:if> <c:if
							test="${item.auditStatus==1 }">审核中</c:if> <c:if
							test="${item.auditStatus==2}">审核通过</c:if> <c:if
							test="${item.auditStatus==3 }">审核未通过</c:if></td>
					<td><a title="删除" target="ajaxTodo" 
						href="declarationInfo.do?delete&id=${item.declareId }&callbackType=forward"
						class="btnDel">删除</a> <a class="icon" style="margin-left:10px" targetType="dialog"
						href="freeMarkController.do?downResumeDoc&declareId=${item.declareId }"
						title="确实要生成word文档吗？"><span>导出WORD</span></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</div>