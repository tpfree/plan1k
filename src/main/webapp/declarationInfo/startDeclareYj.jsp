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
			<dl class="nowrap">
				<input type="hidden" name="flag" value="0" />
				<dt>申报人：</dt>
				<dd>
					<input class="required" name="applicant" type="text" value="${declare.applicant }"
						postField="keyword" /> <span class="info">中文姓名</span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>申报人：</dt>
				<dd>
					<input type="text" name="name_en" class="required lettersonly" value="${declare.name_en }"
						placeholder="请输入英文名" /> <span class="info">英文姓名</span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>申报类别：</dt>
				<dd>
					<input type="radio" name="declareType" value="0" <c:if test="${declare.declareType==0 }">checked</c:if> />杰出人才 <input
						type="radio" name="declareType" value="1" <c:if test="${declare.declareType==1 }">checked</c:if>/>领军人才 <input
						type="radio" name="declareType" value="2" <c:if test="${declare.declareType==2 }">checked</c:if>/>拔尖人才
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>引进形式：</dt>
				<dd>
					<input type="radio" name="personType" value="1"  <c:if test="${declare.personType==1 }">checked</c:if>  />直接引进 <input
						type="radio" name="personType" value="2"  <c:if test="${declare.personType==2 }">checked</c:if> />柔性引进
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>申报领域：</dt>
				<dd>
					<select class="required" name="declareFields">
						<option value="0">-请选择-</option>
						<option value="1" <c:if test="${declare.declareFields==1 }">checked</c:if> >生态环保</option>
						<option value="2" <c:if test="${declare.declareFields==2 }">checked</c:if>>企业技术</option>
						<option value="3" <c:if test="${declare.declareFields==3 }">checked</c:if>>企业管理</option>
						<option value="4" <c:if test="${declare.declareFields==4 }">checked</c:if>>创业</option>
						<option value="5" <c:if test="${declare.declareFields==5 }">checked</c:if>>科技创新</option>
						<option value="6" <c:if test="${declare.declareFields==6 }">checked</c:if>>社会科学</option>
						<option value="7" <c:if test="${declare.declareFields==7 }">checked</c:if>>医疗卫生</option>
						<option value="8" <c:if test="${declare.declareFields==8 }">checked</c:if>>文化艺术</option>
						<option value="9" <c:if test="${declare.declareFields==9 }">checked</c:if>>农林技术推广</option>
						<option value="10" <c:if test="${declare.declareFields==10 }">checked</c:if>>社会工作</option>
						<option value="11" <c:if test="${declare.declareFields==11 }">checked</c:if>>其他</option>
					</select>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>申报单位：</dt>
				<dd>
					<select name="declareUnit">
						<option value="">-请选择-</option>
						<c:forEach var="item" items="${unitList}">
							<option value="${item.id }" <c:if test="${declare.declareUnit==item.id }">checked</c:if>>${item.name }</option>
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
					<input type="text" name="appPhone" value="${declare.appPhone}" class="required phone" maxlength="11"/> <span
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
