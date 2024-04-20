package com.construction.cmsfresher.service.impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import com.construction.cmsfresher.dto.request.cmsconstructiondiarydto.ApproveDTO;
import com.construction.cmsfresher.dto.request.cmsplansdto.CmsPlanWorkItemDTO;
import com.construction.cmsfresher.dto.request.cmsplansdto.CmsPlansDTO;
import com.construction.cmsfresher.dto.request.cmsplansdto.LaborDTO;
import com.construction.cmsfresher.dto.request.cmsplansdto.ProductDTO;
import com.construction.cmsfresher.dto.request.cmsplansdto.TaskDTO;
import com.construction.cmsfresher.dto.response.cmsplandto.CmsPlanDTO;
import com.construction.cmsfresher.dto.response.cmsplandto.CmsPlanJsonDTO;
import com.construction.cmsfresher.dto.response.cmsplandto.CmsPlanJsonDetailDTO;
import com.construction.cmsfresher.dto.response.cmsplanworkitemdto.CmsPlanWorkItemPlanTaskDTO;
import com.construction.cmsfresher.model.CmsPlan;
import com.construction.cmsfresher.model.CmsPlanAction;
import com.construction.cmsfresher.model.CmsPlanHistory;
import com.construction.cmsfresher.model.CmsPlanState;
import com.construction.cmsfresher.model.CmsPlanTask;
import com.construction.cmsfresher.model.CmsPlanTaskLabor;
import com.construction.cmsfresher.model.CmsPlanTaskProduct;
import com.construction.cmsfresher.model.CmsPlanWorkitem;
import com.construction.cmsfresher.model.CmsRoleEmployeesPlanworkitem;
import com.construction.cmsfresher.model.MdConstructionSite;
import com.construction.cmsfresher.model.MdEmployee;
import com.construction.cmsfresher.model.MdProduct;
import com.construction.cmsfresher.model.MdQuantityUnit;
import com.construction.cmsfresher.model.MdRole;
import com.construction.cmsfresher.model.MdTask;
import com.construction.cmsfresher.model.MdWorkItem;
import com.construction.cmsfresher.repository.ICostEstimateRepository;
import com.construction.cmsfresher.repository.IEmployeeRepository;
import com.construction.cmsfresher.repository.IPlanActionsRepository;
import com.construction.cmsfresher.repository.IPlanHistoryRepository;
import com.construction.cmsfresher.repository.IPlanRepository;
import com.construction.cmsfresher.repository.IPlanTaskLaborRepository;
import com.construction.cmsfresher.repository.IPlanTaskProductRepository;
import com.construction.cmsfresher.repository.IPlanTaskRepository;
import com.construction.cmsfresher.repository.IPlanWorkItemRepository;
import com.construction.cmsfresher.repository.IProductRepository;
import com.construction.cmsfresher.repository.IQuantityUnitRepository;
import com.construction.cmsfresher.repository.IRoleEmployeePlanWorkItemRepository;
import com.construction.cmsfresher.repository.IRoleRepository;
import com.construction.cmsfresher.repository.ITaskRepository;
import com.construction.cmsfresher.repository.IWorkItemRepository;
import com.construction.cmsfresher.service.IConstructionSiteService;
import com.construction.cmsfresher.service.IEmployeeService;
import com.construction.cmsfresher.service.IPlanHistoryService;
import com.construction.cmsfresher.service.IPlanSerivce;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.transaction.Transactional;

@Service
@EnableCaching
public class PlanServiceImpl implements IPlanSerivce {

	private final String name = "PL";
	private int count = 1;

	ModelMapper mapper;

	IPlanRepository planRepository;

	IPlanHistoryRepository historyRepository;

	IConstructionSiteService constructionSiteServiceImpl;

	IEmployeeService employeeServiceImpl;

	PlanStateServiceImpl planStateServiceImpl;

	IPlanHistoryService historyServiceImpl;

	IPlanActionsRepository planActionsRepository;

	IWorkItemRepository workItemRepository;

