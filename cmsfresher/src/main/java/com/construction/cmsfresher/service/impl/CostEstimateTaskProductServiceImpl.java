package com.construction.cmsfresher.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.construction.cmsfresher.dto.response.cmscostestimatetaskproductdto.CmsCostestimateTaskProductDTO;
import com.construction.cmsfresher.model.CmsCostestimateTaskProduct;
import com.construction.cmsfresher.repository.ICostEstimateTaskProductRepository;
import com.construction.cmsfresher.service.ICostEstimateTaskProductService;
import com.construction.cmsfresher.service.MapperConverter;

@Service
public class CostEstimateTaskProductServiceImpl implements
		ICostEstimateTaskProductService, MapperConverter<CmsCostestimateTaskProductDTO, CmsCostestimateTaskProduct> {

	@Autowired
	ICostEstimateTaskProductRepository costEstimateTaskProductRepository;

	@Autowired
	ModelMapper mapper;

	@Override
	public CmsCostestimateTaskProductDTO save(CmsCostestimateTaskProductDTO entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CmsCostestimateTaskProductDTO findById(Integer id) {
		// TODO Auto-generated method stub
		CmsCostestimateTaskProduct taskProduct = costEstimateTaskProductRepository.findById(id).orElse(null);
		if (taskProduct == null) {
			return null;
		}
		CmsCostestimateTaskProductDTO taskProductDTO = this.convertEntityToDto(taskProduct);
		return taskProductDTO;
	}

	@Override
	public List<CmsCostestimateTaskProductDTO> findAll() {
		// TODO Auto-generated method stub
		List<CmsCostestimateTaskProduct> lists = costEstimateTaskProductRepository.findAll();
		List<CmsCostestimateTaskProductDTO> dtos = new ArrayList<>();
		lists.forEach(i -> {
			dtos.add(this.convertEntityToDto(i));
		});
		return dtos;
	}

	// Lấy thông tin CmsCostestimateTaskProductDTO từ mã estimatetaskid
	@Override
	public List<CmsCostestimateTaskProductDTO> findAllCostestimateTaskProductFromEstimateTaskId(Integer id) {
		// TODO Auto-generated method stub

		List<CmsCostestimateTaskProduct> lists = costEstimateTaskProductRepository
				.findAllCostestimateTaskProductFromEstimateTaskId(id);
		List<CmsCostestimateTaskProductDTO> dtos = new ArrayList<>();
		lists.forEach(i -> {
			dtos.add(this.convertEntityToDto(i));
		});
		return dtos.size() > 0 ? dtos : null;
	}

	@Override
	public CmsCostestimateTaskProductDTO convertEntityToDto(CmsCostestimateTaskProduct entity) {
		// TODO Auto-generated method stub
		CmsCostestimateTaskProductDTO costestimateTaskProductDTO = new CmsCostestimateTaskProductDTO();
		costestimateTaskProductDTO = mapper.map(entity, CmsCostestimateTaskProductDTO.class);
		return costestimateTaskProductDTO;
	}

	@Override
	public CmsCostestimateTaskProduct convertDtoToEntity(CmsCostestimateTaskProductDTO dto) {
		// TODO Auto-generated method stub
		CmsCostestimateTaskProduct cmsCostestimateTaskProduct = new CmsCostestimateTaskProduct();
		cmsCostestimateTaskProduct = mapper.map(dto, CmsCostestimateTaskProduct.class);
		return cmsCostestimateTaskProduct;
	}

}
