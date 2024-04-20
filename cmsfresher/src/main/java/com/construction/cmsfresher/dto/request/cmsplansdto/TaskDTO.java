package com.construction.cmsfresher.dto.request.cmsplansdto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TaskDTO {

	private Integer taskId;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date startdate;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date enddate;

	private Integer amountOfWork;
	private Integer quantityUnitId;

	private Integer orderIndex;

	private Integer costEstimateId;

	private List<ProductDTO> products;
	private List<LaborDTO> labors;

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Integer getAmountOfWork() {
		return amountOfWork;
	}

	public void setAmountOfWork(Integer amountOfWork) {
		this.amountOfWork = amountOfWork;
	}

	public Integer getQuantityUnitId() {
		return quantityUnitId;
	}

	public void setQuantityUnitId(Integer quantityUnitId) {
		this.quantityUnitId = quantityUnitId;
	}

	public Integer getOrderIndex() {
		return orderIndex;
	}

	public void setOrderIndex(Integer orderIndex) {
		this.orderIndex = orderIndex;
	}

	public Integer getCostEstimateId() {
		return costEstimateId;
	}

	public void setCostEstimateId(Integer costEstimateId) {
		this.costEstimateId = costEstimateId;
	}

	public List<ProductDTO> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}

	public List<LaborDTO> getLabors() {
		return labors;
	}

	public void setLabors(List<LaborDTO> labors) {
		this.labors = labors;
	}

}