	IPlanWorkItemRepository planWorkItemRepository;

	IEmployeeRepository employeeRepository;

	IRoleRepository roleRepository;

	IRoleEmployeePlanWorkItemRepository roleEmployeePlanWorkItemRepository;

	ITaskRepository taskRepository;

	ICostEstimateRepository costEstimateRepository;

	IPlanTaskRepository planTaskRepository;

	IQuantityUnitRepository quantityUnitRepository;

	IProductRepository productRepository;

	IPlanTaskProductRepository planTaskProductRepository;

	IPlanTaskLaborRepository planTaskLaborRepository;

	@Autowired
	public PlanServiceImpl(ModelMapper mapper, IPlanRepository planRepository, IPlanHistoryRepository historyRepository,
			IConstructionSiteService constructionSiteServiceImpl, IEmployeeService employeeServiceImpl,
			PlanStateServiceImpl planStateServiceImpl, IPlanHistoryService historyServiceImpl,
			IPlanActionsRepository planActionsRepository, IWorkItemRepository workItemRepository,
			IPlanWorkItemRepository planWorkItemRepository, IEmployeeRepository employeeRepository,
			IRoleRepository roleRepository, IRoleEmployeePlanWorkItemRepository roleEmployeePlanWorkItemRepository,
			ITaskRepository taskRepository, ICostEstimateRepository costEstimateRepository,
			IPlanTaskRepository planTaskRepository, IQuantityUnitRepository quantityUnitRepository,
			IProductRepository productRepository, IPlanTaskProductRepository planTaskProductRepository,
			IPlanTaskLaborRepository planTaskLaborRepository) {
		this.mapper = mapper;
		this.planRepository = planRepository;
		this.historyRepository = historyRepository;
		this.constructionSiteServiceImpl = constructionSiteServiceImpl;
		this.employeeServiceImpl = employeeServiceImpl;
		this.planStateServiceImpl = planStateServiceImpl;
		this.historyServiceImpl = historyServiceImpl;
		this.planActionsRepository = planActionsRepository;
		this.workItemRepository = workItemRepository;
		this.planWorkItemRepository = planWorkItemRepository;
		this.employeeRepository = employeeRepository;
		this.roleRepository = roleRepository;
		this.roleEmployeePlanWorkItemRepository = roleEmployeePlanWorkItemRepository;
		this.taskRepository = taskRepository;
		this.costEstimateRepository = costEstimateRepository;
		this.planTaskRepository = planTaskRepository;
		this.quantityUnitRepository = quantityUnitRepository;
		this.productRepository = productRepository;
		this.planTaskProductRepository = planTaskProductRepository;
		this.planTaskLaborRepository = planTaskLaborRepository;
	}

	@Override
	public CmsPlanDTO convertEntityToDto(CmsPlan entity) {
		// TODO Auto-generated method stub
		CmsPlanDTO cmsPlansDTO = new CmsPlanDTO();
		cmsPlansDTO = mapper.map(entity, CmsPlanDTO.class);
		return cmsPlansDTO;
	}

	@Override
	public CmsPlan convertDtoToEntity(CmsPlanDTO dto) {
		// TODO Auto-generated method stub
		CmsPlan cmsPlan = new CmsPlan();
		cmsPlan = mapper.map(dto, CmsPlan.class);
		return cmsPlan;
	}

	@Override
	public CmsPlanDTO save(CmsPlanDTO entity) {
		return null;
	}

	@Override
	public CmsPlanDTO findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CmsPlanDTO> findAll() {
		// TODO Auto-generated method stub
		List<CmsPlan> list = planRepository.findAll();
		List<CmsPlanDTO> dtos = new ArrayList<>();
		list.forEach(i -> {
			dtos.add(this.convertEntityToDto(i));
		});
		return dtos;
	}

	// convert CmsPlan sang CmsPlansDTO package request
	public CmsPlansDTO convertEntityToCmsPlansDTO(CmsPlan entity) {
		// TODO Auto-generated method stub
		CmsPlansDTO cmsPlansDTO = new CmsPlansDTO();
		cmsPlansDTO = mapper.map(entity, CmsPlansDTO.class);
		return cmsPlansDTO;
	}

