package com.construction.cmsfresher.dto.response.cmscostestimatetaskdto;

import java.util.List;

public class CmsCostEstimateTaskWorkitemDTO {

	private Integer workitemid;

	private String workitem_code;

	private String workitemname;

	private List<CmsCostEstimateTaskDetailDTO> taskDTOs;

	public Integer getWorkitemid() {
		return workitemid;
	}

	public void setWorkitemid(Integer workitemid) {
		this.workitemid = workitemid;
	}

	public String getWorkitem_code() {
		return workitem_code;
	}

	public void setWorkitem_code(String workitem_code) {
		this.workitem_code = workitem_code;
	}

	public String getWorkitemname() {
		return workitemname;
	}

	public void setWorkitemname(String workitemname) {
		this.workitemname = workitemname;
	}

	public List<CmsCostEstimateTaskDetailDTO> getTaskDTOs() {
		return taskDTOs;
	}

	public void setTaskDTOs(List<CmsCostEstimateTaskDetailDTO> taskDTOs) {
		this.taskDTOs = taskDTOs;
	}

}
