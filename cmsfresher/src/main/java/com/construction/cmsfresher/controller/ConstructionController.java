package com.construction.cmsfresher.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.construction.cmsfresher.dto.response.mdconstructionsitedto.MdConstructionSiteDTO;
import com.construction.cmsfresher.service.IConstructionSiteService;

@RestController
@RequestMapping("/api/constructions")
@CrossOrigin("*")
public class ConstructionController {

	@Autowired
	IConstructionSiteService constructionSiteServiceImpl;

	// Lấy trường name, id, code trong constructionsite có status đã duyệt or chi
	// tiet MdConstructionSiteDTO
	@GetMapping("/active")
	private List<MdConstructionSiteDTO> findAllActiveConstructionsSite(
			@RequestParam(name = "id") Optional<Integer> id) {

		return constructionSiteServiceImpl.findAllActiveConstructionsSite(id);
	}
}
