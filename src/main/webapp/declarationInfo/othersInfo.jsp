<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>

<form method="post"
	action="<c:url value='baseInfoController.do?others&callbackType=closeCurrent&navTabId=sbcl'/>"
	class="pageForm required-validate"
	onsubmit="return validateCallback(this,navTabAjaxDone)">
	<div class="pageContent">
		<div class="pageFormContent" layoutH="57">
			<dl class="nowrap"><input type="hidden" name="flag" value="1" />
				<span>合同期内工作成果知识产权归属：</span>
				<input type="radio" name="intellectual_rights_owner" value="0"
					checked />本人
				<input type="radio" name="intellectual_rights_owner" value="1" />申报单位
				<input type="radio" name="intellectual_rights_owner" value="2" />原单位
			</dl>
			<div class="divider"></div>
			<dl>
				<span>申报情况：</span>
				<input type="radio" name="declare_situation" value="1" checked />首次申报
				<input type="radio" name="declare_situation" value="0" />非首次申报

			</dl>
			<div class="divider"></div>
			<dl class="nowrap">
				<span>您是否和其他任何单位签订过仍然有效的竞业禁止协议，如果有，请列出：</span>
				<br />
				<br />
				<textarea name="if_sign_agreement_other" class="required" cols="80"
					rows="3"></textarea>
			</dl>

			<div class="divider"></div>
			<dl class="nowrap">
				<span>个人工作计划（包括工作内容、工作目标、考核要求等，字数不超过1000字）：</span>
				<br />
				<br />
				<textarea name="personal_work_plan" class="required" cols="80"
					rows="20"></textarea>

			</dl>
		</div>
		<div class="formBar">
			<ul>
			<li><div class="button">
				<div class="buttonContent"
					style="width:70px;padding-top:6px;padding-left:15px;">
					<a href="<c:url value='declarationInfo/qkjjInfo.jsp'/>"
						style="text-decoration:none;" target="navTab" title="个人业绩简介"
						rel="pyrcsb">下&nbsp;&nbsp;一&nbsp;&nbsp;步</a>
				</div>
			</div></li>
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="submit" style="width:80px">提交完成</button>
						</div>
					</div></li>
			</ul>
		</div>
	</div>

</form>
