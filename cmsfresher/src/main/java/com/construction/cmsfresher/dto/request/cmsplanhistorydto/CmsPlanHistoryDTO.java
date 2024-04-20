package com.construction.cmsfresher.dto.request.cmsplanhistorydto;

import java.sql.Timestamp;

public class CmsPlanHistoryDTO {

	private String description;
	private Timestamp actiontime;
	private Integer mdEmployee;
	private Integer cmsPlan;
	private Integer cmsPlanAction;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getActiontime() {
		return actiontime;
	}

	public void setActiontime(Timestamp actiontime) {
		this.actiontime = actiontime;
	}

	public Integer getMdEmployee() {
		return mdEmployee;
	}

	public void setMdEmployee(Integer mdEmployee) {
		this.mdEmployee = mdEmployee;
	}

	public Integer getCmsPlan() {
		return cmsPlan;
	}

	public void setCmsPlan(Integer cmsPlan) {
		this.cmsPlan = cmsPlan;
	}

	public Integer getCmsPlanAction() {
		return cmsPlanAction;
	}

	public void setCmsPlanAction(Integer cmsPlanAction) {
		this.cmsPlanAction = cmsPlanAction;
	}

}
