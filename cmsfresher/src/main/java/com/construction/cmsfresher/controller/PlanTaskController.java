package com.construction.cmsfresher.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.construction.cmsfresher.dto.response.cmsplantaskdto.CmsPlanTaskDTO;
import com.construction.cmsfresher.dto.response.mdemployeedto.MdEmployeeDTO;
import com.construction.cmsfresher.repository.IPlanTaskRepository;
import com.construction.cmsfresher.service.IPlanTaskService;

@RestController
@RequestMapping("/api/plantask")
@CrossOrigin("*")
public class PlanTaskController {

	@Autowired
	IPlanTaskService planTaskService;

	@Autowired
	IPlanTaskRepository planTaskRepository;

	// plantaskid lấy theo chi tiết 
	// constructionid lấy theo cv theo mã constructionid
	@GetMapping("")
	private List<CmsPlanTaskDTO> findAllCmsPlanTaskFromConstructionSiteId(
			@RequestParam(name = "constructionid") Optional<Integer> constructionid,
			@RequestParam(name = "plantaskid") Optional<Integer> plantaskid) {

		return planTaskService.findAllCmsPlanTaskFromConstructionSiteId(constructionid, plantaskid);
	}
	
	// tìm người giám sát theo constructionid
	@GetMapping("/supervisor")
	private List<MdEmployeeDTO> findEmployee(
			@RequestParam(name = "constructionid") Optional<Integer> constructionid,
			@RequestParam(name = "plantaskid") Optional<Integer> plantaskid) {

		return planTaskService.findEmployee(constructionid, plantaskid);
	}
}
