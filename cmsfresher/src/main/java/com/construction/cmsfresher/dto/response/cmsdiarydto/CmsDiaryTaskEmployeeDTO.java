package com.construction.cmsfresher.dto.response.cmsdiarydto;

import com.construction.cmsfresher.dto.response.mdemployeedto.MdEmployeeDTO;
import com.construction.cmsfresher.model.MdShift;

public class CmsDiaryTaskEmployeeDTO {
	private Integer diarytaskemployeeid;

	private MdShift mdShift;

	private MdEmployeeDTO laborsid;

	public Integer getDiarytaskemployeeid() {
		return diarytaskemployeeid;
	}

	public void setDiarytaskemployeeid(Integer diarytaskemployeeid) {
		this.diarytaskemployeeid = diarytaskemployeeid;
	}

	public MdShift getMdShift() {
		return mdShift;
	}

	public void setMdShift(MdShift mdShift) {
		this.mdShift = mdShift;
	}

	public MdEmployeeDTO getLaborsid() {
		return laborsid;
	}

	public void setLaborsid(MdEmployeeDTO laborsid) {
		this.laborsid = laborsid;
	}

}
