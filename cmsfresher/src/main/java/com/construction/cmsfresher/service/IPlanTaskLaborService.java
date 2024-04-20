package com.construction.cmsfresher.service;

import java.util.List;

import com.construction.cmsfresher.dto.response.mdemployeedto.CmsPlanTaskLaborDTO;

public interface IPlanTaskLaborService {
	public List<CmsPlanTaskLaborDTO> findByCmsCmsPlanTaskLaborFromCmsTaskId(Integer id);

}
