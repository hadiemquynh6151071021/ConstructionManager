package com.construction.cmsfresher.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.construction.cmsfresher.model.CmsCostestimateTaskProduct;

public interface ICostEstimateTaskProductRepository extends JpaRepository<CmsCostestimateTaskProduct, Integer> {

	// popup task
	@Query(value = "select * from cms_costestimate_task_products as c where c.costestimatetaskid = ?1",nativeQuery = true)
	public List<CmsCostestimateTaskProduct> findAllCostestimateTaskProductFromEstimateTaskId(Integer id);

}
