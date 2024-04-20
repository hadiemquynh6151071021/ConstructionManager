package com.construction.cmsfresher.dto.response.cmsplantaskdto;

import java.util.Date;

import com.construction.cmsfresher.dto.response.mdtaskdto.MdTaskDTO;
import com.construction.cmsfresher.dto.response.mdworkitemsdto.MdWorkItemDiaryDTO;

public class CmsPlanTaskDTO {
	private Integer plantaskid;
	private Integer amountofwork;
	private Date enddate;

	private Integer orderindex;

	private Date startdate;

	private Integer totallaborquantity;

	private MdTaskDTO mdTask;

	private MdWorkItemDiaryDTO mdWorkItem;

	public Integer getPlantaskid() {
		return plantaskid;
	}

	public void setPlantaskid(Integer plantaskid) {
		this.plantaskid = plantaskid;
	}

	public Integer getAmountofwork() {
		return amountofwork;
	}

	public void setAmountofwork(Integer amountofwork) {
		this.amountofwork = amountofwork;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Integer getOrderindex() {
		return orderindex;
	}

	public void setOrderindex(Integer orderindex) {
		this.orderindex = orderindex;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Integer getTotallaborquantity() {
		return totallaborquantity;
	}

	public void setTotallaborquantity(Integer totallaborquantity) {
		this.totallaborquantity = totallaborquantity;
	}

	public MdTaskDTO getMdTask() {
		return mdTask;
	}

	public void setMdTask(MdTaskDTO mdTask) {
		this.mdTask = mdTask;
	}

	public MdWorkItemDiaryDTO getMdWorkItem() {
		return mdWorkItem;
	}

	public void setMdWorkItem(MdWorkItemDiaryDTO mdWorkItem) {
		this.mdWorkItem = mdWorkItem;
	}

	

}
