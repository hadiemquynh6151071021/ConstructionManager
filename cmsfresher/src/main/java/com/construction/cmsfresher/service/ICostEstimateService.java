package com.construction.cmsfresher.service;

import java.util.List;

import com.construction.cmsfresher.dto.response.mdcostestimatedto.MdCostEstimateDTO;
import com.construction.cmsfresher.dto.response.mdcostestimatedto.MdCostEstimateDetailDTO;

public interface ICostEstimateService extends DaoService<MdCostEstimateDTO, Integer>{
	List<MdCostEstimateDTO> findIdAndCodeAndNameByCostructionID(Integer idConstruction);
	public List<MdCostEstimateDetailDTO> findAllMdCostEstimateDetailDTO();
	public MdCostEstimateDetailDTO findByIdCostEstimateDetailDTO(Integer id);
}
