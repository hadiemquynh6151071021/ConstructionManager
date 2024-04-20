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
 * The persistent class for the cms_laborstates database table.
 * 
 */
@Entity
@Table(name="cms_laborstates")
@NamedQuery(name="CmsLaborstate.findAll", query="SELECT c FROM CmsLaborstate c")
public class CmsLaborstate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer laborstateid;

	private String laborstatename;

	//bi-directional many-to-one association to CmsConstructionsiteLabor
	@OneToMany(mappedBy="cmsLaborstate")
	@JsonIgnore
	private List<CmsConstructionsiteLabor> cmsConstructionsiteLabors;

	public CmsLaborstate() {
	}

	public Integer getLaborstateid() {
		return this.laborstateid;
	}

	public void setLaborstateid(Integer laborstateid) {
		this.laborstateid = laborstateid;
	}

	public String getLaborstatename() {
		return this.laborstatename;
	}

	public void setLaborstatename(String laborstatename) {
		this.laborstatename = laborstatename;
	}

	public List<CmsConstructionsiteLabor> getCmsConstructionsiteLabors() {
		return this.cmsConstructionsiteLabors;
	}

	public void setCmsConstructionsiteLabors(List<CmsConstructionsiteLabor> cmsConstructionsiteLabors) {
		this.cmsConstructionsiteLabors = cmsConstructionsiteLabors;
	}

	public CmsConstructionsiteLabor addCmsConstructionsiteLabor(CmsConstructionsiteLabor cmsConstructionsiteLabor) {
		getCmsConstructionsiteLabors().add(cmsConstructionsiteLabor);
		cmsConstructionsiteLabor.setCmsLaborstate(this);

		return cmsConstructionsiteLabor;
	}

	public CmsConstructionsiteLabor removeCmsConstructionsiteLabor(CmsConstructionsiteLabor cmsConstructionsiteLabor) {
		getCmsConstructionsiteLabors().remove(cmsConstructionsiteLabor);
		cmsConstructionsiteLabor.setCmsLaborstate(null);

		return cmsConstructionsiteLabor;
	}

}