package com.construction.cmsfresher.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import com.construction.cmsfresher.dto.request.cmsconstructiondiarydto.CmsConstructionDiaryDTO;
import com.construction.cmsfresher.dto.response.cmsdiarydto.CmsDiaryDTO;
import com.construction.cmsfresher.dto.response.cmsdiarydto.CmsDiaryTaskEmployeeDTO;
import com.construction.cmsfresher.dto.response.cmsdiarydto.CmsDiaryTaskProductDTO;
import com.construction.cmsfresher.dto.response.cmsdiarydto.CmsProgressDTO;
import com.construction.cmsfresher.model.MdShift;
import com.construction.cmsfresher.model.MdWeather;
import com.construction.cmsfresher.repository.IConstructionDiaryRepository;
import com.construction.cmsfresher.repository.IRoleEmployeePlanWorkItemRepository;
import com.construction.cmsfresher.service.IConstructionDiaryService;
import com.construction.cmsfresher.service.IDiaryTaskEmployeeService;
import com.construction.cmsfresher.service.IDiaryTaskProductService;
import com.construction.cmsfresher.service.IProgressService;
import com.construction.cmsfresher.service.IWeatherService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/diary")
@CrossOrigin("*")
public class ConstructionDiaryController {
	@Autowired
	IWeatherService weatherService;
	@Autowired
	IConstructionDiaryService contructionDiaryService;
	@Autowired
	IProgressService progressService;
	@Autowired
	IDiaryTaskProductService diaryTaskProductService;
	@Autowired
	IDiaryTaskEmployeeService diaryTaskEmployeeService;

	@Autowired
	IConstructionDiaryRepository constructionDiaryRepository;

	@Autowired
	IRoleEmployeePlanWorkItemRepository employeePlanWorkItemRepository;

	@GetMapping("/weathers")
	private ResponseEntity<List<MdWeather>> findAllWeather() {
		List<MdWeather> list = weatherService.findAllWeather();
		if (list == null) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<MdWeather>>(list, HttpStatus.OK);
	}

	@GetMapping("/shifts")
	private ResponseEntity<List<MdShift>> findAllShift() {
		List<MdShift> list = weatherService.findAllShirt();
		if (list == null) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<MdShift>>(list, HttpStatus.OK);
	}

	@PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<String> save(@RequestBody @Valid CmsConstructionDiaryDTO cmsConstructionDiaryDTO) {
		String diary = contructionDiaryService.saveDiary(cmsConstructionDiaryDTO);
		if(diary == null) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>(diary, HttpStatus.OK);

	}

	@GetMapping("/progress")
	private ResponseEntity<CmsProgressDTO> getProgressByPlanTaskOrDiary(@RequestParam Optional<Integer> plantaskid,
			Optional<Integer> diaryid) {
		CmsProgressDTO dto = progressService.getProgressByPlanTaskOrDiary(plantaskid, diaryid);
		if (dto == null) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<CmsProgressDTO>(dto, HttpStatus.OK);
	}

	// lấy vật tư từ mã nhật ký
	@GetMapping("/taskproduct/{id}")
	private ResponseEntity<List<CmsDiaryTaskProductDTO>> findByCmsConstructionDiary(@PathVariable Integer id) {
		List<CmsDiaryTaskProductDTO> dto = diaryTaskProductService.findProductByCmsConstructionDiary(id);
		if (dto == null) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<CmsDiaryTaskProductDTO>>(dto, HttpStatus.OK);
	}

	// lấy nhân công từ mã nhật ký
	@GetMapping("taskemployee/{id}")
	private ResponseEntity<List<CmsDiaryTaskEmployeeDTO>> findEmployeeByCmsConstructionDiary(@PathVariable Integer id) {
		List<CmsDiaryTaskEmployeeDTO> dto = diaryTaskEmployeeService.findEmployeeByCmsConstructionDiary(id);
		if (dto == null) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<CmsDiaryTaskEmployeeDTO>>(dto, HttpStatus.OK);
	}

	@GetMapping("/search")
	private ResponseEntity<List<CmsDiaryDTO>> findAllCmsConstructionDiaryDTOFromConstructionId(
			@RequestParam Optional<Integer> constructionid, @RequestParam Optional<Integer> diaryid) {
		return new ResponseEntity<List<CmsDiaryDTO>>(
				contructionDiaryService.findAllCmsConstructionDiaryDTOFromConstructionId(constructionid, diaryid),
				HttpStatus.OK);
	}

	// id = 1 thì lấy theo ngày mới nhất.
	// id = 2 thì lấy theo trạng thái chưa duyệt
	// id = 3 thì lấy theo ngược lại cái id = 2
	@GetMapping("")
	private ResponseEntity<List<CmsDiaryDTO>> listCmsDiaryDTOByParam(@RequestParam() Optional<Integer> id,
			@RequestParam Optional<Integer> constructionsiteid, @RequestParam Optional<Integer> diaryid) {
		return new ResponseEntity<List<CmsDiaryDTO>>(
				contructionDiaryService.findAllCmsConstructionDiaryByDate(id, constructionsiteid, diaryid),
				HttpStatus.OK);
	}

	@PostMapping("/approve")
	private ResponseEntity<String> Approve(@RequestBody ApproveDTO dto) {
		return new ResponseEntity<String>(contructionDiaryService.approveDiary(dto), HttpStatus.OK);
	}

}
