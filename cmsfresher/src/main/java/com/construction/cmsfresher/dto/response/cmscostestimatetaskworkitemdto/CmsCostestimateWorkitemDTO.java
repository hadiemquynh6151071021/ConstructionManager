package com.construction.cmsfresher.dto.response.cmscostestimatetaskworkitemdto;

import com.construction.cmsfresher.dto.response.mdworkitemsdto.MdWorkItemDTO;

public class CmsCostestimateWorkitemDTO {
	private Integer costestimateworkitemid;

	private MdWorkItemDTO mdWorkItem;

	public Integer getCostestimateworkitemid() {
		return costestimateworkitemid;
	}

	public void setCostestimateworkitemid(Integer costestimateworkitemid) {
		this.costestimateworkitemid = costestimateworkitemid;
	}

	public MdWorkItemDTO getMdWorkItem() {
		return mdWorkItem;
	}

	public void setMdWorkItem(MdWorkItemDTO mdWorkItem) {
		this.mdWorkItem = mdWorkItem;
	}

}
