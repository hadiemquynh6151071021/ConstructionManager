package com.construction.cmsfresher.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.construction.cmsfresher.model.MdCostEstimate;

public interface ICostEstimateRepository extends JpaRepository<MdCostEstimate, Integer> {

	@Query("Select new com.construction.cmsfresher.model.MdCostEstimate(u.costestimateid, u.costestimatecode, u.costestimatename) from MdCostEstimate u where u.mdConstructionSite.constructionsiteid = ?1 and u.status = 'Đã duyệt'")
	List<MdCostEstimate> findIdAndCodeAndNameByCostructionID(Integer idConstruction);
}
