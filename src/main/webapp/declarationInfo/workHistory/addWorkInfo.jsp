<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>

<h2 class="contentTitle"><c:if test="${flag==0 }">添加个人工作经历信息</c:if><c:if test="${flag==1 }">添加成员工作经历信息</c:if></h2>
<form method="post"
	action="<c:url value='workController.do?insert&callbackType=forward'/>"
	class="pageForm required-validate"
	onsubmit="return validateCallback(this,navTabAjaxDone)">
	<div class="pageContent">
		<div class="pageFormContent" layoutH="97">
			<dl class="nowrap">
				<dt>开始时间：</dt><input type="hidden" name="flag" value="${flag }" />
				<dd>
					<input type="text" class="date" readonly="readonly" name="startDate"/><a href="javascript:;" class="inputDateButton">选择</a><span class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>结束时间：</dt>
				<dd>
					<input type="text" class="date" readonly="readonly" name="endDate"/><a href="javascript:;" class="inputDateButton">选择</a> <span class="info"></span>
				</dd>
			</dl>
		
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>工作单位：</dt>
				<dd>
					<input type="text" name="workUnit" class="required" /> <span
						class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>担任职位：</dt>
				<dd>
					<input type="text" name="position" class="required" /> <span
						class="info"></span>
				</dd>
			</dl>
				<div class="divider"></div>
			<dl class="nowrap">
				<dt>所属国家：</dt>
				<dd>
					<input type="text" name="country" value="" class="required" />
					<span class="info"></span>
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
