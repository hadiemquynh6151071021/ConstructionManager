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
 * The persistent class for the cms_diary_states database table.
 * 
 */
@Entity
@Table(name="cms_diary_states")
@NamedQuery(name="CmsDiaryState.findAll", query="SELECT c FROM CmsDiaryState c")
public class CmsDiaryState implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer diarystateid;

	private String diarystatename;

	//bi-directional many-to-one association to CmsConstructionDiary
	@OneToMany(mappedBy="cmsDiaryState")
	@JsonIgnore
	private List<CmsConstructionDiary> cmsConstructionDiaries;

	public CmsDiaryState() {
	}

	public Integer getDiarystateid() {
		return this.diarystateid;
	}

	public void setDiarystateid(Integer diarystateid) {
		this.diarystateid = diarystateid;
	}

	public String getDiarystatename() {
		return this.diarystatename;
	}

	public void setDiarystatename(String diarystatename) {
		this.diarystatename = diarystatename;
	}

	public List<CmsConstructionDiary> getCmsConstructionDiaries() {
		return this.cmsConstructionDiaries;
	}

	public void setCmsConstructionDiaries(List<CmsConstructionDiary> cmsConstructionDiaries) {
		this.cmsConstructionDiaries = cmsConstructionDiaries;
	}

	public CmsConstructionDiary addCmsConstructionDiary(CmsConstructionDiary cmsConstructionDiary) {
		getCmsConstructionDiaries().add(cmsConstructionDiary);
		cmsConstructionDiary.setCmsDiaryState(this);

		return cmsConstructionDiary;
	}

	public CmsConstructionDiary removeCmsConstructionDiary(CmsConstructionDiary cmsConstructionDiary) {
		getCmsConstructionDiaries().remove(cmsConstructionDiary);
		cmsConstructionDiary.setCmsDiaryState(null);

		return cmsConstructionDiary;
	}

}