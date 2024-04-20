package com.construction.cmsfresher.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.construction.cmsfresher.dto.response.mdproductdto.CmsPlanTaskProductDTO;
import com.construction.cmsfresher.model.CmsPlanTaskProduct;
import com.construction.cmsfresher.repository.IPlanTaskProductRepository;
import com.construction.cmsfresher.service.IPlanTaskProductService;
import com.construction.cmsfresher.service.MapperConverter;

@Service
public class PlanTaskProductImpl
		implements IPlanTaskProductService, MapperConverter<CmsPlanTaskProductDTO, CmsPlanTaskProduct> {

	@Autowired
	IPlanTaskProductRepository planTaskProductRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<CmsPlanTaskProductDTO> findByCmsPlanTaskProductFromPlanTaskId(Integer id) {
		// TODO Auto-generated method stub

		List<CmsPlanTaskProduct> product = planTaskProductRepository.findByCmsPlanTaskProductFromPlanTaskId(id);
		List<CmsPlanTaskProductDTO> dtos = new ArrayList<>();
		product.forEach(i -> {
			dtos.add(this.convertEntityToDto(i));
		});
		return dtos.size() > 0 ? dtos : null;
	}

	@Override
	public CmsPlanTaskProductDTO convertEntityToDto(CmsPlanTaskProduct entity) {
		// TODO Auto-generated method stub
		CmsPlanTaskProductDTO productDTO = new CmsPlanTaskProductDTO();
		productDTO = modelMapper.map(entity, CmsPlanTaskProductDTO.class);
		return productDTO;
	}

	@Override
	public CmsPlanTaskProduct convertDtoToEntity(CmsPlanTaskProductDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
