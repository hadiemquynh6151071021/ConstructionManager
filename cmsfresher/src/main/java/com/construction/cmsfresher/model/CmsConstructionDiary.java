package com.construction.cmsfresher.model;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 * The persistent class for the cms_construction_diaries database table.
 * 
 */
@Entity
@Table(name = "cms_construction_diaries")
@NamedQuery(name = "CmsConstructionDiary.findAll", query = "SELECT c FROM CmsConstructionDiary c")
public class CmsConstructionDiary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer diaryid;

	private Timestamp createdtime;

	@Temporal(TemporalType.DATE)
	private Date dateofdiary;

	private String diaryidcode;

	private Time endtime;

	private Boolean isdelete;

	private Boolean islast;

	private String problem;

	private Time starttime;

	private double temperature;
	
	private Integer amountofworkdone;

	// bi-directional many-to-one association to CmsConstructionDiary
	@ManyToOne
	@JoinColumn(name = "predecessordiaryid")
	private CmsConstructionDiary cmsConstructionDiary;

	// bi-directional many-to-one association to CmsConstructionDiary
	@OneToMany(mappedBy = "cmsConstructionDiary")
	@JsonIgnore
	private List<CmsConstructionDiary> cmsConstructionDiaries;

	// bi-directional many-to-one association to CmsDiaryState
	@ManyToOne
	@JoinColumn(name = "diarystateid")
	private CmsDiaryState cmsDiaryState;

	// bi-directional many-to-one association to CmsPlanTask
	@ManyToOne
	@JoinColumn(name = "plantaskid")
	private CmsPlanTask cmsPlanTask;

	// bi-directional many-to-one association to MdEmployee
	@ManyToOne
	@JoinColumn(name = "creatorid")
	private MdEmployee mdEmployee;

	// bi-directional many-to-one association to MdQuantityUnit
	@ManyToOne
	@JoinColumn(name = "quantityunitid")
	private MdQuantityUnit mdQuantityUnit;

	// bi-directional many-to-one association to MdWeather
	@ManyToOne
	@JoinColumn(name = "weatherid")
	private MdWeather mdWeather;

	// bi-directional many-to-one association to CmsDiaryHistory
	@OneToMany(mappedBy = "cmsConstructionDiary",fetch = FetchType.EAGER)
	private List<CmsDiaryHistory> cmsDiaryHistories;

	// bi-directional many-to-one association to CmsDiaryTaskEmployee
	@OneToMany(mappedBy = "cmsConstructionDiary")
	@JsonIgnore
	private List<CmsDiaryTaskEmployee> cmsDiaryTaskEmployees;

	// bi-directional many-to-one association to CmsDiaryTaskProduct
	@OneToMany(mappedBy = "cmsConstructionDiary")
	@JsonIgnore
	private List<CmsDiaryTaskProduct> cmsDiaryTaskProducts;

	// bi-directional many-to-one association to CmsFile
	@OneToMany(mappedBy = "cmsConstructionDiary", fetch = FetchType.EAGER)
	private List<CmsFile> cmsFiles;

	// bi-directional many-to-one association to CmsProgress
	@OneToOne(mappedBy = "cmsConstructionDiary")
	private CmsProgress cmsProgresses;

	public CmsConstructionDiary() {
	}

	public Integer getDiaryid() {
		return this.diaryid;
	}

	public void setDiaryid(Integer diaryid) {
		this.diaryid = diaryid;
	}

	public Timestamp getCreatedtime() {
		return this.createdtime;
	}

	public void setCreatedtime(Timestamp createdtime) {
		this.createdtime = createdtime;
	}

	public Date getDateofdiary() {
		return this.dateofdiary;
	}

	public void setDateofdiary(Date dateofdiary) {
		this.dateofdiary = dateofdiary;
	}

	public String getDiaryidcode() {
		return this.diaryidcode;
	}

	public void setDiaryidcode(String diaryidcode) {
		this.diaryidcode = diaryidcode;
	}

	public Time getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Time endtime) {
		this.endtime = endtime;
	}

	public Boolean getIsdelete() {
		return this.isdelete;
	}

	public void setIsdelete(Boolean isdelete) {
		this.isdelete = isdelete;
	}

	public Boolean getIslast() {
		return this.islast;
	}

	public void setIslast(Boolean islast) {
		this.islast = islast;
	}

	public String getProblem() {
		return this.problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public Time getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Time starttime) {
		this.starttime = starttime;
	}

	public double getTemperature() {
		return this.temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public CmsConstructionDiary getCmsConstructionDiary() {
		return this.cmsConstructionDiary;
	}

	public void setCmsConstructionDiary(CmsConstructionDiary cmsConstructionDiary) {
		this.cmsConstructionDiary = cmsConstructionDiary;
	}

	public List<CmsConstructionDiary> getCmsConstructionDiaries() {
		return this.cmsConstructionDiaries;
	}

	public void setCmsConstructionDiaries(List<CmsConstructionDiary> cmsConstructionDiaries) {
		this.cmsConstructionDiaries = cmsConstructionDiaries;
	}

	public CmsConstructionDiary addCmsConstructionDiary(CmsConstructionDiary cmsConstructionDiary) {
		getCmsConstructionDiaries().add(cmsConstructionDiary);
		cmsConstructionDiary.setCmsConstructionDiary(this);

		return cmsConstructionDiary;
	}

	public CmsConstructionDiary removeCmsConstructionDiary(CmsConstructionDiary cmsConstructionDiary) {
		getCmsConstructionDiaries().remove(cmsConstructionDiary);
		cmsConstructionDiary.setCmsConstructionDiary(null);

		return cmsConstructionDiary;
	}

	public CmsDiaryState getCmsDiaryState() {
		return this.cmsDiaryState;
	}

	public void setCmsDiaryState(CmsDiaryState cmsDiaryState) {
		this.cmsDiaryState = cmsDiaryState;
	}

	public CmsPlanTask getCmsPlanTask() {
		return this.cmsPlanTask;
	}

	public void setCmsPlanTask(CmsPlanTask cmsPlanTask) {
		this.cmsPlanTask = cmsPlanTask;
	}

	public MdEmployee getMdEmployee() {
		return this.mdEmployee;
	}

	public void setMdEmployee(MdEmployee mdEmployee) {
		this.mdEmployee = mdEmployee;
	}

	public MdQuantityUnit getMdQuantityUnit() {
		return this.mdQuantityUnit;
	}

	public void setMdQuantityUnit(MdQuantityUnit mdQuantityUnit) {
		this.mdQuantityUnit = mdQuantityUnit;
	}

	public MdWeather getMdWeather() {
		return this.mdWeather;
	}

	public void setMdWeather(MdWeather mdWeather) {
		this.mdWeather = mdWeather;
	}

	public List<CmsDiaryHistory> getCmsDiaryHistories() {
		return this.cmsDiaryHistories;
	}

	public void setCmsDiaryHistories(List<CmsDiaryHistory> cmsDiaryHistories) {
		this.cmsDiaryHistories = cmsDiaryHistories;
	}

	public CmsDiaryHistory addCmsDiaryHistory(CmsDiaryHistory cmsDiaryHistory) {
		getCmsDiaryHistories().add(cmsDiaryHistory);
		cmsDiaryHistory.setCmsConstructionDiary(this);

		return cmsDiaryHistory;
	}

	public CmsDiaryHistory removeCmsDiaryHistory(CmsDiaryHistory cmsDiaryHistory) {
		getCmsDiaryHistories().remove(cmsDiaryHistory);
		cmsDiaryHistory.setCmsConstructionDiary(null);

		return cmsDiaryHistory;
	}

	public List<CmsDiaryTaskEmployee> getCmsDiaryTaskEmployees() {
		return this.cmsDiaryTaskEmployees;
	}

	public void setCmsDiaryTaskEmployees(List<CmsDiaryTaskEmployee> cmsDiaryTaskEmployees) {
		this.cmsDiaryTaskEmployees = cmsDiaryTaskEmployees;
	}

	public CmsDiaryTaskEmployee addCmsDiaryTaskEmployee(CmsDiaryTaskEmployee cmsDiaryTaskEmployee) {
		getCmsDiaryTaskEmployees().add(cmsDiaryTaskEmployee);
		cmsDiaryTaskEmployee.setCmsConstructionDiary(this);

		return cmsDiaryTaskEmployee;
	}

	public CmsDiaryTaskEmployee removeCmsDiaryTaskEmployee(CmsDiaryTaskEmployee cmsDiaryTaskEmployee) {
		getCmsDiaryTaskEmployees().remove(cmsDiaryTaskEmployee);
		cmsDiaryTaskEmployee.setCmsConstructionDiary(null);

		return cmsDiaryTaskEmployee;
	}

	public List<CmsDiaryTaskProduct> getCmsDiaryTaskProducts() {
		return this.cmsDiaryTaskProducts;
	}

	public void setCmsDiaryTaskProducts(List<CmsDiaryTaskProduct> cmsDiaryTaskProducts) {
		this.cmsDiaryTaskProducts = cmsDiaryTaskProducts;
	}

	public CmsDiaryTaskProduct addCmsDiaryTaskProduct(CmsDiaryTaskProduct cmsDiaryTaskProduct) {
		getCmsDiaryTaskProducts().add(cmsDiaryTaskProduct);
		cmsDiaryTaskProduct.setCmsConstructionDiary(this);

		return cmsDiaryTaskProduct;
	}

	public CmsDiaryTaskProduct removeCmsDiaryTaskProduct(CmsDiaryTaskProduct cmsDiaryTaskProduct) {
		getCmsDiaryTaskProducts().remove(cmsDiaryTaskProduct);
		cmsDiaryTaskProduct.setCmsConstructionDiary(null);

		return cmsDiaryTaskProduct;
	}

	public List<CmsFile> getCmsFiles() {
		return this.cmsFiles;
	}

	public void setCmsFiles(List<CmsFile> cmsFiles) {
		this.cmsFiles = cmsFiles;
	}

	public CmsFile addCmsFile(CmsFile cmsFile) {
		getCmsFiles().add(cmsFile);
		cmsFile.setCmsConstructionDiary(this);

		return cmsFile;
	}

	public CmsFile removeCmsFile(CmsFile cmsFile) {
		getCmsFiles().remove(cmsFile);
		cmsFile.setCmsConstructionDiary(null);

		return cmsFile;
	}

	public CmsProgress getCmsProgresses() {
		return cmsProgresses;
	}

	public void setCmsProgresses(CmsProgress cmsProgresses) {
		this.cmsProgresses = cmsProgresses;
	}

	public Integer getAmountofworkdone() {
		return amountofworkdone;
	}

	public void setAmountofworkdone(Integer amountofworkdone) {
		this.amountofworkdone = amountofworkdone;
	}

	
		

}