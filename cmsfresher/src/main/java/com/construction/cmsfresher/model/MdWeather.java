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
 * The persistent class for the md_weathers database table.
 * 
 */
@Entity
@Table(name="md_weathers")
@NamedQuery(name="MdWeather.findAll", query="SELECT m FROM MdWeather m")
public class MdWeather implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer weatherid;

	private String weathername;

	//bi-directional many-to-one association to CmsConstructionDiary
	@OneToMany(mappedBy="mdWeather")
	@JsonIgnore
	private List<CmsConstructionDiary> cmsConstructionDiaries;

	public MdWeather() {
	}

	public Integer getWeatherid() {
		return this.weatherid;
	}

	public void setWeatherid(Integer weatherid) {
		this.weatherid = weatherid;
	}

	public String getWeathername() {
		return this.weathername;
	}

	public void setWeathername(String weathername) {
		this.weathername = weathername;
	}

	public List<CmsConstructionDiary> getCmsConstructionDiaries() {
		return this.cmsConstructionDiaries;
	}

	public void setCmsConstructionDiaries(List<CmsConstructionDiary> cmsConstructionDiaries) {
		this.cmsConstructionDiaries = cmsConstructionDiaries;
	}

	public CmsConstructionDiary addCmsConstructionDiary(CmsConstructionDiary cmsConstructionDiary) {
		getCmsConstructionDiaries().add(cmsConstructionDiary);
		cmsConstructionDiary.setMdWeather(this);

		return cmsConstructionDiary;
	}

	public CmsConstructionDiary removeCmsConstructionDiary(CmsConstructionDiary cmsConstructionDiary) {
		getCmsConstructionDiaries().remove(cmsConstructionDiary);
		cmsConstructionDiary.setMdWeather(null);

		return cmsConstructionDiary;
	}

}