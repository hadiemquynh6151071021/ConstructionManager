package com.construction.cmsfresher.dto.response.cmsdiarydto;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.construction.cmsfresher.dto.response.cmsdiaryhistorydto.CmsDiaryHistoryDTO;
import com.construction.cmsfresher.dto.response.cmsdiarystatedto.CmsDiaryStateDTO;
import com.construction.cmsfresher.dto.response.cmsfiledto.CmsFileDTO;
import com.construction.cmsfresher.dto.response.cmsplantaskdto.CmsPlanTaskDetailDTO;
import com.construction.cmsfresher.dto.response.mdemployeedto.MdEmployeeDTO;
import com.construction.cmsfresher.model.MdWeather;

public class CmsDiaryDTO {

	private Integer diaryid;
	private String diaryidcode;

	private CmsDiaryStateDTO cmsDiaryState;

	private Timestamp createdtime;
	private Time endtime;
	private Time starttime;

	private CmsPlanTaskDetailDTO cmsPlanTask;
	private Date dateofdiary;
	private MdEmployeeDTO mdEmployee;
	private MdWeather mdWeather;
	private double temperature;
	private String problem;

	List<CmsDiaryHistoryDTO> cmsDiaryHistories;
	private CmsProgressDTO cmsProgresses;

	private List<CmsFileDTO> cmsFiles;

	private Integer amountofworkdone;

	
	
	public Integer getAmountofworkdone() {
		return amountofworkdone;
	}

	public void setAmountofworkdone(Integer amountofworkdone) {
		this.amountofworkdone = amountofworkdone;
	}

	public Integer getDiaryid() {
		return diaryid;
	}

	public void setDiaryid(Integer diaryid) {
		this.diaryid = diaryid;
	}

	public CmsDiaryStateDTO getCmsDiaryState() {
		return cmsDiaryState;
	}

	public void setCmsDiaryState(CmsDiaryStateDTO cmsDiaryState) {
		this.cmsDiaryState = cmsDiaryState;
	}

	public Timestamp getCreatedtime() {
		return createdtime;
	}

	public void setCreatedtime(Timestamp createdtime) {
		this.createdtime = createdtime;
	}

	public CmsPlanTaskDetailDTO getCmsPlanTask() {
		return cmsPlanTask;
	}

	public void setCmsPlanTask(CmsPlanTaskDetailDTO cmsPlanTask) {
		this.cmsPlanTask = cmsPlanTask;
	}

	public Date getDateofdiary() {
		return dateofdiary;
	}

	public void setDateofdiary(Date dateofdiary) {
		this.dateofdiary = dateofdiary;
	}

	public MdEmployeeDTO getMdEmployee() {
		return mdEmployee;
	}

	public void setMdEmployee(MdEmployeeDTO mdEmployee) {
		this.mdEmployee = mdEmployee;
	}

	public MdWeather getMdWeather() {
		return mdWeather;
	}

	public void setMdWeather(MdWeather mdWeather) {
		this.mdWeather = mdWeather;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public List<CmsFileDTO> getCmsFiles() {
		return cmsFiles;
	}

	public void setCmsFiles(List<CmsFileDTO> cmsFiles) {
		this.cmsFiles = cmsFiles;
	}

	public String getDiaryidcode() {
		return diaryidcode;
	}

	public void setDiaryidcode(String diaryidcode) {
		this.diaryidcode = diaryidcode;
	}

	public CmsProgressDTO getCmsProgresses() {
		return cmsProgresses;
	}

	public void setCmsProgresses(CmsProgressDTO cmsProgresses) {
		this.cmsProgresses = cmsProgresses;
	}

	public Time getEndtime() {
		return endtime;
	}

	public void setEndtime(Time endtime) {
		this.endtime = endtime;
	}

	public Time getStarttime() {
		return starttime;
	}

	public void setStarttime(Time starttime) {
		this.starttime = starttime;
	}

	public List<CmsDiaryHistoryDTO> getCmsDiaryHistories() {
		return cmsDiaryHistories;
	}

	public void setCmsDiaryHistories(List<CmsDiaryHistoryDTO> cmsDiaryHistories) {
		this.cmsDiaryHistories = cmsDiaryHistories;
	}

	
}
