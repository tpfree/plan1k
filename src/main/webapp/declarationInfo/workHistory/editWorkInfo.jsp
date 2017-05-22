<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>

<h2 class="contentTitle"><c:if test="${flag==0 }">修改个人工作经历信息</c:if><c:if test="${flag==1 }">修改成员工作经历信息</c:if></h2>
<form method="post"
	action="<c:url value='workController.do?update&callbackType=forward'/>"
	class="pageForm required-validate"
	onsubmit="return validateCallback(this,navTabAjaxDone)">
	<div class="pageContent">
		<div class="pageFormContent" layoutH="97">
			<dl class="nowrap">
				<input type="hidden" name="historyId" class="required"
					value="${workInfo.historyId }" /><input type="hidden" name="flag" value="${flag }" />
				<dt>开始时间：</dt>
				<dd>
					<input type="text" class="date" readonly="readonly"
						name="startDate" value="${workInfo.startDate }" /><a
						href="javascript:;" class="inputDateButton">选择</a><span
						class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>结束时间：</dt>
				<dd>
					<input type="text" class="date" readonly="readonly" name="endDate"
						value="${workInfo.endDate }" /><a href="javascript:;"
						class="inputDateButton">选择</a> <span class="info"></span>
				</dd>
			</dl>

			<div class="divider"></div>
			<dl class="nowrap">
				<dt>工作单位：</dt>
				<dd>
					<input type="text" name="workUnit" class="required"
						value="${workInfo.workUnit }" /> <span class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>担任职位：</dt>
				<dd>
					<input type="text" name="position" class="required"
						value="${workInfo.position }" /> <span class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>所属国家：</dt>
				<dd>
					<input type="text" name="country" class="required"
						value="${workInfo.country }" /> <span class="info"></span>
				</dd>
			</dl>
		</div>
	</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive">
					<div class="buttonContent">
						<button type="submit" style="width:80px">保&nbsp;&nbsp;存</button>
					</div>
				</div></li>
			
		</ul>
	</div>
</form>
