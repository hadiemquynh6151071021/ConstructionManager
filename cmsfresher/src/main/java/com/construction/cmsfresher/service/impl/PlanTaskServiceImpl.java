package com.construction.cmsfresher.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.construction.cmsfresher.dto.response.cmsplantaskdto.CmsPlanTaskDTO;
import com.construction.cmsfresher.dto.response.mdemployeedto.MdEmployeeDTO;
import com.construction.cmsfresher.model.CmsPlanTask;
import com.construction.cmsfresher.model.MdEmployee;
import com.construction.cmsfresher.repository.IEmployeeRepository;
import com.construction.cmsfresher.repository.IPlanTaskRepository;
import com.construction.cmsfresher.service.IPlanTaskService;
import com.construction.cmsfresher.service.MapperConverter;

@Service
public class PlanTaskServiceImpl implements IPlanTaskService, MapperConverter<CmsPlanTaskDTO, CmsPlanTask> {

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	IPlanTaskRepository planTaskRepository;

	@Autowired
	IEmployeeRepository employeeRepository;

	@Override
	public List<CmsPlanTaskDTO> findAllCmsPlanTaskFromConstructionSiteId(Optional<Integer> constructionid,
			Optional<Integer> plantaskid) {
		if (constructionid.isPresent()) {
			List<CmsPlanTask> list = planTaskRepository.findAllCmsPlanTaskFromConstructionSiteId(constructionid, null);
			List<CmsPlanTaskDTO> planTaskDTOs = new ArrayList<>();
			list.forEach(i -> {
				planTaskDTOs.add(this.convertEntityToDto(i));
			});
			return planTaskDTOs;
		}

		List<CmsPlanTask> list = planTaskRepository.findAllCmsPlanTaskFromConstructionSiteId(null, plantaskid);

		List<CmsPlanTaskDTO> planTaskDTOs = new ArrayList<>();
		list.forEach(i -> {
			planTaskDTOs.add(this.convertEntityToDto(i));
		});

		return planTaskDTOs;
	}

	@Override
	public CmsPlanTaskDTO save(CmsPlanTaskDTO entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CmsPlanTaskDTO findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CmsPlanTaskDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CmsPlanTaskDTO convertEntityToDto(CmsPlanTask entity) {
		// TODO Auto-generated method stub
		CmsPlanTaskDTO cmsPlanTaskDTO = new CmsPlanTaskDTO();
		cmsPlanTaskDTO = modelMapper.map(entity, CmsPlanTaskDTO.class);
		return cmsPlanTaskDTO;
	}

	@Override
	public CmsPlanTask convertDtoToEntity(CmsPlanTaskDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MdEmployeeDTO> findEmployee(Optional<Integer> constructionid, Optional<Integer> plantaskid) {
		// TODO Auto-generated method stub
		List<MdEmployeeDTO> dtos = new ArrayList<>();
		if (constructionid.isPresent()) {
			List<Integer> list = planTaskRepository.findEmployee(constructionid, null);
			list.forEach(i -> {
				MdEmployee employee = employeeRepository.findById(i).orElse(null);
				dtos.add(this.convertEntityToDto(employee));
			});
		}
		List<Integer> list = planTaskRepository.findEmployee(null, plantaskid);
		list.forEach(i -> {
			MdEmployee employee = employeeRepository.findById(i).orElse(null);
			dtos.add(this.convertEntityToDto(employee));
		});
		return dtos;
	}

	public MdEmployeeDTO convertEntityToDto(MdEmployee entity) {
		// TODO Auto-generated method stub
		MdEmployeeDTO cmsPlanTaskDTO = new MdEmployeeDTO();
		cmsPlanTaskDTO = modelMapper.map(entity, MdEmployeeDTO.class);
		return cmsPlanTaskDTO;
	}

}
