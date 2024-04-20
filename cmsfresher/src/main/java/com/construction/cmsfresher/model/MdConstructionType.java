package com.construction.cmsfresher.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


/**
 * The persistent class for the md_construction_types database table.
 * 
 */
@Entity
@Table(name="md_construction_types")
@NamedQuery(name="MdConstructionType.findAll", query="SELECT m FROM MdConstructionType m")
public class MdConstructionType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer constructiontypeid;

	private String constructiontypename;

	//bi-directional many-to-one association to MdConstructionSite
	@OneToMany(mappedBy="mdConstructionType")
	@JsonIgnore
	private List<MdConstructionSite> mdConstructionSites;

	//bi-directional many-to-one association to MdBrand
	@ManyToOne
	@JoinColumn(name="brandid")
	private MdBrand mdBrand;

	public MdConstructionType() {
	}

	public Integer getConstructiontypeid() {
		return this.constructiontypeid;
	}

	public void setConstructiontypeid(Integer constructiontypeid) {
		this.constructiontypeid = constructiontypeid;
	}

	public String getConstructiontypename() {
		return this.constructiontypename;
	}

	public void setConstructiontypename(String constructiontypename) {
		this.constructiontypename = constructiontypename;
	}

	public List<MdConstructionSite> getMdConstructionSites() {
		return this.mdConstructionSites;
	}

	public void setMdConstructionSites(List<MdConstructionSite> mdConstructionSites) {
		this.mdConstructionSites = mdConstructionSites;
	}

	public MdConstructionSite addMdConstructionSite(MdConstructionSite mdConstructionSite) {
		getMdConstructionSites().add(mdConstructionSite);
		mdConstructionSite.setMdConstructionType(this);

		return mdConstructionSite;
	}

	public MdConstructionSite removeMdConstructionSite(MdConstructionSite mdConstructionSite) {
		getMdConstructionSites().remove(mdConstructionSite);
		mdConstructionSite.setMdConstructionType(null);

		return mdConstructionSite;
	}

	public MdBrand getMdBrand() {
		return this.mdBrand;
	}

	public void setMdBrand(MdBrand mdBrand) {
		this.mdBrand = mdBrand;
	}

}