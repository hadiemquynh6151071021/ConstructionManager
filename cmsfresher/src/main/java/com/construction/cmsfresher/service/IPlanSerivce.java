package com.construction.cmsfresher.service;

import java.util.List;
import java.util.Optional;

import com.construction.cmsfresher.dto.request.cmsconstructiondiarydto.ApproveDTO;
import com.construction.cmsfresher.dto.request.cmsplansdto.CmsPlansDTO;
import com.construction.cmsfresher.dto.response.cmsplandto.CmsPlanDTO;
import com.construction.cmsfresher.dto.response.cmsplanworkitemdto.CmsPlanWorkItemPlanTaskDTO;
import com.construction.cmsfresher.model.CmsPlan;

public interface IPlanSerivce extends MapperConverter<CmsPlanDTO, CmsPlan>, DaoService<CmsPlanDTO, Integer> {

	public CmsPlan findByIdCmsPlan(Integer id);

	public String savePlans(CmsPlansDTO dto);

	public List<CmsPlanDTO> findAllCmsPlanOrderByState(Optional<Integer> id, Optional<Integer> constructionsiteid,
			Optional<Integer> planid);

	public List<CmsPlanWorkItemPlanTaskDTO> findAllPlanTaskByPlanId(Integer id);
	
	public String approveDiary(ApproveDTO dto);
	
	public String countPlanTaskDone(Integer id);



}
