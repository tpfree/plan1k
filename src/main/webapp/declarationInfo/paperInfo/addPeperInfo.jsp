<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<h2 class="contentTitle"><c:if test="${flag==0 }">添加个人论著（论文）信息</c:if><c:if test="${flag==1 }">添加团队成员论著（论文）信息</c:if></h2>
<form method="post"
	action="<c:url value='paperController.do?insert&callbackType=forward'/>"
	class="pageForm required-validate"
	onsubmit="return validateCallback(this,navTabAjaxDone)">
	<div class="pageContent">
		<div class="pageFormContent" layoutH="97">
			
			<dl class="unit">
				<dt>论著(论文)名称：</dt>
				<dd><input type="hidden" name="flag" value="${flag }" />
					<input type="text" name="paperName" value="" class="required" /> <span
						class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="unit">
				<dt>发表时间：</dt>
				<dd>
					<input type="text" class="date" readonly="readonly"
						name="publishedDate" /><a href="javascript:;" class="required inputDateButton">选择</a><span
						class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="unit">
				<dt>发表载体：</dt>
				<dd>
					<input type="text" name="publishedVector" value="" class="required" /> <span
						class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="unit">
				<dt>论著（论文）作者：</dt>
				<dd>
					<input type="text" name="paperAuthor" value="" class="required" /> <span
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
