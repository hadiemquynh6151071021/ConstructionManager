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
 * The persistent class for the cms_role_employees_planworkitems database table.
 * 
 */
@Entity
@Table(name="cms_role_employees_planworkitems")
@NamedQuery(name="CmsRoleEmployeesPlanworkitem.findAll", query="SELECT c FROM CmsRoleEmployeesPlanworkitem c")
public class CmsRoleEmployeesPlanworkitem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer roleemployeeplanworkitemid;

	//bi-directional many-to-one association to CmsPlanWorkitem
	@ManyToOne
	@JoinColumn(name="planworkitemid")
	private CmsPlanWorkitem cmsPlanWorkitem;

	//bi-directional many-to-one association to MdEmployee
	@ManyToOne()
	@JoinColumn(name="employeeid")
	private MdEmployee mdEmployee;

	//bi-directional many-to-one association to MdRole
	@ManyToOne
	@JoinColumn(name="roleid")
	private MdRole mdRole;

	public CmsRoleEmployeesPlanworkitem() {
	}

	public Integer getRoleemployeeplanworkitemid() {
		return this.roleemployeeplanworkitemid;
	}

	public void setRoleemployeeplanworkitemid(Integer roleemployeeplanworkitemid) {
		this.roleemployeeplanworkitemid = roleemployeeplanworkitemid;
	}

	public CmsPlanWorkitem getCmsPlanWorkitem() {
		return this.cmsPlanWorkitem;
	}

	public void setCmsPlanWorkitem(CmsPlanWorkitem cmsPlanWorkitem) {
		this.cmsPlanWorkitem = cmsPlanWorkitem;
	}

	public MdEmployee getMdEmployee() {
		return this.mdEmployee;
	}

	public void setMdEmployee(MdEmployee mdEmployee) {
		this.mdEmployee = mdEmployee;
	}

	public MdRole getMdRole() {
		return this.mdRole;
	}

	public void setMdRole(MdRole mdRole) {
		this.mdRole = mdRole;
	}

}