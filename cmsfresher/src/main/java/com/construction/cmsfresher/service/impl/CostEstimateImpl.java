package com.construction.cmsfresher.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.construction.cmsfresher.dto.response.mdcostestimatedto.MdCostEstimateDTO;
import com.construction.cmsfresher.dto.response.mdcostestimatedto.MdCostEstimateDetailDTO;
import com.construction.cmsfresher.model.MdCostEstimate;
import com.construction.cmsfresher.repository.ICostEstimateRepository;
import com.construction.cmsfresher.service.ICostEstimateService;
import com.construction.cmsfresher.service.MapperConverter;

@Service
public class CostEstimateImpl implements ICostEstimateService,
		MapperConverter<MdCostEstimateDTO, MdCostEstimate> {

	@Autowired
	ICostEstimateRepository costEstimateRepository;

	@Autowired
	ModelMapper mapper;

	@Override
	public List<MdCostEstimateDTO> findIdAndCodeAndNameByCostructionID(Integer idConstruction) {
		List<MdCostEstimate> list = costEstimateRepository.findIdAndCodeAndNameByCostructionID(idConstruction);
		List<MdCostEstimateDTO> costEstimateDTOs = new ArrayList<>();
		list.forEach(i -> {
			costEstimateDTOs.add(this.convertEntityToDto(i));
		});
		return costEstimateDTOs.size() > 0 ? costEstimateDTOs : null;

	}

	@Override
	public MdCostEstimateDTO save(MdCostEstimateDTO entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MdCostEstimateDTO findById(Integer id) {
		MdCostEstimate costEstimate = costEstimateRepository.findById(id).orElse(null);
		MdCostEstimateDTO costEstimateDTO = this.convertEntityToDto(costEstimate);
		return costEstimateDTO != null ? costEstimateDTO : null;
	}

	@Override
	public List<MdCostEstimateDTO> findAll() {
		// TODO Auto-generated method stub
		List<MdCostEstimate> costEstimates = costEstimateRepository.findAll();
		List<MdCostEstimateDTO> costEstimateDTOs = new ArrayList<>();
		costEstimates.forEach(i -> {
			costEstimateDTOs.add(this.convertEntityToDto(i));
		});

		return costEstimateDTOs.size() > 0 ? costEstimateDTOs : null;
	}
	
	@Override
	public List<MdCostEstimateDetailDTO> findAllMdCostEstimateDetailDTO() {
		// TODO Auto-generated method stub
		List<MdCostEstimate> costEstimates = costEstimateRepository.findAll();
		List<MdCostEstimateDetailDTO> costEstimateDetailDTOs = new ArrayList<>();
		costEstimates.forEach(i -> {
			costEstimateDetailDTOs.add(this.convertEntityToCostEstimateDetail(i));
		});

		return costEstimateDetailDTOs.size() > 0 ? costEstimateDetailDTOs : null;
	}

	@Override
	public MdCostEstimateDTO convertEntityToDto(MdCostEstimate entity) {
		// TODO Auto-generated method stub
		MdCostEstimateDTO costEstimateDTO = new MdCostEstimateDTO();
		costEstimateDTO = mapper.map(entity, MdCostEstimateDTO.class);
		return costEstimateDTO;
	}
	
	public MdCostEstimateDetailDTO convertEntityToCostEstimateDetail(MdCostEstimate entity) {
		// TODO Auto-generated method stub
		MdCostEstimateDetailDTO costEstimateDTO = new MdCostEstimateDetailDTO();
		costEstimateDTO = mapper.map(entity, MdCostEstimateDetailDTO.class);
		return costEstimateDTO;
	}

	@Override
	public MdCostEstimate convertDtoToEntity(MdCostEstimateDTO dto) {
		// TODO Auto-generated method stub
		MdCostEstimate costEstimate = new MdCostEstimate();
		costEstimate = mapper.map(dto, MdCostEstimate.class);
		return costEstimate;
	}
	
	// Lấy hết filed trong chi tiết dự toán
	public MdCostEstimateDetailDTO findByIdCostEstimateDetailDTO(Integer id) {
		MdCostEstimate costEstimate = costEstimateRepository.findById(id).orElse(null);
		MdCostEstimateDetailDTO costEstimateDTO = this.convertEntityToCostEstimateDetail(costEstimate);
		return costEstimateDTO != null ? costEstimateDTO : null;
	}

}
