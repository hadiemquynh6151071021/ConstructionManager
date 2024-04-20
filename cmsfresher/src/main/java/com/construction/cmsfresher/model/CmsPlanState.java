package com.construction.cmsfresher.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


/**
 * The persistent class for the cms_plan_states database table.
 * 
 */
@Entity
@Table(name="cms_plan_states")
@NamedQuery(name="CmsPlanState.findAll", query="SELECT c FROM CmsPlanState c")
public class CmsPlanState implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer planstateid;

	private String planstatename;

	//bi-directional many-to-one association to CmsPlan
	@OneToMany(mappedBy="cmsPlanState")
	@JsonIgnore
	private List<CmsPlan> cmsPlans;

	public CmsPlanState() {
	}

	public Integer getPlanstateid() {
		return this.planstateid;
	}

	public void setPlanstateid(Integer planstateid) {
		this.planstateid = planstateid;
	}

	public String getPlanstatename() {
		return this.planstatename;
	}

	public void setPlanstatename(String planstatename) {
		this.planstatename = planstatename;
	}

	public List<CmsPlan> getCmsPlans() {
		return this.cmsPlans;
	}

	public void setCmsPlans(List<CmsPlan> cmsPlans) {
		this.cmsPlans = cmsPlans;
	}

	public CmsPlan addCmsPlan(CmsPlan cmsPlan) {
		getCmsPlans().add(cmsPlan);
		cmsPlan.setCmsPlanState(this);

		return cmsPlan;
	}

	public CmsPlan removeCmsPlan(CmsPlan cmsPlan) {
		getCmsPlans().remove(cmsPlan);
		cmsPlan.setCmsPlanState(null);

		return cmsPlan;
	}

}