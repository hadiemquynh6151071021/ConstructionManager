package com.construction.cmsfresher.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.construction.cmsfresher.model.CmsProgress;

public interface IProgressRepository extends JpaRepository<CmsProgress, Integer>{
	@Query(value = "select p.* from cms_progresses p, cms_construction_diaries cd\r\n"
			+ "where p.diaryid = cd.diaryid and cd.plantaskid = ?1 order by cd.diaryid DESC LIMIT 1", nativeQuery = true)
	public CmsProgress getProgressFromDiaryDESC(Integer id);
	
	@Query(value = "select p.* from cms_progresses p, cms_construction_diaries cd\r\n"
			+ "where p.diaryid = cd.diaryid and (cd.plantaskid = ?1 or p.diaryid = ?2) order by cd.diaryid DESC limit 1\r\n", nativeQuery = true)
	public CmsProgress getProgressByPlanTaskOrDiary(Optional<Integer> plantaskid, Optional<Integer> diaryid);
}
