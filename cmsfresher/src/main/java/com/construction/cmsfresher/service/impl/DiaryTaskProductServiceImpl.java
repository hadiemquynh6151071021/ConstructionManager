package com.construction.cmsfresher.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.construction.cmsfresher.dto.response.cmsdiarydto.CmsDiaryTaskProductDTO;
import com.construction.cmsfresher.model.CmsDiaryTaskProduct;
import com.construction.cmsfresher.repository.IDiaryTaskProductRepository;
import com.construction.cmsfresher.service.IDiaryTaskProductService;

@Service
public class DiaryTaskProductServiceImpl implements IDiaryTaskProductService {
	@Autowired
	IDiaryTaskProductRepository diaryTaskProductRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<CmsDiaryTaskProductDTO> findProductByCmsConstructionDiary(Integer id) {
		List<CmsDiaryTaskProduct> products = diaryTaskProductRepository.findProductByCmsConstructionDiary(id);
		List<CmsDiaryTaskProductDTO> list = new ArrayList<>();
		products.forEach(i -> {
			list.add(this.convertEntityToDto(i));
		});
		return list;
	}

	@Override
	public CmsDiaryTaskProductDTO convertEntityToDto(CmsDiaryTaskProduct entity) {
		// TODO Auto-generated method stub
		CmsDiaryTaskProductDTO cmsDiaryTaskProductDTO = new CmsDiaryTaskProductDTO();
		cmsDiaryTaskProductDTO = modelMapper.map(entity, CmsDiaryTaskProductDTO.class);
		return cmsDiaryTaskProductDTO;
	}

	@Override
	public CmsDiaryTaskProduct convertDtoToEntity(CmsDiaryTaskProductDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
