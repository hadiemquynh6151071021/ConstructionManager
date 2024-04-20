package com.construction.cmsfresher.dto.response.mdproductdto;

import com.construction.cmsfresher.dto.response.mdquantityunitdto.MdQuantityUnitDTO;

public class MdProductDTO {

	private Integer productid;

	private String productname;

	private MdQuantityUnitDTO mdQuantityUnit;

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}


	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public MdQuantityUnitDTO getMdQuantityUnit() {
		return mdQuantityUnit;
	}

	public void setMdQuantityUnit(MdQuantityUnitDTO mdQuantityUnit) {
		this.mdQuantityUnit = mdQuantityUnit;
	}

}
