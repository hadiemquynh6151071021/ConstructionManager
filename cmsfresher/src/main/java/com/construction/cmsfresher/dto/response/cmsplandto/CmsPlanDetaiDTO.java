package com.construction.cmsfresher.dto.response.cmsplandto;

import com.construction.cmsfresher.dto.response.mdconstructionsitedto.MdConstructionSiteDetaiDTO;

public class CmsPlanDetaiDTO {

	private Integer planid;
	private String planidcode;
	private String planname;

	
	// CmsPlanDetaiDTO dành cho nhật ký
	private MdConstructionSiteDetaiDTO mdConstructionSite;

	public MdConstructionSiteDetaiDTO getMdConstructionSite() {
		return mdConstructionSite;
	}

	public void setMdConstructionSite(MdConstructionSiteDetaiDTO mdConstructionSite) {
		this.mdConstructionSite = mdConstructionSite;
	}

	public Integer getPlanid() {
		return planid;
	}

	public void setPlanid(Integer planid) {
		this.planid = planid;
	}

	public String getPlanidcode() {
		return planidcode;
	}

	public void setPlanidcode(String planidcode) {
		this.planidcode = planidcode;
	}

	public String getPlanname() {
		return planname;
	}

	public void setPlanname(String planname) {
		this.planname = planname;
	}
	
	
	
}
