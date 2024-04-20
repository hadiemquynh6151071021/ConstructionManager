package com.construction.cmsfresher.service;

import java.util.List;

import com.construction.cmsfresher.dto.response.cmsdiarydto.CmsDiaryTaskProductDTO;
import com.construction.cmsfresher.model.CmsDiaryTaskProduct;

public interface IDiaryTaskProductService extends MapperConverter<CmsDiaryTaskProductDTO, CmsDiaryTaskProduct>{
	public List<CmsDiaryTaskProductDTO> findProductByCmsConstructionDiary(Integer id);
}
