package com.pageModel;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * 申请人基本资料信息
 * @author cfl
 *
 */
@XmlRootElement(name = "baseInfo")
public class DeclareBase implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String base_id;
	private String declare_id;
	private String name_zh;
	private String name_en;
	private Integer sex;
	private String nation;
	private String birthday;
	private String birth_addr;
	private String ID_number;
	private String passport_number;
	private String nationality_origin;
	private String political_status;
	private String graduated_school_zh;
	private String graduated_school_en;
	private String profession_zh;
	private String profession_en;
	private String educational_level_zh;
	private String educational_level_en;
	private String unit_pre;
	private String position_pre;
	private String unit_cur;
	private String position_cur;
	private String unit_add_cur;
	private String zip_code;
	private String profession_do;
	private String profession_title;
	private String academic_parttime_info;
	private String outcome_trans_info;
	private String personal_job_profile;
	private String personal_work_plan;
	private String intellectual_rights_owner;
	private String declare_situation;
	private String if_sign_agreement_other;
	private String unit_introduction;
	private String unit_recommend_reason;
	private String unit_working_arrange;
	private String unit_support_conditions;
	private String organizer_audit_opinion;
	private String organizer_recommend_reasion;
	private String organizer_support_conditions;
	private Integer ifvalid;
	private Integer statue;
	private String personal_photo;
	private Integer flag;
	
	
	
	
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	private AjaxDone attachment=new AjaxDone(); 
	
	
	public AjaxDone getAttachment() {
		return attachment;
	}
	public void setAttachment(AjaxDone attachment) {
		this.attachment = attachment;
	}
	public String getPersonal_photo() {
		return personal_photo;
	}
	public void setPersonal_photo(String personal_photo) {
		this.personal_photo = personal_photo;
	}
	
	
	public String getBase_id() {
		return base_id;
	}
	public void setBase_id(String base_id) {
		this.base_id = base_id;
	}
	public String getDeclare_id() {
		return declare_id;
	}
	public void setDeclare_id(String declare_id) {
		this.declare_id = declare_id;
	}
	public String getName_zh() {
		return name_zh;
	}
	public void setName_zh(String name_zh) {
		this.name_zh = name_zh;
	}
	public String getName_en() {
		return name_en;
	}
	public void setName_en(String name_en) {
		this.name_en = name_en;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getBirth_addr() {
		return birth_addr;
	}
	public void setBirth_addr(String birth_addr) {
		this.birth_addr = birth_addr;
	}
	public String getID_number() {
		return ID_number;
	}
	public void setID_number(String iD_number) {
		ID_number = iD_number;
	}
	public String getPassport_number() {
		return passport_number;
	}
	public void setPassport_number(String passport_number) {
		this.passport_number = passport_number;
	}
	public String getNationality_origin() {
		return nationality_origin;
	}
	public void setNationality_origin(String nationality_origin) {
		this.nationality_origin = nationality_origin;
	}
	public String getPolitical_status() {
		return political_status;
	}
	public void setPolitical_status(String political_status) {
		this.political_status = political_status;
	}
	public String getGraduated_school_zh() {
		return graduated_school_zh;
	}
	public void setGraduated_school_zh(String graduated_school_zh) {
		this.graduated_school_zh = graduated_school_zh;
	}
	public String getGraduated_school_en() {
		return graduated_school_en;
	}
	public void setGraduated_school_en(String graduated_school_en) {
		this.graduated_school_en = graduated_school_en;
	}
	public String getProfession_zh() {
		return profession_zh;
	}
	public void setProfession_zh(String profession_zh) {
		this.profession_zh = profession_zh;
	}
	public String getProfession_en() {
		return profession_en;
	}
	public void setProfession_en(String profession_en) {
		this.profession_en = profession_en;
	}
	public String getEducational_level_zh() {
		return educational_level_zh;
	}
	public void setEducational_level_zh(String educational_level_zh) {
		this.educational_level_zh = educational_level_zh;
	}
	public String getEducational_level_en() {
		return educational_level_en;
	}
	public void setEducational_level_en(String educational_level_en) {
		this.educational_level_en = educational_level_en;
	}
	public String getUnit_pre() {
		return unit_pre;
	}
	public void setUnit_pre(String unit_pre) {
		this.unit_pre = unit_pre;
	}
	public String getPosition_pre() {
		return position_pre;
	}
	public void setPosition_pre(String position_pre) {
		this.position_pre = position_pre;
	}
	public String getUnit_cur() {
		return unit_cur;
	}
	public void setUnit_cur(String unit_cur) {
		this.unit_cur = unit_cur;
	}
	public String getPosition_cur() {
		return position_cur;
	}
	public void setPosition_cur(String position_cur) {
		this.position_cur = position_cur;
	}
	public String getUnit_add_cur() {
		return unit_add_cur;
	}
	public void setUnit_add_cur(String unit_add_cur) {
		this.unit_add_cur = unit_add_cur;
	}
	public String getZip_code() {
		return zip_code;
	}
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	public String getProfession_do() {
		return profession_do;
	}
	public void setProfession_do(String profession_do) {
		this.profession_do = profession_do;
	}
	public String getProfession_title() {
		return profession_title;
	}
	public void setProfession_title(String profession_title) {
		this.profession_title = profession_title;
	}
	public String getAcademic_parttime_info() {
		return academic_parttime_info;
	}
	public void setAcademic_parttime_info(String academic_parttime_info) {
		this.academic_parttime_info = academic_parttime_info;
	}
	public String getOutcome_trans_info() {
		return outcome_trans_info;
	}
	public void setOutcome_trans_info(String outcome_trans_info) {
		this.outcome_trans_info = outcome_trans_info;
	}
	public String getPersonal_job_profile() {
		return personal_job_profile;
	}
	public void setPersonal_job_profile(String personal_job_profile) {
		this.personal_job_profile = personal_job_profile;
	}
	public String getPersonal_work_plan() {
		return personal_work_plan;
	}
	public void setPersonal_work_plan(String personal_work_plan) {
		this.personal_work_plan = personal_work_plan;
	}
	public String getIntellectual_rights_owner() {
		return intellectual_rights_owner;
	}
	public void setIntellectual_rights_owner(String intellectual_rights_owner) {
		this.intellectual_rights_owner = intellectual_rights_owner;
	}
	public String getDeclare_situation() {
		return declare_situation;
	}
	public void setDeclare_situation(String declare_situation) {
		this.declare_situation = declare_situation;
	}
	public String getIf_sign_agreement_other() {
		return if_sign_agreement_other;
	}
	public void setIf_sign_agreement_other(String if_sign_agreement_other) {
		this.if_sign_agreement_other = if_sign_agreement_other;
	}
	public String getUnit_introduction() {
		return unit_introduction;
	}
	public void setUnit_introduction(String unit_introduction) {
		this.unit_introduction = unit_introduction;
	}
	public String getUnit_recommend_reason() {
		return unit_recommend_reason;
	}
	public void setUnit_recommend_reason(String unit_recommend_reason) {
		this.unit_recommend_reason = unit_recommend_reason;
	}
	public String getUnit_working_arrange() {
		return unit_working_arrange;
	}
	public void setUnit_working_arrange(String unit_working_arrange) {
		this.unit_working_arrange = unit_working_arrange;
	}
	public String getUnit_support_conditions() {
		return unit_support_conditions;
	}
	public void setUnit_support_conditions(String unit_support_conditions) {
		this.unit_support_conditions = unit_support_conditions;
	}
	public String getOrganizer_audit_opinion() {
		return organizer_audit_opinion;
	}
	public void setOrganizer_audit_opinion(String organizer_audit_opinion) {
		this.organizer_audit_opinion = organizer_audit_opinion;
	}
	public String getOrganizer_recommend_reasion() {
		return organizer_recommend_reasion;
	}
	public void setOrganizer_recommend_reasion(String organizer_recommend_reasion) {
		this.organizer_recommend_reasion = organizer_recommend_reasion;
	}
	public String getOrganizer_support_conditions() {
		return organizer_support_conditions;
	}
	public void setOrganizer_support_conditions(String organizer_support_conditions) {
		this.organizer_support_conditions = organizer_support_conditions;
	}
	public Integer getIfvalid() {
		return ifvalid;
	}
	public void setIfvalid(Integer ifvalid) {
		this.ifvalid = ifvalid;
	}
	public Integer getStatue() {
		return statue;
	}
	public void setStatue(Integer statue) {
		this.statue = statue;
	}
	
	
	

}
