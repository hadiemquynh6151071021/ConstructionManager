package com.construction.cmsfresher.dto.response.cmsdiaryhistorydto;

import java.sql.Timestamp;

import com.construction.cmsfresher.dto.response.cmsdiaryactiondto.CmsDiaryActionDTO;
import com.construction.cmsfresher.dto.response.mdemployeedto.MdEmployeeDTO;

public class CmsDiaryHistoryDTO {
	private Integer diaryhistoryid;

	private Timestamp actiontime;

	private String decsription;

	private CmsDiaryActionDTO cmsDiaryAction;

	private MdEmployeeDTO mdEmployee;

	public Integer getDiaryhistoryid() {
		return diaryhistoryid;
	}

	public void setDiaryhistoryid(Integer diaryhistoryid) {
		this.diaryhistoryid = diaryhistoryid;
	}

	public Timestamp getActiontime() {
		return actiontime;
	}

	public void setActiontime(Timestamp actiontime) {
		this.actiontime = actiontime;
	}

	public String getDecsription() {
		return decsription;
	}

	public void setDecsription(String decsription) {
		this.decsription = decsription;
	}

	public CmsDiaryActionDTO getCmsDiaryAction() {
		return cmsDiaryAction;
	}

	public void setCmsDiaryAction(CmsDiaryActionDTO cmsDiaryAction) {
		this.cmsDiaryAction = cmsDiaryAction;
	}

	public MdEmployeeDTO getMdEmployee() {
		return mdEmployee;
	}

	public void setMdEmployee(MdEmployeeDTO mdEmployee) {
		this.mdEmployee = mdEmployee;
	}

}
