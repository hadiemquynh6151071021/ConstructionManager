package com.construction.cmsfresher.dto.response.cmscostestimatetaskproductdto;

import com.construction.cmsfresher.dto.response.mdproductdto.MdProductDTO;

public class CmsCostestimateTaskProductDTO {

	private Integer costestimatetaskproductid;

	private Integer productamount;
	
	private MdProductDTO mdProduct;

	public Integer getCostestimatetaskproductid() {
		return costestimatetaskproductid;
	}

	public void setCostestimatetaskproductid(Integer costestimatetaskproductid) {
		this.costestimatetaskproductid = costestimatetaskproductid;
	}

	public Integer getProductamount() {
		return productamount;
	}

	public void setProductamount(Integer productamount) {
		this.productamount = productamount;
	}

	public MdProductDTO getMdProduct() {
		return mdProduct;
	}

	public void setMdProduct(MdProductDTO mdProduct) {
		this.mdProduct = mdProduct;
	}

		
		
	
}
