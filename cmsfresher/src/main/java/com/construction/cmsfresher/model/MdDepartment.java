package com.construction.cmsfresher.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


/**
 * The persistent class for the md_departments database table.
 * 
 */
@Entity
@Table(name="md_departments")
@NamedQuery(name="MdDepartment.findAll", query="SELECT m FROM MdDepartment m")
public class MdDepartment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer departmentid;

	private String departmentname;

	//bi-directional many-to-one association to MdEmployee
	@OneToMany(mappedBy="mdDepartment")
	@JsonIgnore
	private List<MdEmployee> mdEmployees;

	public MdDepartment() {
	}

	public Integer getDepartmentid() {
		return this.departmentid;
	}

	public void setDepartmentid(Integer departmentid) {
		this.departmentid = departmentid;
	}

	public String getDepartmentname() {
		return this.departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	public List<MdEmployee> getMdEmployees() {
		return this.mdEmployees;
	}

	public void setMdEmployees(List<MdEmployee> mdEmployees) {
		this.mdEmployees = mdEmployees;
	}

	public MdEmployee addMdEmployee(MdEmployee mdEmployee) {
		getMdEmployees().add(mdEmployee);
		mdEmployee.setMdDepartment(this);

		return mdEmployee;
	}

	public MdEmployee removeMdEmployee(MdEmployee mdEmployee) {
		getMdEmployees().remove(mdEmployee);
		mdEmployee.setMdDepartment(null);

		return mdEmployee;
	}

}