package com.construction.cmsfresher.service.impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.client.HttpServerErrorException;

import com.construction.cmsfresher.dto.request.cmsconstructiondiarydto.ApproveDTO;
import com.construction.cmsfresher.dto.request.cmsconstructiondiarydto.CmsConstructionDiaryDTO;
import com.construction.cmsfresher.dto.request.cmsconstructiondiarydto.LaborDTO;
import com.construction.cmsfresher.dto.request.cmsplansdto.ProductDTO;
import com.construction.cmsfresher.dto.response.cmsdiarydto.CmsDiaryDTO;
import com.construction.cmsfresher.model.CmsConstructionDiary;
import com.construction.cmsfresher.model.CmsDiaryAction;
import com.construction.cmsfresher.model.CmsDiaryHistory;
import com.construction.cmsfresher.model.CmsDiaryState;
import com.construction.cmsfresher.model.CmsDiaryTaskEmployee;
import com.construction.cmsfresher.model.CmsDiaryTaskProduct;
import com.construction.cmsfresher.model.CmsFile;
import com.construction.cmsfresher.model.CmsPlanTask;
import com.construction.cmsfresher.model.CmsProgress;
import com.construction.cmsfresher.model.MdEmployee;
import com.construction.cmsfresher.model.MdProduct;
import com.construction.cmsfresher.model.MdQuantityUnit;
import com.construction.cmsfresher.model.MdWeather;
import com.construction.cmsfresher.repository.IConstructionDiaryRepository;
import com.construction.cmsfresher.repository.IDiaryActionsRepository;
import com.construction.cmsfresher.repository.IDiaryHistoryRepository;
import com.construction.cmsfresher.repository.IDiaryStateRepository;
import com.construction.cmsfresher.repository.IDiaryTaskEmployeeRepository;
import com.construction.cmsfresher.repository.IDiaryTaskProductRepository;
import com.construction.cmsfresher.repository.IEmployeeRepository;
import com.construction.cmsfresher.repository.IFileRepository;
import com.construction.cmsfresher.repository.ILogRepository;
import com.construction.cmsfresher.repository.IPlanTaskRepository;
import com.construction.cmsfresher.repository.IProductRepository;
import com.construction.cmsfresher.repository.IProgressRepository;
import com.construction.cmsfresher.repository.IQuantityUnitRepository;
import com.construction.cmsfresher.repository.IShiftRepository;
import com.construction.cmsfresher.repository.IWeatherRepository;
import com.construction.cmsfresher.security.userdetail.UserDetailImpl;
import com.construction.cmsfresher.service.IConstructionDiaryService;
import com.construction.cmsfresher.service.IEmployeeService;
import com.construction.cmsfresher.service.IUploadFileService;
import com.construction.cmsfresher.util.LogMongoError;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;

@Service
@EnableCaching
public class ConstructionDiaryImpl implements IConstructionDiaryService {

	private final Logger logger = LoggerFactory.getLogger(ConstructionDiaryImpl.class);
	private final String name = "DCV";

	@Autowired
	ModelMapper mapper;
	@Autowired
	IEmployeeRepository employeeRepository;
	@Autowired
	IEmployeeService employeeServiceImpl;
	@Autowired
	IPlanTaskRepository planTaskRepository;
	@Autowired
	IWeatherRepository weatherRepository;
	@Autowired
	IQuantityUnitRepository quantityUnitRepository;
	@Autowired
	IConstructionDiaryRepository constructionDiaryRepository;
	@Autowired
	IDiaryActionsRepository diaryActionsRepository;
	@Autowired
	IDiaryHistoryRepository diaryHistoryRepository;
	@Autowired
	IDiaryStateRepository diaryStateRepository;
	@Autowired
	IProductRepository productRepository;
	@Autowired
	IDiaryTaskProductRepository diaryTaskProductRepository;
	@Autowired
	IDiaryTaskEmployeeRepository diaryTaskEmployeeRepository;

	@Autowired
	IUploadFileService fileService;