	// convert CmsPlansDTO sang CmsPlan
	public CmsPlan convertDtoToEntity(CmsPlansDTO dto) {
		// TODO Auto-generated method stub
		CmsPlan cmsPlan = new CmsPlan();
		cmsPlan = mapper.map(dto, CmsPlan.class);
		return cmsPlan;
	}

	@Transactional
	@CacheEvict(value = "plans", allEntries = true)
	public String savePlans(CmsPlansDTO dto) {

		MdEmployee creator = employeeServiceImpl.findByIdMdEmployee(dto.getMdEmployee());
		MdConstructionSite constructionSite = constructionSiteServiceImpl
				.findByIdMdConstructionSite(dto.getMdConstructionSite());
		CmsPlanState planState = planStateServiceImpl.findByIdPlanState(1);

		CmsPlan cmsPlan = this.convertDtoToEntity(dto);
		cmsPlan.setMdEmployee(creator);
		cmsPlan.setMdConstructionSite(constructionSite);
		cmsPlan.setCmsPlanState(planState);
		cmsPlan.setCreateddate(new Date());
		cmsPlan.setIslast(true);
		// -------------------------

		// Save approver
		MdEmployee approver = employeeServiceImpl.findByIdMdEmployee(dto.getApprovers().get(0));
		List<MdEmployee> employees = new ArrayList<>();
		employees.add(approver);
		cmsPlan.setMdEmployees(employees);
		// Save plan
		cmsPlan = planRepository.save(cmsPlan);
		planRepository.createPlan(cmsPlan.getPlanid());

		// Save plan history
		this.saveCmsPlanHistory(cmsPlan);

		// Save plan workitem & supervisors
		MdRole mdRole = roleRepository.findById(1).orElse(null);
		List<CmsPlanWorkItemDTO> itemDTOs = dto.getListPlanWorkItem();
		for (CmsPlanWorkItemDTO cmsPlanWorkItemDTO : itemDTOs) {
			MdWorkItem mdWorkItem = workItemRepository.findById(cmsPlanWorkItemDTO.getWorkItemId()).orElse(null);
			CmsPlanWorkitem cmsPlanWorkitem = new CmsPlanWorkitem();
			cmsPlanWorkitem.setCmsPlan(cmsPlan);
			cmsPlanWorkitem.setMdWorkItem(mdWorkItem);
			cmsPlanWorkitem.setOrderindex(cmsPlanWorkItemDTO.getOrderIndex());
			planWorkItemRepository.save(cmsPlanWorkitem);
			// supervisors
			MdEmployee mdEmployee = employeeRepository.findById(cmsPlanWorkItemDTO.getEmployeeId()).orElse(null);
			CmsRoleEmployeesPlanworkitem cmsRoleEmployeesPlanworkitem = new CmsRoleEmployeesPlanworkitem();
			cmsRoleEmployeesPlanworkitem.setMdRole(mdRole);
			cmsRoleEmployeesPlanworkitem.setCmsPlanWorkitem(cmsPlanWorkitem);
			cmsRoleEmployeesPlanworkitem.setMdEmployee(mdEmployee);
			roleEmployeePlanWorkItemRepository.save(cmsRoleEmployeesPlanworkitem);
			// task
			List<TaskDTO> taskDTOs = cmsPlanWorkItemDTO.getTasks();
			for (TaskDTO task : taskDTOs) {
				CmsPlanTask cmsPlanTask = new CmsPlanTask();
				cmsPlanTask.setAmountofwork(task.getAmountOfWork());
				cmsPlanTask.setOrderindex(task.getOrderIndex());
				cmsPlanTask.setCmsPlan(cmsPlan);
				cmsPlanTask.setMdWorkItem(mdWorkItem);
				cmsPlanTask.setTotallaborquantity(task.getLabors().size());
				cmsPlanTask.setStartdate(task.getStartdate());
				cmsPlanTask.setEnddate(task.getEnddate());
				MdTask mdTask = taskRepository.findById(task.getTaskId()).orElse(null);
				cmsPlanTask.setMdTask(mdTask);
				cmsPlanTask.setMdCostEstimate(costEstimateRepository.findById(task.getCostEstimateId()).orElse(null));
				cmsPlanTask.setMdQuantityUnit(quantityUnitRepository.findById(task.getQuantityUnitId()).orElse(null));
				planTaskRepository.save(cmsPlanTask);
				// product
				List<ProductDTO> productDTOs = task.getProducts();
				for (ProductDTO product : productDTOs) {
					CmsPlanTaskProduct cmsPlanTaskProduct = new CmsPlanTaskProduct();
					MdProduct mdProduct = productRepository.findById(product.getProductId()).orElseGet(null);
					cmsPlanTaskProduct.setCmsPlanTask(cmsPlanTask);
					cmsPlanTaskProduct.setConsumptionamount(product.getConsumptionAmount());
					cmsPlanTaskProduct.setMdProduct(mdProduct);
					MdQuantityUnit mdQuantityUnit = quantityUnitRepository.findById(product.getQuantityUnit())
							.orElse(null);
					cmsPlanTaskProduct.setQuantityunit(mdQuantityUnit.getQuantityunitname());
					planTaskProductRepository.save(cmsPlanTaskProduct);
				}
				// labor
				List<LaborDTO> laborDTOs = task.getLabors();
				laborDTOs.forEach(i -> {
					CmsPlanTaskLabor cmsPlanTaskLabor = new CmsPlanTaskLabor();
					MdEmployee labor = employeeServiceImpl.findByIdMdEmployee(i.getLaborID());
					cmsPlanTaskLabor.setMdEmployee(labor);
					cmsPlanTaskLabor.setCmsPlanTask(cmsPlanTask);
					planTaskLaborRepository.save(cmsPlanTaskLabor);
				});

			}
		}
		return cmsPlan.getPlanid() + " " + cmsPlan.getPlanidcode();
	}

