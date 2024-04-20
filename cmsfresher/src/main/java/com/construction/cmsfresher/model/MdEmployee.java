package com.construction.cmsfresher.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 * The persistent class for the md_employees database table.
 * 
 */
@Entity
@Table(name = "md_employees")
@NamedQuery(name = "MdEmployee.findAll", query = "SELECT m FROM MdEmployee m")
public class MdEmployee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer employeeid;

	private String address;

	@Temporal(TemporalType.DATE)
	private Date dateofbirth;

	private String email;

	private String firstname;

	private Boolean gender;

	private String idcard;

	private String lastname;

	private String phone;

	private String userid;
	
	private Boolean status;
	
	@OneToMany(mappedBy = "laborsid")
	@JsonIgnore
	private List<CmsDiaryTaskEmployee> diaryTaskEmployees;

	// bi-directional many-to-one association to CmsConstructionDiary
	@OneToMany(mappedBy = "mdEmployee")
	@JsonIgnore
	private List<CmsConstructionDiary> cmsConstructionDiaries;

	// bi-directional many-to-one association to CmsConstructionsiteLabor
	@OneToMany(mappedBy = "mdEmployee")
	@JsonIgnore
	private List<CmsConstructionsiteLabor> cmsConstructionsiteLabors;

	// bi-directional many-to-one association to CmsDiaryHistory
	@OneToMany(mappedBy = "mdEmployee")
	@JsonIgnore
	private List<CmsDiaryHistory> cmsDiaryHistories;

	// bi-directional many-to-many association to CmsPlan
	@ManyToMany(mappedBy="mdEmployees",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<CmsPlan> cmsPlans1;

	// bi-directional many-to-one association to CmsPlanHistory
	@OneToMany(mappedBy = "mdEmployee")
	@JsonIgnore
	private List<CmsPlanHistory> cmsPlanHistories;

	// bi-directional many-to-one association to CmsPlanTaskLabor
	@OneToMany(mappedBy = "mdEmployee")
	@JsonIgnore
	private List<CmsPlanTaskLabor> cmsPlanTaskLabors;

	// bi-directional many-to-one association to CmsPlan
	@OneToMany(mappedBy = "mdEmployee")
	@JsonIgnore
	private List<CmsPlan> cmsPlans2;

	// bi-directional many-to-one association to CmsProgressViewer
	@OneToMany(mappedBy = "mdEmployee")
	@JsonIgnore
	private List<CmsProgressViewer> cmsProgressViewers;

	// bi-directional many-to-one association to CmsRoleEmployeesPlanworkitem
	@OneToMany(mappedBy = "mdEmployee")
	@JsonIgnore
	private List<CmsRoleEmployeesPlanworkitem> cmsRoleEmployeesPlanworkitems;

	// bi-directional many-to-one association to MdAccount
	@OneToMany(mappedBy = "mdEmployee")
	@JsonIgnore
	private List<MdAccount> mdAccounts;

	// bi-directional many-to-one association to MdDepartment
	@ManyToOne()
	@JoinColumn(name = "departmentid")
	private MdDepartment mdDepartment;

	// bi-directional many-to-one association to MdEmployeePosition
	@ManyToOne
	@JoinColumn(name = "employeepositionid")
	private MdEmployeePosition mdEmployeePosition;

	@OneToMany(mappedBy = "mdemployee")
	@JsonIgnore
	private List<MdConstructionSite> mdConstructionSites;

	// bi-directional many-to-one association to MdRole

	public MdEmployee() {
	}

	public Integer getEmployeeid() {
		return this.employeeid;
	}

	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDateofbirth() {
		return this.dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Boolean getGender() {
		return this.gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<CmsConstructionDiary> getCmsConstructionDiaries() {
		return this.cmsConstructionDiaries;
	}

	public void setCmsConstructionDiaries(List<CmsConstructionDiary> cmsConstructionDiaries) {
		this.cmsConstructionDiaries = cmsConstructionDiaries;
	}

	public CmsConstructionDiary addCmsConstructionDiary(CmsConstructionDiary cmsConstructionDiary) {
		getCmsConstructionDiaries().add(cmsConstructionDiary);
		cmsConstructionDiary.setMdEmployee(this);

		return cmsConstructionDiary;
	}

	public CmsConstructionDiary removeCmsConstructionDiary(CmsConstructionDiary cmsConstructionDiary) {
		getCmsConstructionDiaries().remove(cmsConstructionDiary);
		cmsConstructionDiary.setMdEmployee(null);

		return cmsConstructionDiary;
	}

	public List<CmsConstructionsiteLabor> getCmsConstructionsiteLabors() {
		return this.cmsConstructionsiteLabors;
	}

	public void setCmsConstructionsiteLabors(List<CmsConstructionsiteLabor> cmsConstructionsiteLabors) {
		this.cmsConstructionsiteLabors = cmsConstructionsiteLabors;
	}

	public CmsConstructionsiteLabor addCmsConstructionsiteLabor(CmsConstructionsiteLabor cmsConstructionsiteLabor) {
		getCmsConstructionsiteLabors().add(cmsConstructionsiteLabor);
		cmsConstructionsiteLabor.setMdEmployee(this);

		return cmsConstructionsiteLabor;
	}

	public CmsConstructionsiteLabor removeCmsConstructionsiteLabor(CmsConstructionsiteLabor cmsConstructionsiteLabor) {
		getCmsConstructionsiteLabors().remove(cmsConstructionsiteLabor);
		cmsConstructionsiteLabor.setMdEmployee(null);

		return cmsConstructionsiteLabor;
	}

	public List<CmsDiaryHistory> getCmsDiaryHistories() {
		return this.cmsDiaryHistories;
	}

	public void setCmsDiaryHistories(List<CmsDiaryHistory> cmsDiaryHistories) {
		this.cmsDiaryHistories = cmsDiaryHistories;
	}

	public CmsDiaryHistory addCmsDiaryHistory(CmsDiaryHistory cmsDiaryHistory) {
		getCmsDiaryHistories().add(cmsDiaryHistory);
		cmsDiaryHistory.setMdEmployee(this);

		return cmsDiaryHistory;
	}

	public CmsDiaryHistory removeCmsDiaryHistory(CmsDiaryHistory cmsDiaryHistory) {
		getCmsDiaryHistories().remove(cmsDiaryHistory);
		cmsDiaryHistory.setMdEmployee(null);

		return cmsDiaryHistory;
	}

	public List<CmsPlan> getCmsPlans1() {
		return this.cmsPlans1;
	}

	public void setCmsPlans1(List<CmsPlan> cmsPlans1) {
		this.cmsPlans1 = cmsPlans1;
	}

	public List<CmsPlanHistory> getCmsPlanHistories() {
		return this.cmsPlanHistories;
	}

	public void setCmsPlanHistories(List<CmsPlanHistory> cmsPlanHistories) {
		this.cmsPlanHistories = cmsPlanHistories;
	}

	public CmsPlanHistory addCmsPlanHistory(CmsPlanHistory cmsPlanHistory) {
		getCmsPlanHistories().add(cmsPlanHistory);
		cmsPlanHistory.setMdEmployee(this);

		return cmsPlanHistory;
	}

	public CmsPlanHistory removeCmsPlanHistory(CmsPlanHistory cmsPlanHistory) {
		getCmsPlanHistories().remove(cmsPlanHistory);
		cmsPlanHistory.setMdEmployee(null);

		return cmsPlanHistory;
	}

	public List<CmsPlanTaskLabor> getCmsPlanTaskLabors() {
		return this.cmsPlanTaskLabors;
	}

	public void setCmsPlanTaskLabors(List<CmsPlanTaskLabor> cmsPlanTaskLabors) {
		this.cmsPlanTaskLabors = cmsPlanTaskLabors;
	}

	public CmsPlanTaskLabor addCmsPlanTaskLabor(CmsPlanTaskLabor cmsPlanTaskLabor) {
		getCmsPlanTaskLabors().add(cmsPlanTaskLabor);
		cmsPlanTaskLabor.setMdEmployee(this);

		return cmsPlanTaskLabor;
	}

	public CmsPlanTaskLabor removeCmsPlanTaskLabor(CmsPlanTaskLabor cmsPlanTaskLabor) {
		getCmsPlanTaskLabors().remove(cmsPlanTaskLabor);
		cmsPlanTaskLabor.setMdEmployee(null);

		return cmsPlanTaskLabor;
	}

	public List<CmsPlan> getCmsPlans2() {
		return this.cmsPlans2;
	}

	public void setCmsPlans2(List<CmsPlan> cmsPlans2) {
		this.cmsPlans2 = cmsPlans2;
	}

	public CmsPlan addCmsPlans2(CmsPlan cmsPlans2) {
		getCmsPlans2().add(cmsPlans2);
		cmsPlans2.setMdEmployee(this);

		return cmsPlans2;
	}

	public CmsPlan removeCmsPlans2(CmsPlan cmsPlans2) {
		getCmsPlans2().remove(cmsPlans2);
		cmsPlans2.setMdEmployee(null);

		return cmsPlans2;
	}

	public List<CmsProgressViewer> getCmsProgressViewers() {
		return this.cmsProgressViewers;
	}

	public void setCmsProgressViewers(List<CmsProgressViewer> cmsProgressViewers) {
		this.cmsProgressViewers = cmsProgressViewers;
	}

	public CmsProgressViewer addCmsProgressViewer(CmsProgressViewer cmsProgressViewer) {
		getCmsProgressViewers().add(cmsProgressViewer);
		cmsProgressViewer.setMdEmployee(this);

		return cmsProgressViewer;
	}

	public CmsProgressViewer removeCmsProgressViewer(CmsProgressViewer cmsProgressViewer) {
		getCmsProgressViewers().remove(cmsProgressViewer);
		cmsProgressViewer.setMdEmployee(null);

		return cmsProgressViewer;
	}

	public List<CmsRoleEmployeesPlanworkitem> getCmsRoleEmployeesPlanworkitems() {
		return this.cmsRoleEmployeesPlanworkitems;
	}

	public void setCmsRoleEmployeesPlanworkitems(List<CmsRoleEmployeesPlanworkitem> cmsRoleEmployeesPlanworkitems) {
		this.cmsRoleEmployeesPlanworkitems = cmsRoleEmployeesPlanworkitems;
	}

	public CmsRoleEmployeesPlanworkitem addCmsRoleEmployeesPlanworkitem(
			CmsRoleEmployeesPlanworkitem cmsRoleEmployeesPlanworkitem) {
		getCmsRoleEmployeesPlanworkitems().add(cmsRoleEmployeesPlanworkitem);
		cmsRoleEmployeesPlanworkitem.setMdEmployee(this);

		return cmsRoleEmployeesPlanworkitem;
	}

	public CmsRoleEmployeesPlanworkitem removeCmsRoleEmployeesPlanworkitem(
			CmsRoleEmployeesPlanworkitem cmsRoleEmployeesPlanworkitem) {
		getCmsRoleEmployeesPlanworkitems().remove(cmsRoleEmployeesPlanworkitem);
		cmsRoleEmployeesPlanworkitem.setMdEmployee(null);

		return cmsRoleEmployeesPlanworkitem;
	}

	public List<MdAccount> getMdAccounts() {
		return this.mdAccounts;
	}

	public void setMdAccounts(List<MdAccount> mdAccounts) {
		this.mdAccounts = mdAccounts;
	}

	public MdAccount addMdAccount(MdAccount mdAccount) {
		getMdAccounts().add(mdAccount);
		mdAccount.setMdEmployee(this);

		return mdAccount;
	}

	public MdAccount removeMdAccount(MdAccount mdAccount) {
		getMdAccounts().remove(mdAccount);
		mdAccount.setMdEmployee(null);

		return mdAccount;
	}

	public MdDepartment getMdDepartment() {
		return this.mdDepartment;
	}

	public void setMdDepartment(MdDepartment mdDepartment) {
		this.mdDepartment = mdDepartment;
	}

	public MdEmployeePosition getMdEmployeePosition() {
		return this.mdEmployeePosition;
	}

	public void setMdEmployeePosition(MdEmployeePosition mdEmployeePosition) {
		this.mdEmployeePosition = mdEmployeePosition;
	}

	public List<MdConstructionSite> getMdConstructionSites() {
		return mdConstructionSites;
	}

	public void setMdConstructionSites(List<MdConstructionSite> mdConstructionSites) {
		this.mdConstructionSites = mdConstructionSites;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public List<CmsDiaryTaskEmployee> getDiaryTaskEmployees() {
		return diaryTaskEmployees;
	}

	public void setDiaryTaskEmployees(List<CmsDiaryTaskEmployee> diaryTaskEmployees) {
		this.diaryTaskEmployees = diaryTaskEmployees;
	}
	
	

}