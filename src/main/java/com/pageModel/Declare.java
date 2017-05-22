package com.pageModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;



/**
 * 
 * @author cfl
 *
 */
@XmlRootElement(name = "declare")
public class Declare implements java.io.Serializable{


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8362910358395913087L;
	
	
	private String declareId;    //申请资料编号
	private String applicant;     //申请人（中文名）
	private Integer declareType;  //申报类别  0  杰出人才 1 领军人才 2 拔尖人才   
	private String declareUnit;    //申报单位
	private Integer declareFields;      //申报领域
	private String appPhone;           //申请人电话
	private String email;				//申请人电子信箱
	private String name_en;				//申请人英文名
	private Integer ifvalid;			//资料是否有效
	private Integer personType;			//人才类型  个人（0 培养 1 直接引进 2柔性引进）团队（0 培养团队 1 引进团队）
	private String contactPerson;		//联系人姓名
	private String contactPhone;		//联系人电话
	
	private String userName;             //数据录入人
	private Date declare_date;			//申报日期
	private String updateUser;			//数据修改人
	private Date updateDate;			//数据修改时间
	private Integer auditStatus;		//审核状态：0 未审核 1 审核中 2 审核通过 3 审核未通过
	private String auditUser;          //审核人
	private Date auditDate;			//审核时间
	
	private Integer flag;               // 0 个人申报  1 团队申报
	
	private List<DeclareBase> baseInfoList= new ArrayList<DeclareBase>() ;
	private DeclareBase  baseInfo = new DeclareBase();
	private List<Education> eduList = new ArrayList<Education>();
	private List<HonorTitleInfo> honorList = new ArrayList<HonorTitleInfo>();
	private List<PaperInfo> paperList = new ArrayList<PaperInfo>();
	private List<PersonalPatentInfo> patentList = new ArrayList<PersonalPatentInfo>();
	private List<ResearchProInfo> researchList = new ArrayList<ResearchProInfo>();
	private List<SelectedProInfo> selectedList = new ArrayList<SelectedProInfo>();
	private List<TechRewardInfo> rewardList = new ArrayList<TechRewardInfo>();
	private List<WorkHistoryInfo> workList = new ArrayList<WorkHistoryInfo>();
	private List<RelyingOrgInfo> orgList = new ArrayList<RelyingOrgInfo>();
	private TeamMemberInfo memberInfo = new TeamMemberInfo();
	private List<ResearchProInfo> researchList1 = new ArrayList<ResearchProInfo>();
	
	
	

	public List<ResearchProInfo> getResearchList1() {
		return researchList1;
	}



	public void setResearchList1(List<ResearchProInfo> researchList1) {
		this.researchList1 = researchList1;
	}



	public DeclareBase getBaseInfo() {
		return baseInfo;
	}



	public void setBaseInfo(DeclareBase baseInfo) {
		this.baseInfo = baseInfo;
	}



	public List<Education> getEduList() {
		return eduList;
	}



	public void setEduList(List<Education> eduList) {
		this.eduList = eduList;
	}



	public List<HonorTitleInfo> getHonorList() {
		return honorList;
	}



	public void setHonorList(List<HonorTitleInfo> honorList) {
		this.honorList = honorList;
	}



	public List<PaperInfo> getPaperList() {
		return paperList;
	}



	public void setPaperList(List<PaperInfo> paperList) {
		this.paperList = paperList;
	}



	public List<PersonalPatentInfo> getPatentList() {
		return patentList;
	}



	public void setPatentList(List<PersonalPatentInfo> patentList) {
		this.patentList = patentList;
	}



	public List<ResearchProInfo> getResearchList() {
		return researchList;
	}



	public void setResearchList(List<ResearchProInfo> researchList) {
		this.researchList = researchList;
	}



	public List<SelectedProInfo> getSelectedList() {
		return selectedList;
	}



	public void setSelectedList(List<SelectedProInfo> selectedList) {
		this.selectedList = selectedList;
	}



	public List<TechRewardInfo> getRewardList() {
		return rewardList;
	}



	public void setRewardList(List<TechRewardInfo> rewardList) {
		this.rewardList = rewardList;
	}



	public List<WorkHistoryInfo> getWorkList() {
		return workList;
	}



	public void setWorkList(List<WorkHistoryInfo> workList) {
		this.workList = workList;
	}



	public List<RelyingOrgInfo> getOrgList() {
		return orgList;
	}



	public void setOrgList(List<RelyingOrgInfo> orgList) {
		this.orgList = orgList;
	}



	public TeamMemberInfo getMemberInfo() {
		return memberInfo;
	}



	public void setMemberInfo(TeamMemberInfo memberInfo) {
		this.memberInfo = memberInfo;
	}



	public List<DeclareBase> getBaseInfoList() {
		return baseInfoList;
	}



	public void setBaseInfoList(List<DeclareBase> baseInfoList) {
		this.baseInfoList = baseInfoList;
	}



	public String getUpdateUser() {
		return updateUser;
	}



	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}



	public Date getUpdateDate() {
		return updateDate;
	}



	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}



	public Integer getAuditStatus() {
		return auditStatus;
	}



	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}



	public String getAuditUser() {
		return auditUser;
	}



	public void setAuditUser(String auditUser) {
		this.auditUser = auditUser;
	}



	public Date getAuditDate() {
		return auditDate;
	}



	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}



	public Integer getFlag() {
		return flag;
	}



	public void setFlag(Integer flag) {
		this.flag = flag;
	}



	public String getDeclareId() {
		return declareId;
	}



	public void setDeclareId(String declareId) {
		this.declareId = declareId;
	}



	public String getApplicant() {
		return applicant;
	}



	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}



	public Integer getDeclareType() {
		return declareType;
	}



	public void setDeclareType(Integer declareType) {
		this.declareType = declareType;
	}



	


	public String getDeclareUnit() {
		return declareUnit;
	}



	public void setDeclareUnit(String declareUnit) {
		this.declareUnit = declareUnit;
	}



	public Integer getDeclareFields() {
		return declareFields;
	}



	public void setDeclareFields(Integer declareFields) {
		this.declareFields = declareFields;
	}



	public void setDeclare_date(Date declare_date) {
		this.declare_date = declare_date;
	}



	public String getAppPhone() {
		return appPhone;
	}



	public void setAppPhone(String appPhone) {
		this.appPhone = appPhone;
	}



	



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getName_en() {
		return name_en;
	}



	public void setName_en(String name_en) {
		this.name_en = name_en;
	}



	public Date getDeclare_date() {
		return declare_date;
	}




	public Integer getIfvalid() {
		return ifvalid;
	}



	public void setIfvalid(Integer ifvalid) {
		this.ifvalid = ifvalid;
	}



	public Integer getPersonType() {
		return personType;
	}



	public void setPersonType(Integer personType) {
		this.personType = personType;
	}



	public String getContactPerson() {
		return contactPerson;
	}



	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}



	public String getContactPhone() {
		return contactPhone;
	}



	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



}
