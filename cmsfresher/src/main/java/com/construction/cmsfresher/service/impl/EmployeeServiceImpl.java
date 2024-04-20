package com.construction.cmsfresher.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.construction.cmsfresher.dto.response.mdemployeedto.MdEmployeeDTO;
import com.construction.cmsfresher.model.MdEmployee;
import com.construction.cmsfresher.repository.IEmployeeRepository;
import com.construction.cmsfresher.service.IEmployeeService;
import com.construction.cmsfresher.service.MapperConverter;

@Service
public class EmployeeServiceImpl
		implements  MapperConverter<MdEmployeeDTO, MdEmployee>, IEmployeeService {

	@Autowired
	private IEmployeeRepository employeeRepository;

	@Autowired
	ModelMapper mapper;

	@Override
	public MdEmployee save(MdEmployee entity) {
		// TODO Auto-generated method stub
		return employeeRepository.save(entity);
	}

	@Override
	public MdEmployee findById(Integer id) {
		MdEmployee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new UsernameNotFoundException("Not found Account"));
		return employee;
	}

	@Override
	public List<MdEmployee> findAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public List<MdEmployeeDTO> findLaborPosition(String name,Integer labor) {
		// TODO Auto-generated method stub
		List<MdEmployee> employees = employeeRepository.findLaborPosition(name,labor);
		List<MdEmployeeDTO> dtos = new ArrayList<>();
		employees.forEach(i -> {
			dtos.add(this.convertEntityToDto(i));
		});
		return dtos.size() > 0 ? dtos : null;
	}

	@Override
	public MdEmployeeDTO convertEntityToDto(MdEmployee entity) {
		// TODO Auto-generated method stub
		MdEmployeeDTO dto = new MdEmployeeDTO();
		dto = mapper.map(entity, MdEmployeeDTO.class);
		return dto;
	}

	@Override
	public MdEmployee convertDtoToEntity(MdEmployeeDTO dto) {
		// TODO Auto-generated method stub
		MdEmployee entity = new MdEmployee();
		entity = mapper.map(dto, MdEmployee.class);
		return entity;
	}

	
	// tìm id findByIdMdEmployee trả về MdEmployee
	@Override
	public MdEmployee findByIdMdEmployee(Integer id) {
		MdEmployee employee = employeeRepository.findById(id).orElse(null);
		return employee;
	}

}