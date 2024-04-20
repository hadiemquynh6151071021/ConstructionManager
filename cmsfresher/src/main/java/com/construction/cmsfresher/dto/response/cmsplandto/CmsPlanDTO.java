package com.construction.cmsfresher.dto.response.cmsplandto;

import java.util.Date;
import java.util.List;

import com.construction.cmsfresher.dto.response.cmsplanstatedto.CmsPlanStateDTO;
import com.construction.cmsfresher.dto.response.mdemployeedto.MdEmployeeDTO;

public class CmsPlanDTO {
	
	//thiếu mã công trình, tên công trình

	private Integer planid;
	private String planname;
	private String planidcode;
	
	private Date startdate;    
	private Date enddate;

	private MdEmployeeDTO mdEmployee;
//	private MdConstructionSiteDetailDTO mdConstructionSite;
	private CmsPlanStateDTO cmsPlanState;
	private List<MdEmployeeDTO> mdEmployees;

	public Integer getPlanid() {
		return planid;
	}

	public void setPlanid(Integer planid) {
		this.planid = planid;
	}

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

	public MdEmployeeDTO getMdEmployee() {
		return mdEmployee;
	}

	public void setMdEmployee(MdEmployeeDTO mdEmployee) {
		this.mdEmployee = mdEmployee;
	}

	
	public CmsPlanStateDTO getCmsPlanState() {
		return cmsPlanState;
	}

	public void setCmsPlanState(CmsPlanStateDTO cmsPlanState) {
		this.cmsPlanState = cmsPlanState;
	}

	public List<MdEmployeeDTO> getMdEmployees() {
		return mdEmployees;
	}

	public void setMdEmployees(List<MdEmployeeDTO> mdEmployees) {
		this.mdEmployees = mdEmployees;
	}

}
