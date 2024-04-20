package com.construction.cmsfresher.model;

import java.io.Serializable;
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


/**
 * The persistent class for the cms_costestimate_workitems database table.
 * 
 */
@Entity
@Table(name="cms_costestimate_workitems")
@NamedQuery(name="CmsCostestimateWorkitem.findAll", query="SELECT c FROM CmsCostestimateWorkitem c")
public class CmsCostestimateWorkitem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer costestimateworkitemid;

	//bi-directional many-to-one association to CmsCostestimateTask
	@OneToMany(mappedBy="cmsCostestimateWorkitem")
	@JsonIgnore
	private List<CmsCostestimateTask> cmsCostestimateTasks;

	//bi-directional many-to-one association to MdCostEstimate
	@ManyToOne
	@JoinColumn(name="costestimateid")
	private MdCostEstimate mdCostEstimate;

	//bi-directional many-to-one association to MdWorkItem
	@ManyToOne
	@JoinColumn(name="workitemid")
	private MdWorkItem mdWorkItem;

	public CmsCostestimateWorkitem() {
	}

	public Integer getCostestimateworkitemid() {
		return this.costestimateworkitemid;
	}

	public void setCostestimateworkitemid(Integer costestimateworkitemid) {
		this.costestimateworkitemid = costestimateworkitemid;
	}

	public List<CmsCostestimateTask> getCmsCostestimateTasks() {
		return this.cmsCostestimateTasks;
	}

	public void setCmsCostestimateTasks(List<CmsCostestimateTask> cmsCostestimateTasks) {
		this.cmsCostestimateTasks = cmsCostestimateTasks;
	}

	public CmsCostestimateTask addCmsCostestimateTask(CmsCostestimateTask cmsCostestimateTask) {
		getCmsCostestimateTasks().add(cmsCostestimateTask);
		cmsCostestimateTask.setCmsCostestimateWorkitem(this);

		return cmsCostestimateTask;
	}

	public CmsCostestimateTask removeCmsCostestimateTask(CmsCostestimateTask cmsCostestimateTask) {
		getCmsCostestimateTasks().remove(cmsCostestimateTask);
		cmsCostestimateTask.setCmsCostestimateWorkitem(null);

		return cmsCostestimateTask;
	}

	public MdCostEstimate getMdCostEstimate() {
		return this.mdCostEstimate;
	}

	public void setMdCostEstimate(MdCostEstimate mdCostEstimate) {
		this.mdCostEstimate = mdCostEstimate;
	}

	public MdWorkItem getMdWorkItem() {
		return this.mdWorkItem;
	}

	public void setMdWorkItem(MdWorkItem mdWorkItem) {
		this.mdWorkItem = mdWorkItem;
	}

}