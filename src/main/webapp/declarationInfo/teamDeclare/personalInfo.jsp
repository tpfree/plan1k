<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>

<form method="post"
	action="<c:url value='baseInfoController.do?toUpdateJy&callbackType=forward&navTabId=sbcl'/>"
	class="pageForm required-validate"
	onsubmit="return validateCallback(this,navTabAjaxDone)">
	<div class="pageContent">
		<div class="pageFormContent" layoutH="57">
			<dl class="nowrap">
				<dt>个人工作业绩简介（字数不超过1000字）：</dt>
				<input type="hidden" name="flag" value="1" />
				<dd>
					<textarea name="personal_job_profile" class="required" cols="90"
						rows="30"></textarea>
				</dd>
			</dl>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive">
						<div class="buttonContent" style="width:70px;padding-top:6px;padding-left:15px;">
							<a href="<c:url value='workController.do?list&flag=1'/>"
								style="text-decoration:none;" target="navTab" title="工作经历"
								rel="pyrcsb">上&nbsp;&nbsp;一&nbsp;&nbsp;步</a>

						</div>
					</div></li>
				<li><div class="buttonActive" style="width:70px">
						<div class="buttonContent">
							<button type="submit">下&nbsp;&nbsp;一&nbsp;&nbsp;步</button>
						</div>
					</div></li>
			</ul>
		</div>
	</div>


</form>
