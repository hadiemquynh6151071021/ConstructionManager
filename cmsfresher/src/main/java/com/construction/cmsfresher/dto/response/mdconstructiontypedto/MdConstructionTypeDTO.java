package com.construction.cmsfresher.dto.response.mdconstructiontypedto;

import com.construction.cmsfresher.dto.response.mdbranddto.MdBrandDTO;

public class MdConstructionTypeDTO {
	private Integer constructiontypeid;

	private String constructiontypename;

	private MdBrandDTO mdBrand;

	public Integer getConstructiontypeid() {
		return constructiontypeid;
	}

	public void setConstructiontypeid(Integer constructiontypeid) {
		this.constructiontypeid = constructiontypeid;
	}

	public String getConstructiontypename() {
		return constructiontypename;
	}

	public void setConstructiontypename(String constructiontypename) {
		this.constructiontypename = constructiontypename;
	}

	public MdBrandDTO getMdBrand() {
		return mdBrand;
	}

	public void setMdBrand(MdBrandDTO mdBrand) {
		this.mdBrand = mdBrand;
	}

	
}
