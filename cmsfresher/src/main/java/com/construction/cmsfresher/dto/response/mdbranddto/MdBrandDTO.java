package com.construction.cmsfresher.dto.response.mdbranddto;

import com.construction.cmsfresher.dto.response.mdcompanydto.MdCompanyDTO;

public class MdBrandDTO {

	private Integer brandid;

	private String brandname;

	private MdCompanyDTO mdCompany;

	public Integer getBrandid() {
		return brandid;
	}

	public void setBrandid(Integer brandid) {
		this.brandid = brandid;
	}

	public String getBrandname() {
		return brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	public MdCompanyDTO getMdCompany() {
		return mdCompany;
	}

	public void setMdCompany(MdCompanyDTO mdCompany) {
		this.mdCompany = mdCompany;
	}

	
}
