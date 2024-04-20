package com.construction.cmsfresher.model;

import java.io.Serializable;
import java.util.Date;
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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 * The persistent class for the cms_plan_tasks database table.
 * 
 */
@Entity
@Table(name = "cms_plan_tasks")
@NamedQuery(name = "CmsPlanTask.findAll", query = "SELECT c FROM CmsPlanTask c")
public class CmsPlanTask implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer plantaskid;

	private Integer amountofwork;

	@Temporal(TemporalType.DATE)
	private Date enddate;

	private Integer orderindex;

	@Temporal(TemporalType.DATE)
	private Date startdate;

	private Integer totallaborquantity;

	// bi-directional many-to-one association to CmsConstructionDiary
	@OneToMany(mappedBy = "cmsPlanTask")
	@JsonIgnore
	private List<CmsConstructionDiary> cmsConstructionDiaries;

	// bi-directional many-to-one association to CmsPlanTaskLabor
	@OneToMany(mappedBy = "cmsPlanTask")
	@JsonIgnore
	private List<CmsPlanTaskLabor> cmsPlanTaskLabors;

	// bi-directional many-to-one association to CmsPlanTaskProduct
	@OneToMany(mappedBy = "cmsPlanTask")
	@JsonIgnore
	private List<CmsPlanTaskProduct> cmsPlanTaskProducts;

	// bi-directional many-to-one association to CmsPlan
	@ManyToOne
	@JoinColumn(name = "planid")
	private CmsPlan cmsPlan;

	// bi-directional many-to-one association to MdCostEstimate
	@ManyToOne
	@JoinColumn(name = "costestimateid")
	private MdCostEstimate mdCostEstimate;

	// bi-directional many-to-one association to MdQuantityUnit
	@ManyToOne
	@JoinColumn(name = "quantityunitid")
	private MdQuantityUnit mdQuantityUnit;

	// bi-directional many-to-one association to MdTask
	@ManyToOne
	@JoinColumn(name = "taskid")
	private MdTask mdTask;

	// bi-directional many-to-one association to MdWorkItem
	@ManyToOne
	@JoinColumn(name = "workitemid")
	private MdWorkItem mdWorkItem;

	public CmsPlanTask() {
	}

	public Integer getPlantaskid() {
		return this.plantaskid;
	}

	public void setPlantaskid(Integer plantaskid) {
		this.plantaskid = plantaskid;
	}

	public Integer getAmountofwork() {
		return this.amountofwork;
	}

	public void setAmountofwork(Integer amountofwork) {
		this.amountofwork = amountofwork;
	}

	public Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Integer getOrderindex() {
		return this.orderindex;
	}

	public void setOrderindex(Integer orderindex) {
		this.orderindex = orderindex;
	}

	public Date getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Integer getTotallaborquantity() {
		return this.totallaborquantity;
	}

	public void setTotallaborquantity(Integer totallaborquantity) {
		this.totallaborquantity = totallaborquantity;
	}

	public List<CmsConstructionDiary> getCmsConstructionDiaries() {
		return this.cmsConstructionDiaries;
	}

	public void setCmsConstructionDiaries(List<CmsConstructionDiary> cmsConstructionDiaries) {
		this.cmsConstructionDiaries = cmsConstructionDiaries;
	}

	public CmsConstructionDiary addCmsConstructionDiary(CmsConstructionDiary cmsConstructionDiary) {
		getCmsConstructionDiaries().add(cmsConstructionDiary);
		cmsConstructionDiary.setCmsPlanTask(this);

		return cmsConstructionDiary;
	}

	public CmsConstructionDiary removeCmsConstructionDiary(CmsConstructionDiary cmsConstructionDiary) {
		getCmsConstructionDiaries().remove(cmsConstructionDiary);
		cmsConstructionDiary.setCmsPlanTask(null);

		return cmsConstructionDiary;
	}

	public List<CmsPlanTaskLabor> getCmsPlanTaskLabors() {
		return this.cmsPlanTaskLabors;
	}

	public void setCmsPlanTaskLabors(List<CmsPlanTaskLabor> cmsPlanTaskLabors) {
		this.cmsPlanTaskLabors = cmsPlanTaskLabors;
	}

	public CmsPlanTaskLabor addCmsPlanTaskLabor(CmsPlanTaskLabor cmsPlanTaskLabor) {
		getCmsPlanTaskLabors().add(cmsPlanTaskLabor);
		cmsPlanTaskLabor.setCmsPlanTask(this);

		return cmsPlanTaskLabor;
	}

	public CmsPlanTaskLabor removeCmsPlanTaskLabor(CmsPlanTaskLabor cmsPlanTaskLabor) {
		getCmsPlanTaskLabors().remove(cmsPlanTaskLabor);
		cmsPlanTaskLabor.setCmsPlanTask(null);

		return cmsPlanTaskLabor;
	}

	public List<CmsPlanTaskProduct> getCmsPlanTaskProducts() {
		return this.cmsPlanTaskProducts;
	}

	public void setCmsPlanTaskProducts(List<CmsPlanTaskProduct> cmsPlanTaskProducts) {
		this.cmsPlanTaskProducts = cmsPlanTaskProducts;
	}

	public CmsPlanTaskProduct addCmsPlanTaskProduct(CmsPlanTaskProduct cmsPlanTaskProduct) {
		getCmsPlanTaskProducts().add(cmsPlanTaskProduct);
		cmsPlanTaskProduct.setCmsPlanTask(this);

		return cmsPlanTaskProduct;
	}

	public CmsPlanTaskProduct removeCmsPlanTaskProduct(CmsPlanTaskProduct cmsPlanTaskProduct) {
		getCmsPlanTaskProducts().remove(cmsPlanTaskProduct);
		cmsPlanTaskProduct.setCmsPlanTask(null);

		return cmsPlanTaskProduct;
	}

	public CmsPlan getCmsPlan() {
		return this.cmsPlan;
	}

	public void setCmsPlan(CmsPlan cmsPlan) {
		this.cmsPlan = cmsPlan;
	}

	public MdCostEstimate getMdCostEstimate() {
		return this.mdCostEstimate;
	}

	public void setMdCostEstimate(MdCostEstimate mdCostEstimate) {
		this.mdCostEstimate = mdCostEstimate;
	}

	public MdQuantityUnit getMdQuantityUnit() {
		return this.mdQuantityUnit;
	}

	public void setMdQuantityUnit(MdQuantityUnit mdQuantityUnit) {
		this.mdQuantityUnit = mdQuantityUnit;
	}

	public MdTask getMdTask() {
		return this.mdTask;
	}

	public void setMdTask(MdTask mdTask) {
		this.mdTask = mdTask;
	}

	public MdWorkItem getMdWorkItem() {
		return this.mdWorkItem;
	}

	public void setMdWorkItem(MdWorkItem mdWorkItem) {
		this.mdWorkItem = mdWorkItem;
	}

}