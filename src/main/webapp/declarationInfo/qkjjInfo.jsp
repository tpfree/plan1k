<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>

<form method="post"
	action="<c:url value='baseInfoController.do?intro&callbackType=forward&navTabId=sbcl'/>"
	class="pageForm required-validate"
	onsubmit="return validateCallback(this,navTabAjaxDone)">
	<div class="pageContent">
		<div class="pageFormContent" layoutH="57">
			<dl class="nowrap">
				<dt>重要学术兼职情况：</dt>
				<dd><input type="hidden" name="flag" value="0" />
					<textarea name="academic_parttime_info" class="required" cols="80"
						rows="5"></textarea>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>成果转化情况：</dt>
				<dd>
					<textarea name="outcome_trans_info" class="required" cols="80"
						rows="5"></textarea>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>个人工作业绩简介（字数不超过1000字）：</dt><br/><br/>
				<dd>
					<textarea name="personal_job_profile" class="required" cols="80"
						rows="20"></textarea>
				</dd>
			</dl>
		</div>
		<div class="formBar">
		<ul>
		<li><div class="button">
				<div class="buttonContent"
					style="width:70px;padding-top:6px;padding-left:15px;">
					<a href="<c:url value='honorController.do?list&flag=0}'/>"
						style="text-decoration:none;" target="navTab" title="科技荣誉"
						rel="pyrcsb">上&nbsp;&nbsp;一&nbsp;&nbsp;步</a>
				</div>
			</div></li>
			<li><div class="buttonActive">
					<div class="buttonContent">
						<button type="submit" style="width:80px">下&nbsp;&nbsp;一&nbsp;&nbsp;步</button>
					</div>
				</div></li>
		</ul>
	</div>
	</div>

	
</form>
