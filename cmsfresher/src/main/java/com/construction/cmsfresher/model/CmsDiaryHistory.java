package com.construction.cmsfresher.model;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;


/**
 * The persistent class for the cms_diary_histories database table.
 * 
 */
@Entity
@Table(name="cms_diary_histories")
@NamedQuery(name="CmsDiaryHistory.findAll", query="SELECT c FROM CmsDiaryHistory c")
public class CmsDiaryHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer diaryhistoryid;

	private Timestamp actiontime;

	private String decsription;

	//bi-directional many-to-one association to CmsConstructionDiary
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="diaryid")
	private CmsConstructionDiary cmsConstructionDiary;

	//bi-directional many-to-one association to CmsDiaryAction
	@ManyToOne
	@JoinColumn(name="diaryactionid")
	private CmsDiaryAction cmsDiaryAction;

	//bi-directional many-to-one association to MdEmployee
	@ManyToOne
	@JoinColumn(name="actorid")
	private MdEmployee mdEmployee;

	public CmsDiaryHistory() {
	}

	public Integer getDiaryhistoryid() {
		return this.diaryhistoryid;
	}

	public void setDiaryhistoryid(Integer diaryhistoryid) {
		this.diaryhistoryid = diaryhistoryid;
	}

	public Timestamp getActiontime() {
		return this.actiontime;
	}

	public void setActiontime(Timestamp actiontime) {
		this.actiontime = actiontime;
	}

	public String getDecsription() {
		return this.decsription;
	}

	public void setDecsription(String decsription) {
		this.decsription = decsription;
	}

	public CmsConstructionDiary getCmsConstructionDiary() {
		return this.cmsConstructionDiary;
	}

	public void setCmsConstructionDiary(CmsConstructionDiary cmsConstructionDiary) {
		this.cmsConstructionDiary = cmsConstructionDiary;
	}

	public CmsDiaryAction getCmsDiaryAction() {
		return this.cmsDiaryAction;
	}

	public void setCmsDiaryAction(CmsDiaryAction cmsDiaryAction) {
		this.cmsDiaryAction = cmsDiaryAction;
	}

	public MdEmployee getMdEmployee() {
		return this.mdEmployee;
	}

	public void setMdEmployee(MdEmployee mdEmployee) {
		this.mdEmployee = mdEmployee;
	}

}