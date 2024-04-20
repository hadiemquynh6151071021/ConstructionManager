package com.construction.cmsfresher.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;


/**
 * The persistent class for the md_account database table.
 * 
 */
@Entity
@Table(name="md_account")
@NamedQuery(name="MdAccount.findAll", query="SELECT m FROM MdAccount m")
public class MdAccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer accountid;

	@Column(name="password")
	private String password;

	private String username;

	//bi-directional many-to-one association to MdEmployee
	@ManyToOne()
	@JoinColumn(name="employeeid")
	private MdEmployee mdEmployee;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
	name="cms_account_role",
	joinColumns = @JoinColumn(name="accountid"),
	inverseJoinColumns = @JoinColumn(name="roleid")
			)
	private List<MdRole> mdRoles;

	public MdAccount() {
	}

	public Integer getAccountid() {
		return this.accountid;
	}

	public void setAccountid(Integer accountid) {
		this.accountid = accountid;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public MdEmployee getMdEmployee() {
		return this.mdEmployee;
	}

	public void setMdEmployee(MdEmployee mdEmployee) {
		this.mdEmployee = mdEmployee;
	}

	public List<MdRole> getMdRoles() {
		return mdRoles;
	}

	public void setMdRoles(List<MdRole> mdRoles) {
		this.mdRoles = mdRoles;
	}
	
	

}