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
 * The persistent class for the md_brands database table.
 * 
 */
@Entity
@Table(name="md_brands")
@NamedQuery(name="MdBrand.findAll", query="SELECT m FROM MdBrand m")
public class MdBrand implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer brandid;

	private String brandname;

	//bi-directional many-to-one association to MdCompany
	@ManyToOne
	@JoinColumn(name="companyid")
	private MdCompany mdCompany;

	//bi-directional many-to-one association to MdConstructionType
	@OneToMany(mappedBy="mdBrand")
	@JsonIgnore
	private List<MdConstructionType> mdConstructionTypes;

	public MdBrand() {
	}

	public Integer getBrandid() {
		return this.brandid;
	}

	public void setBrandid(Integer brandid) {
		this.brandid = brandid;
	}

	public String getBrandname() {
		return this.brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	public MdCompany getMdCompany() {
		return this.mdCompany;
	}

	public void setMdCompany(MdCompany mdCompany) {
		this.mdCompany = mdCompany;
	}

	public List<MdConstructionType> getMdConstructionTypes() {
		return this.mdConstructionTypes;
	}

	public void setMdConstructionTypes(List<MdConstructionType> mdConstructionTypes) {
		this.mdConstructionTypes = mdConstructionTypes;
	}

	public MdConstructionType addMdConstructionType(MdConstructionType mdConstructionType) {
		getMdConstructionTypes().add(mdConstructionType);
		mdConstructionType.setMdBrand(this);

		return mdConstructionType;
	}

	public MdConstructionType removeMdConstructionType(MdConstructionType mdConstructionType) {
		getMdConstructionTypes().remove(mdConstructionType);
		mdConstructionType.setMdBrand(null);

		return mdConstructionType;
	}

}