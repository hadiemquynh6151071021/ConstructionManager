package com.construction.cmsfresher.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;


/**
 * The persistent class for the cms_diary_task_employees database table.
 * 
 */
@Entity
@Table(name="cms_diary_task_employees")
@NamedQuery(name="CmsDiaryTaskEmployee.findAll", query="SELECT c FROM CmsDiaryTaskEmployee c")
public class CmsDiaryTaskEmployee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer diarytaskemployeeid;

	//bi-directional many-to-one association to CmsConstructionDiary
	@ManyToOne
	@JoinColumn(name="diaryid")
	private CmsConstructionDiary cmsConstructionDiary;

	//bi-directional many-to-one association to MdShift
	@ManyToOne
	@JoinColumn(name="shiftid")
	private MdShift mdShift;
	
	@ManyToOne
	@JoinColumn(name="employeeid")
	private MdEmployee laborsid;

	public CmsDiaryTaskEmployee() {
	}

	public Integer getDiarytaskemployeeid() {
		return this.diarytaskemployeeid;
	}

	public void setDiarytaskemployeeid(Integer diarytaskemployeeid) {
		this.diarytaskemployeeid = diarytaskemployeeid;
	}

	public CmsConstructionDiary getCmsConstructionDiary() {
		return this.cmsConstructionDiary;
	}

	public void setCmsConstructionDiary(CmsConstructionDiary cmsConstructionDiary) {
		this.cmsConstructionDiary = cmsConstructionDiary;
	}

	public MdShift getMdShift() {
		return this.mdShift;
	}

	public void setMdShift(MdShift mdShift) {
		this.mdShift = mdShift;
	}

	

	public MdEmployee getLaborsid() {
		return laborsid;
	}

	public void setLaborsid(MdEmployee laborsid) {
		this.laborsid = laborsid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}