	@Autowired
	IFileRepository fileRepository;
	@Autowired
	IProgressRepository progressRepository;

	@Autowired
	IShiftRepository shiftRepository;
	@Autowired
	ILogRepository logRepository;

	@Autowired
	HttpSession session;

	@Autowired
	LogMongoError mongoError;

	@Override
	public CmsConstructionDiary save(CmsConstructionDiary entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CmsConstructionDiary findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CmsConstructionDiary> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public CmsConstructionDiary convertDtoToEntity(CmsConstructionDiaryDTO dto) {
		// TODO Auto-generated method stub
		CmsConstructionDiary cmsDiary = new CmsConstructionDiary();
		cmsDiary = mapper.map(dto, CmsConstructionDiary.class);
		return cmsDiary;
	}

	@Transactional(rollbackOn = { Exception.class })
	@CacheEvict(value = "diary", allEntries = true)
	public String saveDiary(CmsConstructionDiaryDTO dto) {
		try {
			// save diary
			CmsConstructionDiary constructionDiary = this.saveDiaries(dto);

			// Save history
			CmsDiaryHistory diaryHistory = this.saveCmsDiaryHistory(constructionDiary, 1, "Khởi tạo nhật ký mới");

			// Save product
			this.saveProduct(dto, constructionDiary);

			// Save labor
			this.saveLabor(dto, constructionDiary);

			// save file
			this.saveFile(constructionDiary, dto);
			return constructionDiary.getDiaryid() + " " + constructionDiary.getDiaryidcode();

		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage() + dto.getCreator() + new Date());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return null;
	}

	// Save labor
	@Transactional(rollbackOn = { Exception.class })
	public List<LaborDTO> saveLabor(CmsConstructionDiaryDTO dto, CmsConstructionDiary constructionDiary) {
		try {
			List<LaborDTO> laborDTOs = dto.getLabors();
			laborDTOs.forEach(i -> {
				CmsDiaryTaskEmployee cmsDiaryTaskEmployee = new CmsDiaryTaskEmployee();
				cmsDiaryTaskEmployee.setLaborsid(employeeRepository.findById(i.getLaborID()).orElse(null));
				cmsDiaryTaskEmployee.setCmsConstructionDiary(constructionDiary);
				cmsDiaryTaskEmployee.setMdShift(shiftRepository.findById(i.getShiftID()).orElse(null));
				diaryTaskEmployeeRepository.save(cmsDiaryTaskEmployee);
			});
			return laborDTOs;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage() + dto.getCreator() + new Date());
			UserDetailImpl account = (UserDetailImpl) session.getAttribute("user");
			mongoError.logLaborError(e.getMessage(), account.getId());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return null;
	}

	// Save product
	@Transactional(rollbackOn = { Exception.class })
	public List<ProductDTO> saveProduct(CmsConstructionDiaryDTO dto, CmsConstructionDiary constructionDiary) {
		try {
			List<ProductDTO> productDTOs = dto.getProducts();
			for (ProductDTO product : productDTOs) {
				CmsDiaryTaskProduct cmsDiaryTaskProduct = new CmsDiaryTaskProduct();
				MdProduct mdProduct = productRepository.findById(product.getProductId()).orElseGet(null);
				cmsDiaryTaskProduct.setCmsConstructionDiary(constructionDiary);
				cmsDiaryTaskProduct.setConsumptionamount(product.getConsumptionAmount());
				cmsDiaryTaskProduct.setMdProduct(mdProduct);
				diaryTaskProductRepository.save(cmsDiaryTaskProduct);
			}

		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage() + dto.getCreator() + new Date());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return null;
	}

	@Transactional(rollbackOn = { Exception.class })
	public CmsConstructionDiary saveDiaries(CmsConstructionDiaryDTO dto) {
		try {
			

			MdEmployee creator = employeeRepository.findById(dto.getCreator()).orElse(null);
			CmsPlanTask planTask = planTaskRepository.findById(dto.getCmsPlanTask()).orElse(null);
			MdWeather weather = weatherRepository.findById(dto.getMdWeather()).orElse(null);
			MdQuantityUnit unit = quantityUnitRepository.findById(dto.getQuantityUnit()).orElse(null);
			CmsDiaryState state = diaryStateRepository.findById(1).orElse(null);
			CmsConstructionDiary constructionDiary = this.convertDtoToEntity(dto);
			constructionDiary.setMdEmployee(creator);
			constructionDiary.setCmsPlanTask(planTask);
			constructionDiary.setMdWeather(weather);
			constructionDiary.setMdQuantityUnit(unit);
			constructionDiary.setCmsDiaryState(state);
			constructionDiary.setCreatedtime(Timestamp.valueOf(LocalDateTime.now()));
			constructionDiary.setDateofdiary(dto.getDateOfDiary());
			constructionDiary.setIslast(true);
			constructionDiary.setAmountofworkdone(dto.getAmountOfWork());
			constructionDiary = constructionDiaryRepository.save(constructionDiary);
			constructionDiaryRepository.createDiaryCode(constructionDiary.getDiaryid());
			return constructionDiary;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage() + dto.getCreator() + new Date());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return null;
	}

	// save file
	@Transactional(rollbackOn = { Exception.class })
	public boolean saveFile(CmsConstructionDiary constructionDiary, CmsConstructionDiaryDTO dto) {
		try {
			String[] pictures = dto.getPictures();
			String[] picturesProblem = dto.getPicturesProblem();

			for (String string : pictures) {
				CmsFile cmsFile = new CmsFile();
				cmsFile.setCmsConstructionDiary(constructionDiary);
				cmsFile.setFilelink(string);
				cmsFile.setFiletype(1);
				cmsFile = fileRepository.save(cmsFile);

			}
			for (String string : picturesProblem) {
				CmsFile cmsFile = new CmsFile();
				cmsFile.setCmsConstructionDiary(constructionDiary);
				cmsFile.setFilelink(string);
				cmsFile.setFiletype(0);
				fileRepository.save(cmsFile);
			}
			return true;

		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage() + dto.getCreator() + new Date());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return false;
	}

	@Transactional(rollbackOn = { Exception.class })
	public CmsDiaryHistory saveCmsDiaryHistory(CmsConstructionDiary cmsConstructionDiary, Integer number,
			String description) {
		try {
			CmsDiaryHistory cmsDiaryHistory = new CmsDiaryHistory();
			CmsDiaryAction action = diaryActionsRepository.findById(number).orElse(null);

			cmsDiaryHistory.setMdEmployee(cmsConstructionDiary.getMdEmployee());
			cmsDiaryHistory.setCmsConstructionDiary(cmsConstructionDiary);
			cmsDiaryHistory.setCmsDiaryAction(action);
			cmsDiaryHistory.setActiontime(Timestamp.valueOf(LocalDateTime.now()));
			cmsDiaryHistory.setDecsription(description);
			cmsDiaryHistory = diaryHistoryRepository.save(cmsDiaryHistory);
			return cmsDiaryHistory;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage() + cmsConstructionDiary.getMdEmployee().getUserid() + new Date());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}

		return null;
	}