	public CmsPlanHistory saveCmsPlanHistory(CmsPlan cmsPlan) {
		CmsPlanHistory cmsPlanHistory = new CmsPlanHistory();
		CmsPlanAction action = planActionsRepository.findById(1).orElse(null);

		cmsPlanHistory.setMdEmployee(cmsPlan.getMdEmployee());
		cmsPlanHistory.setCmsPlan(cmsPlan);
		cmsPlanHistory.setCmsPlanAction(action);
		LocalDateTime currentDateTime = LocalDateTime.now();
		cmsPlanHistory.setActiontime(Timestamp.valueOf(currentDateTime));
		return historyRepository.save(cmsPlanHistory);

	}

//	public CmsPlanWorkitem saveCmsPlanWorkitem(CmsPlan cmsPlan){
//		CmsPlanWorkitem cmsPlanWorkitem = new CmsPlanWorkitem();
//		CmsPlan plan = planRepository.findById(cmsPlan.getPlanid()).orElse(null);
//		MdWorkItem workItem = workItemRepository.findById()
//	}

	@Override
	public CmsPlan findByIdCmsPlan(Integer id) {
		CmsPlan cmsPlan = planRepository.findById(id).orElse(null);
		return cmsPlan;
	}

	// id 1 = Khởi tạo, 2 = Duyệt, 3 = Từ chối
	@Override
	@Cacheable(value = "plans")
	public List<CmsPlanDTO> findAllCmsPlanOrderByState(Optional<Integer> id, Optional<Integer> constructionsiteid,
			Optional<Integer> planid) {
		if (id.isPresent() && constructionsiteid.isPresent()) {
			return this.findAllCmsPlanOrderByStates(id, constructionsiteid, null, null);
		} else if (id.isPresent()) {
			return this.findAllCmsPlanOrderByStates(null, null, id, null);

		} else {
			return this.findAllCmsPlanOrderByStates(null, null, null, planid);

		}
	}

