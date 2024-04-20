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
 * The persistent class for the md_warehouses database table.
 * 
 */
@Entity
@Table(name="md_warehouses")
@NamedQuery(name="MdWarehous.findAll", query="SELECT m FROM MdWarehous m")
public class MdWarehous implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer warehouseid;

	private String phone;

	private Integer warehousecapacity;

	private String warehousename;

	private Integer warehousestate;

	//bi-directional many-to-one association to MdConstructionSite
	@ManyToOne
	@JoinColumn(name="constructionsiteid")
	private MdConstructionSite mdConstructionSite;

	public MdWarehous() {
	}

	public Integer getWarehouseid() {
		return this.warehouseid;
	}

	public void setWarehouseid(Integer warehouseid) {
		this.warehouseid = warehouseid;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getWarehousecapacity() {
		return this.warehousecapacity;
	}

	public void setWarehousecapacity(Integer warehousecapacity) {
		this.warehousecapacity = warehousecapacity;
	}

	public String getWarehousename() {
		return this.warehousename;
	}

	public void setWarehousename(String warehousename) {
		this.warehousename = warehousename;
	}

	public Integer getWarehousestate() {
		return this.warehousestate;
	}

	public void setWarehousestate(Integer warehousestate) {
		this.warehousestate = warehousestate;
	}

	public MdConstructionSite getMdConstructionSite() {
		return this.mdConstructionSite;
	}

	public void setMdConstructionSite(MdConstructionSite mdConstructionSite) {
		this.mdConstructionSite = mdConstructionSite;
	}

}