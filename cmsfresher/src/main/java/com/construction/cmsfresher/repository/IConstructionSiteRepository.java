package com.construction.cmsfresher.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.construction.cmsfresher.model.MdConstructionSite;

public interface IConstructionSiteRepository extends JpaRepository<MdConstructionSite, Integer> {

	@Query(value = "select cs.* from md_construction_sites cs, md_cost_estimates ce, md_construction_states ct\r\n"
			+ "where ce.constructionsiteid = cs.constructionsiteid\r\n"
			+ "and cs.constructionstateid = ct.constructionstateid\r\n"
			+ "and ct.constructionstateid = 1 \r\n" + "and ce.status = 'Đã duyệt';\r\n"
			+ "", nativeQuery = true)
	public List<MdConstructionSite> findAllActiveConstructionsSite(Optional<Integer> id);

	

//	@Query(value = "select c from MdCostEstimate c where c.mdConstructionSite.mdConstructionState.constructionstatename = 'Đã duyệt' and c.status = 'Đã duyệt' ")

}
