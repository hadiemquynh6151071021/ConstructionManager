package com.construction.cmsfresher.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import com.construction.cmsfresher.dto.response.cmscostestimatetaskdto.CmsCostEstimateTaskDTO;
import com.construction.cmsfresher.dto.response.cmscostestimatetaskdto.CmsCostEstimateTaskDetailDTO;
import com.construction.cmsfresher.dto.response.cmscostestimatetaskdto.CmsCostEstimateTaskWorkitemDTO;
import com.construction.cmsfresher.model.CmsCostestimateTask;
import com.construction.cmsfresher.repository.ICostEstimateTaskRepository;
import com.construction.cmsfresher.service.ICostEstimateTaskService;
import com.construction.cmsfresher.service.MapperConverter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@EnableCaching
public class CostEstimateTaskImpl
		implements ICostEstimateTaskService, MapperConverter<CmsCostEstimateTaskDTO, CmsCostestimateTask> {

	@Autowired
	ICostEstimateTaskRepository costEstimateTaskRepository;

	@Autowired
	ModelMapper mapper;

	@Override
	public CmsCostEstimateTaskDTO save(CmsCostEstimateTaskDTO entity) {

		return null;
	}

	@Override
	public CmsCostEstimateTaskDTO findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CmsCostEstimateTaskDTO> findAll() {
		// TODO Auto-generated method stub
		List<CmsCostestimateTask> tasks = costEstimateTaskRepository.findAll();
		List<CmsCostEstimateTaskDTO> cmsCostEstimateTaskDTOs = new ArrayList<>();
		tasks.forEach(i -> {
			cmsCostEstimateTaskDTOs.add(this.convertEntityToDto(i));
		});
		return cmsCostEstimateTaskDTOs;
	}

	// Lấy tất cả hạng mục công việc dựa theo dự toán
	@Override
	@Cacheable(value = "costestimateplantask",key = "#id")
	public List<CmsCostEstimateTaskWorkitemDTO> findAllByCostestimatetaskid(Integer id) {
        
		String list = costEstimateTaskRepository.findAllByCostestimatetaskid(id);
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			Map<Integer, CmsCostEstimateTaskWorkitemDTO> map = new HashMap<>();
			List<CmsCostEstimateTaskDTO> dtos = Arrays
					.asList(objectMapper.readValue(list, CmsCostEstimateTaskDTO[].class));
			for (CmsCostEstimateTaskDTO taskDTO : dtos) {
				System.out.println(taskDTO.getWorkitemid());
				CmsCostEstimateTaskWorkitemDTO dto = map.getOrDefault(taskDTO.getWorkitemid(),
						new CmsCostEstimateTaskWorkitemDTO());

				dto.setWorkitemname(taskDTO.getWorkitemname());
				dto.setWorkitemid(taskDTO.getWorkitemid());
				dto.setWorkitem_code(taskDTO.getWorkitemcode());
				CmsCostEstimateTaskDetailDTO detailDTO = new CmsCostEstimateTaskDetailDTO();
				BeanUtils.copyProperties(taskDTO, detailDTO);
				List<CmsCostEstimateTaskDetailDTO> taskDTOs = dto.getTaskDTOs();
				if (taskDTOs == null) {
					taskDTOs = new ArrayList<>();
				}
				taskDTOs.add(detailDTO);
				dto.setTaskDTOs(taskDTOs);
				map.put(taskDTO.getWorkitemid(), dto);
			}
			return new ArrayList<>(map.values());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CmsCostEstimateTaskDTO convertEntityToDto(CmsCostestimateTask entity) {
		// TODO Auto-generated method stub
		CmsCostEstimateTaskDTO cmsCostEstimateTaskDTO = new CmsCostEstimateTaskDTO();
		cmsCostEstimateTaskDTO = mapper.map(entity, CmsCostEstimateTaskDTO.class);
		return cmsCostEstimateTaskDTO;
	}

	@Override
	public CmsCostestimateTask convertDtoToEntity(CmsCostEstimateTaskDTO dto) {
		// TODO Auto-generated method stub
		CmsCostestimateTask cmsCostestimateTask = new CmsCostestimateTask();
		cmsCostestimateTask = mapper.map(dto, CmsCostestimateTask.class);
		return cmsCostestimateTask;
	}

}
