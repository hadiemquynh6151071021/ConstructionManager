package com.construction.cmsfresher.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.construction.cmsfresher.model.CmsDiaryTaskProduct;

public interface IDiaryTaskProductRepository extends JpaRepository<CmsDiaryTaskProduct, Integer>{
	@Query("select d from CmsDiaryTaskProduct d where d.cmsConstructionDiary.diaryid = ?1")
	public List<CmsDiaryTaskProduct> findProductByCmsConstructionDiary(Integer id);
}
