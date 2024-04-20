package com.construction.cmsfresher.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;


/**
 * The persistent class for the cms_plan_task_labors database table.
 * 
 */
@Entity
@Table(name="cms_plan_task_labors")
@NamedQuery(name="CmsPlanTaskLabor.findAll", query="SELECT c FROM CmsPlanTaskLabor c")
public class CmsPlanTaskLabor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer plantasklaborid;

	private String status;

	//bi-directional many-to-one association to CmsPlanTask
	@ManyToOne
	@JoinColumn(name="plantaskid")
	private CmsPlanTask cmsPlanTask;

	//bi-directional many-to-one association to MdEmployee
	@ManyToOne
	@JoinColumn(name="laborid")
	private MdEmployee mdEmployee;

	public CmsPlanTaskLabor() {
	}

	public Integer getPlantasklaborid() {
		return this.plantasklaborid;
	}

	public void setPlantasklaborid(Integer plantasklaborid) {
		this.plantasklaborid = plantasklaborid;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CmsPlanTask getCmsPlanTask() {
		return this.cmsPlanTask;
	}

	public void setCmsPlanTask(CmsPlanTask cmsPlanTask) {
		this.cmsPlanTask = cmsPlanTask;
	}

	public MdEmployee getMdEmployee() {
		return this.mdEmployee;
	}

	public void setMdEmployee(MdEmployee mdEmployee) {
		this.mdEmployee = mdEmployee;
	}

}