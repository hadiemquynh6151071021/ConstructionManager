package com.construction.cmsfresher.service;

import java.util.Optional;

import com.construction.cmsfresher.dto.response.cmsdiarydto.CmsProgressDTO;
import com.construction.cmsfresher.model.CmsProgress;

public interface IProgressService extends DaoService<CmsProgressDTO, Integer>,MapperConverter<CmsProgressDTO, CmsProgress> {
	public CmsProgressDTO getProgressByPlanTaskOrDiary(Optional<Integer> plantaskid, Optional<Integer> diaryid);

}
