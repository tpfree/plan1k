<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<h2 class="contentTitle">个人申报资料信息详情</h2>
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<fieldset>
			<legend>基础资料</legend>
			<dl>
				<dt>申报人：</dt>
				<dd>${declare.applicant }/ ${declare.name_en }</dd>
			</dl>
			<dl>
				<dt>申报类别：</dt>
				<dd>
					<c:if test="${declare.declareType==0 }">杰出人才</c:if>
					<c:if test="${declare.declareType==1 }">领军人才</c:if>
					<c:if test="${declare.declareType==2 }">拔尖人才</c:if>
				</dd>
			</dl>
			<dl>
				<dt>申报领域：</dt>
				<dd>
					<c:if test="${declare.declareFields==1 }">生态环保</c:if>
					<c:if test="${declare.declareFields==2 }">企业技术</c:if>
					<c:if test="${declare.declareFields==3 }">企业管理</c:if>
					<c:if test="${declare.declareFields==4 }">创业</c:if>
					<c:if test="${declare.declareFields==5 }">科技创新</c:if>
					<c:if test="${declare.declareFields==6 }">社会科学</c:if>
					<c:if test="${declare.declareFields==7 }">医疗卫生</c:if>
					<c:if test="${declare.declareFields==8 }">文化艺术</c:if>
					<c:if test="${declare.declareFields==9 }">农林技术推广</c:if>
					<c:if test="${declare.declareFields==10 }">社会工作</c:if>
					<c:if test="${declare.declareFields==11 }">其他</c:if>
				</dd>
			</dl>
			<dl>
				<dt>申报单位：</dt>
				<dd>
					<c:if test="${declare.declareUnit==item.id }">${item.name }</c:if>
				</dd>
			</dl>
			<dl>
				<dt>电子信箱：</dt>
				<dd>${declare.email}</dd>
			</dl>
			<dl>
				<dt>申报人电话：</dt>
				<dd>${declare.appPhone}</dd>
			</dl>
			<dl>
				<dt>联系人：</dt>
				<dd>${declare.contactPerson}</dd>
			</dl>
			<dl>
				<dt>联系人电话：</dt>
				<dd>${declare.contactPhone}</dd>
			</dl>
		</fieldset>

		<fieldset>
			<legend>个人基本信息</legend>
			<dl>
				<dt>姓名：</dt>
				<dd>${baseInfo.name_zh }/ ${baseInfo.name_en }</dd>
			</dl>
		</fieldset>
		<div class="divider"></div>
		<h3 class="contentTitle"></h3>
		<div class="tabs">
			<div class="tabsHeader">
				<div class="tabsHeaderContent">
					<ul>
						<li class="selected"><a href="javascript:void(0)"><span>教育经历</span></a></li>
						<li><a href="javascript:void(0)"><span>工作经历</span></a></li>
						<li><a href="javascript:void(0)"><span>入选人才计划或工程</span></a></li>
						<li><a href="javascript:void(0)"><span>代表性研究项目</span></a></li>
						<li><a href="javascript:void(0)"><span>代表性个人论著</span></a></li>
						<li><a href="javascript:void(0)"><span>获得科技奖励</span></a></li>
						<li><a href="javascript:void(0)"><span>获得科技荣誉</span></a></li>
						<li><a href="javascript:void(0)"><span>个人专利</span></a></li>
					</ul>
				</div>
			</div>
			<div class="tabsContent" style="height: 150px;">
				<div>
					<table class="list nowrap itemDetail" width="100%">
						<thead>
							<tr>
								<th width="50px"></th>
								<th width="200px">时间</th>
								<th>国家</th>
								<th>院校</th>
								<th>专业</th>
								<th>学位</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${eduList}" varStatus="s">
								<tr target="slt_eduId" rel="${item.eduId }">
									<td algin="center">${s.index + 1}</td>
									<td algin="center">${item.startDate}<span>——</span>${item.endDate}</td>
									<td algin="center">${item.country }</td>
									<td algin="center">${item.school }</td>
									<td algin="center">${item.profession }</td>
									<td algin="center">${item.degree }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div>
					<table class="list nowrap itemDetail" width="100%">
						<thead>
							<tr>
								<th width="50px"></th>
								<th width="200px">时间</th>
								<th>单位</th>
								<th>职位</th>
								<th>国家</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${ workList}" varStatus="s">
								<tr target="slt_eduId" rel="${item.historyId }">
									<td algin="center">${s.index + 1}</td>
									<td algin="center">${item.startDate}<span>——</span>${item.endDate}</td>
									<td algin="center">${item.workUnit }</td>
									<td algin="center">${item.position }</td>
									<td algin="center">${item.country }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div>
					<table class="list nowrap itemDetail" width="100%">
						<thead>
							<th width="50px"></th>
							<th>项目名称</th>
							<th>起止时间</th>
							<th>项目性质</th>
							<th>项目来源</th>
							<th>经费总额</th>
							<th>参与人数</th>
							<th>申报人具体位置</th>
							<th>申报人具体任务</th>
							<th>项目进展情况</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${ researchList}" varStatus="s">
								<tr target="slt_eduId" rel="${item.proId }">
									<td algin="center">${s.index + 1}</td>
									<td algin="center">${item.proName }</td>
									<td algin="center">${item.startDate}<span>——</span>${item.endDate}</td>
									<td algin="center">${item.proNature }</td>
									<td algin="center">${item.proSource }</td>
									<td algin="center">${item.totalAmonut }</td>
									<td algin="center">${item.peopleNumber }</td>
									<td algin="center">${item.specificPosition }</td>
									<td algin="center">${item.specificTask }</td>
									<td algin="center">${item.proProgress }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div>
					<table class="list nowrap itemDetail" width="100%">
						<thead>
							<tr>
								<th width="50px"></th>
								<th>发表时间</th>
								<th>论著名称</th>
								<th>发表载体</th>
								<th>论著作者</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${ paperList}" varStatus="s">
								<tr target="slt_eduId" rel="${item.paperId }">
									<td algin="center">${s.index + 1}</td>
									<td algin="center">${item.publishedDate}</td>
									<td algin="center">${item.paperName }</td>
									<td algin="center">${item.publishedVector }</td>
									<td algin="center">${item.paperAuthor }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div>
					<table class="list nowrap itemDetail" width="100%">
						<thead>
							<tr>
								<th width="50px"></th>
								<th>奖励名称</th>
								<th>奖励编号</th>
								<th>奖励部门</th>
								<th>奖励等级</th>
								<th>本人排名</th>
								<th>总人数</th>
								<th>获奖时间</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${rewardList}" varStatus="s">
								<tr target="slt_eduId" rel="${item.rewardId }">
									<td algin="center">${s.index + 1}</td>
									<td algin="center">${item.rewardName}</td>
									<td algin="center">${item.rewardNumber }</td>
									<td algin="center">${item.department }</td>
									<td algin="center"><c:if test="${item.rewardLevel==0 }">厅局级</c:if>
										<c:if test="${item.rewardLevel==1 }">省部级</c:if> <c:if
											test="${item.rewardLevel==2 }">国家级</c:if></td>
									<td algin="center">${item.rewardRanking }</td>
									<td algin="center">${item.totalNumber }</td>
									<td algin="center">${item.rewardDate }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div>
					<table class="list nowrap itemDetail" width="100%">
						<thead>
							<tr>
								<th width="50px"></th>
								<th>荣誉名称</th>
								<th>获奖时间</th>
								<th>颁发部门</th>
								<th>荣誉等级</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${ honorList}" varStatus="s">
								<tr target="slt_eduId" rel="${item.honorId }">
									<td algin="center">${s.index + 1}</td>
									<td algin="center">${item.honorName}</td>
									<td algin="center">${item.honorDate }</td>
									<td algin="center">${item.department }</td>
									<td algin="center"><c:if test="${item.honorlevel==0 }">厅局级</c:if>
										<c:if test="${item.honorlevel==1 }">省部级</c:if> <c:if
											test="${item.honorlevel==2 }">国家级</c:if></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div>
					<table class="list nowrap itemDetail" width="100%">
						<thead>
							<tr>
								<th width="50px"></th>
								<th>专利保护期</th>
								<th>专利名称</th>
								<th>专利类型</th>
								<th>授权国家</th>
								<th>专利所有者</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${ patentList}" varStatus="s">
								<tr target="slt_eduId" rel="${item.patentId }">
									<td algin="center">${s.index + 1}</td>
									<td algin="center">${item.protectPeriod}</td>
									<td algin="center">${item.patentName }</td>
									<td algin="center"><c:if test="${item.patentType==0 }">发明</c:if>
										<c:if test="${item.patentType==1 }">实用新型</c:if> <c:if
											test="${item.patentType==2 }">外观设计</c:if></td>
									<td algin="center">${item.authorizedCountry }</td>
									<td algin="center">${item.patentOwner }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<div class="tabsFooter">
				<div class="tabsFooterContent"></div>
			</div>
		</div>
	</div>
	<div class="formBar">
		<ul>
			<li><div class="button">
					<div class="buttonContent"
						style="width:70px;padding-top:6px;padding-left:15px;">
						<a href="<c:url value='baseInfoController.do?baseList'/>"
							style="text-decoration:none;" target="navTab"
							title="团队负责人及核心成员信息列表" rel="pyrcsb">生成word文档</a>
					</div>
				</div></li>
		</ul>
	</div>

</div>