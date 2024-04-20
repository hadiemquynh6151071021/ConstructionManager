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
 * The persistent class for the md_tasks database table.
 * 
 */
@Entity
@Table(name="md_tasks")
@NamedQuery(name="MdTask.findAll", query="SELECT m FROM MdTask m")
public class MdTask implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer taskid;

	private String taskcode;

	private String taskname;

	//bi-directional many-to-one association to CmsCostestimateTask
	@OneToMany(mappedBy="mdTask")
	@JsonIgnore
	private List<CmsCostestimateTask> cmsCostestimateTasks;

	//bi-directional many-to-one association to CmsPlanTask
	@OneToMany(mappedBy="mdTask")
	@JsonIgnore
	private List<CmsPlanTask> cmsPlanTasks;

	//bi-directional many-to-one association to MdQuantityUnit
	@ManyToOne
	@JoinColumn(name="quantityunitid")
	private MdQuantityUnit mdQuantityUnit;

	//bi-directional many-to-one association to MdWorkItem
	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name="workitemid")
	private MdWorkItem mdWorkItem;

	public MdTask() {
	}

	public Integer getTaskid() {
		return this.taskid;
	}

	public void setTaskid(Integer taskid) {
		this.taskid = taskid;
	}

	public String getTaskname() {
		return this.taskname;
	}

	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}

	public List<CmsCostestimateTask> getCmsCostestimateTasks() {
		return this.cmsCostestimateTasks;
	}

	public void setCmsCostestimateTasks(List<CmsCostestimateTask> cmsCostestimateTasks) {
		this.cmsCostestimateTasks = cmsCostestimateTasks;
	}

	public CmsCostestimateTask addCmsCostestimateTask(CmsCostestimateTask cmsCostestimateTask) {
		getCmsCostestimateTasks().add(cmsCostestimateTask);
		cmsCostestimateTask.setMdTask(this);

		return cmsCostestimateTask;
	}

	public CmsCostestimateTask removeCmsCostestimateTask(CmsCostestimateTask cmsCostestimateTask) {
		getCmsCostestimateTasks().remove(cmsCostestimateTask);
		cmsCostestimateTask.setMdTask(null);

		return cmsCostestimateTask;
	}

	public List<CmsPlanTask> getCmsPlanTasks() {
		return this.cmsPlanTasks;
	}

	public void setCmsPlanTasks(List<CmsPlanTask> cmsPlanTasks) {
		this.cmsPlanTasks = cmsPlanTasks;
	}

	public CmsPlanTask addCmsPlanTask(CmsPlanTask cmsPlanTask) {
		getCmsPlanTasks().add(cmsPlanTask);
		cmsPlanTask.setMdTask(this);

		return cmsPlanTask;
	}

	public CmsPlanTask removeCmsPlanTask(CmsPlanTask cmsPlanTask) {
		getCmsPlanTasks().remove(cmsPlanTask);
		cmsPlanTask.setMdTask(null);

		return cmsPlanTask;
	}

	public MdQuantityUnit getMdQuantityUnit() {
		return this.mdQuantityUnit;
	}

	public void setMdQuantityUnit(MdQuantityUnit mdQuantityUnit) {
		this.mdQuantityUnit = mdQuantityUnit;
	}

	public MdWorkItem getMdWorkItem() {
		return this.mdWorkItem;
	}

	public void setMdWorkItem(MdWorkItem mdWorkItem) {
		this.mdWorkItem = mdWorkItem;
	}

	public String getTaskcode() {
		return taskcode;
	}

	public void setTaskcode(String taskcode) {
		this.taskcode = taskcode;
	}
	

}