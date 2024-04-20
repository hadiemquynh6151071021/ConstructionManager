package com.construction.cmsfresher.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.construction.cmsfresher.dto.response.cmsdiarydto.CmsProgressDTO;
import com.construction.cmsfresher.model.CmsProgress;
import com.construction.cmsfresher.repository.IProgressRepository;
import com.construction.cmsfresher.service.IProgressService;

@Service
public class ProgressServiceImpl implements IProgressService {
	@Autowired
	IProgressRepository progressRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public CmsProgressDTO getProgressByPlanTaskOrDiary(Optional<Integer> plantaskid, Optional<Integer> diaryid) {
		if (plantaskid.isPresent()) {
			return this.convertEntityToDto(progressRepository.getProgressByPlanTaskOrDiary(plantaskid, null)) != null
					? this.convertEntityToDto(progressRepository.getProgressByPlanTaskOrDiary(plantaskid, null))
					: null;
		}
		return this.convertEntityToDto(progressRepository.getProgressByPlanTaskOrDiary(null, diaryid)) != null
				? this.convertEntityToDto(progressRepository.getProgressByPlanTaskOrDiary(null, diaryid))
				: null;
	}

	@Override
	public CmsProgressDTO save(CmsProgressDTO entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CmsProgressDTO findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CmsProgressDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CmsProgressDTO convertEntityToDto(CmsProgress entity) {
		// TODO Auto-generated method stub
		CmsProgressDTO dto = new CmsProgressDTO();
		dto = modelMapper.map(entity, CmsProgressDTO.class);
		return dto;
	}

	@Override
	public CmsProgress convertDtoToEntity(CmsProgressDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
