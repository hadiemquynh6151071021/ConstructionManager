package com.construction.cmsfresher.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.construction.cmsfresher.dto.request.cmsconstructiondiarydto.ApproveDTO;
import com.construction.cmsfresher.dto.request.cmsplansdto.CmsPlansDTO;
import com.construction.cmsfresher.dto.response.cmsplandto.CmsPlanDTO;
import com.construction.cmsfresher.dto.response.cmsplanworkitemdto.CmsPlanWorkItemPlanTaskDTO;
import com.construction.cmsfresher.dto.response.mdemployeedto.CmsPlanTaskLaborDTO;
import com.construction.cmsfresher.dto.response.mdproductdto.CmsPlanTaskProductDTO;
import com.construction.cmsfresher.repository.IPlanRepository;
import com.construction.cmsfresher.service.IPlanSerivce;
import com.construction.cmsfresher.service.IPlanTaskLaborService;
import com.construction.cmsfresher.service.IPlanTaskProductService;
import com.construction.cmsfresher.service.impl.PlanHistoryServiceImpl;

@RestController
@RequestMapping("/api/plans")
@CrossOrigin("*")
public class PlansController {

	@Autowired
	IPlanSerivce planSerivce;

	@Autowired
	PlanHistoryServiceImpl historyServiceImpl;

	@Autowired
	IPlanRepository planRepository;

	@Autowired
	IPlanTaskProductService planTaskProductService;

	@Autowired
	IPlanTaskLaborService planTaskLaborService;

	@GetMapping("")
	private ResponseEntity<List<CmsPlanDTO>> cmsPlans(@RequestParam Optional<Integer> id,
			Optional<Integer> constructionsiteid, Optional<Integer> planid) {
		return new ResponseEntity<List<CmsPlanDTO>>(
				planSerivce.findAllCmsPlanOrderByState(id, constructionsiteid, planid), HttpStatus.OK);
	}

	// Lấy danh sách plantaskproduct theo plantaskid
	@GetMapping("/plantaskproduct/{id}")
	private ResponseEntity<List<CmsPlanTaskProductDTO>> findByCmsPlanTaskProductFromPlanTaskId(
			@PathVariable Integer id) {
		return new ResponseEntity<List<CmsPlanTaskProductDTO>>(
				planTaskProductService.findByCmsPlanTaskProductFromPlanTaskId(id), HttpStatus.OK);
	}

	// Lấy danh sách plantasklabor theo plantaskid
	@GetMapping("/plantasklabor/{id}")
	private ResponseEntity<List<CmsPlanTaskLaborDTO>> findByCmsCmsPlanTaskLaborFromCmsTaskId(@PathVariable Integer id) {
		return new ResponseEntity<List<CmsPlanTaskLaborDTO>>(
				planTaskLaborService.findByCmsCmsPlanTaskLaborFromCmsTaskId(id), HttpStatus.OK);
	}

	@PostMapping("/save")
	private String save(@RequestBody CmsPlansDTO cmsPlansDTO) {
		return planSerivce.savePlans(cmsPlansDTO);
		
	}

	// Lấy danh sách thông tin công việc dựa vào mã plan
	@GetMapping("/getlistbyplanid/{id}")
	private List<CmsPlanWorkItemPlanTaskDTO> findAllPlanTaskByPlanId(@PathVariable Integer id) {
		return planSerivce.findAllPlanTaskByPlanId(id);

	}

	@PostMapping("/approve")
	private ResponseEntity<String> Approve(@RequestBody ApproveDTO dto) {
		return new ResponseEntity<String>(planSerivce.approveDiary(dto), HttpStatus.OK);
	}
	
	@GetMapping("/countplantask/{id}")
	private String countPlanTaskDone(@PathVariable Integer id) {
		String number = planSerivce.countPlanTaskDone(id);
		return "Công việc đã hoàn thành: " + number;
	}

}
