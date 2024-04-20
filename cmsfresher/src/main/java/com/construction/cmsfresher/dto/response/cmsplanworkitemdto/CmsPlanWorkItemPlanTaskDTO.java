package com.construction.cmsfresher.dto.response.cmsplanworkitemdto;

import java.util.List;

import com.construction.cmsfresher.dto.response.cmsplandto.CmsPlanJsonDetailDTO;

public class CmsPlanWorkItemPlanTaskDTO {

	private Integer orderindex;

	private Integer workitemid;

	private String workitemCode;

	private String workitemname;
	private Integer employeeid;

	private String firstname;

	private String idcard;

	private String lastname;

	private String userid;

	private List<CmsPlanJsonDetailDTO> mdTasks;

	public Integer getOrderindex() {
		return orderindex;
	}

	public void setOrderindex(Integer orderindex) {
		this.orderindex = orderindex;
	}

	public Integer getWorkitemid() {
		return workitemid;
	}

	public void setWorkitemid(Integer workitemid) {
		this.workitemid = workitemid;
	}

	public String getWorkitemCode() {
		return workitemCode;
	}

	public void setWorkitemCode(String workitemCode) {
		this.workitemCode = workitemCode;
	}

	public String getWorkitemname() {
		return workitemname;
	}

	public void setWorkitemname(String workitemname) {
		this.workitemname = workitemname;
	}

	public List<CmsPlanJsonDetailDTO> getMdTasks() {
		return mdTasks;
	}

	public void setMdTasks(List<CmsPlanJsonDetailDTO> mdTasks) {
		this.mdTasks = mdTasks;
	}

	public Integer getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

}