	@Transactional(rollbackOn = { Exception.class })
	public CmsProgress saveProgress(CmsConstructionDiary diary) {
		try {
			CmsProgress oldProgress = progressRepository
					.getProgressFromDiaryDESC(diary.getCmsPlanTask().getPlantaskid());
			CmsPlanTask cmsPlanTask = planTaskRepository.findById(diary.getCmsPlanTask().getPlantaskid()).orElse(null);
			CmsProgress progress = new CmsProgress();
			progress.setCmsConstructionDiary(diary);

			progress.setAmountofworkdone(diary.getAmountofworkdone().intValue());

			if (oldProgress == null) {
				progress.setTotalamountofworkdone(diary.getAmountofworkdone().intValue());
			} else {
				// nếu mà totalamountofwork của progress > amountofwork của plantask -> throw
				Integer number = diary.getAmountofworkdone().intValue() + oldProgress.getTotalamountofworkdone();
				if (number > cmsPlanTask.getAmountofwork()) {
					throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
				} else {
					progress.setTotalamountofworkdone(number);
				}
			}
			return progressRepository.save(progress);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage() + " " + diary.getMdEmployee().getEmployeeid() + " " + new Date());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return null;

	}

	// Lấy mã công trình hoặc mã nhật ký cho CmsDiaryDTO
	@Override
	public List<CmsDiaryDTO> findAllCmsConstructionDiaryDTOFromConstructionId(Optional<Integer> constructionsiteid,
			Optional<Integer> diaryid) {
		// TODO Auto-generated method stub

		if (constructionsiteid.isPresent()) {
			List<CmsConstructionDiary> list = constructionDiaryRepository
					.findAllCmsConstructionDiaryDTOFromConstructionId(constructionsiteid, null);
			List<CmsDiaryDTO> dtos = new ArrayList<>();
			list.forEach(i -> {
				dtos.add(this.convertEntityToDto(i));
			});
			return dtos;
		}

		List<CmsConstructionDiary> list = constructionDiaryRepository
				.findAllCmsConstructionDiaryDTOFromConstructionId(null, diaryid);
		List<CmsDiaryDTO> dtos = new ArrayList<>();
		list.forEach(i -> {
			dtos.add(this.convertEntityToDto(i));
		});
		return dtos;
	}

