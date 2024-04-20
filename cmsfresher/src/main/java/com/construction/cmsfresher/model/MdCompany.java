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
 * The persistent class for the md_companies database table.
 * 
 */
@Entity
@Table(name="md_companies")
@NamedQuery(name="MdCompany.findAll", query="SELECT m FROM MdCompany m")
public class MdCompany implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer companyid;

	private String companyaddress;

	private String companyname;

	//bi-directional many-to-one association to MdBrand
	@OneToMany(mappedBy="mdCompany")
	@JsonIgnore
	private List<MdBrand> mdBrands;

	public MdCompany() {
	}

	public Integer getCompanyid() {
		return this.companyid;
	}

	public void setCompanyid(Integer companyid) {
		this.companyid = companyid;
	}

	public String getCompanyaddress() {
		return this.companyaddress;
	}

	public void setCompanyaddress(String companyaddress) {
		this.companyaddress = companyaddress;
	}

	public String getCompanyname() {
		return this.companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public List<MdBrand> getMdBrands() {
		return this.mdBrands;
	}

	public void setMdBrands(List<MdBrand> mdBrands) {
		this.mdBrands = mdBrands;
	}

	public MdBrand addMdBrand(MdBrand mdBrand) {
		getMdBrands().add(mdBrand);
		mdBrand.setMdCompany(this);

		return mdBrand;
	}

	public MdBrand removeMdBrand(MdBrand mdBrand) {
		getMdBrands().remove(mdBrand);
		mdBrand.setMdCompany(null);

		return mdBrand;
	}

}