package com.construction.cmsfresher.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

/**
 * The persistent class for the cms_plan_task_product database table.
 * 
 */
@Entity
@Table(name = "cms_plan_task_product")
@NamedQuery(name = "CmsPlanTaskProduct.findAll", query = "SELECT c FROM CmsPlanTaskProduct c")
public class CmsPlanTaskProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer planTaskProductId;

	private Integer consumptionamount;

	private String quantityunit;

	// bi-directional many-to-one association to CmsPlanTask
	@ManyToOne
	@JoinColumn(name = "plantaskid")
	private CmsPlanTask cmsPlanTask;

	// bi-directional many-to-one association to MdProduct
	@ManyToOne
	@JoinColumn(name = "productid")
	private MdProduct mdProduct;

	public CmsPlanTaskProduct() {
	}

	public Integer getPlanTaskProductId() {
		return planTaskProductId;
	}

	public void setPlanTaskProductId(Integer planTaskProductId) {
		this.planTaskProductId = planTaskProductId;
	}

	public Integer getConsumptionamount() {
		return this.consumptionamount;
	}

	public void setConsumptionamount(Integer consumptionamount) {
		this.consumptionamount = consumptionamount;
	}

	public String getQuantityunit() {
		return this.quantityunit;
	}

	public void setQuantityunit(String quantityunit) {
		this.quantityunit = quantityunit;
	}

	public CmsPlanTask getCmsPlanTask() {
		return this.cmsPlanTask;
	}

	public void setCmsPlanTask(CmsPlanTask cmsPlanTask) {
		this.cmsPlanTask = cmsPlanTask;
	}

	public MdProduct getMdProduct() {
		return this.mdProduct;
	}

	public void setMdProduct(MdProduct mdProduct) {
		this.mdProduct = mdProduct;
	}

}