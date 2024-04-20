package com.construction.cmsfresher.dto.request.cmsplansdto;

public class ProductDTO {

	private Integer productId;
	private Integer quantityUnit;
	private Integer consumptionAmount;


	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getQuantityUnit() {
		return quantityUnit;
	}

	public void setQuantityUnit(Integer quantityUnit) {
		this.quantityUnit = quantityUnit;
	}

	public Integer getConsumptionAmount() {
		return consumptionAmount;
	}

	public void setConsumptionAmount(Integer consumptionAmount) {
		this.consumptionAmount = consumptionAmount;
	}

}
