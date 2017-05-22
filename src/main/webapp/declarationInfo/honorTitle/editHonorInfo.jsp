<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<h2 class="contentTitle"><c:if test="${flag==0 }">个人科技荣誉信息修改</c:if><c:if test="${flag==1 }">团队成员科技荣誉信息修改</c:if></h2>
<form method="post"
	action="<c:url value='honorController.do?update&callbackType=forward'/>"
	class="pageForm required-validate"
	onsubmit="return validateCallback(this,navTabAjaxDone)">
	<div class="pageContent">
		<div class="pageFormContent" layoutH="97">

			<dl class="unit"><input type="hidden" name="flag" value="${flag }" />
				<dt>荣誉名称：</dt><input type="hidden" name="honorId" value="${honorInfo.honorId }" />
				<dd>
					<input type="text" name="honorName" value="${honorInfo.honorName }" class="required" /> <span
						class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="unit">
				<dt>获奖时间：</dt>
				<dd>
					<input type="text" class="date" readonly="readonly"  value="${honorInfo.honorDate }"
						name="honorDate" /><a href="javascript:;"
						class="required inputDateButton">选择</a><span class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="unit">
				<dt>荣誉等级：</dt>
				<dd>
					<select name="honorlevel" class="required">
						<option value="0" <c:if test="${honorInfo.honorlevel==0 }">selected="selected"</c:if>>厅局级</option>
						<option value="1" <c:if test="${honorInfo.honorlevel==1 }">selected="selected"</c:if>>省部级</option>
						<option value="2" <c:if test="${honorInfo.honorlevel==2 }">selected="selected"</c:if>>国家级</option>
					</select>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="unit">
				<dt>颁发部门：</dt>
				<dd>
					<input type="text" name="department" value="${honorInfo.department }" class="required" />
					<span class="info"></span>
				</dd>
			</dl>

			<div class="divider"></div>
			<dl>
				<dt>荣誉证书：</dt>
				<dd> <input name="certificate" value="${honorInfo.certificate }" type="hidden">
					<input name="attachment.attachmentPath"
						value="${attachment.attachmentPath }" type="hidden"> <input
						class="readonly" name="attachment.fileName" value=""
						readonly="readonly" type="text" /> <a class="btnAttach"
						href="declarationInfo/uploadFile.jsp" lookupGroup="attachment"
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
