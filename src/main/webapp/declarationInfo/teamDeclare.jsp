<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<script type="text/javascript">
	
</script>
<h2 class="contentTitle">申报基本信息</h2>
<form method="post"
	action="<c:url value='declarationInfo.do?delcare&callbackType=forward&navTabId=jczl'/>"
	class="pageForm required-validate"
	onsubmit="return validateCallback(this,navTabAjaxDone)">
	<div class="pageContent">
		<div class="pageFormContent" layoutH="97">
			<dl class="nowrap"><input type="hidden" name="flag" value="1" />
				<dt>团队名称：</dt>
				<dd><input type="hidden" name="declareId" value="${declare.declareId }" />
					<input class="required" name="applicant" type="text" value="${declare.applicant }"
						postField="keyword" /> <span class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>申报类别：</dt>
				<dd>
					<input type="radio" name="declareType" value="1" <c:if test="${declare.declareType==1 }">checked</c:if>/>引进团队 <input
						type="radio" name="declareType" value="2" <c:if test="${declare.declareType==2 }">checked</c:if>/>培养团队
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>申报领域：</dt>
				<dd>
					<select class="required" name="declareFields" class="required" >
						<option value="">-请选择-</option>
						<option value="1" <c:if test="${declare.declareFields==1 }">selected</c:if>>科技创新</option>
						<option value="2" <c:if test="${declare.declareFields==2 }">selected</c:if>>产业发展</option>
						<option value="3" <c:if test="${declare.declareFields==3 }">selected</c:if>>企业管理</option>
						<option value="4" <c:if test="${declare.declareFields==4 }">selected</c:if>>生态环保</option>
						<option value="5" <c:if test="${declare.declareFields==5 }">selected</c:if>>技术推广应用</option>
						<option value="6" <c:if test="${declare.declareFields==6 }">selected</c:if>>创业</option>
						<option value="7" <c:if test="${declare.declareFields==7 }">selected</c:if>>社会科学</option>
						<option value="8" <c:if test="${declare.declareFields==8 }">selected</c:if>>文化艺术</option>
						<option value="9" <c:if test="${declare.declareFields==9 }">selected</c:if>>其他</option>
					</select>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>申报单位：</dt>
				<dd>
					<select name="declareUnit" width="40px" class="required" >
						<option value="">-请选择-</option>
						<c:forEach var="item" items="${unitList}">
							<option value="${item.id }" <c:if test="${declare.declareUnit==item.id }">selected</c:if>>${item.name }</option>
						</c:forEach>
					</select>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>电子信箱：</dt>
				<dd>
					<input type="text" name="email" value="${declare.email}" class="required email" />
					<span class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>申报人电话：</dt>
				<dd>
					<input type="text" name="appPhone"  value="${declare.appPhone}" class="required phone" maxlength="11"/> <span
						class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>联系人：</dt>
				<dd>
					<input type="text" name="contactPerson" value="${declare.contactPerson}" class="required" /> <span
						class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>联系人电话：</dt>
				<dd>
					<input type="text" name="contactPhone" value="${declare.contactPhone}" class="required phone"
						maxlength="11" /> <span class="info"></span>
				</dd>
			</dl>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive" >
						<div class="buttonContent" >
							<button type="submit" style="width:80px">下&nbsp;&nbsp;一&nbsp;&nbsp;步</button>
						</div>
					</div></li>
			</ul>
		</div>
	</div>
</form>
