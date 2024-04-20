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

import com.construction.cmsfresher.dto.response.cmscostestimatetaskdto.CmsCostEstimateTaskDTO;
import com.construction.cmsfresher.dto.response.cmscostestimatetaskdto.CmsCostEstimateTaskWorkitemDTO;
import com.construction.cmsfresher.service.ICostEstimateTaskService;

@RestController
@RequestMapping("/api/costestimatetask")
@CrossOrigin("*")
public class CostestimateTaskController {

	@Autowired
	ICostEstimateTaskService costEstimateTaskImpl;

	@GetMapping("")
	private List<CmsCostEstimateTaskDTO> findAll() {
		return costEstimateTaskImpl.findAll();
	}

	// Lấy tất cả hạng mục công việc dựa theo dự toán
	@GetMapping("/getlistbycostestimateid/{id}")
	private ResponseEntity<List<CmsCostEstimateTaskWorkitemDTO>> findAllCostEstimateId(@PathVariable Integer id) {
		List<CmsCostEstimateTaskWorkitemDTO> costestimateTasks = costEstimateTaskImpl.findAllByCostestimatetaskid(id);
		if (costestimateTasks == null) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<CmsCostEstimateTaskWorkitemDTO>>(costestimateTasks, HttpStatus.OK);
	}
}
