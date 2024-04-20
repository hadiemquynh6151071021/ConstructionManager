package com.construction.cmsfresher.dto.response.cmsplandto;

import java.util.List;

import com.construction.cmsfresher.dto.response.cmsplanworkitemdto.CmsPlanWorkItemDTO;

public class CmsPlanFromPlanTaskDTO {

	// CmsPlanDetaiDTO dành cho plan task
	private List<CmsPlanWorkItemDTO> cmsPlanWorkitems;

	public List<CmsPlanWorkItemDTO> getCmsPlanWorkitems() {
		return cmsPlanWorkitems;
	}

	public void setCmsPlanWorkitems(List<CmsPlanWorkItemDTO> cmsPlanWorkitems) {
		this.cmsPlanWorkitems = cmsPlanWorkitems;
	}
	
	
}
