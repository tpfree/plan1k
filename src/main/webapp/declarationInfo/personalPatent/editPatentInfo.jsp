<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<h2 class="contentTitle"><c:if test="${flag==0 }">个人专利信息修改</c:if><c:if test="${flag==1 }">团队成员专利信息修改</c:if></h2>
<form method="post"
	action="<c:url value='patentController.do?update&callbackType=forward'/>"
	class="pageForm required-validate"
	onsubmit="return validateCallback(this,navTabAjaxDone)">
	<div class="pageContent">
		<div class="pageFormContent" layoutH="97">
			
			<dl class="unit">
				<dt>专利名称：</dt>
				<dd><input type="hidden" name="flag" value="${flag }" /><input type="hidden" name="patentId" value="${patentInfo.patentId }" />
					<input type="text" name="patentName" value="${patentInfo.patentName }" class="required" /> <span
						class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="unit">
				<dt>专利保护期：</dt>
				<dd>
					<input type="text" name="protectPeriod" value="${patentInfo.protectPeriod }" class="required digits" />&nbsp;&nbsp;年&nbsp;&nbsp; <span
						class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="unit">
				<dt>专利类型：</dt>
				<dd>
					<select name="patentType" class="required">
						<option value="0"  <c:if test="${patentInfo.patentType==0 }">selected="selected"</c:if>>发明</option>
						<option value="1"  <c:if test="${patentInfo.patentType==1 }">selected="selected"</c:if>>实用新型</option>
						<option value="2"  <c:if test="${patentInfo.patentType==2 }">selected="selected"</c:if>>外观设计</option>
					</select>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="unit">
				<dt>授权国家：</dt>
				<dd>
					<input type="text" name="authorizedCountry" value="${patentInfo.authorizedCountry }" class="required" /> <span
						class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="unit">
				<dt>专利所有者：</dt>
				<dd>
					<input type="text" name="patentOwner" value="${patentInfo.patentOwner }" class="required" /><span
						class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl>
				<dt>专利证书：</dt>
				<dd> <input name="certificate" value="${patentInfo.certificate }" type="hidden">
					<input name="attachment.attachmentPath" value="${attachment.attachmentPath }" type="hidden"> <input class="readonly"
						name="attachment.fileName" value="" readonly="readonly"
						type="text" /> <a class="btnAttach"
						href="declarationInfo/personalPatent/uploadPatent.jsp" lookupGroup="attachment"
						width="560" height="300" title="附件">附件</a>
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
