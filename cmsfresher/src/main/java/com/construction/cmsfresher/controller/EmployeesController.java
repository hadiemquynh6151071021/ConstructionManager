package com.construction.cmsfresher.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.construction.cmsfresher.dto.response.mdemployeedto.MdEmployeeDTO;
import com.construction.cmsfresher.repository.IEmployeeRepository;
import com.construction.cmsfresher.service.IEmployeeService;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin("*")

public class EmployeesController {

	@Autowired
	IEmployeeService employeeServiceImpl;

	@Autowired
	IEmployeeRepository employeeRepository;

	@GetMapping("/search")
	private ResponseEntity<List<MdEmployeeDTO>> findByNameOrUserId(@RequestParam(value = "name") String name,
			@RequestParam(value = "labor") Integer labor) {

		List<MdEmployeeDTO> list = employeeServiceImpl.findLaborPosition(name, labor);
		if (list == null) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<MdEmployeeDTO>>(list, HttpStatus.OK);
	}
	

}
