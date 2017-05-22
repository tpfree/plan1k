<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<h2 class="contentTitle"><c:if test="${flag==0 }">个人科技奖励信息修改</c:if><c:if test="${flag==1 }">团队成员科技奖励信息修改</c:if></h2>
<form method="post"
	action="<c:url value='rewardController.do?update&callbackType=forward'/>"
	class="pageForm required-validate"
	onsubmit="return validateCallback(this,navTabAjaxDone)">
	<div class="pageContent">
		<div class="pageFormContent" layoutH="97">
			<input type="hidden" name="flag" value="${flag }" />
			<dl class="unit">
				<dt>奖励名称：</dt><input name="rewardId" value="${rewardInfo.rewardId }" type="hidden"> 
				<dd>
					<input type="text" name="rewardName" value="${rewardInfo.rewardName }" class="required" /> <span
						class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="unit">
				<dt>奖励编号：</dt>
				<dd>
					<input type="text" name="rewardNumber" value="${rewardInfo.rewardNumber }" class="required" /> <span
						class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="unit">
				<dt>获奖时间：</dt>
				<dd>
					<input type="text" class="date" readonly="readonly" value="${rewardInfo.rewardDate }"
						name="rewardDate" /><a href="javascript:;" class="required inputDateButton">选择</a><span
						class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="unit">
				<dt>奖励等级：</dt>
				<dd>
					<select name="rewardLevel" class="required">
						<option value="0" <c:if test="${rewardInfo.rewardLevel==0 }">selected="selected"</c:if>>厅局级</option>
						<option value="1" <c:if test="${rewardInfo.rewardLevel==1 }">selected="selected"</c:if>>省部级</option>
						<option value="2" <c:if test="${rewardInfo.rewardLevel==2 }">selected="selected"</c:if>>国家级</option>
					</select>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="unit">
				<dt>奖励部门：</dt>
				<dd>
					<input type="text" name="department" value="${rewardInfo.department }" class="required" /> <span
						class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="unit">
				<dt>本人排名：</dt>
				<dd>
					<input type="text" name="rewardRanking" value="${rewardInfo.rewardRanking }" class="required digits" /> <span
						class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="unit">
				<dt>总人数：</dt>
				<dd>
					<input type="text" name="totalNumber" value="${rewardInfo.totalNumber }" class="required digits" /> <span
						class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl>
				<dt>奖励证书：</dt>
				<dd><input name="certificate" value="${rewardInfo.certificate }" type="hidden"> 
					<input name="attachment.attachmentPath" value="${attachment.attachmentPath }" type="hidden"> 
					<input class="readonly"
						name="attachment.fileName" value="" readonly="readonly"
						type="text" /> <a class="btnAttach"
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
