package com.construction.cmsfresher.dto.response.cmscostestimatetaskdto;

public class CmsCostEstimateTaskDTO {

	private Integer amountofwork;
	private Integer taskid;
	private Integer laborquantity;
	private String taskcode;
	private String taskname;
	private String quantityunitname;
	private Integer quantityunitid;
	private String workitemcode;

	private String workitemname;
	private Integer workitemid;

	private Integer costestimatetaskid;
	private Integer costestimateworkitemid;
	public Integer getAmountofwork() {
		return amountofwork;
	}

	public void setAmountofwork(Integer amountofwork) {
		this.amountofwork = amountofwork;
	}

	public Integer getTaskid() {
		return taskid;
	}

	public void setTaskid(Integer taskid) {
		this.taskid = taskid;
	}

	public String getTaskcode() {
		return taskcode;
	}

	public void setTaskcode(String taskcode) {
		this.taskcode = taskcode;
	}

	public Integer getCostestimatetaskid() {
		return costestimatetaskid;
	}

	public void setCostestimatetaskid(Integer costestimatetaskid) {
		this.costestimatetaskid = costestimatetaskid;
	}

	public String getTaskname() {
		return taskname;
	}

	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}

	public String getQuantityunitname() {
		return quantityunitname;
	}

	public void setQuantityunitname(String quantityunitname) {
		this.quantityunitname = quantityunitname;
	}

	public String getWorkitemcode() {
		return workitemcode;
	}

	public void setWorkitemcode(String workitemcode) {
		this.workitemcode = workitemcode;
	}

	public String getWorkitemname() {
		return workitemname;
	}

	public void setWorkitemname(String workitemname) {
		this.workitemname = workitemname;
	}

	public Integer getWorkitemid() {
		return workitemid;
	}

	public void setWorkitemid(Integer workitemid) {
		this.workitemid = workitemid;
	}

	public Integer getLaborquantity() {
		return laborquantity;
	}

	public void setLaborquantity(Integer laborquantity) {
		this.laborquantity = laborquantity;
	}

	public Integer getCostestimateworkitemid() {
		return costestimateworkitemid;
	}

	public void setCostestimateworkitemid(Integer costestimateworkitemid) {
		this.costestimateworkitemid = costestimateworkitemid;
	}

	public Integer getQuantityunitid() {
		return quantityunitid;
	}

	public void setQuantityunitid(Integer quantityunitid) {
		this.quantityunitid = quantityunitid;
	}
	
	

}
