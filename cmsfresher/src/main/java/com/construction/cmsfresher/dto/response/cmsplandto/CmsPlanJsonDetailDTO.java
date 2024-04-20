package com.construction.cmsfresher.dto.response.cmsplandto;

public class CmsPlanJsonDetailDTO {
	private Integer amountofwork;

	private Integer costestimateid;
	private Integer orderindex;
	private Integer planid;
	private Integer plantaskid;

	private String startdate;
	private String enddate;

	private Integer quantityunitid;
	private String quantityunitname;

	private Integer taskid;
	private String taskcode;
	private String taskname;

	private Integer totallaborquantity;

	private Integer workitemid;
	private String workitemcode;
	private String workitemname;

	public Integer getAmountofwork() {
		return amountofwork;
	}

	public void setAmountofwork(Integer amountofwork) {
		this.amountofwork = amountofwork;
	}

	public Integer getCostestimateid() {
		return costestimateid;
	}

	public void setCostestimateid(Integer costestimateid) {
		this.costestimateid = costestimateid;
	}

	public Integer getOrderindex() {
		return orderindex;
	}

	public void setOrderindex(Integer orderindex) {
		this.orderindex = orderindex;
	}

	public Integer getPlanid() {
		return planid;
	}

	public void setPlanid(Integer planid) {
		this.planid = planid;
	}

	public Integer getPlantaskid() {
		return plantaskid;
	}

	public void setPlantaskid(Integer plantaskid) {
		this.plantaskid = plantaskid;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
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

	public String getTaskname() {
		return taskname;
	}

	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}

	public Integer getTotallaborquantity() {
		return totallaborquantity;
	}

	public void setTotallaborquantity(Integer totallaborquantity) {
		this.totallaborquantity = totallaborquantity;
	}

	public Integer getWorkitemid() {
		return workitemid;
	}

	public void setWorkitemid(Integer workitemid) {
		this.workitemid = workitemid;
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

	@Override
	public String toString() {
		return "CmsPlanJsonDTO [amountofwork=" + amountofwork + ", costestimateid=" + costestimateid + ", orderindex="
				+ orderindex + ", planid=" + planid + ", plantaskid=" + plantaskid + ", startdate=" + startdate
				+ ", enddate=" + enddate + ", quantityunitid=" + quantityunitid + ", quantityunitname="
				+ quantityunitname + ", taskid=" + taskid + ", taskcode=" + taskcode + ", taskname=" + taskname
				+ ", totallaborquantity=" + totallaborquantity + ", workitemid=" + workitemid + ", workitemcode="
				+ workitemcode + ", workitemname=" + workitemname + "]";
	}
	
	

}
