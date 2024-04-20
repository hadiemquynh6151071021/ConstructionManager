package com.construction.cmsfresher.dto.response.cmscostestimatetaskdto;

public class CmsCostEstimateTaskDetailDTO {
	
	private Integer amountofwork;
	private Integer taskid;
	private String taskcode;
	private String taskname;
	
	private Integer costestimatetaskid;
	
	private Integer quantityunitid;
	private String quantityunitname;

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

	public Integer getQuantityunitid() {
		return quantityunitid;
	}

	public void setQuantityunitid(Integer quantityunitid) {
		this.quantityunitid = quantityunitid;
	}

	public String getQuantityunitname() {
		return quantityunitname;
	}

	public void setQuantityunitname(String quantityunitname) {
		this.quantityunitname = quantityunitname;
	}

	

	
	

}
