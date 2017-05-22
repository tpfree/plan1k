<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<h2 class="contentTitle">团队依托的创新机构信息修改</h2>
<form method="post"
	action="<c:url value='orgController.do?update&callbackType=forward'/>"
	class="pageForm required-validate"
	onsubmit="return validateCallback(this,navTabAjaxDone)">
	<div class="pageContent">
		<div class="pageFormContent" layoutH="97">
				<dl class="unit">
				<dt>依托机构名称：</dt><input type="hidden" name="orgId" value="${orgInfo.orgId }"  />
				<dd>
					<input type="text" name="orgName" value="${orgInfo.orgName }" class="required" /> <span
						class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="unit">
				<dt>依托机构类别：</dt>
				<dd>
					<input type="text" name="orgType" value="${orgInfo.orgType }" class="required" /> <span
						class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="unit">
				<dt>批准部门：</dt>
				<dd>
					<input type="text" name="ratifyDepartment" value="${orgInfo.ratifyDepartment }" class="required" /> <span
						class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="unit">
				<dt>批准时间：</dt>
				<dd>
					<input type="text" class="date" readonly="readonly" value="${orgInfo.ratifyDate }"
						name="ratifyDate" /><a href="javascript:;" class="required inputDateButton">选择</a><span
						class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="unit">
				<dt>近5年获得资助金额：</dt>
				<dd>
					<input type="text" name="amountSubsidy" value="${orgInfo.amountSubsidy }" class="required" /> 万元<span
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
