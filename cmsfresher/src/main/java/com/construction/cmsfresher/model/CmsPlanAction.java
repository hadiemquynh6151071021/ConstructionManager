package com.construction.cmsfresher.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


/**
 * The persistent class for the cms_plan_actions database table.
 * 
 */
@Entity
@Table(name="cms_plan_actions")
@NamedQuery(name="CmsPlanAction.findAll", query="SELECT c FROM CmsPlanAction c")
public class CmsPlanAction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer planactionid;

	private String planactionname;

	//bi-directional many-to-one association to CmsPlanHistory
	@OneToMany(mappedBy="cmsPlanAction")
	private List<CmsPlanHistory> cmsPlanHistories;

	public CmsPlanAction() {
	}

	public Integer getPlanactionid() {
		return this.planactionid;
	}

	public void setPlanactionid(Integer planactionid) {
		this.planactionid = planactionid;
	}

	public String getPlanactionname() {
		return this.planactionname;
	}

	public void setPlanactionname(String planactionname) {
		this.planactionname = planactionname;
	}

	public List<CmsPlanHistory> getCmsPlanHistories() {
		return this.cmsPlanHistories;
	}

	public void setCmsPlanHistories(List<CmsPlanHistory> cmsPlanHistories) {
		this.cmsPlanHistories = cmsPlanHistories;
	}

	public CmsPlanHistory addCmsPlanHistory(CmsPlanHistory cmsPlanHistory) {
		getCmsPlanHistories().add(cmsPlanHistory);
		cmsPlanHistory.setCmsPlanAction(this);

		return cmsPlanHistory;
	}

	public CmsPlanHistory removeCmsPlanHistory(CmsPlanHistory cmsPlanHistory) {
		getCmsPlanHistories().remove(cmsPlanHistory);
		cmsPlanHistory.setCmsPlanAction(null);

		return cmsPlanHistory;
	}

}