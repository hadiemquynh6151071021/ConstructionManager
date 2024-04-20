package com.construction.cmsfresher.dto.request.cmsconstructiondiarydto;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import com.construction.cmsfresher.dto.request.cmsplansdto.ProductDTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class CmsConstructionDiaryDTO {

	private String diaryidcode;
	private Time endtime;

	private String problem;
	
	private Time starttime;

	@NotNull(message = "QuantityUnit not empty")
	private Integer quantityUnit;

	@NotNull(message = "Temperature not empty")
	private double temperature;

	@NotNull(message = "CmsPlanTask not empty")
	@Min(value = 1, message = "CmsPlanTask must be greater than 1")
	private Integer cmsPlanTask;

	@NotNull(message = "Creator not empty")
	private Integer creator;

	@NotNull(message = "mdWeather not empty")
	@Min(value = 1, message = "MdWeather between 1 and 5")
	@Max(value = 5, message = "MdWeather between 1 and 5")
	private Integer mdWeather;

	@NotNull(message = "Date of Diary not empty")
	private Date dateOfDiary;

	private Integer amountOfWork;

	@NotEmpty(message = "Products not empty")
	private List<ProductDTO> products;

	private List<LaborDTO> labors;

	private String[] pictures;
	private String[] picturesProblem;

	public String getDiaryidcode() {
		return diaryidcode;
	}

	public void setDiaryidcode(String diaryidcode) {
		this.diaryidcode = diaryidcode;
	}

	public Time getEndtime() {
		return endtime;
	}

	public void setEndtime(Time endtime) {
		this.endtime = endtime;
	}

	public Integer getQuantityUnit() {
		return quantityUnit;
	}

	public void setQuantityUnit(Integer quantityUnit) {
		this.quantityUnit = quantityUnit;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public Time getStarttime() {
		return starttime;
	}

	public void setStarttime(Time starttime) {
		this.starttime = starttime;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public Integer getCmsPlanTask() {
		return cmsPlanTask;
	}

	public void setCmsPlanTask(Integer cmsPlanTask) {
		this.cmsPlanTask = cmsPlanTask;
	}

	public Integer getCreator() {
		return creator;
	}

	public void setCreator(Integer creator) {
		this.creator = creator;
	}

	public Integer getMdWeather() {
		return mdWeather;
	}

	public void setMdWeather(Integer mdWeather) {
		this.mdWeather = mdWeather;
	}

	public Integer getAmountOfWork() {
		return amountOfWork;
	}

	public Date getDateOfDiary() {
		return dateOfDiary;
	}

	public void setDateOfDiary(Date dateOfDiary) {
		this.dateOfDiary = dateOfDiary;
	}

	public void setAmountOfWork(Integer amountOfWork) {
		this.amountOfWork = amountOfWork;
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

	public String[] getPictures() {
		return pictures;
	}

	public void setPictures(String[] pictures) {
		this.pictures = pictures;
	}

	public String[] getPicturesProblem() {
		return picturesProblem;
	}

	public void setPicturesProblem(String[] picturesProblem) {
		this.picturesProblem = picturesProblem;
	}

}
