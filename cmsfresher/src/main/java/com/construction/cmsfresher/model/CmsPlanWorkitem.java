package com.construction.cmsfresher.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


/**
 * The persistent class for the cms_plan_workitem database table.
 * 
 */
@Entity
@Table(name="cms_plan_workitem")
@NamedQuery(name="CmsPlanWorkitem.findAll", query="SELECT c FROM CmsPlanWorkitem c")
public class CmsPlanWorkitem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer planworkitemid;

	private Integer orderindex;

	//bi-directional many-to-one association to CmsPlan
	@ManyToOne
	@JoinColumn(name="planid")
	private CmsPlan cmsPlan;

	//bi-directional many-to-one association to MdWorkItem
	@ManyToOne
	@JoinColumn(name="workitemid")
	private MdWorkItem mdWorkItem;

	//bi-directional many-to-one association to CmsRoleEmployeesPlanworkitem
	@OneToMany(mappedBy="cmsPlanWorkitem")
	@JsonIgnore
	private List<CmsRoleEmployeesPlanworkitem> cmsRoleEmployeesPlanworkitems;

	public CmsPlanWorkitem() {
	}

	public Integer getPlanworkitemid() {
		return this.planworkitemid;
	}

	public void setPlanworkitemid(Integer planworkitemid) {
		this.planworkitemid = planworkitemid;
	}

	public Integer getOrderindex() {
		return this.orderindex;
	}

	public void setOrderindex(Integer orderindex) {
		this.orderindex = orderindex;
	}

	public CmsPlan getCmsPlan() {
		return this.cmsPlan;
	}

	public void setCmsPlan(CmsPlan cmsPlan) {
		this.cmsPlan = cmsPlan;
	}

	public MdWorkItem getMdWorkItem() {
		return this.mdWorkItem;
	}

	public void setMdWorkItem(MdWorkItem mdWorkItem) {
		this.mdWorkItem = mdWorkItem;
	}

	public List<CmsRoleEmployeesPlanworkitem> getCmsRoleEmployeesPlanworkitems() {
		return this.cmsRoleEmployeesPlanworkitems;
	}

	public void setCmsRoleEmployeesPlanworkitems(List<CmsRoleEmployeesPlanworkitem> cmsRoleEmployeesPlanworkitems) {
		this.cmsRoleEmployeesPlanworkitems = cmsRoleEmployeesPlanworkitems;
	}

	public CmsRoleEmployeesPlanworkitem addCmsRoleEmployeesPlanworkitem(CmsRoleEmployeesPlanworkitem cmsRoleEmployeesPlanworkitem) {
		getCmsRoleEmployeesPlanworkitems().add(cmsRoleEmployeesPlanworkitem);
		cmsRoleEmployeesPlanworkitem.setCmsPlanWorkitem(this);

		return cmsRoleEmployeesPlanworkitem;
	}

	public CmsRoleEmployeesPlanworkitem removeCmsRoleEmployeesPlanworkitem(CmsRoleEmployeesPlanworkitem cmsRoleEmployeesPlanworkitem) {
		getCmsRoleEmployeesPlanworkitems().remove(cmsRoleEmployeesPlanworkitem);
		cmsRoleEmployeesPlanworkitem.setCmsPlanWorkitem(null);

		return cmsRoleEmployeesPlanworkitem;
	}

}