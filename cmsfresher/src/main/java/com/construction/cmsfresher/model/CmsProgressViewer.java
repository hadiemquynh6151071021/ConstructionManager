package com.construction.cmsfresher.model;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;


/**
 * The persistent class for the cms_progress_viewers database table.
 * 
 */
@Entity
@Table(name="cms_progress_viewers")
@NamedQuery(name="CmsProgressViewer.findAll", query="SELECT c FROM CmsProgressViewer c")
public class CmsProgressViewer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer progressviewerid;

	private Timestamp viewtime;

	//bi-directional many-to-one association to CmsProgress
	@ManyToOne
	@JoinColumn(name="progressid")
	private CmsProgress cmsProgress;

	//bi-directional many-to-one association to MdEmployee
	@ManyToOne
	@JoinColumn(name="viewerid")
	private MdEmployee mdEmployee;

	public CmsProgressViewer() {
	}

	public Integer getProgressviewerid() {
		return this.progressviewerid;
	}

	public void setProgressviewerid(Integer progressviewerid) {
		this.progressviewerid = progressviewerid;
	}

	public Timestamp getViewtime() {
		return this.viewtime;
	}

	public void setViewtime(Timestamp viewtime) {
		this.viewtime = viewtime;
	}

	public CmsProgress getCmsProgress() {
		return this.cmsProgress;
	}

	public void setCmsProgress(CmsProgress cmsProgress) {
		this.cmsProgress = cmsProgress;
	}

	public MdEmployee getMdEmployee() {
		return this.mdEmployee;
	}

	public void setMdEmployee(MdEmployee mdEmployee) {
		this.mdEmployee = mdEmployee;
	}

}