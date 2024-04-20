package com.construction.cmsfresher.model;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;


/**
 * The persistent class for the cms_plan_history database table.
 * 
 */
@Entity
@Table(name="cms_plan_history")
@NamedQuery(name="CmsPlanHistory.findAll", query="SELECT c FROM CmsPlanHistory c")
public class CmsPlanHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer planhistoryid;

	private Timestamp actiontime;

	private String description;

	//bi-directional many-to-one association to CmsPlanAction
	@ManyToOne
	@JoinColumn(name="planactionid")
	private CmsPlanAction cmsPlanAction;

	//bi-directional many-to-one association to CmsPlan
	@ManyToOne
	@JoinColumn(name="planid")
	private CmsPlan cmsPlan;

	//bi-directional many-to-one association to MdEmployee
	@ManyToOne
	@JoinColumn(name="actorid")
	private MdEmployee mdEmployee;

	public CmsPlanHistory() {
	}

	public Integer getPlanhistoryid() {
		return this.planhistoryid;
	}

	public void setPlanhistoryid(Integer planhistoryid) {
		this.planhistoryid = planhistoryid;
	}

	public Timestamp getActiontime() {
		return this.actiontime;
	}

	public void setActiontime(Timestamp actiontime) {
		this.actiontime = actiontime;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CmsPlanAction getCmsPlanAction() {
		return this.cmsPlanAction;
	}

	public void setCmsPlanAction(CmsPlanAction cmsPlanAction) {
		this.cmsPlanAction = cmsPlanAction;
	}

	public CmsPlan getCmsPlan() {
		return this.cmsPlan;
	}

	public void setCmsPlan(CmsPlan cmsPlan) {
		this.cmsPlan = cmsPlan;
	}

	public MdEmployee getMdEmployee() {
		return this.mdEmployee;
	}

	public void setMdEmployee(MdEmployee mdEmployee) {
		this.mdEmployee = mdEmployee;
	}

}