package com.construction.cmsfresher.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


/**
 * The persistent class for the cms_diary_actions database table.
 * 
 */
@Entity
@Table(name="cms_diary_actions")
@NamedQuery(name="CmsDiaryAction.findAll", query="SELECT c FROM CmsDiaryAction c")
public class CmsDiaryAction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer diaryactionid;

	private String diaryactionname;

	//bi-directional many-to-one association to CmsDiaryHistory
	@OneToMany(mappedBy="cmsDiaryAction")
	@JsonIgnore
	private List<CmsDiaryHistory> cmsDiaryHistories;

	public CmsDiaryAction() {
	}

	public Integer getDiaryactionid() {
		return this.diaryactionid;
	}

	public void setDiaryactionid(Integer diaryactionid) {
		this.diaryactionid = diaryactionid;
	}

	public String getDiaryactionname() {
		return this.diaryactionname;
	}

	public void setDiaryactionname(String diaryactionname) {
		this.diaryactionname = diaryactionname;
	}

	public List<CmsDiaryHistory> getCmsDiaryHistories() {
		return this.cmsDiaryHistories;
	}

	public void setCmsDiaryHistories(List<CmsDiaryHistory> cmsDiaryHistories) {
		this.cmsDiaryHistories = cmsDiaryHistories;
	}

	public CmsDiaryHistory addCmsDiaryHistory(CmsDiaryHistory cmsDiaryHistory) {
		getCmsDiaryHistories().add(cmsDiaryHistory);
		cmsDiaryHistory.setCmsDiaryAction(this);

		return cmsDiaryHistory;
	}

	public CmsDiaryHistory removeCmsDiaryHistory(CmsDiaryHistory cmsDiaryHistory) {
		getCmsDiaryHistories().remove(cmsDiaryHistory);
		cmsDiaryHistory.setCmsDiaryAction(null);

		return cmsDiaryHistory;
	}

}