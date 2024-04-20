package com.construction.cmsfresher.service;

import java.util.List;

import com.construction.cmsfresher.dto.response.cmsdiarydto.CmsDiaryTaskEmployeeDTO;
import com.construction.cmsfresher.model.CmsDiaryTaskEmployee;

public interface IDiaryTaskEmployeeService extends MapperConverter<CmsDiaryTaskEmployeeDTO, CmsDiaryTaskEmployee>{
	public List<CmsDiaryTaskEmployeeDTO> findEmployeeByCmsConstructionDiary(Integer id);
}
