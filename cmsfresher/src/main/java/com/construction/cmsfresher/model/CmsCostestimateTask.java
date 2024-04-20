package com.construction.cmsfresher.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.construction.cmsfresher.dto.response.cmscostestimatetaskdto.CmsCostEstimateTaskDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.Table;

/**
 * The persistent class for the cms_costestimate_tasks database table.
 * 
 */


@Entity
@Table(name = "cms_costestimate_tasks")
@NamedQuery(name = "CmsCostestimateTask.findAll", query = "SELECT c FROM CmsCostestimateTask c")
public class CmsCostestimateTask implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer costestimatetaskid;

	private BigDecimal amountofwork;

	private Integer laborquantity;

	// bi-directional many-to-one association to CmsCostestimateTaskProduct
	@OneToMany(mappedBy = "cmsCostestimateTask")
	@JsonIgnore
	private List<CmsCostestimateTaskProduct> cmsCostestimateTaskProducts;

	// bi-directional many-to-one association to CmsCostestimateWorkitem
	@ManyToOne
	@JoinColumn(name = "costestimateworkitemid")
	private CmsCostestimateWorkitem cmsCostestimateWorkitem;

	// bi-directional many-to-one association to MdTask
	@ManyToOne
	@JoinColumn(name = "taskid")
	private MdTask mdTask;

	public CmsCostestimateTask() {
	}

	public Integer getCostestimatetaskid() {
		return this.costestimatetaskid;
	}

	public void setCostestimatetaskid(Integer costestimatetaskid) {
		this.costestimatetaskid = costestimatetaskid;
	}

	public BigDecimal getAmountofwork() {
		return this.amountofwork;
	}

	public void setAmountofwork(BigDecimal amountofwork) {
		this.amountofwork = amountofwork;
	}

	public Integer getLaborquantity() {
		return this.laborquantity;
	}

	public void setLaborquantity(Integer laborquantity) {
		this.laborquantity = laborquantity;
	}

	public List<CmsCostestimateTaskProduct> getCmsCostestimateTaskProducts() {
		return this.cmsCostestimateTaskProducts;
	}

	public void setCmsCostestimateTaskProducts(List<CmsCostestimateTaskProduct> cmsCostestimateTaskProducts) {
		this.cmsCostestimateTaskProducts = cmsCostestimateTaskProducts;
	}

	public CmsCostestimateTaskProduct addCmsCostestimateTaskProduct(
			CmsCostestimateTaskProduct cmsCostestimateTaskProduct) {
		getCmsCostestimateTaskProducts().add(cmsCostestimateTaskProduct);
		cmsCostestimateTaskProduct.setCmsCostestimateTask(this);

		return cmsCostestimateTaskProduct;
	}

	public CmsCostestimateTaskProduct removeCmsCostestimateTaskProduct(
			CmsCostestimateTaskProduct cmsCostestimateTaskProduct) {
		getCmsCostestimateTaskProducts().remove(cmsCostestimateTaskProduct);
		cmsCostestimateTaskProduct.setCmsCostestimateTask(null);

		return cmsCostestimateTaskProduct;
	}

	public CmsCostestimateWorkitem getCmsCostestimateWorkitem() {
		return this.cmsCostestimateWorkitem;
	}

	public void setCmsCostestimateWorkitem(CmsCostestimateWorkitem cmsCostestimateWorkitem) {
		this.cmsCostestimateWorkitem = cmsCostestimateWorkitem;
	}

	public MdTask getMdTask() {
		return this.mdTask;
	}

	public void setMdTask(MdTask mdTask) {
		this.mdTask = mdTask;
	}

}