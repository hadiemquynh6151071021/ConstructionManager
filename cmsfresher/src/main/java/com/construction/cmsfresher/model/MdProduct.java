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
 * The persistent class for the md_products database table.
 * 
 */
@Entity
@Table(name="md_products")
@NamedQuery(name="MdProduct.findAll", query="SELECT m FROM MdProduct m")
public class MdProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer productid;

	private String dimension;

	private String productname;

	//bi-directional many-to-one association to CmsCostestimateTaskProduct
	@OneToMany(mappedBy="mdProduct")
	@JsonIgnore
	private List<CmsCostestimateTaskProduct> cmsCostestimateTaskProducts;

	//bi-directional many-to-one association to CmsDiaryTaskProduct
	@OneToMany(mappedBy="mdProduct")
	@JsonIgnore
	private List<CmsDiaryTaskProduct> cmsDiaryTaskProducts;

	//bi-directional many-to-one association to CmsPlanTaskProduct
	@OneToMany(mappedBy="mdProduct")
	@JsonIgnore
	private List<CmsPlanTaskProduct> cmsPlanTaskProducts;

	//bi-directional many-to-one association to MdQuantityUnit
	@ManyToOne
	@JoinColumn(name="quantityunitid")
	private MdQuantityUnit mdQuantityUnit;

	public MdProduct() {
	}

	public Integer getProductid() {
		return this.productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public String getDimension() {
		return this.dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public String getProductname() {
		return this.productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public List<CmsCostestimateTaskProduct> getCmsCostestimateTaskProducts() {
		return this.cmsCostestimateTaskProducts;
	}

	public void setCmsCostestimateTaskProducts(List<CmsCostestimateTaskProduct> cmsCostestimateTaskProducts) {
		this.cmsCostestimateTaskProducts = cmsCostestimateTaskProducts;
	}

	public CmsCostestimateTaskProduct addCmsCostestimateTaskProduct(CmsCostestimateTaskProduct cmsCostestimateTaskProduct) {
		getCmsCostestimateTaskProducts().add(cmsCostestimateTaskProduct);
		cmsCostestimateTaskProduct.setMdProduct(this);

		return cmsCostestimateTaskProduct;
	}

	public CmsCostestimateTaskProduct removeCmsCostestimateTaskProduct(CmsCostestimateTaskProduct cmsCostestimateTaskProduct) {
		getCmsCostestimateTaskProducts().remove(cmsCostestimateTaskProduct);
		cmsCostestimateTaskProduct.setMdProduct(null);

		return cmsCostestimateTaskProduct;
	}

	public List<CmsDiaryTaskProduct> getCmsDiaryTaskProducts() {
		return this.cmsDiaryTaskProducts;
	}

	public void setCmsDiaryTaskProducts(List<CmsDiaryTaskProduct> cmsDiaryTaskProducts) {
		this.cmsDiaryTaskProducts = cmsDiaryTaskProducts;
	}

	public CmsDiaryTaskProduct addCmsDiaryTaskProduct(CmsDiaryTaskProduct cmsDiaryTaskProduct) {
		getCmsDiaryTaskProducts().add(cmsDiaryTaskProduct);
		cmsDiaryTaskProduct.setMdProduct(this);

		return cmsDiaryTaskProduct;
	}

	public CmsDiaryTaskProduct removeCmsDiaryTaskProduct(CmsDiaryTaskProduct cmsDiaryTaskProduct) {
		getCmsDiaryTaskProducts().remove(cmsDiaryTaskProduct);
		cmsDiaryTaskProduct.setMdProduct(null);

		return cmsDiaryTaskProduct;
	}

	public List<CmsPlanTaskProduct> getCmsPlanTaskProducts() {
		return this.cmsPlanTaskProducts;
	}

	public void setCmsPlanTaskProducts(List<CmsPlanTaskProduct> cmsPlanTaskProducts) {
		this.cmsPlanTaskProducts = cmsPlanTaskProducts;
	}

	public CmsPlanTaskProduct addCmsPlanTaskProduct(CmsPlanTaskProduct cmsPlanTaskProduct) {
		getCmsPlanTaskProducts().add(cmsPlanTaskProduct);
		cmsPlanTaskProduct.setMdProduct(this);

		return cmsPlanTaskProduct;
	}

	public CmsPlanTaskProduct removeCmsPlanTaskProduct(CmsPlanTaskProduct cmsPlanTaskProduct) {
		getCmsPlanTaskProducts().remove(cmsPlanTaskProduct);
		cmsPlanTaskProduct.setMdProduct(null);

		return cmsPlanTaskProduct;
	}

	public MdQuantityUnit getMdQuantityUnit() {
		return this.mdQuantityUnit;
	}

	public void setMdQuantityUnit(MdQuantityUnit mdQuantityUnit) {
		this.mdQuantityUnit = mdQuantityUnit;
	}

}