package com.construction.cmsfresher.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


/**
 * The persistent class for the cms_plans database table.
 * 
 */
@Entity
@Table(name="cms_plans")
@NamedQuery(name="CmsPlan.findAll", query="SELECT c FROM CmsPlan c")
public class CmsPlan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer planid;

	@Temporal(TemporalType.DATE)
	private Date createddate;

	@Temporal(TemporalType.DATE)
	private Date enddate;

	private Boolean islast;

	private String planidcode;

	
	private String planname;

	@Temporal(TemporalType.DATE)
	private Date startdate;

	//bi-directional many-to-many association to MdEmployee
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "cms_plan_approver", joinColumns = { @JoinColumn(name = "planid") }, inverseJoinColumns = {
			@JoinColumn(name = "employeeid") })
	private List<MdEmployee> mdEmployees;

	//bi-directional many-to-one association to CmsPlanHistory
	@OneToMany(mappedBy="cmsPlan")
	@JsonIgnore
	private List<CmsPlanHistory> cmsPlanHistories;

	//bi-directional many-to-one association to CmsPlanTask
	@OneToMany(mappedBy="cmsPlan")
	@JsonIgnore
	private List<CmsPlanTask> cmsPlanTasks;

	//bi-directional many-to-one association to CmsPlanWorkitem
	@OneToMany(mappedBy="cmsPlan",fetch = FetchType.EAGER)
	@JsonIgnore
	private List<CmsPlanWorkitem> cmsPlanWorkitems;

	//bi-directional many-to-one association to CmsPlanState
	@ManyToOne
	@JoinColumn(name="planstateid")
	private CmsPlanState cmsPlanState;

	//bi-directional many-to-one association to CmsPlan
	@ManyToOne
	@JoinColumn(name="predecessorplanid")
	private CmsPlan cmsPlan;

	//bi-directional many-to-one association to CmsPlan
	@OneToMany(mappedBy="cmsPlan")
	@JsonIgnore
	private List<CmsPlan> cmsPlans;

	//bi-directional many-to-one association to MdConstructionSite
	@ManyToOne
	@JoinColumn(name="constructionsiteid")
	private MdConstructionSite mdConstructionSite;

	//bi-directional many-to-one association to MdEmployee
	@ManyToOne
	@JoinColumn(name="creatorid")
	private MdEmployee mdEmployee;

	public CmsPlan() {
	}

	public Integer getPlanid() {
		return this.planid;
	}

	public void setPlanid(Integer planid) {
		this.planid = planid;
	}

	public Date getCreateddate() {
		return this.createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Boolean getIslast() {
		return this.islast;
	}

	public void setIslast(Boolean islast) {
		this.islast = islast;
	}

	public String getPlanidcode() {
		return this.planidcode;
	}

	public void setPlanidcode(String planidcode) {
		this.planidcode = planidcode;
	}

	public String getPlanname() {
		return this.planname;
	}

	public void setPlanname(String planname) {
		this.planname = planname;
	}

	public Date getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public List<MdEmployee> getMdEmployees() {
		return this.mdEmployees;
	}

	public void setMdEmployees(List<MdEmployee> mdEmployees) {
		this.mdEmployees = mdEmployees;
	}

	public List<CmsPlanHistory> getCmsPlanHistories() {
		return this.cmsPlanHistories;
	}

	public void setCmsPlanHistories(List<CmsPlanHistory> cmsPlanHistories) {
		this.cmsPlanHistories = cmsPlanHistories;
	}

	public CmsPlanHistory addCmsPlanHistory(CmsPlanHistory cmsPlanHistory) {
		getCmsPlanHistories().add(cmsPlanHistory);
		cmsPlanHistory.setCmsPlan(this);

		return cmsPlanHistory;
	}

	public CmsPlanHistory removeCmsPlanHistory(CmsPlanHistory cmsPlanHistory) {
		getCmsPlanHistories().remove(cmsPlanHistory);
		cmsPlanHistory.setCmsPlan(null);

		return cmsPlanHistory;
	}

	public List<CmsPlanTask> getCmsPlanTasks() {
		return this.cmsPlanTasks;
	}

	public void setCmsPlanTasks(List<CmsPlanTask> cmsPlanTasks) {
		this.cmsPlanTasks = cmsPlanTasks;
	}

	public CmsPlanTask addCmsPlanTask(CmsPlanTask cmsPlanTask) {
		getCmsPlanTasks().add(cmsPlanTask);
		cmsPlanTask.setCmsPlan(this);

		return cmsPlanTask;
	}

	public CmsPlanTask removeCmsPlanTask(CmsPlanTask cmsPlanTask) {
		getCmsPlanTasks().remove(cmsPlanTask);
		cmsPlanTask.setCmsPlan(null);

		return cmsPlanTask;
	}

	public List<CmsPlanWorkitem> getCmsPlanWorkitems() {
		return this.cmsPlanWorkitems;
	}

	public void setCmsPlanWorkitems(List<CmsPlanWorkitem> cmsPlanWorkitems) {
		this.cmsPlanWorkitems = cmsPlanWorkitems;
	}

	public CmsPlanWorkitem addCmsPlanWorkitem(CmsPlanWorkitem cmsPlanWorkitem) {
		getCmsPlanWorkitems().add(cmsPlanWorkitem);
		cmsPlanWorkitem.setCmsPlan(this);

		return cmsPlanWorkitem;
	}

	public CmsPlanWorkitem removeCmsPlanWorkitem(CmsPlanWorkitem cmsPlanWorkitem) {
		getCmsPlanWorkitems().remove(cmsPlanWorkitem);
		cmsPlanWorkitem.setCmsPlan(null);

		return cmsPlanWorkitem;
	}

	public CmsPlanState getCmsPlanState() {
		return this.cmsPlanState;
	}

	public void setCmsPlanState(CmsPlanState cmsPlanState) {
		this.cmsPlanState = cmsPlanState;
	}

	public CmsPlan getCmsPlan() {
		return this.cmsPlan;
	}

	public void setCmsPlan(CmsPlan cmsPlan) {
		this.cmsPlan = cmsPlan;
	}

	public List<CmsPlan> getCmsPlans() {
		return this.cmsPlans;
	}

	public void setCmsPlans(List<CmsPlan> cmsPlans) {
		this.cmsPlans = cmsPlans;
	}

	public CmsPlan addCmsPlan(CmsPlan cmsPlan) {
		getCmsPlans().add(cmsPlan);
		cmsPlan.setCmsPlan(this);

		return cmsPlan;
	}

	public CmsPlan removeCmsPlan(CmsPlan cmsPlan) {
		getCmsPlans().remove(cmsPlan);
		cmsPlan.setCmsPlan(null);

		return cmsPlan;
	}

	public MdConstructionSite getMdConstructionSite() {
		return this.mdConstructionSite;
	}

	public void setMdConstructionSite(MdConstructionSite mdConstructionSite) {
		this.mdConstructionSite = mdConstructionSite;
	}

	public MdEmployee getMdEmployee() {
		return this.mdEmployee;
	}

	public void setMdEmployee(MdEmployee mdEmployee) {
		this.mdEmployee = mdEmployee;
	}

}