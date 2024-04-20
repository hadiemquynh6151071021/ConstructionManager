package com.construction.cmsfresher.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.construction.cmsfresher.model.CmsPlanTaskLabor;

public interface IPlanTaskLaborRepository extends JpaRepository<CmsPlanTaskLabor, Integer>{
	@Query(value = "select c from CmsPlanTaskLabor c where c.cmsPlanTask.plantaskid = ?1 ")
	public List<CmsPlanTaskLabor> findByCmsCmsPlanTaskLaborFromCmsTaskId(Integer id);

}
