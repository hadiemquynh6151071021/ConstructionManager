package com.construction.cmsfresher.model;

import java.io.Serializable;
import java.sql.Time;
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
 * The persistent class for the md_shifts database table.
 * 
 */
@Entity
@Table(name="md_shifts")
@NamedQuery(name="MdShift.findAll", query="SELECT m FROM MdShift m")
public class MdShift implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer shiftid;

	private Time endtime;

	private String shiftname;

	private Time starttime;

	//bi-directional many-to-one association to CmsDiaryTaskEmployee
	@OneToMany(mappedBy="mdShift")
	@JsonIgnore
	private List<CmsDiaryTaskEmployee> cmsDiaryTaskEmployees;

	public MdShift() {
	}

	public Integer getShiftid() {
		return this.shiftid;
	}

	public void setShiftid(Integer shiftid) {
		this.shiftid = shiftid;
	}

	public Time getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Time endtime) {
		this.endtime = endtime;
	}

	public String getShiftname() {
		return this.shiftname;
	}

	public void setShiftname(String shiftname) {
		this.shiftname = shiftname;
	}

	public Time getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Time starttime) {
		this.starttime = starttime;
	}

	public List<CmsDiaryTaskEmployee> getCmsDiaryTaskEmployees() {
		return this.cmsDiaryTaskEmployees;
	}

	public void setCmsDiaryTaskEmployees(List<CmsDiaryTaskEmployee> cmsDiaryTaskEmployees) {
		this.cmsDiaryTaskEmployees = cmsDiaryTaskEmployees;
	}

	public CmsDiaryTaskEmployee addCmsDiaryTaskEmployee(CmsDiaryTaskEmployee cmsDiaryTaskEmployee) {
		getCmsDiaryTaskEmployees().add(cmsDiaryTaskEmployee);
		cmsDiaryTaskEmployee.setMdShift(this);

		return cmsDiaryTaskEmployee;
	}

	public CmsDiaryTaskEmployee removeCmsDiaryTaskEmployee(CmsDiaryTaskEmployee cmsDiaryTaskEmployee) {
		getCmsDiaryTaskEmployees().remove(cmsDiaryTaskEmployee);
		cmsDiaryTaskEmployee.setMdShift(null);

		return cmsDiaryTaskEmployee;
	}

}