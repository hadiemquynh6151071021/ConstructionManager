package com.construction.cmsfresher.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.construction.cmsfresher.dto.response.mdemployeedto.CmsPlanTaskLaborDTO;
import com.construction.cmsfresher.model.CmsPlanTaskLabor;
import com.construction.cmsfresher.repository.IPlanTaskLaborRepository;
import com.construction.cmsfresher.service.IPlanTaskLaborService;
import com.construction.cmsfresher.service.MapperConverter;

@Service
public class PlanTaskLaborImpl
		implements IPlanTaskLaborService, MapperConverter<CmsPlanTaskLaborDTO, CmsPlanTaskLabor> {

	@Autowired
	IPlanTaskLaborRepository planTaskLaborRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<CmsPlanTaskLaborDTO> findByCmsCmsPlanTaskLaborFromCmsTaskId(Integer id) {
		// TODO Auto-generated method stub

		List<CmsPlanTaskLabor> labor = planTaskLaborRepository.findByCmsCmsPlanTaskLaborFromCmsTaskId(id);
		List<CmsPlanTaskLaborDTO> dto = new ArrayList<>();
		labor.forEach(i -> {
			dto.add(this.convertEntityToDto(i));
		});
		return dto;
	}

	@Override
	public CmsPlanTaskLaborDTO convertEntityToDto(CmsPlanTaskLabor entity) {
		// TODO Auto-generated method stub
		CmsPlanTaskLaborDTO laborDTO = new CmsPlanTaskLaborDTO();
		laborDTO = modelMapper.map(entity, CmsPlanTaskLaborDTO.class);
		return laborDTO;
	}

	@Override
	public CmsPlanTaskLabor convertDtoToEntity(CmsPlanTaskLaborDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
