package com.construction.cmsfresher.dto.response.mdtaskdto;

import com.construction.cmsfresher.dto.response.mdquantityunitdto.MdQuantityUnitDTO;

public class MdTaskDTO {

	private Integer taskid;

	private String taskcode;

	private String taskname;

	private MdQuantityUnitDTO mdQuantityUnit;

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

	public MdQuantityUnitDTO getMdQuantityUnit() {
		return mdQuantityUnit;
	}

	public void setMdQuantityUnit(MdQuantityUnitDTO mdQuantityUnit) {
		this.mdQuantityUnit = mdQuantityUnit;
	}

}
