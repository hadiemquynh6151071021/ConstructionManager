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
 * The persistent class for the md_quantity_units database table.
 * 
 */
@Entity
@Table(name = "md_quantity_units")
@NamedQuery(name = "MdQuantityUnit.findAll", query = "SELECT m FROM MdQuantityUnit m")
public class MdQuantityUnit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer quantityunitid;

	private Boolean isalloweddecimal;

	private String quantityunitname;

	// bi-directional many-to-one association to CmsConstructionDiary
	@OneToMany(mappedBy = "mdQuantityUnit")
	@JsonIgnore
	private List<CmsConstructionDiary> cmsConstructionDiaries;

	// bi-directional many-to-one association to CmsPlanTask
	@OneToMany(mappedBy = "mdQuantityUnit")
	@JsonIgnore
	private List<CmsPlanTask> cmsPlanTasks;

	// bi-directional many-to-one association to CmsProgress

	// bi-directional many-to-one association to MdProduct
	@OneToMany(mappedBy = "mdQuantityUnit")
	@JsonIgnore
	private List<MdProduct> mdProducts;

	// bi-directional many-to-one association to MdTask
	@OneToMany(mappedBy = "mdQuantityUnit")
	@JsonIgnore
	private List<MdTask> mdTasks;

	public MdQuantityUnit() {
	}

	public Integer getQuantityunitid() {
		return this.quantityunitid;
	}

	public void setQuantityunitid(Integer quantityunitid) {
		this.quantityunitid = quantityunitid;
	}

	public Boolean getIsalloweddecimal() {
		return this.isalloweddecimal;
	}

	public void setIsalloweddecimal(Boolean isalloweddecimal) {
		this.isalloweddecimal = isalloweddecimal;
	}

	public String getQuantityunitname() {
		return this.quantityunitname;
	}

	public void setQuantityunitname(String quantityunitname) {
		this.quantityunitname = quantityunitname;
	}

	public List<CmsConstructionDiary> getCmsConstructionDiaries() {
		return this.cmsConstructionDiaries;
	}

	public void setCmsConstructionDiaries(List<CmsConstructionDiary> cmsConstructionDiaries) {
		this.cmsConstructionDiaries = cmsConstructionDiaries;
	}

	public CmsConstructionDiary addCmsConstructionDiary(CmsConstructionDiary cmsConstructionDiary) {
		getCmsConstructionDiaries().add(cmsConstructionDiary);
		cmsConstructionDiary.setMdQuantityUnit(this);

		return cmsConstructionDiary;
	}

	public CmsConstructionDiary removeCmsConstructionDiary(CmsConstructionDiary cmsConstructionDiary) {
		getCmsConstructionDiaries().remove(cmsConstructionDiary);
		cmsConstructionDiary.setMdQuantityUnit(null);

		return cmsConstructionDiary;
	}

	public List<CmsPlanTask> getCmsPlanTasks() {
		return this.cmsPlanTasks;
	}

	public void setCmsPlanTasks(List<CmsPlanTask> cmsPlanTasks) {
		this.cmsPlanTasks = cmsPlanTasks;
	}

	public CmsPlanTask addCmsPlanTask(CmsPlanTask cmsPlanTask) {
		getCmsPlanTasks().add(cmsPlanTask);
		cmsPlanTask.setMdQuantityUnit(this);

		return cmsPlanTask;
	}

	public CmsPlanTask removeCmsPlanTask(CmsPlanTask cmsPlanTask) {
		getCmsPlanTasks().remove(cmsPlanTask);
		cmsPlanTask.setMdQuantityUnit(null);

		return cmsPlanTask;
	}

	public List<MdProduct> getMdProducts() {
		return this.mdProducts;
	}

	public void setMdProducts(List<MdProduct> mdProducts) {
		this.mdProducts = mdProducts;
	}

	public MdProduct addMdProduct(MdProduct mdProduct) {
		getMdProducts().add(mdProduct);
		mdProduct.setMdQuantityUnit(this);

		return mdProduct;
	}

	public MdProduct removeMdProduct(MdProduct mdProduct) {
		getMdProducts().remove(mdProduct);
		mdProduct.setMdQuantityUnit(null);

		return mdProduct;
	}

	public List<MdTask> getMdTasks() {
		return this.mdTasks;
	}

	public void setMdTasks(List<MdTask> mdTasks) {
		this.mdTasks = mdTasks;
	}

	public MdTask addMdTask(MdTask mdTask) {
		getMdTasks().add(mdTask);
		mdTask.setMdQuantityUnit(this);

		return mdTask;
	}

	public MdTask removeMdTask(MdTask mdTask) {
		getMdTasks().remove(mdTask);
		mdTask.setMdQuantityUnit(null);

		return mdTask;
	}

}