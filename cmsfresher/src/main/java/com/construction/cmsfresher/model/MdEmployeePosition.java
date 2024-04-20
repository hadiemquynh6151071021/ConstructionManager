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
 * The persistent class for the md_employee_positions database table.
 * 
 */
@Entity
@Table(name="md_employee_positions")
@NamedQuery(name="MdEmployeePosition.findAll", query="SELECT m FROM MdEmployeePosition m")
public class MdEmployeePosition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer employeepositionid;

	private String employeepositionname;

	//bi-directional many-to-one association to MdEmployee
	@OneToMany(mappedBy="mdEmployeePosition")
	@JsonIgnore
	private List<MdEmployee> mdEmployees;

	public MdEmployeePosition() {
	}

	public Integer getEmployeepositionid() {
		return this.employeepositionid;
	}

	public void setEmployeepositionid(Integer employeepositionid) {
		this.employeepositionid = employeepositionid;
	}

	public String getEmployeepositionname() {
		return this.employeepositionname;
	}

	public void setEmployeepositionname(String employeepositionname) {
		this.employeepositionname = employeepositionname;
	}

	public List<MdEmployee> getMdEmployees() {
		return this.mdEmployees;
	}

	public void setMdEmployees(List<MdEmployee> mdEmployees) {
		this.mdEmployees = mdEmployees;
	}

	public MdEmployee addMdEmployee(MdEmployee mdEmployee) {
		getMdEmployees().add(mdEmployee);
		mdEmployee.setMdEmployeePosition(this);

		return mdEmployee;
	}

	public MdEmployee removeMdEmployee(MdEmployee mdEmployee) {
		getMdEmployees().remove(mdEmployee);
		mdEmployee.setMdEmployeePosition(null);

		return mdEmployee;
	}

}