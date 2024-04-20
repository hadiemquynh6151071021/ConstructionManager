package com.construction.cmsfresher.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * The persistent class for the md_work_items database table.
 * 
 */
@Entity
@Table(name = "md_work_items")
@NamedQuery(name = "MdWorkItem.findAll", query = "SELECT m FROM MdWorkItem m")
public class MdWorkItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer workitemid;

	private String workitemcode;

	private String workitemname;

	// bi-directional many-to-one association to CmsCostestimateWorkitem
	@OneToMany(mappedBy = "mdWorkItem")
	@JsonIgnore
	private List<CmsCostestimateWorkitem> cmsCostestimateWorkitems;

	// bi-directional many-to-one association to CmsPlanTask
	@OneToMany(mappedBy = "mdWorkItem")
	@JsonIgnore
	private List<CmsPlanTask> cmsPlanTasks;

	// bi-directional many-to-one association to CmsPlanWorkitem
	@OneToMany(mappedBy = "mdWorkItem")
	@JsonIgnore
	private List<CmsPlanWorkitem> cmsPlanWorkitems;

	// bi-directional many-to-one association to MdTask
	@OneToMany(mappedBy = "mdWorkItem", fetch = FetchType.EAGER)
	private List<MdTask> mdTasks;

	public MdWorkItem() {
	}

	public Integer getWorkitemid() {
		return this.workitemid;
	}

	public void setWorkitemid(Integer workitemid) {
		this.workitemid = workitemid;
	}

	public String getWorkitemname() {
		return this.workitemname;
	}

	public void setWorkitemname(String workitemname) {
		this.workitemname = workitemname;
	}

	public List<CmsCostestimateWorkitem> getCmsCostestimateWorkitems() {
		return this.cmsCostestimateWorkitems;
	}

	public void setCmsCostestimateWorkitems(List<CmsCostestimateWorkitem> cmsCostestimateWorkitems) {
		this.cmsCostestimateWorkitems = cmsCostestimateWorkitems;
	}

	public CmsCostestimateWorkitem addCmsCostestimateWorkitem(CmsCostestimateWorkitem cmsCostestimateWorkitem) {
		getCmsCostestimateWorkitems().add(cmsCostestimateWorkitem);
		cmsCostestimateWorkitem.setMdWorkItem(this);

		return cmsCostestimateWorkitem;
	}

	public CmsCostestimateWorkitem removeCmsCostestimateWorkitem(CmsCostestimateWorkitem cmsCostestimateWorkitem) {
		getCmsCostestimateWorkitems().remove(cmsCostestimateWorkitem);
		cmsCostestimateWorkitem.setMdWorkItem(null);

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
		cmsPlanTask.setMdWorkItem(this);

		return cmsPlanTask;
	}

	public CmsPlanTask removeCmsPlanTask(CmsPlanTask cmsPlanTask) {
		getCmsPlanTasks().remove(cmsPlanTask);
		cmsPlanTask.setMdWorkItem(null);

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
		cmsPlanWorkitem.setMdWorkItem(this);

		return cmsPlanWorkitem;
	}

	public CmsPlanWorkitem removeCmsPlanWorkitem(CmsPlanWorkitem cmsPlanWorkitem) {
		getCmsPlanWorkitems().remove(cmsPlanWorkitem);
		cmsPlanWorkitem.setMdWorkItem(null);

		return cmsPlanWorkitem;
	}

	public List<MdTask> getMdTasks() {
		return this.mdTasks;
	}

	public void setMdTasks(List<MdTask> mdTasks) {
		this.mdTasks = mdTasks;
	}

	

	public String getWorkitemcode() {
		return workitemcode;
	}

	public void setWorkitemcode(String workitemcode) {
		this.workitemcode = workitemcode;
	}

	public MdTask addMdTask(MdTask mdTask) {
		getMdTasks().add(mdTask);
		mdTask.setMdWorkItem(this);

		return mdTask;
	}

	public MdTask removeMdTask(MdTask mdTask) {
		getMdTasks().remove(mdTask);
		mdTask.setMdWorkItem(null);

		return mdTask;
	}

}