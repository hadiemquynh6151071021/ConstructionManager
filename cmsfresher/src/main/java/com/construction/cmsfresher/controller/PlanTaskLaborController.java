package com.construction.cmsfresher.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.construction.cmsfresher.dto.response.mdemployeedto.CmsPlanTaskLaborDTO;
import com.construction.cmsfresher.service.IPlanTaskLaborService;

@RestController
@RequestMapping("/api/plantasklabor")
@CrossOrigin("*")
public class PlanTaskLaborController {

	@Autowired
	IPlanTaskLaborService planTaskLaborService;

	@GetMapping("/{id}")
	private List<CmsPlanTaskLaborDTO> findByCmsCmsPlanTaskLaborFromCmsTaskId(@PathVariable Integer id) {
		return planTaskLaborService.findByCmsCmsPlanTaskLaborFromCmsTaskId(id);
	}

}
