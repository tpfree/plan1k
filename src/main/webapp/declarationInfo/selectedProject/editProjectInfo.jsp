<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<h2 class="contentTitle"><c:if test="${flag==0 }">个人入选人才计划或工程信息修改</c:if><c:if test="${flag==1 }">团队程艳入选人才计划或工程信息修改</c:if></h2>
<form method="post"
	action="<c:url value='selectedController.do?update&callbackType=forward'/>"
	class="pageForm required-validate"
	onsubmit="return validateCallback(this,navTabAjaxDone)">
	<div class="pageContent">
		<div class="pageFormContent" layoutH="97">
			
			<dl class="unit">
				<dt>计划或工程名称：</dt> <input type="hidden" name="proId" class="required" value="${selectPro.proId }"/>
				<dd><input type="hidden" name="flag" value="${flag }" />
					<input type="text" name="proName" value="${selectPro.proName }" class="required" /> <span
						class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="unit">
				<dt>入选时间：</dt>
				<dd>
					<input type="text" class="date" readonly="readonly" value="${selectPro.selectedTime }"
						name="selectedTime" /><a href="javascript:;" class="required inputDateButton">选择</a><span
						class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="unit">
				<dt>计划或工程等级：</dt>
				<dd>
					<select name="proLevel" class="required">
						<option value="0" <c:if test="${selectPro.proLevel==0 }">selected="selected"</c:if>>厅局级</option>
						<option value="1" <c:if test="${selectPro.proLevel==1 }">selected="selected"</c:if>>省部级</option>
						<option value="2" <c:if test="${selectPro.proLevel==2 }">selected="selected"</c:if>>国家级</option>
					</select>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="unit">
				<dt>备注：</dt>
				<dd>
					<textarea name="memo"  cols="40" rows="5">${selectPro.memo }</textarea>
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
