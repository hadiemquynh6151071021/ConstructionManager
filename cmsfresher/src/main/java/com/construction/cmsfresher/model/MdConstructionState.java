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
 * The persistent class for the md_construction_states database table.
 * 
 */
@Entity
@Table(name="md_construction_states")
@NamedQuery(name="MdConstructionState.findAll", query="SELECT m FROM MdConstructionState m")
public class MdConstructionState implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer constructionstateid;

	private String constructionstatename;

	//bi-directional many-to-one association to MdConstructionSite
	@OneToMany(mappedBy="mdConstructionState")
	@JsonIgnore
	private List<MdConstructionSite> mdConstructionSites;

	public MdConstructionState() {
	}

	public Integer getConstructionstateid() {
		return this.constructionstateid;
	}

	public void setConstructionstateid(Integer constructionstateid) {
		this.constructionstateid = constructionstateid;
	}

	public String getConstructionstatename() {
		return this.constructionstatename;
	}

	public void setConstructionstatename(String constructionstatename) {
		this.constructionstatename = constructionstatename;
	}

	public List<MdConstructionSite> getMdConstructionSites() {
		return this.mdConstructionSites;
	}

	public void setMdConstructionSites(List<MdConstructionSite> mdConstructionSites) {
		this.mdConstructionSites = mdConstructionSites;
	}

	public MdConstructionSite addMdConstructionSite(MdConstructionSite mdConstructionSite) {
		getMdConstructionSites().add(mdConstructionSite);
		mdConstructionSite.setMdConstructionState(this);

		return mdConstructionSite;
	}

	public MdConstructionSite removeMdConstructionSite(MdConstructionSite mdConstructionSite) {
		getMdConstructionSites().remove(mdConstructionSite);
		mdConstructionSite.setMdConstructionState(null);

		return mdConstructionSite;
	}

}