package com.construction.cmsfresher.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.construction.cmsfresher.dto.response.cmsplanstatedto.CmsPlanStateDTO;
import com.construction.cmsfresher.model.CmsPlanState;
import com.construction.cmsfresher.repository.IPlanStateRepository;
import com.construction.cmsfresher.service.MapperConverter;

@Component
public class PlanStateServiceImpl
		implements  MapperConverter<CmsPlanStateDTO, CmsPlanState> {

	@Autowired
	IPlanStateRepository planStateRepository;

	@Autowired
	ModelMapper mapper;

	@Override
	public CmsPlanStateDTO convertEntityToDto(CmsPlanState entity) {
		// TODO Auto-generated method stub
		CmsPlanStateDTO cmsPlanStateDTO = new CmsPlanStateDTO();
		cmsPlanStateDTO = mapper.map(entity, CmsPlanStateDTO.class);
		return cmsPlanStateDTO;
	}

	@Override
	public CmsPlanState convertDtoToEntity(CmsPlanStateDTO dto) {
		// TODO Auto-generated method stub
		CmsPlanState cmsPlanState = new CmsPlanState();
		cmsPlanState = mapper.map(dto, CmsPlanState.class);
		return cmsPlanState;
	}

	// tìm id findByIdPlanState trả về CmsPlanState
	public CmsPlanState findByIdPlanState(Integer id) {
		CmsPlanState planState = planStateRepository.findById(id).orElse(null);
		return planState;
	}

}
