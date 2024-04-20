package com.construction.cmsfresher.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.construction.cmsfresher.dto.request.cmsplanhistorydto.CmsPlanHistoryDTO;
import com.construction.cmsfresher.model.CmsPlan;
import com.construction.cmsfresher.model.CmsPlanHistory;
import com.construction.cmsfresher.repository.IPlanHistoryRepository;
import com.construction.cmsfresher.repository.IPlanRepository;
import com.construction.cmsfresher.service.IPlanHistoryService;

@Service
public class PlanHistoryServiceImpl implements IPlanHistoryService {

	@Autowired
	IPlanHistoryRepository planHistoryRepository;

	@Autowired
	IPlanRepository planServiceImpl;

	@Autowired
	ModelMapper mapper;

	public CmsPlanHistoryDTO convertEntityToDto(CmsPlanHistory entity) {
		// TODO Auto-generated method stub
		CmsPlanHistoryDTO cmsPlanHistoryDTO = new CmsPlanHistoryDTO();
		cmsPlanHistoryDTO = mapper.map(entity, CmsPlanHistoryDTO.class);
		return cmsPlanHistoryDTO;
	}

	public  CmsPlanHistory convertDtoToEntity(CmsPlanHistoryDTO dto) {
		// TODO Auto-generated method stub
		CmsPlanHistory cmsPlanHistory = new CmsPlanHistory();
		cmsPlanHistory = mapper.map(dto, CmsPlanHistory.class);
		return cmsPlanHistory;
	}

	@Override
	public CmsPlanHistory saveCmsPlanHistory(CmsPlan cmsPlan) {
//		MdEmployee employee = employeeServiceImpl.findByIdMdEmployee(cmsPlanHistoryDTO.getMdEmployee());
//		CmsPlanAction planAction = planActionServiceImpl.findByIdCmsPlanAction(cmsPlanHistoryDTO.getCmsPlanAction());
//		CmsPlan cmsPlan = planServiceImpl.findByIdCmsPlan(cmsPlanHistoryDTO.getCmsPlan());
//		CmsPlanHistory cmsPlanHistory = this.convertDtoToEntity(cmsPlanHistoryDTO);
//		cmsPlanHistory.setCmsPlan(cmsPlan);
//		cmsPlanHistory.setMdEmployee(employee);
//		cmsPlanHistory.setCmsPlanAction(planAction);
//
//		cmsPlanHistory = planHistoryRepository.save(cmsPlanHistory);
//		
//
//		return cmsPlanHistory;

//		CmsPlanHistoryDTO cmsPlanHistoryDTO = new CmsPlanHistoryDTO();
//		if (planServiceImpl.findById(cmsPlan.getPlanid()) != null) {
//			cmsPlanHistoryDTO.setMdEmployee(cmsPlan.getMdEmployee().getEmployeeid());
//			cmsPlanHistoryDTO.setCmsPlan(cmsPlan.getPlanid());
//			LocalDateTime currentDateTime = LocalDateTime.now();
//			cmsPlanHistoryDTO.setActiontime(Timestamp.valueOf(currentDateTime));
//			CmsPlanHistory cmsPlanHistory = this.convertDtoToEntity(cmsPlanHistoryDTO);
//			return planHistoryRepository.save(cmsPlanHistory);
//		}
		return null;

	}

}
