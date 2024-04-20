package com.construction.cmsfresher.service;

import java.util.List;

import com.construction.cmsfresher.dto.response.cmscostestimatetaskdto.CmsCostEstimateTaskWorkitemDTO;
import com.construction.cmsfresher.dto.response.cmscostestimatetaskdto.CmsCostEstimateTaskDTO;

public interface ICostEstimateTaskService extends DaoService<CmsCostEstimateTaskDTO, Integer> {

	public List<CmsCostEstimateTaskWorkitemDTO> findAllByCostestimatetaskid(Integer id);
}
