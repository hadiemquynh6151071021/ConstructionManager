package com.construction.cmsfresher.model;

import java.io.Serializable;

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
 * The persistent class for the cms_constructionsite_labors database table.
 * 
 */
@Entity
@Table(name = "cms_constructionsite_labors")
@NamedQuery(name = "CmsConstructionsiteLabor.findAll", query = "SELECT c FROM CmsConstructionsiteLabor c")
public class CmsConstructionsiteLabor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer constructionsitelaborid;

	// bi-directional many-to-one association to CmsLaborstate
	@ManyToOne
	@JoinColumn(name = "laborstateid")
	private CmsLaborstate cmsLaborstate;

	// bi-directional many-to-one association to MdConstructionSite
	@ManyToOne
	@JoinColumn(name = "constructionsiteid")
	private MdConstructionSite mdConstructionSite;

	// bi-directional many-to-one association to MdEmployee
	@ManyToOne
	@JoinColumn(name = "laborid")
	private MdEmployee mdEmployee;

	public CmsConstructionsiteLabor() {
	}

	public Integer getConstructionsitelaborid() {
		return constructionsitelaborid;
	}

	public void setConstructionsitelaborid(Integer constructionsitelaborid) {
		this.constructionsitelaborid = constructionsitelaborid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public CmsLaborstate getCmsLaborstate() {
		return this.cmsLaborstate;
	}

	public void setCmsLaborstate(CmsLaborstate cmsLaborstate) {
		this.cmsLaborstate = cmsLaborstate;
	}

	public MdConstructionSite getMdConstructionSite() {
		return this.mdConstructionSite;
	}

	public void setMdConstructionSite(MdConstructionSite mdConstructionSite) {
		this.mdConstructionSite = mdConstructionSite;
	}

	public MdEmployee getMdEmployee() {
		return this.mdEmployee;
	}

	public void setMdEmployee(MdEmployee mdEmployee) {
		this.mdEmployee = mdEmployee;
	}

}