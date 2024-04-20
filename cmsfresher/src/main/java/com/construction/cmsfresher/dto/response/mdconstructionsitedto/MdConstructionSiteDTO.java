package com.construction.cmsfresher.dto.response.mdconstructionsitedto;

import java.util.Date;

import com.construction.cmsfresher.dto.response.mdconstructionstatedto.MdConstructionStateDTO;
import com.construction.cmsfresher.dto.response.mdconstructiontypedto.MdConstructionTypeDTO;
import com.construction.cmsfresher.dto.response.mdemployeedto.MdEmployeeDTO;

public class MdConstructionSiteDTO {

	private String address;
	private Integer constructionsiteid;
	private String constructionsitecode;
	private String constructionsitename;
	private Date startdate;
	private Date createddate;
	private Date enddate;

	private MdEmployeeDTO mdEmployee;

	private MdConstructionTypeDTO mdConstructionType;

	private MdConstructionStateDTO mdConstructionState;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getConstructionsitecode() {
		return constructionsitecode;
	}

	public void setConstructionsitecode(String constructionsitecode) {
		this.constructionsitecode = constructionsitecode;
	}

	public String getConstructionsitename() {
		return constructionsitename;
	}

	public void setConstructionsitename(String constructionsitename) {
		this.constructionsitename = constructionsitename;
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

	public MdConstructionTypeDTO getMdConstructionType() {
		return mdConstructionType;
	}

	public void setMdConstructionType(MdConstructionTypeDTO mdConstructionType) {
		this.mdConstructionType = mdConstructionType;
	}

	public MdConstructionStateDTO getMdConstructionState() {
		return mdConstructionState;
	}

	public void setMdConstructionState(MdConstructionStateDTO mdConstructionState) {
		this.mdConstructionState = mdConstructionState;
	}

	public Integer getConstructionsiteid() {
		return constructionsiteid;
	}

	public void setConstructionsiteid(Integer constructionsiteid) {
		this.constructionsiteid = constructionsiteid;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}
	

	

}
