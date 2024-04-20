package com.construction.cmsfresher.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.construction.cmsfresher.dto.response.cmsdiarydto.CmsDiaryTaskEmployeeDTO;
import com.construction.cmsfresher.model.CmsDiaryTaskEmployee;
import com.construction.cmsfresher.repository.IDiaryTaskEmployeeRepository;
import com.construction.cmsfresher.service.IDiaryTaskEmployeeService;

@Service
public class DiaryTaskEmployeeServiceImpl implements IDiaryTaskEmployeeService {
	@Autowired
	IDiaryTaskEmployeeRepository diaryTaskEmployeeRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<CmsDiaryTaskEmployeeDTO> findEmployeeByCmsConstructionDiary(Integer id) {
		List<CmsDiaryTaskEmployee> list = diaryTaskEmployeeRepository.findEmployeeByCmsConstructionDiary(id);
	    List<CmsDiaryTaskEmployeeDTO> dtos = new ArrayList<>();
	    list.forEach(i->{
	    	dtos.add(this.convertEntityToDto(i));
	    });
	    return dtos;
		
	}

	@Override
	public CmsDiaryTaskEmployeeDTO convertEntityToDto(CmsDiaryTaskEmployee entity) {
		// TODO Auto-generated method stub
		CmsDiaryTaskEmployeeDTO diaryTaskEmployeeDTO = new CmsDiaryTaskEmployeeDTO();
		diaryTaskEmployeeDTO = modelMapper.map(entity, CmsDiaryTaskEmployeeDTO.class);
		return diaryTaskEmployeeDTO;
	}

	@Override
	public CmsDiaryTaskEmployee convertDtoToEntity(CmsDiaryTaskEmployeeDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
