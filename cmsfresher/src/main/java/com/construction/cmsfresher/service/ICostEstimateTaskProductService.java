package com.construction.cmsfresher.service;

import java.util.List;

import com.construction.cmsfresher.dto.response.cmscostestimatetaskproductdto.CmsCostestimateTaskProductDTO;

public interface ICostEstimateTaskProductService extends DaoService<CmsCostestimateTaskProductDTO, Integer> {

	public List<CmsCostestimateTaskProductDTO> findAllCostestimateTaskProductFromEstimateTaskId(Integer id);
}
