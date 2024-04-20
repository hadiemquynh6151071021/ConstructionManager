package com.construction.cmsfresher.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
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
 * The persistent class for the md_cost_estimates database table.
 * 
 */
@Entity
@Table(name="md_cost_estimates")
@NamedQuery(name="MdCostEstimate.findAll", query="SELECT m FROM MdCostEstimate m")
public class MdCostEstimate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer costestimateid;

	private String costestimatecode;

	private String costestimatename;

	@Temporal(TemporalType.DATE)
	private Date dateofcostestimate;
	
	private String status;

	private Boolean islast;

	//bi-directional many-to-one association to CmsCostestimateWorkitem
	@JsonIgnore
	@OneToMany(mappedBy="mdCostEstimate")
	private List<CmsCostestimateWorkitem> cmsCostestimateWorkitems;

	//bi-directional many-to-one association to CmsPlanTask
	@JsonIgnore
	@OneToMany(mappedBy="mdCostEstimate")
	private List<CmsPlanTask> cmsPlanTasks;

	//bi-directional many-to-one association to MdConstructionSite
	@ManyToOne
	@JoinColumn(name="constructionsiteid")
	private MdConstructionSite mdConstructionSite;

	public MdCostEstimate() {
	}

	public Integer getCostestimateid() {
		return this.costestimateid;
	}

	public void setCostestimateid(Integer costestimateid) {
		this.costestimateid = costestimateid;
	}

	public String getCostestimatecode() {
		return this.costestimatecode;
	}

	public void setCostestimatecode(String costestimatecode) {
		this.costestimatecode = costestimatecode;
	}

	public String getCostestimatename() {
		return this.costestimatename;
	}

	public void setCostestimatename(String costestimatename) {
		this.costestimatename = costestimatename;
	}

	public Date getDateofcostestimate() {
		return this.dateofcostestimate;
	}

	public void setDateofcostestimate(Date dateofcostestimate) {
		this.dateofcostestimate = dateofcostestimate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getIslast() {
		return this.islast;
	}

	public void setIslast(Boolean islast) {
		this.islast = islast;
	}

	public List<CmsCostestimateWorkitem> getCmsCostestimateWorkitems() {
		return this.cmsCostestimateWorkitems;
	}

	public void setCmsCostestimateWorkitems(List<CmsCostestimateWorkitem> cmsCostestimateWorkitems) {
		this.cmsCostestimateWorkitems = cmsCostestimateWorkitems;
	}

	public CmsCostestimateWorkitem addCmsCostestimateWorkitem(CmsCostestimateWorkitem cmsCostestimateWorkitem) {
		getCmsCostestimateWorkitems().add(cmsCostestimateWorkitem);
		cmsCostestimateWorkitem.setMdCostEstimate(this);

		return cmsCostestimateWorkitem;
	}

	public CmsCostestimateWorkitem removeCmsCostestimateWorkitem(CmsCostestimateWorkitem cmsCostestimateWorkitem) {
		getCmsCostestimateWorkitems().remove(cmsCostestimateWorkitem);
		cmsCostestimateWorkitem.setMdCostEstimate(null);

		return cmsCostestimateWorkitem;
	}

	public List<CmsPlanTask> getCmsPlanTasks() {
		return this.cmsPlanTasks;
	}

	public void setCmsPlanTasks(List<CmsPlanTask> cmsPlanTasks) {
		this.cmsPlanTasks = cmsPlanTasks;
	}

	public CmsPlanTask addCmsPlanTask(CmsPlanTask cmsPlanTask) {
		getCmsPlanTasks().add(cmsPlanTask);
		cmsPlanTask.setMdCostEstimate(this);

		return cmsPlanTask;
	}

	public CmsPlanTask removeCmsPlanTask(CmsPlanTask cmsPlanTask) {
		getCmsPlanTasks().remove(cmsPlanTask);
		cmsPlanTask.setMdCostEstimate(null);

		return cmsPlanTask;
	}

	public MdConstructionSite getMdConstructionSite() {
		return this.mdConstructionSite;
	}

	public void setMdConstructionSite(MdConstructionSite mdConstructionSite) {
		this.mdConstructionSite = mdConstructionSite;
	}

	public MdCostEstimate(Integer costestimateid, String costestimatecode, String costestimatename) {
		this.costestimateid = costestimateid;
		this.costestimatecode = costestimatecode;
		this.costestimatename = costestimatename;
		
	}
	
	

}