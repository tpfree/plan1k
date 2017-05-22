<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<h2 class="contentTitle"><c:if test="${flag==0 }">添加个人代表性研究项目信息</c:if>
<c:if test="${flag==1&&type==2 }">添加团队成员代表性研究项目信息</c:if>
<c:if test="${flag==1&&type==1 }">添加团队成员正在展开的科研项目信息</c:if></h2>
</h2>
<form method="post"
	action="<c:url value='researchController.do?insert&callbackType=forward'/>"
	class="pageForm required-validate"
	onsubmit="return validateCallback(this,navTabAjaxDone)">
	<div class="pageContent">
		<div class="pageFormContent" layoutH="97">
			
			<dl class="unit">
				<dt>项目名称：</dt><input type="hidden" name="flag" value="${flag }" />
				<dd><input type="hidden" name="type" value="${type }" />
					<input type="text" name="proName" value="" class="required" /> <span
						class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="unit">
				<dt>起始时间：</dt>
				<dd>
					<input type="text" class="date" readonly="readonly"
						name="startDate" /><a href="javascript:;" class="required inputDateButton">选择</a><span
						class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="unit">
				<dt>截至时间：</dt>
				<dd>
					<input type="text" class="date" readonly="readonly"
						name="endDate" /><a href="javascript:;" class="required inputDateButton">选择</a><span
						class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="unit">
				<dt>项目性质：</dt>
				<dd>
					<input type="text" name="proNature" value="" class="required" /> <span
						class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="unit">
				<dt>项目来源：</dt>
				<dd>
					<input type="text" name="proSource" value="" class="required" /> <span
						class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="unit">
				<dt>经费总额：</dt>
				<dd>
					<input type="text" name="totalAmonut" value="" class="required number" />&nbsp;&nbsp;万元&nbsp;&nbsp;&nbsp;&nbsp;<span
						class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="unit">
				<dt>参与人数：</dt>
				<dd>
					<input type="text" name="peopleNumber" value="" class="required digits" /> <span
						class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="unit">
				<dt>申报人具体职位：</dt>
				<dd>
					<input type="text" name="specificPosition" value="" class="required" /> <span
						class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="unit">
				<dt>申报人具体任务：</dt>
				<dd>
					<input type="text" name="specificTask" value="" class="required" /> <span
						class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="unit">
				<dt>项目进展情况：</dt>
				<dd>
					<textarea name="proProgress" class="required" cols="40" rows="5"></textarea>
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
