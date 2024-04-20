package com.construction.cmsfresher.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.construction.cmsfresher.model.CmsCostestimateTask;




public interface ICostEstimateTaskRepository extends JpaRepository<CmsCostestimateTask, Integer>{
	
	@Query(value = "with re as (\r\n"
			+ "select cct.*, ta.taskid, ta.taskcode, ta.taskname, qu.quantityunitname,qu.quantityunitid, wt.workitemid, wt.workitemcode,wt.workitemname from cms_costestimate_tasks cct, md_tasks ta, md_quantity_units qu,\r\n"
			+ "	cms_costestimate_workitems ccw, md_work_items wt\r\n"
			+ "where cct.taskid = ta.taskid and qu.quantityunitid = ta.quantityunitid and cct.costestimateworkitemid = ccw.costestimateworkitemid\r\n"
			+ "and ccw.workitemid = wt.workitemid and ccw.costestimateid = ?1\r\n"
			+ ")\r\n"
			+ "\r\n"
			+ "select\r\n"
			+ "array_to_json(array_agg(re.*)) as tasks\r\n"
			+ "from re, cms_costestimate_workitems ccw,\r\n"
			+ "md_work_items wi\r\n"
			+ "where re.costestimateworkitemid = ccw.costestimateworkitemid\r\n"
			+ "and ccw.workitemid = wi.workitemid",nativeQuery = true)
	public String findAllByCostestimatetaskid (Integer id);
	
}
