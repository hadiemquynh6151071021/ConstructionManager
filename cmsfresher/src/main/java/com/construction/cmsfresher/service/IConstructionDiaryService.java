package com.construction.cmsfresher.service;

import java.util.List;
import java.util.Optional;

import com.construction.cmsfresher.dto.request.cmsconstructiondiarydto.ApproveDTO;
import com.construction.cmsfresher.dto.request.cmsconstructiondiarydto.CmsConstructionDiaryDTO;
import com.construction.cmsfresher.dto.response.cmsdiarydto.CmsDiaryDTO;
import com.construction.cmsfresher.model.CmsConstructionDiary;

public interface IConstructionDiaryService
		extends DaoService<CmsConstructionDiary, Integer>, MapperConverter<CmsDiaryDTO, CmsConstructionDiary> {
	public String saveDiary(CmsConstructionDiaryDTO dto);

	public List<CmsDiaryDTO> findAllCmsConstructionDiaryDTOFromConstructionId(Optional<Integer> constructionsiteid,
			Optional<Integer> diaryid);

	public List<CmsDiaryDTO> findAllCmsConstructionDiaryByDate(Optional<Integer> id,
			Optional<Integer> constructionsiteid, Optional<Integer> diaryid);

	public String approveDiary(ApproveDTO dto);

}
