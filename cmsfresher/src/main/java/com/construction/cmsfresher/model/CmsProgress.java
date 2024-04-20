package com.construction.cmsfresher.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * The persistent class for the cms_progresses database table.
 * 
 */
@Entity
@Table(name = "cms_progresses")
@NamedQuery(name = "CmsProgress.findAll", query = "SELECT c FROM CmsProgress c")
public class CmsProgress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer progressid;

	private Integer amountofworkdone;

	private Integer totalamountofworkdone;

	// bi-directional many-to-one association to CmsProgressViewer
	@OneToMany(mappedBy = "cmsProgress", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<CmsProgressViewer> cmsProgressViewers;

	// bi-directional many-to-one association to CmsConstructionDiary
	@OneToOne
	@JsonIgnore
	@JoinColumn(name = "diaryid")
	private CmsConstructionDiary cmsConstructionDiary;

	// bi-directional many-to-one association to MdQuantityUnit

	public CmsProgress() {
	}

	public Integer getProgressid() {
		return this.progressid;
	}

	public void setProgressid(Integer progressid) {
		this.progressid = progressid;
	}

	public Integer getAmountofworkdone() {
		return this.amountofworkdone;
	}

	public void setAmountofworkdone(Integer amountofworkdone) {
		this.amountofworkdone = amountofworkdone;
	}

	public Integer getTotalamountofworkdone() {
		return this.totalamountofworkdone;
	}

	public void setTotalamountofworkdone(Integer totalamountofworkdone) {
		this.totalamountofworkdone = totalamountofworkdone;
	}

	public List<CmsProgressViewer> getCmsProgressViewers() {
		return this.cmsProgressViewers;
	}

	public void setCmsProgressViewers(List<CmsProgressViewer> cmsProgressViewers) {
		this.cmsProgressViewers = cmsProgressViewers;
	}

	public CmsProgressViewer addCmsProgressViewer(CmsProgressViewer cmsProgressViewer) {
		getCmsProgressViewers().add(cmsProgressViewer);
		cmsProgressViewer.setCmsProgress(this);

		return cmsProgressViewer;
	}

	public CmsProgressViewer removeCmsProgressViewer(CmsProgressViewer cmsProgressViewer) {
		getCmsProgressViewers().remove(cmsProgressViewer);
		cmsProgressViewer.setCmsProgress(null);

		return cmsProgressViewer;
	}

	public CmsConstructionDiary getCmsConstructionDiary() {
		return this.cmsConstructionDiary;
	}

	public void setCmsConstructionDiary(CmsConstructionDiary cmsConstructionDiary) {
		this.cmsConstructionDiary = cmsConstructionDiary;
	}

}