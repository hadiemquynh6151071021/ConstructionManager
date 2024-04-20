package com.construction.cmsfresher.dto.response.cmsplantaskdto;

import com.construction.cmsfresher.dto.response.cmsplandto.CmsPlanDetaiDTO;
import com.construction.cmsfresher.dto.response.mdtaskdto.MdTaskDTO;
import com.construction.cmsfresher.dto.response.mdworkitemsdto.MdWorkItemDTO;

public class CmsPlanTaskDetailDTO {

	private Integer plantaskid;
	private Integer amountofwork;

	
	private CmsPlanDetaiDTO cmsPlan;
	
	private MdTaskDTO mdTask;
	
	private MdWorkItemDTO mdWorkItem;

	public Integer getPlantaskid() {
		return plantaskid;
	}

	public void setPlantaskid(Integer plantaskid) {
		this.plantaskid = plantaskid;
	}

	public CmsPlanDetaiDTO getCmsPlan() {
		return cmsPlan;
	}

	public void setCmsPlan(CmsPlanDetaiDTO cmsPlan) {
		this.cmsPlan = cmsPlan;
	}

	public MdWorkItemDTO getMdWorkItem() {
		return mdWorkItem;
	}

	public void setMdWorkItem(MdWorkItemDTO mdWorkItem) {
		this.mdWorkItem = mdWorkItem;
	}

	public MdTaskDTO getMdTask() {
		return mdTask;
	}

	public void setMdTask(MdTaskDTO mdTask) {
		this.mdTask = mdTask;
	}

	public Integer getAmountofwork() {
		return amountofwork;
	}

	public void setAmountofwork(Integer amountofwork) {
		this.amountofwork = amountofwork;
	}

		
	
}
