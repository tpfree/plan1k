<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<h2 class="contentTitle">申报基本信息</h2>
<form method="post"
	action="<c:url value='baseInfoController.do?insert&callbackType=forward&navTabId=jyjl'/>"
	class="pageForm required-validate"
	onsubmit="return validateCallback(this,navTabAjaxDone)">

	<div class="pageContent">
		<div class="pageFormContent" layoutH="97">
			<dl>
				<dt>中文姓名：</dt>
				<input type="hidden" name="flag" value="0" />
				<dd>
					<input type="text" name="name_zh" class="required" value="${baseInfo.name_zh }"
						placeholder="请输入中文名" /> <span class="info"></span>
				</dd>
			</dl>
			<dl>
				<dt>英文姓名：</dt>
				<dd>
					<input type="text" name="name_en" class="required lettersonly" value="${baseInfo.name_en }"
						placeholder="请输入英文名" /> <span class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl>
				<dt>性别：</dt>
				<dd>
					<input type="radio" name="sex" value="0"  <c:if test="${baseInfo.sex==0 }">checked</c:if> />女 <input
						type="radio" name="sex" value="1" <c:if test="${baseInfo.sex==1 }">checked</c:if>/>男
				</dd>
			</dl>
			<dl>
				<dt>民族：</dt>
				<dd>
					<input type="text" name="nation" value="${baseInfo.nation }" class="required" /> <span
						class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl>
				<dt>出生日期：</dt>
				<dd>
					<input type="text" class="date" readonly="readonly" value="${baseInfo.birthday }" name="birthday" /><a
						class="inputDateButton" href="javascript:;">选择</a> <span
						class="info"></span>
				</dd>
			</dl>
			<dl>
				<dt>出生地：</dt>
				<dd>
					<input type="text" name="birth_addr" value="${baseInfo.birth_addr }" class="required" /><span
						class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl>
				<dt>身份证号：</dt>
				<dd>
					<input type="text" name="ID_number" value="${baseInfo.ID_number }"/> <span class="info"></span>
				</dd>
			</dl>
			<dl>
				<dt>护照号：</dt>
				<dd>
					<input type="text" name="passport_number" value="${baseInfo.passport_number }" /> <span class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl>
				<dt>国籍/籍贯：</dt>
				<dd>
					<input type="text" name="nationality_origin" value="${baseInfo.nationality_origin }" /> <span class="info"></span>
				</dd>
			</dl>
			<dl>
				<dt>政治面貌：</dt>
				<dd>
					<input type="text" name="political_status" value="${baseInfo.political_status }"/> <span class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl>
				<dt>毕业院校（中文）：</dt>
				<dd>
					<input type="text" name="graduated_school_zh" value="${baseInfo.graduated_school_zh }"/> <span
						class="info"></span>
				</dd>
			</dl>
			<dl>
				<dt>毕业院校（英文）：</dt>
				<dd>
					<input type="text" name="graduated_school_en" class="lettersonly" value="${baseInfo.graduated_school_en }"/> <span
						class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl>
				<dt>所学专业（中文）：</dt>
				<dd>
					<input type="text" name="profession_zh" value="${baseInfo.profession_zh }"/> <span class="info"></span>
				</dd>
			</dl>
			<dl>
				<dt>所学专业（英文）：</dt>
				<dd>
					<input type="text" name="profession_en" class="lettersonly" value="${baseInfo.profession_en }"/> <span class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl>
				<dt>获得学位（中文）：</dt>
				<dd>
					<input type="text" name="educational_level_zh" value="${baseInfo.educational_level_zh }"/> <span
						class="info"></span>
				</dd>
			</dl>
			<dl>
				<dt>获得学位（英文）：</dt>
				<dd>
					<input type="text" name="educational_level_en" class="lettersonly" value="${baseInfo.educational_level_en }"/> <span
						class="info"></span>
				</dd>
			</dl>
			<c:if test="${type==0 }">
				<div class="divider"></div>
				<dl>
					<dt>前工作单位：</dt>
					<dd>
						<input type="text" name="unit_pre" value="${baseInfo.unit_pre }"/> <span class="info"></span>
					</dd>
				</dl>
				<dl>
					<dt>担任职务：</dt>
					<dd>
						<input type="text" name="position_pre" value="${baseInfo.position_pre }"/> <span class="info"></span>
					</dd>
				</dl>
			</c:if>
			<div class="divider"></div>
			<dl>
				<dt>现工作单位：</dt>
				<dd>
					<input type="text" name="unit_cur" value="${baseInfo.unit_cur }"/> <span class="info"></span>
				</dd>
			</dl>
			<dl>
				<dt>现担任职务：</dt>
				<dd>
					<input type="text" name="position_cur" value="${baseInfo.position_cur }"/> <span class="info"></span>
				</dd>
			</dl>

			<div class="divider"></div>
			<dl>
				<dt>现工作单位地址：</dt>
				<dd>
					<input type="text" name="unit_add_cur"value="${baseInfo.unit_add_cur }" /> <span class="info"></span>
				</dd>
			</dl>
			<dl>
				<dt>从事专业：</dt>
				<dd>
					<input type="text" name="profession_do" value="${baseInfo.profession_do }"/> <span class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl>
				<dt>专业职称：</dt>
				<dd>
					<input type="text" name="profession_title" value="${baseInfo.profession_title }"/> <span class="info"></span>
				</dd>
			</dl>
			<dl>
				<dt>邮政编码：</dt>
				<dd>
					<input type="text" name="zip_code" maxlength="7" value="${baseInfo.zip_code }"/> <span
						class="info"></span>
				</dd>
			</dl>

			<div class="divider"></div>
			<dl>
				<dt>个人照片：</dt>
				<dd>
					<input name="attachment.id" value="${attachment.fileName }"
						type="hidden"> <input class="readonly"
						name="attachment.fileName"  readonly="readonly"
						type="text" /> <a class="btnAttach"
						href="declarationInfo/uploadFile.jsp" lookupGroup="attachment"
						width="560" height="300" title="附件">附件</a>
				</dd>
			</dl>
		</div>
		<div class="formBar">
			<ul>
			<li><div class="button">
				<div class="buttonContent"
					style="width:70px;padding-top:6px;padding-left:15px;">
					<a href="<c:url value='declarationInfo.do?getInfo'/>"
						style="text-decoration:none;" target="navTab" title="个人申报"
						rel="pyrcsb">上&nbsp;&nbsp;一&nbsp;&nbsp;步</a>
				</div>
			</div></li>
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="submit" style="width:80px">下&nbsp;&nbsp;一&nbsp;&nbsp;步</button>
						</div>
					</div></li>

			</ul>
		</div>
	</div>
</form>
