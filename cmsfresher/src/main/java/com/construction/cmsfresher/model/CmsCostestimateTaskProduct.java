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
 * The persistent class for the cms_costestimate_task_products database table.
 * 
 */
@Entity
@Table(name = "cms_costestimate_task_products")
@NamedQuery(name = "CmsCostestimateTaskProduct.findAll", query = "SELECT c FROM CmsCostestimateTaskProduct c")
public class CmsCostestimateTaskProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer costestimatetaskproductid;

	private Integer productamount;

	// bi-directional many-to-one association to CmsCostestimateTask
	@ManyToOne
	@JoinColumn(name = "costestimatetaskid")
	private CmsCostestimateTask cmsCostestimateTask;

	// bi-directional many-to-one association to MdProduct
	@ManyToOne
	@JoinColumn(name = "productid")
	private MdProduct mdProduct;

	public CmsCostestimateTaskProduct() {
	}

	
	
	public Integer getProductamount() {
		return productamount;
	}



	public void setProductamount(Integer productamount) {
		this.productamount = productamount;
	}



	public CmsCostestimateTask getCmsCostestimateTask() {
		return this.cmsCostestimateTask;
	}

	public void setCmsCostestimateTask(CmsCostestimateTask cmsCostestimateTask) {
		this.cmsCostestimateTask = cmsCostestimateTask;
	}

	public MdProduct getMdProduct() {
		return this.mdProduct;
	}

	public void setMdProduct(MdProduct mdProduct) {
		this.mdProduct = mdProduct;
	}

	public Integer getCostestimatetaskproductid() {
		return costestimatetaskproductid;
	}

	public void setCostestimatetaskproductid(Integer costestimatetaskproductid) {
		this.costestimatetaskproductid = costestimatetaskproductid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}