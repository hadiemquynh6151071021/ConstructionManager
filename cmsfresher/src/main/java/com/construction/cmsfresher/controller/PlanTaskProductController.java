package com.construction.cmsfresher.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.construction.cmsfresher.dto.response.mdproductdto.CmsPlanTaskProductDTO;
import com.construction.cmsfresher.repository.IPlanTaskProductRepository;
import com.construction.cmsfresher.service.IPlanTaskProductService;

@RestController
@RequestMapping("/api/plantaskproduct")
@CrossOrigin("*")
public class PlanTaskProductController {
	@Autowired
	IPlanTaskProductService planTaskProductService;

	@Autowired
	IPlanTaskProductRepository planTaskProductRepository;

	@GetMapping("/{id}")
	private List<CmsPlanTaskProductDTO> findByCmsPlanTaskProductFromPlanTaskId(@PathVariable Integer id) {
		return planTaskProductService.findByCmsPlanTaskProductFromPlanTaskId(id);
	}

}
