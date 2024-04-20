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

import com.construction.cmsfresher.dto.response.mdcostestimatedto.MdCostEstimateDTO;
import com.construction.cmsfresher.dto.response.mdcostestimatedto.MdCostEstimateDetailDTO;
import com.construction.cmsfresher.service.ICostEstimateService;

@RestController
@RequestMapping("/api/costestimate")
@CrossOrigin("*")
public class CostEstimateController {
	@Autowired
	ICostEstimateService costEstimateImpl;

	// Lấy tất cả trường trong findAllMdCostEstimateDetailDTO
	@GetMapping("")
	private List<MdCostEstimateDetailDTO> findAllMdCostEstimateDetailDTO() {
		return costEstimateImpl.findAllMdCostEstimateDetailDTO();
	}

	// Lấy danh sách code và name trong MdCostEstimateDTO theo mã công trình
	@GetMapping("/getcodeandname/{id}")
	private ResponseEntity<List<MdCostEstimateDTO>> findIdAndCodeAndNameByCostructionID(@PathVariable Integer id) {
		List<MdCostEstimateDTO> costEstimates = costEstimateImpl.findIdAndCodeAndNameByCostructionID(id);
		if (costEstimates == null) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<MdCostEstimateDTO>>(costEstimates, HttpStatus.OK);
	}

	// Lấy chi tiết dự toán trong MdCostEstimateDetailDTO
	@GetMapping("/{id}")
	private ResponseEntity<MdCostEstimateDetailDTO> findByIdCostEstimateDetailDTO(@PathVariable Integer id) {
		MdCostEstimateDetailDTO mdCostEstimate = costEstimateImpl.findByIdCostEstimateDetailDTO(id);
		if (mdCostEstimate == null) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<MdCostEstimateDetailDTO>(mdCostEstimate, HttpStatus.OK);
	}
}
