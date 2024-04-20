package com.construction.cmsfresher.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.construction.cmsfresher.model.CmsPlanTaskProduct;

public interface IPlanTaskProductRepository extends JpaRepository<CmsPlanTaskProduct, Integer> {

	@Query(value = "select c from CmsPlanTaskProduct c where c.cmsPlanTask.plantaskid = ?1 ")
	public List<CmsPlanTaskProduct> findByCmsPlanTaskProductFromPlanTaskId(Integer id);
}
