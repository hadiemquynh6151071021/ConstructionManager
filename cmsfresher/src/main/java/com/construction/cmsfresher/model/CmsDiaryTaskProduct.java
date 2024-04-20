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
 * The persistent class for the cms_diary_task_products database table.
 * 
 */
@Entity
@Table(name = "cms_diary_task_products")
@NamedQuery(name = "CmsDiaryTaskProduct.findAll", query = "SELECT c FROM CmsDiaryTaskProduct c")
public class CmsDiaryTaskProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer diarytaskproductid;

	private Integer consumptionamount;

	// bi-directional many-to-one association to CmsConstructionDiary
	@ManyToOne
	@JoinColumn(name = "diaryid")
	private CmsConstructionDiary cmsConstructionDiary;

	// bi-directional many-to-one association to MdProduct
	@ManyToOne
	@JoinColumn(name = "productid")
	private MdProduct mdProduct;

	public CmsDiaryTaskProduct() {
	}

	
	public Integer getDiarytaskproductid() {
		return diarytaskproductid;
	}


	public void setDiarytaskproductid(Integer diarytaskproductid) {
		this.diarytaskproductid = diarytaskproductid;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Integer getConsumptionamount() {
		return this.consumptionamount;
	}

	public void setConsumptionamount(Integer consumptionamount) {
		this.consumptionamount = consumptionamount;
	}

	public CmsConstructionDiary getCmsConstructionDiary() {
		return this.cmsConstructionDiary;
	}

	public void setCmsConstructionDiary(CmsConstructionDiary cmsConstructionDiary) {
		this.cmsConstructionDiary = cmsConstructionDiary;
	}

	public MdProduct getMdProduct() {
		return this.mdProduct;
	}

	public void setMdProduct(MdProduct mdProduct) {
		this.mdProduct = mdProduct;
	}

}