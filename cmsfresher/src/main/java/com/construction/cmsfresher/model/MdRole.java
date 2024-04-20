package com.construction.cmsfresher.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * The persistent class for the md_roles database table.
 * 
 */
@Entity
@Table(name = "md_roles")
@NamedQuery(name = "MdRole.findAll", query = "SELECT m FROM MdRole m")
public class MdRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roleid;

	private String rolename;

	// bi-directional many-to-one association to CmsRoleEmployeesPlanworkitem
	@OneToMany(mappedBy = "mdRole")
	@JsonIgnore
	private List<CmsRoleEmployeesPlanworkitem> cmsRoleEmployeesPlanworkitems;

	// bi-directional many-to-one association to MdEmployee
	@JsonIgnore
	@ManyToMany(mappedBy = "mdRoles")
	private List<MdAccount> mdAccounts;

	public MdRole() {
	}

	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public List<CmsRoleEmployeesPlanworkitem> getCmsRoleEmployeesPlanworkitems() {
		return this.cmsRoleEmployeesPlanworkitems;
	}

	public void setCmsRoleEmployeesPlanworkitems(List<CmsRoleEmployeesPlanworkitem> cmsRoleEmployeesPlanworkitems) {
		this.cmsRoleEmployeesPlanworkitems = cmsRoleEmployeesPlanworkitems;
	}

	public CmsRoleEmployeesPlanworkitem addCmsRoleEmployeesPlanworkitem(
			CmsRoleEmployeesPlanworkitem cmsRoleEmployeesPlanworkitem) {
		getCmsRoleEmployeesPlanworkitems().add(cmsRoleEmployeesPlanworkitem);
		cmsRoleEmployeesPlanworkitem.setMdRole(this);

		return cmsRoleEmployeesPlanworkitem;
	}

	public CmsRoleEmployeesPlanworkitem removeCmsRoleEmployeesPlanworkitem(
			CmsRoleEmployeesPlanworkitem cmsRoleEmployeesPlanworkitem) {
		getCmsRoleEmployeesPlanworkitems().remove(cmsRoleEmployeesPlanworkitem);
		cmsRoleEmployeesPlanworkitem.setMdRole(null);

		return cmsRoleEmployeesPlanworkitem;
	}


}