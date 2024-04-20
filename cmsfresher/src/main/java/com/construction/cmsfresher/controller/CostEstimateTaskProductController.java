package com.construction.cmsfresher.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.construction.cmsfresher.dto.response.cmscostestimatetaskproductdto.CmsCostestimateTaskProductDTO;
import com.construction.cmsfresher.repository.ICostEstimateTaskProductRepository;
import com.construction.cmsfresher.service.ICostEstimateTaskProductService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/costestimatetaskproduct")
public class CostEstimateTaskProductController {

	@Autowired
	ICostEstimateTaskProductService costEstimateTaskProductServiceImpl;
	
	@Autowired
	ICostEstimateTaskProductRepository costEstimateTaskProductRepository;

	@GetMapping("")
	private List<CmsCostestimateTaskProductDTO> findAll() {
		return costEstimateTaskProductServiceImpl.findAll();
	}

	// lấy thông tin chi tiết của CmsCostestimateTaskProductDTO từ mã id củaCmsCostestimateTaskProductDTO
	@GetMapping("/{id}")
	private ResponseEntity<CmsCostestimateTaskProductDTO> findById(@PathVariable Integer id) {

		CmsCostestimateTaskProductDTO costestimateTaskProduct = costEstimateTaskProductServiceImpl.findById(id);
		if (costestimateTaskProduct == null) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<CmsCostestimateTaskProductDTO>(costestimateTaskProduct, HttpStatus.OK);
	}

	// Lấy thông tin CmsCostestimateTaskProductDTO từ mã costestimate_task_id 
	@GetMapping("/getlistbycostestimatetaskid/{id}")
	private ResponseEntity<List<CmsCostestimateTaskProductDTO>> findAllCostestimateTaskProductFromEstimateTaskId(
			@PathVariable Integer id) {
		List<CmsCostestimateTaskProductDTO> list = costEstimateTaskProductServiceImpl
				.findAllCostestimateTaskProductFromEstimateTaskId(id);
		if (list == null) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<CmsCostestimateTaskProductDTO>>(list, HttpStatus.OK);
	}

}
