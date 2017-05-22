<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<h2 class="contentTitle">团队成员教育经历信息添加</h2>
<form method="post"
	action="<c:url value='eduInfoController.do?insert&callbackType=forward'/>"
	class="pageForm required-validate"
	onsubmit="return validateCallback(this,navTabAjaxDone)">
	<div class="pageContent">
		<div class="pageFormContent" layoutH="97">
			<dl class="unit">
				<dt>开始时间：</dt> <input type="hidden" name="flag" value="1" />
				<dd>
					<input type="text" class="date" readonly="readonly"
						name="startDate" /><a href="javascript:;" class="inputDateButton">选择</a><span
						class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="unit">
				<dt>结束时间：</dt>
				<dd>
					<input type="text" class="date" readonly="readonly" name="endDate" /><a
						href="javascript:;" class="inputDateButton">选择</a> <span
						class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="unit">
				<dt>所属国家：</dt>
				<dd>
					<input type="text" name="country" value="" class="required" /> <span
						class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="unit">
				<dt>毕业院校：</dt>
				<dd>
					<input type="text" name="school" class="required" /> <span
						class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="unit">
				<dt>所学专业：</dt>
				<dd>
					<input type="text" name="profession" class="required" /> <span
						class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="unit">
				<dt>获得学位：</dt>
				<dd>
					<input type="text" name="degree" class="required" /> <span
						class="info"></span>
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
