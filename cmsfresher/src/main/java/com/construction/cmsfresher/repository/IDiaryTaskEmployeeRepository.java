package com.construction.cmsfresher.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.construction.cmsfresher.model.CmsDiaryTaskEmployee;

public interface IDiaryTaskEmployeeRepository extends JpaRepository<CmsDiaryTaskEmployee, Integer>{
	@Query("select d from CmsDiaryTaskEmployee d where d.cmsConstructionDiary.diaryid = ?1")
	public List<CmsDiaryTaskEmployee> findEmployeeByCmsConstructionDiary(Integer id);
}
