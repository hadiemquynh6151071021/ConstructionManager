package com.construction.cmsfresher.dto.response.cmsdiarydto;

import com.construction.cmsfresher.dto.response.mdproductdto.MdProductDTO;

public class CmsDiaryTaskProductDTO {
	private Integer diarytaskproductid;

	private Integer consumptionamount;
	
	private MdProductDTO mdProduct;

	public Integer getDiarytaskproductid() {
		return diarytaskproductid;
	}

	public void setDiarytaskproductid(Integer diarytaskproductid) {
		this.diarytaskproductid = diarytaskproductid;
	}

	public Integer getConsumptionamount() {
		return consumptionamount;
	}

	public void setConsumptionamount(Integer consumptionamount) {
		this.consumptionamount = consumptionamount;
	}

	public MdProductDTO getMdProduct() {
		return mdProduct;
	}

	public void setMdProduct(MdProductDTO mdProduct) {
		this.mdProduct = mdProduct;
	}
	
	
}
