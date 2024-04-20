package com.construction.cmsfresher.service;

import java.util.List;
import java.util.Optional;

import com.construction.cmsfresher.dto.response.cmsplantaskdto.CmsPlanTaskDTO;
import com.construction.cmsfresher.dto.response.mdemployeedto.MdEmployeeDTO;

public interface IPlanTaskService extends DaoService<CmsPlanTaskDTO, Integer>{
	public List<CmsPlanTaskDTO> findAllCmsPlanTaskFromConstructionSiteId(Optional<Integer> constructionid, Optional<Integer> plantaskid);
	
	public List<MdEmployeeDTO> findEmployee(Optional<Integer> constructionid, Optional<Integer> plantaskid);

}
