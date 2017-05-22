<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>

<h2 class="contentTitle">修改教育经历信息</h2>
<form method="post"
	action="<c:url value='eduInfoController.do?update&callbackType=forward'/>"
	class="pageForm required-validate"
	onsubmit="return validateCallback(this,navTabAjaxDone)">
	<div class="pageContent">
		<div class="pageFormContent" layoutH="97"></dt><input type="hidden" name="flag" value="0" />
			<dl class="nowrap"><input type="hidden" name="eduId" class="required" value="${edu.eduId }"/>
				<dt>开始时间：</dt>
				<dd>
					<input type="text" class="date" readonly="readonly" name="startDate" value="${edu.startDate }"/><a href="javascript:;" class="inputDateButton">选择</a><span class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>结束时间：</dt>
				<dd>
					<input type="text" class="date" readonly="readonly" name="endDate" value="${edu.endDate }"/><a href="javascript:;" class="inputDateButton">选择</a> <span class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>所属国家：</dt>
				<dd>
					<input type="text" name="country" class="required" value="${edu.country }"/>
					<span class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>毕业院校：</dt>
				<dd>
					<input type="text" name="school" class="required" value="${edu.school }"/> <span
						class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>所学专业：</dt>
				<dd>
					<input type="text" name="profession" class="required" value="${edu.profession }"/> <span
						class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>获得学位：</dt>
				<dd>
					<input type="text" name="degree" class="required" value="${edu.degree }"/> <span class="info"></span>
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
