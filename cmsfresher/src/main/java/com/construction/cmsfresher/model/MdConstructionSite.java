package com.construction.cmsfresher.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


/**
 * The persistent class for the md_construction_sites database table.
 * 
 */
@Entity
@Table(name="md_construction_sites")
@NamedQuery(name="MdConstructionSite.findAll", query="SELECT m FROM MdConstructionSite m")

public class MdConstructionSite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer constructionsiteid;

	private String address;

	private String constructionsitecode;

	private String constructionsitename;

	@Temporal(TemporalType.DATE)
	private Date enddate;

	private Boolean islast;

	@Temporal(TemporalType.DATE)
	private Date startdate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="createddate")
	private Date createdDate;

	//bi-directional many-to-one association to CmsConstructionsiteLabor
	@OneToMany(mappedBy="mdConstructionSite")
	@JsonIgnore
	private List<CmsConstructionsiteLabor> cmsConstructionsiteLabors;

	//bi-directional many-to-one association to CmsPlan
	@OneToMany(mappedBy="mdConstructionSite")
	@JsonIgnore
	private List<CmsPlan> cmsPlans;
	
	@ManyToOne
	@JoinColumn(name = "mdEmployeeid")
	private MdEmployee mdemployee;


	//bi-directional many-to-one association to MdConstructionState
	@ManyToOne
	@JoinColumn(name="constructionstateid")
	private MdConstructionState mdConstructionState;

	//bi-directional many-to-one association to MdConstructionType
	@ManyToOne
	@JoinColumn(name="constructiontypeid")
	private MdConstructionType mdConstructionType;

	//bi-directional many-to-one association to MdCostEstimate
	@OneToMany(mappedBy="mdConstructionSite")
	@JsonIgnore
	private List<MdCostEstimate> mdCostEstimates;

	//bi-directional many-to-one association to MdWarehous
	@OneToMany(mappedBy="mdConstructionSite")
	@JsonIgnore
	private List<MdWarehous> mdWarehouses;

	public MdConstructionSite() {
	}

	public Integer getConstructionsiteid() {
		return this.constructionsiteid;
	}

	public void setConstructionsiteid(Integer constructionsiteid) {
		this.constructionsiteid = constructionsiteid;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getConstructionsitecode() {
		return this.constructionsitecode;
	}

	public void setConstructionsitecode(String constructionsitecode) {
		this.constructionsitecode = constructionsitecode;
	}

	public String getConstructionsitename() {
		return this.constructionsitename;
	}

	public void setConstructionsitename(String constructionsitename) {
		this.constructionsitename = constructionsitename;
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

	public Date getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public List<CmsConstructionsiteLabor> getCmsConstructionsiteLabors() {
		return this.cmsConstructionsiteLabors;
	}

	public void setCmsConstructionsiteLabors(List<CmsConstructionsiteLabor> cmsConstructionsiteLabors) {
		this.cmsConstructionsiteLabors = cmsConstructionsiteLabors;
	}

	public CmsConstructionsiteLabor addCmsConstructionsiteLabor(CmsConstructionsiteLabor cmsConstructionsiteLabor) {
		getCmsConstructionsiteLabors().add(cmsConstructionsiteLabor);
		cmsConstructionsiteLabor.setMdConstructionSite(this);

		return cmsConstructionsiteLabor;
	}

	public CmsConstructionsiteLabor removeCmsConstructionsiteLabor(CmsConstructionsiteLabor cmsConstructionsiteLabor) {
		getCmsConstructionsiteLabors().remove(cmsConstructionsiteLabor);
		cmsConstructionsiteLabor.setMdConstructionSite(null);

		return cmsConstructionsiteLabor;
	}

	public List<CmsPlan> getCmsPlans() {
		return this.cmsPlans;
	}

	public void setCmsPlans(List<CmsPlan> cmsPlans) {
		this.cmsPlans = cmsPlans;
	}

	public CmsPlan addCmsPlan(CmsPlan cmsPlan) {
		getCmsPlans().add(cmsPlan);
		cmsPlan.setMdConstructionSite(this);

		return cmsPlan;
	}

	public CmsPlan removeCmsPlan(CmsPlan cmsPlan) {
		getCmsPlans().remove(cmsPlan);
		cmsPlan.setMdConstructionSite(null);

		return cmsPlan;
	}

	public MdConstructionState getMdConstructionState() {
		return this.mdConstructionState;
	}

	public void setMdConstructionState(MdConstructionState mdConstructionState) {
		this.mdConstructionState = mdConstructionState;
	}

	public MdConstructionType getMdConstructionType() {
		return this.mdConstructionType;
	}

	public void setMdConstructionType(MdConstructionType mdConstructionType) {
		this.mdConstructionType = mdConstructionType;
	}

	public List<MdCostEstimate> getMdCostEstimates() {
		return this.mdCostEstimates;
	}

	public void setMdCostEstimates(List<MdCostEstimate> mdCostEstimates) {
		this.mdCostEstimates = mdCostEstimates;
	}

	public MdCostEstimate addMdCostEstimate(MdCostEstimate mdCostEstimate) {
		getMdCostEstimates().add(mdCostEstimate);
		mdCostEstimate.setMdConstructionSite(this);

		return mdCostEstimate;
	}

	public MdCostEstimate removeMdCostEstimate(MdCostEstimate mdCostEstimate) {
		getMdCostEstimates().remove(mdCostEstimate);
		mdCostEstimate.setMdConstructionSite(null);

		return mdCostEstimate;
	}

	public List<MdWarehous> getMdWarehouses() {
		return this.mdWarehouses;
	}

	public void setMdWarehouses(List<MdWarehous> mdWarehouses) {
		this.mdWarehouses = mdWarehouses;
	}

	public MdWarehous addMdWarehous(MdWarehous mdWarehous) {
		getMdWarehouses().add(mdWarehous);
		mdWarehous.setMdConstructionSite(this);

		return mdWarehous;
	}

	public MdWarehous removeMdWarehous(MdWarehous mdWarehous) {
		getMdWarehouses().remove(mdWarehous);
		mdWarehous.setMdConstructionSite(null);

		return mdWarehous;
	}


	
	public MdEmployee getMdemployee() {
		return mdemployee;
	}

	public void setMdemployee(MdEmployee mdemployee) {
		this.mdemployee = mdemployee;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	

}