	@Override
	public CmsDiaryDTO convertEntityToDto(CmsConstructionDiary entity) {
		// TODO Auto-generated method stub
		CmsDiaryDTO dto = new CmsDiaryDTO();
		dto = mapper.map(entity, CmsDiaryDTO.class);
		return dto;
	}

	@Override
	public CmsConstructionDiary convertDtoToEntity(CmsDiaryDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	// id 1 = khởi tạo, 2 = đối chứng, 3 = duyệt, 4 = từ chối đối chứng, 5 = từ chối
	// duyệt
	@Override
	@Cacheable(value = "diary")
	public List<CmsDiaryDTO> findAllCmsConstructionDiaryByDate(Optional<Integer> id,
			Optional<Integer> constructionsiteid, Optional<Integer> diaryid) {

		System.out.println("vao db lay du lieu");
		if (constructionsiteid.isPresent() && id.isPresent()) {
			return this.findAllCmsConstructionDiaryByDate(constructionsiteid, id, null, null);
		} else if (id.isPresent()) {
			return this.findAllCmsConstructionDiaryByDate(null, null, id, null);
		} else {
			return this.findAllCmsConstructionDiaryByDate(null, null, null, diaryid);
		}
	}

	// lấy công trình có nhật ký chưa duyệt ( vd constructionid=1&id=1 )
	private List<CmsDiaryDTO> findAllCmsConstructionDiaryByDate(Optional<Integer> constructionid, Optional<Integer> id1,
			Optional<Integer> id2, Optional<Integer> diaryid) {
		List<CmsConstructionDiary> list = constructionDiaryRepository.findAllCmsConstructionDiaryByDate(constructionid,
				id1, id2, diaryid);
		List<CmsDiaryDTO> dtos = new ArrayList<>();
		list.forEach(i -> {
			dtos.add(this.convertEntityToDto(i));
		});
		return dtos;
	}

	@CacheEvict(value = "diary", allEntries = true)
	public String approveDiary(ApproveDTO dto) {
		CmsConstructionDiary diary = constructionDiaryRepository.findById(dto.getId()).orElse(null);
		if (diary != null) {
			diary.setCmsDiaryState(diaryStateRepository.findById(dto.getActionid()).orElse(null));
			constructionDiaryRepository.save(diary);
			if (dto.getActionid() == 3) {
				this.saveProgress(diary);
			}
		}
		// Save history
		this.saveCmsDiaryHistory(diary, dto.getActionid(), dto.getDescription());
		return diary.getDiaryid() + " " + diary.getDiaryidcode();
	}

}