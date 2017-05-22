<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<h2 class="contentTitle">团队负责人基本信息</h2>
<form method="post"
	action="<c:url value='baseInfoController.do?insert&callbackType=forward&navTabId=jyjl'/>"
	class="pageForm required-validate"
	onsubmit="return validateCallback(this,navTabAjaxDone)">

	<div class="pageContent">
		<div class="pageFormContent" layoutH="97">
			<dl>
				<dt>中文姓名：</dt><input type="hidden" name="flag" value="1"/>
				<dd>
					<input type="text" name="name_zh" class="required"
						placeholder="请输入中文名" /> <span class="info"></span>
				</dd>
			</dl>
			<dl>
				<dt>英文姓名：</dt>
				<dd>
					<input type="text" name="name_en" class="required lettersonly"
						placeholder="请输入英文名" /> <span class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl>
				<dt>性别：</dt>
				<dd>
					<input type="radio" name="sex" value="0" checked />女 <input
						type="radio" name="sex" value="1" />男
				</dd>
			</dl>
			<dl>
				<dt>民族：</dt>
				<dd>
					<input type="text" name="nation" class="required" /> <span
						class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl>
				<dt>出生日期：</dt>
				<dd>
					<input type="text" class="date" readonly="readonly" name="birthday" /><a
						class="inputDateButton" href="javascript:;">选择</a> <span
						class="info"></span>
				</dd>
			</dl>
			<dl>
				<dt>出生地：</dt>
				<dd>
					<input type="text" name="birth_addr" class="required" /><span
						class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl>
				<dt>身份证号：</dt>
				<dd>
					<input type="text" name="ID_number" /> <span class="info"></span>
				</dd>
			</dl>
			<dl>
				<dt>护照号：</dt>
				<dd>
					<input type="text" name="passport_number" /> <span class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl>
				<dt>国籍/籍贯：</dt>
				<dd>
					<input type="text" name="nationality_origin" /> <span class="info"></span>
				</dd>
			</dl>
			<dl>
				<dt>政治面貌：</dt>
				<dd>
					<input type="text" name="political_status" /> <span class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl>
				<dt>毕业院校（中文）：</dt>
				<dd>
					<input type="text" name="graduated_school_zh" /> <span
						class="info"></span>
				</dd>
			</dl>
			<dl>
				<dt>毕业院校（英文）：</dt>
				<dd>
					<input type="text" name="graduated_school_en" /> <span
						class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl>
				<dt>所学专业（中文）：</dt>
				<dd>
					<input type="text" name="profession_zh" /> <span class="info"></span>
				</dd>
			</dl>
			<dl>
				<dt>所学专业（英文）：</dt>
				<dd>
					<input type="text" name="profession_en" /> <span class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl>
				<dt>获得学位（中文）：</dt>
				<dd>
					<input type="text" name="educational_level_zh" /> <span
						class="info"></span>
				</dd>
			</dl>
			<dl>
				<dt>获得学位（英文）：</dt>
				<dd>
					<input type="text" name="educational_level_en" /> <span
						class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl>
				<dt>工作单位：</dt>
				<dd>
					<input type="text" name="unit_cur" /> <span class="info"></span>
				</dd>
			</dl>
			<dl>
				<dt>担任职务：</dt>
				<dd>
					<input type="text" name="position_cur" /> <span class="info"></span>
				</dd>
			</dl>

			<div class="divider"></div>
			<dl>
				<dt>工作单位地址：</dt>
				<dd>
					<input type="text" name="unit_add_cur" /> <span class="info"></span>
				</dd>
			</dl>
			<dl>
				<dt>从事专业：</dt>
				<dd>
					<input type="text" name="profession_do" /> <span class="info"></span>
				</dd>
			</dl>
			<div class="divider"></div>
			<dl>
				<dt>专业职称：</dt>
				<dd>
					<input type="text" name="profession_title" /> <span class="info"></span>
				</dd>
			</dl>
			<dl>
				<dt>邮政编码：</dt>
				<dd>
					<input type="text" name="zip_code" maxlength="7" /> <span
						class="info"></span>
				</dd>
			</dl>

			<div class="divider"></div>
			<dl>
				<dt>个人照片：</dt>
				<dd>
					<input name="attachment.id" value="${attachment.fileName }"
						type="hidden"> <input class="readonly"
						name="attachment.fileName" value="" readonly="readonly"
						type="text" /> <a class="btnAttach"
						href="declarationInfo/uploadFile.jsp" lookupGroup="attachment"
						width="560" height="300" title="附件">附件</a>
				</dd>
			</dl>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="submit" style="width:80px">下&nbsp;&nbsp;一&nbsp;&nbsp;步</button>
						</div>
					</div></li>
				
			</ul>
		</div>

	</div>
</form>
