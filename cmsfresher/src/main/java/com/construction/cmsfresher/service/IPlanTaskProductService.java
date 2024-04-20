package com.construction.cmsfresher.service;

import java.util.List;

import com.construction.cmsfresher.dto.response.mdproductdto.CmsPlanTaskProductDTO;

public interface IPlanTaskProductService {
	public List<CmsPlanTaskProductDTO> findByCmsPlanTaskProductFromPlanTaskId(Integer id);

}
