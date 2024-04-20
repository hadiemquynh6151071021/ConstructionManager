package com.construction.cmsfresher.service;

import java.util.List;

import com.construction.cmsfresher.dto.response.mdemployeedto.MdEmployeeDTO;
import com.construction.cmsfresher.model.MdEmployee;

public interface IEmployeeService extends DaoService<MdEmployee, Integer> {

	public List<MdEmployeeDTO> findLaborPosition(String name,Integer labor);
	
	public MdEmployee findByIdMdEmployee(Integer id);

}
