package com.construction.cmsfresher.dto.request.cmsplansdto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CmsPlansDTO {

	private String planname;
	private String planidcode;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date startdate;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date enddate;

	private Integer mdConstructionSite;
	private Integer mdEmployee;

	private Integer cmsPlanAction;

	private List<CmsPlanWorkItemDTO> listPlanWorkItem;
	private List<Integer> approvers;

	public String getPlanname() {
		return planname;
	}

	public void setPlanname(String planname) {
		this.planname = planname;
	}

	public String getPlanidcode() {
		return planidcode;
	}

	public void setPlanidcode(String planidcode) {
		this.planidcode = planidcode;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Integer getMdConstructionSite() {
		return mdConstructionSite;
	}

	public void setMdConstructionSite(Integer mdConstructionSite) {
		this.mdConstructionSite = mdConstructionSite;
	}

	public Integer getMdEmployee() {
		return mdEmployee;
	}

	public void setMdEmployee(Integer mdEmployee) {
		this.mdEmployee = mdEmployee;
	}

	public Integer getCmsPlanAction() {
		return cmsPlanAction;
	}

	public void setCmsPlanAction(Integer cmsPlanAction) {
		this.cmsPlanAction = cmsPlanAction;
	}

	public List<CmsPlanWorkItemDTO> getListPlanWorkItem() {
		return listPlanWorkItem;
	}

	public void setListPlanWorkItem(List<CmsPlanWorkItemDTO> listPlanWorkItem) {
		this.listPlanWorkItem = listPlanWorkItem;
	}

	public List<Integer> getApprovers() {
		return approvers;
	}

	public void setApprovers(List<Integer> approvers) {
		this.approvers = approvers;
	}

}
