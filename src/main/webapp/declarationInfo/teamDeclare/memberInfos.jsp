<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<h2 class="contentTitle">团队成员信息</h2>
<form action="<c:url value='declarationInfo.do?addmembers&callbackType=forward'/>" method="post" class="pageForm required-validate"
	onsubmit="return validateCallback(this, navTabAjaxDone)">
	<div class="pageContent">
		<div class="pageFormContent" layoutH="97">
			<fieldset>
				<legend>职称情况</legend>
				<dl>
					<dt>正高级职称人员：</dt>
					<dd>
						<input name="seniorTitleNum" type="text" class="required digits" value="${membersInfo.seniorTitleNum }"/>
					</dd>
				</dl>
				<dl>
					<dt>副高级职称人员：</dt>
					<dd>
						<input name="viceSeniorTitleNum" type="text" class="required digits" value="${membersInfo.viceSeniorTitleNum }"/>
					</dd>
				</dl>
				<dl>
					<dt>中级职称人员：</dt>
					<dd>
						<input name="intermediateTitlNum" type="text" class="required digits" value="${membersInfo.intermediateTitlNum }"/>
					</dd>
				</dl>
				<dl>
					<dt>中级职称以下人员：</dt>
					<dd>
						<input name="belowIntermediateNum" type="text" class="required digits" value="${membersInfo.belowIntermediateNum }"/>
					</dd>
				</dl>
				<dl>
					<dt>小计：</dt>
					<dd>
						<input name="titleSubtotal" type="text" class="required digits" value="${membersInfo.titleSubtotal }"/>
					</dd>
				</dl>
			</fieldset>

			<fieldset>
				<legend>学历学位情况</legend>
				<dl>
					<dt>博士人员：</dt>
					<dd>
						<input name="doctorMum" type="text" class="required digits" value="${membersInfo.doctorMum }"/>
					</dd>
				</dl>
				<dl>
					<dt>硕士人员：</dt>
					<dd>
						<input name="masterNum" type="text" class="required digits" value="${membersInfo.masterNum }"/>
					</dd>
				</dl>
				<dl>
					<dt>学士人员：</dt>
					<dd>
						<input name="bacheloNum" type="text" class="required digits" value="${membersInfo.bacheloNum }"/>
					</dd>
				</dl>
				<dl>
					<dt>大专以下人员：</dt>
					<dd>
						<input name="juniorCollegeNun" type="text" class="required" value="${membersInfo.juniorCollegeNun }"/>
					</dd>
				</dl>
				<dl>
					<dt>小计：</dt>
					<dd>
						<input name="eudSubtotal" type="text" class="required digits" value="${membersInfo.eudSubtotal }"/>
					</dd>
				</dl>
			</fieldset>
			<div class="divider"></div>
			<h3 class="contentTitle">团队成员</h3>

			<div class="tabsContent" style="height: 150px;">
				<div>
					<table class="list nowrap itemDetail" addButton="增加成员" width="100%">
						<thead>
							<tr>
								<th type="text" name="baseInfoList[#index#].name_zh" class="required">姓名</th>
								<th type="date" name="baseInfoList[#index#].birthday" class="required">出生年月</th>
								<th type="text" name="baseInfoList[#index#].educational_level_zh" class="required">学历学位</th>
								<th type="text" name="baseInfoList[#index#].political_status" class="required">政治面貌</th>
								<th type="text" name="baseInfoList[#index#].profession_title" class="required">职务职称</th>
								<th type="text" name="baseInfoList[#index#].graduated_school_zh" class="required">毕业院校</th>
								<th type="text" name="baseInfoList[#index#].profession_zh" class="required">专业</th>
								<th type="del" width="60">操作</th>
							</tr>
						</thead>
						<tbody>
						<c:choose>
						<c:when test="${listInfo ==null }">
							<tr class="unitBox">
								<td><input type="text" name="baseInfoList[0].name_zh" value=""></td>
								<td><input type="text" name="baseInfoList[0].birthday" class="date  textInput" datefmt="yyyy-MM-dd">
									<a class="inputDateButton" href="javascript:void(0)">选择</a></td>
								<td><input type="text" name="baseInfoList[0].educational_level_zh" value=""></td>
								<td><input type="text" name="baseInfoList[0].political_status" value=""></td>
								<td><input type="text" name="baseInfoList[0].profession_title" value=""></td>
								<td><input type="text" name="baseInfoList[0].graduated_school_zh" value=""></td>
								<td><input type="text" name="baseInfoList[0].profession_zh" value=""></td>
								<td><a href="javascript:void(0)" class="btnDel ">删除</a></td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach items="${listInfo}" var="infoList" varStatus="info">
							<tr class="unitBox">
								<td><input type="text" name="baseInfoList[${info.index}].name_zh" value="${infoList.name_zh }"></td>
								<td><input type="text" name="baseInfoList[${info.index}].birthday" value="${infoList.birthday }" class="date  textInput" datefmt="yyyy-MM-dd">
									<a class="inputDateButton" href="javascript:void(0)">选择</a></td>
								<td><input type="text" name="baseInfoList[${info.index}].educational_level_zh" value="${infoList.educational_level_zh }"></td>
								<td><input type="text" name="baseInfoList[${info.index}].political_status" value="${infoList.political_status }"></td>
								<td><input type="text" name="baseInfoList[${info.index}].profession_title" value="${infoList.profession_title }"></td>
								<td><input type="text" name="baseInfoList[${info.index}].graduated_school_zh" value="${infoList.graduated_school_zh }"></td>
								<td><input type="text" name="baseInfoList[${info.index}].profession_zh" value="${infoList.profession_zh }"></td>
								<td><a href="javascript:void(0)" class="btnDel ">删除</a></td>
							</tr>
							</c:forEach>
						</c:otherwise>
						</c:choose>
						</tbody>
					</table>
				</div>
			</div>
			<div class="tabsFooter">
				<div class="tabsFooterContent"></div>
			</div>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="button">
				<div class="buttonContent"
					style="width:70px;padding-top:6px;padding-left:15px;">
					<a href="<c:url value='baseInfoController.do?baseList'/>"
						style="text-decoration:none;" target="navTab" title="团队负责人及核心成员信息列表"
						rel="pyrcsb">上&nbsp;&nbsp;一&nbsp;&nbsp;步</a>
				</div>
			</div></li>
				<li><div class="buttonActive" style="width:70px">
						<div class="buttonContent">
							<button type="submit">下&nbsp;&nbsp;一&nbsp;&nbsp;步</button>
						</div>
					</div></li>
			</ul>
		</div>

	</div>
</form>