	private List<CmsPlanDTO> findAllCmsPlanOrderByStates(Optional<Integer> id, Optional<Integer> constructionsiteid,
			Optional<Integer> id2, Optional<Integer> planid) {
		List<CmsPlan> list = planRepository.findAllCmsPlanOrderByState(id, constructionsiteid, id2, planid);
		List<CmsPlanDTO> dtos = new ArrayList<>();
		list.forEach(i -> {
			dtos.add(this.convertEntityToDto(i));
		});
		return dtos;
	}

	// Lấy danh sách thông tin công việc dựa vào mã plan
	@Override
	@Cacheable(value = "plans", key = "#id")
	public List<CmsPlanWorkItemPlanTaskDTO> findAllPlanTaskByPlanId(Integer id) {
		// TODO Auto-generated method stub
		String json = planRepository.findAllPlanTaskByPlanId(id);
		Map<Integer, CmsPlanWorkItemPlanTaskDTO> map = new HashMap<>();
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			List<CmsPlanJsonDTO> jsonDTOs = Arrays.asList(objectMapper.readValue(json, CmsPlanJsonDTO[].class));

			for (CmsPlanJsonDTO cmsPlanJsonDTO : jsonDTOs) {
				CmsPlanWorkItemPlanTaskDTO planWorkItemPlanTaskDTO = map.getOrDefault(cmsPlanJsonDTO.getWorkitemid(),
						new CmsPlanWorkItemPlanTaskDTO());
				planWorkItemPlanTaskDTO.setOrderindex(cmsPlanJsonDTO.getOrderindexofworkitem());
				planWorkItemPlanTaskDTO.setWorkitemid(cmsPlanJsonDTO.getWorkitemid());
				planWorkItemPlanTaskDTO.setWorkitemCode(cmsPlanJsonDTO.getWorkitemcode());
				planWorkItemPlanTaskDTO.setWorkitemname(cmsPlanJsonDTO.getWorkitemname());
				planWorkItemPlanTaskDTO.setEmployeeid(cmsPlanJsonDTO.getEmployeeid());
				planWorkItemPlanTaskDTO.setFirstname(cmsPlanJsonDTO.getFirstname());
				planWorkItemPlanTaskDTO.setLastname(cmsPlanJsonDTO.getLastname());
				planWorkItemPlanTaskDTO.setUserid(cmsPlanJsonDTO.getUserid());
				planWorkItemPlanTaskDTO.setIdcard(cmsPlanJsonDTO.getIdcard());
				CmsPlanJsonDetailDTO cmsPlanJsonDetailDTO = new CmsPlanJsonDetailDTO();

				BeanUtils.copyProperties(cmsPlanJsonDTO, cmsPlanJsonDetailDTO);
				List<CmsPlanJsonDetailDTO> detailDTOs = planWorkItemPlanTaskDTO.getMdTasks();

				if (detailDTOs == null) {
					detailDTOs = new ArrayList<>();
				}
				detailDTOs.add(cmsPlanJsonDetailDTO);
				planWorkItemPlanTaskDTO.setMdTasks(detailDTOs);
				map.put(cmsPlanJsonDTO.getWorkitemid(), planWorkItemPlanTaskDTO);

			}
			return new ArrayList<>(map.values());

		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@CacheEvict(value = "plans", allEntries = true)
	public String approveDiary(ApproveDTO dto) {
		CmsPlan plan = planRepository.findById(dto.getId()).orElse(null);
		if (plan != null) {
			plan.setCmsPlanState(planStateServiceImpl.findByIdPlanState(dto.getActionid()));
			planRepository.save(plan);
		}
		// Save history
		this.saveCmsPlanHistory(plan);
		return plan.getPlanid() + " " + plan.getPlanidcode();
	}

	@Override
	public String countPlanTaskDone(Integer id) {
		int count = planRepository.countPlanTaskDone(id);
		return String.valueOf(count);
	}

}
